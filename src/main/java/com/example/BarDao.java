package com.example;

import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface BarDao extends CrudRepository<Bar, String> {

}
