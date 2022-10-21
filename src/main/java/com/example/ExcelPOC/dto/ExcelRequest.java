package com.example.ExcelPOC.dto;

import java.util.List;

public class ExcelRequest {
	private int id;
	private List<String> fileNames;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<String> getFileNames() {
		return fileNames;
	}
	public void setFileNames(List<String> fileNames) {
		this.fileNames = fileNames;
	}
	public ExcelRequest(int id, List<String> fileNames) {
		super();
		this.id = id;
		this.fileNames = fileNames;
	}
	public ExcelRequest() {
		super();
	}
	@Override
	public String toString() {
		return "ExcelRequest [id=" + id + ", fileNames=" + fileNames + "]";
	}
}
