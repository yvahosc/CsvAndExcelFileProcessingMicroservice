package org.makaia.fileProcessor.model;

import java.util.List;

public class FileRecordProvisionalStructure {
    private String fileType;
    private List<String> fileRecord;

    public FileRecordProvisionalStructure(String fileType, List<String> fileRecord) {
        this.fileType = fileType;
        this.fileRecord = fileRecord;
    }

    public String getFileType() {
        return fileType;
    }

    public List<String> getFileRecord() {
        return fileRecord;
    }
}