package com.conversionApp.Utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONObject;

import io.github.cdimascio.dotenv.Dotenv;

public class CurrencyRatesAPI {
	private double conversionRate;
	private String dateFromAPI;
	private String API_KEY; 
	

	public CurrencyRatesAPI(String from, String to) {
		try {
			Dotenv dotenv = Dotenv.load();
			API_KEY = dotenv.get("API_KEY");

			String apiUrl = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/pair/" + from + "/" + to;

			// Create a URI object
			URI uri = new URI(apiUrl);

			// Open a connection to the API endpoint
			HttpURLConnection connection = (HttpURLConnection) uri.toURL().openConnection();
			connection.setRequestMethod("GET");

			// Get the response code
			int responseCode = connection.getResponseCode();

			// Read the response
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			StringBuilder response = new StringBuilder();
			String line;
			while ((line = reader.readLine()) != null) {
				response.append(line);
			}
			reader.close();

			// Parse the JSON response
			JSONObject json = new JSONObject(response.toString());
			setConversionRate(json.getDouble("conversion_rate"));
			setDateFromAPI(json.getString("time_last_update_utc"));

		} catch (IOException | URISyntaxException e) {
			e.printStackTrace();
		}

	}

	private String trimDate(String utcTimestamp) {
		SimpleDateFormat inputFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss Z");
		SimpleDateFormat outputFormat = new SimpleDateFormat("EEE, dd MMM yyyy");

		try {
			Date date = inputFormat.parse(utcTimestamp);
			return outputFormat.format(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return ""; // Return empty string if parsing fails
	}

	public double getConversionRate() {
		return conversionRate;
	}

	public void setConversionRate(double conversionRate) {
		this.conversionRate = conversionRate;
	}

	public String getDateFromAPI() {
		return trimDate(dateFromAPI);
	}

	public void setDateFromAPI(String dateFromAPI) {
		this.dateFromAPI = dateFromAPI;
	}

}