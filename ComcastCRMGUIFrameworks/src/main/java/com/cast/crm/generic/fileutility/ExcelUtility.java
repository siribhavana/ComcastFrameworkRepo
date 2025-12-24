package com.cast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility 
{
	public String getDataFromExcel(String sheetName,int rowNum,int cellNum) throws Exception
	{
		FileInputStream fis=new FileInputStream("./testData/testScriptdata1.xlsx");
		Workbook workbook=WorkbookFactory.create(fis);
		Sheet sheet=workbook.getSheet(sheetName);
		Row row=sheet.getRow(rowNum);
		Cell cell=row.getCell(cellNum);
		String data=cell.getStringCellValue();
		return data;
	}
	
	public int getRowCount(String sheetName) throws Exception
	{
		FileInputStream fis=new FileInputStream("./testData/testScriptdata1.xlsx");
		Workbook workbook=WorkbookFactory.create(fis);
		Sheet sheet=workbook.getSheet(sheetName);
		int row=sheet.getLastRowNum();
		return row;
	}
	
	public void setDataIntoExcel(String sheetName,int rowNum,int cellNum,String data) throws Exception
	{
		FileInputStream fis=new FileInputStream("./testData/testScriptdata1.xlsx");
		Workbook workbook=WorkbookFactory.create(fis);
		Sheet sheet=workbook.getSheet(sheetName);
		Row row=sheet.getRow(rowNum);
		Cell cell=row.createCell(cellNum);
		cell.setCellType(CellType.STRING);
		cell.setCellValue(data);
		FileOutputStream fos=new FileOutputStream("./testData/testScriptdata1.xlsx");
		workbook.write(fos);
		fos.close();
		workbook.close();
	}
}
