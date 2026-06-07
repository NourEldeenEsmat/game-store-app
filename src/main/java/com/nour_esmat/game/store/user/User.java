package com.nour_esmat.game.store.user;

import com.nour_esmat.game.store.comment.Comment;
import com.nour_esmat.game.store.game_request.GameRequest;
import com.nour_esmat.game.store.common.GeneraleClass;

import com.nour_esmat.game.store.notification.Notification;
import com.nour_esmat.game.store.wish_list.WishList;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User extends GeneraleClass {
    private String name;
    private String email;
    @OneToOne(mappedBy = "user")
    private WishList wishList;
    @OneToMany(mappedBy = "user")
    private List<Notification> notifications;
    @OneToMany(mappedBy = "user")
    private List<GameRequest> gameRequests;
    @OneToMany(mappedBy = "user")
    private List<Comment> comments;
}
