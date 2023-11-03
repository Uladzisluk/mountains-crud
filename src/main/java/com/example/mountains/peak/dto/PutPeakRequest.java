package com.example.mountains.peak.dto;

import lombok.Data;

@Data
public class PutPeakRequest {
    String name;
    Double height;
    String range;
}
