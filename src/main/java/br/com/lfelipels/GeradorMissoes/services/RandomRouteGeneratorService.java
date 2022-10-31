package br.com.lfelipels.GeradorMissoes.services;

import br.com.lfelipels.GeradorMissoes.objectsValue.Route;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class RandomRouteGeneratorService {

    public Route generate(Set<String> addresses){
        if(addresses.size() < 2){
            throw new IllegalArgumentException("Informe pelo menos dois endereços para gerar a rota");
        }

        Route route = new Route();

        int idxAddress = (int) (Math.random() * addresses.size());
        String from = addresses
                .stream()
                .skip(idxAddress)
                .findFirst()
                .get();

        route.setFrom(from);

        String to = addresses
                .stream()
                .filter((String a) -> route.getFrom() != a)
                .skip((int) (Math.random() * (addresses.size() -1) ))
                .findFirst()
                .get();

        route.setTo(to);

        return route;
    }
}
