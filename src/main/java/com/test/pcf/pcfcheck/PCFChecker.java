package com.test.pcf.pcfcheck;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class PCFChecker {

	public static void main(String[] args) {
		SpringApplication.run(PCFChecker.class, args);
	}

	private String makeHTMLRow(String title){
		return "<tr><td><h3>" + title + "</h3></td><td>&nbsp</td><td></td></tr>";
	}

	private String makeHTMLRow(String endpoint, String msg){
		String link="";
		if(endpoint != "Context Root")
			link = "<a href=/" + endpoint + ">" + endpoint + "</a>";
		else {
			link = endpoint;
		}
		return "<tr><td>" + link + "</td><td>&nbsp</td><td>" + msg + "</td></tr>";
	}

	@RequestMapping("/")
	public String index(){
		String s = "<table>";
		s += infoEndpoints();
		s += loggingEndpoints();
		s += resourceEndpoints();
		s += "</table>";

		return s;
	}

	private String infoEndpoints(){
		String s = makeHTMLRow("Health");
		s += makeHTMLRow("jvm", "Localhost information (name & IP address)");
		s += makeHTMLRow("java", "Java version running on DEA");
		s += makeHTMLRow("healthcheck", "Health check page to ensure app is running");
		s += makeHTMLRow("","");
		return s;
	}

	private String loggingEndpoints(){
		String s = makeHTMLRow("Logging");
		s += makeHTMLRow("smallmsg","Write a single, short message");
		s += makeHTMLRow("bigmsg", "Write a single, long message");
		s += makeHTMLRow("seconds", "Write one message per second for 15 seconds");
		s += makeHTMLRow("minute", "Write one message per second for 1 minute");
		s += makeHTMLRow("hour", "Write one message per second for 1 hour");
		s += makeHTMLRow("","");
		return s;
	}

	private String resourceEndpoints(){
		String s = makeHTMLRow("ISO Endpoints");
		s += makeHTMLRow("memory", "Ramp up memory usage");
		s += makeHTMLRow("killmemory", "Reduce memory usage");
		s += makeHTMLRow("cpu", "Ramp up CPU usage");
		s += makeHTMLRow("killcpu", "Reduce CPU usage");
		s += makeHTMLRow("","");
		return s;
	}


}
