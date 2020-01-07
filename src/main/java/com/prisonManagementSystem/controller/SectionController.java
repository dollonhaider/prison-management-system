package com.prisonManagementSystem.controller;

import com.prisonManagementSystem.constant.HttpHeader;
import com.prisonManagementSystem.dto.ResponseDTO;
import com.prisonManagementSystem.dto.SectionCreateDTO;
import com.prisonManagementSystem.dto.SectionUpdateDTO;
import com.prisonManagementSystem.model.dummy.User;
import com.prisonManagementSystem.service.SectionService;
import com.prisonManagementSystem.utills.Utils;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SectionController {
    @Autowired
    SectionService sectionService;

    @RequestMapping(value = "/section/create", method = RequestMethod.POST)
    public ResponseDTO create(@RequestBody SectionCreateDTO input,@RequestHeader(value = HttpHeader.REQUESTER) String currentUserStr)
    {
        User requester = Utils.generateUserFromJsonStr(currentUserStr);
        ResponseDTO result = sectionService.create(input,requester);
        return result;
    }

    @RequestMapping(value = "/section/get-list",method = RequestMethod.GET)
    public ResponseDTO getList()
    {
        ResponseDTO result = sectionService.getList();
        return result;
    }
    @RequestMapping(value = "/section/get/{id}",method = RequestMethod.GET)
    public ResponseDTO get(@PathVariable("id") ObjectId id)
    {
        ResponseDTO result = sectionService.get(id);
        return result;
    }
    @RequestMapping(value = "/section/update",method = RequestMethod.PUT)
    public ResponseDTO update(@RequestBody SectionUpdateDTO input,@RequestHeader(value = HttpHeader.REQUESTER) String currentUserStr)
    {
        User requester = Utils.generateUserFromJsonStr(currentUserStr);
        ResponseDTO result = sectionService.update(input,requester);
        return result;
    }
    @RequestMapping(value = "/section/delete/{id}",method = RequestMethod.DELETE)
    public ResponseDTO delete(@PathVariable("id") ObjectId id,@RequestHeader(value = HttpHeader.REQUESTER) String currentUserStr)
    {
        User requester = Utils.generateUserFromJsonStr(currentUserStr);
        ResponseDTO result = sectionService.delete(id,requester);
        return result;
    }

}
