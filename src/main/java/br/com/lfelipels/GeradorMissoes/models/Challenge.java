package br.com.lfelipels.GeradorMissoes.models;

import java.util.Set;

public class Challenge {
    private String challenger;
    private Set<String> missions;

    public Challenge(String challenger, Set<String> missions) {
        this.challenger = challenger;
        this.missions = missions;
    }

    public String getChallenger() {
        return challenger;
    }

    public Set<String> getMissions() {
        return missions;
    }
}
