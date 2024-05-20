package ch.swisscom.assignment.featuretoggle;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

import ch.swisscom.assignment.featuretoggle.model.Feature;

@ExtendWith(MockitoExtension.class)
public class FeatureServiceTest {

    @Mock
    FeatureRepository repository;

    FeatureService featureService;

    @BeforeEach
    public void setup() {
        featureService = new FeatureService(repository);
    }

    @Test
    void getFeatures() {
        when(repository.findAll()).thenReturn(List.of(Feature.builder().build()));
        assertThat(featureService.getFeatures()).isEqualTo(List.of(Feature.builder().build()));
    }

    @ParameterizedTest
    @MethodSource("provide_testCalcIsActive")
    void testCalcIsActive(boolean isExpired, String customerId, boolean isInverted, boolean expectedActive) {
        Feature feature = FeatureMother.getFeature();
        feature.setInverted(isInverted);
        
        assertThat(featureService.calcIsFeatureActive(feature, customerId, isExpired)).isEqualTo(expectedActive);
    }

    private static Stream<Arguments> provide_testCalcIsActive() {
    return Stream.of(
        // Order: isExpired, customerId, isInverted, expectedActive
        Arguments.of(false, FeatureMother.customerId1, false, true),
        Arguments.of(false, FeatureMother.customerId1, true, false),
        
        Arguments.of(false, FeatureMother.customerIdNotIncluded, true, false),
        Arguments.of(false, FeatureMother.customerIdNotIncluded, false, false),

        Arguments.of(true, FeatureMother.customerId1, false, false),
        Arguments.of(true, FeatureMother.customerId1, true, false)
    );
    }
}
