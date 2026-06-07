package com.nour_esmat.game.store.notification;

import com.nour_esmat.game.store.common.GeneraleClass;

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
public class Notification extends GeneraleClass {
    private String message;
    private String receiver;
    private Level level;
    private Status status;
    @ManyToOne
    private User user;
}
