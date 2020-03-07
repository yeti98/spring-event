package com.devculi.springevent.services;

import com.devculi.springevent.entities.User;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

@Service
public class MailService {
    public void sendInvitationLetter(Object listener, User user) {
        // generate token....
        System.out.println(String.format("Sent mail... Listen by: %s. Run on thread: %s",
                listener.getClass().getSimpleName(),
                Thread.currentThread().getName()));
        String mailContent = String.format("Hello %s, welcome to `Lớp học của ông giáo`. Please verify your account!", user.getUsername());
        System.out.println(mailContent);
    }

    @Async
    public Future<Boolean> sendInvitationLetterAsync(Object listener, User user) {
        // generate token....
        System.out.println(String.format("Sent mail and return status... Listen by: %s. Run on thread: %s",
                listener.getClass().getSimpleName(),
                Thread.currentThread().getName()));
        String mailContent = String.format("Hello %s, welcome to `Lớp học của ông giáo`. Please verify your account!", user.getUsername());
        System.out.println(mailContent);
        // if smt return new AsyncResult<>(false);
        return new AsyncResult<>(true);
    }
}
