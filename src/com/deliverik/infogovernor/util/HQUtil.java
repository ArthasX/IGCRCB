package com.deliverik.infogovernor.util;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import main.java.com.dlk.hq.Plateform;
import main.java.com.dlk.hq.Server;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hyperic.hq.hqapi1.HQApi;
import org.hyperic.hq.hqapi1.MetricApi;
import org.hyperic.hq.hqapi1.types.Metric;
import org.hyperic.hq.hqapi1.types.MetricsResponse;
import org.hyperic.hq.hqapi1.types.Resource;
import org.hyperic.hq.hqapi1.types.ResourceResponse;

import com.deliverik.framework.utility.CodeListUtils;
import com.deliverik.infogovernor.scheduling.bl.IGSCH02BLImpl;
import com.deliverik.infogovernor.soc.alarm.model.entity.HQServerTB;

public class HQUtil {
	
	static String hqServerIP;
	static Integer hqServerPort;
	static String hqServerUsername;
	static String hqServerPassword;
	
	private static Log log = LogFactory.getLog(HQUtil.class);

	public static HQApi getHQApi(CodeListUtils codeListUtils)throws Exception{
		HQApi api = null;
		try{
			hqServerIP = codeListUtils.getCodeValue("160", null, null, "1");
			hqServerPort = new Integer(codeListUtils.getCodeValue("160", null, null, "2"));
			hqServerUsername = codeListUtils.getCodeValue("160", null, null, "3");
			hqServerPassword = StringEncrypt.asciiToChar(codeListUtils.getCodeValue("160", null, null, "4"));
			api = new HQApi(hqServerIP, hqServerPort, false, hqServerUsername, hqServerPassword);
		}catch(Exception e){
			log.error("连接HQ Server失败， ip="+hqServerIP+", user="+hqServerUsername);
		}
		return api;
	}

	public static String creatCronExp(String periodType, 
			String exeHour, String exeMinute, String qjcrttime){
		String retCronExp = null;
		//秒 分 时 日 月 周
		//week
		if ("3".equals(periodType)) {
			IGSCH02BLImpl sch02BL = new IGSCH02BLImpl();
			String week = sch02BL.getWeekOfDate(qjcrttime, "eng");
			retCronExp = "0 " + exeMinute + " " + exeHour + " ? * " + week;
		}
		//month
		else if ("4".equals(periodType)){
			String day = qjcrttime.split("/")[2];
			retCronExp = "0 " + exeMinute + " " + exeHour + " " + day + " * ?";
		}
		//once
		else if ("1".equals(periodType)){
			String day = qjcrttime.split("/")[2];
			String month = qjcrttime.split("/")[1];
			String year = qjcrttime.split("/")[0];
			retCronExp = "0 " + exeMinute + " " + exeHour + " " + day + " " + month + " ? " + year;
		}
		// day
		else if ("2".equals(periodType)){
			retCronExp = "0 " + exeMinute + " " + exeHour + " * * ?";
		}
		return retCronExp;
	}
	
	/**
	 * get HQ Server
	 * @param plateform
	 * @return
	 */
	public static List<Server> getHQServer(Plateform plateform){
		List<Server>  serverList = plateform.getServerList().get(0).getServer();
		if(serverList == null || serverList.size() == 0){
			return null;
		}
		return serverList;
	}
	
