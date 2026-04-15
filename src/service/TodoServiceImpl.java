package service;

import repository.TodoRepository;
import vo.Todo;

import java.util.List;
import java.util.Map;

// View와 Repository 사이에서 기능을 연결하는 계층
public class TodoServiceImpl implements TodoService {
    private final TodoRepository todoRepository;

    public TodoServiceImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public void addTodo(String date, String time, String task) {
        Todo todo = new Todo(time, task, false); // 전달받은 인자를 데이터로 가지는 객체 생성

        todoRepository.add(date, todo); // repository에 전달
    }

    @Override
    public List<Todo> getTodosByDate(String date) {
        return todoRepository.findByDate(date); // repository에 전달
    }

    @Override
    public Map<String, List<Todo>> getAllTodos() {
        return Map.of();
    }

    @Override
    public void updateTodo(String date, int index, String time, String task) {
        Todo todo = new Todo(time, task, false); // 전달받은 인자를 데이터로 가지는 객체 생성
        todoRepository.update(date, index, todo); // repository에 전달
    }

    @Override
    public void deleteTodo(String date, int index) {

    }

    @Override
    public void completeTodo(String date, int index) {

    }
}
