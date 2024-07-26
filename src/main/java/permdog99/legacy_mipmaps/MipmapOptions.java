package permdog99.legacy_mipmaps;

import io.wispforest.owo.config.annotation.Config;
import io.wispforest.owo.config.annotation.Modmenu;
import io.wispforest.owo.config.annotation.RestartRequired;

@Modmenu(modId = "legacy-mipmaps")
@Config(name = "legacy-mipmaps", wrapperName = "MipmapOptionsWrapper", saveOnModification = true)
public class MipmapOptions {

    @RestartRequired
    public MipmapChoices mipmapType = MipmapChoices.TU5Plus;

    public enum MipmapChoices {
        TU5Plus, TU0toTU2, Java
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
