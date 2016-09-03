package com.crossover.trial.weather.airport;

import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.Test;

import junit.framework.Assert;

public class AirportLoaderTest {

	/**
	 * Test upload using Buffer
	 * @throws Exception
	 */
	@Test
    public void testUpload() throws Exception {
		String s = AirportLoader.class.getProtectionDomain().getCodeSource().getLocation().getPath()+"airports.dat";
        try {
			AirportLoader.main(new String[] {s.substring(1)});
		} catch (Exception e) {
			e.printStackTrace();
		}
        Assert.assertTrue("dat file uploaded OK with InputStream method", true);
    }
	
	/**
	 * Test upload using scanner
	 * @throws Exception
	 */
	@Test
	public void testUploadScanner() throws Exception{
		AirportLoader al = new AirportLoader();
		String s = AirportLoader.class.getProtectionDomain().getCodeSource().getLocation().getPath()+"airports.dat";
		final Scanner scanner;

		try{
			scanner = new Scanner(s);
			al.upload(scanner);
		}catch(final FileNotFoundException ex){
			ex.printStackTrace();
		}
		Assert.assertTrue("dat file uploaded OK with Scanner method", true);
	}
}
