package com.dave.mocking.model;

/**
 * Created by David on 07/10/2017.
 */
public class ImportedFileResponse {


    private final FileImportHeader fileHeader;


    private final boolean ackSent;

    public ImportedFileResponse(FileImportHeader fileHeader, boolean ackSent) {
        this.fileHeader = fileHeader;
        this.ackSent = ackSent;
    }

    public FileImportHeader getFileHeader() {
        return fileHeader;
    }

    public boolean isAckSent() {
        return ackSent;
    }
}
