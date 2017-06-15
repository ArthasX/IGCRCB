/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.alarm.model.entity;

import java.util.HashMap;

import org.hyperic.hq.hqapi1.types.ResourcePrototype;

import com.deliverik.infogovernor.util.HQUtil;

public class HQServerTB {

	private String plantformName;
	private String resourceTypeId;
	private String resourcePrototypeName;
	
	private String serverIp;
	private String serverIp2;
	private String serverType;
	private String serverName;
	private String hostName;
	private String interval;
	private String resourceId;
	private String pluginName;

	//oracle
	private String dburl;
	private String dbuser;
	private String dbpwd;
	private String status;
	private String scriptname;
	
	//host
	private String hostIP;
	private String hostPort;
	private String hostUser;
	private String ConnectType;
	private String hostPassword;
	private String systemType;
	
	
	private String createMessage;
	private int fileId;
	
	private String serverid;
	
	private Integer hqserverid;
	private String hqservername;

	private HashMap<String,String> config; 
	private ResourcePrototype resourcePrototype;
	
	private boolean isEnable;
	private String desc;

	public String getPlantformName() {
		return plantformName;
	}
	public void setPlantformName(String plantformName) {
		this.plantformName = plantformName;
	}
	public String getServerType() {
		return serverType;
	}
	public void setServerType(String serverType) {
		this.serverType = serverType;
	}
	public String getServerName() {
		return serverName;
	}
	public void setServerName(String serverName) {
		this.serverName = serverName;
	}
	public String getHostName() {
		return hostName;
	}
	public void setHostName(String hostName) {
		this.hostName = hostName;
	}
	public String getDburl() {
		return dburl;
	}
	public void setDburl(String dburl) {
		this.dburl = dburl;
	}
	public String getDbuser() {
		return dbuser;
	}
	public void setDbuser(String dbuser) {
		this.dbuser = dbuser;
	}
	public String getDbpwd() {
		return dbpwd;
	}
	public void setDbpwd(String dbpwd) {
		this.dbpwd = dbpwd;
	}
	public String getScriptname() {
		return scriptname;
	}
	public void setScriptname(String scriptname) {
		this.scriptname = scriptname;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getStatus() {
		return status;
	}
	public String getStatusNum(){
		if(status==null || "".equals(status)){
			return "0";
		}
		return "1";
	}
	public void setConfig(HashMap<String,String> config) {
		this.config = config;
	}
	public HashMap<String,String> getConfig() {
		
		if(serverType!=null && "oracle".equals(serverType.toLowerCase())){

			config = new HashMap<String, String>();
			//config.put("Oracle.host", hostName);
			config.put("Oracle.dburl", dburl);
			config.put("Oracle.dbuser", dbuser);
			config.put("Oracle.dbpassword", dbpwd);
			if(scriptname!=null){
				config.put("Oracle.scriptname", scriptname);
			}
			

		}else if(serverType!=null && "aix".equals(serverType.toLowerCase())){

			config = new HashMap<String, String>();
			config.put("Host.IP", hostIP);
			config.put("Host.name", hostName);
			config.put("Host.port", hostPort);
			config.put("Host.user", hostUser);
			config.put("Host.password", hostPassword);
			config.put("ConnectType", ConnectType);
			if(scriptname!=null){
				config.put("Host.scriptname", scriptname);
			}
			
		}else if(serverType!=null && "ping".equals(serverType.toLowerCase())){

			config = new HashMap<String, String>();
			config.put("Host.IP", hostIP);
			config.put("Host.name", hostName);
			config.put("SystemType", systemType);
		}

		return config;
	}
	public void setResourcePrototypeName(String resourcePrototypeName) {
		this.resourcePrototypeName = resourcePrototypeName;
	}
	public String getResourcePrototypeName() {
		return resourcePrototypeName;
	}
	public void setResourceTypeId(String resourceTypeId) {
		this.resourceTypeId = resourceTypeId;
	}
	public String getResourceTypeId() {
		return resourceTypeId;
	}
	public void setHostIP(String hostIP) {
		this.hostIP = hostIP;
	}
	public String getHostIP() {
		return hostIP;
	}
	public void setHostPort(String hostPort) {
		this.hostPort = hostPort;
	}
	public String getHostPort() {
		return hostPort;
	}
	public void setHostUser(String hostUser) {
		this.hostUser = hostUser;
	}
	public String getHostUser() {
		return hostUser;
	}
	public void setHostPassword(String hostPassword) {
		this.hostPassword = hostPassword;
	}
	public String getHostPassword() {
		return hostPassword;
	}
	public void setConnectType(String connectType) {
		ConnectType = connectType;
	}
	public String getConnectType() {
		return ConnectType;
	}
	public void setResourcePrototype(ResourcePrototype resourcePrototype) {
		this.resourcePrototype = resourcePrototype;
	}
	public ResourcePrototype getResourcePrototype() {
		resourcePrototype = new ResourcePrototype();
		resourcePrototype.setName(resourcePrototypeName);
		if(resourceTypeId != null && HQUtil.isNumber(resourceTypeId)){
			resourcePrototype.setResourceTypeId(Integer.parseInt(resourceTypeId));
		}else{
			resourcePrototype.setResourceTypeId(2);
		}
		return resourcePrototype;
	}
	public void setServerIp(String serverIp) {
		this.serverIp = serverIp;
	}
	public String getServerIp() {
		if(dburl!=null && "".equals(dburl)){
			serverIp = dburl;
		}else if(hostIP!=null && "".equals(hostIP)){
			serverIp = hostIP;
		}
		return serverIp;
	}
	public void setCreateMessage(String createMessage) {
		this.createMessage = createMessage;
	}
	public String getCreateMessage() {
		return createMessage;
	}
	public void setFileId(int fileId) {
		this.fileId = fileId;
	}
	public int getFileId() {
		return fileId;
	}
	public void setInterval(String interval) {
		this.interval = interval;
	}
	public String getInterval() {
		return interval;
	}
	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}
	public String getResourceId() {
		return resourceId;
	}
	public int getResourceIdNum() {
		if(resourceId==null || !HQUtil.isNumber(resourceId)){
			return 0;
		}
		return Integer.parseInt(resourceId);
	}
	public void setServerIp2(String serverIp2) {
		this.serverIp2 = serverIp2;
	}
	public String getServerIp2() {
		return serverIp2;
	}
	public String getServerid() {
		return serverid;
	}
	public void setServerid(String serverid) {
		this.serverid = serverid;
	}
	public void setSystemType(String systemType) {
		this.systemType = systemType;
	}
	public String getSystemType() {
		return systemType;
	}
	public Integer getHqserverid() {
		return hqserverid;
	}
	public void setHqserverid(Integer hqserverid) {
		this.hqserverid = hqserverid;
	}
	public String getHqservername() {
		return hqservername;
	}
	public void setHqservername(String hqservername) {
		this.hqservername = hqservername;
	}
	public boolean isEnable() {
		return isEnable;
	}
	public void setEnable(boolean isEnable) {
		this.isEnable = isEnable;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getPluginName() {
		return pluginName;
	}
	public void setPluginName(String pluginName) {
		this.pluginName = pluginName;
	}
}