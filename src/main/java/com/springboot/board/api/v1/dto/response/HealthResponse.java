package com.springboot.board.api.v1.dto.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class HealthResponse {
  private final String status;
}