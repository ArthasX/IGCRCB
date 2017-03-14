/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.dbm.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.dbm.model.WorkmanagerInfo;

/**
 * ȫ��IP��ַ������Ϣ�������VO
 * 
 * @author 
 *
 */
@SuppressWarnings("serial")
public class IGDBM13011VO extends BaseVO implements Serializable{

	//������������
	protected List<WorkmanagerInfo> wmList;

	/**Ƶ�������ڼ���*/
	protected List<IGDBM13012VO> weekList;
	
	/**Ƶ������������*/
	protected List<IGDBM13012VO> monthList;
	
	protected Map<String, List<WorkmanagerInfo>> workmanagermap;
	
	protected Map<Integer,String> mapType;

	/**
	 * @return the Ƶ�������ڼ���
	 */
	public List<IGDBM13012VO> getWeekList() {
		return weekList;
	}

	/**
	 * @param Ƶ�������ڼ��� the weekList to set
	 */
	public void setWeekList(List<IGDBM13012VO> weekList) {
		this.weekList = weekList;
	}

	/**
	 * @return the Ƶ������������
	 */
	public List<IGDBM13012VO> getMonthList() {
		return monthList;
	}

	/**
	 * @param Ƶ������������ the monthList to set
	 */
	public void setMonthList(List<IGDBM13012VO> monthList) {
		this.monthList = monthList;
	}

	/**
	 * @return the workmanagermap
	 */
	public Map<String, List<WorkmanagerInfo>> getWorkmanagermap() {
		return workmanagermap;
	}

	/**
	 * @param workmanagermap the workmanagermap to set
	 */
	public void setWorkmanagermap(Map<String, List<WorkmanagerInfo>> workmanagermap) {
		this.workmanagermap = workmanagermap;
	}

	/**
	 * @return the mapType
	 */
	public Map<Integer, String> getMapType() {
		return mapType;
	}

	/**
	 * @param mapType the mapType to set
	 */
	public void setMapType(Map<Integer, String> mapType) {
		this.mapType = mapType;
	}
	
	/**
	 * @return the wmList
	 */
	public List<WorkmanagerInfo> getWmList() {
		return wmList;
	}

	/**
	 * @param wmList the wmList to set
	 */
	public void setWmList(List<WorkmanagerInfo> wmList) {
		this.wmList = wmList;
	}
	
}


