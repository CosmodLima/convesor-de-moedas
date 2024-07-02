package convesor.moedas;

import java.util.Map;

public record Moeda( String resultado, String codigo_base, Map<String, Double> taxaDeConversao) {

}
