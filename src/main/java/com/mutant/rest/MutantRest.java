package com.mutant.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.mutant.model.dao.IStatsDao;
import com.mutant.model.entity.DataArray;
import com.mutant.model.entity.Stats;
import com.mutant.util.BloodTest;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = { "*" })
public class MutantRest {
	
	@Autowired
	IStatsDao statsDao;

	@PostMapping(path = "/mutant", consumes = "application/json")
	public ResponseEntity<?> obtenerPersonal(@RequestBody String dna) throws Exception{

		// Declaraciones
		Gson gson = new Gson();
		DataArray dataArray = gson.fromJson(dna, DataArray.class);
		List<String> resultadoAnalisis = new ArrayList<>();
		Map<String, Object> response = new HashMap<>();
		// valido la ocurrencia de los caracteres solicitados por Magneto
		for (String var : dataArray.getDna()) {
			if (!var.matches("^[AGTC]+$")) {
				response.put("mensaje:", "Ingrese un tipo de dato conocido. Solo caracteres: [A,G,T,C].");
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.FORBIDDEN);
			}
		}
		/*
		 * Persistenia de Datos y Muestreo
		 * 
		 */
		BloodTest bloodTest = new BloodTest();
		int dato2 = dataArray.getDna().length;
		char[][] dato1 = new char[dato2][dato2];
		dato1 = dataArray.getMatrizDna().clone();

		resultadoAnalisis = bloodTest.isMutant(dato1, dato2);
		try {
			String strStats = String.join(" ", resultadoAnalisis);

			if (resultadoAnalisis.size() > 1) {/* Guarda en la database el string de ADN mutante */

				Stats stats = new Stats();
				stats.setMutantDna(strStats);
				statsDao.save(stats);

				response.put("mensaje: ", "en esta secuencia se encontró ADN mutante.");
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
			} else {/* Guarda en la database el string de ADN no mutante */

				Stats stats = new Stats();
				stats.setHumanDna(strStats);
				statsDao.save(stats);
		
				response.put("mensaje: ", "en esta secuencia de ADN no es mutante.");
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.FORBIDDEN);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
}