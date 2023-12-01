package com.example.mountains.range.dto;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class GetRangeResponse {
    UUID id;
    String name;
    Integer length;
}
