package SecuritySpring.SringSecurityTest.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class UserController {

@GetMapping("/user")
    public String helloThere(){
        return "Hello by User";
    }
}
