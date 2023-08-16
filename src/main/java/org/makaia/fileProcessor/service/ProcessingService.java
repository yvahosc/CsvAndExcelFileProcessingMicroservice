package org.makaia.fileProcessor.service;

import org.makaia.fileProcessor.exceptions.ApiException;
import org.makaia.fileProcessor.model.FileFactory;
import org.makaia.fileProcessor.model.FileRecordProvisionalStructure;
import org.makaia.fileProcessor.model.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ProcessingService {
    public List<List<String>> generateRecordsFromFile(String filePath) throws ApiException {
        return FileFactory.generateFileRecords(filePath).getFileRecords();
    }

    public Response fileRecordValidation(String filePath) throws ApiException {
        List<List<String>> fileRecords =
                FileFactory.generateFileRecords(filePath).getFileRecords();

        String typeFile;

        if(filePath.endsWith(".xlsx")){
            typeFile = "Excel";
        }else{
            typeFile = "csv";
        }

        int valideLinesExcel = 0;
        int invalideLinesExcel = 0;

        for(List<String> fileRecord: fileRecords){
            FileRecordProvisionalStructure structuresFileRecord =
                    new FileRecordProvisionalStructure(typeFile, fileRecord);
            Boolean recordValidation = isValidRecord(structuresFileRecord);
            if(recordValidation){
                valideLinesExcel++;
            } else{
                invalideLinesExcel++;
            }
        }
        return new Response(filePath, typeFile, valideLinesExcel,
                invalideLinesExcel - 1);
    }

    public Boolean isValidRecord(FileRecordProvisionalStructure recordFile){
        String uri = "http://localhost:8080/api/v1/file-records";

        ResponseEntity<Boolean> response =
                new RestTemplate().postForEntity(uri, recordFile,
                        Boolean.class);
        return response.getBody();
    }
}