package com.nour_esmat.game.store.category;

import com.nour_esmat.game.store.game.Game;
import com.nour_esmat.game.store.common.GeneraleClass;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
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
public class Category extends GeneraleClass {
    private String name;
    @OneToMany(mappedBy = "category")
    private List<Game> game;
}
