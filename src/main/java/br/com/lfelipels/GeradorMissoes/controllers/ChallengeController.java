package br.com.lfelipels.GeradorMissoes.controllers;

import br.com.lfelipels.GeradorMissoes.DistrictHelper;
import br.com.lfelipels.GeradorMissoes.models.Challenge;
import br.com.lfelipels.GeradorMissoes.repositories.ChallengeRepository;
import br.com.lfelipels.GeradorMissoes.services.MissionGeneratorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController()
@RequestMapping("/challenges")
public class ChallengeController {

    private final MissionGeneratorService missionGeneratorService;
    private final ChallengeRepository challengeRepository;

    public ChallengeController(
            MissionGeneratorService missionGeneratorService,
            ChallengeRepository challengeRepository) {
        this.missionGeneratorService = missionGeneratorService;
        this.challengeRepository = challengeRepository;
    }

    @GetMapping()
    public ResponseEntity<Object> index(@RequestParam(name = "challengers") Set<String> challengers) {
        List<Challenge> challenges = this.challengeRepository.findByChallengers(challengers);
        return ResponseEntity.status(HttpStatus.OK).body(challenges);
    }

    @PostMapping()
    public ResponseEntity<Object> storeChallengers(@RequestBody Map<String, Set<String>> requestData) {
        Set<String> challengers = requestData.get("challengers");
        this.missionGeneratorService.generate(challengers, DistrictHelper.list());
        return ResponseEntity.status(HttpStatus.OK).body("success");
    }
}
