package com.bundgaard.demo.Repositorys;

import com.bundgaard.demo.Models.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
}