package com.example.accchat3.domain.chat.util;

import java.time.*;

public final class TimeConverter {
    private static final ZoneId KST = ZoneId.of("Asia/Seoul");

    private TimeConverter() {}

    public static LocalDateTime kstFromEpochMillis(Long epochMillis) {
        return epochMillis == null
                ? null
                : LocalDateTime.ofInstant(Instant.ofEpochMilli(epochMillis), KST);
    }

/*    public static LocalDateTime kstFromEpochSeconds(Long epochSeconds) {
        return epochSeconds == null
                ? null
                : LocalDateTime.ofInstant(Instant.ofEpochSecond(epochSeconds), KST);
    }*/
}
