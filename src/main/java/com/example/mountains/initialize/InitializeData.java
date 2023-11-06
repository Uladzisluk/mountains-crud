package com.example.mountains.initialize;

import com.example.mountains.peak.entity.Peak;
import com.example.mountains.peak.service.api.PeakService;
import com.example.mountains.range.entity.Range;
import com.example.mountains.range.service.api.RangeService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class InitializeData implements InitializingBean {

    private final PeakService peakService;
    private final RangeService rangeService;

    @Autowired
    public InitializeData(PeakService peakService, RangeService rangeService){
        this.peakService = peakService;
        this.rangeService = rangeService;
    }
    @Override
    public void afterPropertiesSet() throws Exception {
        Range range1 = Range.builder().id(UUID.fromString("9ddbffa6-7c2d-11ee-b962-0242ac120002"))
                .name("Black Forest").length(160).peaks(new ArrayList<>())
                .build();
        Range range2 = Range.builder().id(UUID.fromString("9ddc01f4-7c2d-11ee-b962-0242ac120002"))
                .name("Alps").length(1200).peaks(new ArrayList<>())
                .build();
        Range range3 = Range.builder().id(UUID.fromString("9ddc0334-7c2d-11ee-b962-0242ac120002"))
                .name("Eifel").length(100).peaks(new ArrayList<>())
                .build();

        rangeService.create(range1);
        rangeService.create(range2);
        rangeService.create(range3);

        peakService.create(Peak.builder().id(UUID.fromString("5064164a-7c2e-11ee-b962-0242ac120002"))
            .name("Feldberg").height(1493).range(range1).build());
        peakService.create(Peak.builder().id(UUID.fromString("5064191a-7c2e-11ee-b962-0242ac120002"))
                .name("Belchen").height(1414).range(range1).build());
        peakService.create(Peak.builder().id(UUID.fromString("50641a5a-7c2e-11ee-b962-0242ac120002"))
                .name("Herzogenhom").height(1415).range(range1).build());
        peakService.create(Peak.builder().id(UUID.fromString("50641b72-7c2e-11ee-b962-0242ac120002"))
                .name("Silbergberg").height(1358).range(range1).build());

        peakService.create(Peak.builder().id(UUID.fromString("a633f310-7c2e-11ee-b962-0242ac120002"))
                .name("Alphubel").height(4206).range(range2).build());
        peakService.create(Peak.builder().id(UUID.fromString("a633f61c-7c2e-11ee-b962-0242ac120002"))
                .name("Dom").height(4545).range(range2).build());
        peakService.create(Peak.builder().id(UUID.fromString("a633f928-7c2e-11ee-b962-0242ac120002"))
                .name("Breithom").height(4164).range(range2).build());
        peakService.create(Peak.builder().id(UUID.fromString("a633fd10-7c2e-11ee-b962-0242ac120002"))
                .name("Weissmies").height(4017).range(range2).build());

        peakService.create(Peak.builder().id(UUID.fromString("bf1c2708-7c2e-11ee-b962-0242ac120002"))
                .name("Radersberg").height(637).range(range3).build());
        peakService.create(Peak.builder().id(UUID.fromString("bf1c2942-7c2e-11ee-b962-0242ac120002"))
                .name("Botrange").height(694.24).range(range3).build());
        peakService.create(Peak.builder().id(UUID.fromString("bf1c2a46-7c2e-11ee-b962-0242ac120002"))
                .name("Steling").height(658.3).range(range3).build());
        peakService.create(Peak.builder().id(UUID.fromString("bf1c2eba-7c2e-11ee-b962-0242ac120002"))
                .name("Calmont").height(378.4).range(range3).build());
    }

    @SneakyThrows
    private byte[] getResourceAsByteArray(String name) {
        try (InputStream is = this.getClass().getResourceAsStream(name)) {
            return is.readAllBytes();
        }
    }
}
