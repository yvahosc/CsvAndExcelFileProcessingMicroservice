package org.makaia.fileProcessor.model;

public class Response {
    private String filePath;
    private String typeFile;
    private int validRecords;
    private int invalidRecords;

    public Response(String filePath, String typeFile, int validRecords, int invalidRecords) {
        this.filePath = filePath;
        this.typeFile = typeFile;
        this.validRecords = validRecords;
        this.invalidRecords = invalidRecords;
    }

    public String getFilePath() {
        return filePath;
    }

    public String getTypeFile() {
        return typeFile;
    }

    public int getValidRecords() {
        return validRecords;
    }

    public int getInvalidRecords() {
        return invalidRecords;
    }
}