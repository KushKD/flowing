package com.mis.education.Education.MIS.modules.role.controller;

import com.mis.education.Education.MIS.modules.role.entity.RolesEntity;
import com.mis.education.Education.MIS.repositories.roles.RolesRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class RolesRestController {

    @Autowired
    RolesRepository rolesRepository;

    private static final Logger logger = LoggerFactory.getLogger(RolesRestController.class);

    @RequestMapping(value = "/apidataTable/getRoles", method = RequestMethod.GET)
    public DataTablesOutput<RolesEntity> getUsers_(@Valid DataTablesInput input) {
        System.out.println(input);
        return rolesRepository.findAll(input);
    }

}