package com.example.mountains.range.controller.impl;

import com.example.mountains.range.controller.api.RangeController;
import com.example.mountains.range.dto.GetRangesResponse;
import com.example.mountains.range.dto.PutRangeRequest;
import com.example.mountains.range.function.RangesToResponseFunction;
import com.example.mountains.range.function.RequestToRangeFunction;
import com.example.mountains.range.service.api.RangeService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@RestController
@Log
public class RangeDefaultController implements RangeController {

    private final RangeService service;
    private final RequestToRangeFunction requestToRange;

    private final RangesToResponseFunction rangesToResponse;
    @Autowired
    public RangeDefaultController(RangeService service,
                                  RequestToRangeFunction requestToRange,
                                  RangesToResponseFunction rangesToResponse){
        this.service = service;
        this.requestToRange = requestToRange;
        this.rangesToResponse = rangesToResponse;
    }

    @Override
    public GetRangesResponse getRanges() {
        return rangesToResponse.apply(service.findAll());
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
