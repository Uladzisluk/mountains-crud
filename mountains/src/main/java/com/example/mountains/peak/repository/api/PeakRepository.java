package com.example.mountains.peak.repository.api;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.mountains.peak.entity.Peak;
import com.example.mountains.range.entity.Range;
import com.example.mountains.repository.CrudRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface PeakRepository extends JpaRepository<Peak, UUID> {
    Optional<Peak> findByIdAndRange(UUID id, Range range);

    List<Peak> findAllByRange(Range range);

}
