/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.ram.model.condition;

import java.util.ArrayList;
import java.util.List;

/**
  * ����: ������ʷ��ѯ��������ʵ��
  * ��������: ������ʷ��ѯ��������ʵ��
  * ������¼: 2013/10/10
  * �޸ļ�¼: 
  */
public class AssessmentScoreVWSearchCondImpl implements
		AssessmentScoreVWSearchCond {
	/** ����id */
	protected Integer prid;
	
	/**��ȱ�����Ȳ�ѯ����*/
	protected String currentyear;
	
	/**�������������ѯ��ʼʱ��*/
	protected String begintime;
	
	/**�������������ѯ��ʼʱ��*/
	protected String endtime;
	
	/** ����������ֲ�����id*/
	protected String userid;
	
	/** ������������pdids*/
	protected List<String> list;
	
	/** ����������������ͳ�� ʹ��toporgid*/
	protected String topOrgid;
	
	/**
	 * pridȡ��
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * prid�趨
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	/**
	 * currentyearȡ��
	 */
	public String getCurrentyear() {
		return currentyear;
	}

	/**
	 * currentyear�趨
	 */
	public void setCurrentyear(String currentyear) {
		this.currentyear = currentyear;
	}

	/**
	 * begintimeȡ��
	 */
	public String getBegintime() {
		return begintime;
	}

	/**
	 * begintime�趨
	 */
	public void setBegintime(String begintime) {
		this.begintime = begintime;
	}

	/**
	 * endtimeȡ��
	 */
	public String getEndtime() {
		return endtime;
	}

	/**
	 * endtime�趨
	 */
	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	/**
	 * useridȡ��
	 */
	public String getUserid() {
		return userid;
	}

	/**
	 * userid�趨
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}

	/**
	 * ������������pdidslistȡ��
	 */
	public List<String> getList() {
		return list;
	}

	/**
	 * ������������pdidslist�趨
	 */
	public void setList(List<String> list) {
		this.list = new ArrayList<String>();
		this.list = list;
	}

	/**
	 * topOrgidȡ��
	 */
	public String getTopOrgid() {
		return topOrgid;
	}

	/**
	 * topOrgid�趨
	 */
	public void setTopOrgid(String topOrgid) {
		this.topOrgid = topOrgid;
	}
	
	
}