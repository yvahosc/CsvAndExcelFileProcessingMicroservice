package org.makaia.fileProcessor.model;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.makaia.fileProcessor.exceptions.ApiException;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CsvFile extends File{
    public CsvFile(String filePath, String fileType) throws ApiException {
        super(filePath, fileType);
        super.setFileRecords(generateFileRecords(filePath));
    }

    public static List<List<String>> generateFileRecords(String filePath) throws ApiException {
        List<List<String>> records = new ArrayList();

        try{
            Reader reader = Files.newBufferedReader(Paths.get(filePath));
            CSVParser parser = new CSVParser(reader, CSVFormat.DEFAULT);
            for (CSVRecord registro: parser) {
                records.add(registro.toList());
            }
        } catch (Exception e) {
            throw new ApiException(400, "Error en la lectura del archivo");
        }
        return records;
    }
}