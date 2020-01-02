package com.prisonManagementSystem.repository;

import com.prisonManagementSystem.model.Guest;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface GuestRepository extends MongoRepository<Guest, String> {

    public Guest findByIdAndStatus(ObjectId id, String status);
    public Guest findByName(String name);
    public List<Guest> findAllByStatus(String status);
    public Guest findById(ObjectId id);
}
