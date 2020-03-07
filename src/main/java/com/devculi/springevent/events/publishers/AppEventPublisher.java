package com.devculi.springevent.events.publishers;

// Publisher cho tất cả các event được custom
// Adapter pattern được sử dụng ở đây.

import com.devculi.springevent.entities.User;
import com.devculi.springevent.events.InvitationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class AppEventPublisher {
    final
    ApplicationEventPublisher applicationEventPublisher;

    public AppEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }


    /**
     * @param user : User truyền vào InvitationEvent.
     *             Vì ta không mong muốn user thay đổi nên thêm từ khóa final
     */
    public void publishInvitationEvent(final User user) {
        // tạo event
        InvitationEvent invitationEvent = new InvitationEvent(this, user);
        // publish event
        applicationEventPublisher.publishEvent(invitationEvent);
    }
}
