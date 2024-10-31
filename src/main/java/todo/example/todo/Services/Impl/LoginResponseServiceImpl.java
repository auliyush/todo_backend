package todo.example.todo.Services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import todo.example.todo.Models.Response.LoginResponse;
import todo.example.todo.Repositories.LoginResponseRepository;
import todo.example.todo.Services.LoginResponseService;

@Service
public class LoginResponseServiceImpl implements LoginResponseService {

    @Autowired
    private LoginResponseRepository loginResponseRepository;

    @Override
    public Boolean saveLoginResponse(LoginResponse loginResponse) {
        loginResponseRepository.save(loginResponse);
        return true;
    }
}
