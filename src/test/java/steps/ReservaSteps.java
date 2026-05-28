package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Quando;
import io.cucumber.java.pt.Então;
import reserva.ReservaService;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReservaSteps {
    private ReservaService reservaService;
    private String cidade;
    private String endereco;
    private String resultado;

    @Dado("que o passageiro está na cidade {string}")
    public void queOPassageiroEstaNaCidade(String cidade) {
        reservaService = new ReservaService();
        this.cidade = cidade;
    }

    @Dado("informa o endereço {string}")
    public void informaOEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Quando("solicitar a reserva do carro")
    public void solicitarAReservaDoCarro() {
        resultado = reservaService.reservar(cidade, endereco);
    }

    @Então("o sistema deve retornar {string}")
    public void oSistemaDeveRetornar(String mensagemEsperada) {
        assertEquals(mensagemEsperada, resultado);
    }
}