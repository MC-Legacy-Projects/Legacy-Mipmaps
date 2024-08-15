package permdog99.legacy_mipmaps.mixin;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.texture.*;
import net.minecraft.resource.ResourcePackProfile;
import net.minecraft.util.crash.CrashException;
import net.minecraft.util.crash.CrashReport;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import permdog99.legacy_mipmaps.LegacyMipmapHelper;
import permdog99.legacy_mipmaps.LegacyMipmaps;
import permdog99.legacy_mipmaps.MipmapOptions;

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



    @Unique
    public NativeImage[] changeMipmapGeneration(int mipmapLevels) {
        if (LegacyMipmaps.CONFIG.mipmapType() == MipmapOptions.MipmapChoices.TU12Plus) {
            return LegacyMipmapHelper.getMipmapTU12Plus(this.mipmapLevelsImages, mipmapLevels);
        } else if (LegacyMipmaps.CONFIG.mipmapType() == MipmapOptions.MipmapChoices.TU0toTU2) {
            return LegacyMipmapHelper.getMipmapTU0toTU2(this.mipmapLevelsImages, mipmapLevels);
        }else if (LegacyMipmaps.CONFIG.mipmapType() == MipmapOptions.MipmapChoices.TU3toTU11) {
            return LegacyMipmapHelper.getMipmapTU3toTU11(this.mipmapLevelsImages, mipmapLevels);
        } else {
            return LegacyMipmapHelper.getMipmapJava(this.mipmapLevelsImages, mipmapLevels);
        }
    }
}
