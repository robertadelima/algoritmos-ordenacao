package ordenacao;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Ordenacao {

	public static void main(String[] args) {

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
					+ " Execuções, Tempo Médio(ns)");
			csvWriter.flush();
			csvWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		int repeticoes = 10;

		int[] tamanhosDeInput = new int[] { 100, 1000, 10000 };

		for (int tamanho : tamanhosDeInput) {
			ordemCrescente = gerarVetorEmOrdemCrescente(tamanho);
			ordemDecrescente = gerarVetorEmOrdemDecrescente(tamanho);
			ordemAleatoria = gerarVetorAleatorio(tamanho);

			// Feito com três 'for' separados para manter a sequência desejada no output
			for (MetodoDeOrdenacao metodo : metodosOrdenacao) {
				metodo.setVetor(ordemCrescente.clone());
				metodo.sort(repeticoes);
				metodo.writeToFile("Crescente", metodo.getClass().getSimpleName());
			}

			for (MetodoDeOrdenacao metodo : metodosOrdenacao) {
				metodo.setVetor(ordemDecrescente.clone());
				metodo.sort(repeticoes);
				metodo.writeToFile("Decrescente", metodo.getClass().getSimpleName());
			}

			for (MetodoDeOrdenacao metodo : metodosOrdenacao) {
				metodo.setVetor(ordemAleatoria.clone());
				metodo.sort(repeticoes);
				metodo.writeToFile("Aleatoria", metodo.getClass().getSimpleName());
			}
		}
		System.out.println("Finished writing. Check the output.csv file!");

	}

	public static int[] gerarVetorEmOrdemCrescente(int tamanho) {
		int[] vetor = new int[tamanho];
		for (int i = 0; i < vetor.length; i++)
			vetor[i] = i + 1;
		
		return vetor;
	}

	public static int[] gerarVetorEmOrdemDecrescente(int tamanho) {
		int[] vetor = new int[tamanho];
		for (int i = 0; i < vetor.length; i++)
			vetor[i] = tamanho - i;
		
		return vetor;
	}

	public static int[] gerarVetorAleatorio(int tamanho) {
		int[] vetor = gerarVetorEmOrdemCrescente(tamanho);
		Random random = new Random();
		for (int i = 0; i < vetor.length; i++) {
			int j = random.nextInt(vetor.length);
			int temp = vetor[i];
			vetor[i] = vetor[j];
			vetor[j] = temp;
		}
		return vetor;
	}

}
