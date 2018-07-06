package com.dave.mocking.easymock;

import com.dave.mocking.model.*;
import org.easymock.*;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Created by David on 07/10/2017.
 */
@RunWith(EasyMockRunner.class)
@Ignore
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
