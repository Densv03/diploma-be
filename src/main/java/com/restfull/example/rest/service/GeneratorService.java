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

@Service
@AllArgsConstructor
public class GeneratorService {

    private OpenAiLocalService openAiLocalService;




    public String generateTemplate(GenerateLetterRequest request){
        List<ChatMessage> messages = new ArrayList<>();
        final GenerateMailDescriptionRequest mailDescriptionRequest = request.getGenerateMailDescriptionRequest();
        final MailConfigurationRequest config = request.getMailConfigurationRequest();
        var firstInstruction =new ChatMessage(OpenAiConstant.Role.SYSTEM, "You will help me generate messages. I will give you behavior, describe tasks and enter data through the API. I need you to generate an email. Only when I say “start” will you generate, but for now listen carefully. I will give you the “header” of the email and describe the “body” of the email. the “body” will describe the very idea of the message and may contain instructions, so treat the “body” carefully");
        messages.add(firstInstruction);
        var secondInstruction = new ChatMessage(OpenAiConstant.Role.USER, String.format("\"title\": %s, \"body\": %s", mailDescriptionRequest.getTitle(), mailDescriptionRequest.getBody()));
        messages.add(secondInstruction);
        var third =new ChatMessage(OpenAiConstant.Role.SYSTEM, "I will continue to give you instructions on how to generate an email. I will now describe the variables that I will keep in mind later. \"usingPlaceHolder\" - if the variable is equal to True, then when you write an appeal to some person, you use a placenoder like {Holder} so that I can then replace it. If \"usingPlaceHolder\" is False, then you are trying to generate text without referring to anyone in particular. \"sentenceCount\" - a variable storing the number of sentences that need to be generated for the email.\n" + "\"fromName\" - a variable storing the value on behalf of whom the message is generated. Used to generate email.\n" + "\"style\" - a variable indicating the style of the message (scientific, business, official, artistic, etc.).");
        messages.add(third);
        String template = """
        "usingPlaceHolder" : %s,
        "templateCount" : %s,
        "fromName" : %s,
        "style" : %s,
        "sentenceCount" : %s
        """;
        var fourth = new ChatMessage(OpenAiConstant.Role.USER,
                String.format(template, config.getUsingPlaceHolder(), config.getTemplateCount(), config.getFrom(), config.getStyle().name(), config.getTemplateCount()));
        messages.add(fourth);
        final ChatCompletionResult chatCompletionResult = openAiLocalService.chatCompletion(messages);
        System.out.printf(chatCompletionResult.getChoices().get(0).getMessage().getContent());
        return chatCompletionResult.getChoices().get(0).getMessage().getContent();

    }

}
