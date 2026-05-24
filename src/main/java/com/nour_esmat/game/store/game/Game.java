package com.nour_esmat.game.store.game;

import com.nour_esmat.game.store.genral_class.GenralClass;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Game extends GenralClass {
    private String title;
    private SupportedPlatforms supportedPlatforms;
    private String photoUrl;
}
