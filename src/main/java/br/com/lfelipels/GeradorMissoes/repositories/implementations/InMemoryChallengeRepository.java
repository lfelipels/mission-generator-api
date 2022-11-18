package br.com.lfelipels.GeradorMissoes.repositories.implementations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import br.com.lfelipels.GeradorMissoes.models.Challenge;
import br.com.lfelipels.GeradorMissoes.repositories.ChallengeRepository;

public class InMemoryChallengeRepository implements ChallengeRepository {

    private Map<String, Challenge> challenges;

    public InMemoryChallengeRepository() {
        this.challenges = new HashMap<>();
    }

    @Override
    public void save(Challenge challenge) {
        this.challenges.put(challenge.getChallenger(), challenge);
    }

    @Override
    public List<Challenge> findByChallengers(Set<String> challengers) {
        List<Challenge> challenges = new ArrayList();

        for (String challengerName : challengers) {
            if (this.challenges.containsKey(challengerName)) {
                challenges.add(this.challenges.get(challengerName));
            }
        }

        return challenges;
    }
}
