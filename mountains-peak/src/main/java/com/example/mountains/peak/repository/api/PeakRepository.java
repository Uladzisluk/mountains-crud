package com.example.mountains.peak.repository.api;

import com.example.mountains.peak.entity.Peak;
import com.example.mountains.range.entity.Range;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface PeakRepository extends JpaRepository<Peak, UUID> {
    Optional<Peak> findByIdAndRange(UUID id, Range range);

    List<Peak> findAllByRange(Range range);

}
