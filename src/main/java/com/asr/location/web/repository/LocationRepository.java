package com.asr.location.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asr.location.web.model.Location;

public interface LocationRepository extends JpaRepository<Location, Integer> {

}
