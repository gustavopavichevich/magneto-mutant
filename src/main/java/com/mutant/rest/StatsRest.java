package com.mutant.rest;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.mutant.model.dao.IStatsDao;
import com.mutant.model.entity.Data;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = { "*" })
public class StatsRest {
	

	@Autowired
	IStatsDao statsDao;
	
	@Async
	@PostMapping(path = "/stats", produces = "application/json")
	public ResponseEntity<?> obtenerPersonal() {

		Map<String, Object> response = new HashMap<>();
		Gson gson = new Gson();
		Data data = new Data();
		
		//recupero datos de la base
		
		data.setCount_mutant_dna(statsDao.countByMutantDnaNotNull().toString());
		data.setCount_human_dna(statsDao.countByHumanDnaNotNull().toString());
		data.setRatio((statsDao.count()/statsDao.countByMutantDnaNotNull()));
		String ADN = gson.toJson(data);
		
		response.put("ADN",ADN);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
}
