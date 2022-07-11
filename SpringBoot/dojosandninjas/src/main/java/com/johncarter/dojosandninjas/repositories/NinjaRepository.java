package com.johncarter.dojosandninjas.repositories;

import java.util.List;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.johncarter.dojosandninjas.models.Dojo;
import com.johncarter.dojosandninjas.models.Ninja;

@Repository
public interface NinjaRepository extends CrudRepository<Ninja, Long>{
	List<Ninja> findAll();
	List<Ninja> findAllByDojo(Dojo dojo);
}
