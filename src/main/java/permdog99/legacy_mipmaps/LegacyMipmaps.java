package permdog99.legacy_mipmaps;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LegacyMipmaps implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("legacy-mipmaps");
	@Override
	public void onInitialize() {
		LOGGER.info("Legacy Mipmaps Enabled!");
	}
}