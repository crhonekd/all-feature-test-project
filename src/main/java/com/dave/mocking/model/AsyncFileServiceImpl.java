package com.dave.mocking.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by David on 07/10/2017.
 */

@Service
public class AsyncFileServiceImpl {

    @Autowired
    AckServiceImpl ackService;
    @Autowired
    FileServiceImpl fileService;

    public ImportedFileResponse importFile(ImportFile file) {

        FileImportHeader fileHeader = fileService.importAndPersist(file);
        boolean ackSent = ackService.sendPositiceAck(fileHeader);

        ImportedFileResponse response = new ImportedFileResponse(fileHeader, ackSent);

        String name = new String("David");
        ackService.setSomeName(name);

        return response;
    }
}
