package com.example.mountains.peak.entity;

import com.example.mountains.range.entity.Range;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class Peak implements Comparable<Peak>, Serializable {
    @Id
    private UUID id;
    String name;
    double height;
    @ManyToOne
    @EqualsAndHashCode.Exclude
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
