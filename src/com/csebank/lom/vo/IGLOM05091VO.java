/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.vo;

import java.io.Serializable;
import java.util.List;

import com.csebank.lom.model.DeptEentertainment;
import com.deliverik.framework.base.BaseVO;

/**
 * 
 * �Ӵ�ͳ��VO
 *
 */
public class IGLOM05091VO extends BaseVO implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
	/**
	 * �Ӵ�ͳ�ƽ��
	 */
	protected List<DeptEentertainment> deptEentertainment;

	/**
	 * �Ӵ�ͳ�ƽ��ȡ��
	 * @return �Ӵ�ͳ�ƽ��
	 */
	public List<DeptEentertainment> getDeptEentertainmentList() {
		return deptEentertainment;
	}

	/**
	 * �Ӵ�ͳ�ƽ��
	 * @param deptEentertainment �Ӵ�ͳ�ƽ��
	 */
	public void setDeptEentertainmentList(List<DeptEentertainment> deptEentertainment) {
		this.deptEentertainment = deptEentertainment;
	}

}
