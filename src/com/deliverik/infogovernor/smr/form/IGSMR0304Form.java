/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.smr.form;

import com.deliverik.framework.base.BaseForm;

/**
 * ����:ͨ����ʷ��ѯform 
 * ����������ͨ����ʷ��ѯform 
 * �����ˣ�����͢
 * ������¼�� 2013-08-14
 * �޸ļ�¼��
 */
@SuppressWarnings("serial")
public class IGSMR0304Form extends BaseForm {

	/** ���� */
	protected String prtype;
	
	/** ������ */
	protected String prtitle;
	
	/** ����ʱ�俪ʼ */
	protected String prstarttime;
	
	/** ����ʱ����� */
	protected String prclosetime;
	
	/** ������������ */
	private Integer[] prids;
	
	/** ���̶���ID���� */
    private String[] prpdids;
	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public String getPrtype() {
		return prtype;
	}
	/**
	 * �����趨
	 *
	 * @param rctype ����
	 */
	public void setPrtype(String prtype) {
		this.prtype = prtype;
	}
	/**
	 * ������ ȡ��
	 *
	 * @return ������ 
	 */
	public String getPrtitle() {
		return prtitle;
	}
	/**
	 * ������ �趨
	 *
	 * @param prtitle ������ 
	 */
	public void setPrtitle(String prtitle) {
		this.prtitle = prtitle;
	}
	/**
	 * ����ʱ�俪ʼȡ��
	 *
	 * @return ����ʱ�俪ʼ
	 */
	public String getPrstarttime() {
		return prstarttime;
	}
	/**
	 * ����ʱ�俪ʼ�趨
	 *
	 * @param prstarttime ����ʱ�俪ʼ 
	 */
	public void setPrstarttime(String prstarttime) {
		this.prstarttime = prstarttime;
	}
	/**
	 * ����ʱ�����ȡ��
	 *
	 * @return ����ʱ�����
	 */
	public String getPrclosetime() {
		return prclosetime;
	}
	/**
	 * ����ʱ������趨
	 *
	 * @param prclosetime ����ʱ�����
	 */
	public void setPrclosetime(String prclosetime) {
		this.prclosetime = prclosetime;
	}
	/**
	 * ������������ȡ��
	 * @return prids  ������������
	 */
	public Integer[] getPrids() {
		return prids;
	}
	/**
	 * �������������趨
	 * @param prids  ������������
	 */
	public void setPrids(Integer[] prids) {
		this.prids = prids;
	}
	/**
	 * ���̶���ID����ȡ��
	 * @return prpdids  ���̶���ID����
	 */
	public String[] getPrpdids() {
		return prpdids;
	}
	/**
	 * ���̶���ID�����趨
	 * @param prpdids  ���̶���ID����
	 */
	public void setPrpdids(String[] prpdids) {
		this.prpdids = prpdids;
	}
	
	
}
