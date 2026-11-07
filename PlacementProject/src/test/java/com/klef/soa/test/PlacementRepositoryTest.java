package com.klef.soa.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;
import org.springframework.test.context.TestPropertySource;

import com.klef.soa.entity.Placement;
import com.klef.soa.repository.PlacementRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestPropertySource(properties = "spring.datasource.url=jdbc:postgresql://localhost:5433/soa-skill-exam-2400032790")
public class PlacementRepositoryTest
{
    @Autowired
    private PlacementRepository repository;

    @Test
    void testFindAllPlacements()
    {
        List<Placement> placements = repository.findAll();
        assertNotNull(placements);
        assertFalse(placements.isEmpty());
        System.out.println("Total Placements: " + placements.size());
    }

    @Test
    void testFindPlacementById()
    {
        Optional<Placement> placement = repository.findById(1L);
        assertTrue(placement.isPresent());
        assertEquals(1L, placement.get().getPlacementId());
        System.out.println("Placement ID: " + placement.get().getPlacementId());
        System.out.println("Name: " + placement.get().getName());
    }

    @Test
    void testFindPlacementByName()
    {
        List<Placement> placements = repository.findByName("TCS");
        assertFalse(placements.isEmpty());
        assertEquals("TCS", placements.get(0).getName());
        System.out.println("Name: " + placements.get(0).getName());
        System.out.println("Location: " + placements.get(0).getLocation());
    }

    @Test
    void testFindPlacementByInvalidName()
    {
        List<Placement> placements = repository.findByName("notfound");
        assertTrue(placements.isEmpty());
    }

    @Test
    void testDatabaseConnection()
    {
        long count = repository.count();
        assertTrue(count >= 0);
        System.out.println("Total Placements in Database: " + count);
    }

    @Test
    void testPlacementDetails()
    {
        Optional<Placement> placement = repository.findById(1L);
        assertTrue(placement.isPresent());
        Placement foundPlacement = placement.get();
        assertNotNull(foundPlacement.getName());
        assertNotNull(foundPlacement.getType());
        assertNotNull(foundPlacement.getStatus());
        assertNotNull(foundPlacement.getLocation());
        System.out.println("Name: " + foundPlacement.getName());
        System.out.println("Type: " + foundPlacement.getType());
        System.out.println("Status: " + foundPlacement.getStatus());
    }

    @Test
    void testPlacementType()
    {
        Optional<Placement> placement = repository.findById(1L);
        assertTrue(placement.isPresent());
        assertEquals("On Campus", placement.get().getType());
        System.out.println("Type: " + placement.get().getType());
    }

    @Test
    void testTotalPlacementCount()
    {
        long count = repository.count();
        assertEquals(1L, count);
    }

    @Test
    void testPlacementTypes()
    {
        List<Placement> placements=repository.findByType("On Campus");
        assertNotNull(placements);
        assertEquals(1,placements.size());

    }
}
