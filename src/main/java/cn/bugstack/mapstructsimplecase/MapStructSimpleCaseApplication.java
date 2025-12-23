package cn.bugstack.mapstructsimplecase;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.bugstack.mapstructsimplecase.mapper")
public class MapStructSimpleCaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(MapStructSimpleCaseApplication.class, args);
    }

}
