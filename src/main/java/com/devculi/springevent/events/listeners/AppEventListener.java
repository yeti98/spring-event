package com.devculi.springevent.events.listeners;

import com.devculi.springevent.events.InvitationEvent;
import com.devculi.springevent.services.MailService;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class AppEventListener {
    final
    MailService mailService;

    public AppEventListener(MailService mailService) {
        this.mailService = mailService;
    }

    /** Annotation @EventListener đánh đâu là sẽ lắng nghe sự kiện.
     * @param invitationEvent: sự kiện cần được bắt
     */
    @EventListener
    public void invitationEventListener(InvitationEvent invitationEvent) {
        Assert.notNull(invitationEvent, "Event must not be null");
        mailService.sendInvitationLetter(this, invitationEvent.getUser());
    }

    // khai báo những sự kiện khác...
}
