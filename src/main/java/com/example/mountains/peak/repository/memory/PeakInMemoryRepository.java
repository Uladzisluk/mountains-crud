package com.example.mountains.peak.repository.memory;

import com.example.mountains.datastore.component.DataStore;
import com.example.mountains.peak.entity.Peak;
import com.example.mountains.peak.repository.api.PeakRepository;
import com.example.mountains.range.entity.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class PeakInMemoryRepository implements PeakRepository {
    /**
     * Underlying data store. In future should be replaced with database connection.
     */
    private final DataStore store;

    @Autowired
    public PeakInMemoryRepository(DataStore store){
        this.store = store;
    }


    @Override
    public Optional<Peak> findByIdAndRange(UUID id, Range range) {
        return store.findAllPeaks().stream()
                .filter(peak -> peak.getRange().equals(range))
                .filter(peak -> peak.getId().equals(id))
                .findFirst();
    }

    @Override
    public List<Peak> findAllByRange(Range range) {
        return store.findAllPeaks().stream()
                .filter(peak -> range.equals(peak.getRange()))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Peak> findById(UUID id) {
        return store.findAllPeaks().stream()
                .filter(peak -> peak.getId().equals(id))
                .findFirst();
    }

    @Override
    public List<Peak> findAll() {
        return store.findAllPeaks();
    }

    @Override
    public Peak save(Peak entity) {
        store.savePeak(entity);
        return entity;
    }

    @Override
    public void delete(Peak entity) {
        store.deletePeak(entity.getId());
    }
}
