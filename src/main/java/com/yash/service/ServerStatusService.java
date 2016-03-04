package com.yash.service;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.yash.bean.ServerBean;

@Service
public class ServerStatusService {
	
	public void updateServerStatus(List<ServerBean> serverBeansList){
		if(!CollectionUtils.isEmpty(serverBeansList)) {
			for (ServerBean serverBean : serverBeansList) {
				serverBean.setStatus(getStatus(serverBean));
			}
		}
	}
	
	
	private static String getStatus(ServerBean serverBean) {

		String result = "";
		HttpURLConnection connection = null;
		try {
			URL siteURL = new URL(serverBean.getUrl());
			connection = (HttpURLConnection) siteURL.openConnection();
			connection.setRequestMethod(serverBean.getMethod());
			connection.connect();

			int code = connection.getResponseCode();
			if (code == 200) {
				result = "Green (200)";
			} else {
				result = "Not Ok : "+code;
			}
		} catch (Exception e) {
			result = "->Red<-" + e.getMessage();
		} finally {
			if(connection != null) {
				connection.disconnect();
			}
		}
		return result;
	}

}
