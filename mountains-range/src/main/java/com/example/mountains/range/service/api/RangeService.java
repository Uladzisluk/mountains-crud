package com.example.mountains.range.service.api;

import com.example.mountains.range.dto.PutRangeRequest;
import com.example.mountains.range.entity.Range;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RangeService {
    Optional<Range> find(UUID id);
    Optional<Range> find(String name);
    List<Range> findAll();
    void create(Range range);
    void createForEvent(UUID id, PutRangeRequest request);
    void delete(UUID id);
}
