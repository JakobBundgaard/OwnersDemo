package com.bundgaard.demo.Repositorys;

import com.bundgaard.demo.Models.Dog;
import org.springframework.data.repository.CrudRepository;

public interface DogRepo extends CrudRepository<Dog, Long> {

}