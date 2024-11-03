package com.thirdparty.apiservice.utility;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.springframework.stereotype.Component;

@Component
public class ExcelDataValidationUtility {

    public static  String cellTypeConverter(Cell cell){
        String value = null;
        try {
            CellType type = cell.getCellType();
            if(type == CellType.NUMERIC){
                value = String.valueOf(Integer.valueOf((int) cell.getNumericCellValue()));
            } else if (cell == null) {
                value = null;

            } else if (type == CellType._NONE || type == CellType.BLANK) {
                value = "";
            } else if (type == CellType.BOOLEAN) {
                value = String.valueOf(Boolean.valueOf(cell.getBooleanCellValue()));
            } else  {
                value = cell.getStringCellValue();
            }
        value = value.trim();
        }catch (Exception e) {

        }
        return value;
    }
}
