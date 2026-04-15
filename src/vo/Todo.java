package vo;

// 할 일 데이터를 담는 객체 클래스
public class Todo {
    private String time; // 시간
    private String task; // 할 일 내용
    private boolean completed; // 완료 여부

    public Todo() {
    }

    public Todo(String time, String task, boolean completed) {
        this.time = time;
        this.task = task;
        this.completed = completed;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return time + " | " + task + " | " + (completed ? "완료" : "미완료");
    }
}
