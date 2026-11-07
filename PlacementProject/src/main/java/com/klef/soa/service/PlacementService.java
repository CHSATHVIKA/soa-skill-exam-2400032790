package com.klef.soa.service;

import java.util.List;

import com.klef.soa.dto.PlacementDTO;
import com.klef.soa.entity.Placement;

public interface PlacementService
{
    String insertPlacement(PlacementDTO dto);

    String updatePlacement(PlacementDTO dto);

    String deletePlacement(Long id);

    List<Placement> displayAll();

    Placement displayById(Long id);

    List<Placement> findByName(String name);

    List<Placement> findByType(String type);
}