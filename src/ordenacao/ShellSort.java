package ordenacao;

public class ShellSort extends MetodoDeOrdenacao {

    public ShellSort() {
        super();
    }

    public void sort(int repeticoes) {
        if (vetor != null) {
            int[] vetorTemp = vetor.clone();
            for (int i = 1; i <= repeticoes; i++) {
                vetor = vetorTemp.clone();
                super.start();
                shellSort();
                super.stop();
            }
        }
    }

    private void shellSort() {
        if (vetor != null) {
            comparacoes = 0;
            movimentacoes = 0;
            int h = 1;
            int n = vetor.length;
            while (h < n) {
                h = h * 3 + 1;
            }
            h = h / 3;
            int c, j;
            while (h > 0) {
                for (int i = h; i < n; i++) {
                    c = vetor[i];
                    j = i;
                    while (j >= h && vetor[j - h] > c) {
                        comparacoes++;
                        vetor[j] = vetor[j - h];
                        movimentacoes++;
                        j = j - h;
                    }
                    comparacoes++;
                    vetor[j] = c;
                    movimentacoes++;
                }
                h = h / 2;
            }
        }
    }

//    @Override
//    public void print() {
//        System.out.print("Método: ShellSort     | ");
//        super.print();
//    }

}
