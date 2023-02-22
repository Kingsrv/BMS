package com.srv.BMS.repository;

import com.srv.BMS.model.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheatreRepository extends JpaRepository<Theatre, Long> {

    Theatre save(Theatre theatre);




}
