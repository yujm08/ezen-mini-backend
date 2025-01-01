package com.springboot.board.common.util;

import lombok.experimental.UtilityClass;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * DateTimeUtil 클래스는 날짜 및 시간 관련 유틸리티 메서드를 제공하는 유틸리티 클래스
 */
@UtilityClass
public class DateTimeUtil {
    
    /**
     * 주어진 LocalDateTime 객체를 "yyyy-MM-dd HH:mm:ss" 형식의 문자열로 포맷
     * 
     * @param dateTime 포맷할 LocalDateTime 객체
     * @return 포맷된 날짜 및 시간 문자열, dateTime이 null인 경우 빈 문자열 반환
     */
    public String formatDateTime(LocalDateTime dateTime) {
        if (dateTime == null) return "";  // dateTime이 null인 경우 빈 문자열 반환
        return dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));  // 날짜 및 시간을 지정된 형식으로 포맷하여 반환
    }
} 