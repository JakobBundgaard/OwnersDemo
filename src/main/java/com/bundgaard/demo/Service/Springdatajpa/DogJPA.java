package com.bundgaard.demo.Service.Springdatajpa;

import com.bundgaard.demo.Models.Dog;
import com.bundgaard.demo.Repositorys.DogRepo;
import com.bundgaard.demo.Service.DogService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service // gør at en instans af denne klasse bliver oprettet og sat ind i OwnerController via konstruktør
public class DogJPA implements DogService {

    private final DogRepo dogRepo;

    // Spring vil selv oprette en instans som implementerer OwnerRepository
    public DogJPA(DogRepo dogRepo) {
        this.dogRepo = dogRepo;
    }

    @Override
    public Set<Dog> findAll() {
        Set<Dog> dogs = new HashSet<>();
        dogRepo.findAll().forEach(dogs::add);  //tilføjer alle elementer til set
        return dogs;
    }


    @Override
    public Dog save(Dog object) {
        return dogRepo.save(object);
    }

    @Override
    public void delete(Dog object) {
        dogRepo.delete(object);
    }


    @Override
    public void deleteById(Long aLong) {
        dogRepo.deleteById(aLong);
    }

    @Override
    public Optional<Dog> findById(Long aLong) {
        return dogRepo.findById(aLong);
    }
}
