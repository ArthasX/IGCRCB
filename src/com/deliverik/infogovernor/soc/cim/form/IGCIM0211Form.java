/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.soc.cim.form;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.soc.asset.model.condition.SOC0120SearchCond;

/**
 * ����: �������汾��ѯ����FORM
 * ��������: �������汾��ѯ����FORM
 * ������¼: 2011/05/05
 * �޸ļ�¼: 
 */
public class IGCIM0211Form extends BaseForm implements SOC0120SearchCond{
	private static final long serialVersionUID = 1L;
	
	/** ʵ���� */
	protected String impeiname;
	
	/** �汾�� */
	protected Integer impversion;
	
	/**
	 * ʵ����ȡ��
	 *
	 * @return ʵ����
	 */
	public String getImpeiname() {
		return impeiname;
	}

	/**
	 * ʵ�����趨
	 * @param impeinameʵ����
	 */
	public void setImpeiname(String impeiname) {
		this.impeiname = impeiname;
	}
	
	/**
	 * �汾��ȡ��
	 * @return �汾��
	 */
	public Integer getImpversion() {
		return impversion;
	}

	/**
	 * �汾���趨
	 * @param impversion�汾��
	 */
	public void setImpversion(Integer impversion) {
		this.impversion = impversion;
	}

	public String getDeleteflag_eq() {
		return null;
	}

	public String getImpeiname_like() {
		return null;
	}

	public String getImpeiname_eq() {
		return null;
	}


	public String getEilabel() {
		return null;
	}

	public String getEsyscoding() {
		return null;
	}
	public String getImpcreatetime_e() {
		return null;
	}

	public String getImpcreatetime_s() {
		return null;
	}

}
