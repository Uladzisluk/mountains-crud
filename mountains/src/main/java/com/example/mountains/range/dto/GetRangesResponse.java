package com.example.mountains.range.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Singular;

import java.util.List;
import java.util.UUID;


@Data
@Builder
public class GetRangesResponse {
    @Data
    @Builder
    public static class Range{
        UUID id;
        String name;
        Integer length;
    }

    @Singular
    List<Range> ranges;
}
