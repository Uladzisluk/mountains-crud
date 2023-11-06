package com.example.mountains.peak.controller.api;

import com.example.mountains.peak.dto.GetPeakResponse;
import com.example.mountains.peak.dto.GetPeaksResponse;
import com.example.mountains.peak.dto.PutPeakRequest;
import com.example.mountains.range.entity.Range;

import java.util.UUID;

public interface PeakController {

    GetPeaksResponse getPeaks();
    GetPeakResponse getPeak(UUID id);
    void putPeak(UUID id, PutPeakRequest request);
    void deletePeak(UUID id);
}
