package com.nour_esmat.game.store.comment;

import com.nour_esmat.game.store.genral_class.GenralClass;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Comment extends GenralClass {
    private String comment;
}
