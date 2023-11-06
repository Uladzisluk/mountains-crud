package com.example.mountains.range.controller.api;

import com.example.mountains.range.dto.GetRangeResponse;
import com.example.mountains.range.dto.GetRangesResponse;
import com.example.mountains.range.dto.PutRangeRequest;

import java.util.UUID;

public interface RangeController {
    GetRangesResponse getRanges();
    GetRangeResponse getRange(UUID id);
    GetRangeResponse getRange(String name);
    void putRange(UUID id, PutRangeRequest request);
}
