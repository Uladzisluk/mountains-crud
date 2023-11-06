package com.example.mountains.peak.service.api;

import com.example.mountains.peak.entity.Peak;
import com.example.mountains.range.entity.Range;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PeakService {
    Optional<Peak> find(UUID id);
    Optional<Peak> find(UUID id, Range range);
    List<Peak> findAll();
    List<Peak> findAll(Range range);
    Optional<List<Peak>> findAllByRange(UUID rangeId);
    Optional<Peak> findByRange(UUID rangeId, UUID peakId);
    void create(Peak peak);
    void createInRange(UUID rangeId, Peak peak);
    void update(Peak peak);
    public void delete(UUID id);
}
