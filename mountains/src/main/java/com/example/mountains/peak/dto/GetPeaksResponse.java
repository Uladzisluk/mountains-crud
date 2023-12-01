package com.example.mountains.peak.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Singular;

import java.util.List;
import java.util.UUID;

@Data
@Builder
public class GetPeaksResponse {
    @Data
    @Builder
    public static class Peak{
        UUID id;
        String name;
        Double height;
        String range;
    }

    @Singular
    List<Peak> peaks;
}
