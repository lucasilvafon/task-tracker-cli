package org.example;

import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    static ArrayList<String> tasks = new ArrayList<>();

    public static void main(String[] args) {
        //Adicionar tarefa
        //Listar tarefa
        //Deletar tarefa
        System.out.println("Lista de tarefas");
        if (args.length == 0) {
            System.out.println("Use um comando: add | list | done | delete");
            return;
        }
        if (args[0].equals("add")) {
            if (args.length < 2) {
                System.out.println("Digite a descrição da tarefa");
                return;
            }
            String descricao = args[1];
            tasks.add(descricao);
            System.out.println("Tarefa adicionada: " + descricao);
        }
        if (args[0].equals("list")) {

            if (tasks.isEmpty()) {
                System.out.println("Nenhuma tarefa encontrada");
                return;
            }

            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }
}