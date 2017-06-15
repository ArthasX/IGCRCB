/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.sym.dto;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.user.model.IG622Info;
import com.deliverik.infogovernor.sym.form.IGSYM1802Form;

/**
 * ����: ��ҳ����DTO
 * ������������ҳ����DTO
 * ������¼����ѧ־    2012/11/14
 * �޸ļ�¼��
 */
@SuppressWarnings("serial")
public class IGSYM18DTO extends BaseDTO implements Serializable{
	
	/** ��ҳ������Ϣ������� */
	protected List<IG622Info> firstJspInfoList;
	/**��ҳ��������form */
	protected IGSYM1802Form igSYM1802Form;
	
	/**
	 * ��ҳ��������form��ȡ
	 * @return the igSYM1802Form
	 */
	public IGSYM1802Form getIgSYM1802Form() {
		return igSYM1802Form;
	}
	/**
	 *��ҳ��������form�趨
	 *	
	 * @param igSYM1802Form the igSYM1802Form to set
	 */
	public void setIgSYM1802Form(IGSYM1802Form igSYM1802Form) {
		this.igSYM1802Form = igSYM1802Form;
	}
	/**
	 * ��ҳ������Ϣ������� ȡ��
	 * @return the firstJspInfoList
	 */
	public List<IG622Info> getFirstJspInfoList() {
		return firstJspInfoList;
	}
	/**
	 *��ҳ������Ϣ�����������
	 *	
	 * @param firstJspInfoList the firstJspInfoList to set
	 */
	public void setFirstJspInfoList(List<IG622Info> firstJspInfoList) {
		this.firstJspInfoList = firstJspInfoList;
	}
}


