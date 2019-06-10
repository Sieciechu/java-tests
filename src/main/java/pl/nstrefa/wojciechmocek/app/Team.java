package pl.nstrefa.wojciechmocek.app;

import lombok.NonNull;

abstract public class Team {

    protected String name;

    public Team(@NonNull String name) {
        this.name = name;
    }
}
