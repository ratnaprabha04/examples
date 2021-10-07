package com.training.httpclient;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class NonReactiveClient {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		for(int i=0;i<10;i++) {
			String json = getStockQuoteJson(i);
			System.out.println(json);
		}
		long stop = System.currentTimeMillis();
		System.out.println("Time taken: "+(stop - start)+" ms.");

	}

	public static String getStockQuoteJson(int i) {
		String json="";
		
	
		try {
			
			URL url = new URL("http://localhost:8080/quotes/"+i);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
						con.setRequestMethod("GET");
			con.setRequestProperty("Accept", "application/json");
			int responseCode = con.getResponseCode();
			//System.out.println("GET Response Code :: " + responseCode);
			if (responseCode == HttpURLConnection.HTTP_OK) { // success
				BufferedReader in = new BufferedReader(new InputStreamReader(
						con.getInputStream()));
				String inputLine;
				StringBuffer response = new StringBuffer();

				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);
				}
				json = response.toString();
				in.close();
			}else {
				System.out.println("Some unexpected response");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return json;
	}

}
