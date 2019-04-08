package com.example.demo.web.vo;

import lombok.Data;


@Data
public class Message<T> {
    private T info;
    private int code;
    public Message(T info, int code){
        this.info=info;
        this.code=code;
    }
}
