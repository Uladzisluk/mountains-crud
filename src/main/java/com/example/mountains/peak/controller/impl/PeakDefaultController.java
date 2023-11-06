package com.example.mountains.peak.controller.impl;

import com.example.mountains.peak.controller.api.PeakController;
import com.example.mountains.peak.dto.GetPeakResponse;
import com.example.mountains.peak.dto.GetPeaksResponse;
import com.example.mountains.peak.dto.PutPeakRequest;
import com.example.mountains.peak.function.PeakToResponseFunction;
import com.example.mountains.peak.function.PeaksToResponseFunction;
import com.example.mountains.peak.function.RequestToPeakFunction;
import com.example.mountains.peak.service.api.PeakService;
import com.example.mountains.range.entity.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.NoSuchElementException;
import java.util.UUID;

@Controller
public class PeakDefaultController implements PeakController {

    private final PeakService service;
    private final PeakToResponseFunction peakToResponse;
    private final PeaksToResponseFunction peaksToResponse;
    private final RequestToPeakFunction requestToPeak;

    @Autowired
    public PeakDefaultController(
            PeakService service,
            PeakToResponseFunction peakToResponse,
            PeaksToResponseFunction peaksToResponse,
            RequestToPeakFunction requestToPeak
    ){
        this.service = service;
        this.peakToResponse = peakToResponse;
        this.peaksToResponse = peaksToResponse;
        this.requestToPeak = requestToPeak;
    }
    @Override
    public GetPeaksResponse getPeaks() {
        return peaksToResponse.apply(service.findAll());
    }

    @Override
    public GetPeakResponse getPeak(UUID id) {
        return service.find(id).map(peakToResponse).orElseThrow(() -> new NoSuchElementException());
    }

    @Override
    public void putPeak(UUID id, PutPeakRequest request) {
        service.create(requestToPeak.apply(id, request));
    }

    @Override
    public void deletePeak(UUID id) {
        service.delete(id);
    }
}
