package com.nour_esmat.game.store.game;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GameResponse {
    private String id;
    private String name;
    private Set<String> platforms;
    private String imageUrl;
}
