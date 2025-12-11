package com.example.accchat3.global.config;

<<<<<<< HEAD
import jakarta.annotation.PostConstruct;
=======
import org.springframework.beans.factory.annotation.Value;
>>>>>>> 6e912bf8a0d4ef5be62a7e736a185ddd0f65984a
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.context.annotation.Profile;
<<<<<<< HEAD
=======
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
>>>>>>> 6e912bf8a0d4ef5be62a7e736a185ddd0f65984a
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

@Configuration
@Profile("prod")
public class DynamoDBConfig {
    @Value("${aws.region}")
    private String region;

    @Value("${aws.credentials.accessKeyId}")
    private String accessKey;

    @Value("${aws.credentials.secretAccessKey}")
    private String secretAccessKey;


    @PostConstruct
    public void init() {
        System.out.println("🔥 Using PROD DynamoDB Config");
    }


    @Bean
    public DynamoDbClient dynamoDbClient() {
        return DynamoDbClient.builder()
                .region(Region.of(region)) // 서울 리전
                .credentialsProvider(StaticCredentialsProvider.create(
                        AwsBasicCredentials.create(accessKey, secretAccessKey)
                ))
                .build();
    }


    @Bean
    public DynamoDbEnhancedClient dynamoDbEnhancedClient(DynamoDbClient dynamoDbClient){
        return DynamoDbEnhancedClient.builder()
                .dynamoDbClient(dynamoDbClient)
                .build();

    }


}
