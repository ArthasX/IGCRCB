package com.deliverik.infogovernor.soc.aut.form;

import java.util.List;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.soc.asset.model.condition.SOC0124SearchCond;

/**
 * �ʲ����ѯHELP������FORM
 * IGCOM0302Form ActionForm
 */
public class IGAUT0201Form extends BaseForm implements SOC0124SearchCond{

	private static final long serialVersionUID = 1L;

	/** �ʲ�ģ�ͱ�� */
	protected String elabel;
	
	/** �ʲ����� */
	protected String eilabel;
	
	/** �ʲ������� */
	protected String einame;
	
	/** �ʲ�ģ�ͷ��� */
	protected String ecategory;
	
	/** �ʲ�ģ��һ������ */
	protected String ekey1;
	
	/** �ʲ�ģ�Ͷ������� */
	protected String ekey2;
	
	/** �ʲ�����ʱ��FROM */
	protected String eiupdtime_from;
	
	/** �ʲ�����ʱ��TO */
	protected String eiupdtime_to;
	
	/** �ʲ�����������*/
	public String eiorgsyscoding;
	
	/** �ʲ���������������*/
	public String eiorgname;
	
	public String eistatus;
	
	/** �ʲ�ģ���� */
	protected String ename;
	
	/** ģ�Ͳ���� */
	protected String esyscoding;
	
	/** ��ʼ������� */
	protected String esyscodingbegin;
	
	/** ��ѡ��ѡ��ID */
	protected String[] selectId;
	
	/** �ʲ�ʹ�û���code*/
	public String usesyscoding;
	
	/** ά�������ղ�ѯ��ʼʱ�� */
	public String wbdate_from;
	/** ά�������ղ�ѯ����ʱ�� */
	public String wbdate_to;
	
	/** ��̬��ID */
	protected String pidid;
	
	protected boolean flag;
	
	/** �ʲ�����2��ʼʱ�� */
	protected String eiupdtime_from2;
	
	/** �ʲ�����2��ֹʱ�� */
	protected String eiupdtime_to2;
	protected String useorgname;
	
	/** ��ѯ����ʵ���ʶ*/
	protected boolean topCiFlag;
	
	public boolean isTopCiFlag() {
		return topCiFlag;
	}

	public void setTopCiFlag(boolean topCiFlag) {
		this.topCiFlag = topCiFlag;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public String getUsesyscoding() {
		return usesyscoding;
	}

	public void setUsesyscoding(String usesyscoding) {
		this.usesyscoding = usesyscoding;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}

	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}

	public void setEistatus(String eistatus) {
		this.eistatus = eistatus;
	}

	public String getEistatus() {
		return eistatus;
	}

	public String getEiorgsyscoding() {
		return eiorgsyscoding;
	}

	public void setEiorgsyscoding(String eiorgsyscoding) {
		this.eiorgsyscoding = eiorgsyscoding;
	}

	public String getEiorgname() {
		return eiorgname;
	}

	public void setEiorgname(String eiorgname) {
		this.eiorgname = eiorgname;
	}

	/**
	 * �ʲ�ģ�ͱ���ȡ��
	 * @return �ʲ�ģ�ͱ���
	 */
	public String getElabel() {
		return elabel;
	}

	/**
	 * �ʲ�ģ�ͱ����趨
	 *
	 * @param elabel �ʲ�ģ�ͱ���
	 */
	public void setElabel(String elabel) {
		this.elabel = elabel;
	}

	/**
	 * �ʲ������ȡ��
	 * @return �ʲ������
	 */
	public String getEilabel() {
		return eilabel;
	}

	/**
	 * �ʲ�������趨
	 *
	 * @param eilabel �ʲ������
	 */
	public void setEilabel(String eilabel) {
		this.eilabel = eilabel;
	}

	/**
	 * �ʲ�������ȡ��
	 * @return �ʲ�������
	 */
	public String getEiname() {
		return einame;
	}

	/**
	 * �ʲ��������趨
	 *
	 * @param einame �ʲ�������
	 */
	public void setEiname(String einame) {
		this.einame = einame;
	}

	/**
	 * �ʲ�ģ�ͷ���ȡ��
	 * @return �ʲ�ģ�ͷ���
	 */
	public String getEcategory() {
		return ecategory;
	}

	/**
	 * �ʲ�ģ�ͷ����趨
	 *
	 * @param ecategory �ʲ�ģ�ͷ���
	 */
	public void setEcategory(String ecategory) {
		this.ecategory = ecategory;
	}

	/**
	 * �ʲ�ģ��һ������ȡ��
	 * @return �ʲ�ģ��һ������
	 */
	public String getEkey1() {
		return ekey1;
	}

	/**
	 * �ʲ�ģ��һ�������趨
	 *
	 * @param ekey1 �ʲ�ģ��һ������
	 */
	public void setEkey1(String ekey1) {
		this.ekey1 = ekey1;
	}

