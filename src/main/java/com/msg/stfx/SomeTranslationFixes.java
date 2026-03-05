package com.msg.stfx;

import api.AddonHandler;
import api.BTWAddon;

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