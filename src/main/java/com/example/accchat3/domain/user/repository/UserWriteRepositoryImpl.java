package com.example.accchat3.domain.user.repository;

import com.example.accchat3.domain.auth.entity.User;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;

@Repository
@RequiredArgsConstructor
public class UserWriteRepositoryImpl implements UserWriteRopository{

    private final DynamoDbEnhancedClient enhancedClient;

    private DynamoDbTable<User> table() {
        return enhancedClient.table("User", TableSchema.fromBean(User.class));
    }

    @Override
    public void save(User user) {
        table().putItem(user);
    }

    @Override
    public User findById(Integer userId) {
        return table().getItem(
                Key.builder().partitionValue(userId).build()
        );
    }
}
