package org.arachne;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TestHttp {

	static List<Map<String, String>> mArrayList = new ArrayList<>();

	public static void main(String[] args) {
		try {
			URL url = new URL("http://39.121.112.198:8080/hh/mapconnect.jsp");
			HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection(); // uRL로
																							// 접속

			httpURLConnection.setReadTimeout(5000); // 읽는 시간 설정
			httpURLConnection.setConnectTimeout(5000); // 요청 시간 설정
			httpURLConnection.connect(); // 연결

			int responseStetusCode = httpURLConnection.getResponseCode(); // 응답

			InputStream inputStream;
			if (responseStetusCode == HttpURLConnection.HTTP_OK) { // 성공
				inputStream = httpURLConnection.getInputStream();
			} else { // 실패
				inputStream = httpURLConnection.getErrorStream();
			}

			InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "EUC-KR"); // 인코딩
																								// 타입
																								// 설정

			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

			StringBuilder sb = new StringBuilder();
			String line;

			while ((line = bufferedReader.readLine()) != null) {
				sb.append(line + "\n");
			}

			bufferedReader.close();
			httpURLConnection.disconnect();

			
			String mJsonString = sb.toString();
			System.out.println("json 파싱하기 이전: " + mJsonString);

			try {
				JSONObject jsonObject = new JSONObject(mJsonString);
				JSONArray jsonArray = jsonObject.getJSONArray("mapTest");

				for (int i = 0; i < jsonArray.length(); i++) {
					JSONObject object = jsonArray.getJSONObject(i);

					HashMap<String, String> hashMap = new HashMap<>();

					hashMap.put("area", object.getString("area"));
					hashMap.put("lat", object.getString("lat"));
					hashMap.put("lng", object.getString("lng"));

					mArrayList.add(hashMap);
				}

				System.out.println(mArrayList.toString());
				
			} catch (JSONException e) {
				// Log.d(TAG, "showResult : ", e);
			}

		} catch (Exception e) {

		}

	}

}
