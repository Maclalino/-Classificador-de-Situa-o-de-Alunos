import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClassificadorAlunoTest {

    private final ClassificadorAluno classificador = new ClassificadorAluno();

    @Test
    void deveClassificarAlunoComoAprovado() {
        String resultado = classificador.classificar(8.0, 90.0);

        assertEquals("Aprovado", resultado);
    }

    @Test
    void deveClassificarAlunoComoRecuperacao() {
        String resultado = classificador.classificar(6.0, 80.0);

        assertEquals("Recuperação", resultado);
    }

    @Test
    void deveClassificarAlunoComoReprovadoPorNota() {
        String resultado = classificador.classificar(4.0, 90.0);

        assertEquals("Reprovado por nota", resultado);
    }

    @Test
    void deveClassificarAlunoComoReprovadoPorFrequencia() {
        String resultado = classificador.classificar(9.0, 60.0);

        assertEquals("Reprovado por frequência", resultado);
    }

    @Test
    void deveAprovarAlunoComNotaExatamenteSeteEFrequenciaValida() {
        String resultado = classificador.classificar(7.0, 75.0);

        assertEquals("Aprovado", resultado);
    }

    @Test
    void deveColocarAlunoEmRecuperacaoComNotaExatamenteCinco() {
        String resultado = classificador.classificar(5.0, 75.0);

        assertEquals("Recuperação", resultado);
    }

    @Test
    void deveAprovarAlunoComFrequenciaExatamenteSetentaECinco() {
        String resultado = classificador.classificar(8.0, 75.0);

        assertEquals("Aprovado", resultado);
    }

    @Test
    void deveLancarExcecaoQuandoNotaForMenorQueZero() {
        assertThrows(IllegalArgumentException.class, () -> {
            classificador.classificar(-1.0, 80.0);
        });
    }

    @Test
    void deveLancarExcecaoQuandoNotaForMaiorQueDez() {
        assertThrows(IllegalArgumentException.class, () -> {
            classificador.classificar(11.0, 80.0);
        });
    }

    @Test
    void deveLancarExcecaoQuandoFrequenciaForMenorQueZero() {
        assertThrows(IllegalArgumentException.class, () -> {
            classificador.classificar(8.0, -10.0);
        });
    }

    @Test
    void deveLancarExcecaoQuandoFrequenciaForMaiorQueCem() {
        assertThrows(IllegalArgumentException.class, () -> {
            classificador.classificar(8.0, 120.0);
        });
    }
}