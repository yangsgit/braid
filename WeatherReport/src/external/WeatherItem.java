package external;

public class WeatherItem {
	public String stationID;
	public String cloudBroken;
	public String cloudOvercast;
	public String windSpeed;
	public String windDirection;
	public String visibility;
	public String temperature;
	
	public WeatherItem(String stationID, String cloudBroken, String cloudOvercast, String windSpeed, String windDirection, String visibility, String temperature) {
		this.stationID = stationID;
		this.cloudBroken = cloudBroken;
		this.cloudOvercast = cloudOvercast;
		this.windSpeed = windSpeed;
		this.windDirection = windDirection;
		this.visibility = visibility;
		this.temperature = temperature;
	}
}

