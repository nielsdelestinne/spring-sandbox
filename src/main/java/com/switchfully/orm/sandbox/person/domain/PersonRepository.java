package com.switchfully.orm.sandbox.person.domain;

import com.switchfully.orm.sandbox.person.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, String> {
}
