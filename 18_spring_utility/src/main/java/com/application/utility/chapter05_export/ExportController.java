package com.application.utility.chapter05_export;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
/*

	# Excel Export (poi)
	
	- Apache POI는 Java에서 Microsoft Office 형식의 파일을 읽고 쓰기 위한 라이브러리이다. 
	
	- 스프링 부트(Spring Boot) Apache POI 라이브러리를 사용하여 Excel 파일의 데이터를 정리하고 보고서를 생성할 수 있다. 
	
	
	
	[ 스프링 Excel Export 구현방법 ]
	
		1) build.gradle파일에 의존성을 추가한다.
		
			// excel export
			implementation 'org.apache.poi:poi:5.2.2'
			implementation 'org.apache.poi:poi-ooxml:5.2.2'
		
		
		2) 컨트롤러에서 export 기능을 구현한다. (ExportSample.java참조)

*/

import com.application.utility.chapter04_scheduler.SchedulerDAO;

import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/export")
public class ExportController {
	
	@Autowired
	private SchedulerDAO schedulerDAO; // 단순 실습을 위한 DAO 재사용
	
	@GetMapping("/main")
	public String main() {
		return "export/main";
	}
	
	@GetMapping("/ex")
	public void exportSample(HttpServletResponse response) {
  
		try {
			 
			// Excel 파일명
			String fileName = "export_ex";
			
			// Excel Sheet
			Workbook workbook = new XSSFWorkbook();
			Sheet sheet = workbook.createSheet("test sheet");
			
			// Excel 헤더
			String[] header = {"제목1", "제목2", "제목3", "제목4", "제목5"};
			Row row = sheet.createRow(0);                 // 1row를 생성한다.
			for (int i = 0; i < header.length; i++) {
			    Cell cell = row.createCell(i);			  // 1cell을 생성한다.
			    cell.setCellValue(header[i]);			  // 데이터를 대입한다.
			}
	
			// Excel 본문
			for (int i = 1; i < 10; i++) {
				
				row = sheet.createRow(i); 
				
				Cell cell = row.createCell(0);
				cell.setCellValue("제목1 데이터");
				
				cell = row.createCell(1);
				cell.setCellValue("제목2 데이터");
				
				cell = row.createCell(2);
				cell.setCellValue("제목3 데이터");
				
				cell = row.createCell(3);
				cell.setCellValue("제목4 데이터");
				
				cell = row.createCell(4);
				cell.setCellValue("제목5 데이터");
				
			}

			// 엑셀 파일 생성 및 다운로드
			response.setContentType("application/vnd.ms-excel");
			response.setHeader("Content-Disposition", "attachment;filename="+ URLEncoder.encode(fileName, "UTF-8") + ".xlsx");
			workbook.write(response.getOutputStream());
			workbook.close();
	
		} catch(IOException e) {
		    e.printStackTrace();
		}
		
	}
	
	@GetMapping("/productExport")
	public void productExport(HttpServletResponse response) {
  
		try {
			 
			// Excel 파일명
			String fileName = "productList";
			
			// Excel Sheet
			Workbook workbook = new XSSFWorkbook();
			Sheet sheet = workbook.createSheet("상품리스트");
			
			// Excel 헤더
			String[] header = {"상품아이디", "상품이름", "가격", "배송비", "등록일자", "브랜드아이디"};
			Row row = sheet.createRow(0);                 // 1row를 생성한다.
			for (int i = 0; i < header.length; i++) {
			    Cell cell = row.createCell(i);			  // 1cell을 생성한다.
			    cell.setCellValue(header[i]);			  // 데이터를 대입한다.
			}
	
			// Excel 본문
			List<Map<String,Object>> productList = schedulerDAO.getProductList();
			int i = 0;
			for (Map<String,Object> product : productList ) {
				
				row = sheet.createRow(i);
				
				Cell cell = row.createCell(0);
				cell.setCellValue((String)product.get("PRODUCT_ID").toString());
				
				cell = row.createCell(1);
				cell.setCellValue((String)product.get("PRODUCT_NM").toString());
				
				cell = row.createCell(2);
				cell.setCellValue((String)product.get("PRICE").toString().toString());
				
				cell = row.createCell(3);
				cell.setCellValue((String)product.get("DELIVERY_PRICE").toString());
				
				cell = row.createCell(4);
				cell.setCellValue((String)product.get("ENROLL_AT").toString());
				
				cell = row.createCell(5);
				cell.setCellValue((String)product.get("BRAND_ID").toString());
				
				i++;
			}
	
				
			// 엑셀 파일 생성 및 다운로드
			response.setContentType("application/vnd.ms-excel");
			response.setHeader("Content-Disposition", "attachment;filename="+ URLEncoder.encode(fileName, "UTF-8") + ".xlsx");
			workbook.write(response.getOutputStream());
			workbook.close();
	
		} catch(IOException e) {
		    e.printStackTrace();
		}
		
	}
	
	@GetMapping("/brandExport")
	public void brandExport(HttpServletResponse response) {
  
		try {
			 
			// Excel 파일명
			String fileName = "brandList";
			
			// Excel Sheet
			Workbook workbook = new XSSFWorkbook();
			Sheet sheet = workbook.createSheet("브랜드리스트");
			
			// Excel 헤더
			String[] header = {"브랜드아이디", "브랜드이름"};
			Row row = sheet.createRow(0);                 // 1row를 생성한다.
			for (int i = 0; i < header.length; i++) {
			    Cell cell = row.createCell(i);			  // 1cell을 생성한다.
			    cell.setCellValue(header[i]);			  // 데이터를 대입한다.
			}
	
			// Excel 본문
			List<Map<String,Object>> brandList = schedulerDAO.getBrandList();
			int i = 0;
			for (Map<String,Object> brand : brandList ) {
				
				row = sheet.createRow(i);
				
				Cell cell = row.createCell(0);
				cell.setCellValue((String)brand.get("BRAND_ID").toString());
				
				cell = row.createCell(1);
				cell.setCellValue((String)brand.get("BRAND_NM").toString());
				
				i++;
			}
	
				
			// 엑셀 파일 생성 및 다운로드
			response.setContentType("application/vnd.ms-excel");
			response.setHeader("Content-Disposition", "attachment;filename="+ URLEncoder.encode(fileName, "UTF-8") + ".xlsx");
			workbook.write(response.getOutputStream());
			workbook.close();
	
		} catch(IOException e) {
		    e.printStackTrace();
		}
		
	}
}
