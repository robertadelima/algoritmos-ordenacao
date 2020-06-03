package ordenacao;

public class BubbleSort extends MetodoDeOrdenacao {

    public BubbleSort() {
        super();
    }

    public void sort(int repeticoes) {
        if (vetor != null) {
            int[] vetorTemp = vetor.clone();
            for(int i = 1; i<=repeticoes; i++){
                vetor = vetorTemp.clone();
                super.start();
                bubbleSort(); 
                super.stop();
            }
        }
    }

    private void bubbleSort() {
        for (int i = 1; i < vetor.length; i++) {
            for (int j = 0; j < vetor.length - i; j++) {
                comparacoes++;
                if (vetor[j] > vetor[j + 1]) {
                    troca(j, j + 1);
                }
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
        System.out.print("Método: BubbleSort    | ");
        super.print();
    }

}