package com.nour_esmat.game.store.comment;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepo extends JpaRepository<Comment,String> {
    long countByGameId(String gameId);
}
