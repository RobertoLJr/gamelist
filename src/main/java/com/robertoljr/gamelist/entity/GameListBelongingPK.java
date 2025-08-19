// Auxiliary class to map the composite primary key of the Belongings table

package com.robertoljr.gamelist.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.Objects;

@Embeddable
public class GameListBelongingPK {

    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;

    @ManyToOne
    @JoinColumn(name = "game_list_id")
    private GameList gameList;

    public GameListBelongingPK() {
    }

    public GameListBelongingPK(Game game, GameList gameList) {
        this.game = game;
        this.gameList = gameList;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public GameList getGameList() {
        return gameList;
    }

    public void setGameList(GameList gameList) {
        this.gameList = gameList;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        GameListBelongingPK that = (GameListBelongingPK) o;
        return Objects.equals(getGame(), that.getGame()) && Objects.equals(getGameList(), that.getGameList());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getGame(), getGameList());
    }

    @Override
    public String toString() {
        return "BelongingPK{" +
                "game=" + game +
                ", gameList=" + gameList +
                '}';
    }
}
