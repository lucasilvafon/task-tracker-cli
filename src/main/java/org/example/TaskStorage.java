package org.example;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class TaskStorage {

    private static final String FILE_NAME = "tasks.json";

    public static ArrayList<Task> loadTasks() throws Exception {

        File file = new File(FILE_NAME);

        if (!file.exists()) {
            return new ArrayList<>();
        }

        Gson gson = new Gson();

        FileReader reader = new FileReader(file);

        Type type = new TypeToken<ArrayList<Task>>(){}.getType();

        ArrayList<Task> tasks = gson.fromJson(reader, type);

        reader.close();

        return tasks;
    }

    public static void saveTasks(ArrayList<Task> tasks) throws Exception {

        Gson gson = new Gson();

        FileWriter writer = new FileWriter(FILE_NAME);

        gson.toJson(tasks, writer);

        writer.close();
    }
}