/*
 * ������������Ϣ�������޹�˾��Ȩ����,��������Ȩ��.
 */
package com.deliverik.infogovernor.dut.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.dut.model.DutyPlan;
import com.deliverik.infogovernor.dut.model.DutyResultVWInfo;

/**
 * ֵ���ձ�VO
 */
public class IGDUT02031VO extends BaseVO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/** ֵ���ձ�������� */
	protected Map<String,List<DutyResultVWInfo>> typeMap;	
	
	/** ֵ������Ϣ*/
	protected String usersinfo;
	
	/** ֵ��ʱ��*/
	protected String dptype;

	/** ֵ��ƻ�*/
	protected DutyPlan dutyPlan;
	
	/** ֵ���ձ�ID���� */
	protected List<Integer> dridList;

	/** ֵ���ձ������ѡ���ʶ 0����ѡ 1��ѡ */
	protected List<String> showList;
	
	/** ֵ���ձ���ע */
	protected String dpremarks;
	
	/** ���˵���Ƿ�ɱ༭ */
	protected List<String> showResultList;
	
	
	public List<String> getShowResultList() {
		return showResultList;
	}

	public void setShowResultList(List<String> showResultList) {
		this.showResultList = showResultList;
	}

	/**
	 * ֵ���ձ������ѡ���ʶȡ��
	 * @return the showList
	 */
	public List<String> getShowList() {
		return showList;
	}

	/**
	 *  ֵ���ձ������ѡ���ʶ�趨
	 */
	public void setShowList(List<String> showList) {
		this.showList = showList;
	}
	
	/**
	 * ֵ���ձ�ID����ȡ��
	 * @return the dridList
	 */
	public List<Integer> getDridList() {
		return dridList;
	}

	/**
	 *  ֵ���ձ�ID�����趨
	 */
	public void setDridList(List<Integer> dridList) {
		this.dridList = dridList;
	}
	
	
	/**
	 *  ֵ���ձ��������ȡ��
	 * @return the typeMap
	 */
	public DutyPlan getDutyPlan() {
		return dutyPlan;
	}


	/**
	 *  ֵ���ձ���������趨
	 */
	public void setDutyPlan(DutyPlan dutyPlan) {
		this.dutyPlan = dutyPlan;
	}


	/**
	 *  ֵ���ձ��������ȡ��
	 * @return the typeMap
	 */
	public Map<String, List<DutyResultVWInfo>> getTypeMap() {
		return typeMap;
	}


	/**
	 *  ֵ������Ϣȡ��
	 * @return the usersinfo
	 */
	public String getUsersinfo() {
		return usersinfo;
	}


	/**
	 *  ֵ��ʱ��ȡ��
	 * @return the dptype
	 */
	public String getDptype() {
		return dptype;
	}


	/**
	 *  ֵ���ձ���������趨
	 */
	public void setTypeMap(Map<String, List<DutyResultVWInfo>> typeMap) {
		this.typeMap = typeMap;
	}


	/**
	 *  ֵ������Ϣ�趨
	 */
	public void setUsersinfo(String usersinfo) {
		this.usersinfo = usersinfo;
	}


	/**
	 *  ֵ��ʱ���趨
	 */
	public void setDptype(String dptype) {
		this.dptype = dptype;
	}


	/**
	 * ֵ��ƻ���עȡ��
	 *
	 * @return dpremarks ֵ��ƻ���ע
	 */
	public String getDpremarks() {
		return dpremarks;
	}

	/**
	 * ֵ��ƻ���ע�趨
	 *
	 * @param dpremarks ֵ��ƻ���ע
	 */
	public void setDpremarks(String dpremarks) {
		this.dpremarks = dpremarks;
	}
	
}
