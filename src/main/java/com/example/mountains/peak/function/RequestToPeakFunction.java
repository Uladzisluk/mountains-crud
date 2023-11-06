package com.example.mountains.peak.function;

import com.example.mountains.peak.dto.PutPeakRequest;
import com.example.mountains.peak.entity.Peak;
import com.example.mountains.range.entity.Range;
import lombok.Builder;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.function.BiFunction;

@Component
public class RequestToPeakFunction implements BiFunction<UUID, PutPeakRequest, Peak> {
    @Override
    public Peak apply(UUID id, PutPeakRequest request){
        Peak newPeak =  Peak.builder()
                .id(id)
                .name(request.getName())
                .height(request.getHeight())
                .build();
        return newPeak;
    }
}
