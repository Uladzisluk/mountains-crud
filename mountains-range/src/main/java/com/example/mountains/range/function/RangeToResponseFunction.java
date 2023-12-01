package com.example.mountains.range.function;

import com.example.mountains.range.dto.GetRangeResponse;
import com.example.mountains.range.entity.Range;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class RangeToResponseFunction implements Function<Range, GetRangeResponse> {
    @Override
    public GetRangeResponse apply(Range range){
        return GetRangeResponse.builder()
                .id(range.getId())
                .name(range.getName())
                .length(range.getLength())
                .build();
    }
}
