package com.example.mountains.peak.dto;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class GetPeakResponse{
    UUID id;
    String name;
    Double height;
    String range;
}
