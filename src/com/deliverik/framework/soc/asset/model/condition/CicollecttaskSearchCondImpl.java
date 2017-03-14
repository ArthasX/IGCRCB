/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.model.condition;

import java.io.Serializable;
import java.util.List;

/**
  * ����: cicollecttask��������ʵ��
  * ��������: cicollecttask��������ʵ��
  * ������¼: 2013/07/05
  * �޸ļ�¼: 
  */
public class CicollecttaskSearchCondImpl implements
		CicollecttaskSearchCond {
	
	protected Integer typeid;

	/** typename */
	protected String typename;

	/** uuid */
	protected String uuid;

	/** name */
	protected String name;

	/** startrule */
	protected String startrule;

	/** stoprule */
	protected String stoprule;

	/** starttime */
	protected String starttime;

	/** stoptime */
	protected String stoptime;

	/** newstarttime */
	protected String newstarttime;

	/** newstoptime */
	protected String newstoptime;

	/** executstatus */
	protected String executstatus;

	/** periodtype */
	protected String periodtype;
	
	protected List<String> typeNames;
	
	protected List<Integer> typeIds;
	
	private String collectType;

	public List<String> getTypeNames() {
		return typeNames;
	}

	public void setTypeNames(List<String> typeNames) {
		this.typeNames = typeNames;
	}

	/**
	 * typeidȡ��
	 *
	 * @return typeid
	 */
	public Integer getTypeid() {
		return typeid;
	}

	/**
	 * typeid�趨
	 *
	 * @param typeid typeid
	 */
	public void setTypeid(Integer typeid) {
		this.typeid = typeid;
	}

	/**
	 * typenameȡ��
	 *
	 * @return typename
	 */
	public String getTypename() {
		return typename;
	}

	/**
	 * typename�趨
	 *
	 * @param typename typename
	 */
	public void setTypename(String typename) {
		this.typename = typename;
	}

	/**
	 * uuidȡ��
	 *
	 * @return uuid
	 */
	public String getUuid() {
		return uuid;
	}

	/**
	 * uuid�趨
	 *
	 * @param uuid uuid
	 */
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	/**
	 * nameȡ��
	 *
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * name�趨
	 *
	 * @param name name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * startruleȡ��
	 *
	 * @return startrule
	 */
	public String getStartrule() {
		return startrule;
	}

	/**
	 * startrule�趨
	 *
	 * @param startrule startrule
	 */
	public void setStartrule(String startrule) {
		this.startrule = startrule;
	}

	/**
	 * stopruleȡ��
	 *
	 * @return stoprule
	 */
	public String getStoprule() {
		return stoprule;
	}

	/**
	 * stoprule�趨
	 *
	 * @param stoprule stoprule
	 */
	public void setStoprule(String stoprule) {
		this.stoprule = stoprule;
	}

	/**
	 * starttimeȡ��
	 *
	 * @return starttime
	 */
	public String getStarttime() {
		return starttime;
	}

	/**
	 * starttime�趨
	 *
	 * @param starttime starttime
	 */
	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	/**
	 * stoptimeȡ��
	 *
	 * @return stoptime
	 */
	public String getStoptime() {
		return stoptime;
	}

	/**
	 * stoptime�趨
	 *
	 * @param stoptime stoptime
	 */
	public void setStoptime(String stoptime) {
		this.stoptime = stoptime;
	}

	/**
	 * newstarttimeȡ��
	 *
	 * @return newstarttime
	 */
	public String getNewstarttime() {
		return newstarttime;
	}

	/**
	 * newstarttime�趨
	 *
	 * @param newstarttime newstarttime
	 */
	public void setNewstarttime(String newstarttime) {
		this.newstarttime = newstarttime;
	}

	/**
	 * newstoptimeȡ��
	 *
	 * @return newstoptime
	 */
	public String getNewstoptime() {
		return newstoptime;
	}

	/**
	 * newstoptime�趨
	 *
	 * @param newstoptime newstoptime
	 */
	public void setNewstoptime(String newstoptime) {
		this.newstoptime = newstoptime;
	}

	/**
	 * executstatusȡ��
	 *
	 * @return executstatus
	 */
	public String getExecutstatus() {
		return executstatus;
	}

	/**
	 * executstatus�趨
	 *
	 * @param executstatus executstatus
	 */
	public void setExecutstatus(String executstatus) {
		this.executstatus = executstatus;
	}

	/**
	 * periodtypeȡ��
	 *
	 * @return periodtype
	 */
	public String getPeriodtype() {
		return periodtype;
	}

	/**
	 * periodtype�趨
	 *
	 * @param periodtype periodtype
	 */
	public void setPeriodtype(String periodtype) {
		this.periodtype = periodtype;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return typeid;
	}

	public void setCollectType(String collectType) {
		this.collectType = collectType;
	}

	public String getCollectType() {
		return collectType;
	}

	public List<Integer> getTypeIds() {
		return typeIds;
	}

	public void setTypeIds(List<Integer> typeIds) {
		this.typeIds = typeIds;
	}
	
}