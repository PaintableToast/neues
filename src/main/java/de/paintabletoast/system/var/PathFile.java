package de.paintabletoast.system.var;

public enum PathFile {
    MESSAGE,
    CONFIG,
    PERMISSION,
    SOUNDS,
    SETTINGS,

    ARGUMENTS,
    GENERAL,
    CONSOLE,
    USER;
    public String getPath() {
        return this.toString() + ".";
    }
    public String getBeforePath() {
        return  "." + this.toString();
    }
}
