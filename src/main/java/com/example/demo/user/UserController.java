package com.example.demo.user;

import com.example.demo.products.Product;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private final UserService userService;

    UserController(UserService  userService){
        this.userService=userService;
    }


    @GetMapping("/Users")
    public List<User> getall(){
        return userService.getall();
    }

    @GetMapping("/Users/{id}")
    public User getUserById(@PathVariable int id){
        return userService.findById(id);}


    @PostMapping("/addeduser")
    @ResponseBody
    public User addUser(@RequestParam int id, @RequestParam String firstname, @RequestParam String lastname , @RequestParam String email,
        @RequestParam("Address.Street") String Street , @RequestParam("Address.zip") int zip, @RequestParam("Address.City") String City, @RequestParam("Address.Country") String Country){
        return userService.addnewUser(id,firstname,lastname,email,Street,zip,City, Country);
    }

}
