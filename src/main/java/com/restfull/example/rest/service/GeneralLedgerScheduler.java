package com.restfull.example.rest.service;

import com.restfull.example.rest.entety.PushEntity;
import com.restfull.example.rest.entety.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class GeneralLedgerScheduler {

    @Autowired
    private EmailSenderService emailSenderService ;

    @Autowired
    private PushEmailService pushEmailService;

    @Autowired UserService userService;

    @Scheduled(fixedRate = 1000*30) //per 30 seconds
    public void start() {
        System.out.println("Email sending");
        final List<PushEntity> entityList = pushEmailService.getNotSendMails();
        for (int i = 0; i < entityList.size(); i++) {
            final PushEntity pushEntity = entityList.get(i);
            final Boolean usingPlaceHolder = pushEntity.getUsingPlaceHolder();
            final String template = pushEntity.getTemplate();
            final UserEntity fromEmail = userService.getUserEmailById(pushEntity.getUserId());
            if (usingPlaceHolder){
                final String replaced = replaceTextBetweenBraces(template, pushEntity.getEmail());
                emailSenderService.sendSimpleEmail(pushEntity.getEmail(), fromEmail.getEmail(), pushEntity.getTitle(), replaced);
                pushEmailService.updateSend(pushEntity);
            }else {
                emailSenderService.sendSimpleEmail(pushEntity.getEmail(), fromEmail.getEmail(), pushEntity.getTitle(), pushEntity.getTemplate());
                pushEmailService.updateSend(pushEntity);
            }
        }
    }

    private static String replaceTextBetweenBraces(String template, String from) {
        String regex = "\\{.*?\\}"; // Регулярное выражение для поиска текста в фигурных скобках
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(template);

        // Заменяем найденные подстроки на replacement
        StringBuffer result = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(result, from);
        }
        matcher.appendTail(result);

        return result.toString();
    }




}
