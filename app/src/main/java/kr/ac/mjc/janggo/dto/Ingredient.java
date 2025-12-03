package kr.ac.mjc.janggo.dto;

import java.io.Serializable;

public class Ingredient implements Serializable {
    private String name;

    public Ingredient(String ingredientName) {
        this.name = ingredientName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
