package convesor;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;

import convesor.moedas.Moeda;

public class ConsultaMoeda {
  public Moeda moedasEscolhida(String valorMoeda, String cambioMoeda){
        String senha = "74f480e5a3c5fae507d921c5";
        String endereco = "https://v6.exchangerate-api.com/v6/"+ senha + "/latest/"+ valorMoeda;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();

                try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());


            Moeda moeda = new Gson().fromJson(response.body(), Moeda.class);
            if (moeda.taxaDeConversao().containsKey(cambioMoeda)) {
                return moeda;
            } else {
                throw new RuntimeException("Moeda não encontrada");
            }
        } catch (Exception e) {
            throw new RuntimeException("Error na consulta da moedas" + e.getMessage());
        }
                
  }
}
