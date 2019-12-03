package com.mutant.model.dao;

import org.springframework.data.repository.CrudRepository;

import com.mutant.model.entity.Stats;

public interface IStatsDao extends CrudRepository<Stats, Long>{
	
	public Long countByHumanDnaNotNull();
	
	public Long countByMutantDnaNotNull();
	
}
