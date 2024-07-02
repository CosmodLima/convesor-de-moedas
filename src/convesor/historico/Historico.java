package convesor.historico;

import java.util.ArrayList;
import java.util.List;

public class Historico {
  private final List<String> historico;

  public Historico() {
    historico = new ArrayList<>();
  }

  public void adicionarEntrada(String entrada) {
    historico.add(entrada);
  }

  public void exibirHistorico() {
    if (historico.isEmpty()) {
      System.out.println("Nenhuma conversão realizada.");
    } else {
      System.out.println("Histórico de Conversões:");
      for (String entrada : historico) {
        System.out.println(entrada);
      }
    }
  }
}
