package SecuritySpring.SringSecurityTest.Controller;


import SecuritySpring.SringSecurityTest.models.Customer;
import SecuritySpring.SringSecurityTest.models.DTO.RegistrationDTO;
import SecuritySpring.SringSecurityTest.service.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/utente")
public class SignUpController {

    @Autowired
    SignUpService signUpService;


    @PostMapping("/register")
    public Customer registrazione(@RequestBody RegistrationDTO body){

        return signUpService.registerCustomer(body.getUsername(),body.getPassword());
    }




}