	/**
	 * split HQ Server
	 * @param fileValue
	 * @param fileName
	 * @return
	 */
	public static HQServerTB splitHQServer(String key, String value, String fileName, HQServerTB hs){

		if(key==null || value==null ){
			hs.setStatus("server "+hs.getServerName()+"property key " +key+" value"+value );
			return hs;
		}

		if("resource".equals(key)){
			
			if(!value.contains("resourcePrototypeName=")){
				hs.setStatus(hs.getServerType()+" The contents of the "+fileName+" is missing 'resourcePrototypeName=' ");
				return hs;
			}
//			if(!value.contains("resourceTypeId=")){
//				hs.setStatus(hs.getServerType()+" The contents of the "+fileName+" is missing 'resourceTypeId=' ");
//				return hs;
//			}
			if(!value.contains("ip=")){
				hs.setStatus(hs.getServerType()+" The contents of the "+fileName+" is missing 'ip=' ");
				return hs;
			}
//			if(!value.contains("ip2=")){
//				hs.setStatus(hs.getServerType()+" The contents of the "+fileName+" is missing 'ip2=' ");
//				return hs;
//			}
//			if(!value.contains("resourceId=")){
//				hs.setStatus(hs.getServerType()+" The contents of the "+fileName+" is missing 'resourceId=' ");
//				return hs;
//			}
			if(!value.contains("interval=")){
				hs.setStatus(hs.getServerType()+" The contents of the "+fileName+" is missing 'interval=' ");
				return hs;
			}
			
			String[] resourceValue = null;
			String[] resourceValueArr = value.split(",");
			
			for(int i=0; i<resourceValueArr.length; i++){

				if(resourceValueArr[i].contains("resourcePrototypeName=")){
					resourceValue = resourceValueArr[i].split("=");
					hs.setResourcePrototypeName(resourceValue[1]);
					continue;
				}
//				else if(resourceValueArr[i].contains("resourceTypeId=")){
//					resourceValue = resourceValueArr[i].split("=");
//					hs.setResourceTypeId(resourceValue[1]);
//					continue;
//				}
				else if(resourceValueArr[i].contains("ip=")){
					resourceValue = resourceValueArr[i].split("=");
					hs.setServerIp(resourceValue[1]);
					continue;
				}
				else if(resourceValueArr[i].contains("ip2=")){
					resourceValue = resourceValueArr[i].split("=");
					hs.setServerIp2(resourceValue[1]);
					continue;
				}
//				else if(resourceValueArr[i].contains("resourceId=")){
//					resourceValue = resourceValueArr[i].split("=");
//					hs.setResourceId(resourceValue[1]);
//					continue;
//				}
				else if(resourceValueArr[i].contains("interval=")){
					resourceValue = resourceValueArr[i].split("=");
					hs.setInterval(resourceValue[1]);
					continue;
				}
				hs.setResourceTypeId("2");
			}
			
		}else if("plugin".equals(key)){
			
			String[] resourceValue = null;
			String[] resourceValueArr = value.split(",");
			
			if("Ping".equals(hs.getServerType())){
				
				if(!value.contains("Host.name=")){
					hs.setStatus("The contents of the "+fileName+" is missing 'Host.name=' ");
					return hs;
				}
//				if(!value.contains("Host.IP=")){
//					hs.setStatus("The contents of the "+fileName+" is missing 'Host.IP=' ");
//					return hs;
//				}
				if(!value.contains("SystemType=")){
					hs.setStatus("The contents of the "+fileName+" is missing 'SystemType=' ");
					return hs;
				}
				for(int i=0; i<resourceValueArr.length; i++){
					
					if(resourceValueArr[i].contains("Host.name=")){
						resourceValue = resourceValueArr[i].split("=");
						hs.setHostName(resourceValue[1]);
						continue;
					}
//					else if(resourceValueArr[i].contains("Host.IP=")){
//						resourceValue = resourceValueArr[i].split("=");
//						hs.setHostIP(resourceValue[1]);
//						continue;
//					}
					else if(resourceValueArr[i].contains("SystemType=")){
						resourceValue = resourceValueArr[i].split("=");
						hs.setSystemType(resourceValue[1]);
						continue;
					}
				}
				hs.setHostIP(hs.getServerIp());
				hs.setStatus("SUCCESS");
			}else if("Aix".equals(hs.getServerType())){

				if(!value.contains("Host.name=")){
					hs.setStatus("The contents of the "+fileName+" is missing 'Host.name=' ");
					return hs;
				}
//				if(!value.contains("Host.IP=")){
//					hs.setStatus("The contents of the "+fileName+" is missing 'Host.IP=' ");
//					return hs;
//				}
				if(!value.contains("Host.port=")){
					hs.setStatus("The contents of the "+fileName+" is missing 'Host.port=' ");
					return hs;
				}
				if(!value.contains("Host.user=")){
					hs.setStatus("The contents of the "+fileName+" is missing 'Host.user=' ");
					return hs;
				}
				if(!value.contains("Host.password=")){
					hs.setStatus("The contents of the "+fileName+" is missing 'Host.password=' ");
					return hs;
				}
				if(!value.contains("ConnectType=")){
					hs.setStatus("The contents of the "+fileName+" is missing 'ConnectType=' ");
					return hs;
				}

				for(int i=0; i<resourceValueArr.length; i++){

					if(resourceValueArr[i].contains("Host.name=")){
						resourceValue = resourceValueArr[i].split("=");
						hs.setHostName(resourceValue[1]);
						continue;
					}
//					else if(resourceValueArr[i].contains("Host.IP=")){
//						resourceValue = resourceValueArr[i].split("=");
//						hs.setHostIP(resourceValue[1]);
//						continue;
//					}
					else if(resourceValueArr[i].contains("Host.port=")){
						resourceValue = resourceValueArr[i].split("=");
						hs.setHostPort(resourceValue[1]);
						continue;
					}else if(resourceValueArr[i].contains("Host.user=")){
						resourceValue = resourceValueArr[i].split("=");
						hs.setHostUser(resourceValue[1]);
						continue;
					}else if(resourceValueArr[i].contains("Host.password=")){
						resourceValue = resourceValueArr[i].split("=");
						hs.setHostPassword(resourceValue[1]);
						continue;
					}else if(resourceValueArr[i].contains("ConnectType=")){
						resourceValue = resourceValueArr[i].split("=");
						hs.setConnectType(resourceValue[1]);
						continue;
					}else if(resourceValueArr[i].contains("Host.scriptname=")){
						resourceValue = resourceValueArr[i].split("=");
						hs.setScriptname(resourceValue[1]);
						continue;
					}
				}
				hs.setHostIP(hs.getServerIp());
				hs.setStatus("SUCCESS");

			}else if("Oracle".equals(hs.getServerType())){

//				if(!value.contains("Oracle.host=")){
//					hs.setStatus("The contents of the "+fileName+" is missing 'Oracle.host=' ");
//					return hs;
//				}
				if(!value.contains("Oracle.dbuser=")){
					hs.setStatus("The contents of the "+fileName+" is missing 'Oracle.dbuser=' ");
					return hs;
				}
//				if(!value.contains("Oracle.scriptname=")){
//					hs.setStatus("The contents of the "+fileName+" is missing 'Oracle.scriptname=' ");
//					return hs;
//				}
				if(!value.contains("Oracle.dburl=")){
					hs.setStatus("The contents of the "+fileName+" is missing 'Oracle.dburl=' ");
					return hs;
				}
				if(!value.contains("Oracle.dbpassword=")){
					hs.setStatus("The contents of the "+fileName+" is missing 'Oracle.dbpassword=' ");
					return hs;
				}

				for(int i=0; i<resourceValueArr.length; i++){
//					if(resourceValueArr[i].contains("Oracle.host=")){
//						resourceValue = resourceValueArr[i].split("=");
//						hs.setHostName(resourceValue[1]);
//						continue;
//					}else 

					if(resourceValueArr[i].contains("Oracle.dbuser=")){
						resourceValue = resourceValueArr[i].split("=");
						hs.setDbuser(resourceValue[1]);
						continue;
					}else if(resourceValueArr[i].contains("Oracle.scriptname=")){
						resourceValue = resourceValueArr[i].split("=");
						hs.setScriptname(resourceValue[1]);
						continue;
					}else if(resourceValueArr[i].contains("Oracle.dburl=")){
						resourceValue = resourceValueArr[i].split("=");
						hs.setDburl(resourceValue[1]);
						continue;
					}else if(resourceValueArr[i].contains("Oracle.dbpassword=")){
						resourceValue = resourceValueArr[i].split("=");
						hs.setDbpwd(resourceValue[1]);
						continue;
					}
				}
				hs.setStatus("SUCCESS");
			}
		}
		
		return hs;
	}
	
