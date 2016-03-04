package com.yash.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import com.yash.bean.ServerBean;

@Service
public class ServerDataManager {

	private List<ServerBean> serverList = null;

	public List<ServerBean> getServerList() {
		if (serverList == null) {
			serverList = new ArrayList<ServerBean>();
			try {
				InputStream file = new FileInputStream(
						new File(
								"C:\\Data\\Sample\\PingWebApp\\src\\main\\resources\\ServerList.xlsx"));

				// Create Workbook instance holding reference to .xlsx file
				XSSFWorkbook workbook = new XSSFWorkbook(file);

				// Get first/desired sheet from the workbook
				XSSFSheet sheet = workbook.getSheetAt(0);

				// Iterate through each rows one by one
				Iterator<Row> rowIterator = sheet.iterator();
				while (rowIterator.hasNext()) {
					Row row = rowIterator.next();
					ServerBean serverBean = new ServerBean();
					// For each row, iterate through all the columns
					Cell methodCell = row.getCell(0);
					Cell targerUrlCell = row.getCell(1);
					Cell payloadCell = row.getCell(2);
					if (methodCell != null) {
						serverBean.setMethod(methodCell.getStringCellValue());
						serverBean.setUrl(targerUrlCell.getStringCellValue());
						if (payloadCell != null) {
							serverBean.setPayload(payloadCell
									.getStringCellValue());
						}
					}
					serverList.add(serverBean);

				}
				file.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return serverList;
	}

}
