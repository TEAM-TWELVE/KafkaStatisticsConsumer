package com.example.demo.Consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;

@Component
public class CityConsumer {
    private static Collection<String> cityCollection = new ArrayList<>();

    @KafkaListener(topics = "${kafka.topic.city}")
    public void consume(String city)
    {
        cityCollection.add(city);
    }

    public Collection<String> citySearches(){
        return cityCollection;
    }
}