package com.qpp.comiccps.basics.controller;

import com.qpp.comiccps.basics.service.impl.MallCartoonOrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MallCartoonOrderController {

    @Autowired
    private MallCartoonOrderServiceImpl mallCartoonOrderService;


}
