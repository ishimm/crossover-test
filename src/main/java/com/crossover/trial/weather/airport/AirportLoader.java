package com.crossover.trial.weather.airport;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

/**
 * A simple airport loader which reads a file from disk and sends entries to the webservice
 *
 * TODO: Implement the Airport Loader
 * 
 * @author code test administrator
 */
public class AirportLoader {

	/** end point for read queries */
	private WebTarget query;

	/** end point to supply updates */
	private WebTarget collect;

	private List<AirportData> airportData = new ArrayList<>();

	public AirportLoader() {
		Client client = ClientBuilder.newClient();
		query = client.target("http://localhost:8080/query");
		collect = client.target("http://localhost:8080/collect");
	}

	public void upload(InputStream airportDataStream) throws IOException{
		//[1, "General Edward Lawrence Logan Intl", "Boston", "United States", "BOS", "KBOS", 42.364347, -71.005181, 19, -5, "A"]
		BufferedReader reader = new BufferedReader(new InputStreamReader(airportDataStream));
		String l = null;
		while ((l = reader.readLine()) != null) {
			addAirportFromDat(l.split(","));
		}
		collect.property("airportData", airportData);
	}

	/**
	 * This method is better for reading bigger files
	 * @param scanner
	 * @throws IOException
	 */
	public void upload(Scanner scanner) throws IOException{
		//[1, "General Edward Lawrence Logan Intl", "Boston", "United States", "BOS", "KBOS", 42.364347, -71.005181, 19, -5, "A"]
		scanner.useDelimiter(",");
		while(scanner.hasNextLine()) {
			final ArrayList<String> data = new ArrayList<String>();
			while(scanner.hasNext()){
				data.add(scanner.next());
			}
			addAirportFromDat(data);
		}
		scanner.close();
		collect.property("airportData", airportData);
	}

	/**
	 * Header   	| Description
			------------|------------
	line[0]		City		| Main city served by airport. May be spelled differently from name.
	line[1]		Country		| Country or territory where airport is located.
	line[2]		IATA/FAA 	| 3-letter FAA code or IATA code (blank or "" if not assigned)
	line[3]		ICAO		| 4-letter ICAO code (blank or "" if not assigned)
	line[4]		Latitude 	| Decimal degrees, up to 6 significant digits. Negative is South, positive is North.
	line[5]		Longitude	| Decimal degrees, up to 6 significant digits. Negative is West, positive is East.
	line[6]		Altitude	| In feet
	line[7]		Timezone	| Hours offset from UTC. Fractional hours are expressed as decimals. (e.g. India is 5.5)
	line[8]		DST			| One of E (Europe), A (US/Canada), S (South America), O (Australia), Z (New Zealand), N (None) or U (Unknown) 

	example dat file:
	[1, "General Edward Lawrence Logan Intl", "Boston", "United States", "BOS", "KBOS", 42.364347, -71.005181, 19, -5, "A"]
	[2,"Newark Liberty Intl","Newark","United States","EWR","KEWR",40.6925,-74.168667,18,-5,"A"]
	[3, "John F Kennedy Intl", "New York", "United States", "JFK", "KJFK", 40.639751, -73.778925, 13, -5, "A"]
	 * @param line
	 */
	private void addAirportFromDat(String[] line) {
		AirportData ap = new AirportData();
		ap.setIata(line[4]);
		ap.setLatitude(Double.valueOf(line[6]));
		ap.setLongitude(Double.valueOf(line[7]));
		airportData.add(ap);
	}

	private void addAirportFromDat(ArrayList<String> line) {
		AirportData ap = new AirportData();
		ap.setIata(line.get(4));
		ap.setLatitude(Double.valueOf(line.get(6)));
		ap.setLongitude(Double.valueOf(line.get(7)));
		airportData.add(ap);
	}

	public static void main(String args[]) throws IOException{
		File airportDataFile = new File(args[0]);
		if (!airportDataFile.exists() || airportDataFile.length() == 0) {
			System.err.println(airportDataFile + " is not a valid input");
			System.exit(1);
		}
		//Way 1
//		AirportLoader al = new AirportLoader();
//		try{
//			al.upload(new FileInputStream(airportDataFile));
//		}catch(final FileNotFoundException ex){
//			ex.printStackTrace();
//		}

		//Way 2 -We'll use this for .dat file with 1000 airports
		AirportLoader al2 = new AirportLoader();
		final Scanner scanner;

		try{
			scanner = new Scanner(airportDataFile);
			al2.upload(scanner);
		}catch(final FileNotFoundException ex){
			ex.printStackTrace();
		}

		System.exit(0);
	}
}
