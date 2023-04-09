package com.kyn.socialintegration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kyn.socialintegration.repository.StoreRepository;



@Service
public class StoreServiceImpl implements StoreService {

	@Autowired
	private StoreRepository storeRepo;
	public void deletestoreById(int id) {

		storeRepo.deleteById((long) id);
	}
	@Override
	public void deletestoreById(long id) {
		// TODO Auto-generated method stub
		
	}

}