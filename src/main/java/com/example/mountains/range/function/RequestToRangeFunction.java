package com.example.mountains.range.function;

import com.example.mountains.range.dto.GetRangesResponse;
import com.example.mountains.range.dto.PutRangeRequest;
import com.example.mountains.range.entity.Range;

import java.util.UUID;
import java.util.function.BiFunction;

public class RequestToRangeFunction implements BiFunction<UUID, PutRangeRequest, Range> {
    @Override
    public Range apply(UUID id, PutRangeRequest request){
        return Range.builder()
                .id(id)
                .name(request.getName())
                .length(request.getLength())
                .build();
    }
}
