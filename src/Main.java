import java.util.Scanner;
import convesor.ConsultaMoeda;
import convesor.conversor.Conversor;

public class Main {

  private static final Scanner leitura = new Scanner(System.in);
  private static final ConsultaMoeda conversor = new ConsultaMoeda();
  private static final String mensagem = """
      ****************************************************
            Seja bem-vindo/a ao Conversor de Moedas =]

            1) Dólar =>> Euro
            2) Euro =>> Dólar
            3) Dólar =>> Real Brasileiro
            4) Real Brasileiro =>> Dólar
            5) Dólar =>> Peso Argentino
            6) Peso Argentino =>> Dólar
            7) Dólar =>> Won Sul-Coreano
            8) Won Sul-Coreano =>> Dólar
            9) Dólar =>> Peso Colombiano
            10) Peso Colombiano =>> Dólar
            11) Exibir Histórico de Conversões
            0) Sair
            Escolha uma opção válida:
      ****************************************************
            """;

  public static void main(String[] args) {
    int opcao = -1;
    while (opcao != 0) {
      mostrarMenu();
      opcao = leitura.nextInt();
      leitura.nextLine();
      executarOpcao(opcao);
    }
  }

  private static void mostrarMenu() {
    System.out.println(mensagem);
  }

  private static void executarOpcao(int opcao) {
    try {
      switch (opcao) {
        case 1 -> converter("USD", "EUR", "Dólar =>> Euro");
        case 2 -> converter("EUR", "USD", "Euro =>> Dólar");
        case 3 -> converter("USD", "BRL", "Dólar =>> Real Brasileiro");
        case 4 -> converter("BRL", "USD", "Real Brasileiro =>> Dólar");
        case 5 -> converter("USD", "ARS", "Dólar =>> Peso Argentino");
        case 6 -> converter("ARS", "USD", "Peso Argentino =>> Dólar");
        case 7 -> converter("USD", "KRW", "Dólar =>> Won Sul Coreano");
        case 8 -> converter("KRW", "USD", "Won Sul Coreano =>> Dólar");
        case 9 -> converter("USD", "COP", "Dólar =>> Peso Colombiano");
        case 10 -> converter("COP", "USD", "Peso Colombiano =>> Dólar");
        case 11 -> Conversor.exibirHistorico();
        case 0 -> {
          System.out.println("Encerrando Conversor...");
          System.exit(0);
        }
        default -> System.out.println("Opção Inválida. Tente novamente.\n");
      }
    } catch (Exception e) {
      System.err.println("Ocorreu um erro: " + e.getMessage());
    }
  }

  private static void converter(String moedaOrigem, String moedaDestino, String mensagemConversao) {
    System.out.print("Digite o valor que deseja converter: \n$");
    String quantidadeM = leitura.nextLine();
    System.out.println(mensagemConversao);
    Conversor.converterMoeda(moedaOrigem, moedaDestino, conversor, quantidadeM);
  }
}
