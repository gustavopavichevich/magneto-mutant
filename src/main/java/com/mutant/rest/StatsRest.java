package com.mutant.rest;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.mutant.model.dao.IStatsDao;
import com.mutant.model.entity.Data;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = { "*" })
public class StatsRest {
	

	@Autowired
	IStatsDao statsDao;
	
	@PostMapping(path = "/stats", produces = "application/json")
	public ResponseEntity<?> obtenerPersonal() {

		System.out.println("Count humanDna : " + statsDao.countByHumanDnaNotNull());
		System.out.println("Count mutantDna : " + statsDao.countByMutantDnaNotNull());
		System.out.println("Count humanDna : " + statsDao.count());
		
		Map<String, Object> response = new HashMap<>();
		Gson gson = new Gson();
		Data data = new Data();
		
		//recupero datos de la base
		
		
		
		data.setCount_mutant_dna("");
		data.setCount_human_dna("");
		data.setRatio(0.3);
		String ADN = gson.toJson(data);
		
		response.put("ADN",ADN);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
}
