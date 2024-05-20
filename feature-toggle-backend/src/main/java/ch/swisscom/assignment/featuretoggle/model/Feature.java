package ch.swisscom.assignment.featuretoggle.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
public class Feature {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    // TODO implement version
    // @Version
    // private Long version;

    private String displayName;
    private String technicalName;
    private String description;
    private List<String> customerIds;
    private LocalDateTime expiresOn;
    private boolean inverted;
    private boolean archived;
}
