package com.test.pcf.pcfcheck.controllers;

import com.test.pcf.pcfcheck.lib.EmptyThread;
import com.test.pcf.pcfcheck.lib.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class ResourceController {

    private static final String memoryTemplate = "Buffer Size=%s";
    private static final String cpuTemplate = "Looping Thread=%s";
    private static final int recordSize = 1048576;
    private static final List<byte[]> buffer = new ArrayList<byte[]>();
    private static final List<Thread> threads = new ArrayList<Thread>();

    @RequestMapping("/memory")
    public Result testMemory() {
        byte[] bytes = new byte[recordSize];
        Arrays.fill(bytes, (byte) -1);
        buffer.add(bytes);

        long bufferSize = buffer.size()* recordSize;

        return new Result(buffer.size(), String.format(memoryTemplate,bufferSize));
    }

    @RequestMapping("/killmemory")
    public Result killMemory() {

        if (buffer.size() > 0) {
            buffer.remove(0);
        }

        long bufferSize = buffer.size() * recordSize;

        return new Result(buffer.size(), String.format(memoryTemplate,bufferSize));
    }

    @RequestMapping("/cpu")
    public Result testCpu(){
        Thread thread = new Thread(new EmptyThread());
        thread.start();
        threads.add(thread);

        return new Result(threads.size(),String.format(cpuTemplate,threads.size()));
    }

    @RequestMapping("/killcpu")
    public Result killCpu(){
        if (threads.size()>0) {
            threads.get(0).interrupt();
            threads.remove(0);
        }

        return new Result(threads.size(),String.format(cpuTemplate,threads.size()));
    }

}
