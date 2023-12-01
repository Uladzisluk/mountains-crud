package com.example.mountains.range.entity;

import com.example.mountains.peak.entity.Peak;
import jakarta.persistence.*;
import lombok.*;

import jakarta.persistence.Table;

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
    @OneToMany(mappedBy = "range", cascade = CascadeType.REMOVE)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    List<Peak> peaks;

    @Override
    public String toString(){
        StringBuilder result = new StringBuilder("Range name: " + name + ", lenght: " + length + " km, peaks:\n");
        for (Peak peak: peaks){
            result.append(peak).append("\n");
        }
        return result.toString();
    }

    @Override
    public int compareTo(Range o) {
        return name.compareTo(o.getName());
    }
}
