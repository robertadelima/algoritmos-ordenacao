package ordenacao;

public abstract class MetodoDeOrdenacao {

    protected int[] vetor;
    protected int comparacoes;
    protected int movimentacoes;
    protected long[] tempo;
    protected int execucao;

    public MetodoDeOrdenacao() {
        vetor = null;
        comparacoes = 0;
        movimentacoes = 0;
        tempo = new long[10];
        execucao = 0;
    }

    public void setVetor(int[] v) {
        vetor = v;
    }

    public int[] getVetor() {
        return vetor;
    }

    public int getComparacoes() {
        return comparacoes;
    }

    public int getMovimentacoes() {
        return movimentacoes;
    }
    
    public void start(){
        movimentacoes = 0;
        comparacoes = 0;
        tempo[execucao] = System.nanoTime();
    }
    
    public void stop (){
        tempo[execucao] = System.nanoTime() - tempo[execucao];
        execucao++;
        if(execucao>tempo.length-1){
           execucao = 0;
        }
    }
    
    public void print() {
        System.out.print("Comparações: " + comparacoes + " | ");
        System.out.print("Movimentações: " + movimentacoes + " | ");
        long total = 0;  
        int qtd = 0;
        for(int i = 0; i<tempo.length;i++){
            if(tempo[i]>0){
                total = total + tempo[i];
                qtd++;
            }
        }
        long media = total / (long)qtd;
        System.out.println("Tempo: " + media + " nanossegundos");
    }

}
