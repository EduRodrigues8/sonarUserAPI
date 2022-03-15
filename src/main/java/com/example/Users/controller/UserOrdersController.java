// package com.example.Users.controller;

// import com.example.Users.repository.userOrdersRepository;
// // import com.example.Users.service.OrderService;
// import com.example.Users.models.userOrders;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.CrossOrigin;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestHeader;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import java.util.List;
// import java.util.Optional;

// // configura para chamar um comando específico da url

// @RestController
// @CrossOrigin
// @RequestMapping("/orders")
// public class UserOrdersController {
// @Autowired
// private OrderService service;

// @Autowired
// private userOrdersRepository userOrdersRepository;

// // Chama por um 'Id' específico de um 'User'.
// @GetMapping("/orders/{id}")
// public Optional<userOrders> unicaOrder(@PathVariable(value = "id") long id) {
// return userOrdersRepository.findById(id);
// }

// // Lista as 'orders' que já obtiveram cadastro.
// @GetMapping
// public List<userOrders> listar() {
// return userOrdersRepository.findAll();
// }

// // Atualiza a 'order' de um 'User' que já estava inserida.
// @PutMapping
// public userOrders atualizaUser(@RequestBody userOrders user) {
// return userOrdersRepository.save(user);
// }

// // Adiciona uma 'Order'.
// @PostMapping()
// public ResponseEntity<?> adicionar(@RequestHeader("Authorization") String
// token, String simbolo,
// @RequestBody userOrders userOrders) {
// return service.save(userOrders, simbolo, token);
// }
// }