package com.example.mountains.range.repository.memory;

import com.example.mountains.datastore.component.DataStore;
import com.example.mountains.range.entity.Range;
import com.example.mountains.range.repository.api.RangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class RangeInMemoryRepository implements RangeRepository {

    private final DataStore store;

    @Autowired
    public RangeInMemoryRepository(DataStore store){
        this.store = store;
    }


    @Override
    public Optional<Range> findByName(String name) {
        return store.findAllRanges().stream()
                .filter(range -> range.getName().equals(name))
                .findFirst();
    }

    @Override
    public Optional<Range> findById(UUID id) {
        return store.findAllRanges().stream()
                .filter(range -> range.getId().equals(id))
                .findFirst();
    }

    @Override
    public List<Range> findAll() {
        return store.findAllRanges();
    }

    @Override
    public Range save(Range entity) {
        store.saveRange(entity);
        return entity;
    }

    @Override
    public void delete(Range entity) {
        throw new UnsupportedOperationException("Not implemented.");
    }
}
