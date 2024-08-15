package permdog99.legacy_mipmaps;

import io.wispforest.owo.config.annotation.Config;
import io.wispforest.owo.config.annotation.Modmenu;
import io.wispforest.owo.config.annotation.RestartRequired;

@Modmenu(modId = "legacy-mipmaps")
@Config(name = "legacy-mipmaps", wrapperName = "MipmapOptionsWrapper", saveOnModification = true)
public class MipmapOptions {

    @RestartRequired
    public MipmapChoices mipmapType = MipmapChoices.TU12Plus;

    public enum MipmapChoices {
        TU0toTU2, TU3toTU11, TU12Plus, Java
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
