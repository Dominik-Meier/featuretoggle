package ch.swisscom.assignment.featuretoggle;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.swisscom.assignment.featuretoggle.model.Feature;

public interface FeatureRepository extends JpaRepository<Feature, UUID> {
    List<Feature> findAllByIdIn(List<UUID> ids);

    // TODO archived should have a function
}
