/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testex;

import java.util.List;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import testex.jokefetching.*;

/**
 *
 * @author Emil
 */
@RunWith(MockitoJUnitRunner.class)
public class FetcherFactoryTest {
    
    @Mock
    private Moma momaMock;
    
    @Mock
    private ChuckNorris chuckNorrisMock;
    
    @Mock
    private Tambal tambalMock;
    
    @Mock
    private EduJoke eduJokeMock;
    
    @Test()
    public void testFetcherFactory() throws Exception {
        FetcherFactory factory = new FetcherFactory();
        List<IJokeFetcher> result = factory.getJokeFetchers("eduprog,ChuckNorris,Moma,Tambal");
        System.out.println("result = " + result);
        assertThat(result.size(), is(4));
    }
}
