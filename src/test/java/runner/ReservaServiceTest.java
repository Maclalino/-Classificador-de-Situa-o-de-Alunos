package runner;

import org.junit.jupiter.api.Test;
import reserva.ReservaService;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReservaServiceTest {
    @Test
    public void deveReservarQuandoCidadeForBeloHorizonte() {
        ReservaService service = new ReservaService();
        String resultado = service.reservar("Belo Horizonte", "Rua A, 123");
        assertEquals("Motorista a caminho", resultado);
    }

    @Test
    public void deveReservarQuandoCidadeForContagem() {
        ReservaService service = new ReservaService();
        String resultado = service.reservar("Contagem", "Rua B, 456");
        assertEquals("Motorista a caminho", resultado);
    }

    @Test
    public void deveRetornarForaDeCoberturaQuandoCidadeNaoAtendida() {
        ReservaService service = new ReservaService();
        String resultado = service.reservar("Betim", "Rua C, 789");
        assertEquals("Área fora de cobertura", resultado);
    }
}
