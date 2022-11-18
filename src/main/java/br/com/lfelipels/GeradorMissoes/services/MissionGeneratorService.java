package br.com.lfelipels.GeradorMissoes.services;

import br.com.lfelipels.GeradorMissoes.models.Challenge;
import br.com.lfelipels.GeradorMissoes.objectsValue.Route;
import br.com.lfelipels.GeradorMissoes.repositories.ChallengeRepository;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MissionGeneratorService {

        private final int MAX_TRANSFER = 10;

        private final RandomRouteGeneratorService randomRouteGeneratorService;
        private ChallengeRepository challengeRepository;

        public MissionGeneratorService(
                        ChallengeRepository challengeRepository,
                        RandomRouteGeneratorService randomRouteGeneratorService) {
                this.challengeRepository = challengeRepository;
                this.randomRouteGeneratorService = randomRouteGeneratorService;
        }

        public void generate(Set<String> users, Set<String> districts) {
                for (String userName : users) {
                        Set<String> missions = new HashSet();
                        missions.add(this.generateLocomotionMission(districts));
                        missions.add(this.generateChallengeMission(districts, users, userName));
                        missions.add(this.generateWinnerMission(districts, users, userName));
                        this.challengeRepository.save(new Challenge(userName, missions));
                }
        }

        private String generateWinnerMission(Set<String> districts, Set<String> users, String challenger) {

                String usersNamesJoin = String.join(" e ", users.stream()
                                .filter(u -> !u.equals(challenger))
                                .toList());

                Route route = this.randomRouteGeneratorService.generate(districts);
                return String.format(
                                "Numa disputa entre você, %s, você deve fazer a viagem com menos baldeações para pegar um ônibus do "
                                                +
                                                "bairro %s para o bairro %s",
                                usersNamesJoin,
                                route.getFrom(),
                                route.getTo());
        }

        private String generateChallengeMission(
                        Set<String> districts,
                        Set<String> users,
                        String challenger) {
                Route route = this.randomRouteGeneratorService.generate(districts);
                // remove o desafiante e escolhe o usuario desafiado
                Set<String> usersList = new HashSet<>();
                usersList.addAll(users);
                usersList.remove(challenger);
                String user = usersList.stream()
                                .skip((int) (Math.random() * (users.size() - 1)))
                                .findFirst()
                                .get();

                return String.format(
                                "Você deve desafiar o jogador %s a pegar um ônibus do bairro %s ao bairro %s, " +
                                                "fazendo a baldeação no máximo %d vezes.",
                                user,
                                route.getFrom(),
                                route.getTo(),
                                (int) (Math.random() * MAX_TRANSFER));
        }

        private String generateLocomotionMission(Set<String> districts) {
                Route route = this.randomRouteGeneratorService.generate(districts);
                return String.format(
                                "Você deve pegar um ônibus do bairro %s ao bairro %s, fazendo a baldeação no máximo %d vezes",
                                route.getFrom(),
                                route.getTo(),
                                (int) (Math.random() * MAX_TRANSFER));
        }
}
