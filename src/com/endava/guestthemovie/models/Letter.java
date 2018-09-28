package com.endava.guestthemovie.models;

public class Letter {
    private Character letter;
    private Boolean isHidden;

    public Letter(Character letter, Boolean isHidden) {
        this.letter = letter;
        this.isHidden = isHidden;
    }

    public Character getLetter() {
        return letter;
    }

    public void setLetter(Character letter) {
        this.letter = letter;
    }

    public Boolean getHidden() {
        return isHidden;
    }

    public void setHidden(Boolean hidden) {
        isHidden = hidden;
    }
}
