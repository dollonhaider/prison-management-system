package com.prisonManagementSystem.service;

import com.prisonManagementSystem.dto.ResponseDTO;
import com.prisonManagementSystem.dto.VisitorCreateDTO;
import com.prisonManagementSystem.dto.VisitorUpdateDTO;
import com.prisonManagementSystem.enums.Authority;
import com.prisonManagementSystem.model.Prisoner;
import com.prisonManagementSystem.model.Section;
import com.prisonManagementSystem.model.Visitor;
import com.prisonManagementSystem.model.dummy.User;
import com.prisonManagementSystem.repository.PrisonerRepository;
import com.prisonManagementSystem.repository.SectionRepository;
import com.prisonManagementSystem.repository.VisitorRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisitorService {
    private ResponseDTO output = new ResponseDTO();
    @Autowired
    private VisitorRepository visitorRepository;
    @Autowired
    private PrisonerRepository prisonerRepository;
    @Autowired
    private SectionRepository sectionRepository;

    public ResponseDTO create(VisitorCreateDTO input,User requester)
    {
        Visitor visitor = new Visitor();
        if (requester.hasAuthority(Authority.ROLE_ADMIN) && requester.hasAuthority(Authority.ROLE_OFFICER)) {
            Prisoner prisoner = prisonerRepository.findByIdAndStatus(new ObjectId(input.getPrisonerId()), "V");
            if (prisoner == null) {
                return output.generateErrorResponse("Prisoner not found !!");
            } else {
                visitor.setVisitorName(input.getVisitorName());
                visitor.setVisitorNidNo(input.getVisitorNidNo());
                visitor.setPrisonerId(prisoner);
                visitor.setRelationship(input.getRelationship());
                visitor.setEntryTime(input.getEntryTime());
                visitor.setStatus("V");
                visitorRepository.save(visitor);
                return output.generateSuccessResponse(visitor, "Successfully created");
            }
        }   else {
            return output.generateErrorResponse("Permission denied!!");
        }
    }

    public ResponseDTO getList()
    {
        List<Visitor> visitors = visitorRepository.findAllByStatus("V");
        if(visitors == null)
        {
            return output.generateErrorResponse("No data found");
        }
        else
        {
            return output.generateSuccessResponse(visitors,"Success!");
        }
    }

    public ResponseDTO get(ObjectId id)
    {
        Visitor visitor = visitorRepository.findByIdAndStatus(id,"V");
        if (visitor==null)
        {
            return output.generateErrorResponse("Data not found");
        }
        else {
            return output.generateSuccessResponse(visitor,"Success");
        }
    }

    public ResponseDTO update(VisitorUpdateDTO input,User requester)
    {
        if(requester.hasAuthority(Authority.ROLE_ADMIN) && requester.hasAuthority(Authority.ROLE_OFFICER))
        {
            Visitor visitor = visitorRepository.findByIdAndStatus(input.getId(),"V");
            if (visitor != null && input != null) {
                visitor.setExitTime(input.getExitTime());
                visitorRepository.save(visitor);
                return output.generateSuccessResponse(visitor, "successfully updated");
            }else {
                return output.generateErrorResponse("Data not found");
            }
        } else
        {
            return output.generateErrorResponse("Invalid input");
        }

    }

    public ResponseDTO delete(ObjectId id,User requester) {
        if (requester.hasAuthority(Authority.ROLE_ADMIN) && requester.hasAuthority(Authority.ROLE_OFFICER)) {
            Visitor visitor = visitorRepository.findByIdAndStatus(id, "V");
            if (visitor == null) {
                return output.generateErrorResponse("You have entered a wrong id");
            } else {
                visitor.setStatus("D");
                visitorRepository.save(visitor);
            }
            return output.generateSuccessResponse(visitor, "success");

        } else {
            return output.generateErrorResponse("");
        }
    }


}
