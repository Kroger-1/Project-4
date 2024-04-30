import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.*;

public class Main {
    public static Scanner input = new Scanner(System.in);
    public static ArrayList<Task> tasks = new ArrayList<>();
    public static void main(String[] args) {
        deserializeTask();

        String[] events = new String[]{"(1) Add a Task", "(2) Remove a Task", "(3) Update Task", "(4) List tasks", "(5) List Tasks by Priority", "(6) Quit"};

        String taskSelect = "";


        while (!taskSelect.equals("6")) {
            for(String event : events) {
                System.out.println(event);
            }

            System.out.println("What do you wanna do?");
            taskSelect = input.nextLine();
            if (taskSelect.equals("1")) {
                addTasks();
            }

            if (taskSelect.equals("2")) {
                removeTasks();
            }

            if (taskSelect.equals("3")) {
                updateTasks();
            }

            if (taskSelect.equals("4")) {
                listTasks();
            }
            if (taskSelect.equals("5")) {
                taskByPriority();
            }
        }
        System.out.println("Json with Gson");
        serializeTask();

    }

    static void serializeTask(){

         Gson gson = new Gson();
        try (FileWriter writer = new FileWriter("data.json")) {
            gson.toJson(tasks,writer);
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
    static void deserializeTask(){
        try{
            FileReader reader = new FileReader("data.json");
            JsonParser parser = new JsonParser();
            JsonElement element = parser.parse(reader);
            Gson gson = new Gson();
            Type type = new TypeToken<ArrayList<Task>>(){}.getType();
            tasks = gson.fromJson(element, type);
            System.out.println(tasks);



        }catch (IOException e){
            e.printStackTrace();
        }
    }

    static void addTasks() {

        System.out.println("What's the title?");
        String taskTitle = input.nextLine();

        System.out.println("What's the tasks description?");
        String taskDesc = input.nextLine();

        System.out.println("What is the tasks priority?");
        int taskPriority = input.nextInt();
        input.nextLine();

        Task newTask = new Task(taskTitle, taskDesc, taskPriority);
        tasks.add(newTask);


    }

    static void removeTasks() {

        System.out.println("What task would you like to remove...");
        System.out.println(tasks);
        int removeTask = input.nextInt();
        input.nextLine();
        tasks.remove(removeTask);
    }

    static void updateTasks() {
        System.out.println("What do you want to update?");
        System.out.println(tasks);
        System.out.println("Update a task...");
        input.nextLine();
    }

    static void listTasks() {
        String taskSelector = "";
        String individualTask = "";

        System.out.println("Would you like to list one task or all tasks? (1, 2)");
        taskSelector = input.nextLine();
        if (taskSelector.equals("1")) {
            System.out.println("Which task to list? (Use Numbers)");
            individualTask = input.nextLine();
            System.out.println(tasks.get(Integer.parseInt(individualTask)));
        } else if (taskSelector.equals("2")) {

            //Project 3
            //You have go from list tasks -> 2 | automatically lists them sorted

            Collections.sort(tasks);
            for (Task task : tasks) {
                System.out.println(task);
            }
        } else {
            System.out.println("Not a Valid Option");
        }
    }

    static void taskByPriority() {
        try {
            System.out.println("Which priority would you like to list?");
            int priority = input.nextInt();
            input.nextLine();

            for (Task task : tasks) {
                if (task.getTaskPriority() == priority) {
                    System.out.println(task);
                }
            }
        } catch (Exception e) {
            System.out.println("Not a Valid Number");
        }

    }
}
//For testing purposes
class Taskjson {
    private String taskTitle;
    private String taskDescription;
    private int taskPriority;

    public Taskjson(String taskTitle, String taskDescription, int taskPriority) {
        this.taskTitle = taskTitle;
        this.taskDescription = taskDescription;
        this.taskPriority = taskPriority;
    }

    @Override
    public String toString() {
        return "Taskjson{" +
                "taskTitle='" + taskTitle + '\'' +
                ", taskDescription='" + taskDescription + '\'' +
                ", taskPriority=" + taskPriority +
                '}';
    }
}



