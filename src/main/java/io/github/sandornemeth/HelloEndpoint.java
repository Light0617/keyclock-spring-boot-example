package io.github.sandornemeth;

import java.security.Principal;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * External gateway.
 *
 * @author Sandor Nemeth <sandor.nemeth.1986@gmail.com>
 */
@RestController
public class HelloEndpoint {

    @Secured("ROLE_ADMIN")
//    @Secured("ROLE_USER")
    @GetMapping("/admin/hello")
    public String sayHelloToAdmin(final Principal principal) {
        return "Hello Admin: " + principal.getName();
    }

//    @Secured("ROLE_USER")
//    @Secured("ROLE_ADMIN")
    @GetMapping("/user/hello")
    public String sayHelloToUser(final Principal principal) {
        return "Hello User: " + principal.getName();
    }

    @GetMapping("/guest/hello")
    public String sayHelloToGuest() {
        return "Hello Guest";
    }
}
