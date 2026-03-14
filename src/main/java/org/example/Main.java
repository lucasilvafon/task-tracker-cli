package org.example;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws Exception {

        ArrayList<Task> tasks = TaskStorage.loadTasks();

        System.out.println("Lista de tarefas");

        if (args.length == 0) {
            System.out.println("Use um comando: add | list");
            return;
        }

        if (args[0].equals("add")) {

            if (args.length < 2) {
                System.out.println("Digite a descrição da tarefa");
                return;
            }

            int id = tasks.size() + 1;

            Task task = new Task(id, args[1]);

            tasks.add(task);

            TaskStorage.saveTasks(tasks);

            System.out.println("Tarefa adicionada: " + task.getDescription());
        }

        if (args[0].equals("list")) {

            if (tasks.isEmpty()) {
                System.out.println("Nenhuma tarefa encontrada");
                return;
            }

            for (Task task : tasks) {
                System.out.println(
                        task.getId() +
                                ". [" + task.getStatus() + "] " +
                                task.getDescription()
                );
            }
        }

    }
}