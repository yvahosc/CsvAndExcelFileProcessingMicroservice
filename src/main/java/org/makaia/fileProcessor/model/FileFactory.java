package org.makaia.fileProcessor.model;

import org.makaia.fileProcessor.exceptions.ApiException;

public class FileFactory {
    public static File generateFileRecords(String filePath) throws ApiException {

        int index = 0;
        for (int i = filePath.length() - 1; i >= 0; i--) {
            if (filePath.charAt(i) == '.'){
                index = i;
                break;
            }
        }

        String fileType = filePath.substring(index);

        switch (fileType) {
            case (".xlsx"):
                return new ExcelFile(filePath, fileType);
            case (".csv"):
                return new CsvFile(filePath, fileType);
            default:
                throw new ApiException(400, "Tipo de archivo: no " +
                        "corresponde a los definidos.");
        }
    }
}