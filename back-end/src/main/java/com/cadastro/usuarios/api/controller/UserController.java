package com.cadastro.usuarios.api.controller;

import com.cadastro.usuarios.application.contracts.reponse.UserReesponse;
import com.cadastro.usuarios.application.contracts.request.UserRequest;
import com.cadastro.usuarios.application.useCase.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin
public class UserController {

        private final UserService userService;

        public UserController(UserService userService) {
            this.userService = userService;
        }

        @GetMapping
        public List<UserReesponse> findAll() {
            return userService.findAll();
        }

        @GetMapping("/{id}")
        public UserReesponse findById(@PathVariable Long id) {
            return userService.findById(id);
        }

        @PostMapping
        public UserReesponse insert(@RequestBody UserRequest request) {
            return userService.insert(request);
        }

        @PutMapping("/{id}")
        public UserReesponse update(
                @PathVariable Long id,
                @RequestBody UserRequest request) {
            return userService.update(request, id);
        }

        @DeleteMapping("/{id}")
        public void deleteById(@PathVariable Long id) {
            userService.deleteById(id);
        }
}
