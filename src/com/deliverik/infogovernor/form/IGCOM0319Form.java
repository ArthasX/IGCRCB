/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.form;

import com.deliverik.framework.soc.asset.model.condition.SOC0130SearchCond;
import com.deliverik.framework.soc.asset.model.condition.SOC0131SearchCond;

/**
 * ����: �豸��ϵ��ϢFORM
 * ��������: �豸��ϵ��ϢFORM
 * ������¼: 2011/05/13
 * �޸ļ�¼: 
 */
public class IGCOM0319Form extends IGCOM0318Form implements SOC0130SearchCond,SOC0131SearchCond{
	private static final long serialVersionUID = 1L;
	
	protected String srname;
	
	/** FsLvVgInfo�б�ɸѡ���������� */
	protected String attrName;
	
	/** FsLvVgInfo�б�ɸѡ������ֵ */
	protected String attrValue;
	
	/** FsLvVgInfo�б�ɸѡ���������� */
	protected String parName;
	
	/** FsLvVgInfo�б�ɸѡ������ֵ */
	protected String parValue;
	
	/** FS-LV-VG������ */
	protected String soltName;
	/** VG-PV-META������*/
	protected String soltNameVg;
	
	/** ����ʽ 0���� 1���� */
	protected Integer soltType;
	
	/** �ֱ��� */
	protected Integer screenWidth;

	
	
	

	/**
	 *  FS-LV-VG������ȡ��
	 * @return  FS-LV-VG������
	 */
	public String getSoltName() {
		return soltName;
	}

	/**
	 *  FS-LV-VG�������趨
	 * @param soltName FS-LV-VG������
	 */
	public void setSoltName(String soltName) {
		this.soltName = soltName;
	}

	/**
	 * ����ʽ 0���� 1����ȡ��
	 * @return ����ʽ 0���� 1����
	 */
	public Integer getSoltType() {
		return soltType;
	}

	/**
	 * ����ʽ 0���� 1�����趨
	 * @param soltType����ʽ 0���� 1����
	 */
	public void setSoltType(Integer soltType) {
		this.soltType = soltType;
	}

	/**
	 * �ֱ���ȡ��
	 * @return �ֱ���
	 */
	public Integer getScreenWidth() {
		return screenWidth;
	}

	/**
	 * �ֱ����趨
	 * @param screenWidth�ֱ���
	 */
	public void setScreenWidth(Integer screenWidth) {
		this.screenWidth = screenWidth;
	}

	public String getSrname() {
		return srname;
	}

	public void setSrname(String srname) {
		this.srname = srname;
	}

	/**
	 * FsLvVgInfo�б�ɸѡ����������ȡ��
	 * @return FsLvVgInfo�б�ɸѡ����������
	 */
	public String getAttrName() {
		return attrName;
	}

	/**
	 * FsLvVgInfo�б�ɸѡ�����������趨
	 * @param attrNameFsLvVgInfo�б�ɸѡ����������
	 */
	public void setAttrName(String attrName) {
		this.attrName = attrName;
	}

	/**
	 * FsLvVgInfo�б�ɸѡ������ֵȡ��
	 * @return FsLvVgInfo�б�ɸѡ������ֵ
	 */
	public String getAttrValue() {
		return attrValue;
	}

	/**
	 * FsLvVgInfo�б�ɸѡ������ֵ�趨
	 * @param attrValueFsLvVgInfo�б�ɸѡ������ֵ
	 */
	public void setAttrValue(String attrValue) {
		this.attrValue = attrValue;
	}

	/**
	 * FsLvVgInfo�б�ɸѡ����������ȡ��
	 * @return FsLvVgInfo�б�ɸѡ����������
	 */
	public String getParName() {
		return parName;
	}

	/**
	 * FsLvVgInfo�б�ɸѡ�����������趨
	 * @param parNameFsLvVgInfo�б�ɸѡ����������
	 */
	public void setParName(String parName) {
		this.parName = parName;
	}

	/**
	 * FsLvVgInfo�б�ɸѡ������ֵȡ��
	 * @return FsLvVgInfo�б�ɸѡ������ֵ
	 */
	public String getParValue() {
		return parValue;
	}

	/**
	 * FsLvVgInfo�б�ɸѡ������ֵ�趨
	 * @param parValueFsLvVgInfo�б�ɸѡ������ֵ
	 */
	public void setParValue(String parValue) {
		this.parValue = parValue;
	}

	/**
	 * VG-PV-META������ȡ��
	 * @return VG-PV-META������
	 */
	public String getSoltNameVg() {
		return soltNameVg;
	}

	/**
	 * VG-PV-META�������趨
	 * @param soltNameVg VG-PV-META������
	 */
	public void setSoltNameVg(String soltNameVg) {
		this.soltNameVg = soltNameVg;
	}
	
	
	
}
