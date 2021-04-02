package com.rp.utilities;

import com.rp.constants.FrameWorkConstants;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class ExcelUtil {

    private ExcelUtil() {
    }

    public static List<Map<String, String>> getTestDetails(String sheetname) {
        List<Map<String, String>> l = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream(FrameWorkConstants.getEXCELPATH())) {
            HSSFWorkbook workbook = new HSSFWorkbook(fis);
            HSSFSheet sheet = workbook.getSheet(sheetname);

            Map<String, String> map = null;

            int lastrownum = sheet.getLastRowNum();
            int lastcolnum = sheet.getRow(0).getLastCellNum();
            for (int i = 1; i <= lastrownum; i++) {
                map = new HashMap<>();
                for (int j = 0; j < lastcolnum; j++) {
                    DataFormatter dataFormatter = new DataFormatter();
                    HSSFCell keyCell = sheet.getRow(0).getCell(j);
                    HSSFCell valueCell = sheet.getRow(i).getCell(j);
                    map.put(dataFormatter.formatCellValue(keyCell), dataFormatter.formatCellValue(valueCell));
                }
                l.add(map);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return l;
    }
}