package com.example.mountains.peak.service.impl;

import com.example.mountains.peak.entity.Peak;
import com.example.mountains.peak.repository.api.PeakRepository;
import com.example.mountains.peak.service.api.PeakService;
import com.example.mountains.range.entity.Range;
import com.example.mountains.range.repository.api.RangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

@Service
public class PeakDefaultService implements PeakService {

    private final PeakRepository peakRepository;
    private final RangeRepository rangeRepository;

    @Autowired
    public PeakDefaultService(PeakRepository peakRepository, RangeRepository rangeRepository){
        this.peakRepository = peakRepository;
        this.rangeRepository = rangeRepository;
    }

    @Override
    public Optional<Peak> find(UUID id) {
        return peakRepository.findById(id);
    }

    @Override
    public Optional<Range> findRange(UUID rangeId) { return rangeRepository.findById(rangeId);}

    @Override
    public Optional<Peak> find(UUID id, Range range) {
        return peakRepository.findByIdAndRange(id, range);
    }

    @Override
    public List<Peak> findAll() {
        return peakRepository.findAll();
    }

    @Override
    public List<Peak> findAll(Range range) {
        return peakRepository.findAllByRange(range);
    }

    @Override
    public Optional<List<Peak>> findAllByRange(UUID rangeId) {
        return rangeRepository.findById(rangeId)
                .map(peakRepository::findAllByRange);
    }

    @Override
    public Optional<Peak> findByRange(UUID rangeId, UUID peakId){
        Optional<Range> range = rangeRepository.findById(rangeId);
        if(!range.isPresent()) throw new NoSuchElementException("RANGE_NOT_FOUND");
        Range presentRange = range.get();
        return find(peakId, presentRange);
    }

    @Override
    public void create(Peak peak) {
        peakRepository.save(peak);
    }

    @Override
    public void createInRange(UUID rangeId, Peak peak){
        Optional<Range> range = rangeRepository.findById(rangeId);
        if(!range.isPresent()) throw new NoSuchElementException("RANGE_NOT_FOUND");
        peak.setRange(range.get());
        peakRepository.save(peak);
    }

    @Override
    public void update(Peak peak) {
        peakRepository.save(peak);
    }

    @Override
    public void delete(UUID id) {
        peakRepository.findById(id).ifPresent(peak -> peakRepository.delete(peak));
    }
}
