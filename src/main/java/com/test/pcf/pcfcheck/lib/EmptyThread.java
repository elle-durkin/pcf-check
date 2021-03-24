package com.test.pcf.pcfcheck.lib;

public class EmptyThread implements Runnable {

    @Override
    public void run() { while (!Thread.currentThread().isInterrupted()) {}}
}
