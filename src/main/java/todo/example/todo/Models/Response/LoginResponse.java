package todo.example.todo.Models.Response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@Document(collection = "loginUsers")
public class LoginResponse {
    private String loginId;
    private LocalDateTime dateTime;
}
