package com.bundgaard.demo.Service;

import com.bundgaard.demo.Models.Dog;

import java.util.List;

public interface DogService extends CrudService<Dog, Long>{
    public List<Dog> getOwnerlessDogs();
    public List<Dog> getDogs(int start, int number);
}
