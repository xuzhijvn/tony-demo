package com.tony;

import com.tony.springrediscache.User;
import com.tony.springrediscache.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
@RequestMapping("/spring-redis-cache")
public class SpringRedisCacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringRedisCacheApplication.class, args);
    }

    @Autowired
    private UserService userService;

    @RequestMapping("/find/{id}")
    public Object find(@PathVariable(value="id")Integer id) {
        return userService.findUserById(id);
    }
    @RequestMapping("/find2/{id}")
    public Object find2(@PathVariable(value="id")Integer id) {
        return userService.findUserById2(id);
    }

    @GetMapping("/update/{id}/{name}")
    public Object update(@PathVariable(value="id")Integer id, @PathVariable(value="name")String name) {
        return userService.update(new User(id, name));
    }

    @GetMapping("/delete/{id}")
    public Object delete(@PathVariable(value="id")Integer id) {
        userService.deleteById(new User(id));
        return "移除缓存 key = " + id;
    }

    @GetMapping("deleteAll")
    public Object deleteAll() {
        userService.deleteAll();
        return "移除所有缓存";
    }

}
