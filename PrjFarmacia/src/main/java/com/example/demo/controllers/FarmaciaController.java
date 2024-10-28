package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Farmacia;
import com.example.demo.Services.FarmaciaService;

@RestController
@RequestMapping("/Farmacia")
public class FarmaciaController {

   private final FarmaciaService farmaciaService;

   @Autowired
   public FarmaciaController(FarmaciaService farmaciaService) {
       this.farmaciaService = farmaciaService;
   }

   @PostMapping
   public Farmacia criarFarmacia(@RequestBody Farmacia farmacia) {
       return farmaciaService.salvarfarmacia(farmacia);
   }

   @GetMapping
   public List<Farmacia> buscarTodos() {
       return farmaciaService.buscarTodosFarmacias();
   }

   @GetMapping("/{id}")
   public Farmacia buscarPorId(@PathVariable Long id) {
       return farmaciaService.buscarFarmaciaPorId(id);
   }

   @DeleteMapping("/{id}")
   public void deletarFarmacia(@PathVariable Long id) {
	   farmaciaService.excluirFarmacia(id);
   }

   @PutMapping
   public ResponseEntity<Farmacia> FarmaciaAtualizado(@PathVariable Long id, @RequestBody Farmacia farmacia) {
       Farmacia farmaciaAtualizado = farmaciaService.atualizarFarmacia(id, farmacia);
       if (farmaciaAtualizado != null) {
           return ResponseEntity.ok(farmaciaAtualizado);
       } else {
           return null;
       }
   }
}