package com.nour_esmat.game.store.wish_list;

import com.nour_esmat.game.store.game.Game;
import com.nour_esmat.game.store.genral_class.GeneraleClass;
import com.nour_esmat.game.store.user.User;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class WishList extends GeneraleClass {
    private String name;
    @OneToOne
    private User user;
    @ManyToMany(mappedBy = "wishLists",fetch = FetchType.EAGER)
    private List<Game> games;
}
