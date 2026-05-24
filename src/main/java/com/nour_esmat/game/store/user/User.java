package com.nour_esmat.game.store.user;

import com.nour_esmat.game.store.genral_class.GenralClass;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User extends GenralClass {
    private String name;
    private String email;
}
