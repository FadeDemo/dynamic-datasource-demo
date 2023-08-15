package org.fade.demo.mybatis.nat5.controller;

import org.fade.demo.mybatis.nat5.service.RunoobService;
import org.springframework.stereotype.Controller;

/**
 * @author fade
 */
@Controller
public class RunoobController {

    private final RunoobService runoobService;


    public RunoobController(RunoobService runoobService) {
        this.runoobService = runoobService;
    }

}
