package com.example.demo.Service;

import com.example.demo.Consumer.CityConsumer;
import com.example.demo.Model.TopCity;
import org.apache.kafka.common.protocol.types.Field;
import org.apache.logging.log4j.util.PropertySource;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CityService {

    private CityConsumer cityConsumer = new CityConsumer();
    private Collection<String> citySearches = cityConsumer.citySearches();

    public Collection<TopCity> fetchCityStatistics() {
        HashMap<String, Integer> hashMaps = new HashMap<String, Integer>();
        for (String city : citySearches) {
            if (hashMaps.containsKey(city)) {
                hashMaps.put(city, hashMaps.get(city) + 1);
            }else {
            hashMaps.put(city, 1);
            }
        }
        return sortCities(hashMaps);
    }

    public Collection<TopCity> sortCities(HashMap<String, Integer> hashMaps) {
        List<TopCity> topCities = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : hashMaps.entrySet()) {
            topCities.add(new TopCity(entry.getKey(), entry.getValue()));
        }
        Collections.sort(topCities);
        Collections.reverse(topCities);

        List<TopCity> sortedCities = new ArrayList<>();

        for (int i = 0; i < topCities.size() && i < 3 ; i++) {
            sortedCities.add(topCities.get(i));
        }
        return sortedCities;
    }
}
