package com.nour_esmat.game.store.platform;

import com.nour_esmat.game.store.game.Game;
import com.nour_esmat.game.store.common.GeneraleClass;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Platform extends GeneraleClass {
    @Enumerated(EnumType.STRING)
    private Console console;
    @ManyToMany(mappedBy = "platforms")
    private Set<Game> games;
}
