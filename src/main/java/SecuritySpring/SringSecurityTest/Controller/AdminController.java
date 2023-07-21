package SecuritySpring.SringSecurityTest.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {
@GetMapping("/admin")
    public String helloThere(){
        return "Hello by admin";
    }
}
