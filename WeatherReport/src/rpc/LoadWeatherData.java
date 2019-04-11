package rpc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;


import external.WeatherAPI;
import external.WeatherItem;
 
/**
 * Servlet implementation class LoadWeatherData
 */
@WebServlet("/Load")
public class LoadWeatherData extends HttpServlet {
	private static final String secret_key = "20d59fb9ec8ea1457f56c337c7998d62";
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoadWeatherData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JSONArray array = new JSONArray();
		WeatherAPI test = new WeatherAPI();
		WeatherItem[] weatherItems = test.getWeatherItems();
		for (WeatherItem item : weatherItems) {
			JSONObject jsonObj = item.toJSONObject();
			array.put(jsonObj);
		}
		RpcHelper.writeJsonArray(response, array);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {			
			if (request.getParameter("secret_key").equals(secret_key)) {
				JSONArray array = new JSONArray();
				WeatherAPI test = new WeatherAPI();
				WeatherItem[] weatherItems = test.getWeatherItems();
				for (WeatherItem item : weatherItems) {
					JSONObject jsonObj = item.toJSONObject();
					array.put(jsonObj);
				}
				RpcHelper.writeJsonArray(response, array);
			}else {
				JSONObject obj = new JSONObject();
				obj.put("result", "error secret key");
				RpcHelper.writeJsonObject(response, obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
