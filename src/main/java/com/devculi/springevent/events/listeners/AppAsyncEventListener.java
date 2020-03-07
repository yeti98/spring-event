package com.devculi.springevent.events.listeners;

import com.devculi.springevent.events.InvitationEvent;
import com.devculi.springevent.services.MailService;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.concurrent.Future;

@Component
// Các method gắn annotation @Async đều có access modifier là public và không thể gọi bởi các hàm khác trong cùng class
public class AppAsyncEventListener {
    final
    MailService mailService;

    public AppAsyncEventListener(MailService mailService) {
        this.mailService = mailService;
    }

    /**
     * Annotation @EventListener đánh đâu là sẽ lắng nghe sự kiện
     *
     * @param invitationEvent: sự kiện cần được bắt
     */
    @EventListener
    @Async
    public void invitationEventListener(InvitationEvent invitationEvent) {
        Assert.notNull(invitationEvent, "Event must not be null");
        mailService.sendInvitationLetter(this, invitationEvent.getUser());
    }

    /**
     * Annotation @EventListener đánh đâu là sẽ lắng nghe sự kiện
     *
     * @param invitationEvent: sự kiện cần được bắt
     */
    @EventListener
    @Async("threadPoolExecutor") // chỉ rõ tên của bean
    public void invitationEventListenerWithSpecificExecutor(InvitationEvent invitationEvent) {
        Assert.notNull(invitationEvent, "Event must not be null");
        mailService.sendInvitationLetter(this, invitationEvent.getUser());
    }

    /**
     * Annotation @EventListener đánh đâu là sẽ lắng nghe sự kiện
     *
     * @param invitationEvent: sự kiện cần được bắt
     */
    @EventListener
    @Async
    public void invitationEventListenerAndReturnStatus(InvitationEvent invitationEvent) {
        Assert.notNull(invitationEvent, "Event must not be null");
        Future<Boolean> result = mailService.sendInvitationLetterAsync(this, invitationEvent.getUser());
        while (true) {
            if (result.isDone()) {
                // việc gửi mail thành công
                break;
            }
            // làm gì đó
        }
    }

    // khai báo những sự kiện bất đồng bộ khác...
}
