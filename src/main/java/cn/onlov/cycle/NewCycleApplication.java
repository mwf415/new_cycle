package cn.onlov.cycle;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

@MapperScan("cn.onlov.cycle.dao.mapper")
public class NewCycleApplication {

    public static void main(String[] args) {
        SpringApplication.run(NewCycleApplication.class, args);
    }
}
