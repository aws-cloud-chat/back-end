package com.example.accchat3.domain.user.repository;

import com.example.accchat3.domain.auth.entity.User;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.Expression;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.enhanced.dynamodb.model.ScanEnhancedRequest;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

@Repository
@RequiredArgsConstructor
public class UserReadRepositoryImpl implements UserReadRepository {

    private final DynamoDbEnhancedClient enhancedClient;

    private DynamoDbTable<User> table() {
        return enhancedClient.table("User", TableSchema.fromBean(User.class));
    }

    @Override
    public boolean existsByEmail(String email) {

        ScanEnhancedRequest request = ScanEnhancedRequest.builder()
                .filterExpression(
                        Expression.builder()
                                .expression("email = :email")
                                .putExpressionValue(":email", AttributeValue.fromS(email))
                                .build()
                )
                .limit(1)
                .build();

        return table().scan(request).items().iterator().hasNext();
    }

    @Override
    public boolean existsByUsername(String username) {

        ScanEnhancedRequest request = ScanEnhancedRequest.builder()
                .filterExpression(
                        Expression.builder()
                                .expression("userName = :username")
                                .putExpressionValue(":username", AttributeValue.fromS(username))
                                .build()
                )
                .limit(1)
                .build();

        return table().scan(request).items().iterator().hasNext();
    }
}
