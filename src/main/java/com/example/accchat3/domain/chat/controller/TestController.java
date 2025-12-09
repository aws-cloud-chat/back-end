package com.example.accchat3.domain.chat.controller;

import com.example.accchat3.domain.chat.entity.TestItem;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;

@RestController
@RequiredArgsConstructor
public class TestController {

    private final DynamoDbEnhancedClient enhancedClient; // Bean 주입만!

    private DynamoDbTable<TestItem> testTable() {
        return enhancedClient.table("TestTable", TableSchema.fromBean(TestItem.class));
    }

    @GetMapping("/dynamo/test")
    public String test() {
        TestItem item = new TestItem();
        item.setPk("USER#1");
        item.setSk("TEST#1");
        item.setMessage("Hello!");

        testTable().putItem(item);
        return "ok";
    }

    @GetMapping("/dynamo/test2")
    public String test2() {


        for(int i=2; i<10; i++){
            TestItem item = new TestItem();
            item.setPk("USER#"+i);
            item.setSk("TEST#"+i);
            item.setMessage("Hello! num: "+i);
            testTable().putItem(item);
        }


        return "ok";
    }



}