package com.example.mountains.range.function;

import com.example.mountains.range.dto.GetRangesResponse;
import com.example.mountains.range.entity.Range;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;

@Component
public class RangesToResponseFunction implements Function<List<Range>, GetRangesResponse> {
    @Override
    public GetRangesResponse apply(List<Range> ranges) {
        return GetRangesResponse.builder()
                .ranges(ranges.stream()
                        .map(range -> GetRangesResponse.Range.builder()
                                .id(range.getId())
                                .name(range.getName())
                                .length(range.getLength())
                                .build())
                        .toList())
                .build();
    }
}
