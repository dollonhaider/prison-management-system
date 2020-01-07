package com.prisonManagementSystem.controller;

import com.prisonManagementSystem.constant.HttpHeader;
import com.prisonManagementSystem.dto.GuestCreateDTO;
import com.prisonManagementSystem.dto.GuestUpdateDTO;
import com.prisonManagementSystem.dto.ResponseDTO;
import com.prisonManagementSystem.model.dummy.User;
import com.prisonManagementSystem.service.GuestService;
import com.prisonManagementSystem.utills.Utils;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class GuestController {
    @Autowired
    private GuestService guestService;
    @RequestMapping(value = "/guest/create", method = RequestMethod.POST)
    public ResponseDTO create(@RequestBody GuestCreateDTO input,@RequestHeader(value = HttpHeader.REQUESTER) String currentUserStr)
    {
        User requester = Utils.generateUserFromJsonStr(currentUserStr);
        ResponseDTO result = guestService.create(input,requester);
        return result;
    }

    @RequestMapping(value = "/guest/get-list",method = RequestMethod.GET)
    public ResponseDTO getList(@RequestHeader(value = HttpHeader.REQUESTER) String currentUserStr)
    {
        User requester = Utils.generateUserFromJsonStr(currentUserStr);
        ResponseDTO result = guestService.getList(requester);
        return result;
    }
    @RequestMapping(value = "/guest/get/{id}",method = RequestMethod.GET)
    public ResponseDTO get(@PathVariable("id") ObjectId id)
    {
        ResponseDTO result = guestService.get(id);
        return result;
    }
    @RequestMapping(value = "/guest/update",method = RequestMethod.PUT)
    public ResponseDTO update(@RequestBody GuestUpdateDTO input,@RequestHeader(value = HttpHeader.REQUESTER) String currentUserStr)
    {
        User requester = Utils.generateUserFromJsonStr(currentUserStr);
        ResponseDTO result = guestService.update(input,requester);
        return result;
    }
    @RequestMapping(value = "/guest/delete/{id}",method = RequestMethod.DELETE)
    public ResponseDTO delete(@PathVariable("id") ObjectId id,@RequestHeader(value = HttpHeader.REQUESTER) String currentUserStr)
    {
        User requester = Utils.generateUserFromJsonStr(currentUserStr);
        ResponseDTO result = guestService.delete(id,requester);
        return result;
    }

}
