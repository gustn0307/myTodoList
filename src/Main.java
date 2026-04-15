import repository.TodoRepository;
import repository.TodoRepositoryImpl;
import service.TodoService;
import service.TodoServiceImpl;
import view.TodoView;

import java.util.Scanner;

// 프로그램 시작 및 객체 연결
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        TodoRepository todoRepository = new TodoRepositoryImpl();
        TodoService todoService = new TodoServiceImpl(todoRepository); // 생성자 주입 방식
        TodoView todoView = new TodoView(sc, todoService);

        todoView.start();
    }
}
