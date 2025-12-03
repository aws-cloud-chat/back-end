package com.example.accchat3.global.config;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class DynamoDBLocalConfig {
    @PostConstruct
    public void init() {
        Amazon
        AmazonDynamoDB client = AmazonDynamoDBClientBuilder
                .standard()
                .withEndpointConfiguration(
                        new AwsClientBuilder.EndpointConfiguration(
                                "http://localhost:8000",
                                "ap-northeast-2"
                        )
                )
                .build();

        // 로컬 테스트 테이블 생성
        CreateTableRequest req = new CreateTableRequest()
                .withTableName("User")
                .withKeySchema(new KeySchemaElement("userId", KeyType.HASH))
                .withAttributeDefinitions(new AttributeDefinition("userId", ScalarAttributeType.S))
                .withProvisionedThroughput(new ProvisionedThroughput(5L, 5L));

        if (!client.listTables().getTableNames().contains("User")) {
            client.createTable(req);
        }
    }
}
