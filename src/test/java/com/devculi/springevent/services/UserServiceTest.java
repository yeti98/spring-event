package com.devculi.springevent.services;

import com.devculi.springevent.entities.User;
import com.devculi.springevent.events.publishers.AppEventPublisher;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
    @InjectMocks
    private UserService userService;
    @Mock
    private AppEventPublisher appEventPublisher;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void whenUserSignup_thenSentMail() {
        // when
        userService.signup("any_username", "any_password");
        // then
        verify(appEventPublisher, times(1)).publishInvitationEvent(any(User.class));
    }
}