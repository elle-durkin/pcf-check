package com.test.pcf.pcfcheck.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalTime;

@RestController
public class LoggingController {
    private String makeHTMLRow(String endpoint, String msg){
        String link="";
        if(endpoint != "Context Root")
            link = "<a href=/" + endpoint + ">" + endpoint + "</a>";
        else {
            link = endpoint;
        }
        return "<tr><td>" + link + "</td><td>&nbsp</td><td>" + msg + "</td></tr>";
    }

    @RequestMapping("/logging")
    public String index(){
        String s = "<table>";
        s += makeHTMLRow("hour", "one message every second for an hour.");
        s += makeHTMLRow("minute","one message every second for a minute");
        s += makeHTMLRow("seconds", "one message every second for 15 seconds");
        s += "</table>";

        return s;
    }

    class WriteEachSecond extends Thread {
        int seconds = 0;
        WriteEachSecond(int seconds) { this.seconds = seconds;}

        public void run(){
            for (int i=0; i <this.seconds; i++) {
                System.out.println(i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    @RequestMapping("/hour")
    public String hour() {
        WriteEachSecond wes = new WriteEachSecond(3600);
        wes.start();
        return "Your hour has started...";
    }

    @RequestMapping("/minute")
    public String minute() {
        WriteEachSecond wes = new WriteEachSecond(60);
        wes.start();
        return "Your minute has started...";
    }

    @RequestMapping("/seconds")
    public String seconds() {
        WriteEachSecond wes = new WriteEachSecond(15);
        wes.start();
        return "Your 15 seconds have started...";
    }

    public LocalTime id=null;

    public String getId(){
        LocalTime ts = LocalTime.now();
        if(id==null){
            id = LocalTime.now();
        }
        else {
            if (ts.isAfter(id.plusSeconds(30))){
                id = LocalTime.now();
            }
        }
        return Integer.toString(id.toSecondOfDay());
    }

    @RequestMapping("/smallmsg")
    public String smallmsg(){
        String msg = getId() + "-- 12345";
        System.out.println(msg);
        return "Wrote the following small message to System.out" + msg;
    }

    @RequestMapping("/bigmsg")
    public String bigmsg(){
        String msg = getId() + "--";
        for (int i=0; i<20;i++){
            msg += "0123456789abcdefghijklmnopqrstuvwxyz---";
        }
        System.out.println(msg);
        return "Wrote the following big message to System.out" + msg;
    }

}
