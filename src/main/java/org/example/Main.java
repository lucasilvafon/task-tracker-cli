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
        if (args[0].equals("update")) {

            if (args.length < 2) {
                System.out.println("Digite o id: ");
                return;
            }

            int id = Integer.parseInt(args[1]);
            Task updateTask = null;

            for (Task task : tasks) {
                if (task.getId() == id) {
                    updateTask = task;
                    break;
                }
            }

            if (updateTask == null) {
                System.out.println("Tarefa não encontrada");
                return;
            }

            if (args.length < 3) {
                System.out.println("Digite o status: PROGRESS | DONE ");
                return;
            }

            String status = args[2];

            if (status.equalsIgnoreCase("PROGRESS")) {
                updateTask.markInProgress();
            } else if (status.equalsIgnoreCase("DONE")) {
                updateTask.markDone();
            } else {
                System.out.println("STATUS INVÁLIDO");
                return;
            }

            TaskStorage.saveTasks(tasks);

            System.out.println("Status atualizado com sucesso");
        }

        if (args[0].equals("delete")) {

            if (args.length < 2) {
                System.out.println("Digite o id: ");
                return;
            }

            int id = Integer.parseInt(args[1]);
            Task deleteTask = null;

            for (Task task : tasks) {
                if (task.getId() == id) {
                    deleteTask = task;
                    break;
                }
            }

            if (deleteTask == null) {
                System.out.println("Tarefa não encontrada");
                return;
            }

            tasks.remove(deleteTask);

            TaskStorage.saveTasks(tasks);

            System.out.println("Tarefa removida com sucesso");
        }


    }
}