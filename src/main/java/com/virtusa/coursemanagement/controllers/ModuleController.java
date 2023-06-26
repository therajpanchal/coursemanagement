package com.virtusa.coursemanagement.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.coursemanagement.models.Module;
import com.virtusa.coursemanagement.services.ModuleService;

@RestController
@RequestMapping("/api/modules")
public class ModuleController {
    
    @Autowired
    private final ModuleService moduleService;

    public ModuleController(ModuleService moduleService) {
        this.moduleService = moduleService;
    }

    @GetMapping
    public ResponseEntity<List<Module>> getAllModules() {
        List<Module> modules = moduleService.getAllModules();
        return new ResponseEntity<List<Module>>(modules, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Module> getModuleById(@PathVariable Long id) {
        Module module = moduleService.getModuleById(id);
        if(module!=null) {
            return new ResponseEntity<Module>(module, HttpStatus.OK);
        }
        return new ResponseEntity<Module>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/course/{courseid}")
    public ResponseEntity<List<Module>> getModuleByCourseId(@PathVariable Long courseid) {
        List<Module> modules = moduleService.getModuleByCourseId(courseid);
        if(!modules.isEmpty()) {
            return new ResponseEntity<List<Module>>(modules, HttpStatus.OK);
        }
        return new ResponseEntity<List<Module>>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public Module create(@RequestBody Module module) {
        return moduleService.createModule(module);
    }

    @PutMapping("/{id}")
    public Module update(@PathVariable Long id, @RequestBody Module module) {
        return moduleService.updateModule(id, module);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        moduleService.deleteModule(id);
    }
}
