// Change this to your own package
package com.example.renske.nativeapppractice;

/*
    A class depicting a plant of a certain type and size, and the color of the pot it is in.
*/
public class Plant {

    private String name;
    private String potColor;
    private int size;

    public Plant(String name, String potColor, int size) {
        this.name = name;
        this.potColor = potColor;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPotColor() {
        return potColor;
    }

    public void setPotColor(String potColor) {
        this.potColor = potColor;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
