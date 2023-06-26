package com.virtusa.coursemanagement.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.coursemanagement.models.Module;
import com.virtusa.coursemanagement.repositories.ModuleRepository;

@Service
public class ModuleService {
    
    @Autowired
    private final ModuleRepository moduleRepository;

    public ModuleService(ModuleRepository moduleRepository) {
        this.moduleRepository = moduleRepository;
    }

    public List<Module> getAllModules() {
        return moduleRepository.findAll();
    }

    public Module getModuleById(Long id) {
        Optional<Module> module = moduleRepository.findById(id);
        return module.orElse(null);
    }

    public List<Module> getModuleByCourseId(Long id) {
        List<Module> modules = moduleRepository.findByCourseId(id);
        return modules;
    }

    public Module createModule(Module module) {
        return moduleRepository.save(module);
    }

    public Module updateModule(Long id, Module module) {
        Optional<Module> moduleToUpdate = moduleRepository.findById(id);
        if(moduleToUpdate.isPresent()) {
            Module existingModule = moduleToUpdate.get();
            existingModule.setCourseId(module.getCourseId());
            existingModule.setName(module.getName());
            return moduleRepository.save(existingModule);
        } 
        return null;
    }

    public void deleteModule(Long id) {
        moduleRepository.deleteById(id);
    }

}
