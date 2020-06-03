package ordenacao;

public class MergeSort extends MetodoDeOrdenacao {

    public MergeSort() {
        super();
    }

    public void sort(int repeticoes) {
        if (vetor != null) {
            int[] vetorTemp = vetor.clone();
            for (int i = 1; i <= repeticoes; i++) {
                vetor = vetorTemp.clone();
                super.start();
                mergeSort(vetor, vetor.clone(), 0, vetor.length - 1);
                super.stop();
            }
        }
    }

    private void mergeSort(int[] vetor, int[] vetorTemp, int inicio, int fim) {
        if (inicio < fim) {
            int meio = (inicio + fim) / 2;
            mergeSort(vetor, vetorTemp, inicio, meio);
            mergeSort(vetor, vetorTemp, meio + 1, fim);
            intercalar(vetor, vetorTemp, inicio, meio, fim);
        }
    }

    private void intercalar(int[] vetor, int[] vetorTemp, int inicio, int meio, int fim) {
        for (int f = inicio; f <= fim; f++) {
            vetorTemp[f] = vetor[f];
            movimentacoes++;
        }
        int iEsq = inicio;
        int iDir = meio + 1;
        for (int k = inicio; k <= fim; k++) {
            if (iEsq > meio) {
                vetor[k] = vetorTemp[iDir++];
            } else if (iDir > fim) {
                vetor[k] = vetorTemp[iEsq++];
            } else if (vetorTemp[iEsq] < vetorTemp[iDir]) {
                vetor[k] = vetorTemp[iEsq++];
            } else {
                vetor[k] = vetorTemp[iDir++];
            }
            comparacoes++;
            movimentacoes++;
        }
    }

    @Override
    public void print() {
        System.out.print("Método: MergeSort     | ");
        super.print();
    }

}
