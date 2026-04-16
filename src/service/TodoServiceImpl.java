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
        todoRepository.add(date, new Todo(time, task, false)); // 이렇게도 작성 가능
    }

    @Override
    public List<Todo> getTodosByDate(String date) {
        return todoRepository.findByDate(date); // repository에 전달
    }

    @Override
    public Map<String, List<Todo>> getAllTodos() {
        return todoRepository.findAll();
    }

    @Override
    public void updateTodo(String date, int index, String time, String task) {
        todoRepository.update(date, index, new Todo(time, task, false)); // repository에 전달
    }

    @Override
    public void deleteTodo(String date, int index) {
        todoRepository.delete(date, index);
    }

    @Override
    public void completeTodo(String date, int index) {
        todoRepository.complete(date, index);
    }
}