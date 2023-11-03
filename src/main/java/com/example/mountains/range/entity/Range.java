package com.example.mountains.range.entity;

import com.example.mountains.peak.entity.Peak;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class Range implements Comparable<Range>, Serializable {
    @Id
    private UUID id;
    String name;
    int length;
    @OneToMany(mappedBy = "range")
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
