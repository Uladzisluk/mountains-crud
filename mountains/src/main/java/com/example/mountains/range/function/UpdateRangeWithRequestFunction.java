package com.example.mountains.range.function;

import com.example.mountains.range.dto.PatchRangeRequest;
import com.example.mountains.range.entity.Range;

import java.util.function.BiFunction;

public class UpdateRangeWithRequestFunction implements BiFunction<Range, PatchRangeRequest, Range> {
    @Override
    public Range apply(Range range, PatchRangeRequest request){
        return Range.builder()
                .id(range.getId())
                .name(request.getName())
                .length(request.getLength())
                .build();
    }
}
