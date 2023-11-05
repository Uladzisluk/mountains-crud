package com.example.mountains.range.service.api;

import com.example.mountains.range.entity.Range;

import java.util.Optional;
import java.util.UUID;

public interface RangeService {
    Optional<Range> find(UUID id);
    Optional<Range> find(String name);
    void create(Range range);
}
