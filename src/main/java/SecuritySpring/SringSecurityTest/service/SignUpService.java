package SecuritySpring.SringSecurityTest.service;



import SecuritySpring.SringSecurityTest.models.Customer;
import SecuritySpring.SringSecurityTest.models.Role;
import SecuritySpring.SringSecurityTest.repositories.ICustomerRepository;
import SecuritySpring.SringSecurityTest.repositories.IRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;




@Service
@Transactional
public class SignUpService {

    @Autowired
    ICustomerRepository customerRepository;

    @Autowired
    IRoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;


    public Customer registerCustomer(String username, String password){

            String encodedPassword= passwordEncoder.encode(password);
             Role userRole =   roleRepository.findByAuthority("ADMIN");// dipende che ruolo vuoi settare USER o ADMIN
             Set<Role> authorities= new HashSet<>();
            authorities.add(userRole);
         return customerRepository.save(new Customer(username,encodedPassword,authorities ));
        }



}
