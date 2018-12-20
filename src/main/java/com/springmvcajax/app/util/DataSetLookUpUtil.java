package com.springmvcajax.app.util;

import org.apache.commons.collections.MultiMap;
import org.apache.commons.collections.map.MultiValueMap;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author Naveen
 *
 */
public class DataSetLookUpUtil {
	
	/**
	 * 
	 * @return allUsersList
	 */

	public static List<String> allUsersList() {
		List<String> allUsersList = new ArrayList<>();
		allUsersList.add("UserOne");
		allUsersList.add("UserTwo");
		allUsersList.add("UserThree");
		allUsersList.add("UserFour");
		return allUsersList;
	}

	/**
	 * Method Used for Initializing static Provinces
	 * 
	 * @return provincesList
	 */
	public static List<String> lookUpProvinces() {
		List<String> provincesList = new ArrayList<>();
		provincesList.add("Alberta");
		provincesList.add("British Columbia");
		return provincesList;
	}

	/**
	 * Method Used for Initializing Capital
	 * 
	 * @return apache MultiMap
	 */
	public static MultiMap lookUpCapitalRegion() {

		MultiMap capitalRegionMap = new MultiValueMap();
		capitalRegionMap.put("Alberta", "Calgary");
		capitalRegionMap.put("Alberta", "Edmonton");
		capitalRegionMap.put("British Columbia", "Vancouver");
		capitalRegionMap.put("British Columbia", "Victoria");
		return capitalRegionMap;
	}

	/**
	 * Method Used for lookup Capital
	 * 
	 * @return List "capitalRegionList"
	 */
	public static List<String> lookUpCapitalRegion(String capitalRegion) {
		MultiMap capitalRegionMap = lookUpCapitalRegion();
		List<String> capitalRegionList = new ArrayList<>();
		if (capitalRegionMap.containsKey(capitalRegion)) {
			String regionString = String.valueOf(capitalRegionMap.get(capitalRegion)).substring(1);
			capitalRegionList = Arrays.asList(regionString.split("\\,"));
		}
		return capitalRegionList;
	}

	/**
	 * Method Used for Initializing Province
	 * 
	 * @return apache MultiMap
	 */
	public static MultiMap lookUpMajorPlaces() {
		MultiMap cityRegionMap = new MultiValueMap();
		cityRegionMap.put("Calgary", "Chestermere");
		cityRegionMap.put("Calgary", "Longview");
		cityRegionMap.put("Calgary", "Rocky View County");
		cityRegionMap.put("Calgary", "Turner Valley");
		cityRegionMap.put("Edmonton", "St.Albert");
		cityRegionMap.put("Edmonton", "Mill Woods");
		cityRegionMap.put("Edmonton", "Westmount");
		cityRegionMap.put("Edmonton", "Strathcona");
		cityRegionMap.put("Vancouver", "Coal Harbour");
		cityRegionMap.put("Vancouver", "Yaletown ");
		cityRegionMap.put("Vancouver", "Downtown Vancouver");
		cityRegionMap.put("Vancouver", "Chinatown");
		cityRegionMap.put("Victoria", "James Bay");
		cityRegionMap.put("Victoria", "Gonzales");
		cityRegionMap.put("Victoria", "Rockland");
		cityRegionMap.put("Victoria", "Cordova Bay");
		return cityRegionMap;
	}

	/**
	 * Method Used for lookup CapitalRegion
	 * 
	 * @return List "capitalRegionList"
	 */
	public static List lookUpMajorPlaces(String majorPlaces) {
		MultiMap cityRegionMap = lookUpMajorPlaces();
		List<String> languageRegionList = new ArrayList();
		if (cityRegionMap.containsKey(majorPlaces)) {
			String languageString = String.valueOf(cityRegionMap.get(majorPlaces));
			languageRegionList = Arrays.asList(languageString.split("\\,"));
		}
		return languageRegionList;
	}
	/**Method Used to create JsonObject
	 * @return JSONObject
	 */
	public static String generateJsonObject(String capitalRegion){
		JSONObject obj = new JSONObject();
		switch (capitalRegion)
		{
			case "Calgary":
				obj.put("population", "1.266 million (2014)");
				obj.put("totalArea", "825.3 km");
				break;
			case "Edmonton":
				obj.put("population", "928,182 (2014)");
				obj.put("totalArea", "684 km");
				break;
			case "Vancouver":
				obj.put("population", "647,540 (2014)");
				obj.put("totalArea", "115 km");
				break;
			case "Victoria":
				obj.put("population", "84,289(2014)");
				obj.put("totalArea", "19.47 km");
				break;
		}
		JSONArray jSONArray = new JSONArray();
		jSONArray.add(lookUpMajorPlaces(capitalRegion));
		obj.put("MajorCities", jSONArray);
		return obj.toJSONString();
	}

}
