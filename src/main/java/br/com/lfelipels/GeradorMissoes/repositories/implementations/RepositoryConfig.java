package br.com.lfelipels.GeradorMissoes.repositories.implementations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.lfelipels.GeradorMissoes.repositories.ChallengeRepository;

@Configuration
public class RepositoryConfig {

    @Bean
    public ChallengeRepository inMemoryImplementation() {
        return new InMemoryChallengeRepository();
    }
}
