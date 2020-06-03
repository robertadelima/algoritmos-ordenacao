package ordenacao;

public class SelectionSort extends MetodoDeOrdenacao {

    public SelectionSort() {
        super();
    }

    public void sort(int repeticoes) {
        if (vetor != null) {
            int[] vetorTemp = vetor.clone();
            for (int i = 1; i <= repeticoes; i++) {
                vetor = vetorTemp.clone();
                super.start();
                selectionSort();
                super.stop();
            }
        }
    }

    private void selectionSort() {
        // Neste m�todo, a parte ordenada (esquerda) do vetor n�o possui nenhum elemento,
        // ent�o � necess�rio iniciar em zero
        for (int i = 0; i < vetor.length - 1; i++) {
            // Considera que o menor elemento � o primeiro elemento da parte ainda n�o ordenada
            int menor = i;
            // Percorre o restante da parte n�o ordenada em busca de um elemento menor
            for (int j = i + 1; j < vetor.length; j++) {
                comparacoes++;
                if (vetor[j] < vetor[menor]) {
                    menor = j;
                }
            }
            // Coloca o menor elemento na posi��o "i"
            // Ap�s a troca, "i" passa a integrar a parte ordenada (esquerda) do vetor
            if (i < menor) {
                troca(i, menor);
            }
        }
    }

    private void troca(int a, int b) {
        int temp = vetor[a];
        vetor[a] = vetor[b];
        vetor[b] = temp;
        movimentacoes++;
    }

    @Override
    public void print() {
        System.out.print("M�todo: SelectionSort | ");
        super.print();
    }

}
