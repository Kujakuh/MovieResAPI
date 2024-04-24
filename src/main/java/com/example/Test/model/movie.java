package com.example.Test.model;

import jakarta.persistence.*;

@Entity
@Table(name="movies")
public class movie {

    @Id // Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String movie_name;
    private String url;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMovie_name() {
        return movie_name;
    }

    public void setMovieName(String movie_name) {
        this.movie_name = movie_name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

