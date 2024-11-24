package com.thirdparty.apiservice.config;


import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.trace.Tracer;
import io.opentelemetry.exporter.jaeger.JaegerGrpcSpanExporter;
import io.opentelemetry.exporter.otlp.trace.OtlpGrpcSpanExporter;
import io.opentelemetry.sdk.OpenTelemetrySdk;
import io.opentelemetry.sdk.logs.SdkLoggerProvider;
import io.opentelemetry.sdk.metrics.SdkMeterProvider;
import io.opentelemetry.sdk.resources.Resource;
import io.opentelemetry.sdk.trace.SdkTracerProvider;
import io.opentelemetry.sdk.trace.export.SimpleSpanProcessor;
import org.springframework.context.annotation.Bean;
import io.opentelemetry.api.OpenTelemetry;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Configuration
public class TracerConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }


    @Bean
    public Tracer tracer(OpenTelemetry openTelemetry) {
        return openTelemetry.getTracer("com.thirdparty.apiservice");
    }


   @Bean
    public OpenTelemetry openTelemetry() {
//        JaegerGrpcSpanExporter jaegerExporter = JaegerGrpcSpanExporter.builder()
//                .setEndpoint("http://localhost:14250") // ensure Jaeger container name and port
//                .build();
//
//        return OpenTelemetrySdk.builder()
//                .setTracerProvider(SdkTracerProvider.builder()
//                        .addSpanProcessor(SimpleSpanProcessor.create(jaegerExporter))
//                        .build())
//                .setMeterProvider(SdkMeterProvider.builder().build())
//                .setLoggerProvider(SdkLoggerProvider.builder().build())
//                .buildAndRegisterGlobal();

//        Resource resource = Resource.getDefault()
//                .merge(Resource.builder()
//                        .put(ResourceAttributes.SERVICE_NAME, "my-service-name") // Set your service name here
//                        .build()); // Set your service name here
//
//        // Use getDefault for Jaeger exporter
//        JaegerGrpcSpanExporter jaegerExporter = JaegerGrpcSpanExporter.getDefault();
//
//        // Build the TracerProvider with the resource
//        SdkTracerProvider tracerProvider = SdkTracerProvider.builder()
//                .addSpanProcessor(SimpleSpanProcessor.create(jaegerExporter))
//                .setResource(resource)
//                .build();
//
//        // Return the configured OpenTelemetry instance
//        return OpenTelemetrySdk.builder()
//                .setTracerProvider(tracerProvider)
//                .setMeterProvider(SdkMeterProvider.builder().build())
//                .setLoggerProvider(SdkLoggerProvider.builder().build())
//                .buildAndRegisterGlobal();
//    }

//        Resource resource = Resource.getDefault()
//                .merge(Resource.builder()
//                        .put(ResourceAttributes.SERVICE_NAME, "yob-thirdparty-api-service") // Set your service name here
//                        .build()); // Set your service name here


//        OtlpGrpcSpanExporter exporter = OtlpGrpcSpanExporter.builder()
//                .setEndpoint("http://jaeger:14250") // OTLP endpoint
//                .build();



        Resource resource = Resource.getDefault().merge(Resource.create(
                Attributes.of(AttributeKey.stringKey("service.name"), "yob-thirdparty-api-service")
        ));


        JaegerGrpcSpanExporter jaegerExporter = JaegerGrpcSpanExporter.builder()
                .setEndpoint("http://localhost:14250")
                .build();


        OtlpGrpcSpanExporter otelExporter = OtlpGrpcSpanExporter.builder() .setEndpoint("http://localhost:14250").build(); // Set the endpoint of your Jaeger instance .build();


        SdkTracerProvider tracerProvider = SdkTracerProvider.builder()
                .addSpanProcessor(SimpleSpanProcessor.create(jaegerExporter))
                .setResource(resource)
                .build();

        return OpenTelemetrySdk.builder()
                .setTracerProvider(tracerProvider)
                .setMeterProvider(SdkMeterProvider.builder().build())
                .setLoggerProvider(SdkLoggerProvider.builder().build())
                .buildAndRegisterGlobal();
    }
}
