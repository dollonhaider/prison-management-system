package com.prisonManagementSystem.controller;

import com.prisonManagementSystem.constant.HttpHeader;
import com.prisonManagementSystem.dto.PrisonerCreateDTO;
import com.prisonManagementSystem.dto.PrisonerUpdateDTO;
import com.prisonManagementSystem.dto.ResponseDTO;
import com.prisonManagementSystem.model.dummy.User;
import com.prisonManagementSystem.service.PrisonerService;
import com.prisonManagementSystem.utills.Utils;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PrisonerController {
    @Autowired
    private PrisonerService prisonerService;

    @RequestMapping(value = "/prisoner/create", method = RequestMethod.POST)
    public ResponseDTO create(@RequestBody PrisonerCreateDTO input, @RequestHeader(value = HttpHeader.REQUESTER) String currentUserStr)
    {
        User requester = Utils.generateUserFromJsonStr(currentUserStr);
        ResponseDTO result = prisonerService.create(input,requester);
        return result;
    }


    @RequestMapping(value = "/prisoner/get-list",method = RequestMethod.GET)
    public ResponseDTO getList()
    {
        ResponseDTO result = prisonerService.getList();
        return result;
    }
    @RequestMapping(value = "/prisoner/get/{id}",method = RequestMethod.GET)
    public ResponseDTO get(@PathVariable("id") ObjectId id)
    {
        ResponseDTO result = prisonerService.get(id);
        return result;
    }
    @RequestMapping(value = "/prisoner/update",method = RequestMethod.PUT)
    public ResponseDTO update(@RequestBody PrisonerUpdateDTO input,@RequestHeader(value = HttpHeader.REQUESTER) String currentUserStr)
    {
        User requester = Utils.generateUserFromJsonStr(currentUserStr);
        ResponseDTO result = prisonerService.update(input,requester);
        return result;
    }
    @RequestMapping(value = "/prisoner/delete/{id}",method = RequestMethod.DELETE)
    public ResponseDTO delete(@PathVariable("id") ObjectId id,@RequestHeader(value = HttpHeader.REQUESTER) String currentUserStr)
    {
        User requester = Utils.generateUserFromJsonStr(currentUserStr);
        ResponseDTO result = prisonerService.delete(id, requester);
        return result;
    }
}
