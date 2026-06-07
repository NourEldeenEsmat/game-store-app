package com.nour_esmat.game.store.game;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepo extends JpaRepository<Game,String> {
    boolean existsByTitle(String name);
}
