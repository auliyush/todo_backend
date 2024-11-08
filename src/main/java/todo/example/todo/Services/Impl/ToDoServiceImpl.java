package todo.example.todo.Services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import todo.example.todo.Models.CreateRequests.ToDoCreateRequest;
import todo.example.todo.Models.ToDo;
import todo.example.todo.Models.User;
import todo.example.todo.Repositories.ToDoRepository;
import todo.example.todo.Services.ToDoService;
import todo.example.todo.Services.UserService;

import java.util.List;

@Service
public class ToDoServiceImpl implements ToDoService {

    @Autowired
    private ToDoRepository toDoRepository;

    @Autowired
    private UserService userService;

    @Override
    public Boolean createToDo(ToDoCreateRequest toDoCreateRequest) {
        User user = userService.getUserById(toDoCreateRequest.getUserId());
        if (user != null) {
            for (ToDo todo : getAllTodoByUserId(user.getUserId())) {
                if (todo.getTodo().equals(toDoCreateRequest.getTodo())) {
                    return false;
                }
            }
            ToDo toDo = new ToDo();
            toDo.setUserId(toDoCreateRequest.getUserId());
            toDo.setTodo(toDoCreateRequest.getTodo());
            toDo.setActive(true);
            toDo.setComplete(false);
            toDoRepository.save(toDo);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<ToDo> getAllTodoByUserId(String userId) {
        User user = userService.getUserById(userId);
        if (user != null) {
            return toDoRepository.findAllByUserIdAndIsActive(userId,true);
        } else {
            return null;
        }
    }

    @Override
    public List<ToDo> getAllInCompleteToDo(String userId) {
        User user = userService.getUserById(userId);
        if (user != null) {
            return toDoRepository.findAllByUserIdAndIsComplete(userId,false);
        } else {
            return null;
        }
    }

    @Override
    public boolean completeTodo(String userId, String todoId) {
        User user = userService.getUserById(userId);
        if (user != null) {
            ToDo toDo = toDoRepository.findByTodoId(todoId);
            if (toDo != null) {
                toDo.setComplete(true);
                toDoRepository.save(toDo);
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public boolean deleteTodo(String userId, String todoId) {
        User user = userService.getUserById(userId);
        if (user != null) {
            ToDo toDo = toDoRepository.findByTodoId(todoId);
            if (toDo != null) {
                toDo.setActive(false);
                toDoRepository.save(toDo);
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
