# EZEN Mini 프로젝트 백엔드

## 설명

- Ezen Boot Camp mini 프로젝트 백엔드 파트
- 수업내용을 원본으로 API server 구현 리팩토링
- Vscode , intellij 둘다 사용 가능

## 기술 스택

- Java 17
- Spring Boot 3.1.5
- MySQL
- Maven
- Lombok
- Swagger

## 설치 및 실행 방법

1. 필요한 소프트웨어 설치:

   - JDK 17 이상
   - Maven
   - MySQL
   - Postman (필요시)

2. 프로젝트 클론:

   ```bash
   git clone [프로젝트의 Git 저장소 URL]
   ```

3. 의존성 설치:

   ```bash
   # .env 파일 생성해야 빌드가 됨
   cd [프로젝트 디렉토리]
   mvn clean install
   ```

4. 애플리케이션 실행:
   ```bash
   mvn spring-boot:run
   ```

## API 문서

- Swagger UI: [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)
- API 문서: [http://localhost:8080/v3/api-docs](http://localhost:8080/v3/api-docs)

## 패키지 구조

## Swagger UI

Swagger UI: http://localhost:8080/swagger-ui/index.html

## Swagger API 문서

API 문서: http://localhost:8080/v3/api-docs

## 패키지 구조

```mermaid
graph LR;
    A[com.springboot.board] --> B[api]
    B --> C[v1]
    C --> D[controller]
    D --> E[QuestionController.java]
    D --> F[AnswerController.java]
    C --> G[dto]
    G --> H[request]
    H --> I[QuestionCreateRequest.java]
    H --> J[AnswerCreateRequest.java]
    G --> K[response]
    K --> L[QuestionResponse.java]
    K --> M[AnswerResponse.java]

    A --> N[application]
    N --> O[service]
    O --> P[QuestionService.java]
    O --> Q[AnswerService.java]
    N --> R[mapper]
    R --> S[QuestionMapper.java]
    R --> T[AnswerMapper.java]

    A --> U[domain]
    U --> V[entity]
    V --> W[Question.java]
    V --> X[Answer.java]
    U --> Y[repository]
    Y --> Z[QuestionRepository.java]
    Y --> AA[AnswerRepository.java]

    A --> AB[common]
    AB --> AC[exception]
    AC --> AD[DataNotFoundException.java]
    AC --> AE[GlobalExceptionHandler.java]
    AB --> AF[response]
    AF --> AG[ApiResponse.java]
    AB --> AH[util]
    AH --> AI[DateTimeUtil.java]

    A --> AJ[config]
    AJ --> AK[SwaggerConfig.java]
    AJ --> AL[WebConfig.java]
    AJ --> AM[SecurityConfig.java]
```

## Question 시퀀스

```mermaid
%%{init: {'theme': 'dark'}}%%
sequenceDiagram
    participant C as Client
    participant QC as QuestionController
    participant QS as QuestionService
    participant QM as QuestionMapper
    participant QR as QuestionRepository

    C->>+QC: POST /api/v1/questions
    Note over C,QC: @RequestBody QuestionCreateRequest
    Note right of C: { "subject": "질문 제목", "content": "질문 내용" }

    QC->>+QS: createQuestion(request)

    QS->>+QM: toEntity(request)
    Note over QM: DTO를 Entity로 변환
    QM-->>-QS: Question Entity

    QS->>+QR: save(question)
    Note over QR: 데이터베이스에 저장
    QR-->>-QS: Saved Question Entity

    QS->>+QM: toResponse(savedQuestion)
    Note over QM: Entity를 DTO로 변환
    QM-->>-QS: QuestionResponse

    QS-->>-QC: QuestionResponse
    QC-->>-C: ApiResponse<QuestionResponse>
```

<br>
<br>

## Answer 시퀀스

```mermaid
%%{init: {'theme': 'dark'}}%%
sequenceDiagram
    participant C as Client
    participant AC as AnswerController
    participant AS as AnswerService
    participant AM as AnswerMapper
    participant AR as AnswerRepository

    C->>+AC: POST /api/v1/answers
    Note over C,AC: @RequestBody AnswerCreateRequest
    Note right of C: { "content": "답변 내용", "questionId": 1 }

    AC->>+AS: createAnswer(request)

    AS->>+AM: toEntity(request)
    Note over AM: DTO를 Entity로 변환
    AM-->>-AS: Answer Entity

    AS->>+AR: save(answer)
    Note over AR: 데이터베이스에 저장
    AR-->>-AS: Saved Answer Entity

    AS->>+AM: toResponse(savedAnswer)
    Note over AM: Entity를 DTO로 변환
    AM-->>-AS: AnswerResponse

    AS-->>-AC: AnswerResponse
    AC-->>-C: ApiResponse<AnswerResponse>
```