	/**
	 * get time
	 * 
	 * @param symbols
	 *            yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public static String getTime(String symbols, long timestamp) {
		SimpleDateFormat format = null;
		if(symbols == null || "".equals(symbols)){
			format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		}else{
			format = new SimpleDateFormat(symbols);
		}
		
		if (timestamp != 0) {
			return format.format(new Date(timestamp));
		}
		
		return format.format(System.currentTimeMillis());
	}

	public static boolean isNumber(String numberStr) {
		if (numberStr == null || !numberStr.matches("^(-?\\d+)(\\.\\d+)?")) {
			return false;
		}
		return true;
	}

	/**
	 * close Metric
	 * @param server
	 * @param hqapi
	 */
	public static void closeMetric(Resource server, HQApi hqapi) {
		
		List<Metric> metricList = null;
		MetricApi metricApi = hqapi.getMetricApi();
		try {
			MetricsResponse response = metricApi.getMetrics(server, true);
			List<Metric> metrics = response.getMetric();
			if (metrics == null || metrics.size() == 0) {
				return;
			}
			metricList = new ArrayList<Metric>();
			for (Metric metric : metrics) {
				metric.setEnabled(false);
				metricList.add(metric);
			}
			metricApi.syncMetrics(metricList);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * open Metric
	 * @param server
	 * @param hqapi
	 */
	public static void openMetric(Resource server, HQApi hqapi) {

		List<Metric> metricList = null;
		MetricApi metricApi = hqapi.getMetricApi();
		try {
			MetricsResponse response = metricApi.getMetrics(server, false);
			List<Metric> metrics = response.getMetric();
			if (metrics == null || metrics.size() == 0) {
				return;
			}
			metricList = new ArrayList<Metric>();
			for (Metric metric : metrics) {
				metric.setEnabled(true);
				metric.setInterval(86400000);
				metricList.add(metric);
			}
			metricApi.syncMetrics(metricList);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static HQServerTB getMetricStatusByName(Resource server, HQApi hqapi, String metricName){
		
		boolean isEnable = false;
		HQServerTB servertb = null;
		MetricApi metricApi = hqapi.getMetricApi();
		try {

			MetricsResponse response = metricApi.getMetrics(server, true);
			MetricsResponse response2 = metricApi.getMetrics(server, false);
			List<Metric> metrics = response.getMetric();
			List<Metric> metrics2 = response2.getMetric();

			if(metricName == null || "".equals(metricName)){
				metricName = "Availability";
			}

			if (metrics != null && metrics.size() != 0) {

				for (Metric metric : metrics) {
					if(metricName.equals(metric.getName())){
						isEnable = metric.isEnabled();
						servertb = new HQServerTB();
						servertb.setEnable(isEnable);
						break;
					}
				}
			}else if(metrics2 != null && metrics2.size() != 0){

				for (Metric metric : metrics2) {
					if(metricName.equals(metric.getName())){
						isEnable = metric.isEnabled();
						servertb = new HQServerTB();
						servertb.setEnable(isEnable);
						break;
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return servertb;
	}

	/**
	 * get HQ Server List By Plateform
	 * 
	 * @param resourceResponse
	 * @return
	 */
	public static List<Resource> getHQServerListByPlateform(
			ResourceResponse resourceResponse) {
		List<Resource> serverList = null;
		serverList = resourceResponse.getResource().getResource();
		if (serverList == null || serverList.size() == 0) {
			return serverList;
		}
		return serverList;
	}

	/**
	 * get HQ Plateforms
	 * 
	 * @param plateformNameList
	 * @return
	 * @throws Exception
	 */
	public static List<ResourceResponse> getHQPlateforms(
			List<String> plateformNameList, HQApi hqapi) throws Exception {
		List<ResourceResponse> plateformList = null;
		if (plateformNameList == null || plateformNameList.size() == 0) {
			return plateformList;
		}

		plateformList = new ArrayList<ResourceResponse>();
		for (String name : plateformNameList) {
			ResourceResponse resourceResponse = hqapi.getResourceApi()
					.getPlatformResource(name, true, true);
			if ("SUCCESS".equals(resourceResponse.getStatus().toString())) {

				plateformList.add(resourceResponse);
			}
		}
		return plateformList;
	}
	
	/**
	 * get HQ Plateforms
	 * 
	 * @param plateformNameList
	 * @return
	 * @throws Exception
	 */
	public static Map<String, ResourceResponse> getHQPlateformsMap(
			List<String> plateformNameList, HQApi hqapi) throws Exception {
		Map<String, ResourceResponse> plateformMap = null;
		if (plateformNameList == null || plateformNameList.size() == 0) {
			return plateformMap;
		}

		plateformMap = new HashMap<String, ResourceResponse>();
		for (String name : plateformNameList) {
			ResourceResponse resourceResponse = hqapi.getResourceApi()
					.getPlatformResource(name, true, true);
			if ("SUCCESS".equals(resourceResponse.getStatus().toString())) {

				plateformMap.put(name, resourceResponse);
			}
		}
		return plateformMap;
	}
}
