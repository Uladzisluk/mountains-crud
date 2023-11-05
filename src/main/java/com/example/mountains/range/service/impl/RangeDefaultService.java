package com.example.mountains.range.service.impl;

import com.example.mountains.range.entity.Range;
import com.example.mountains.range.repository.api.RangeRepository;
import com.example.mountains.range.repository.memory.RangeInMemoryRepository;
import com.example.mountains.range.service.api.RangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class RangeDefaultService implements RangeService {

    private final RangeRepository repository;

    @Autowired
    public RangeDefaultService(RangeRepository repository){
        this.repository = repository;
    }
    @Override
    public Optional<Range> find(UUID id) {
        return repository.findById(id);
    }

    @Override
    public Optional<Range> find(String name) {
        return repository.findByName(name);
    }

    @Override
    public void create(Range range) {
        repository.save(range);
    }
}
