package ch.swisscom.assignment.featuretoggle;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ch.swisscom.assignment.featuretoggle.model.Feature;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
@Transactional
public class FeatureService {

    private final FeatureRepository repository;

    public Feature getFeature(UUID id) {
        // TODO handle exception of get()
        return repository.findById(id).get();
    }

    public List<Feature> getFeatures() {
        return repository.findAll();
    }

    public List<Feature> getFeaturesForCustomer(List<UUID> featureIds) {
        return repository.findAllByIdIn(featureIds);
    }

    public Feature saveFeature(Feature feature) {
        return repository.save(feature);
    } 

    public Feature updateFeature(Feature feature) {
        return saveFeature(feature);
    }

    public Feature archiveFeature(UUID featureId) {
        Feature existingFeature = getFeature(featureId);
        existingFeature.setArchived(true);
        return saveFeature(existingFeature);
    }

    public boolean calcIsFeatureActive(Feature feature, String customerId, boolean isExpired) {
        boolean containsCustomerId = feature.getCustomerIds().contains(customerId);
        boolean isInverted = feature.isInverted();

        return !isExpired && containsCustomerId ? !isInverted : false;
    }
}
