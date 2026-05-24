package com.nour_esmat.game.store.notification;

import com.nour_esmat.game.store.genral_class.GenralClass;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Notification extends GenralClass {
    private String message;
    private String recever;
    private Level level;
    private Status status;
}
