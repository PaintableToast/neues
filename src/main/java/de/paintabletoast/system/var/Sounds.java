package de.paintabletoast.system.var;// This class was created by PaintableToast

import org.bukkit.Sound;

public enum Sounds {
    NO_PERMISSION,
    WRONG_ARGS,
    ;
    public final Sound getSound() {
        return org.bukkit.Sound.valueOf(ConfigFile.SOUNDS.getConfig().getString(PathFile.SOUNDS.getPath() + this.name().toUpperCase()));
    }
}
