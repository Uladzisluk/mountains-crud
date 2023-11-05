package com.example.mountains.peak.repository.api;

import com.example.mountains.peak.entity.Peak;
import com.example.mountains.range.entity.Range;
import com.example.mountains.repository.CrudRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PeakRepository extends CrudRepository<Peak, UUID> {
    Optional<Peak> findByIdAndRange(UUID id, Range range);

    List<Peak> findAllByRange(Range range);

}
