package com.deliverik.framework.asset.model.condition;

import java.util.List;

/**
 * �ʲ���Ϣ��������ʵ��
 * 
 */
public class IG013SearchCondImpl implements IG013SearchCond {

	/** �ʲ�ģ��ID */
	protected String eid;
	
	/** �ʲ���� */
	protected String eilabel;
	
	/** �ʲ����� */
	protected String einame;
	
	/** �ʲ��汾�� */
	protected Integer eiversion;
	
	/** �ʲ�С�汾*/
	protected Integer eismallversion;
	
	/** �ʲ�������������� */
	protected String eiorgsyscoding;
	
	/** �ʲ�ID��ƽ̨������ */
	protected String eiid;
	
	protected List<String> eilabel_list;
	
	/** �ʲ����ƣ���ȫƥ�� ��*/
	protected String einame_equal;
	
	
	/**
	 * �ʲ����ƣ���ȫƥ�� ��ȡ��
	 * @return �ʲ����ƣ���ȫƥ�� ��
	 */
	public String getEiname_equal() {
		return einame_equal;
	}

	/**
	 * �ʲ����ƣ���ȫƥ�� ���趨
	 *
	 * @param einame_equal �ʲ����ƣ���ȫƥ�� ��
	 */
	public void setEiname_equal(String einame_equal) {
		this.einame_equal = einame_equal;
	}

	public List<String> getEilabel_list() {
		return eilabel_list;
	}

	public void setEilabel_list(List<String> eilabel_list) {
		this.eilabel_list = eilabel_list;
	}

	/**
	 * �ʲ�IDȡ��
	 * @return �ʲ�ID
	 */
	public String getEiid() {
		return eiid;
	}

	/**
	 * �ʲ�ID�趨
	 *
	 * @param eiid �ʲ�ID
	 */
	public void setEiid(String eiid) {
		this.eiid = eiid;
	}

	/**
	 * �ʲ��������������ȡ��
	 * @return �ʲ��������������
	 */
	public String getEiorgsyscoding() {
		return eiorgsyscoding;
	}
	/**
	 * �ʲ���������������趨
	 *
	 * @param eiorgsyscoding �ʲ��������������
	 */
	public void setEiorgsyscoding(String eiorgsyscoding) {
		this.eiorgsyscoding = eiorgsyscoding;
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
	 * �ʲ����ȡ��
	 * @return �ʲ����
	 */
	public String getEilabel() {
		return eilabel;
	}

	/**
	 * �ʲ�����趨
	 *
	 * @param eilabel �ʲ����
	 */
	public void setEilabel(String eilabel) {
		this.eilabel = eilabel;
	}

	/**
	 * �ʲ�����ȡ��
	 * @return �ʲ�����
	 */
	public String getEiname() {
		return einame;
	}


	/**
	 * �ʲ������趨
	 *
	 * @param einame �ʲ�����
	 */
	public void setEiname(String einame) {
		this.einame = einame;
	}

	/**
	 * �ʲ��汾��ȡ��
	 * @return �ʲ��汾��
	 */
	public Integer getEiversion() {
		return eiversion;
	}

	/**
	 * �ʲ��汾���趨
	 *
	 * @param eiversion �ʲ��汾��
	 */
	public void setEiversion(Integer eiversion) {
		this.eiversion = eiversion;
	}
	
	/**
	 * �ʲ�С�汾ȡ��
	 * @return �ʲ�С�汾
	 */
	public Integer getEismallversion() {
		return eismallversion;
	}
	
	/**
	 * �ʲ�С�汾�趨
	 *
	 * @param eismallversion �ʲ�С�汾
	 */
	public void setEismallversion(Integer eismallversion) {
		this.eismallversion = eismallversion;
	}
}