	/**
	 * �ʲ�ģ�Ͷ�������ȡ��
	 * @return �ʲ�ģ�Ͷ�������
	 */
	public String getEkey2() {
		return ekey2;
	}

	/**
	 * �ʲ�ģ�Ͷ��������趨
	 *
	 * @param ekey1 �ʲ�ģ�Ͷ�������
	 */
	public void setEkey2(String ekey2) {
		this.ekey2 = ekey2;
	}

	/**
	 * �ʲ������ʱ��FROMȡ��
	 * @return �ʲ������ʱ��FROM
	 */
	public String getEiupdtime_from() {
		return eiupdtime_from;
	}

	/**
	 * �ʲ������ʱ��FROM�趨
	 *
	 * @param eiupdtime_from �ʲ������ʱ��FROM
	 */
	public void setEiupdtime_from(String eiupdtime_from) {
		this.eiupdtime_from = eiupdtime_from;
	}

	/**
	 * �ʲ������ʱ��TOȡ��
	 * @return �ʲ������ʱ��TO
	 */
	public String getEiupdtime_to() {
		return eiupdtime_to;
	}

	/**
	 * �ʲ������ʱ��TO�趨
	 *
	 * @param eiupdtime_to �ʲ������ʱ��TO
	 */
	public void setEiupdtime_to(String eiupdtime_to) {
		this.eiupdtime_to = eiupdtime_to;
	}
	
	public String getEname() {
		return ename;
	}

	public String getEsyscoding() {
		return esyscoding;
	}
	
	public String[] getCivalue() {
		// TODO Auto-generated method stub
		return null;
	}

	public String[] getCname() {
		// TODO Auto-generated method stub
		return null;
	}

	public String[] getCcivalue() {
		return null;
	}

	public String[] getCclabel() {
		return null;
	}

	public String getEiorgsyscoding_q() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getEsyscodingbegin() {
		return esyscodingbegin;
	}

	public void setEsyscodingbegin(String esyscodingbegin) {
		this.esyscodingbegin = esyscodingbegin;
	}

	public String getEistatus_q() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getEiorgcode() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * ��ѡ��ѡ��IDȡ��
	 * @return ��ѡ��ѡ��ID
	 */
	public String[] getSelectId() {
		return selectId;
	}

	/**
	 * ��ѡ��ѡ��ID�趨
	 *
	 * @param selectId ��ѡ��ѡ��ID
	 */
	public void setSelectId(String[] selectId) {
		this.selectId = selectId;
	}

	public List<String> getEiidList() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getWbdate_from() {
		return wbdate_from;
	}

	public void setWbdate_from(String wbdate_from) {
		this.wbdate_from = wbdate_from;
	}

	public String getWbdate_to() {
		return wbdate_to;
	}

	public void setWbdate_to(String wbdate_to) {
		this.wbdate_to = wbdate_to;
	}

	/**
	 * ��̬��IDȡ��
	 * @return ��̬��ID
	 */
	public String getPidid() {
		return pidid;
	}

	/**
	 * ��̬��ID�趨
	 * @param pidid ��̬��ID
	 */
	public void setPidid(String pidid) {
		this.pidid = pidid;
	}
	
	

	/* (non-Javadoc)
	 * @see com.deliverik.framework.asset.model.condition.EntityItemVWSearchCond#getEirootmark_eq()
	 */
	public Integer getEirootmark_eq() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getTopCI() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @return the �ʲ�����2��ʼʱ��
	 */
	public String getEiupdtime_from2() {
		return eiupdtime_from2;
	}

	/**
	 * @param �ʲ�����2��ʼʱ�� the eiupdtime_from2 to set
	 */
	public void setEiupdtime_from2(String eiupdtime_from2) {
		this.eiupdtime_from2 = eiupdtime_from2;
	}

	/**
	 * @return the �ʲ�����2��ֹʱ��
	 */
	public String getEiupdtime_to2() {
		return eiupdtime_to2;
	}

	/**
	 * @param �ʲ�����2��ֹʱ�� the eiupdtime_to2 to set
	 */
	public void setEiupdtime_to2(String eiupdtime_to2) {
		this.eiupdtime_to2 = eiupdtime_to2;
	}

	public String getUseorgname() {
		return useorgname;
	}

	public void setUseorgname(String useorgname) {
		this.useorgname = useorgname;
	}

	/* (non-Javadoc)
	 * @see com.deliverik.framework.soc.asset.model.condition.SOC0124SearchCond#getIp()
	 */
	public String getIp() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getAssetNumber() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getIpAddress() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getAote() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDeviceType() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getLifeCycle() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<String> getEiidNotInList() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPayee() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getAmount() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isUpgrade() {
		// TODO Auto-generated method stub
		return false;
	}

	public String getEiinsdate_gt() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getEiinsdate_lt() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getEiusername() {
		// TODO Auto-generated method stub
		return null;
	}

}
