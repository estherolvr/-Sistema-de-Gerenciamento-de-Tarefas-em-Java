import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private List<Task> tasks;
    private int nextId;

    public TaskManager() {
        this.tasks = new ArrayList<>();
        this.nextId = 1;
    }

    public void addTask(String description) {
        Task newTask = new Task(nextId++, description);
        tasks.add(newTask);
        System.out.println("Tarefa adicionada: " + newTask.getDescription());
    }

    public void listTasks() {
        if (tasks.isEmpty()) {
            System.out.println("Nenhuma tarefa cadastrada.");
            return;
        }
        System.out.println("Lista de Tarefas:");
        for (Task task : tasks) {
            System.out.println(task);
        }
    }

    public void updateTaskDescription(int id, String newDescription) {
        Task task = findTaskById(id);
        if (task != null) {
            task.setDescription(newDescription);
            System.out.println("Descrição da tarefa " + id + " atualizada para: " + newDescription);
        } else {
            System.out.println("Tarefa com ID " + id + " não encontrada.");
        }
    }

    public void markTaskCompleted(int id) {
        Task task = findTaskById(id);
        if (task != null) {
            task.setCompleted(true);
            System.out.println("Tarefa " + id + " marcada como concluída.");
        } else {
            System.out.println("Tarefa com ID " + id + " não encontrada.");
        }
    }

    public void deleteTask(int id) {
        Task taskToRemove = null;
        for (Task task : tasks) {
            if (task.getId() == id) {
                taskToRemove = task;
                break;
            }
        }
        if (taskToRemove != null) {
            tasks.remove(taskToRemove);
            System.out.println("Tarefa " + id + " removida.");
        } else {
            System.out.println("Tarefa com ID " + id + " não encontrada.");
        }
    }

    private Task findTaskById(int id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                return task;
            }
        }
        return null;
    }
}

