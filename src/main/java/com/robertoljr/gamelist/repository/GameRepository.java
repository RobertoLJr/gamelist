package com.robertoljr.gamelist.repository;

import com.robertoljr.gamelist.entity.Game;
import com.robertoljr.gamelist.projection.GameSummaryProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {

    // Replace JQL with native SQL for this particular method
    @Query(nativeQuery = true, value = """
            SELECT tb_games.id, tb_games.title, tb_games.release_year AS `year`, tb_games.img_url AS imgUrl, tb_games.short_description AS shortDescription, tb_game_list_belongings.position
            FROM tb_games
            INNER JOIN tb_game_list_belongings ON tb_games.id = tb_game_list_belongings.game_id
            WHERE tb_game_list_belongings.game_list_id = 2
            ORDER BY tb_game_list_belongings.position
            """)
    List<GameSummaryProjection> findAllByListId(Long id);
}
