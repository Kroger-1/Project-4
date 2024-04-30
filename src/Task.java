

import java.util.Collections;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

class Task implements Comparable<Task>, Iterable{
    private String taskTitle;
    private String taskDescription;
    private int taskPriority;

    public Task(String taskTitle, String taskDescription, int taskPriority) {
        this.taskTitle = taskTitle;
        this.taskDescription = taskDescription;
        this.taskPriority = taskPriority;
    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public int getTaskPriority() {
        return taskPriority;
    }

    public void setTaskPriority(int taskPriority) {
        this.taskPriority = taskPriority;
    }


    @Override
    public String toString() {
        return "Task{" +
                "taskTitle='" + taskTitle + '\'' +
                ", taskDescription='" + taskDescription + '\'' +
                ", taskPriority=" + taskPriority +
                '}';
    }

    @Override
    public int compareTo(Task o) {
        if (taskPriority > o.taskPriority) {
            return -1;
        } else if (taskPriority < o.taskPriority) {
            return 1;
        } else {
            return this.taskTitle.compareTo(o.taskTitle);
        }
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer action) {
        Iterable.super.forEach(action);
    }

    @Override
    public Spliterator spliterator() {
        return Iterable.super.spliterator();
    }
}