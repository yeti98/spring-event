package com.devculi.springevent.services;

import com.devculi.springevent.entities.User;
import com.devculi.springevent.events.publishers.AppEventPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    AppEventPublisher eventPublisher;

    public void signup(String username, String password) {
        // do others
        User user = new User(username, password);
        eventPublisher.publishInvitationEvent(user);
    }
}
