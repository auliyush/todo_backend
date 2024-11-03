package todo.example.todo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import todo.example.todo.Models.CreateRequests.ToDoCreateRequest;
import todo.example.todo.Models.ToDo;
import todo.example.todo.Services.ToDoService;

import java.util.List;

@RestController
@RequestMapping("/todo")
@CrossOrigin(origins = "*")
public class ToDoController {

    @Autowired
    private ToDoService toDoService;

    @PostMapping("/create")
    public Boolean createToDo(@RequestBody ToDoCreateRequest toDoCreateRequest) {
        return toDoService.createToDo(toDoCreateRequest);
    }
    @GetMapping("/get/all/incomplete/toDo")
    public List<ToDo> getAllInCompleteToDo(@RequestParam String userId){
        return toDoService.getAllInCompleteToDo(userId);
    }
    @GetMapping("/get/all/by/userId")
    public List<ToDo> getAllTodoByUserId(@RequestParam String userId) {
        return toDoService.getAllTodoByUserId(userId);
    }

    @PutMapping("/complete")
    public boolean completeTodo(@RequestParam String userId, String todoId) {
        return toDoService.completeTodo(userId, todoId);
    }

    @PutMapping("/remove")
    public boolean deleteTodo(@RequestParam String userId, String todoId) {
        return toDoService.deleteTodo(userId, todoId);
    }
}
