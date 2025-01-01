## 시퀀스 다이어그램
<br>


'''mermaid
sequenceDiagram
    Client->>+AnswerController: POST /api/v1/answers
    Note over Client,AnswerController: @RequestBody AnswerCreateRequest
    
    AnswerController->>+AnswerService: createAnswer(request)
    
    AnswerService->>+AnswerMapper: toEntity(request)
    Note over AnswerMapper: DTO를 Entity로 변환
    AnswerMapper-->>-AnswerService: Answer Entity
    
    AnswerService->>+AnswerRepository: save(answer)
    AnswerRepository-->>-AnswerService: Saved Answer Entity
    
    AnswerService->>+AnswerMapper: toResponse(savedAnswer)
    Note over AnswerMapper: Entity를 DTO로 변환
    AnswerMapper-->>-AnswerService: AnswerResponse
    
    AnswerService-->>-AnswerController: AnswerResponse
    
    AnswerController-->>-Client: ApiResponse<AnswerResponse>
    Note over Client,AnswerController: HTTP 201 Created
```
