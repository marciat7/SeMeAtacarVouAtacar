package com.example.marciacavalcante.semeatacarvouatacar;

/**
 * Created by Marcia Cavalcante on 01/07/2017.
 */

public class Meme {
    private String url;
    private int force;

    public String getUrl() {
        return url;
    }

    public int getForce() {
        return force;
    }

    public Meme(String url, int force){
        this.url = url;
        this.force = force;
    }
}
