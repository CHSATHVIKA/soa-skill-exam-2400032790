package com.klef.soa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.klef.soa.dto.PlacementDTO;
import com.klef.soa.entity.Placement;
import com.klef.soa.service.PlacementService;

@RestController
@RequestMapping("/placement")
public class PlacementController
{
    @Autowired
    private PlacementService service;

    @GetMapping("/")
    public String home()
    {
        return "Placement Service Project - SOA Skill Exam 2400032790";
    }

    @PostMapping("/insert")
    public String insert(@RequestBody PlacementDTO dto)
    {
        return service.insertPlacement(dto);
    }

    @PutMapping("/update")
    public String update(@RequestBody PlacementDTO dto)
    {
        return service.updatePlacement(dto);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id)
    {
        return service.deletePlacement(id);
    }

    @GetMapping("/displayall")
    public List<Placement> displayAll()
    {
        return service.displayAll();
    }

    @GetMapping("/displaybyid/{id}")
    public Placement displayById(@PathVariable Long id)
    {
        return service.displayById(id);
    }

    @GetMapping("/findbyname/{name}")
    public List<Placement> findByName(@PathVariable String name)
    {
        return service.findByName(name);
    }
    @GetMapping("/findbytype/{type}")
    public List<Placement> findByType(@PathVariable String type)
    {
        return service.findByType(type);
    }
}