import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nSistema de Gerenciamento de Tarefas");
            System.out.println("1. Adicionar Tarefa");
            System.out.println("2. Listar Tarefas");
            System.out.println("3. Atualizar Descrição da Tarefa");
            System.out.println("4. Marcar Tarefa como Concluída");
            System.out.println("5. Excluir Tarefa");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Digite a descrição da tarefa: ");
                    String description = scanner.nextLine();
                    taskManager.addTask(description);
                    break;
                case 2:
                    taskManager.listTasks();
                    break;
                case 3:
                    System.out.print("Digite o ID da tarefa para atualizar: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Digite a nova descrição: ");
                    String newDescription = scanner.nextLine();
                    taskManager.updateTaskDescription(updateId, newDescription);
                    break;
                case 4:
                    System.out.print("Digite o ID da tarefa para marcar como concluída: ");
                    int completeId = scanner.nextInt();
                    taskManager.markTaskCompleted(completeId);
                    break;
                case 5:
                    System.out.print("Digite o ID da tarefa para excluir: ");
                    int deleteId = scanner.nextInt();
                    taskManager.deleteTask(deleteId);
                    break;
                case 6:
                    System.out.println("Saindo do sistema.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}

