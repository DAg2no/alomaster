package com.principal.alomaster.repositories;

import com.principal.alomaster.models.Map;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MapRepository extends JpaRepository<Map, Long> {
}
