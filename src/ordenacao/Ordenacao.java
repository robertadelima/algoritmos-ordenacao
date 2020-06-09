package ordenacao;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Ordenacao {

    public static void main(String[] args) {

//        BubbleSort bs = new BubbleSort();
//        InsertionSort is = new InsertionSort();
//        SelectionSort ss = new SelectionSort();
//        MergeSort ms = new MergeSort();
//        QuickSort qs = new QuickSort();
//        ShellSort shs = new ShellSort();
        
        //Novo
        ArrayList<MetodoDeOrdenacao> metodosOrdenacao = new ArrayList<>();
        metodosOrdenacao.add(new BubbleSort());
        metodosOrdenacao.add(new InsertionSort());
        metodosOrdenacao.add(new SelectionSort());
        metodosOrdenacao.add(new MergeSort());
        metodosOrdenacao.add(new QuickSort());
        metodosOrdenacao.add(new ShellSort());

        int[] ordemCrescente;
        int[] ordemDecrescente;
        int[] ordemAleatoria;
        
        try {
			FileWriter csvWriter = new FileWriter("output.csv", false);
			csvWriter.write("Tamanho do input, Ordenação do input, Método, Comparações, Movimentações,"
					+ " Repetições, Tempo Médio(nanosseg)");
			csvWriter.flush();
			csvWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
        
        int repeticoes = 10;

        int[] tamanhosDeInput = new int[]{100, 1000, 10000};
        
        for(int tamanho : tamanhosDeInput) {
        	ordemCrescente = vertorEmOrdemCrescente(tamanho);
        	ordemDecrescente = vertorEmOrdemDecrescente(tamanho);
        	ordemAleatoria = vertorEmDesordem(tamanho);
        	
        	for(MetodoDeOrdenacao metodo : metodosOrdenacao) {
        		 metodo.setVetor(ordemCrescente.clone()); 
        		 metodo.sort(repeticoes); 
        		 metodo.writeToFile("Crescente", metodo.getClass().getSimpleName());
        	}
        	for(MetodoDeOrdenacao metodo : metodosOrdenacao) {
       		 metodo.setVetor(ordemDecrescente.clone()); 
       		 metodo.sort(repeticoes); 
       		 metodo.writeToFile("Decrescente", metodo.getClass().getSimpleName());
        	}
        	for(MetodoDeOrdenacao metodo : metodosOrdenacao) {
       		 metodo.setVetor(ordemAleatoria.clone()); 
       		 metodo.sort(repeticoes); 
       		 metodo.writeToFile("Aleatoria", metodo.getClass().getSimpleName());
        	}
        }
        
        
//        int tamanho = 100;
//        for(int i = 1; i<=3; i++){
//            ordemCrescente = vertorEmOrdemCrescente(tamanho);
//            ordemDecrescente = vertorEmOrdemDecrescente(tamanho);
//            ordemAleatoria = vertorEmDesordem(tamanho);
//            
//            System.out.println("VETOR COM "+tamanho+" ELEMENTOS EM ORDEM CRESCENTE - MELHOR CASO");
//            bs.setVetor(ordemCrescente.clone()); bs.sort(repeticoes); bs.print(); 
//            is.setVetor(ordemCrescente.clone()); is.sort(repeticoes); is.print(); 
//            ss.setVetor(ordemCrescente.clone()); ss.sort(repeticoes); ss.print(); 
//            ms.setVetor(ordemCrescente.clone()); ms.sort(repeticoes); ms.print(); 
//            qs.setVetor(ordemCrescente.clone()); qs.sort(repeticoes); qs.print(); 
//            shs.setVetor(ordemCrescente.clone()); shs.sort(repeticoes); shs.print();
//            System.out.println("VETOR COM "+tamanho+" ELEMENTOS EM ORDEM DECRESCENTE - PIOR CASO");
//            bs.setVetor(ordemDecrescente.clone()); bs.sort(repeticoes); bs.print(); 
//            is.setVetor(ordemDecrescente.clone()); is.sort(repeticoes); is.print(); 
//            ss.setVetor(ordemDecrescente.clone()); ss.sort(repeticoes); ss.print(); 
//            ms.setVetor(ordemDecrescente.clone()); ms.sort(repeticoes); ms.print(); 
//            qs.setVetor(ordemDecrescente.clone()); qs.sort(repeticoes); qs.print(); 
//            shs.setVetor(ordemDecrescente.clone()); shs.sort(repeticoes); shs.print();     
//            System.out.println("VETOR COM "+tamanho+" ELEMENTOS EM DESORDEM");
//            bs.setVetor(ordemAleatoria.clone()); bs.sort(repeticoes); bs.print(); 
//            is.setVetor(ordemAleatoria.clone()); is.sort(repeticoes); is.print(); 
//            ss.setVetor(ordemAleatoria.clone()); ss.sort(repeticoes); ss.print(); 
//            ms.setVetor(ordemAleatoria.clone()); ms.sort(repeticoes); ms.print(); 
//            qs.setVetor(ordemAleatoria.clone()); qs.sort(repeticoes); qs.print(); 
//            shs.setVetor(ordemAleatoria.clone()); shs.sort(repeticoes); shs.print();      
//            tamanho = tamanho * 10;        
//        }
//    
    }
    
    public static int[] vertorEmOrdemCrescente(int tamanho){
        int[] vetor = new int[tamanho];
        for(int i = 0; i<vetor.length; i++){
            vetor[i] = i+1;
        }
        return vetor;
    }
    
    public static int[] vertorEmOrdemDecrescente(int tamanho){
        int[] vetor = new int[tamanho];
        for(int i = 0; i<vetor.length; i++){
            vetor[i] = tamanho-i;
        }
        return vetor;
    }  
    
    public static int[] vertorEmDesordem(int tamanho){
        int[] vetor = vertorEmOrdemCrescente(tamanho);
        Random random = new Random();
        for(int i = 0; i<vetor.length; i++){
            int j = random.nextInt(vetor.length);
            int temp = vetor[i];
            vetor[i] = vetor[j];
            vetor[j] = temp;
        }
        return vetor;
    }       

}
