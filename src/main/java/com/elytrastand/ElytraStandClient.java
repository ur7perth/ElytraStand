package com.elytrastand;

import net.fabricmc.api.ClientModInitializer;

public final class ElytraStandClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        System.out.println("[ElytraStand] Loaded successfully.");
    }
}
