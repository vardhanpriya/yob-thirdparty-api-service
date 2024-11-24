package com.thirdparty.apiservice.controller;


import io.opentelemetry.api.logs.LogRecordBuilder;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.Tracer;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Data

public class HelloController {
    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);
    private final Tracer tracer;
    private final RestTemplate restTemplate;


    public HelloController(Tracer tracer, RestTemplate restTemplate) {
        this.tracer = tracer;
        this.restTemplate = restTemplate;

    }

    @GetMapping("/hello")
    public String sayHello() {
        // Create a custom span
        Span span = tracer.spanBuilder("custom-span").startSpan();
        try {
            // Add custom attributes to the span
            span.setAttribute("custom.attribute", "example value");

            span.addEvent("Event inside span");
            span.addEvent("Event inside span2");
            span.addEvent("completed");

            return "Hello, OpenTelemetry!";
        } finally {
            span.end(); // End the span
        }
    }

    @GetMapping("/hii")
    public String sayHello1() {
        logger.info("Saying hello!");

        // Simulate a delay to make it more likely to see the trace in Zipkin
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            logger.error("Error", e);
        }

        return "Hello, world!";
    }
}
