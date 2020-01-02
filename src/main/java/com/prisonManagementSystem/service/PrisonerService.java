package com.prisonManagementSystem.service;

import com.prisonManagementSystem.dto.PrisonerCreateDTO;
import com.prisonManagementSystem.dto.PrisonerUpdateDTO;
import com.prisonManagementSystem.dto.ResponseDTO;
import com.prisonManagementSystem.enums.Authority;
import com.prisonManagementSystem.model.Prisoner;
import com.prisonManagementSystem.model.Section;
import com.prisonManagementSystem.model.dummy.User;
import com.prisonManagementSystem.repository.PrisonerRepository;
import com.prisonManagementSystem.repository.SectionRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrisonerService {
    private ResponseDTO output = new ResponseDTO();
    @Autowired
    private PrisonerRepository prisonerRepository;
    @Autowired
    private SectionRepository sectionRepository;
public ResponseDTO create(PrisonerCreateDTO input,User requester)
{
    Prisoner prisoner = new Prisoner();
    if (requester.hasAuthority(Authority.ROLE_ADMIN) && requester.hasAuthority(Authority.ROLE_OFFICER)) {
        Section section = sectionRepository.findByIdAndStatus(new ObjectId(input.getSectionId()), "V");
        if (section == null) {
            return output.generateErrorResponse("Permission Denied !! Section not found !!");
        }
        if (requester.getSection().equals(section.getSectionName())) {
            prisoner = prisonerRepository.findByIdAndStatus(input.getId(), "V");
    if(prisoner == null)
    {
        prisoner = new Prisoner();
        prisoner.setName(input.getName());
        prisoner.setUniqueName(input.getUniqueName());
        prisoner.setFatherName(input.getFatherName());
        prisoner.setAge(input.getAge());
        prisoner.setAddress(input.getAddress());
        prisoner.setDateOfIn(input.getDateOfIn());
        prisoner.setDateOfOut(input.getDateOfOut());
        prisoner.setCaseType(input.getCaseType());
        prisoner.setCaseYear(input.getCaseYear());
        prisoner.setStatus("V");
        prisoner.setSection(section);
        prisonerRepository.save(prisoner);
        return output.generateSuccessResponse(prisoner,"Successfully created");

    }else {
        return output.generateErrorResponse(" Already exist !!");

    }
        } else {
            return output.generateErrorResponse("Permission Denied!!");
        }
    }
    return output.generateSuccessResponse(prisoner, "Successfully created");

}

    public ResponseDTO getList()
    {
        List<Prisoner> prisoners = prisonerRepository.findAllByStatus("V");
        if(prisoners == null)
        {
            return output.generateErrorResponse("No data found");
        }
        else
        {
            return output.generateSuccessResponse(prisoners,"Success!");
        }
    }

    public ResponseDTO get(ObjectId id)
    {
        Prisoner prisoner = prisonerRepository.findByIdAndStatus(id,"V");
        if (prisoner==null)
        {
            return output.generateErrorResponse("Data not found");
        }
        else {
            return output.generateSuccessResponse(prisoner,"Success");
        }
    }

    public ResponseDTO update(PrisonerUpdateDTO input,User requester)
    {

        Prisoner prisoner;
        if (requester.hasAuthority(Authority.ROLE_ADMIN) && requester.hasAuthority(Authority.ROLE_OFFICER))
        {
            Section section = sectionRepository.findByIdAndStatus(new ObjectId(input.getSectionId()), "V");
            if (section == null) {
                return output.generateErrorResponse("Permission Denied !! Section not found !!");
            }
            if (requester.getSection().equals(section.getSectionName())) {
                prisoner = prisonerRepository.findByIdAndStatus(input.getId(), "V");
                if (prisoner == null && input != null) {
                    prisoner.setName(input.getName());
                    prisoner.setUniqueName(input.getUniqueName());
                    prisoner.setFatherName(input.getFatherName());
                    prisoner.setAge(input.getAge());
                    prisoner.setAddress(input.getAddress());
                    prisoner.setDateOfIn(input.getDateOfIn());
                    prisoner.setDateOfOut(input.getDateOfOut());
                    prisoner.setCaseType(input.getCaseType());
                    prisoner.setSection(section);
                    prisonerRepository.save(prisoner);
                    return output.generateSuccessResponse(prisoner, "successfully updated");

                } else {
                    return output.generateErrorResponse("Already exist!!");
                }
            }
            else {
                return output.generateErrorResponse("Invalid input");
            }
        } else
        {
            return output.generateErrorResponse("Permission Denied!!");
        }


    }


    public ResponseDTO delete(ObjectId id, User requester) {
        if (requester.hasAuthority(Authority.ROLE_ADMIN) && requester.hasAuthority(Authority.ROLE_OFFICER)) {
            Prisoner prisoner = prisonerRepository.findByIdAndStatus(id, "V");
            if (prisoner == null) {
                return output.generateErrorResponse("You have entered wrong id");
            } else {
                prisoner.setStatus("D");
                prisonerRepository.save(prisoner);
            }
            return output.generateSuccessResponse(prisoner, "success");
        } else {
            return output.generateErrorResponse("Permission Denied!!");
        }
    }
  /*  public String test(PrisonerCreateDTO input) {
        String value = "Sda";
        Prisoner prisoner = prisonerRepository.findByIdAndStatus(input.getPrisonerId(), "V");
        if (prisoner == null) {
            //
        }
        return  value;
    }*/

}
