package com.robertoljr.gamelist.projection;

public interface GameSummaryProjection {
    Long getId();

    String getTitle();

    Integer getReleaseYear();

    String getImgUrl();

    String getShortDescription();

    Integer getPosition();
}
