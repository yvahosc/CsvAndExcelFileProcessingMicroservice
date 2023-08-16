package org.makaia.fileProcessor.model;

import org.apache.poi.EmptyFileException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.*;
import org.makaia.fileProcessor.exceptions.ApiException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelFile extends File{
    public ExcelFile(String filePath, String fileType) throws ApiException {
        super(filePath, fileType);
        super.setFileRecords(generateFileRecords(filePath));
    }

    public static List<List<String>> generateFileRecords(String filePath) throws ApiException {
        Workbook workbook = null;
        try {
            workbook = WorkbookFactory.create(new java.io.File(filePath));
        } catch (IOException e) {
            throw new ApiException(400, "Error en la lectura del archivo");
        } catch (EncryptedDocumentException e){
            throw new ApiException(400, "Error al intentar acceder " +
                    "al archivo, este se encuentra protegido con contraseña");
        } catch(EmptyFileException e){
            throw new ApiException(400, "El archivo se encuentra vacío");
        }
        if(workbook == null){
            throw new ApiException(400, "No se encontró el archivo en la " +
                    "ruta suministrada");
        }
        Sheet sheet = workbook.getSheetAt(0);
        Iterator<Row> column = sheet.rowIterator();

        List<List<String>> records = new ArrayList();

        while(column.hasNext()){
            List<String> record = new ArrayList<>();
            Row row = (Row) column.next();
            Iterator<Cell> cells = row.cellIterator();
            while(cells.hasNext()){
                Cell cell = cells.next();
                switch(cell.getCellType()) {
                    case NUMERIC:
                        if(DateUtil.isCellDateFormatted(cell)){
                            record.add(String.valueOf(cell.getDateCellValue()));
                        }else{
                            String cellValue =
                                    String.valueOf(cell.getNumericCellValue());
                            record.add(cellValue);
                        }
                        break;
                    case STRING:
                        record.add(cell.getStringCellValue());
                        break;
                    case BOOLEAN:
                        record.add(String.valueOf(cell.getBooleanCellValue()));
                        break;
                    case FORMULA:
                        try{
                            record.add(cell.getStringCellValue());
                        }catch(Exception e){
                            record.add(String.valueOf(cell.getNumericCellValue()));
                        }
                        break;
                }
            }
            records.add(record);
        }
        return records;
    }
}