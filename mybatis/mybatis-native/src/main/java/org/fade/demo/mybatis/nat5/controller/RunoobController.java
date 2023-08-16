package org.fade.demo.mybatis.nat5.controller;

import org.fade.demo.mybatis.nat5.entity.Runoob;
import org.fade.demo.mybatis.nat5.service.RunoobService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

/**
 * @author fade
 */
@RestController
@RequestMapping("/runoob")
public class RunoobController {

    private final RunoobService runoobService;


    public RunoobController(RunoobService runoobService) {
        this.runoobService = runoobService;
    }

    @PostMapping("/add")
    public ResponseEntity<Void> addRunoob(@RequestBody Runoob runoob) {
        this.runoobService.insert(runoob);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/update")
    public ResponseEntity<Void> updateRunoob(@RequestBody Runoob runoob) {
        this.runoobService.update(runoob);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/delete")
    public ResponseEntity<Void> deleteRunoob(@RequestBody Runoob runoob) {
        Objects.requireNonNull(runoob);
        this.runoobService.delete(runoob.getRunoobId());
        return ResponseEntity.ok().build();
    }

    @PostMapping("/selectById")
    public ResponseEntity<Runoob> getRunoobById(@RequestBody Runoob runoob) {
        Objects.requireNonNull(runoob);
        Runoob data = this.runoobService.selectById(runoob.getRunoobId());
        return ResponseEntity.ok(data);
    }

}
