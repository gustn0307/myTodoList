package repository;

import vo.Todo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 실제 데이터를 저장하고 조회하는 계층
public class TodoRepositoryImpl implements TodoRepository{
    private final Map<String, List<Todo>> todoMap = new HashMap<>(); // 내부 저장소

    @Override
    public void add(String date, Todo todo) {
        if(todoMap.containsKey(date)){ // 날짜 존재하면 해당 날짜에 할 일 추가
            todoMap.get(date).add(todo); // 해당 날짜의 할 일 List에 할 일 추가
            System.out.println(todoMap); // 테스트 출력
            return; // 추가하고 메서드 종료
        }
        // 날짜 존재하지 않으면 해당 날짜를 키로 가지는 할 일 추가
        // 컬렉션은 null 대신 빈 컬렉션을 반환한다.(실무 규칙)
        // 컬렉션은 Optional 사용하지 않는다. (단일 객체 조회는 Optional 사용함)
        todoMap.put(date, new ArrayList<>()); // 날짜를 추가하고 null 방지를 위해 빈 리스트를 추가(실무 규칙)
        todoMap.get(date).add(todo); // 새로 생긴 날짜에 할 일 추가
        System.out.println(todoMap); // 테스트 출력
    }

    @Override
    public List<Todo> findByDate(String date) {
        List<Todo> todos = new ArrayList<>();
        for (String key : todoMap.keySet()) { // 순회해서 해당 날짜의 할 일 List 반환
            if(date.equals(key)){ // 일치하는 날짜 있으면 리스트에 추가
                return todoMap.get(key); // 일치하는 날짜의 할 일 리스트 반환
            }
        }

        // 순회해서 입력한 날짜가 없으면 날짜와 빈 리스트 추가
        // 컬렉션은 null 대신 빈 컬렉션을 반환한다.(실무 규칙)
        // 컬렉션은 Optional 사용하지 않는다. (단일 객체 조회는 Optional 사용함)
        todoMap.put(date, new ArrayList<>()); // 날짜를 추가하고 null 방지를 위해 빈 리스트를 추가(실무 규칙)
        return todoMap.get(date); // 찾는 날짜가 없으면 빈 리스트를 반환
    }

    @Override
    public Map<String, List<Todo>> findAll() {
        return Map.of();
    }

    @Override
    public void update(String date, int index, Todo todo) {

    }

    @Override
    public void delete(String date, int index) {

    }

    @Override
    public void complete(String date, int index) {

    }
}
