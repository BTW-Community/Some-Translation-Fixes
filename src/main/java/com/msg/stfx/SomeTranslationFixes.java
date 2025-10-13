package com.msg.stfx;

import btw.AddonHandler;
import btw.BTWAddon;

public class SomeTranslationFixes extends BTWAddon {
    private static SomeTranslationFixes instance;

    public SomeTranslationFixes() {
        super();
    }

    @Override
    public void initialize() {
        AddonHandler.logMessage(this.getName() + " Version " + this.getVersionString() + " Initializing...");
    }
}