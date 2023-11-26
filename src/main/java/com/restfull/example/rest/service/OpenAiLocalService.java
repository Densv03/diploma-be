package com.restfull.example.rest.service;

import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.completion.CompletionResult;
import com.theokanning.openai.completion.chat.ChatCompletionRequest;
import com.theokanning.openai.completion.chat.ChatCompletionResult;
import com.theokanning.openai.completion.chat.ChatMessage;
import com.theokanning.openai.service.OpenAiService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OpenAiLocalService {

    private final OpenAiService openAiService;

//
//    public ChatCompletionResult chatCompletion(final String message) {
//        //model name;
//        return chatCompletion(message, OpenAiConstant.Model.DEFAULT_CHAT_COMPLETION);
//    }
//
//    public ChatCompletionResult chatCompletion(final String message, final String model) {
//        ChatCompletionRequest chatCompletionRequest = ChatCompletionRequest.builder().model(model)
//                .messages(Collections.singletonList(new ChatMessage(OpenAiConstant.Role.SYSTEM, message))).build();
//        return openAiService.createChatCompletion(chatCompletionRequest);
//    }
//
//    public CompletionResult completion(final String prompt) {
//        return completion(prompt, OpenAiConstant.Model.DEFAULT_COMPLETION);
//    }
//
//    public CompletionResult completion(final String prompt, final String model) {
//        CompletionRequest completionRequest = CompletionRequest.builder().model(model).maxTokens(1).logprobs(2)
//                .temperature(0.0).prompt(prompt).build();
//        return openAiService.createCompletion(completionRequest);
//    }

    public ChatCompletionResult chatCompletion(final List<ChatMessage> chatMessages) {
        return chatCompletion(chatMessages, "gpt-4", 1d);
    }

    public ChatCompletionResult chatCompletion(final List<ChatMessage> chatMessages, final String model,
                                               final Double temperature) {
        ChatCompletionRequest completionRequest = ChatCompletionRequest.builder().model(model).messages(chatMessages)
                .temperature(temperature).build();
        return openAiService.createChatCompletion(completionRequest);
    }
}
