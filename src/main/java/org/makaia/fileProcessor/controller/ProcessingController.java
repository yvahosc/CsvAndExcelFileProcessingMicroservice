package org.makaia.fileProcessor.controller;

import org.makaia.fileProcessor.exceptions.ApiException;
import org.makaia.fileProcessor.model.Response;
import org.makaia.fileProcessor.service.ProcessingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/file")
public class ProcessingController {

    ProcessingService processingService;

    @Autowired()
    public ProcessingController(ProcessingService processingService){
        this.processingService = processingService;
    }

    @PostMapping()
    public List<List<String>> generateRecordsFromFile(@RequestBody() String filePath) throws ApiException {
        return processingService.generateRecordsFromFile(filePath);
    }

    @PostMapping("/file-processor-and-record-validation")
    public Response fileRecordValidation(@RequestBody() String filePath) throws ApiException {
        return processingService.fileRecordValidation(filePath);
    }
}