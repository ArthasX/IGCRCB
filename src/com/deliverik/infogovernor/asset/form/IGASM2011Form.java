/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.asset.form;

import com.deliverik.framework.asset.model.condition.ImportVersionSearchCond;
import com.deliverik.framework.base.BaseForm;

/**
 * ����: �������汾��ѯ����FORM
 * ��������: �������汾��ѯ����FORM
 * ������¼: 2011/05/05
 * �޸ļ�¼: 
 */
public class IGASM2011Form extends BaseForm implements ImportVersionSearchCond{
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

	public String getEiddid() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getTypeId() {
		// TODO Auto-generated method stub
		return null;
	}

}
