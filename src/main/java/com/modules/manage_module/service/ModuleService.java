package com.modules.manage_module.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.modules.manage_module.dto.ModuleDto;
import com.modules.manage_module.entity.Modules;
import com.modules.manage_module.repository.ModulesRepository;

@Service
public class ModuleService {
	@Autowired
	private ModulesRepository moduleRepo;
	
	public Modules createModule(ModuleDto moduledto) {
		try {
		Modules module = new Modules();
	    module.setModuleid(UUID.randomUUID().toString());  
		module.setName(moduledto.getName());
		module.setDescription(moduledto.getDescription());
		module.setCreated_at(LocalDateTime.now());
		module.setOwner(moduledto.getOwner());
		module.setStatus(moduledto.getStatus());
		module.setStartdate(moduledto.getStartdate());
		module.setDuedate(moduledto.getDuedate());
		module.setProjectid(moduledto.getProjectid());
		
		Modules savedModule = moduleRepo.save(module);
		return savedModule;
		}
		catch(Exception e)
		{
			
			return null;
		}
	}
	
	public List<ModuleDto> getProjectModules(String projectId)
	{
		List<ModuleDto> moduledtoList = new ArrayList<>();
		
		List<Modules> moduleList = moduleRepo.findAllById(projectId);
		
		for(Modules module : moduleList) {
			
		ModuleDto moduledto = new ModuleDto();
		moduledto.setName(module.getName());
		moduledto.setDescription(module.getDescription());
		moduledto.setCreated_at(module.getCreated_at());
		moduledto.setModuleid(module.getModuleid());
		moduledto.setOwner(module.getOwner());
		moduledto.setProjectid(module.getProjectid());
		moduledto.setStartdate(module.getStartdate());
		moduledto.setDuedate(module.getDuedate());
		moduledto.setStatus(module.getStatus());
		moduledto.setUpdated_at(module.getUpdated_at());
		
		moduledtoList.add(moduledto);
		}
		return moduledtoList;
	}
	
	public ModuleDto getModule(String moduleId)
	{
		ModuleDto moduledto = new ModuleDto();	
		Optional<Modules> module = moduleRepo.findById(moduleId);
		
		if(module.isPresent())
		{
			Modules actualModule = module.get();
			moduledto.setName(actualModule.getName());
			moduledto.setDescription(actualModule.getDescription());
			moduledto.setCreated_at(actualModule.getCreated_at());
			moduledto.setModuleid(actualModule.getModuleid());
			moduledto.setOwner(actualModule.getOwner());
			moduledto.setProjectid(actualModule.getProjectid());
			moduledto.setStartdate(actualModule.getStartdate());
			moduledto.setDuedate(actualModule.getDuedate());
			moduledto.setStatus(actualModule.getStatus());
			moduledto.setUpdated_at(actualModule.getUpdated_at());
		}
		return moduledto;
	}
	
	public boolean updateModule(ModuleDto moduledto) {
	    try {
	        return moduleRepo.findById(moduledto.getModuleid())
	                .map(existingModule -> {
	                    if (existingModule.getName() != null) {
	                        existingModule.setName(moduledto.getName());
	                    }
	                    if (existingModule.getDescription() != null) {
	                        existingModule.setDescription(moduledto.getDescription());
	                    }
	                    if (existingModule.getOwner() != null) {
	                        existingModule.setOwner(moduledto.getOwner());
	                    }
	                    if (existingModule.getProjectid() != null) {
	                        existingModule.setProjectid(moduledto.getProjectid());
	                    }
	                    if (existingModule.getStartdate() != null) {
	                        existingModule.setStartdate(moduledto.getStartdate());
	                    }
	                    if (existingModule.getDuedate() != null) {
	                        existingModule.setDuedate(moduledto.getDuedate());
	                    }
	                    if (existingModule.getStatus() != null) {
	                        existingModule.setStatus(moduledto.getStatus());
	                    }
	                    if (existingModule.getUpdated_at() != null) {
	                        existingModule.setUpdated_at(moduledto.getUpdated_at());
	                    }
	                    moduleRepo.save(existingModule);
	                    return true; 
	                }).orElse(false); 
	    } catch (Exception e) {
	        return false; 
	    }
	}

}