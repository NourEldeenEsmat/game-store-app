package com.nour_esmat.game.store.game;

import com.nour_esmat.game.store.category.Category;
import com.nour_esmat.game.store.comment.Comment;
import com.nour_esmat.game.store.common.GeneraleClass;

import com.nour_esmat.game.store.platform.Platform;
import com.nour_esmat.game.store.wish_list.WishList;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
public class Game extends GeneraleClass {

    @Column(unique = true,nullable = false)
    private String title;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Platform> platforms;
    private String photoUrl;
    @ManyToOne
    private Category category;
    @OneToMany(mappedBy = "game")
    private List<Comment> comments;
    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinTable(
            name = "game_wishlist",
            joinColumns = {@JoinColumn(name = "game_id")},
            inverseJoinColumns = {@JoinColumn(name = "wishlist_id")}
    )
    private List<WishList> wishLists;

    public void addWishlist (WishList wishList){
        this.wishLists.add(wishList);
        wishList.getGames().add(this);
    }

    public void removeWishlist(WishList wishList){
        this.wishLists.remove(wishList);
        wishList.getGames().remove(this);
    }
}
