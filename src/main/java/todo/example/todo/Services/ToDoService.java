package todo.example.todo.Services;

import todo.example.todo.Models.CreateRequests.ToDoCreateRequest;
import todo.example.todo.Models.ToDo;

import java.util.List;

public interface ToDoService {

    Boolean createToDo(ToDoCreateRequest toDoCreateRequest);

    List<ToDo> getAllTodoByUserId(String userId);

    boolean completeTodo(String userId, String todoId);

    boolean deleteTodo(String userId, String todoId);

    List<ToDo> getAllInCompleteToDo(String userId);
}
