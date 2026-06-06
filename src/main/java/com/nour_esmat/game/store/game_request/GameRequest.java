package com.nour_esmat.game.store.game_request;

import com.nour_esmat.game.store.genral_class.GeneraleClass;

import com.nour_esmat.game.store.user.User;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class GameRequest extends GeneraleClass {
    private String title;
    private Status status;
    @ManyToOne
    private User user;
}
