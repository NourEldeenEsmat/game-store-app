package com.nour_esmat.game.store.wish_list;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface wishListRepository extends JpaRepository<WishList, String> {
    @Query("""
            select count(w)
            from WishList w
            join w.games g
            where g.id = :gameId
            """)
    long countByGameId(@Param("gameId") String gameId);

}
