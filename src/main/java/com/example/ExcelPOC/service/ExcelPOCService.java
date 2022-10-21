package com.example.ExcelPOC.service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import com.example.ExcelPOC.dto.ExcelRequest;
import com.example.ExcelPOC.dto.ExcelResponse;

@Service
public class ExcelPOCService {
	public ExcelResponse generateExcel(ExcelRequest request) throws IOException {
		Workbook workbook = new XSSFWorkbook();

		Sheet sheet = workbook.createSheet("MultiLine Text");
		sheet.setColumnWidth(0, 6000);
		sheet.setColumnWidth(1, 4000);

		Row header = sheet.createRow(0);

		CellStyle headerStyle = workbook.createCellStyle();
		headerStyle.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
		headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

		XSSFFont font = ((XSSFWorkbook) workbook).createFont();
		font.setFontName("Arial");
		font.setFontHeightInPoints((short) 16);
		font.setBold(true);
		headerStyle.setFont(font);

		Cell headerCell = header.createCell(0);
		headerCell.setCellValue("ID");
		headerCell.setCellStyle(headerStyle);

		headerCell = header.createCell(1);
		headerCell.setCellValue("Filenames");
		headerCell.setCellStyle(headerStyle);
		
		
		
		CellStyle style = workbook.createCellStyle();
		style.setWrapText(true);

		Row row = sheet.createRow(1);
		//Set the height of the cell to the number of filenames
		if(!request.getFileNames().isEmpty() && request.getFileNames().size()>0) {
		row.setHeightInPoints(((request.getFileNames().size())*sheet.getDefaultRowHeightInPoints()));
		}
		Cell cell = row.createCell(0);
		//Set the id here
		cell.setCellValue(request.getId());
		cell.setCellStyle(style);

		cell = row.createCell(1);
		String cellContent="";
		if(!request.getFileNames().isEmpty() && request.getFileNames().size()>0) {
			//Sort the files as per the fileNames
			Collections.sort(request.getFileNames());
			int count=0;
			for(String content:request.getFileNames()) {
				if(count==0) {
					cellContent=content;
					count++;
				}else if(count<=request.getFileNames().size()-1){
					cellContent=cellContent+" \n"+content;
					count++;
				}
			}
		}
		//Set the multi line text here
		cell.setCellValue(cellContent);
		cell.setCellStyle(style);
		
		
		//Generate the file to the below location
		String fileLocation = "C:\\Users\\BiswadeepB\\Documents\\ExcelPOCFiles\\POC.xlsx";
		FileOutputStream outputStream = new FileOutputStream(fileLocation);
		workbook.write(outputStream);
		workbook.close();
		
		ExcelResponse response = new ExcelResponse();
		response.setMessage("Excel file generated successfully");
		response.setResponseCode(200);
		return response;
	}
}
