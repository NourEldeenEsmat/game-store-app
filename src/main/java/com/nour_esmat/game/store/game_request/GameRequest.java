package com.nour_esmat.game.store.game_request;

import com.nour_esmat.game.store.genral_class.GenralClass;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class GameRequest extends GenralClass {
    private String title;
    private Status status;
}
