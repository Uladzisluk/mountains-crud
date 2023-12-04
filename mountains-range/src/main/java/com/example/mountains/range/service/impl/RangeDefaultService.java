package com.example.mountains.range.service.impl;

import com.example.mountains.range.dto.PutRangeRequest;
import com.example.mountains.range.entity.Range;
import com.example.mountains.range.event.repository.api.RangeEventRepository;
import com.example.mountains.range.repository.api.RangeRepository;
import com.example.mountains.range.service.api.RangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RangeDefaultService implements RangeService {

    private final RangeRepository repository;

    private final RangeEventRepository eventRepository;

    @Autowired
    public RangeDefaultService(RangeRepository repository, RangeEventRepository eventRepository){
        this.repository = repository;
        this.eventRepository = eventRepository;
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
    public List<Range> findAll(){
        return repository.findAll();
    }

    @Override
    public void delete(UUID id) {
        repository.findById(id).ifPresent(repository::delete);
        eventRepository.delete(id);
    }


    @Override
    public void create(Range range) {
        repository.save(range);
    }

    @Override
    public void createForEvent(UUID id, PutRangeRequest request) {
        eventRepository.create(id, request);
    }


}
