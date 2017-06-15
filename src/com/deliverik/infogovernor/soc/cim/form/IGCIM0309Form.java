/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.soc.cim.form;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.soc.asset.model.condition.SOC0129SearchCond;

/**
 * ����: �豸��ϸ��ϢForm
 * ��������: �豸��ϸ��ϢForm
 * ������¼: 2011/05/19
 * �޸ļ�¼: 
 */
public class IGCIM0309Form extends BaseForm implements SOC0129SearchCond{
	private static final long serialVersionUID = 1L;
	
	/** �豸ID */
	protected String eiid;
	
	/** �豸˵�� */
	protected String eidesc;
	
	/** �豸״̬ */
	protected String eistatus;
	
	/** �豸������������ */
	protected String eiorgsyscoding;
	
	/** ģ�Ͳ���� */
	protected String esyscoding_q;
	
	/** �豸������������ */
	protected String eiorgname;
	
	/** �豸����ֵ */
	protected String[] civalue;
	
	/** �ʲ�ģ����������ֵ */
	protected String[] entityItemCivalue;
	
	/** �������Ա�ʶ */
	protected String[] civalue_bak;
	
	/** ȡֵ��Χ�������� */
	protected Map<Integer, List<LabelValueBean>> selectedListMap = new HashMap<Integer, List<LabelValueBean>>();

	
	
	
	
	/**
	 * �豸����ֵȡ��
	 * @return �豸����ֵ
	 */
	public String[] getCivalue() {
		return civalue;
	}

	/**
	 * �豸����ֵ�趨
	 * @param civalue�豸����ֵ
	 */
	public void setCivalue(String[] civalue) {
		this.civalue = civalue;
	}

	/**
	 * �ʲ�ģ����������ֵȡ��
	 * @return �ʲ�ģ����������ֵ
	 */
	public String[] getEntityItemCivalue() {
		return entityItemCivalue;
	}

	/**
	 * �ʲ�ģ����������ֵ�趨
	 * @param entityItemCivalue�ʲ�ģ����������ֵ
	 */
	public void setEntityItemCivalue(String[] entityItemCivalue) {
		this.entityItemCivalue = entityItemCivalue;
	}

	/**
	 * �������Ա�ʶȡ��
	 * @return �������Ա�ʶ 
	 */
	public String[] getCivalue_bak() {
		return civalue_bak;
	}

	/**
	 * �������Ա�ʶ�趨
	 * @param civalue_bak�������Ա�ʶ 
	 */
	public void setCivalue_bak(String[] civalue_bak) {
		this.civalue_bak = civalue_bak;
	}

	/**
	 * �豸IDȡ��
	 */
	public String getEiid() {
		return eiid;
	}

	/**
	 * �豸ID�趨
	 * @param eiid�豸ID
	 */
	public void setEiid(String eiid) {
		this.eiid = eiid;
	}
	
	/**
	 * ȡֵ��Χ��������ȡ��
	 * @return ȡֵ��Χ��������
	 */
	public Map<Integer, List<LabelValueBean>> getSelectedListMap() {
		return selectedListMap;
	}

	/**
	 * ȡֵ��Χ���������趨
	 * @param selectedListMapȡֵ��Χ��������
	 */
	public void setSelectedListMap(
			Map<Integer, List<LabelValueBean>> selectedListMap) {
		this.selectedListMap = selectedListMap;
	}

	/**
	 * �豸˵��ȡ��
	 * @return �豸˵��
	 */
	public String getEidesc() {
		return eidesc;
	}

	/**
	 * �豸˵���趨
	 * @param eidesc�豸˵��
	 */
	public void setEidesc(String eidesc) {
		this.eidesc = eidesc;
	}

	/**
	 * �豸״̬ȡ��
	 * @return �豸״̬
	 */
	public String getEistatus() {
		return eistatus;
	}

	/**
	 * �豸״̬�趨
	 * @param eistatus�豸״̬
	 */
	public void setEistatus(String eistatus) {
		this.eistatus = eistatus;
	}

	/**
	 * �豸������������ȡ��
	 * @return �豸������������
	 */
	public String getEiorgsyscoding() {
		return eiorgsyscoding;
	}

	/**
	 * �豸�������������趨
	 * @param eiorgsyscoding�豸������������
	 */
	public void setEiorgsyscoding(String eiorgsyscoding) {
		this.eiorgsyscoding = eiorgsyscoding;
	}

	/**
	 * ģ�Ͳ����ȡ��
	 * @return ģ�Ͳ����
	 */
	public String getEiorgname() {
		return eiorgname;
	}

	/**
	 * ģ�Ͳ�����趨
	 * @param eiorgnameģ�Ͳ����
	 */
	public void setEiorgname(String eiorgname) {
		this.eiorgname = eiorgname;
	}

	/**
	 * �豸������������ȡ��
	 */
	public String getEsyscoding_q() {
		return esyscoding_q;
	}
	
	/**
	 * �豸�������������趨
	 * @param esyscoding_q�豸������������
	 */
	public void setEsyscoding_q(String esyscoding_q) {
		this.esyscoding_q = esyscoding_q;
	}
	
	/**
	 * ȡֵ��Χ��������ȡ��
	 * @return ȡֵ��Χ��������
	 */
	public List<LabelValueBean> getSelectedListMap(int index) {
		return (List<LabelValueBean>) selectedListMap.get( new Integer( index ) );
	}

	/**
	 * ȡֵ��Χ���������趨
	 *
	 * @param selectedList ȡֵ��Χ��������
	 */
	public void setSelectedListMap(int index,List<LabelValueBean> selectedList) {
		selectedListMap.put(new Integer(index), selectedList);
	}
	public String getClabel_q() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getCname() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Integer> getEiid_list() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getSreilabel_q() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getSrname_q() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getEkey2() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.deliverik.framework.soc.asset.model.condition.SOC0129SearchCond#getCheckersion()
	 */
	public int getCheckersion() {
		// TODO Auto-generated method stub
		return 0;
	}

	public String getId() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
