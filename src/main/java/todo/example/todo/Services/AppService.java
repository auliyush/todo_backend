package todo.example.todo.Services;

import todo.example.todo.Models.CreateRequests.LoginCreateRequest;
import todo.example.todo.Models.CreateRequests.UserCreateRequest;
import todo.example.todo.Models.Response.LoginResponse;

public interface AppService {

    Boolean signUp(UserCreateRequest userCreateRequest);

    LoginResponse signIn(LoginCreateRequest loginCreateRequest);
}
