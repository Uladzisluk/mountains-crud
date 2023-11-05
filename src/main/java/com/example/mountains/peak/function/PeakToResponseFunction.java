package com.example.mountains.peak.function;

import com.example.mountains.peak.dto.GetPeakResponse;
import com.example.mountains.peak.entity.Peak;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class PeakToResponseFunction implements Function<Peak, GetPeakResponse> {
    @Override
    public GetPeakResponse apply(Peak peak){
        return GetPeakResponse.builder()
                .id(peak.getId())
                .name(peak.getName())
                .height(peak.getHeight())
                .range(peak.getRange().getName())
                .build();
    }
}
