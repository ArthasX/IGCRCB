package com.deliverik.infogovernor.risk.vo;

import java.io.Serializable;

import com.deliverik.framework.base.BaseVO;

/**	
 * ����: �������Ϣvo
 * ������¼��yukexin    2014-9-4 ����10:22:25	
 * �޸ļ�¼��null
 */	
@SuppressWarnings("serial")
public class IGRIS06141VO extends BaseVO implements Serializable{
	
	/** �����id  */	
	private String eiid;
	
	/** ��������  */	
	private String eilabel;
	
	/** ���������  */	
	private String checkitemName;
	
	/** �����˵��  */	
	private String checkitemDesc;
	
	/** ���������  */	
	private String checkitemMethod;

	/**
	 * �����idȡ��
	 * @return eiid  �����id
	 */
	public String getEiid() {
		return eiid;
	}

	/**
	 * �����id�趨
	 * @param eiid  �����id
	 */
	public void setEiid(String eiid) {
		this.eiid = eiid;
	}

	/**
	 * ��������ȡ��
	 * @return eilabel  ��������
	 */
	public String getEilabel() {
		return eilabel;
	}

	/**
	 * ���������趨
	 * @param eilabel  ��������
	 */
	public void setEilabel(String eilabel) {
		this.eilabel = eilabel;
	}

	/**
	 * ���������ȡ��
	 * @return checkitemName  ���������
	 */
	public String getCheckitemName() {
		return checkitemName;
	}

	/**
	 * ����������趨
	 * @param checkitemName  ���������
	 */
	public void setCheckitemName(String checkitemName) {
		this.checkitemName = checkitemName;
	}

	/**
	 * �����˵��ȡ��
	 * @return checkitemDesc  �����˵��
	 */
	public String getCheckitemDesc() {
		return checkitemDesc;
	}

	/**
	 * �����˵���趨
	 * @param checkitemDesc  �����˵��
	 */
	public void setCheckitemDesc(String checkitemDesc) {
		this.checkitemDesc = checkitemDesc;
	}

	/**
	 * ���������ȡ��
	 * @return checkitemMethod  ���������
	 */
	public String getCheckitemMethod() {
		return checkitemMethod;
	}

	/**
	 * ����������趨
	 * @param checkitemMethod  ���������
	 */
	public void setCheckitemMethod(String checkitemMethod) {
		this.checkitemMethod = checkitemMethod;
	}
	
}

