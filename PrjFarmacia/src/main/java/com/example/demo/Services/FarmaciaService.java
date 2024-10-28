package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Farmacia;
import com.example.demo.repositories.FarmaciaRepository;

@Service
public class FarmaciaService {
   
   private final com.example.demo.repositories.FarmaciaRepository FarmaciaRepository;
   
   
   @Autowired
   public FarmaciaService(com.example.demo.repositories.FarmaciaRepository farmaciaRepository) {
    this.FarmaciaRepository = farmaciaRepository;
   }
   
   public Farmacia salvarfarmacia(Farmacia farmacia) {
       return FarmaciaRepository.save(farmacia);
       
   }
   
   public Farmacia buscarFarmaciaPorId(Long id) {
       return FarmaciaRepository.findById(id).orElse(null);
   }
   
   public List<Farmacia> buscarTodosFarmacias(){
       return FarmaciaRepository.findAll();
   }
   
   public void excluirFarmacia(Long id) {
	   FarmaciaRepository.deleteById(id);
   }
   public Farmacia atualizarFarmacia(Long id, Farmacia farmaciaAtualizado) {
       Optional<Farmacia> farmaciaExistente = FarmaciaRepository.findById(id);
       if(farmaciaExistente.isPresent()) {
    	   Farmacia farmacia = farmaciaExistente.get();
           farmacia.setNome(farmaciaAtualizado.getNome());
           farmacia.setBula(farmaciaAtualizado.getBula());
           farmacia.setAttribute12(farmaciaAtualizado.getAttribute12());
           return FarmaciaRepository.save(farmacia);
       }
       else
       {
           return null;
       }
   }
}