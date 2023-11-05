package com.example.mountains.peak.function;

import com.example.mountains.peak.dto.PutPeakRequest;
import com.example.mountains.peak.entity.Peak;
import com.example.mountains.range.entity.Range;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.function.BiFunction;

@Component
public class RequestToPeakFunction implements TriFunction<UUID, Range, PutPeakRequest, Peak> {
    @Override
    public Peak apply(UUID id, Range range, PutPeakRequest request){
        Peak newPeak =  Peak.builder()
                .id(id)
                .name(request.getName())
                .height(request.getHeight())
                .range(range)
                .build();
        range.getPeaks().add(newPeak);
        return newPeak;
    }
}
