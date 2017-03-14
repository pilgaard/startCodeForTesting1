/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testex;

import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import testex.jokefetching.ChuckNorris;
import testex.jokefetching.EduJoke;
import testex.jokefetching.IFetcherFactory;
import testex.jokefetching.IJokeFetcher;
import testex.jokefetching.Moma;
import testex.jokefetching.Tambal;

/**
 *
 * @author Emil
 */
@RunWith(MockitoJUnitRunner.class)
public class JokeFetcherTest {

    private JokeFetcher jokeFetcher;

    @Mock
    IDateFormatter ifMock;
    @Mock
    IFetcherFactory factory;
    @Mock
    Moma moma;
    @Mock
    ChuckNorris chuck;
    @Mock
    EduJoke edu;
    @Mock
    Tambal tambal;

    @Before
    public void setup() {
        List<IJokeFetcher> fetchers = Arrays.asList(edu, chuck, moma, tambal);
        when(factory.getJokeFetchers("EduJoke,ChuckNorris,Moma,Tambal")).thenReturn(fetchers);
        List<String> types = Arrays.asList("EduJoke", "ChuckNorris", "Moma", "Tambal");
        when(factory.getAvailableTypes()).thenReturn(types);
        jokeFetcher = new JokeFetcher(ifMock, factory);
    }

    public JokeFetcherTest() {
    }

    @Test
    public void testGetAvailableTypes() throws Exception {
        assertThat(jokeFetcher.getAvailableTypes(), hasItems("eduprog", "chucknorris", "moma", "tambal"));
        assertThat(jokeFetcher.getAvailableTypes().size(), is(4));
    }

    @Test
    public void testcheckIfValidToken() throws Exception {
        assertTrue(jokeFetcher.checkIfValidToken("chucknorris"));
        assertFalse(jokeFetcher.checkIfValidToken("something"));
    }

    @Test
    public void testGetJokes() throws Exception {
        given(ifMock.getFormattedDate(eq("Europe/Copenhagen"), anyObject())).willReturn("17 feb. 2017 10:56 AM");
        Jokes jokes = jokeFetcher.getJokes("eduprog,chucknorris,moma,tambal", "Europe/Copenhagen");
        assertThat(jokes.getTimeZoneString(), is("17 feb. 2017 10:56 AM"));
        verify(ifMock, times(1)).getFormattedDate(eq("Europe/Copenhagen"), anyObject());
    }
}
