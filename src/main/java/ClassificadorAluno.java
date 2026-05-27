public class ClassificadorAluno {

    private static final double NOTA_MINIMA = 0.0;
    private static final double NOTA_MAXIMA = 10.0;

    private static final double FREQUENCIA_MINIMA = 0.0;
    private static final double FREQUENCIA_MAXIMA = 100.0;
    private static final double FREQUENCIA_MINIMA_APROVACAO = 75.0;

    private static final double NOTA_APROVACAO = 7.0;
    private static final double NOTA_RECUPERACAO = 5.0;

    public String classificar(double notaFinal, double frequencia) {
        validarNota(notaFinal);
        validarFrequencia(frequencia);

        if (frequencia < FREQUENCIA_MINIMA_APROVACAO) {
            return "Reprovado por frequência";
        }

        if (notaFinal >= NOTA_APROVACAO) {
            return "Aprovado";
        }

        if (notaFinal >= NOTA_RECUPERACAO) {
            return "Recuperação";
        }

        return "Reprovado por nota";
    }

    private void validarNota(double notaFinal) {
        if (notaFinal < NOTA_MINIMA || notaFinal > NOTA_MAXIMA) {
            throw new IllegalArgumentException("Nota final deve estar entre 0 e 10.");
        }
    }

    private void validarFrequencia(double frequencia) {
        if (frequencia < FREQUENCIA_MINIMA || frequencia > FREQUENCIA_MAXIMA) {
            throw new IllegalArgumentException("Frequência deve estar entre 0 e 100.");
        }
    }
}