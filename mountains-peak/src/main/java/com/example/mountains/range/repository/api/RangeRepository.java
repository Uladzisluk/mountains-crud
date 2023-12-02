package com.example.mountains.range.repository.api;

import com.example.mountains.range.entity.Range;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface RangeRepository extends JpaRepository<Range, UUID> {
}
