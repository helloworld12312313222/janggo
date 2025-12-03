package kr.ac.mjc.janggo.dto;

import java.io.Serializable;

public class Chef implements Serializable {
    private int image;
    private String name;
    private String description;

    public Chef(int image, String name, String description) {
        this.image = image;
        this.name = name;
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
