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

//    @Secured("ROLE_ADMIN")
    @GetMapping("/admin/hello")
    public String sayHelloToAdmin(final Principal principal) {
        return "Hello Admin: " + principal.getName();
    }

    //CORRECT
    @Secured("ROLE_USER")
    @GetMapping("/user/hello")
    public String sayHelloToUser(final Principal principal) {
        return "Hello User: " + principal.getName();
    }

    //for storageuser/123 => 200
    @Secured("ROLE_SECURITYADMINISTRATOR")
    @GetMapping("/volumes/hello")
    public String sayHelloToVolume(final Principal principal) {
        return "Hello volumes: " + principal.getName();
    }

    //for storageuser/123 => 200
    @Secured({"ROLE_SECURITYADMINISTRATOR", "ROLE_STORAGEADMINISTRATOR", "ROLE_SYSTEMADMINISTRATOR"})
    @GetMapping("/storage-systems/hello")
    public String sayHelloToStorageSystems(final Principal principal) {
        return "Hello StorageSystem: " + principal.getName();
    }

    @GetMapping("/guest/hello")
    public String sayHelloToGuest() {
        return "Hello Guest";
    }
}
