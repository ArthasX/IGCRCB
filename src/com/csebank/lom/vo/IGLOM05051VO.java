/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.csebank.lom.model.WorkLunchEatery;
import com.deliverik.framework.base.BaseVO;

/**
 * 
 * �����ͳɱ�ͳ��VO
 *
 */
public class IGLOM05051VO extends BaseVO implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
	/**
	 * �����ͳɱ�ͳ�ƽ��
	 */
	protected List<WorkLunchEatery> workLunchEateryList;
	
	protected Map<String,IGLOM05051VO> map;

	/**
	 * �����ͳɱ�ͳ�ƽ��ȡ��
	 * @return �����ͳɱ�ͳ�ƽ��
	 */
	public List<WorkLunchEatery> getWorkLunchEateryList() {
		return workLunchEateryList;
	}

	/**
	 * �����ͳɱ�ͳ�ƽ��
	 * @param eentertainmentList �����ͳɱ�ͳ�ƽ��
	 */
	public void setWorkLunchEateryList(List<WorkLunchEatery> workLunchEateryList) {
		this.workLunchEateryList = workLunchEateryList;
	}

	public Map<String, IGLOM05051VO> getMap() {
		return map;
	}

	public void setMap(Map<String, IGLOM05051VO> map) {
		this.map = map;
	}
	
}
