package com.test.pcf.pcfcheck.lib;

public class Result {
    private final long id;

    private final String content;

    public Result(long id, String content){
        this.id = id;
        this.content = content;
    }

    public long getId() { return id;}

    public String getContent() { return content;}
}
