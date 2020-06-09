package ordenacao;

public class InsertionSort extends MetodoDeOrdenacao {

    public InsertionSort() {
        super();
    }

    public void sort(int repeticoes) {
        if (vetor != null) {
            int[] vetorTemp = vetor.clone();
            for (int i = 1; i <= repeticoes; i++) {
                vetor = vetorTemp.clone();
                super.start();
                insertionSort();
                super.stop();
            }
        }
    }

    private void insertionSort() {
        // O primeiro elemento do vetor já está ordenado, então não é necessário iniciar em 0
        for (int i = 1; i < vetor.length; i++) {
            // A "carta" que está sendo comprada
            int pivo = vetor[i];
            // Percorre a parte já ordenada, da direita para a esquerda,
            // a partir do elemento imediatamente à esquerda do pivô (i-1)                
            int j = i - 1;
            boolean trocou = false;
            while (j >= 0 && vetor[j] > pivo) {
                vetor[j + 1] = vetor[j]; // Desloca a "carta" para a direita se ela for maior que o pivô
                j--;
                comparacoes++;
                movimentacoes++;
                trocou = true;
            }
            if (!trocou) {
                comparacoes++;
            }
            vetor[j + 1] = pivo; // Insere a nova "carta" na posição correta    
        }
    }

//    @Override
//    public void print() {
//        System.out.print("Método: InsertionSort | ");
//        super.print();
//    }

}
