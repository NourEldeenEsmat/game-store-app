package com.nour_esmat.game.store.comment;

import com.nour_esmat.game.store.game.Game;
import com.nour_esmat.game.store.genral_class.GeneraleClass;

import com.nour_esmat.game.store.user.User;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Comment extends GeneraleClass {
    private String comment;
    @ManyToOne
    private Game game;
    @ManyToOne
    private User user;
}
