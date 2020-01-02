package com.prisonManagementSystem.repository;

import com.prisonManagementSystem.model.Section;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SectionRepository extends MongoRepository<Section, String>{
    public Section findById(ObjectId id);
    public Section findBySectionName(String sectionName);
    public Section findByStatus(String status);
    public Section findByIdAndStatus(ObjectId id,String status);
    public List<Section> findAllByStatus(String Status);


}
