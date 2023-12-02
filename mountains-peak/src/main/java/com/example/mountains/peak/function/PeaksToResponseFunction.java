package com.example.mountains.peak.function;

import com.example.mountains.peak.dto.GetPeaksResponse;
import com.example.mountains.peak.entity.Peak;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;

@Component
public class PeaksToResponseFunction implements Function<List<Peak>, GetPeaksResponse> {
    @Override
    public GetPeaksResponse apply(List<Peak> peaks){
        return GetPeaksResponse.builder()
                .peaks(peaks.stream()
                        .map(peak -> GetPeaksResponse.Peak.builder()
                                .id(peak.getId())
                                .name(peak.getName())
                                .height(peak.getHeight())
                                .range(peak.getRange() == null ? "" : peak.getRange().getName())
                                .build())
                        .toList())
                .build();
    }
}
