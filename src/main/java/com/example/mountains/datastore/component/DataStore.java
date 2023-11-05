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

    public synchronized void savePeak(Peak value) throws IllegalArgumentException {
        if (value.getRange() != null) {
            Range range = ranges.stream()
                    .filter(range1 -> range1.getId().equals(value.getRange().getId()))
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("No range with id \"%s\".".formatted(value.getRange().getId())));
            range.getPeaks().add(value);
        }
        peaks.removeIf(peak -> peak.getId().equals(value.getId()));
        peaks.add(value);
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

    public synchronized void saveRange(Range value) {
        ranges.removeIf(range -> range.getId().equals(value.getId()));
        ranges.add(cloningUtility.clone(value));
    }
}
