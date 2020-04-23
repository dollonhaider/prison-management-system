package com.prisonManagementSystem.service;

import com.prisonManagementSystem.dto.GuestCreateDTO;
import com.prisonManagementSystem.dto.GuestUpdateDTO;
import com.prisonManagementSystem.dto.ResponseDTO;
import com.prisonManagementSystem.enums.Authority;
import com.prisonManagementSystem.model.Guest;
import com.prisonManagementSystem.model.dummy.User;
import com.prisonManagementSystem.repository.GuestRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.List;

@Service
public class GuestService {
    private ResponseDTO output = new ResponseDTO();
    @Autowired
    private GuestRepository guestRepository;

    public ResponseDTO create(GuestCreateDTO input,User requester)
    {
        if (requester.hasAuthority(Authority.ROLE_ADMIN) && requester.hasAuthority(Authority.ROLE_OFFICER)) {
            Guest createGuest = guestRepository.findByName(input.getName());
            if (createGuest == null) {
                Guest guest = new Guest();
                guest.setName(input.getName());
                guest.setEmail(input.getEmail());
                guest.setPhone(input.getPhone());
                guest.setPassword(encodePassword(input.getPassword()));
                guest.setStatus("V");
                guestRepository.save(guest);
                return output.generateSuccessResponse(guest, "Successfully created a guest.");

            } else {
                return output.generateErrorResponse("This name is already exist");
            }
        } else{
            return output.generateErrorResponse("Permission Denied!");
        }
    }

    public ResponseDTO getList(User requester)
    {
        List<Guest> guests = guestRepository.findAllByStatus("V");
        if(guests == null)
        {
            return output.generateErrorResponse("No data found");
        }
        else
        {
            return output.generateSuccessResponse(guests,"Success!");
        }
    }

    public ResponseDTO get(ObjectId id)
    {
        Guest guest = guestRepository.findByIdAndStatus(id,"V");
        if (guest==null)
        {
            return output.generateErrorResponse("Data not found");
        }
        else {
            return output.generateSuccessResponse(guest,"Success");
        }
    }

    public ResponseDTO update(GuestUpdateDTO input,User requester)
    {
        if (requester.hasAuthority(Authority.ROLE_ADMIN) && requester.hasAuthority(Authority.ROLE_OFFICER)) {

            Guest guest = guestRepository.findByIdAndStatus(input.getId(), "V");

            if (input != null || guest != null) {
                if (guest == null) {
                    return output.generateErrorResponse("Data not found");
                }

                if (input.getName() != null) {
                    guest.setName(input.getName());
                }
                if (input.getEmail() != null) {
                    guest.setEmail(input.getEmail());
                }
                if (input.getPhone() != null) {
                    guest.setPhone(input.getPhone());
                }

                guestRepository.save(guest);
                return output.generateSuccessResponse(guest, "successfully updated information");
            } else {
                return output.generateErrorResponse("Invalid input");
            }

        } else {
            return output.generateErrorResponse("Permission Denied!!");

        }


    }

    public ResponseDTO delete(ObjectId id,User requester) {
        if (requester.hasAuthority(Authority.ROLE_ADMIN) && requester.hasAuthority(Authority.ROLE_OFFICER)) {
            Guest guest = guestRepository.findByIdAndStatus(id, "V");
            if (guest == null) {
                return output.generateErrorResponse("You have entered wrong id");
            } else {
                guest.setStatus("D");
                guestRepository.save(guest);
            }
            return output.generateSuccessResponse(guest, "success");

        } else {
            return output.generateErrorResponse("Permission Denied!!");

        }
    }

    public String encodePassword(String password)
    {
        String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());
        return encodedPassword;
    }
    public String decodePassword(String input)
    {
        byte[] decodedPassword = Base64.getDecoder().decode(input);
        return  new String(decodedPassword);
    }
}
