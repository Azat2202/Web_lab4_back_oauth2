package ru.web_lab4;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * Tests that application starts
 */
@SpringBootTest
class ApplicationTest {
    @Autowired
    private WebLab4BackApplication webLab4BackApplication;
    @Test
    void contextLoads() {
        assertThat(webLab4BackApplication).isNotNull();
    }
}