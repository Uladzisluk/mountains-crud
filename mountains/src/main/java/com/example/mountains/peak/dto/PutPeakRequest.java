package com.example.mountains.peak.dto;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Builder
@Data
public class PutPeakRequest {
    String name;
    Double height;
    UUID range;
}
