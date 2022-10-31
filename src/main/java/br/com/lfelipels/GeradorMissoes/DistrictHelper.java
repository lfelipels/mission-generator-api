package br.com.lfelipels.GeradorMissoes;

import java.util.Set;
import java.util.TreeSet;

public class DistrictHelper {

    public static Set<String> list(){
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

        return districts;
    }
}
