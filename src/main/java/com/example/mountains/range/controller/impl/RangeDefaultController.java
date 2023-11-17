package com.example.mountains.range.controller.impl;

import com.example.mountains.peak.function.PeakToResponseFunction;
import com.example.mountains.peak.function.PeaksToResponseFunction;
import com.example.mountains.peak.function.RequestToPeakFunction;
import com.example.mountains.peak.service.api.PeakService;
import com.example.mountains.range.controller.api.RangeController;
import com.example.mountains.range.dto.GetRangeResponse;
import com.example.mountains.range.dto.GetRangesResponse;
import com.example.mountains.range.dto.PutRangeRequest;
import com.example.mountains.range.function.RangeToResponseFunction;
import com.example.mountains.range.function.RangesToResponseFunction;
import com.example.mountains.range.function.RequestToRangeFunction;
import com.example.mountains.range.service.api.RangeService;
import com.example.mountains.range.service.impl.RangeDefaultService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@RestController
@Log
public class RangeDefaultController implements RangeController {

    private final RangeService service;
    private final RangeToResponseFunction rangeToResponse;
    private final RangesToResponseFunction rangesToResponse;
    private final RequestToRangeFunction requestToRange;

    @Autowired
    public RangeDefaultController(RangeService service,
                               RangeToResponseFunction rangeToResponse,
                               RangesToResponseFunction rangesToResponse,
                               RequestToRangeFunction requestToRange){
        this.service = service;
        this.rangeToResponse = rangeToResponse;
        this.rangesToResponse = rangesToResponse;
        this.requestToRange = requestToRange;
    }

    @Override
    public GetRangesResponse getRanges() {
        return rangesToResponse.apply(service.findAll());
    }

    @Override
    public GetRangeResponse getRange(UUID id) {
        return service.find(id).map(rangeToResponse)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public void putRange(UUID id, PutRangeRequest request) {
        service.create(requestToRange.apply(id, request));
    }

    @Override
    public void deleteRange(UUID id) {
        service.find(id)
                .ifPresentOrElse(
                        range -> service.delete(id),
                        () -> {
                            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                        }
                );
    }
}
