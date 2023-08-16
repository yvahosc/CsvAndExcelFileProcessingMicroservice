package org.makaia.fileProcessor.model;

import java.util.List;

public abstract class File {
    private final String filePath;
    private final String fileType;
    private List<List<String>> fileRecords;

    public File(String filePath, String fileType) {
        this.filePath = filePath;
        this.fileType = fileType;
    }

    public List<List<String>> getFileRecords() {
        return fileRecords;
    }

    public void setFileRecords(List<List<String>> fileRecords) {
        this.fileRecords = fileRecords;
    }
}