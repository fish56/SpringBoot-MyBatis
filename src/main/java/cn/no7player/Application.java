package cn.no7player;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.no7player.mapper") // 告知MyBatis我们的接口层的位置
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
