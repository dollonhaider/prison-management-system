package com.prisonManagementSystem.repository;

import com.prisonManagementSystem.model.Visitor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface VisitorRepository extends MongoRepository<Visitor, String > {
    public Visitor findByIdAndStatus(ObjectId id, String status);
    public Visitor findByVisitorName(String visitorName);
    public List<Visitor> findAllByStatus(String status);
    public Visitor findById(ObjectId id);
}
