package org.example;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws Exception {

        ArrayList<Task> tasks = TaskStorage.loadTasks();
        TaskService taskService = new TaskService(tasks);

        System.out.println("Lista de tarefas");


        switch (args[0]){
            case "add":
                taskService.addTask(args[1]);
                break;
            case "list":
                taskService.listTask();
                break;
            case "update":
                if (args.length < 2) {
                    System.out.println("Digite o id e a atualizacao de status: progress | done");
                    return;
                }
                taskService.updateTask(Integer.parseInt(args[1]), args[2]);
                break;
            case "delete":
                if (args.length < 2) {
                    System.out.println("Digite o id: ");
                    return;
                }
                taskService.deleteTask(Integer.parseInt(args[1]));
            default:
                if (args.length == 0) {
                    System.out.println("Use um comando: add | list | update | delete");
                    return;
                }
        }
    }
}