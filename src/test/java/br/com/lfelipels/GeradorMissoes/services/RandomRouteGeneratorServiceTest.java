package br.com.lfelipels.GeradorMissoes.services;

import br.com.lfelipels.GeradorMissoes.objectsValue.Route;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.TreeSet;

public class RandomRouteGeneratorServiceTest {

    @Test
    public void generateRoute() {

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

        RandomRouteGeneratorService randomRouteGenerator = new RandomRouteGeneratorService();
        Route route =  randomRouteGenerator.generate(districts);

        Assertions.assertNotNull(route);
        Assertions.assertNotNull(route.getFrom());
        Assertions.assertNotNull(route.getTo());
    }

    @Test
    public void shouldThrowAnExceptionIfTheSizeOfAddressesListLessThan2() {

        Set<String> districts = new TreeSet(){
            { add("Aldeota"); }
        };

        RandomRouteGeneratorService randomRouteGenerator = new RandomRouteGeneratorService();
        Assertions.assertThrows(IllegalArgumentException.class, () -> randomRouteGenerator.generate(districts));
    }
}
