package permdog99.legacy_mipmaps;

import blue.endless.jankson.Jankson;
import io.wispforest.owo.config.ConfigWrapper;
import io.wispforest.owo.config.Option;
import io.wispforest.owo.util.Observable;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class MipmapOptionsWrapper extends ConfigWrapper<permdog99.legacy_mipmaps.MipmapOptions> {

    public final Keys keys = new Keys();

    private final Option<permdog99.legacy_mipmaps.MipmapOptions.MipmapChoices> mipmapType = this.optionForKey(this.keys.mipmapType);

    private MipmapOptionsWrapper() {
        super(permdog99.legacy_mipmaps.MipmapOptions.class);
    }

    private MipmapOptionsWrapper(Consumer<Jankson.Builder> janksonBuilder) {
        super(permdog99.legacy_mipmaps.MipmapOptions.class, janksonBuilder);
    }

    public static MipmapOptionsWrapper createAndLoad() {
        var wrapper = new MipmapOptionsWrapper();
        wrapper.load();
        return wrapper;
    }

    public static MipmapOptionsWrapper createAndLoad(Consumer<Jankson.Builder> janksonBuilder) {
        var wrapper = new MipmapOptionsWrapper(janksonBuilder);
        wrapper.load();
        return wrapper;
    }

    public permdog99.legacy_mipmaps.MipmapOptions.MipmapChoices mipmapType() {
        return mipmapType.value();
    }

    public void mipmapType(permdog99.legacy_mipmaps.MipmapOptions.MipmapChoices value) {
        mipmapType.set(value);
    }


    public static class Keys {
        public final Option.Key mipmapType = new Option.Key("mipmapType");
    }
}

