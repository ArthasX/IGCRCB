/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.dbm.form;

import com.deliverik.framework.base.BaseForm;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ������ȡForm
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGDBM1200Form extends BaseForm{

	/** ���̶���ID */
	protected String prpdid;
	
	/** ���̷���ʱ�� */
	protected String propentime_like;
	
	/** ���̹ر�ʱ��*/
	protected String prclosetime_like;
	
	/** ����״̬ */
	protected String prstatus;
	
	/** �����˴���״̬*/
	protected String ppstatus;
	
	/** ��չ���� */
	protected String other;
	
	/** �·� */
	protected String month;
	
	/** ����δ�رձ�ʶ */
	protected String prActive;
	
	/** ������ */
	protected String[] varnames;
	
	/** ��ֵ */
	protected String[] varvalues;
	
	/** ����ʵ�ʼ��ʱ�� */
	protected String rcrrealtime_like;
	
	/** ���ռ������ */
	protected String rcclass;
	
	/** ��鷽ʽ  */
	protected String rcrtestmode;
	
	/** ���̴����û�ID */
	protected String ppuserid;
	
	/**�ʲ������*/
	protected String esyscoding;

	/** ��������ֵ */
	protected String pivarvalue;
	
	/** ����&�ʲ�ID */
	protected String countid;
	
	/** ����&�ʲ����� */
	protected String type;
	/**���̹رձ�ʶ*/
	protected String prclose;
	
	/** ���̼���*/
	protected String prid_in;
	
	/** �Ƿ�Ϊ�澯�¼� 1Ϊ�� 0Ϊ��*/
	protected String alarm_Is;
	
	/** ���Ƿ��Ѿ�ȷ��1Ϊ��0Ϊ��*/
	protected String ppbacktime_isNull;
	
	/**
	 * ���̶���IDȡ��
	 * @return prpdid ���̶���ID
	 */
	public String getPrpdid() {
		return prpdid;
	}

	/**
	 * ���̶���ID�趨
	 * @param prpdid ���̶���ID
	 */
	public void setPrpdid(String prpdid) {
		this.prpdid = prpdid;
	}

	/**
	 * ���̷���ʱ��ȡ��
	 * @return propentime_like ���̷���ʱ��
	 */
	public String getPropentime_like() {
		return propentime_like;
	}

	/**
	 * ���̷���ʱ���趨
	 * @param propentime_like ���̷���ʱ��
	 */
	public void setPropentime_like(String propentime_like) {
		this.propentime_like = propentime_like;
	}

	/**
	 * ����״̬ȡ��
	 * @return prstatus ����״̬
	 */
	public String getPrstatus() {
		return prstatus;
	}

	/**
	 * ����״̬�趨
	 * @param prstatus ����״̬
	 */
	public void setPrstatus(String prstatus) {
		this.prstatus = prstatus;
	}
	
	/**�����˴���״̬ȡ��
	 * @return the ppstatus
	 */
	public String getPpstatus() {
		return ppstatus;
	}

	/**�����˴���״̬�趨
	 * @param ppstatus the ppstatus to set
	 */
	public void setPpstatus(String ppstatus) {
		this.ppstatus = ppstatus;
	}
	
	/**
	 * ��չ����ȡ��
	 * @return other ��չ����
	 */
	public String getOther() {
		return other;
	}

	/**
	 * ��չ�����趨
	 * @param other ��չ����
	 */
	public void setOther(String other) {
		this.other = other;
	}

	/**
	 * �·�ȡ��
	 * @return month �·�
	 */
	public String getMonth() {
		return month;
	}

	/**
	 * �·��趨
	 * @param month �·�
	 */
	public void setMonth(String month) {
		this.month = month;
	}

	/**
	 * ����δ�رձ�ʶȡ��
	 * @return prActive ����δ�رձ�ʶ
	 */
	public String getPrActive() {
		return prActive;
	}

	/**
	 * ����δ�رձ�ʶ�趨
	 * @param prActive ����δ�رձ�ʶ
	 */
	public void setPrActive(String prActive) {
		this.prActive = prActive;
	}

	/**
	 * ������ȡ��
	 * @return varnames ������
	 */
	public String[] getVarnames() {
		return varnames;
	}

	/**
	 * �������趨
	 * @param varnames ������
	 */
	public void setVarnames(String[] varnames) {
		this.varnames = varnames;
	}

	/**
	 * ��ֵȡ��
	 * @return varvalues ��ֵ
	 */
	public String[] getVarvalues() {
		return varvalues;
	}

	/**
	 * ��ֵ�趨
	 * @param varvalues ��ֵ
	 */
	public void setVarvalues(String[] varvalues) {
		this.varvalues = varvalues;
	}

	/**
	 * ����ʵ�ʼ��ʱ��ȡ��
	 * @return rcrrealtime_like ����ʵ�ʼ��ʱ��
	 */
	public String getRcrrealtime_like() {
		return rcrrealtime_like;
	}

	/**
	 * ����ʵ�ʼ��ʱ���趨
	 * @param rcrrealtime_like ����ʵ�ʼ��ʱ��
	 */
	public void setRcrrealtime_like(String rcrrealtime_like) {
		this.rcrrealtime_like = rcrrealtime_like;
	}

	/**
	 * ���ռ������ȡ��
	 * @return rcclass ���ռ������
	 */
	public String getRcclass() {
		return rcclass;
	}

	/**
	 * ���ռ�������趨
	 * @param rcclass ���ռ������
	 */
	public void setRcclass(String rcclass) {
		this.rcclass = rcclass;
	}

	/**
	 * ��鷽ʽȡ��
	 * @return rcrtestmode ��鷽ʽ
	 */
	public String getRcrtestmode() {
		return rcrtestmode;
	}

	/**
	 * ��鷽ʽ�趨
	 * @param rcrtestmode ��鷽ʽ
	 */
	public void setRcrtestmode(String rcrtestmode) {
		this.rcrtestmode = rcrtestmode;
	}

	/**
	 * ���̴����û�IDȡ��
	 * @return ppuserid ���̴����û�ID
	 */
	public String getPpuserid() {
		return ppuserid;
	}

	/**
	 * ���̴����û�ID�趨
	 * @param ppuserid ���̴����û�ID
	 */
	public void setPpuserid(String ppuserid) {
		this.ppuserid = ppuserid;
	}

	/**
	 * �ʲ������   ȡ��
	 * @return esyscoding_like �ʲ������
	 */
	public String getEsyscoding() {
		return esyscoding;
	}

	/**
	 * �ʲ������   �趨
	 * @param esyscoding_like �ʲ������
	 */
	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCountid() {
		return countid;
	}

	public void setCountid(String countid) {
		this.countid = countid;
	}
	
	

	/**
	 * ���̹ر�ʱ��ȡ��
	 * @return the prclosetime_like
	 */
	public String getPrclosetime_like() {
		return prclosetime_like;
	}

	/**
	 * ���̹ر�ʱ���趨
	 * @param prclosetime_like the prclosetime_like to set
	 */
	public void setPrclosetime_like(String prclosetime_like) {
		this.prclosetime_like = prclosetime_like;
	}

	public String getPivarvalue() {
		return pivarvalue;
	}

	public void setPivarvalue(String pivarvalue) {
		this.pivarvalue = pivarvalue;
	}

	/**
	 * ���̹رձ�ʶ   ȡ��
	 * @return prclose ���̹رձ�ʶ
	 */
	public String getPrclose() {
		return prclose;
	}

	/**
	 * ���̹رձ�ʶ   �趨
	 * @param prclose ���̹رձ�ʶ
	 */
	public void setPrclose(String prclose) {
		this.prclose = prclose;
	}

	/**
	 * ���̼��ϻ�ȡ
	 * @return the prid_in
	 */
	public String getPrid_in() {
		return prid_in;
	}

	/**
	 * ���̼����趨
	 * @param prid_in
	 */
	public void setPrid_in(String prid_in) {
		this.prid_in = prid_in;
	}

	/**
	 * �Ƿ�Ϊ�澯�¼�1Ϊ��0Ϊ���ȡ
	 * @return the alarm_Is
	 */
	public String getAlarm_Is() {
		return alarm_Is;
	}

	/**
	 * �Ƿ�Ϊ�澯�¼�1Ϊ��0Ϊ���趨
	 * @param alarm_Is
	 */
	public void setAlarm_Is(String alarm_Is) {
		this.alarm_Is = alarm_Is;
	}

	/**
	 * ���Ƿ��Ѿ�ȷ��1Ϊ��0Ϊ�ǻ�ȡ
	 * @return the ppbacktime_isNull
	 */
	public String getPpbacktime_isNull() {
		return ppbacktime_isNull;
	}

	/**
	 * ���Ƿ��Ѿ�ȷ��1Ϊ��0Ϊ���趨
	 * @param ppbacktime_isNull
	 */
	public void setPpbacktime_isNull(String ppbacktime_isNull) {
		this.ppbacktime_isNull = ppbacktime_isNull;
	}
	
}
