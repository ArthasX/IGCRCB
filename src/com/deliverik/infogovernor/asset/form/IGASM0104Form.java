package com.deliverik.infogovernor.asset.form;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.soc.asset.model.SOC0109Info;

/**
 * �ʲ�������Ϣ�༭����FORM
 * 
 */
public class IGASM0104Form extends BaseForm implements SOC0109Info{

	private static final long serialVersionUID = 1L;

	/** �ʲ�����ID */
	protected String cid;
	
	/** �ʲ�����ID�����֣� */
	protected String cidStr;
	
	/** �ʲ�ģ��ID */
	protected String eid;
	
	/** �ʲ������� */
	protected String cname;

	/** �ʲ�����˵�� */
	protected String cdesc;
	
	/** �ʲ����õ�λ */
	protected String cunit;

	/** �ʲ�����״̬ */
	protected String cstatus;
	
	/** �ʲ�����˳�� */
	protected Integer cseq = 2;
	
	/** �ʲ�����ģ�� */
	protected String ccategory;
	
	/** �ʲ�����ȡֵ��Χ */
	protected String coption;
	
	/** �ʲ����ñ�� */
	protected String clabel;

	/** �ʲ�ģ�ͱ�� */
	protected String elabel;
	
	/** �༭ģʽ���Ǽ�/�����  */
	protected String mode = "0";
	
	/** ����Ǩ�Ʊ�ʶ */
	protected String route = "0";

	/** �ʲ����ø�����ʶ */
	protected String cattach;
	
	/** �ʲ�ģ�Ͳ���� */
	protected String esyscoding;
	
	/** �ʲ�ȡֵ��Χ���� */
	protected String rangename;
	
	/** �ʲ�����ֵ����ģ������ */
	protected String cename;
	
	/** �ʲ�����ֵ����ģ�Ͳ���� */
	protected String cesyscoding;
	
	/** �ʲ����ñ����� */
	protected String crequired;
	
	protected String fingerPrint;

	public String getFingerPrint() {
		return fingerPrint;
	}

	public void setFingerPrint(String fingerPrint) {
		this.fingerPrint = fingerPrint;
	}
	
	/**
	 * �ʲ�ģ�Ͳ����ȡ��
	 * @return �ʲ�ģ�Ͳ����
	 */
	public String getEsyscoding() {
		return esyscoding;
	}

