package br.com.lfelipels.GeradorMissoes.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class MissionsGeneratorServiceTest {

    @Test
    public void generateMissionsForUsers(){

        List<String> users = new ArrayList(){
            { add("Fulano"); }
            { add("Sicrano"); }
            { add("Beltrano"); }
        };
        //lista de bairros em ordem alfabética
        Set<String> districts = new TreeSet(){
            { add("Aldeota"); }
            { add("Santa Marta"); }
            { add("Jardim Cruzeiro"); }
            { add("Alvorada"); }
            { add("Getúlio Vargas"); }
            { add("Jardim Blumenau"); }
            { add("Jardim Bandeirantes"); }
            { add("Caetano"); }
            { add("Jardim Esperança"); }
            { add("Jesus de Nazaré"); }
        };

        MissionGeneratorService missionGenerator = new MissionGeneratorService(new RandomRouteGeneratorService());
        Map<String, Set<String> > missions = missionGenerator.generate(users, districts);

        int missionsByUser = 3;
        Assertions.assertEquals(missionsByUser, missions.get(users.get(0)).size());
        Assertions.assertEquals(missionsByUser, missions.get(users.get(1)).size());
        Assertions.assertEquals(missionsByUser, missions.get(users.get(2)).size());
    }

}
