package com.application.demo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class IncomingMessage {

    private String messageId;
    private String messageBody;
}
