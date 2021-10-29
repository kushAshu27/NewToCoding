package com.Vtiger.Automation.Utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestDataUtil {

	private static Workbook wbook = null;
	private static Sheet sheetobj = null;
	public static Map<String, String> TDMap = null;
	
	public static void createWorkBookObject(String Filepath) throws IOException {
		
		FileInputStream file = new FileInputStream(Filepath);
	//	String ext1 = FilenameUtils.getExtension("TestData\\TestData.xlsx");
		
	//	if(ext1.equalsIgnoreCase("xlxs")) {
			
			 wbook = new XSSFWorkbook(file);
			 System.out.println(wbook);
			
	/*	}else {
			
			 wbook = new HSSFWorkbook(file);
		}*/
			
	}
	
	public static void createWorkSheetObj() {
		
		sheetobj = wbook.getSheet("TestData");
	}
	
	public static int rowount() {
		
		int rowcnt = sheetobj.getPhysicalNumberOfRows();
		System.out.println(rowcnt);
		return rowcnt;
	}
	
	public static int getColumnCount() {
		
		Row rowobj = sheetobj.getRow(0);
		int colmncnt = rowobj.getPhysicalNumberOfCells();
		System.out.println(colmncnt);
		return colmncnt;
	}
	
	public static int getDesiredRowNumber(String Filepath, String TCID) throws IOException
	{
		int returnRowNumber = 0;
		createWorkBookObject(Filepath);
		createWorkSheetObj();
		int rw =  rowount();
		int cl = getColumnCount();
		for(int i=1; i<=rw ; i++)
		{
			for(int j=0; j<cl-1; j++)
			{
				Row rowobj = sheetobj.getRow(i);
				Cell CelObj = rowobj.getCell(j, MissingCellPolicy.CREATE_NULL_AS_BLANK);
				String CellDataValue = CelObj.getStringCellValue();
				if(CellDataValue.equalsIgnoreCase(TCID))
				{
					returnRowNumber = i;
					return returnRowNumber;
				}
			}
		}
		return cl;
	}
	
	public static void getTestCaseData(String Filepath, String TCID) throws Exception
	{
		TDMap = new HashMap<String, String>();
		int desiredrow = getDesiredRowNumber(Filepath,TCID);
		int clmcnt = getColumnCount();
		for(int i=0; i<clmcnt-1; i++)
		{
			Row robj = sheetobj.getRow(desiredrow);
			Cell clobj = robj.getCell(i, MissingCellPolicy.CREATE_NULL_AS_BLANK);
			String KeyData = clobj.getStringCellValue();
			Cell clobj1 = robj.getCell(i+1, MissingCellPolicy.CREATE_NULL_AS_BLANK);
			String KeyValueData = clobj1.getStringCellValue();
			TDMap.put(KeyData, KeyValueData);
			i = i+1;
		}
		System.out.println("aaa");
	}
}
