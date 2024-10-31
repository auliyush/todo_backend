package todo.example.todo.Services;

import todo.example.todo.Models.CreateRequests.ToDoCreateRequest;
import todo.example.todo.Models.ToDo;

import java.util.List;

public interface ToDoService {

    ToDo createToDo(ToDoCreateRequest toDoCreateRequest);

    List<ToDo> getAllTodoByUserId(String userId);

    boolean completeTodo(String userId, String todoId);

    boolean deleteTodo(String todoId, String userId);
}
