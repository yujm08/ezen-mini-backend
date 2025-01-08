package com.springboot.board.common.util;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class DateTimeUtil {
    private static final ZoneId ZONE_SEOUL = ZoneId.of("Asia/Seoul");
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    // 현재 시간을 Asia/Seoul 타임존으로 가져옴
    public static LocalDateTime now() {
        return LocalDateTime.now(ZONE_SEOUL);
    }

    // LocalDateTime을 문자열로 포맷팅
    public static String format(LocalDateTime dateTime) {
        return dateTime != null ? dateTime.format(FORMATTER) : null;
    }
}
