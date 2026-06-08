package com.nour_esmat.game.store.platform;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Set;

public interface PlatformRepo extends JpaRepository<Platform,String> {

    @Query("""
            select p from Platform p
            where p.console in :consoles
            """)
    Set<Platform> findAllByConsoleIn(@Param("consoles") Set<Console> selectedConsole);
}
