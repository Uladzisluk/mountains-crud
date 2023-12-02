package com.example.mountains.range.controller.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

public interface RangeController {

    @DeleteMapping("/api/ranges/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteRange(
            @PathVariable("id")
            UUID id
    );
}
