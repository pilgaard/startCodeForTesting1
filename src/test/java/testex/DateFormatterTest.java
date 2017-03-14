/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testex;

import java.sql.Timestamp;
import java.util.Date;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.Test;

/**
 *
 * @author Emil
 */
public class DateFormatterTest {
    
    public DateFormatterTest() {
    }
    

    /**
     * Test of getFormattedDate method, of class DateFormatter.
     */
    @Test
    public void testGetFormattedDate() throws Exception {
        DateFormatter dateFormatter = new DateFormatter();
        Date date = new Date(1489482000L*1000);
        String expected = "14 mar. 2017 10:00 AM";
        String df = dateFormatter.getFormattedDate("Europe/Copenhagen", date);
        assertThat(df, is(expected));
    }
    
    @Test
    public void testGetFormattedDateFail() throws Exception {
        DateFormatter dateFormatter = new DateFormatter();
        Date date = new Date(1489482000L*1000);
        String expected = "14 mar. 2017 10:00 AM";
        String df = dateFormatter.getFormattedDate("Asia/Tokyo", date);
        assertThat(df, is(not(expected)));
    }      
}
