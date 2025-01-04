package com.springboot.board.api.v1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.springboot.board.api.v1.dto.response.HealthResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Health", description = "헬스 체크 API")
@RestController
@RequestMapping("/api/v1/health")
public class HealthController {

  @Operation(summary = "헬스 체크", description = "서버의 상태를 확인합니다.")
  @GetMapping
  public HealthResponse checkHealth() {
    return new HealthResponse("UP");
  }
}