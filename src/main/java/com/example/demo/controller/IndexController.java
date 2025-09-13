package com.example.demo.controller;

import com.example.demo.dto.CarDTO;
import com.example.demo.model.Car;
import com.example.demo.service.CarServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car")
public class IndexController {

    private CarServiceImpl carService;

    public IndexController(CarServiceImpl carService) {
        this.carService = carService;
    }

    @GetMapping("/")
    public String index() {
        return "<h1>Hello, World!</h1>";
    }

    @GetMapping("/mostrar")
    public ResponseEntity<List<CarDTO>> getCarros() {
        List<CarDTO> carros = carService.findAll();
        return ResponseEntity.ok().body(carros);
    }

    @PostMapping("/enviar")
    public ResponseEntity<String> criarCarro(@RequestBody @Valid CarDTO carro) {
        carService.save(carro);
        return ResponseEntity.ok("Carro armazenado com sucesso!");
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<String> editarCarro(@PathVariable String id, @RequestBody @Valid CarDTO carro) {
        carService.update(id, carro);
        return ResponseEntity.ok("Carro editado com sucesso!");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCar(@PathVariable String id) {
        carService.deleteById(id);
        return ResponseEntity.ok("Carro deletado com sucesso!");
    }
}
