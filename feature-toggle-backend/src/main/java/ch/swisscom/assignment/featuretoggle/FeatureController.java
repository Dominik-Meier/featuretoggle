package ch.swisscom.assignment.featuretoggle;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.swisscom.assignment.featuretoggle.model.Feature;
import ch.swisscom.assignment.featuretoggle.model.FeatureRequest;
import ch.swisscom.assignment.featuretoggle.model.FeatureSearchDto;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/features")
public class FeatureController {

    private final FeatureService service;

    @CrossOrigin(origins = "*")
    @GetMapping
    public List<Feature> getFeatures() {
        return service.getFeatures();
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/search")
    public List<FeatureSearchDto> searchFeatures(@RequestBody FeatureRequest featureRequest) {
        List<Feature> featuresForCustomer = service.getFeaturesForCustomer(featureRequest.getFeatureIds());
        return featuresForCustomer.stream()
        .map(f -> mapFeatureToFeatureSearchDto(f, featureRequest.getCustomerId()))
        .toList();
    }

    @CrossOrigin(origins = "*")
    @PostMapping
    public Feature saveFeature(@RequestBody Feature feature) {
        return service.saveFeature(feature);
    }

    @CrossOrigin(origins = "*")
    @PutMapping("/{id}")
    public Feature saveFeature(@PathVariable UUID id, @RequestBody Feature feature) {
        if(!feature.getId().equals(id)) {
            // TODO handle error
            return null;
        }
    
        return service.updateFeature(feature);
    }

    @CrossOrigin(origins = "*")
    @PutMapping("/{id}/archived")
    public Feature archiveFeature(@PathVariable UUID id) {
   
        return service.archiveFeature(id);
    }

    // TODO move into maper class or us a mapper (like mapstruct)
    private FeatureSearchDto mapFeatureToFeatureSearchDto(Feature feature, String customerId) {
    boolean isExpired = LocalDateTime.now().isAfter(feature.getExpiresOn());

    return FeatureSearchDto.builder()
    .name(feature.getDisplayName())
    .active(service.calcIsFeatureActive(feature, customerId, isExpired))
    .inverted(feature.isInverted())
    .expired(isExpired)
    .build();
    }
}
