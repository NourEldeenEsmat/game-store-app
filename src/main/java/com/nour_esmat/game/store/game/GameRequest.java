package com.nour_esmat.game.store.game;

import java.util.Set;

public record GameRequest(
        String name,
        String categoryId,
        Set<String> platformSet
) {

}
