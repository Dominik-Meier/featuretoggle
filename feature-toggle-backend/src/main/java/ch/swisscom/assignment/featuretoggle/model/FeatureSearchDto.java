package ch.swisscom.assignment.featuretoggle.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class FeatureSearchDto {
    private String name;
    private boolean active;
    private boolean inverted;
    private boolean expired;
}
