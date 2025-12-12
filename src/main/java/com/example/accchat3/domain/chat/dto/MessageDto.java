package com.example.accchat3.domain.chat.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MessageDto {
    private String id;
    private String content;
    private LocalDateTime createdAt;
    private Long seq;
    private UserInfoDto sender;
}
