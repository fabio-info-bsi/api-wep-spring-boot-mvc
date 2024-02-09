# api-wep-spring-boot-mvc
Um exemplo de API REST com spring boot com mvc.

## Usou/Criou:
- @SpringBootApplication
- Lombok (@Slf4j, @AllArgsConstructor, @Getter, @Setter, @Data)
- @Service, @Component, @Controller, @RestController, @RestControllerAdvice
- ResponseEntity
- Exceptions customizadas e Handler para tratá-las.
- Logback
- MDC para logs
- Implementação de Interceptor para Requests (HandlerInterceptor & WebMvcConfigurer) 

## Lembretes

- #### Por padrão o spring cria uma `String` representação de um `Object` no formato JavaScript Object Notation (JSON) e retornar o dado via endpoint (`@RestController`)
    Ex:
    ```java
    @GetMapping("/country")
    public CountryDto home() {
        return CountryDto.of("Brazil", 18_000_00);
    }
    ```
    Response:
    ```json
    {
        "name": "Brazil",
        "population": 1800000
    }
    ```
- #### Com ResponseEntity é possível retornar Body, Status Code e Headers.
  ```java
  @GetMapping("/country")
  public ResponseEntity<?> home() {
      return ResponseEntity.status(HttpStatus.ACCEPTED)
              .header("timestamp", String.valueOf(System.currentTimeMillis()))
              .body(CountryDto.of("Brazil", 18_000_00));
  }
  ```
- #### Utilize @RestControllerAdvice para controlar exception dos @RestControllers
  ````java
  @RestControllerAdvice
  public class ExceptionControllerAdvice {
  
      @ExceptionHandler(BaseException.class)
      public ResponseEntity<ErrorDetails> exceptionBaseHandler(BaseException baseException) {
          return ResponseEntity.badRequest().body(baseException.getErrorDetails());
      }
  }
  ````
- #### Para registrar MDC nos logs utilize `MDC.put("<key>", <value>);`
- #### É possível criar interceptor para requests. Basta implementar interface `HandlerInterceptor` e adicionar aos Interceptors do Spring.
  ```Java
  public class RequestHandlerInterceptorImpl implements HandlerInterceptor {
        @Override
        public boolean preHandle(final HttpServletRequest request, final HttpServletResponse response, final Object handler) {
            //logic
            return true;
        }
  }
  ```
  Adicionando no Spring interceptor:
  ```java
  @Configuration
  public class WebConfig implements WebMvcConfigurer {
      @Override
      public void addInterceptors(final InterceptorRegistry registry) {
          registry.addInterceptor(new RequestHandlerInterceptorImpl());
      }
  }
  ```