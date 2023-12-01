package com.example.mountains.range.initialize;

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

    private final RangeService rangeService;

    @Autowired
    public InitializeData(RangeService rangeService){
        this.rangeService = rangeService;
    }
    @Override
    public void afterPropertiesSet() throws Exception {
        Range range1 = Range.builder().id(UUID.fromString("9ddbffa6-7c2d-11ee-b962-0242ac120002"))
                .name("Black Forest").length(160)
                .build();
        Range range2 = Range.builder().id(UUID.fromString("9ddc01f4-7c2d-11ee-b962-0242ac120002"))
                .name("Alps").length(1200)
                .build();
        Range range3 = Range.builder().id(UUID.fromString("9ddc0334-7c2d-11ee-b962-0242ac120002"))
                .name("Eifel").length(100)
                .build();

        rangeService.create(range1);
        rangeService.create(range2);
        rangeService.create(range3);
    }
}
