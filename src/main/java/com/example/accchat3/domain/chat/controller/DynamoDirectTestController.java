package com.example.accchat3.domain.chat.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

import java.net.URI;

@RestController
@RequiredArgsConstructor
public class DynamoDirectTestController {

    @GetMapping("/dynamo/direct")
    public String direct() {
        DynamoDbClient client = DynamoDbClient.builder()
                .region(Region.AP_NORTHEAST_2)
                .endpointOverride(URI.create("http://localhost:8000")) // 로컬 강제
                .credentialsProvider(
                        StaticCredentialsProvider.create(
                                AwsBasicCredentials.create("hsozi2", "0r5mqs")
                        )
                )
                .build();

        client.listTables(); // 여기서 실제로 로컬 서버에 요청

        return "local ok";
    }
}

