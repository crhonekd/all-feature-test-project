package com.dave.mocking.mockito;

import com.dave.mocking.model.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Created by David on 07/10/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class MockitoTest {

    @Mock
    FileServiceImpl fileService;
    @Mock
    AckServiceImpl ackService;
    @InjectMocks
    AsyncFileServiceImpl asyncFileService;

    @Captor
    ArgumentCaptor<String> nameCaptor;

    @Before
    public void init() {
//        asyncFileService = new AsyncFileServiceImpl();
//        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void firstTest() {
        ImportFile file = null;
        ImportedFileResponse respose = null;
        FileImportHeader header = null;

        when(fileService.importAndPersist(file)).thenReturn(header);
        when(ackService.sendPositiceAck(    header)).thenReturn(true);

        ImportedFileResponse response = asyncFileService.importFile(file);

        verify(ackService).setSomeName(nameCaptor.capture());
        final String value = nameCaptor.getValue();
        assertEquals("David", value);

        assertEquals(true, response.isAckSent());
        verify(fileService).importAndPersist(file);
        verify(ackService, times(1)).sendPositiceAck(header);
        verify(ackService, times(1)).setSomeName("David");
        verify(ackService, never()).sendNegativeAck(header);


    }
}
