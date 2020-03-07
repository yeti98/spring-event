package com.devculi.springevent.events;

import com.devculi.springevent.entities.User;
import org.springframework.context.ApplicationEvent;
import org.springframework.util.Assert;

// InvitationEvent cần kế thừa ApplicationEvent để là 1 event hợp lệ
public class InvitationEvent extends ApplicationEvent {
    private User user;

    /**
     * @param source : nơi phát ra event
     * @param user   : object muốn truyền vào event
     */
    public InvitationEvent(Object source, User user) {
        // bắt buộc phải gọi đến constructor của lớp cha
        super(source);
        Assert.notNull(user, "User must not be null");
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
