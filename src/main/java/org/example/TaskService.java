package org.example;

import java.util.ArrayList;

public class TaskService {

    private final ArrayList<Task> tasks;

    public TaskService(ArrayList<Task> tasks){
        this.tasks = tasks;
    }

    public void addTask(String description) throws Exception {

        int id = tasks.size() + 1;

        Task task = new Task(id, description);

        tasks.add(task);

        TaskStorage.saveTasks(tasks);

        System.out.println("Tarefa adicionada: " + task.getDescription());

    }
    public void listTask(){
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
    public void updateTask(int id, String status) throws Exception {
        Task updateTask = fingById(id);
        if (updateTask == null) {
            System.out.println("Tarefa não encontrada");
            return;
        }
       switch (status) {
           case "progress":
               updateTask.markProgress();
               System.out.println("Status atualizado com sucesso");
               break;
           case "done":
               updateTask.markDone();
               System.out.println("Status atualizado com sucesso");
               break;
           default:
               System.out.println("STATUS INVALIDO");
               break;
       }
        TaskStorage.saveTasks(tasks);
    }

    public void deleteTask(int id) throws Exception {
        Task deleteTask = fingById(id);

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

    public Task fingById(int id){
        for (Task task : tasks) {
            if (task.getId() == id) {
                return task;
            }
        }
        return null;
    }
}

