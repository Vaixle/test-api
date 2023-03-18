package com.vaixle.testapi.configuration;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Getter
@Setter
@Component
@FieldDefaults(level = AccessLevel.PRIVATE)
@ConfigurationProperties(prefix = "exception")
public class ExceptionConfig {
    MessageConfig orderNotFound;
    MessageConfig productNotFound;
    MessageConfig notEnough;

    @Getter
    @Setter
    @FieldDefaults(level = AccessLevel.PRIVATE)
    public static class MessageConfig {
        String defaultMessage;
        String messageWithId;
        String messageWithCount;
    }

    public String getOrderNotFoundDefaultMessage() {
        return orderNotFound.getDefaultMessage();
    }

    public String getOrderNotFoundMessageWithId() {
        return orderNotFound.getMessageWithId();
    }
    public String getProductNotFoundDefaultMessage() {
        return productNotFound.getDefaultMessage();
    }

    public String getProductNotFoundMessageWithId() {
        return productNotFound.getMessageWithId();
    }

    public String getNotEnoughDefaultMessage() {
        return notEnough.getDefaultMessage();
    }

    public String getNotEnoughMessageWithCount() {
        return notEnough.getMessageWithCount();
    }
}
