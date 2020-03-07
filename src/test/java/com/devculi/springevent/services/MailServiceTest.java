package com.devculi.springevent.services;

import com.devculi.springevent.entities.User;
import com.devculi.springevent.events.InvitationEvent;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.mock;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MailServiceTest {
    @Mock
    ApplicationEventPublisher applicationEventPublisher;

    @Test
    public void sendInvitationLetter() {
        User user = mock(User.class);
        InvitationEvent invitationEvent = new InvitationEvent(this, user);
        applicationEventPublisher.publishEvent(invitationEvent);
    }
}