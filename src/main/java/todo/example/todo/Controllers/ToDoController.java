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
    public ToDo createToDo(@RequestBody ToDoCreateRequest toDoCreateRequest) {
        return toDoService.createToDo(toDoCreateRequest);
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
    public boolean deleteTodo(@RequestParam String todoId, String userId) {
        return toDoService.deleteTodo(todoId, userId);
    }
}