	/**
	 * �ʲ�ģ�Ͳ�����趨
	 *
	 * @param esyscoding �ʲ�ģ�Ͳ����
	 */
	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}


	/**
	 * �ʲ�����IDȡ��
	 * @return �ʲ�����ID
	 */
	public String getCid() {
		if( (this.cidStr == null) || (this.cidStr.equals(""))){
			return null;
		} else {
			return this.cidStr;
		}
	}


	/**
	 * �ʲ�����ID�趨
	 *
	 * @param cid �ʲ�����ID
	 */
	public void setCid(String cid) {
		this.cid = cid;
	}


	/**
	 * �ʲ�����ID�����֣�ȡ��
	 * @return �ʲ�����ID�����֣�
	 */
	public String getCidStr() {
		return cidStr;
	}


	/**
	 * �ʲ�����ID�����֣��趨
	 *
	 * @param cidStr �ʲ�����ID�����֣�
	 */
	public void setCidStr(String cidStr) {
		this.cidStr = cidStr;
	}


	/**
	 * �ʲ�ģ��IDȡ��
	 * @return �ʲ�ģ��ID
	 */
	public String getEid() {
		return eid;
	}


	/**
	 * �ʲ�ģ��ID�趨
	 *
	 * @param eid �ʲ�ģ��ID
	 */
	public void setEid(String eid) {
		this.eid = eid;
	}


	/**
	 * �ʲ�������ȡ��
	 * @return �ʲ�������
	 */
	public String getCname() {
		return cname;
	}


	/**
	 * �ʲ��������趨
	 *
	 * @param cname �ʲ�������
	 */
	public void setCname(String cname) {
		this.cname = cname;
	}


	/**
	 * �ʲ�����˵��ȡ��
	 * @return �ʲ�����˵��
	 */
	public String getCdesc() {
		return cdesc;
	}


	/**
	 * �ʲ�����˵���趨
	 *
	 * @param cdesc �ʲ�����˵��
	 */
	public void setCdesc(String cdesc) {
		this.cdesc = cdesc;
	}


	/**
	 * �ʲ����õ�λȡ��
	 * @return �ʲ����õ�λ
	 */
	public String getCunit() {
		return cunit;
	}


	/**
	 * �ʲ����õ�λ�趨
	 *
	 * @param cunit �ʲ����õ�λ
	 */
	public void setCunit(String cunit) {
		this.cunit = cunit;
	}


	/**
	 * �ʲ�����״̬ȡ��
	 * @return �ʲ�����״̬
	 */
	public String getCstatus() {
		return cstatus;
	}


	/**
	 * �ʲ�����״̬�趨
	 *
	 * @param cstatus �ʲ�����״̬
	 */
	public void setCstatus(String cstatus) {
		this.cstatus = cstatus;
	}


	/**
	 * �ʲ�����˳��ȡ��
	 * @return �ʲ�����˳��
	 */
	public Integer getCseq() {
		return cseq;
	}


	/**
	 * �ʲ�����˳���趨
	 *
	 * @param cseq �ʲ�����˳��
	 */
	public void setCseq(Integer cseq) {
		this.cseq = cseq;
	}


	/**
	 * �ʲ�����ģ��ȡ��
	 * @return �ʲ�����ģ��
	 */
	public String getCcategory() {
		return ccategory;
	}


	/**
	 * �ʲ�����ģ���趨
	 *
	 * @param ccategory �ʲ�����ģ��
	 */
	public void setCcategory(String ccategory) {
		this.ccategory = ccategory;
	}


	/**
	 * �ʲ�����ȡֵ��Χȡ��
	 * @return �ʲ�����ȡֵ��Χ
	 */
	public String getCoption() {
		return coption;
	}


	/**
	 * �ʲ�����ȡֵ��Χ�趨
	 *
	 * @param coption �ʲ�����ȡֵ��Χ
	 */
	public void setCoption(String coption) {
		this.coption = coption;
	}


	/**
	 * �ʲ����ñ��ȡ��
	 * @return �ʲ����ñ��
	 */
	public String getClabel() {
		return clabel;
	}


	/**
	 * �ʲ����ñ���趨
	 *
	 * @param clabel �ʲ����ñ��
	 */
	public void setClabel(String clabel) {
		this.clabel = clabel;
	}


	/**
	 * �ʲ�ģ�ͱ��ȡ��
	 * @return �ʲ�ģ�ͱ��
	 */
	public String getElabel() {
		return elabel;
	}


	/**
	 * �ʲ�ģ�ͱ���趨
	 *
	 * @param elabel �ʲ�ģ�ͱ��
	 */
	public void setElabel(String elabel) {
		this.elabel = elabel;
	}


	/**
	 * �༭ģʽȡ��
	 * @return �༭ģʽ
	 */
	public String getMode() {
		return mode;
	}


	/**
	 * �༭ģʽ�趨
	 *
	 * @param mode �༭ģʽ
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}


	/**
	 * ����Ǩ�Ʊ�ʶȡ��
	 * @return ����Ǩ�Ʊ�ʶ
	 */
	public String getRoute() {
		return route;
	}


	/**
	 * ����Ǩ�Ʊ�ʶ�趨
	 *
	 * @param route ����Ǩ�Ʊ�ʶ
	 */
	public void setRoute(String route) {
		this.route = route;
	}

	/**
	 * �ʲ����ø�����ʶȡ��
	 * @return �ʲ����ø�����ʶ
	 */
	public String getCattach() {
		return cattach;
	}

	/**
	 * �ʲ����ø�����ʶ�趨
	 *
	 * @param cattach �ʲ����ø�����ʶ
	 */
	public void setCattach(String cattach) {
		this.cattach = cattach;
	}

	/**
	 * �ʲ�ȡֵ��Χ����ȡ��
	 * @return �ʲ�ȡֵ��Χ����
	 */
	public String getRangename() {
		return rangename;
	}

	/**
	 * �ʲ�ȡֵ��Χ�����趨
	 *
	 * @param rangename �ʲ�ȡֵ��Χ����
	 */
	public void setRangename(String rangename) {
		this.rangename = rangename;
	}

	/**
	 * �ʲ�����ֵ����ģ������
	 * @return �ʲ�ȡֵ��Χ����
	 */
	public String getCename() {
		return cename;
	}

	/**
	 * �ʲ�����ֵ����ģ�������趨
	 *
	 * @param rangename �ʲ�����ֵ����ģ������
	 */
	public void setCename(String cename) {
		this.cename = cename;
	}

	/**
	 * �ʲ�����ֵ����ģ�Ͳ����
	 * @return �ʲ�����ֵ����ģ�Ͳ����
	 */
	public String getCesyscoding() {
		return cesyscoding;
	}

	/**
	 * �ʲ�����ֵ����ģ�Ͳ�����趨
	 *
	 * @param rangename �ʲ�����ֵ����ģ�Ͳ����
	 */
	public void setCesyscoding(String cesyscoding) {
		this.cesyscoding = cesyscoding;
	}

	public String getCrequired() {
		return crequired;
	}

	public void setCrequired(String crequired) {
		this.crequired = crequired;
	}

	public Integer getCorder() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
