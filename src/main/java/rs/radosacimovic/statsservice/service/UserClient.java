package rs.radosacimovic.statsservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import rs.radosacimovic.statsservice.model.User;

import java.util.List;

@FeignClient("user-service")
public interface UserClient {
    @GetMapping(value = "/api/users?role=SELLER")
    List<User> getSellers();
}
