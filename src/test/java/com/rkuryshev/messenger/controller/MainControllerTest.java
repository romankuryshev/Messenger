package com.rkuryshev.messenger.controller;

import com.rkuryshev.messenger.service.ChatService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MainControllerTest {

    MainController mainController = Mockito.mock(MainController.class);

    @Test
    void getPublic() {
        Assertions.assertEquals("public", mainController.getPublic());
    }
}