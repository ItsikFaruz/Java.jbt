package app.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import app.core.entites.Person;

public interface PersonRepository extends JpaRepository<Person,Integer>{

}
