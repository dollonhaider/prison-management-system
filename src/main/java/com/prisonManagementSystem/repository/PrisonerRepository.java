package com.prisonManagementSystem.repository;

import com.prisonManagementSystem.model.Prisoner;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PrisonerRepository extends MongoRepository<Prisoner, String > {
    public Prisoner findByIdAndStatus(ObjectId id, String status);
    public Prisoner findByName(String name);
    public List<Prisoner> findAllByStatus(String status);
    public Prisoner findById(ObjectId id);
}
