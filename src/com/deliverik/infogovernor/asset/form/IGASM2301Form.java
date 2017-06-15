/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.asset.form;

import com.deliverik.framework.asset.model.condition.ImportVersionSearchCond;
import com.deliverik.framework.base.BaseForm;

/**
 * ����: �ɼ�����̨��Ϣ��ѯ����FORM
 * ��������: �ɼ�����̨��Ϣ��ѯ����FORM
 * ������¼: 2011/05/04
 * �޸ļ�¼: 
 */
public class IGASM2301Form extends BaseForm implements ImportVersionSearchCond{
	private static final long serialVersionUID = 1L;
	
	/** �߼�ɾ����ʶ */
	protected String deleteflag_eq;
	
	/** ʵ���� */
	protected String impeiname;
	
	/** ʵ����(������) */
	protected String impeiname_eq;
	
	/** ʵ����(ģ����ѯ) */
	protected String impeiname_like;
	
	/** ����ID���� */
	protected String[] collectIds;
	
	/** �汾�� */
	protected Integer impversion;
	
	/** �߼�ɾ����ʶ */
	protected String deleteflag;
	
	/**
	 * �߼�ɾ����ʶȡ��
	 *
	 * @return �߼�ɾ����ʶ
	 */
	public String getDeleteflag_eq() {
		return deleteflag_eq;
	}

	/**
	 * �߼�ɾ����ʶ�趨
	 * @param deleteflag_eq�߼�ɾ����ʶ
	 */
	public void setDeleteflag_eq(String deleteflag_eq) {
		this.deleteflag_eq = deleteflag_eq;
	}

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
	 * ʵ����(ģ����ѯ)ȡ��
	 *
	 * @return ʵ����(ģ����ѯ)
	 */
	public String getImpeiname_like() {
		return impeiname_like;
	}

	/**
	 * ʵ����(ģ����ѯ)�趨
	 * @param impeinameʵ����(ģ����ѯ)
	 */
	public void setImpeiname_like(String impeiname_like) {
		this.impeiname_like = impeiname_like;
	}

	/**
	 * ����ID����
	 * @return ����ID����
	 */
	public String[] getCollectIds() {
		return collectIds;
	}

	/**
	 * ����ID����
	 * @param collectIds ����ID����
	 */
	public void setCollectIds(String[] collectIds) {
		this.collectIds = collectIds;
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

	/**
	 * �߼�ɾ����ʶ
	 * @return �߼�ɾ����ʶ
	 */
	public String getDeleteflag() {
		return deleteflag;
	}

	/**
	 * �߼�ɾ����ʶ
	 * @param deleteflag�߼�ɾ����ʶ
	 */
	public void setDeleteflag(String deleteflag) {
		this.deleteflag = deleteflag;
	}

	/**
	 * ʵ����(������)ȡ��
	 */
	public String getImpeiname_eq() {
		return impeiname_eq;
	}

	/**
	 * ʵ����(������)�趨
	 * @param impeiname_eqʵ����(������)
	 */
	public void setImpeiname_eq(String impeiname_eq) {
		this.impeiname_eq = impeiname_eq;
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
