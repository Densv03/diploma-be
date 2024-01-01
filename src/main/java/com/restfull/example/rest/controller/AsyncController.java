package com.restfull.example.rest.controller;

import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.concurrent.CompletableFuture;

@RequestMapping("/async")
@RestController
public class AsyncController {

    @Async
    @GetMapping("/example")
    public CompletableFuture<String> asyncEndpoint() {
        // Ваш асинхронный код
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(10000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "Результат вашей асинхронной операции";
        });
    }
}
