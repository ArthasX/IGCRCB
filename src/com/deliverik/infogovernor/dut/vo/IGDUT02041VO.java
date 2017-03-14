/*
 * ������������Ϣ�������޹�˾��Ȩ����,��������Ȩ��.
 */
package com.deliverik.infogovernor.dut.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.dut.model.DutyPlan;
import com.deliverik.infogovernor.dut.model.DutyResult;
import com.deliverik.infogovernor.dut.model.entity.DutyPersonTB;

/**
 * ֵ��������VO
 */
public class IGDUT02041VO extends BaseVO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * ֵ�������ݼ������
	 */
	private List<DutyResult> dutyResultList;
	
	/**
	 * ֵ����������ʾVO
	 */
	protected List<IGDUT02042VO> voList;
	
	/** ֵ������Ϣ*/
	protected String usersinfo;
	
	/** ֵ��ƻ�*/
	protected DutyPlan dutyPlan;
	
	/** ֵ�����б� */
	protected List<DutyPersonTB> dutyPersonList;
	
	/** �Ƿ���δ�����,1���� */
	protected String  hasNullDrcontent;
	
	/**
	 * ֵ�������ݼ������ȡ��
	 * @return ֵ�������ݼ������
	 */
	public List<DutyResult> getDutyResultList() {
		return dutyResultList;
	}

	/**
	 * ֵ�������ݼ�������趨
	 * @param dutyDataList ֵ�������ݼ������
	 */
	public void setDutyResultList(List<DutyResult> dutyResultList) {
		this.dutyResultList = dutyResultList;
		if(dutyResultList != null) {
			voList = new ArrayList<IGDUT02042VO>();
			//�������
			String dadtype = "";
			//VO���
			int i = -1;
			for(DutyResult dr :dutyResultList) {
				if(dr.getDadtype().equals(dadtype)) {
					voList.get(i).getDutyResultList().add(dr);
				} else {
					dadtype = dr.getDadtype();
					voList.add(new IGDUT02042VO());
					voList.get(++i).setDutyResultList(new ArrayList<DutyResult>());
					voList.get(i).setDutyResult(dr);
				}
				int count = voList.get(i).getRowspanNum();
				voList.get(i).setRowspanNum(++count);
			}
		}
	}

	/**
	 * ֵ����������ʾVO
	 * @return ֵ����������ʾVO
	 */
	public List<IGDUT02042VO> getVoList() {
		return voList;
	}
	
	/**
	 * ֵ������Ϣȡ��
	 * @return ֵ������Ϣ
	 */
	public String getUsersinfo() {
		return usersinfo;
	}

	/**
	 * ֵ������Ϣ�趨
	 *
	 * @param usersinfo ֵ������Ϣ
	 */
	public void setUsersinfo(String usersinfo) {
		this.usersinfo = usersinfo;
	}

	/**
	 * ֵ��ƻ�ȡ��
	 * @return ֵ��ƻ�
	 */
	public DutyPlan getDutyPlan() {
		return dutyPlan;
	}

	/**
	 * ֵ��ƻ��趨
	 *
	 * @param dutyPlan ֵ��ƻ�
	 */
	public void setDutyPlan(DutyPlan dutyPlan) {
		this.dutyPlan = dutyPlan;
	}

	/**
	 * ֵ����ȡ��
	 * @return ֵ����
	 */
	public List<DutyPersonTB> getDutyPersonList() {
		return dutyPersonList;
	}

	/**
	 * ֵ�����趨
	 *
	 * @param dutyPersonList ֵ����
	 */
	public void setDutyPersonList(List<DutyPersonTB> dutyPersonList) {
		this.dutyPersonList = dutyPersonList;
	}
	
	/**
	 * �Ƿ���δ�����ȡ��
	 * @return �Ƿ���δ�����
	 */
	public String getHasNullDrcontent() {
		return hasNullDrcontent;
	}

	/**
	 * �Ƿ���δ�����
	 * @param hasNullDrcontent �Ƿ���δ�����
	 */
	public void setHasNullDrcontent(String hasNullDrcontent) {
		this.hasNullDrcontent = hasNullDrcontent;
	}
	
}
