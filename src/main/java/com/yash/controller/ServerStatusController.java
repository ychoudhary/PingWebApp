package com.yash.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.yash.bean.ServerBean;
import com.yash.service.ServerDataManager;
import com.yash.service.ServerStatusService;

@Controller
public class ServerStatusController {
	
	@Autowired
	ServerDataManager serverDataManager;
	
	@Autowired
	ServerStatusService statusService;

	@RequestMapping("/serverStatus")
	public ModelAndView helloWorld() {
 
		String now = (new java.util.Date()).toString();
		
        Map<String, Object> myModel = new HashMap<String, Object>();
        myModel.put("now", now);
        List<ServerBean> serverList = serverDataManager.getServerList();
        statusService.updateServerStatus(serverList);
		myModel.put("serverList", serverList);

        return new ModelAndView("serverStatus", "model", myModel);
		
	}
}
