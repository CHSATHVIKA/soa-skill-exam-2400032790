package com.klef.soa.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.soa.dto.PlacementDTO;
import com.klef.soa.entity.Placement;
import com.klef.soa.repository.PlacementRepository;

@Service
public class PlacementServiceImpl implements PlacementService
{
    @Autowired
    private PlacementRepository repository;

    @Override
    public String insertPlacement(PlacementDTO dto)
    {
        Placement p = new Placement();

        p.setPlacementId(dto.getPlacementId());
        p.setName(dto.getName());
        p.setType(dto.getType());
        p.setStatus(dto.getStatus());
        p.setLocation(dto.getLocation());

        p.setCreatedAt(LocalDateTime.now().toString());
        p.setUpdatedAt(LocalDateTime.now().toString());

        repository.save(p);

        return "Placement Inserted Successfully";
    }

    @Override
    public String updatePlacement(PlacementDTO dto)
    {
        Placement p = repository.findById(dto.getPlacementId()).orElse(null);

        if (p != null)
        {
            p.setName(dto.getName());
            p.setType(dto.getType());
            p.setStatus(dto.getStatus());
            p.setLocation(dto.getLocation());

            p.setUpdatedAt(LocalDateTime.now().toString());

            repository.save(p);

            return "Placement Updated Successfully";
        }

        return "Placement Not Found";
    }

    @Override
    public String deletePlacement(Long id)
    {
        if(repository.existsById(id))
        {
            repository.deleteById(id);
            return "Placement Deleted Successfully";
        }

        return "Placement Not Found";
    }

    @Override
    public List<Placement> displayAll()
    {
        return repository.findAll();
    }

    @Override
    public Placement displayById(Long id)
    {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Placement> findByName(String name)
    {
        return repository.findByName(name);
    }
    @Override
    public List<Placement> findByType(String type)
    {
        return repository.findByType(type);
    }
}