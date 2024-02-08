package com.springtut.servicecenter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springtut.servicecenter.dto.JobCardDto;
import com.springtut.servicecenter.dto.ResponseDto;
import com.springtut.servicecenter.dto.VehicalDto;
import com.springtut.servicecenter.model.JobCard;
import com.springtut.servicecenter.model.Vehical;
import com.springtut.servicecenter.service.VehicalService;

@RestController
@RequestMapping("/vehical")
public class VehicalController {

	@Autowired
	VehicalService service;
	
	@GetMapping("/get")
	public ResponseDto getVehicals(){
		List<VehicalDto> vehicalDtos =  service.getAllVehicals();
		return new ResponseDto(200, "Vehicals fetched successfully", vehicalDtos);
	}
	
	@GetMapping("/get/{chasisnumber}")
	public ResponseDto getVehical(@PathVariable("chasisnumber") String chasisNumber){
		VehicalDto vehicalDto =  service.getVehicalDto(chasisNumber);
		return new ResponseDto(200, "Vehical fetched successfully", vehicalDto);
	}
	
	@PostMapping("/create")
	public ResponseDto saveVehical(@RequestBody Vehical vehical) {
		VehicalDto vehicalDto = service.addVehical(vehical);
		return new ResponseDto(200, "Vehical saved successfully", vehicalDto);
	}
	
	@PutMapping("/update")
	public ResponseDto updateVehical(@RequestBody Vehical vehical) {	
		VehicalDto vehicalDto = service.addVehical(vehical);
		return new ResponseDto( 200, "Vehical data updated successfully", vehicalDto);
	}
	
	@DeleteMapping("/delete/{chasisNumber}")
	public ResponseDto deleteVehical(@PathVariable("chasisNumber") String chasisNumber) {
		String message = new String();
		if(service.deleteVehical(chasisNumber)) {
			message = "Vehical deleted successfully";
		}
		else {
			message = "Vehical deletion unsuccessfull";
		}
		return new ResponseDto(200, message);
	}
	
}
