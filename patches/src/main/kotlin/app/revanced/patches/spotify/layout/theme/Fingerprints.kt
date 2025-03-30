package app.revanced.patches.spotify.layout.theme

import app.revanced.patcher.fingerprint
import app.revanced.util.containsLiteralInstruction
import com.android.tools.smali.dexlib2.AccessFlags

internal const val PLAYLIST_BACKGROUND_COLOR_LITERAL = 0xFF121212
internal const val SHARE_MENU_BACKGROUND_COLOR_LITERAL = 0xFF1F1F1F

internal val encoreThemeFingerprint = fingerprint {
    strings("Encore theme was not provided. Please wrap your content with ProvideEncoreTheme. For @Previews use com.spotify.encore.tooling.preview.EncorePreview()")
}

internal const val HOME_CATEGORY_PILL_COLOR_LITERAL = 0xFF333333

internal val homeCategoryPillColorsFingerprint = fingerprint{
    accessFlags(AccessFlags.STATIC, AccessFlags.CONSTRUCTOR)
    custom { method, _ ->
        method.containsLiteralInstruction(0x33000000)
                && method.containsLiteralInstruction(HOME_CATEGORY_PILL_COLOR_LITERAL)
    }
}

internal const val SETTINGS_HEADER_COLOR_LITERAL = 0xFF282828

internal val settingsHeaderColorFingerprint = fingerprint {
    accessFlags(AccessFlags.STATIC, AccessFlags.CONSTRUCTOR)
    custom { method, _ ->
        method.containsLiteralInstruction(9)
                && method.containsLiteralInstruction(SETTINGS_HEADER_COLOR_LITERAL)
    }
}
