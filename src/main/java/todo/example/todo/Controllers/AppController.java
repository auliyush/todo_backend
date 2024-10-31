package todo.example.todo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import todo.example.todo.Models.CreateRequests.LoginCreateRequest;
import todo.example.todo.Models.CreateRequests.UserCreateRequest;
import todo.example.todo.Models.Response.LoginResponse;
import todo.example.todo.Services.AppService;

@RestController
@RequestMapping("/todo")
@CrossOrigin(origins = "*")
public class AppController {

    @Autowired
    private AppService appService;

    @PostMapping("/signUp")
    public Boolean signUp(@RequestBody UserCreateRequest userCreateRequest) {
        return appService.signUp(userCreateRequest);
    }

    @PostMapping("/signIn")
    public LoginResponse signIn(@RequestBody LoginCreateRequest loginCreateRequest) {
        return appService.signIn(loginCreateRequest);
    }


}
