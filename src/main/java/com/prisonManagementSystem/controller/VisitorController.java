package com.prisonManagementSystem.controller;

import com.prisonManagementSystem.constant.HttpHeader;
import com.prisonManagementSystem.dto.ResponseDTO;
import com.prisonManagementSystem.dto.VisitorCreateDTO;
import com.prisonManagementSystem.dto.VisitorUpdateDTO;
import com.prisonManagementSystem.model.dummy.User;
import com.prisonManagementSystem.service.VisitorService;
import com.prisonManagementSystem.utills.Utils;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class VisitorController {

    @Autowired
    private VisitorService visitorService;

    @RequestMapping(value = "/visitor/create", method = RequestMethod.POST)
    public ResponseDTO create(@RequestBody VisitorCreateDTO input, @RequestHeader(value = HttpHeader.REQUESTER) String currentUserStr)
    {
        User requester = Utils.generateUserFromJsonStr(currentUserStr);
        ResponseDTO result = visitorService.create(input,requester);
        return result;
    }

    @RequestMapping(value = "/visitor/get-list",method = RequestMethod.GET)
    public ResponseDTO getList()
    {
        ResponseDTO result = visitorService.getList();
        return result;
    }
    @RequestMapping(value = "/visitor/get/{id}",method = RequestMethod.GET)
    public ResponseDTO get(@PathVariable("id") ObjectId id)
    {
        ResponseDTO result = visitorService.get(id);
        return result;
    }
    @RequestMapping(value = "/visitor/update",method = RequestMethod.PUT)
    public ResponseDTO update(@RequestBody VisitorUpdateDTO input,@RequestHeader(value = HttpHeader.REQUESTER) String currentUserStr)
    {
        User requester = Utils.generateUserFromJsonStr(currentUserStr);
        ResponseDTO result = visitorService.update(input,requester);
        return result;
    }
    @RequestMapping(value = "/visitor/delete/{id}",method = RequestMethod.DELETE)
    public ResponseDTO delete(@PathVariable("id") ObjectId id,@RequestHeader(value = HttpHeader.REQUESTER) String currentUserStr)
    {
        User requester = Utils.generateUserFromJsonStr(currentUserStr);
        ResponseDTO result = visitorService.delete(id,requester);
        return result;
    }
}
