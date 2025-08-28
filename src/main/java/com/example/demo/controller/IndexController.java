package com.example.demo.controller;

import com.example.demo.model.Car;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/car")
public class IndexController {

    private Car ultimoCarro;

    @GetMapping("/")
    public String index() {
        return "<h1>Hello, World!</h1>";
    }

    @GetMapping("/mostrar")
    public ResponseEntity<Car> getUltimoCarro() {
        return ResponseEntity.ok(ultimoCarro);
    }

    @PostMapping("/enviar")
    public ResponseEntity<String> criarCarro(@RequestBody Car carro) {
        this.ultimoCarro = carro;
        return ResponseEntity.ok("Carro armazenado com sucesso!");
    }
}
