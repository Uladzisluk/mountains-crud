package com.example.mountains.peak.service.impl;

import com.example.mountains.peak.entity.Peak;
import com.example.mountains.peak.repository.api.PeakRepository;
import com.example.mountains.peak.service.api.PeakService;
import com.example.mountains.range.entity.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PeakDefaultService implements PeakService {

    private final PeakRepository repository;

    @Autowired
    public PeakDefaultService(PeakRepository repository){
        this.repository = repository;
    }

    @Override
    public Optional<Peak> find(UUID id) {
        return repository.findById(id);
    }

    @Override
    public Optional<Peak> find(UUID id, Range range) {
        return repository.findByIdAndRange(id, range);
    }

    @Override
    public List<Peak> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Peak> findAll(Range range) {
        return repository.findAllByRange(range);
    }

    @Override
    public void create(Peak peak) {
        repository.save(peak);
    }

    @Override
    public void update(Peak peak) {
        repository.save(peak);
    }

    @Override
    public void delete(UUID id) {
        repository.findById(id).ifPresent(peak -> repository.delete(peak));
    }
}
