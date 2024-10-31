package todo.example.todo.Services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import todo.example.todo.Models.CreateRequests.LoginCreateRequest;
import todo.example.todo.Models.CreateRequests.UserCreateRequest;
import todo.example.todo.Models.Response.LoginResponse;
import todo.example.todo.Models.User;
import todo.example.todo.Services.AppService;
import todo.example.todo.Services.LoginResponseService;
import todo.example.todo.Services.UserService;

import java.time.LocalDateTime;

@Service
public class AppServiceImpl implements AppService {

    @Autowired
    private UserService userService;

    @Autowired
    private LoginResponseService loginResponseService;

    @Override
    public Boolean signUp(UserCreateRequest userCreateRequest) {
        User user = userService.getUserByPhoneNumber(userCreateRequest.getPhoneNumber());
        if (user != null) {
            return false;
        } else {
            userService.createUser(userCreateRequest);
            return true;
        }
    }

    @Override
    public LoginResponse signIn(LoginCreateRequest loginCreateRequest) {
        User user = userService.getUserByPhoneNumber(loginCreateRequest.getPhoneNumber());
        if (user != null) {
            if (user.getPassword().equals(loginCreateRequest.getPassword())) {
                LoginResponse loginResponse = new LoginResponse(user.getUserId(), LocalDateTime.now());
                loginResponseService.saveLoginResponse(loginResponse);
                return loginResponse;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }
}
