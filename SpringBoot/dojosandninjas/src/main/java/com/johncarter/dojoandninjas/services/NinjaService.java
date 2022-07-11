package com.johncarter.dojoandninjas.services;

import java.util.List;
import java.util.Optional;

import com.johncarter.dojosandninjas.models.Dojo;
import com.johncarter.dojosandninjas.models.Ninja;
import com.johncarter.dojosandninjas.repositories.NinjaRepository;

public class NinjaService {
	private final NinjaRepository repo;
    
    public NinjaService(NinjaRepository repo) {
        this.repo = repo;
    }
    // returns all the ninjas
    public List<Ninja> all() {
        return repo.findAll();
    }
    // creates a ninja
    public Ninja create(Ninja ninja) {
        return repo.save(ninja);
    }
    // retrieves a ninja
    public Ninja find(Long id) {
        Optional<Ninja> result = repo.findById(id);
        if(result.isPresent()) {
            return result.get();
        } else {
            return null;
        }
    }
    public List<Ninja> byDojo(Dojo dojo) {
    	return repo.findAllByDojo(dojo);
    }
}
