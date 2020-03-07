package com.devculi.springevent.events.listeners;

import com.devculi.springevent.events.InvitationEvent;
import com.devculi.springevent.services.MailService;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class InvitationListener implements ApplicationListener<InvitationEvent> {
    final MailService mailService;

    public InvitationListener(MailService mailService) {
        this.mailService = mailService;
    }

    /**
     * @param invitationEvent : sự kiện cần được bắt
     */
    @Override
    public void onApplicationEvent(InvitationEvent invitationEvent) {
        Assert.notNull(invitationEvent, "Event must not be null");
        mailService.sendInvitationLetter(this, invitationEvent.getUser());
    }
}
