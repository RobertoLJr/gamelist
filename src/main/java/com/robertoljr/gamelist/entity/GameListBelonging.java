package com.robertoljr.gamelist.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "game_list_belongings")
public class GameListBelonging {

    @EmbeddedId
    private GameListBelongingPK id = new GameListBelongingPK();

    private Integer position;

    public GameListBelonging() {
    }

    public GameListBelonging(Game game, GameList gameList, Integer position) {
        id.setGame(game);
        id.setGameList(gameList);
        this.position = position;
    }

    public GameListBelongingPK getId() {
        return id;
    }

    public void setId(GameListBelongingPK id) {
        this.id = id;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        GameListBelonging that = (GameListBelonging) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "GameListBelonging{" +
                "id=" + id +
                ", position=" + position +
                '}';
    }
}
