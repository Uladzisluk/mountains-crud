package com.example.mountains.range.dto;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
public class PatchRangeRequest {
    String name;
    Integer length;
}
