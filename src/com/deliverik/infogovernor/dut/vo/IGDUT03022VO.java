/*
 * ������������Ϣ�������޹�˾��Ȩ����,��������Ȩ��.
 */
package com.deliverik.infogovernor.dut.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.dut.model.DutyResult;

/**
 * ֵ��������VO
 */
public class IGDUT03022VO extends BaseVO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * ֵ��������
	 */
	protected DutyResult dutyResult;
	/**
	 * ֵ�������ݼ������
	 */
	protected List<DutyResult> dutyResultList;
	
	/**
	 * ������ϲ�����
	 */
	protected Integer rowspanNum = 0;

	/**
	 * ֵ�������ݼ������ȡ��
	 * @return ֵ�������ݼ������
	 */
	public List<DutyResult> getDutyResultList() {
		return dutyResultList;
	}

	/**
	 * ������ϲ������趨
	 * @param dutyDataList ������ϲ�����
	 */
	public void setDutyResultList(List<DutyResult> dutyResultList) {
		this.dutyResultList = dutyResultList;
	}

	/**
	 * ������ϲ�����ȡ��
	 * @return ������ϲ�����
	 */
	public Integer getRowspanNum() {
		return rowspanNum;
	}

	/**
	 * ������ϲ������趨
	 * @param rowspanNum ������ϲ�����
	 */
	public void setRowspanNum(Integer rowspanNum) {
		this.rowspanNum = rowspanNum;
	}

	/**
	 * ֵ��������ȡ��
	 * @return ֵ��������
	 */
	public DutyResult getDutyResult() {
		return dutyResult;
	}

	/**
	 * ֵ���������趨
	 * @param dutyResult ֵ��������
	 */
	public void setDutyResult(DutyResult dutyResult) {
		this.dutyResult = dutyResult;
	}
	
}
