package com.example.accchat3.global.redis;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RedisMessageListener {

    // 임시용 : 그냥 로그만 찍고 아무 기능 없음
    public void handleMessage(String message) {
        log.info("📩 [Dummy Redis Listener] 메시지 수신: {}", message);
    }
}
