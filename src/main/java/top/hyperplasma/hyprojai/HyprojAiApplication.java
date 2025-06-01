package top.hyperplasma.hyprojai;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("top.hyperplasma.hyprojai.mapper")
public class HyprojAiApplication {

    public static void main(String[] args) {
        SpringApplication.run(HyprojAiApplication.class, args);
    }

}
