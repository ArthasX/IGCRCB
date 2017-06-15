/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.dut.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.dut.model.DutyResult;

/**
 * ֵ���������ҵ���߼��ӿ�
 */
public class IGDUT03031VO extends BaseVO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * ֵ�����������Ϣ�������
	 */
	protected List<DutyResult> dutyResultList;

	/**
	 * ֵ�����������Ϣ�������ȡ��
	 * @return ֵ�����������Ϣ�������
	 */
	public List<DutyResult> getDutyResultList() {
		return dutyResultList;
	}

	/**
	 * ֵ�����������Ϣ��������趨
	 * @param dutyResultList ֵ�����������Ϣ�������
	 */
	public void setDutyResultList(List<DutyResult> dutyResultList) {
		this.dutyResultList = dutyResultList;
	}

}
