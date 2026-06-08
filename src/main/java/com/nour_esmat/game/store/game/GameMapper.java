package com.nour_esmat.game.store.game;

import com.nour_esmat.game.store.category.Category;

public class GameMapper {
    public Game toGame(RequestedGame game) {
        return Game.builder()
                .title(game.name())
                .category(Category.builder().id(game.categoryId()).build())
                .build();    }
}

