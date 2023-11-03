package com.example.mountains.datastore.component;

import com.example.mountains.peak.entity.Peak;
import com.example.mountains.range.entity.Range;
import com.example.mountains.serialization.component.CloningUtility;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Log
@Component
public class DataStore {
    private final Set<Range> ranges = new HashSet<>();

    private final Set<Peak> peaks = new HashSet<>();

    private final CloningUtility cloningUtility;

    @Autowired
    public DataStore(CloningUtility cloningUtility) {
        this.cloningUtility = cloningUtility;
    }

    public synchronized List<Peak> findAllPeaks() {
        return peaks.stream()
                .map(cloningUtility::clone)
                .collect(Collectors.toList());
    }

    public synchronized void createPeak(Peak value) throws IllegalArgumentException {
        if (peaks.stream().anyMatch(peak -> peak.getId().equals(value.getId()))) {
            throw new IllegalArgumentException("The peak id \"%s\" is not unique".formatted(value.getId()));
        }
        Peak entity = cloneWithRelationships(value);
        peaks.add(entity);
    }

    public synchronized void updatePeak(Peak value) throws IllegalArgumentException {
        Peak entity = cloneWithRelationships(value);
        if (peaks.removeIf(peak -> peak.getId().equals(value.getId()))) {
            peaks.add(entity);
        } else {
            throw new IllegalArgumentException("The peak with id \"%s\" does not exist".formatted(value.getId()));
        }
    }

    public synchronized void deletePeak(UUID id) throws IllegalArgumentException {
        if (!peaks.removeIf(peak -> peak.getId().equals(id))) {
            throw new IllegalArgumentException("The peak with id \"%s\" does not exist".formatted(id));
        }
    }

    public synchronized List<Range> findAllRanges() {
        return ranges.stream()
                .map(cloningUtility::clone)
                .collect(Collectors.toList());
    }

    public synchronized void createRange(Range value) throws IllegalArgumentException {
        if (ranges.stream().anyMatch(range -> range.getId().equals(value.getId()))) {
            throw new IllegalArgumentException("The range id \"%s\" is not unique".formatted(value.getId()));
        }
        ranges.add(cloningUtility.clone(value));
    }

    public synchronized void updateRange(Range value) throws IllegalArgumentException {
        if (ranges.removeIf(range -> range.getId().equals(value.getId()))) {
            ranges.add(cloningUtility.clone(value));
        } else {
            throw new IllegalArgumentException("The range with id \"%s\" does not exist".formatted(value.getId()));
        }
    }

    private Peak cloneWithRelationships(Peak value) {
        Peak entity = cloningUtility.clone(value);

        if (entity.getRange() != null) {
            entity.setRange(ranges.stream()
                    .filter(range -> range.getId().equals(value.getRange().getId()))
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("No range with id \"%s\".".formatted(value.getRange().getId()))));
        }

        return entity;
    }
}
