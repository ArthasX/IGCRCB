/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.soc.alarm.form;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.infogovernor.soc.alarm.model.condition.CRM10SearchCond;


@SuppressWarnings("serial")
public class IGALM0501Form extends BaseForm implements CRM10SearchCond {
	
protected String host;
	
	protected  String  isquery;
	protected  String  Tablename;
	protected String nowCollecttime="";
	public void setTablename(String tablename) {
		Tablename = tablename;
	}


	public String getNowCollecttime() {
		return nowCollecttime;
	}


	public void setNowCollecttime(String nowCollecttime) {
		this.nowCollecttime = nowCollecttime;
	}


	public String getIsquery() {
		return isquery;
	}


	public void setIsquery(String isquery) {
		this.isquery = isquery;
	}


	/** ip */
	protected String ip;

	
	public String getHost() {
		return host;
	}


	public void setHost(String host) {
		this.host = host;
	}


	public String getIp() {
		return ip;
	}


	public void setIp(String ip) {
		this.ip = ip;
	}


	public String getIP() {
		return ip;
	}


	public void setIP(String ip) {
		this.ip = ip;
	}


	public String getServername() {
		return servername;
	}

   
	public void setServername(String servername) {
		this.servername = servername;
	}


	public Integer getServertype() {
		return servertype;
	}


	public void setServertype(Integer servertype) {
		this.servertype = servertype;
	}


	public String getCollecttime() {
		return collecttime;
	}


	public void setCollecttime(String collecttime) {
		this.collecttime = collecttime;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public String getKeys() {
		return keys;
	}


	public void setKeys(String keys) {
		this.keys = keys;
	}


	/** servername */
	protected String servername;

	
	public String getTablename() {
		return Tablename;
	}


	public String getSymType() {
		return SymType;
	}


	public void setSymType(String symType) {
		SymType = symType;
	}


	/** servertype */
	protected Integer servertype;


	/** collecttime */
	protected String collecttime;

	
	

    protected String category;


	/** keys */
	protected String keys;
	
	/**SymType*/
	protected String SymType;
   
    /**objectname**/
	protected String objectname;



	public String getObjectname() {
		return objectname;
	}


	public void setObjectname(String objectname) {
		this.objectname = objectname;
	}


	protected String get_StartTime="";//开始时间
    protected String get_EndTime="";//结束时间


	public String getGet_StartTime() {
		return get_StartTime;
	}


	public void setGet_StartTime(String get_StartTime) {
		this.get_StartTime = get_StartTime;
	}


	public String getGet_EndTime() {
		return get_EndTime;
	}


	public void setGet_EndTime(String get_EndTime) {
		this.get_EndTime = get_EndTime;
	}


	


	
}
