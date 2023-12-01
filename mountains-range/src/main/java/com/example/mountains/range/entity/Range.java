package com.example.mountains.range.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "ranges")
public class Range implements Comparable<Range>, Serializable {
    @Id
    private UUID id;
    String name;
    int length;

    @Override
    public String toString(){
        StringBuilder result = new StringBuilder("Range name: " + name + ", lenght: " + length + " km, peaks:\n");
        return result.toString();
    }

    @Override
    public int compareTo(Range o) {
        return name.compareTo(o.getName());
    }
}
