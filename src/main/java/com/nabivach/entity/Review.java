package com.nabivach.entity;

/**
 * Created by grey3 on 08.06.2016.
 */

public class Review {

    private int id;
    private int user_id;
    private int movie_id;
    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(int movie_id) {
        this.movie_id = movie_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Review { id =" +id+", user_id="+user_id+", movie_id="+movie_id+", description_id="+'\''+'}';
    }
}

