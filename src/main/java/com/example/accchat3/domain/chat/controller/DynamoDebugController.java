package com.example.accchat3.domain.chat.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DynamoDebugController {

    private final DynamoDbClient dynamoDbClient; // Config에서 주입되는 그 Bean

    @GetMapping("/dynamo/debug")
    public List<String> debug() {
        return dynamoDbClient.listTables().tableNames();
    }
}
