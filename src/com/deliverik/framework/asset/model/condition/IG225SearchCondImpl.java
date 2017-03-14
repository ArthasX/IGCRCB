package com.deliverik.framework.asset.model.condition;

import java.util.List;

/**
 * �ʲ�ģ��������Ϣ��������ʵ��
 * 
 */
public class IG225SearchCondImpl implements IG225SearchCond {

	/** �ʲ�ģ��ID */
	protected String eid;
	
	/** �ʲ�ģ�����Ա�ţ�ƽ̨������ */
	protected String clabel;
	
	/** �ʲ�ģ���������� */
	protected String cname;
	
	/** �ʲ�ģ���������� */
	protected String ccategory;
	
	/** �ʲ�ģ������״̬��1���ã�2ͣ�ã� */
	protected String cstatus;
	
	/** �ʲ�ģ�������Ƿ���ʾ��ʶ��ƽ̨������1��ʾ��0��ʾ�� */
	protected Integer cseq;
	
	/** �ʲ�ģ�Ͳ�����������������ƽ̨������ */
	protected List<String> esyscodingList;
	
	/** �ʲ�ģ���������������������ƽ̨������ */
	protected List<String> cattachList;

	/** clabel�ֶι��ˣ�����ʾ�������� */
	protected String[] filterlabel; 
	
	/**
	 * �ʲ�ģ�������������������ȡ��
	 * @return �ʲ�ģ�������������������
	 */
	public List<String> getCattachList() {
		return cattachList;
	}

	/**
	 * �ʲ�ģ��������������������趨
	 *
	 * @param cattachList �ʲ�ģ�������������������
	 */
	public void setCattachList(List<String> cattachList) {
		this.cattachList = cattachList;
	}

	/**
	 * �ʲ�ģ�Ͳ���������������ȡ��
	 * @return �ʲ�ģ�Ͳ���������������
	 */
	public List<String> getEsyscodingList() {
		return esyscodingList;
	}

	/**
	 * �ʲ�ģ�Ͳ����������������趨
	 *
	 * @param esyscodingList �ʲ�ģ�Ͳ���������������
	 */
	public void setEsyscodingList(List<String> esyscodingList) {
		this.esyscodingList = esyscodingList;
	}

	/**
	 * �ʲ�ģ�����Ա��ȡ��
	 * @return �ʲ�ģ�����Ա��
	 */
	public String getClabel() {
		return clabel;
	}

	/**
	 * �ʲ�ģ�����Ա���趨
	 *
	 * @param clabel �ʲ�ģ�����Ա��
	 */
	public void setClabel(String clabel) {
		this.clabel = clabel;
	}

	/**
	 * �ʲ�ģ����������ȡ��
	 * @return �ʲ�ģ����������
	 */
	public String getCname() {
		return cname;
	}

	/**
	 * �ʲ�ģ�����������趨
	 *
	 * @param cname �ʲ�ģ����������
	 */
	public void setCname(String cname) {
		this.cname = cname;
	}

	/**
	 * �ʲ�ģ����������ȡ��
	 * @return �ʲ�ģ����������
	 */
	public String getCcategory() {
		return ccategory;
	}

	/**
	 * �ʲ�ģ�����������趨
	 *
	 * @param ccategory �ʲ�ģ����������
	 */
	public void setCcategory(String ccategory) {
		this.ccategory = ccategory;
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
	 * �ʲ�ģ������״̬ȡ��
	 * @return �ʲ�ģ������״̬
	 */
	public String getCstatus() {
		return cstatus;
	}

	/**
	 * �ʲ�ģ������״̬�趨
	 *
	 * @param cstatus �ʲ�ģ������״̬
	 */
	public void setCstatus(String cstatus) {
		this.cstatus = cstatus;
	}

	/**
	 * �ʲ�ģ�������Ƿ���ʾ��ʶȡ��
	 * @return �ʲ�ģ�������Ƿ���ʾ��ʶ
	 */
	public Integer getCseq() {
		return cseq;
	}

	/**
	 * �ʲ�ģ�������Ƿ���ʾ��ʶ�趨
	 *
	 * @param cseq �ʲ�ģ�������Ƿ���ʾ��ʶ
	 */
	public void setCseq(Integer cseq) {
		this.cseq = cseq;
	}
	
	/**
	 * clabel�ֶι�����Ϣȡ��
	 * @return clabel�ֶι�����Ϣ��ʶ
	 */
	public String[] getFilterlabel() {
		return filterlabel;
	}
	
	/**
	 * clabel�ֶι�����Ϣ�趨
	 *
	 * @param cseq clabel�ֶι�����Ϣ�趨
	 */
	public void setFilterlabel(String[] filterlabel) {
		this.filterlabel = filterlabel;
	}
}
