package convesor.conversor;

import convesor.ConsultaMoeda;
import convesor.historico.Historico;
import convesor.moedas.Moeda;

public class Conversor {
    private static Historico historico = new Historico();

    public static void converterMoeda(String base, String cambio, ConsultaMoeda tipoConsulta, String quantidadeMoeda) {
        double valor;
        double conversorMoeda;

        Moeda moeda = tipoConsulta.moedasEscolhida(base, cambio);
        try {
            valor = Double.parseDouble(quantidadeMoeda);
            conversorMoeda = valor * moeda.conversion_rates().get(cambio);
            String resultadoConversao = "O valor " + valor + " " + base + " corresponde ao valor final de =>> " + conversorMoeda + " " + cambio;
            System.out.println(conversorMoeda);
            System.out.println(resultadoConversao);
            historico.adicionarEntrada(resultadoConversao);
        } catch (NumberFormatException e) {
            System.out.println("Quantidade Incorreta, Tente Novamente.");
        }
    }

    public static void exibirHistorico() {
        historico.exibirHistorico();
    }
}
