package com.bundgaard.demo.Repositorys;

import com.bundgaard.demo.Models.Dog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface DogRepo extends PagingAndSortingRepository<Dog, Long> {

}