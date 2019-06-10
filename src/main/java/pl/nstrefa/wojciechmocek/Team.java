package pl.nstrefa.wojciechmocek;

import lombok.NonNull;

abstract public class Team {

    protected String name;

    public Team(@NonNull String name) {
        this.name = name;
    }
}
