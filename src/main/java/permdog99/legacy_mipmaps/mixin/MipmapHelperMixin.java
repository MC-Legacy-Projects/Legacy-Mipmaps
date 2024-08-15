package permdog99.legacy_mipmaps.mixin;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.texture.MipmapHelper;
import net.minecraft.client.texture.NativeImage;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import permdog99.legacy_mipmaps.LegacyMipmapHelper;
import permdog99.legacy_mipmaps.LegacyMipmaps;
import permdog99.legacy_mipmaps.MipmapOptions;

@Environment(EnvType.CLIENT)
@Mixin(MipmapHelper.class)
public class MipmapHelperMixin {

    /**
     * @author
     * Permdog99
     * @reason
     * Change mipmapping
     */
    @Overwrite
    public static NativeImage[] getMipmapLevelsImages(NativeImage[] originals, int mipmap) {
        if (LegacyMipmaps.CONFIG.mipmapType() == MipmapOptions.MipmapChoices.TU12Plus) {
            return LegacyMipmapHelper.getMipmapTU12Plus(originals, mipmap);
        } else if (LegacyMipmaps.CONFIG.mipmapType() == MipmapOptions.MipmapChoices.TU0toTU2) {
            return LegacyMipmapHelper.getMipmapTU0toTU2(originals, mipmap);
        }else if (LegacyMipmaps.CONFIG.mipmapType() == MipmapOptions.MipmapChoices.TU3toTU11) {
            return LegacyMipmapHelper.getMipmapTU3toTU11(originals, mipmap);
        } else {
            return LegacyMipmapHelper.getMipmapJava(originals, mipmap);
        }
    }
}
