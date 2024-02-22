	package time;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TimeTest {
	
	//Total Seconds testing
	
	@Test
	public void testGetTotalSecondsGood() {
		int seconds = Time.getTotalSeconds("05:05:05:06");
		assertTrue("The seconds were not calculated propperly", seconds ==18305);
	}
	
	@Test
	public void testGetTotalSecondsBad() {
		assertThrows(StringIndexOutOfBoundsException.class,
				()->{Time.getTotalSeconds("10:00");});
	}
	
	@Test
	public void testGetTotalSecondsBoundary() {
		int seconds = Time.getTotalSeconds("23:59:59:06");
		assertTrue("The seconds were not calculated propperly", seconds ==86399);
	}
	
	
	//Get Seconds Testing
	
	public void testGetSecondsGood() {
		int seconds = Time.getSeconds("05:05:05:06");
		assertTrue("The seconds were not calculated propperly", seconds == 5);
	}
	
	@Test
	public void testGetSecondsBad() {
		assertThrows(StringIndexOutOfBoundsException.class,
				()->{Time.getTotalSeconds("10:00");});
	}
	
	@Test
	public void testGetSecondsBoundary() {
		int seconds = Time.getSeconds("23:59:59:06");
		assertTrue("The seconds were not calculated propperly", seconds == 59);
	}
	
	//Minute testing
	
	@Test
	public void testGetMinutesGood() {
		int minutes = Time.getTotalMinutes("05:05:05:06");
		assertTrue("The minutes were not calculated propperly", minutes == 5);
	}
	
	@Test
	public void testGetMinutesBad() {
		assertThrows(StringIndexOutOfBoundsException.class, 
					() ->{Time.getTotalMinutes("20"); });
	}
	
	@Test
	public void testGetMinutesBoundary() {
		int minutes = Time.getTotalMinutes("23:59:59:06");
		assertTrue("The minutes were not calculated propperly", minutes == 59);
	}
	
	//Hours
	
	@Test
	public void testGetHoursGood() {
		int hours = Time.getTotalHours("10:05:05:06");
		assertTrue("The hours were not calculated propperly", hours == 10);
	}
	
	@Test
	public void testGetHoursBad() {
		assertThrows(StringIndexOutOfBoundsException.class, 
					() ->{Time.getTotalHours(""); });
	}
	
	@Test
	public void testGetHoursBoundary() {
		int hours = Time.getTotalHours("23:59:59:06");
		assertTrue("The hours were not calculated propperly", hours == 23);
	}

	@ParameterizedTest
	@ValueSource(strings = { "05:00:00", "05:15:15", "05:59:59" })
	void testGetTotalHours(String candidate) {
		
	int hours = Time.getTotalHours(candidate);
	assertTrue("The hours were not calculated properly",
	hours == 5);
	}
	
	
	// Miliseconds
	public void testGetMilisecondsGood() {
		int miliseconds = Time.getMiliseconds("10:05:05:06");
		assertTrue("The miliseconds were not calculated propperly", miliseconds == 6);
	}
	
	@Test
	public void testGetMilisecondsBad() {
		assertThrows(StringIndexOutOfBoundsException.class,
				()->{Time.getMiliseconds("10:00:00");});
	}
	
	public void testGetMilisecondsBoundary() {
		int miliseconds = Time.getMiliseconds("23:59:59:59");
		assertTrue("The miliseconds were not calculated propperly", miliseconds == 59);
	}

}
