package com.clearlove.pojo;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
// 基本上所有的对象都会序列化
public class User implements Serializable {

    private String name;
    private int age;
}
