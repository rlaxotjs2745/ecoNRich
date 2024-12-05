package com.task.econrich;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
        info = @Info(
                title = "백엔드 개발자 김태선 에코앤리치 채용과정 과제 전형",
                version = "v1"
        )
)
@SpringBootApplication
public class EcoNRichApplication {

    public static void main(String[] args) {
        SpringApplication.run(EcoNRichApplication.class, args);
    }

}
