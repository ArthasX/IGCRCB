/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.model.condition;

/**
  * ����: SOC0107VW��������ʵ��
  * ��������: SOC0107VW��������ʵ��
  * ������¼: 2016/06/21
  * �޸ļ�¼: 
  */
public class SOC0107VWSearchCondImpl implements
		SOC0107VWSearchCond {
	/** ���ݿ�ID */
	protected Integer id;
	
	/** �ʲ�ID */
	protected String eiid;

	/** �ʲ�ģ��ID */
	protected String eid;
	
	/** �ʲ����԰汾�� */
	protected String civersion;
	
	/** �ʲ�ģ������ID */
	protected String cid;
	
	/** �ʲ�ģ������ֵ */
	protected String civalue;

	/** �ʲ�����С�汾��*/
	protected String cismallversion;
	
	protected String[]  cids;
	
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * �ʲ�ģ������IDȡ��
	 * @return �ʲ�ģ������ID
	 */
	public String getCid() {
		return cid;
	}

	/**
	 * �ʲ�ģ������ID�趨
	 *
	 * @param cid �ʲ�ģ������ID
	 */
	public void setCid(String cid) {
		this.cid = cid;
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
	 * �ʲ����԰汾��ȡ��
	 * @return �ʲ����԰汾��
	 */
	public String getCiversion() {
		return civersion;
	}

	/**
	 * �ʲ����԰汾���趨
	 *
	 * @param civersion �ʲ����԰汾��
	 */
	public void setCiversion(String civersion) {
		this.civersion = civersion;
	}
	
	/**
	 * �ʲ�ģ������ֵȡ��
	 * @return �ʲ�ģ������ֵ
	 */
	public String getCivalue() {
		return civalue;
	}

	/**
	 * �ʲ�ģ������ֵ�趨
	 * @param civalue �ʲ�ģ������ֵ
	 */
	public void setCivalue(String civalue) {
		this.civalue = civalue;
	}
	
	/**
	 * �ʲ�����С�汾��ȡ��
	 * @return �ʲ�����С�汾��
	 */
	public String getCismallversion() {
		return cismallversion;
	}
	/**
	 * �ʲ�����С�汾���趨
	 *
	 * @param cismallversion �ʲ�����С�汾��
	 */
	public void setCismallversion(String cismallversion) {
		this.cismallversion = cismallversion;
	}

	public String[] getCids() {
		return cids;
	}

	public void setCids(String[] cids) {
		this.cids = cids;
	}
}