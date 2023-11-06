package com.example.mountains.peak.entity;

import com.example.mountains.range.entity.Range;
import jakarta.persistence.Table;
import lombok.*;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
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
