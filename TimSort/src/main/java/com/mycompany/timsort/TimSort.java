package com.mycompany.timsort;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class TimSort {

    public static int[] carregarDados(String nomeArquivo) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(nomeArquivo));
        List<Integer> dadosLista = new ArrayList<>();
        while (scanner.hasNextInt()) {
            dadosLista.add(scanner.nextInt());
        }
        scanner.close();

        int[] dados = new int[dadosLista.size()];
        for (int i = 0; i < dadosLista.size(); i++) {
            dados[i] = dadosLista.get(i);
        }
        return dados;
    }

    public static void main(String[] args) throws FileNotFoundException {
        String nomeArquivo = "C:\\Users\\Administrator\\Downloads\\dados500mil.txt"; // Substitua pelo caminho correto
        int[] dados = carregarDados(nomeArquivo); 


        long inicio = System.nanoTime();
        Arrays.sort(dados); 
        long fim = System.nanoTime();

     
        long tempoExecucao = fim - inicio;
        long horas = TimeUnit.NANOSECONDS.toHours(tempoExecucao);
        long minutos = TimeUnit.NANOSECONDS.toMinutes(tempoExecucao) % 60;
        long segundos = TimeUnit.NANOSECONDS.toSeconds(tempoExecucao) % 60;
        long milissegundos = TimeUnit.NANOSECONDS.toMillis(tempoExecucao) % 1000;

        String tempoFormatado = String.format("%02d:%02d:%02d:%03d", horas, minutos, segundos, milissegundos);

 
        System.out.println("=====================TIMSORT===============");
        System.out.println("Tempo de execução: " + tempoFormatado);
        System.out.println(Arrays.toString(dados));
    }
}