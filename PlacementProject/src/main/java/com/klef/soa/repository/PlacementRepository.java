package com.klef.soa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.klef.soa.entity.Placement;

@Repository
public interface PlacementRepository extends JpaRepository<Placement, Long>
{
    List<Placement> findByName(String name);

    List<Placement> findByType(String type);
}