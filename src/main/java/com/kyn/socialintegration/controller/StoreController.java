package com.kyn.socialintegration.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kyn.socialintegration.dto.StorePostDto;
import com.kyn.socialintegration.entity.Store;
import com.kyn.socialintegration.repository.StoreRepository;
import com.kyn.socialintegration.repository.UserRepository;
import com.kyn.socialintegration.service.StoreService;

@RestController
@RequestMapping("/api/store")
public class StoreController {
	@Autowired
    private UserRepository userRepository;
	@Autowired
	private StoreRepository storeRepository;
	@Autowired
	private StoreService storeService;

	//Post new store
	@PostMapping(value = "/post-store")
	public ResponseEntity<String> postStore(@RequestBody StorePostDto storeNew) {
		Store checkPhoneNum= storeRepository.findByPhone(storeNew.getPhone());
		
		if (checkPhoneNum != null) {
			return new ResponseEntity<>("Phone number already taken",HttpStatus.BAD_REQUEST);
		} 
			Store sto = new Store();
			sto.setName(storeNew.getName());
			sto.setPhone(storeNew.getPhone());
			sto.setLocalities(storeNew.getLocalities());
			sto.setDescription(storeNew.getDescription());
			storeRepository.save(sto);
			return new ResponseEntity<>("Post Store Successful! ",HttpStatus.OK);
		
	}
	//Search neigbour based on name, phone, localities
	@GetMapping("/search")
	public List<Store> searchStore(@RequestParam("keyword") String keyword) {
		List<Store> result = storeRepository.search(keyword);
		
		return result;		
	}
	@GetMapping("/store-list")
	public List<Store> Storelist() {
		List<Store> result = storeRepository.findAll();
		
		return result;		
	}
//	 View Store detail
	@GetMapping("/store-detail")
	public Store carDetail(@RequestParam("sid") long sid) {
		Store detail = storeRepository.findById(sid).get();
		return detail;		
	}
	@DeleteMapping(value = "/deleteStore/{id}")
	public void deleteStore(@PathVariable Integer id) {
	    System.out.println("Received delete request for store with id " + id);
	    storeService.deletestoreById(id);
	}
}
