package com.modules.manage_module.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.modules.manage_module.dto.ModuleDto;
import com.modules.manage_module.entity.Modules;
import com.modules.manage_module.service.ModuleService;

@RestController
@RequestMapping("/modules")
public class ModuleController {
	
	@Autowired
	private ModuleService moduleService;
	
	@PostMapping("/createModule")
	public ResponseEntity<?> createModule(@RequestBody ModuleDto moduledto)
	{
		try {
            Modules savedModule = moduleService.createModule(moduledto);
            
            return ResponseEntity.ok(savedModule);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                                 .body("Error occurred while creating the module: " + e.getMessage());
        }
	}
	
	@GetMapping("/getProjectModules")
	public ResponseEntity<List<ModuleDto>> getAllProjectModules(@RequestParam String projectId){
		List<ModuleDto> moduleDtoList = moduleService.getProjectModules(projectId);
        return ResponseEntity.status(HttpStatus.OK).body(moduleDtoList);
 
	}
	@GetMapping("/getModule")
	public ResponseEntity<ModuleDto> getModule(@RequestParam String moduleId){
		ModuleDto moduleDto = moduleService.getModule(moduleId);
       return ResponseEntity.status(HttpStatus.OK).body(moduleDto);
	}
	@PutMapping("/update")
	public ResponseEntity<?> updateModule(@RequestBody ModuleDto moduledto)
	{
		boolean response = moduleService.updateModule(moduledto);
		if(response)
		{
	        return ResponseEntity.status(HttpStatus.OK).body("Module updated successfully");
		}
		else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Module update failed!");
		}
	}
}
