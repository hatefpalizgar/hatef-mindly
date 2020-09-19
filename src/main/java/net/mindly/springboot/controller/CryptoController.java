package net.mindly.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.mindly.springboot.exception.ResourceNotFoundException;
import net.mindly.springboot.model.Crypto;
import net.mindly.springboot.repository.CryptoRepository;

@CrossOrigin(origins="https://alaz7622356694.github.io/**")
@RestController
@RequestMapping("/api/")
public class CryptoController {
	
	@Autowired
	private CryptoRepository cryptoRepository;
	
    @GetMapping("/crypto")	
    public List<Crypto> getAllCrypto(){
	 return cryptoRepository.findAll();
}
    @PostMapping("/crypto")
    public Crypto AddCrypto ( @RequestBody Crypto crypto){
	 return cryptoRepository.save(crypto);}
    
  
   @DeleteMapping("/crypto/{id}")
   public ResponseEntity < Map<String, Boolean>> deleteCrypto(@PathVariable Long id){
	   Crypto crypto=cryptoRepository.findById(id).orElseThrow(() -> 
       new ResourceNotFoundException("Crypto not exist with id :" + id));
	   
	   cryptoRepository.delete(crypto);
	   Map<String,Boolean> response = new HashMap<>();
	   response.put("deleted",Boolean.TRUE);
	   return ResponseEntity.ok(response);
   }
    
}
	 
	
	 
	 
	 


