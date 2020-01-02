package com.prisonManagementSystem.controller;

import com.prisonManagementSystem.constant.HttpHeader;
import com.prisonManagementSystem.dto.OfficerCreateDTO;
import com.prisonManagementSystem.dto.OfficerUpdateDTO;
import com.prisonManagementSystem.dto.ResponseDTO;
import com.prisonManagementSystem.model.dummy.User;
import com.prisonManagementSystem.service.OfficerService;
import com.prisonManagementSystem.utills.Utils;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class OfficerController {
    @Autowired
    private OfficerService officerService;
    @RequestMapping(value = "/officer/create", method = RequestMethod.POST)
    public ResponseDTO create(@RequestBody OfficerCreateDTO input, @RequestHeader(value = HttpHeader.REQUESTER) String currentUserStr)
    {
        User requester = Utils.generateUserFromJsonStr(currentUserStr);
        ResponseDTO result = officerService.create(input,requester);
        return result;
    }

    @RequestMapping(value = "/officer/get-list",method = RequestMethod.GET)
    public ResponseDTO getList()
    {
        ResponseDTO result = officerService.getList();
        return result;
    }
    @RequestMapping(value = "/officer/get/{id}",method = RequestMethod.GET)
    public ResponseDTO get(@PathVariable("id") ObjectId id)
    {
        ResponseDTO result = officerService.get(id);
        return result;
    }
    @RequestMapping(value = "/officer/update",method = RequestMethod.PUT)
    public ResponseDTO update(@RequestBody OfficerUpdateDTO input, @RequestHeader(value = HttpHeader.REQUESTER) String currentUserStr)
    {
        User requester = Utils.generateUserFromJsonStr(currentUserStr);
        ResponseDTO result = officerService.update(input,requester);
        return result;
    }
    @RequestMapping(value = "/officer/delete/{id}",method = RequestMethod.DELETE)
    public ResponseDTO delete(@PathVariable("id") ObjectId id,@RequestHeader(value = HttpHeader.REQUESTER) String currentUserStr)
    {
        User requester = Utils.generateUserFromJsonStr(currentUserStr);
        ResponseDTO result = officerService.delete(id,requester);
        return result;
    }

}
