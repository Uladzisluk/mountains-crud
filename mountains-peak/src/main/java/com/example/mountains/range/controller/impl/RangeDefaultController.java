package com.example.mountains.range.controller.impl;

import com.example.mountains.range.controller.api.RangeController;
import com.example.mountains.range.service.api.RangeService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@RestController
@Log
public class RangeDefaultController implements RangeController {

    private final RangeService service;
    @Autowired
    public RangeDefaultController(RangeService service){
        this.service = service;
    }
    @Override
    public void deleteRange(UUID id) {
        service.find(id)
                .ifPresentOrElse(
                        range -> service.delete(id),
                        () -> {
                            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                        }
                );
    }
}
