package br.com.lfelipels.GeradorMissoes.repositories;

import java.util.List;
import java.util.Set;

import br.com.lfelipels.GeradorMissoes.models.Challenge;

public interface ChallengeRepository {
    public void save(Challenge challenge);

    public List<Challenge> findByChallengers(Set<String> challengers);
}
