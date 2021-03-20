package com.ramkarlapudi.userapilive.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.ramkarlapudi.userapilive.model.AwayTeam;
import com.ramkarlapudi.userapilive.model.HomeTeam;
import com.ramkarlapudi.userapilive.model.Map2;
import com.ramkarlapudi.userapilive.model.MyArrayList;
import com.ramkarlapudi.userapilive.model.MyArrayListPlayersData;
import com.ramkarlapudi.userapilive.model.Root;
import com.ramkarlapudi.userapilive.model.Series;
import com.ramkarlapudi.userapilive.model.Venue;
import com.ramkarlapudi.userapilive.util.LiveScoreConstants;

@Component
public class LiveScoreServiceImpl implements LiveScoreService, LiveScoreConstants {

	private static final Logger LOGGER = LogManager.getLogger(LiveScoreServiceImpl.class);

	private String currentJson = null;
	private String currentJsonBody = null;
	private String jsonMeta = null;

	private List<MyArrayList> liveMatches = null;

	private Series series = null;
	private Venue venue = null;
	private HomeTeam homeTeam = null;
	private AwayTeam awayTeam = null;
	@SuppressWarnings("unchecked")
	private HttpResponse<JsonNode> response = null;
	private String searchapiurl = null;
	private int p =0;

	public String setup(String processName) throws IOException, UnirestException {
		LOGGER.info("  ********** Entering  setup ********* ");

		try {

			ObjectMapper mapper = new ObjectMapper();
			mapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);

			switch (processName) {
			case Live_Matches:
				LOGGER.info("  ********** Entering  liveMatches case********* ");
				response = Unirest.get(SERIES_MATCHES_API).header("x-rapidapi-key", apiKey)
						.header("x-rapidapi-host", apiHost).asJson();

				currentJsonBody = mapper
						.writeValueAsString(response.getBody().getObject().getJSONObject("matchList").get("matches"));
				jsonMeta = mapper.writeValueAsString(response.getBody().getObject().getJSONObject("meta"));
				LOGGER.info("  ********** currentJsonBody  " + currentJsonBody);
				break;
			case "playerSearch":
				LOGGER.info("  ********** Entering  playerSearch case********* ");
				response = Unirest
						.get("https://dev132-cricket-live-scores-v1.p.rapidapi.com/playersbyteam.php?teamid=3")
						.header("x-rapidapi-key", "e0c34d9a36msh7bb0545fbfa765cp1f416cjsn72c335f15dc6")
						.header("x-rapidapi-host", "dev132-cricket-live-scores-v1.p.rapidapi.com").asJson();
				currentJsonBody = mapper
						.writeValueAsString(response.getBody().getObject().getJSONObject("teamPlayers"));
				break;
			case SEARCH_BY_NAME:
				LOGGER.info("  ********** Entering  searchbyname case********* ");
				response = Unirest.get(searchapiurl).header("x-rapidapi-key", apiKey).header("x-rapidapi-host", apiHost)
						.asJson();
				currentJsonBody = mapper
						.writeValueAsString(response.getBody().getObject().getJSONObject("teamPlayers"));

				break;

			default:
				break;
			}

			// convert java object to JSON String
			currentJson = mapper.writeValueAsString(response);

			String str = mapper.writeValueAsString(response.getBody().getObject());

			JSONObject obj = new JSONObject(currentJson.toString());

			// return json;
			LOGGER.info("  ********** Exiting   setup");
		} catch (Exception e) {
			LOGGER.error("Error while fetching Data from Live Cricket Data API " + e);
		}

		return currentJsonBody;

	}

	@Override
	public String getCurrentMatches() {
		String currentJson1 = null;

		try {
			currentJson1 = setup("liveMatches");
			Json2java();
		} catch (IOException | UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return currentJson1;

	}

	private void Json2java() throws IOException, UnirestException {
		String j2j = jsonMeta;
		Gson gson = new Gson();
		// java.lang.reflect.Type tttt = new TypeToken<map>() {}.getType();
		// System.out.println(jsonMeta);
		// map currentMatches = gson.fromJson(j2j, map.class);
		Root currentMatches = gson.fromJson(j2j, Root.class);
		System.out.println(currentMatches.getMap().getCompletedMatchCount());
	}

	public List<MyArrayList> getcurrentLiveSeries() {
		LOGGER.info("*******Entering getcurrentLiveSeries **");
		try {
			setup("liveMatches");
			String j2j = currentJsonBody;
			Gson gson = new Gson();
			Root currentSeries = gson.fromJson(j2j, Root.class);
			List<MyArrayList> matchesList = currentSeries.getMyArrayList();
			liveMatches = new ArrayList<MyArrayList>();

			liveMatches = matchesList.stream().filter(m -> m.getMap().getStatus().equals("LIVE"))
					.collect(Collectors.toList());
			LOGGER.info("*******liveMatches List   " + liveMatches.size());
		} catch (IOException | UnirestException e) {
			e.printStackTrace();
			LOGGER.error("Error while fetching Current Live Matches Data " + e);
		}

		return liveMatches;
	}

	public List<MyArrayListPlayersData> getPlayers() {
		LOGGER.info("*******Entering getPlayers from Service **");
		String Players = null;
		List<MyArrayListPlayersData> playersList = null;
		try {
			Players = setup("playerSearch");
			Gson gson = new Gson();
			Root Playersdata = gson.fromJson(currentJsonBody, Root.class);
			playersList = Playersdata.getMap().getPlayers().getMyArrayList();
			LOGGER.info("list size " + playersList.size());
			for (MyArrayListPlayersData myArrayList : playersList) {
				Map2 players = myArrayList.getMap();
				// System.out.println("Players data" + players.toString());
			}
		} catch (IOException | UnirestException e) {
			e.printStackTrace();
			LOGGER.error("Error while fetching Players Data " + e);

		}
		LOGGER.info("*******Exiting  getPlayers from Service Returing List **" + playersList.size());
		return playersList;

	}

	public List<MyArrayListPlayersData> getPlayerByName(String playerName) {
		LOGGER.info("*******Entering getPlayerByName from Service **");
		String jsonData = null;
		List<MyArrayListPlayersData> playersList = null;
		List<MyArrayListPlayersData> SearchList = new ArrayList<MyArrayListPlayersData>();
		try {
			for (int i = 1; i <= 7; i++) {
				searchapiurl = teamPlayersapi + i;
				LOGGER.info("*******searchapiurl **" + searchapiurl);
				jsonData = setup(SEARCH_BY_NAME);
				Gson gson = new Gson();
				Root Playersdata = gson.fromJson(currentJsonBody, Root.class);
				playersList = Playersdata.getMap().getPlayers().getMyArrayList();
				LOGGER.info("list size " + "Team id " + i + " " + playersList.size());
				List<MyArrayListPlayersData> searchdata = playersList.stream()
						.filter(p -> p.getMap().getFirstName().equalsIgnoreCase(playerName)
								|| p.getMap().getLastName().equalsIgnoreCase(playerName)
								|| p.getMap().getFirstName().equalsIgnoreCase(playerName))
						.collect(Collectors.toList());
				SearchList.addAll(searchdata);
				if (SearchList.size() > 0) {
					break;
				}
			}
			if (SearchList.size() == 0) {
				LOGGER.info("*******NO Players Found  with Given SearchName **");
			}
		} catch (Exception e) {
			LOGGER.error("Error while fetching Players Search Data " + e);
		}

		return SearchList;

	}

}
