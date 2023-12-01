package com.example.mountains.range.controller.api;

import com.example.mountains.range.dto.GetRangeResponse;
import com.example.mountains.range.dto.GetRangesResponse;
import com.example.mountains.range.dto.PutRangeRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

public interface RangeController {

    @GetMapping("/api/ranges")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetRangesResponse getRanges();

    @GetMapping("/api/ranges/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetRangeResponse getRange(@PathVariable("id") UUID id);

    @PutMapping("/api/ranges/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    void putRange(@PathVariable("id") UUID id, @RequestBody PutRangeRequest request);

    @DeleteMapping("/api/ranges/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteRange(
            @PathVariable("id")
            UUID id
    );
}
