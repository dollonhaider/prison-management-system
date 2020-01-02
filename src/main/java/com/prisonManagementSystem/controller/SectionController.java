package com.prisonManagementSystem.controller;

import com.prisonManagementSystem.dto.ResponseDTO;
import com.prisonManagementSystem.dto.SectionCreateDTO;
import com.prisonManagementSystem.dto.SectionUpdateDTO;
import com.prisonManagementSystem.service.SectionService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SectionController {
    @Autowired
    SectionService sectionService;

    @RequestMapping(value = "/section/create", method = RequestMethod.POST)
    public ResponseDTO create(@RequestBody SectionCreateDTO input)
    {
        ResponseDTO result = sectionService.create(input);
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
    public ResponseDTO update(@RequestBody SectionUpdateDTO input)
    {
        ResponseDTO result = sectionService.update(input);
        return result;
    }
    @RequestMapping(value = "/section/delete/{id}",method = RequestMethod.DELETE)
    public ResponseDTO delete(@PathVariable("id") ObjectId id)
    {
        ResponseDTO result = sectionService.delete(id);
        return result;
    }

}
