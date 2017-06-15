package com.deliverik.infogovernor.util;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.hyperic.hq.hqapi1.HQApi;
import org.hyperic.hq.hqapi1.types.Resource;
import org.hyperic.hq.hqapi1.types.ResourceResponse;
import org.junit.Test;
import org.junit.Before;

public class HQUtilTest {

	private HQApi hqapi = null;

	@Before
	public void init(){
		try{
			String hqServerIP = "127.0.0.1";
			int hqServerPort = 7080;
			String hqServerUsername = "hqadmin";
			String hqServerPassword = "hqadmin";
			hqapi = new HQApi(hqServerIP, hqServerPort, false, hqServerUsername, hqServerPassword);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Test
	public void testGetHQServerListByPlateform(){
		List<String> plateformNameList = new ArrayList<String>();
		plateformNameList.add("administrator");
		try {
			List<ResourceResponse> plateforms = HQUtil.getHQPlateforms(plateformNameList, hqapi);
			//Assert.assertEquals(1, plateforms.size());
			for(ResourceResponse plateform : plateforms){
				List<Resource> serverList = HQUtil.getHQServerListByPlateform(plateform);
				for(Resource server : serverList){
					System.out.println(server.getName());
				}
			}
		} catch (Exception e) { 
			e.printStackTrace();
		}
	}

	@Test
	public void testGetHQPlateforms() {
		List<String> plateformNameList = new ArrayList<String>();
		plateformNameList.add("administrator");
		try {
			List<ResourceResponse> plateforms = HQUtil.getHQPlateforms(plateformNameList, hqapi);
			Assert.assertEquals(1, plateforms.size());
		} catch (Exception e) { 
			e.printStackTrace();
		}
	}
}
