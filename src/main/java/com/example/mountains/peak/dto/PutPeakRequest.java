package com.example.mountains.peak.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PutPeakRequest {
    String name;
    Double height;
    String range;
}
