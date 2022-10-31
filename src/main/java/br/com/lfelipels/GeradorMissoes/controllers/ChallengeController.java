package br.com.lfelipels.GeradorMissoes.controllers;

import br.com.lfelipels.GeradorMissoes.DistrictHelper;
import br.com.lfelipels.GeradorMissoes.services.MissionGeneratorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController()
@RequestMapping("/challenges")
public class ChallengeController {
    private List<String> challengers;

    private final MissionGeneratorService missionGeneratorService;

    public ChallengeController(MissionGeneratorService missionGeneratorService) {
        this.missionGeneratorService = missionGeneratorService;
        this.challengers = new ArrayList();
    }

    @GetMapping()
    public ResponseEntity<Object> index() {
        if(this.challengers.isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Informe os participantes para os desafios");
        }
        Map<String, Set<String>> missions = this.missionGeneratorService.generate(
                this.challengers,
                DistrictHelper.list()
        );
        return ResponseEntity.status(HttpStatus.OK).body(missions);
    }

    @PostMapping()
    public ResponseEntity<Object> storeChallengers(@RequestBody Map<String, List<String>> requestData) {
        this.challengers.clear();
        this.challengers.addAll(requestData.get("challengers"));
        return ResponseEntity.status(HttpStatus.OK).body("success");
    }
}
