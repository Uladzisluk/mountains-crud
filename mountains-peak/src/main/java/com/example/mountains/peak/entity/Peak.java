package com.example.mountains.peak.entity;

import com.example.mountains.range.entity.Range;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "peaks")
public class Peak implements Comparable<Peak>, Serializable {
    @Id
    private UUID id;
    String name;
    double height;
    @ManyToOne
    @JoinColumn(name = "range_name")
    Range range;

    @Override
    public String toString(){
        return "Peak name: " + name + ", height: " + height + " m";
    }

    @Override
    public int compareTo(Peak o) {
        return Double.compare(height, o.height);
    }
}
