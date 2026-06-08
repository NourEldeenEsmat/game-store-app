package com.nour_esmat.game.store.game;

import com.nour_esmat.game.store.category.Category;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;
@Service
public class GameMapper {
    public Game toGame(GameRequest game) {
        return Game.builder()
                .title(game.name())
                .category(Category.builder().id(game.categoryId()).build())
                .build();
    }

    public static GameResponse toGameResponse(Game game) {
        return GameResponse.builder()
                .id(game.getId())
                .imageUrl("fix later")
                .name(game.getTitle())
                .platforms(game.getPlatforms().stream().map(p -> p.getConsole().name())
                                .collect(Collectors.toSet()))
                .build();
    }
}

