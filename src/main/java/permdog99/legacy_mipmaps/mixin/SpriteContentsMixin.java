package permdog99.legacy_mipmaps.mixin;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import io.wispforest.owo.config.ConfigWrapper;
import io.wispforest.owo.config.Option;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.GameOptions;
import net.minecraft.client.texture.*;
import net.minecraft.resource.ResourcePackManager;
import net.minecraft.resource.ResourcePackProfile;
import net.minecraft.util.crash.CrashException;
import net.minecraft.util.crash.CrashReport;
import org.spongepowered.asm.mixin.*;
import permdog99.legacy_mipmaps.LegacyMipmapHelper;
import permdog99.legacy_mipmaps.LegacyMipmaps;
import permdog99.legacy_mipmaps.MipmapOptions;
import permdog99.legacy_mipmaps.MipmapOptionsWrapper;

import java.util.List;
import java.util.Map;

@Environment(EnvType.CLIENT)
@Mixin(SpriteContents.class)
public class SpriteContentsMixin {
    @Shadow
    NativeImage[] mipmapLevelsImages;
    @Unique
    private final MipmapOptions mipmapOptions;

    @Unique
    private List<ResourcePackProfile> enabled = ImmutableList.of();

    @Unique
    private Map<String, ResourcePackProfile> profiles = ImmutableMap.of();

    public SpriteContentsMixin(MipmapOptions mipmapOptions) {
        this.mipmapOptions = mipmapOptions;
    }

    /**
     * @author
     * Permdog99
     * @reason
     * For legacy looking mipmaps
     */
    @Overwrite
    public void generateMipmaps(int mipmapLevels) {
        try {
            if (LegacyMipmaps.CONFIG.mipmapType() == MipmapOptions.MipmapChoices.TU5Plus) {
                this.mipmapLevelsImages = LegacyMipmapHelper.getMipmapTU5Plus(this.mipmapLevelsImages, mipmapLevels);
            } else if (LegacyMipmaps.CONFIG.mipmapType() == MipmapOptions.MipmapChoices.TU0toTU2) {
                this.mipmapLevelsImages = LegacyMipmapHelper.getMipmapTU0toTU2(this.mipmapLevelsImages, mipmapLevels);
            } else {
                this.mipmapLevelsImages = LegacyMipmapHelper.getMipmapJava(this.mipmapLevelsImages, mipmapLevels);
            }
        } catch (Throwable var6) {
            CrashReport crashReport = CrashReport.create(var6, "Generating mipmaps for frame");
            throw new CrashException(crashReport);
        }
    }
}
