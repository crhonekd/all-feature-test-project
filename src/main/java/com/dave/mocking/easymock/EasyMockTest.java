package com.dave.mocking.easymock;

import com.dave.mocking.model.*;
import org.easymock.EasyMock;
import org.easymock.EasyMockRunner;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by David on 07/10/2017.
 */
@RunWith(EasyMockRunner.class)
public class EasyMockTest {

    @Mock
    FileServiceImpl fileService;
    @Mock
    AckServiceImpl ackService;
    @TestSubject
    AsyncFileServiceImpl asyncFileService = new AsyncFileServiceImpl();

    @Test
    public void firstTest() {
        ImportFile file = null;
        ImportedFileResponse respose = null;
        FileImportHeader header = null;

        EasyMock.expect(fileService.importAndPersist(file)).andReturn(header);
        EasyMock.replay(fileService);

        EasyMock.expect(ackService.sendPositiceAck(header)).andReturn(true);
        EasyMock.replay(ackService);


        ImportedFileResponse response = asyncFileService.importFile(file);

        Assert.assertEquals(true, response.isAckSent());


    }
}
