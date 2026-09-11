package com.genocraft.gibble.entity.client;

import com.genocraft.gibble.entity.entity.ModEntities;

public class ModEntityRenderer {
    public static void register() {
        GibbleRenderer.register(
                ModEntities.GIBBLE.GibbleRenderer::new
        );
    }
}
