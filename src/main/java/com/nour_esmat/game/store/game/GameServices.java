package com.nour_esmat.game.store.game;

import com.nour_esmat.game.store.category.CategoryRepository;
import com.nour_esmat.game.store.common.PageResponse;
import com.nour_esmat.game.store.platform.Console;
import com.nour_esmat.game.store.platform.Platform;
import com.nour_esmat.game.store.platform.PlatformRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GameServices {
    private final GameRepo gameRepo;
    private final GameMapper gameMapper;
    private final PlatformRepo platformRepo;

    private final CategoryRepository categoryRepository;

    public String addGame(RequestedGame game) {
        if (gameRepo.existsByTitle(game.name()))
            throw new RuntimeException("the game already exist");

        final Set<Platform> platformSet = new HashSet<>();
        final Set<Console> selectedConsole =
                game.platformSet().stream().map(Console::valueOf)
                        .collect(Collectors.toSet());
        platformRepo.findAllByConsoleIn(selectedConsole);
        if (!categoryRepository.existsById(game.categoryId())){
            throw new RuntimeException("the game category is not exist");
        }
        Game newGame = gameMapper.toGame(game);
        newGame.setPlatforms(platformSet);
        Game savedGame = gameRepo.save(newGame);
        return savedGame.getId();
    }

    public void updateGame(String id, RequestedGame game) {

    }

    public String uploadGameCoverImg(MultipartFile file, String gameId) {
        return null;
    }

    public PageResponse<GameResponse> findAllGames() {
        return null;
    }
}
