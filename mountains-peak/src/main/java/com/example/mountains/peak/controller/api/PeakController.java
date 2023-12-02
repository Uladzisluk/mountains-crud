package com.example.mountains.peak.controller.api;

import com.example.mountains.peak.dto.GetPeakResponse;
import com.example.mountains.peak.dto.GetPeaksResponse;
import com.example.mountains.peak.dto.PutPeakRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

public interface PeakController {

    @GetMapping("/api/peaks")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetPeaksResponse getPeaks();

    @GetMapping("/api/peaks/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetPeakResponse getPeak(@PathVariable("id") UUID id);

    @GetMapping("/api/ranges/{rangeId}/peaks")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetPeaksResponse getRangePeaks(@PathVariable("rangeId") UUID rangeId);

    @GetMapping("/api/ranges/{rangeId}/peaks/{peakId}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetPeakResponse getRangePeak(@PathVariable("rangeId") UUID rangeId, @PathVariable("peakId") UUID peakId);

    @PutMapping("/api/peaks/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    void putPeak(@PathVariable("id") UUID id, @RequestBody PutPeakRequest request);

    @PutMapping("/api/ranges/{rangeId}/peaks/{peakId}")
    @ResponseStatus(HttpStatus.CREATED)
    void putRangePeak(@PathVariable("rangeId") UUID rangeId, @PathVariable("peakId") UUID peakId, @RequestBody PutPeakRequest request);

    @DeleteMapping("/api/peaks/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deletePeak(@PathVariable("id") UUID id);
}
