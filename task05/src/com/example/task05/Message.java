package com.example.task05;

import java.util.function.Consumer;

public class Message<T>{
    private String to;
    private String from;
    private T content;

    Message(String f, String t, T c){
        to = t;
        from = f;
        content = c;
    }

    public String getFrom() { return from; }
    public String getTo() { return to; }
    public T getContent() { return content; }
}
