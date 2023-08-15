package org.fade.demo.mybatis.nat5;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <p>启动类</p>
 * @author fade
 */
@SpringBootApplication
@MapperScan("org.fade.demo.mybatis.nat5.mapper")
public class NativeApplication {

    public static void main(String[] args) {
        SpringApplication.run(NativeApplication.class, args);
    }

}
