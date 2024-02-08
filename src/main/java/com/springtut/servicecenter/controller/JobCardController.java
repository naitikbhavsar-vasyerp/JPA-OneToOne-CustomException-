	package com.springtut.servicecenter.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.springtut.servicecenter.dto.JobCardDto;
import com.springtut.servicecenter.dto.RequestPayloadDto;
import com.springtut.servicecenter.dto.ResponseDto;
import com.springtut.servicecenter.model.JobCard;
import com.springtut.servicecenter.service.JobCardService;


@RestController
@RequestMapping("/jobcard")
public class JobCardController {

	
	@Autowired
	JobCardService jobCardService;
	
	@GetMapping("/get")
	public ResponseDto getJobCards(){
		List<JobCardDto> jobCardDtos =  jobCardService.getAllJobCards();
		return new ResponseDto(200, "Jobcards fetched successfully", jobCardDtos);
	}
	
	@GetMapping("/get/{jobCardId}")
	public ResponseDto getJobCard(@PathVariable("jobCardId") Long jobCardId){
		JobCardDto jobCardDto =  jobCardService.getJobCard(jobCardId);
		return new ResponseDto(200, "Jobcard fetched successfully", jobCardDto);
	}
	
	@PostMapping("/create")
	public ResponseDto saveJobCard(@RequestBody JobCard jobCard) {
		JobCardDto jobCardDto = jobCardService.saveJobCard(jobCard);
		return new ResponseDto(200, "jobcard created successfully", jobCardDto);
	}
	
	@PostMapping("/assign-created")
	public ResponseDto assignvehical(@RequestBody RequestPayloadDto requestPayload) {
		JobCardDto jobCardDto = jobCardService.assignCreated(requestPayload.jobCardId, requestPayload.chasisNumber);
		return new ResponseDto(200, "Vehical assigned to jobcard successfully", jobCardDto);
	}
	
	@PutMapping("/update")
	public ResponseDto updateJobCard(@RequestBody JobCard jobCard) {	
		JobCardDto jobCardDto = jobCardService.updateJobCard(jobCard);
		return new ResponseDto(200, "jobcard updated successfully", jobCardDto);
	}
	
	@DeleteMapping("/delete/{jobCardId}")
	public ResponseDto deleteJobCard(@PathVariable("jobCardId") Long jobCardId) {
		String message = new String();
		if(jobCardService.deleteJobCard(jobCardId)) {
			message = "JobCard deleted successfully";
		}
		else {
			message = "JobCard not deleted";
		}
		
		return new ResponseDto(200, message);
	}
	                  
	@PostMapping("/upload")
	public ResponseDto getFile(@RequestParam("file") MultipartFile file) {
		String message = "File uploaded. Download by clicking "+jobCardService.uploadFile(file);
		return new ResponseDto(200, message);
	}
	
	@GetMapping("/download/{fileName}")
	public ResponseEntity<Object> getFile(@PathVariable("fileName") String name){
		ResponseEntity<Object> entity = jobCardService.getFile(name);
		return entity;
	}
	
}
