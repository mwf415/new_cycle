package cn.onlov.cycle;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan(basePackages = "cn.onlov.cycle.core.dao.mapper")
@EnableTransactionManagement
@EnableScheduling
public class CycleApplication {

    public static void main(String[] args) {
        SpringApplication.run(CycleApplication.class, args);
    }
}
