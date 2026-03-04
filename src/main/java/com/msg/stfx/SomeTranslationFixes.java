package com.msg.stfx;


import net.fabricmc.api.ModInitializer;
import net.legacyfabric.fabric.api.logger.v1.Logger;

public class SomeTranslationFixes implements ModInitializer {

    public static final String NAME = "Some Translation Fixes";
    public static final Logger LOG = Logger.get(NAME);

	@Override
	public void onInitialize() {
		LOG.info(NAME + " Initializing...");
	}
    // @Override
    // public void initialize() {
    //     AddonHandler.logMessage(this.getName() + " Version " + this.getVersionString() + " Initializing...");
    // }
}