package com.nour_esmat.game.store.game;

import com.nour_esmat.game.store.category.CategoryRepository;
import com.nour_esmat.game.store.comment.CommentRepo;
import com.nour_esmat.game.store.common.PageResponse;
import com.nour_esmat.game.store.platform.Console;
import com.nour_esmat.game.store.platform.Platform;
import com.nour_esmat.game.store.platform.PlatformRepo;
import com.nour_esmat.game.store.wish_list.wishListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GameServices {
    private final GameRepo gameRepo;
    private final GameMapper gameMapper;
    private final PlatformRepo platformRepo;
    private final CommentRepo commentRepo;
    private final CategoryRepository categoryRepository;
    private final wishListRepository wishListRepository;

    public String addGame(GameRequest gameRequest) {
        // todo handel exceptions
        if (gameRepo.existsByTitle(gameRequest.name()))
            throw new RuntimeException("the gameRequest already exist");
        if (!categoryRepository.existsById(gameRequest.categoryId())) {
            throw new RuntimeException("the gameRequest category is not exist");
        }
        // todo get gameRequest platforms from database and check if they are valid
        final Set<Console> selectedConsoles =
                gameRequest.platformSet().stream().map(Console::valueOf)
                        .collect(Collectors.toSet());
        final Set<Platform> platforms = platformRepo.findAllByConsoleIn(selectedConsoles);
        if (platforms.size() != selectedConsoles.size()) {
            // todo dedicated exception
            throw new RuntimeException("One or more platforms are not supported");
        }
        // todo Map Game Request To a Game Entity and set platforms to it and save it
        Game game = gameMapper.toGame(gameRequest);
        game.setPlatforms(platforms);
        Game savedGame = gameRepo.save(game);
        return savedGame.getId();
    }

    public void updateGame(String id, GameRequest gameRequest) {
        Game game = gameRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("gameRequest not found"));
        // todo handel exceptions
        if (!game.getTitle().equals(gameRequest.name())
                && gameRepo.existsByTitle(gameRequest.name())) {
            throw new RuntimeException("the gameRequest already exist");
        }
        //todo bring newPlatforms from database
        final Set<Console> selectedConsole =
                gameRequest.platformSet().stream().map(Console::valueOf)
                        .collect(Collectors.toSet());
        Set<Platform> platforms = platformRepo.findAllByConsoleIn(selectedConsole);
        List<String> platformIds = platforms.stream().map(Platform::getId).toList();
        List<Platform> newPlatforms = platformRepo.findAllById(platformIds);
        //todo bring currentPlatforms from game
        Set<Platform> currentPlatforms = game.getPlatforms();
        // todo edit game platforms
        List<Platform> platformsToAdd = new ArrayList<>(newPlatforms);
        platformsToAdd.remove(currentPlatforms);
        List<Platform> platformsToRemove = new ArrayList<>(currentPlatforms);
        platformsToRemove.remove(newPlatforms);
        for (Platform platform : platformsToAdd) {
            game.addPlatform(platform);
        }
        for (Platform platform : platformsToRemove) {
            game.deletePlatform(platform);
        }
        // todo edit last parameter and save the game
        game.setTitle(gameRequest.name());
        gameRepo.save(game);
    }

    public PageResponse<GameResponse> findAllGames(int page, int size) {
        //todo get a pageable object with specific page and size
        Pageable pageable = PageRequest.of(page, size);
        //todo get a game page with pageable object from database
        Page<Game> gamesPage = gameRepo.findAll(pageable);
        //todo transfer gamesPage to list of game responses
        List<GameResponse> gameResponses = gamesPage
                .stream().map(GameMapper::toGameResponse).toList();
        //todo create and return PageResponse
        return PageResponse.<GameResponse>builder()
                .content(gameResponses)
                .number(gamesPage.getNumber())
                .size(gamesPage.getSize())
                .totalElements(gamesPage.getTotalElements())
                .totalPages(gamesPage.getTotalPages())
                .isLast(gamesPage.isLast())
                .isFirst(gamesPage.isFirst())
                .build();
    }

    public void deleteGame(String gameId, boolean confirm){
        long commentsCount = commentRepo.countByGameId(gameId);
        long wishListCount = wishListRepository.countByGameId(gameId);


        final List<String> warnings = new ArrayList<>();

        if (commentsCount > 0) {
            warnings.add("Comment count is greater than 0");
            System.out.println("The current game has comments: " + commentsCount);
        }
        if (wishListCount > 0) {
            warnings.add("Wish list count is greater than 0");
            System.out.println("The current game has wishlist: " + wishListCount);
        }

        if (warnings.size() > 0 && !confirm) {
            // todo add a custom exp
            throw new RuntimeException("One or more warnings");
        }

        gameRepo.deleteById(gameId);

        // todo I would like you to show me how you would remove the game from the wishlists


    }

    public String uploadGameCoverImg(MultipartFile file, String gameId) {
        return null;
    }

}
