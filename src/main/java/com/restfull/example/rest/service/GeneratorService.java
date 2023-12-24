package com.restfull.example.rest.service;

import com.restfull.example.rest.model.request.GenerateLetterRequest;
import com.restfull.example.rest.model.request.GenerateMailDescriptionRequest;
import com.restfull.example.rest.model.request.MailConfigurationRequest;
import com.restfull.example.rest.shared.dto.OpenAiConstant;
import com.theokanning.openai.completion.chat.ChatCompletionResult;
import com.theokanning.openai.completion.chat.ChatMessage;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class GeneratorService {

    private OpenAiLocalService openAiLocalService;

    private LabelService labelService;


    public String generateTemplate(UUID id, GenerateLetterRequest request) {
        List<ChatMessage> messages = new ArrayList<>();
        final GenerateMailDescriptionRequest mailDescriptionRequest = request.getGenerateMailDescriptionRequest();
        final MailConfigurationRequest config = request.getMailConfigurationRequest();
        List<String> generatedContents = new ArrayList<>();
        for (int i = 0; i < config.getTemplateCount(); i++) {
            var firstInstruction = new ChatMessage(OpenAiConstant.Role.SYSTEM, "You will help me generate messages. I will give you behavior, describe tasks and enter data through the API. I need you to generate an email's body. Only when I say “start” will you generate, but for now listen carefully. I will give you the “header” of the email and describe the “body” of the email. the “body” will describe the very idea of the message and may contain instructions, so treat the “body” carefully");
            messages.add(firstInstruction);
            var secondInstruction = new ChatMessage(OpenAiConstant.Role.USER, String.format("\"title\": %s, \"body\": %s", mailDescriptionRequest.getTitle(), mailDescriptionRequest.getBody()));
            messages.add(secondInstruction);
            var third = new ChatMessage(OpenAiConstant.Role.SYSTEM, "I will continue to give you instructions on how to generate an email. I will now describe the variables that I will keep in mind later. \"usingPlaceHolder\" - if the variable is equal to True, then when you write an appeal to some person, you use a placeholder {Holder} so that I can then replace it with name of receiver. If \"usingPlaceHolder\" is False, then you are trying to generate text without referring to anyone in particular. Use only placeholder for substitution of receiving emails (if \"usingPlaceHolder\" is true). \"sentenceCount\" - a variable storing the number of sentences that need to be generated for the email.\n" + "\"fromName\" - a variable storing the value on behalf of whom the message is generated. Used to generate email.\n" + "\"style\" - a variable indicating the style of the message (scientific, business, official, artistic, etc.).");
            messages.add(third);
            String template = """
                    "usingPlaceHolder" : %s,
                    "templateCount" : %s,
                    "fromName" : %s,
                    "style" : %s,
                    "sentenceCount" : %s
                    """;
            var fourth = new ChatMessage(OpenAiConstant.Role.USER, String.format(template, config.getUsingPlaceHolder(), config.getTemplateCount(), config.getFrom(), config.getStyle().name(), config.getTemplateCount()));
            messages.add(fourth);
            final ChatCompletionResult chatCompletionResult = openAiLocalService.chatCompletion(messages);
            final String content = chatCompletionResult.getChoices().get(0).getMessage().getContent();
            generatedContents.add(content);
        }
        saveGeneratedTemplate(id,request, generatedContents);

        return generatedContents.get(0);

    }

    private void saveGeneratedTemplate(UUID id, GenerateLetterRequest request, List<String> content) {
        labelService.saveGeneratedTemplates(id, request, content);
    }

}
