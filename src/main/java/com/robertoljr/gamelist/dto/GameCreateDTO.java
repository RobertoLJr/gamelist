package com.robertoljr.gamelist.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.robertoljr.gamelist.entity.Game;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.BeanUtils;

public class GameCreateDTO {

    @NotNull(message = "Game name is required")
    @NotBlank(message = "Game name is required")
    @JsonProperty("title")
    private String title;

    @NotNull(message = "Game year is required")
    @JsonProperty("year")
    private Integer year;

    @NotNull(message = "Game genre is required")
    @NotBlank(message = "Game genre is required")
    @JsonProperty("genre")
    private String genre;

    @NotNull(message = "Game platform is required")
    @NotBlank(message = "Game platform is required")
    @JsonProperty("platform")
    private String platform;

    @JsonProperty("score")
    private Double score;

    @JsonProperty("imgUrl")
    private String imgUrl;

    @NotNull(message = "Game short description is required")
    @NotBlank(message = "Game short description is required")
    @JsonProperty("shortDescription")
    private String shortDescription;

    @NotNull(message = "Game long description is required")
    @NotBlank(message = "Game long description is required")
    @JsonProperty("longDescription")
    private String longDescription;

    public GameCreateDTO() {
    }

    public GameCreateDTO(Game entity) {
        BeanUtils.copyProperties(entity, this);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }
}
