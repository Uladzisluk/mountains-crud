package com.example.mountains.peak.function;

import com.example.mountains.peak.dto.PatchPeakRequest;
import com.example.mountains.peak.entity.Peak;

import java.util.function.BiFunction;

public class UpdatePeakWithRequestFunction implements BiFunction<Peak, PatchPeakRequest, Peak> {
    @Override
    public Peak apply(Peak peak, PatchPeakRequest request){
        Peak newPeak =  Peak.builder()
                .id(peak.getId())
                .name(request.getName())
                .height(request.getHeight())
                .range(peak.getRange())
                .build();
        peak.getRange().getPeaks().add(newPeak);
        peak.getRange().getPeaks().remove(peak);
        return newPeak;
    }
}
