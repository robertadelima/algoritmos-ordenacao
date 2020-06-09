package ordenacao;

public class QuickSort extends MetodoDeOrdenacao {

    public QuickSort() {
        super();
    }

    public void sort(int repeticoes) {
        if (vetor != null) {
            int[] vetorTemp = vetor.clone();
            for (int i = 1; i <= repeticoes; i++) {
                vetor = vetorTemp.clone();
                super.start();
                quickSort(vetor, 0, vetor.length - 1);
                super.stop();
            }
        }
    }

    private void quickSort(int[] v, int ini, int fim) {
        if (ini < fim) {
            int pivo = separar(v, ini, fim);
            quickSort(v, ini, pivo - 1);
            quickSort(v, pivo + 1, fim);
        }
    }

    private int separar(int[] v, int ini, int fim) {
        int i = ini + 1;
        int j = fim;
        int pivo = v[ini];
        while (i <= j) {
            if (v[i] <= pivo) {
                i++;

            } else if (v[j] > pivo) {
                j--;
            } else if (i <= j) {
                troca(i, j);
                i++;
                j--;
            }
            comparacoes++;
        }
        troca(ini, j);
        return j;
    }

    private void troca(int a, int b) {
        int temp = vetor[a];
        vetor[a] = vetor[b];
        vetor[b] = temp;
        movimentacoes++;
    }

//    @Override
//    public void print() {
//        System.out.print("Método: QuickSort     | ");
//        super.print();
//    }

}
