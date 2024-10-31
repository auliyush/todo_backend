package todo.example.todo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import todo.example.todo.Models.CreateRequests.UserCreateRequest;
import todo.example.todo.Models.User;
import todo.example.todo.Services.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public User createUser(@RequestBody UserCreateRequest userCreateRequest) {
        return userService.createUser(userCreateRequest);

    }

    @GetMapping("/get/byId")
    public User getUserById(@RequestParam String userId) {
        return userService.getUserById(userId);
    }

}
