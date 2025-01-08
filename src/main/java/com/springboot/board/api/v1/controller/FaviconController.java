package com.springboot.board.api.v1.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FaviconController {
    @GetMapping("/favicon.ico")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void handleFaviconRequest() {
        // 아무 내용도 반환하지 않고 HTTP 204 상태 코드를 반환
    }
}
