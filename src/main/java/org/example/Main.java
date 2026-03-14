package org.example;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws Exception {

        ArrayList<Task> tasks = TaskStorage.loadTasks();
        TaskService taskService = new TaskService(tasks);

        System.out.println("Lista de tarefas");

        if (args.length == 0) {
            System.out.println("Use um comando: add | list | update | delete");
            return;
        }

        if (args[0].equals("add")) {
            taskService.addTask(args[1]);
        }

        if (args[0].equals("list")) {
            taskService.listTask();
        }

        if (args[0].equals("update")) {
            if (args.length < 2) {
                System.out.println("Digite o id e a atualizacao de status: progress | done");
                return;
            }
            taskService.updateTask(Integer.parseInt(args[1]), args[2]);
        }

        if (args[0].equals("delete")) {
            if (args.length < 2) {
                System.out.println("Digite o id: ");
                return;
            }
            taskService.deleteTask(Integer.parseInt(args[1]));
        }

    }
}