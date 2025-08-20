package com.robertoljr.gamelist.projection;

public interface GameSummaryProjection {
    Long getId();

    String getTitle();

    Integer getYear();

    String getImgUrl();

    String getShortDescription();

    Integer getPosition();
}
