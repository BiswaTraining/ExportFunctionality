package com.example.ExcelPOC.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ExcelPOC.dto.ExcelRequest;
import com.example.ExcelPOC.dto.ExcelResponse;
import com.example.ExcelPOC.service.ExcelPOCService;

@RestController
@RequestMapping("/excel")
public class ExcelController {
	
	@Autowired
	private ExcelPOCService excelPOCService;
	
	@PostMapping("/generateExcelPOC")
	public ResponseEntity<ExcelResponse> generateExcelPOC(@RequestBody ExcelRequest request) throws IOException{
		ExcelResponse response = excelPOCService.generateExcel(request);
		return new ResponseEntity<ExcelResponse>(response,HttpStatus.OK);
	}
}
