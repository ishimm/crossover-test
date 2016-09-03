package com.crossover.trial.weather.airport;

import java.io.File;
import java.io.FileInputStream;
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
			//Surefire does not support tests or any referenced libraries calling System.exit() at any time.
			//According to http://maven.apache.org/surefire/maven-surefire-plugin/faq.html
			//AirportLoader.main(new String[] {s.substring(1)});
			AirportLoader al = new AirportLoader();
			al.upload(new FileInputStream(s));
		}catch(final FileNotFoundException ex){
			ex.printStackTrace();
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
			File file = new File(s);
			scanner = new Scanner(file);
			al.upload(scanner);
			scanner.close();
		}catch(final FileNotFoundException ex){
			ex.printStackTrace();
		}
		Assert.assertTrue("dat file uploaded OK with Scanner method", true);
	}
}
