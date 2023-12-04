package com.example.mountains.range.event.repository.api;

import com.example.mountains.range.dto.PutRangeRequest;

import java.util.UUID;

public interface RangeEventRepository {
    void create(UUID id, PutRangeRequest request);
    void delete(UUID id);
}
