package com.prisonManagementSystem.service;

import com.prisonManagementSystem.dto.OfficerUpdateDTO;
import com.prisonManagementSystem.dto.ResponseDTO;
import com.prisonManagementSystem.dto.SectionCreateDTO;
import com.prisonManagementSystem.dto.SectionUpdateDTO;
import com.prisonManagementSystem.enums.Authority;
import com.prisonManagementSystem.model.Officer;
import com.prisonManagementSystem.model.Section;
import com.prisonManagementSystem.model.dummy.User;
import com.prisonManagementSystem.repository.SectionRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SectionService {
    private ResponseDTO output = new ResponseDTO();
    @Autowired
    private SectionRepository sectionRepository;

    public ResponseDTO create(SectionCreateDTO input,User requester)
    {
        if (requester.hasAuthority(Authority.ROLE_ADMIN)) {
            Section createSection = sectionRepository.findBySectionName(input.getSectionName());
            if (createSection == null) {
                Section section = new Section();
                section.setSectionName(input.getSectionName().toLowerCase());
                section.setNoOfPrisoners(input.getNoOfPrisoners());
                section.setStatus("V");
                sectionRepository.save(section);
                return output.generateSuccessResponse(section, "Successfully created");
            } else {
                return output.generateErrorResponse("This name already exist");
            }
        } else {
            return output.generateErrorResponse("Permission denied!!");
        }
    }

    public ResponseDTO getList()
    {
        List<Section> sections = sectionRepository.findAllByStatus("V");
        if(sections == null)
        {
            return output.generateErrorResponse("No data found");
        }
        else
        {
            return output.generateSuccessResponse(sections,"Success!");
        }
    }

    public ResponseDTO get(ObjectId id)
    {
        Section section = sectionRepository.findByIdAndStatus(id,"V");
        if (section==null)
        {
            return output.generateErrorResponse("Data not found");
        }
        else {
            return output.generateSuccessResponse(section,"Success");
        }
    }

    public ResponseDTO update(SectionUpdateDTO input,User requester)
    {
        if (requester.hasAuthority(Authority.ROLE_ADMIN)) {
            Section section = sectionRepository.findByIdAndStatus(input.getId(), "V");

            if (input != null || section != null) {
                if (section == null) {
                    return output.generateErrorResponse("Data not found");
                }

                if (input.getSectionName() != null) {
                    section.setSectionName(input.getSectionName());
                }
                if (input.getNoOfPrisoners() != 0) {
                    section.setNoOfPrisoners(input.getNoOfPrisoners());
                }

                sectionRepository.save(section);
                return output.generateSuccessResponse(section, "successfully updated");
            } else {
                return output.generateErrorResponse("Invalid input");
            }
        } else {
            return output.generateErrorResponse("Permission denied!!");
        }


    }

    public ResponseDTO delete(ObjectId id,User requester) {
        if (requester.hasAuthority(Authority.ROLE_ADMIN)) {
            Section section = sectionRepository.findByIdAndStatus(id, "V");
            if (section == null) {
                return output.generateErrorResponse("You have entered wrong id");
            } else {
                section.setStatus("D");
                sectionRepository.save(section);
            }
            return output.generateSuccessResponse(section, "success");

        } else {
            return output.generateErrorResponse("Permission denied!!");
        }
    }

}
