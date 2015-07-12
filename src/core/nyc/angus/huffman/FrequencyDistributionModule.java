
package nyc.angus.huffman;

import dagger.Module;
import dagger.Provides;
import nyc.angus.huffman.distribution.FrequencyDistribution;
import nyc.angus.huffman.sort.FrequencySorter;

/**
 * Module for injecting {@link FrequencyDistribution} and {@link FrequencySorter} objects.
 */
@Module
public class FrequencyDistributionModule {
	@Provides
	FrequencyDistribution provideFrequencyDistribution() {
		return new FrequencyDistribution();
	}

	@Provides
	FrequencySorter provideFrequencySorter() {
		return new FrequencySorter();
	}
}
