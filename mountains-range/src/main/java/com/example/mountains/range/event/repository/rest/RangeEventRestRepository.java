package com.example.mountains.range.event.repository.rest;

import com.example.mountains.range.dto.PutRangeRequest;
import com.example.mountains.range.event.repository.api.RangeEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Repository
public class RangeEventRestRepository implements RangeEventRepository {
    private final RestTemplate restTemplate;

    @Autowired
    public  RangeEventRestRepository(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @Override
    public void create(UUID id, PutRangeRequest request) {
        restTemplate.put("/api/ranges/{id}", request, id);
    }

    @Override
    public void delete(UUID id) {
        restTemplate.delete("/api/ranges/{id}", id);
    }
}
