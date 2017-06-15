package com.deliverik.framework.asset.model.condition;

/**
 * �ʲ�������Ϣ��������ʵ��
 * 
 */
public class IG800SearchCondImpl implements IG800SearchCond {

	/** �ʲ�ID */
	protected Integer eiid;

	/** �ʲ�ģ��ID */
	protected String eid;
	
	/** �ʲ����԰汾�� */
	protected String civersion;
	
	/** �ʲ�ģ������ID */
	protected Integer cid;
	
	/** �ʲ�ģ������ֵ */
	protected String civalue;

	/** �ʲ�����С�汾��*/
	protected String cismallversion;
	
	/**
	 * �ʲ�ģ������IDȡ��
	 * @return �ʲ�ģ������ID
	 */
	public Integer getCid() {
		if(cid==null){
			return 0;
		}
		return cid;
	}

	/**
	 * �ʲ�ģ������ID�趨
	 *
	 * @param cid �ʲ�ģ������ID
	 */
	public void setCid(Integer cid) {
		this.cid = cid;
	}

	/**
	 * �ʲ�IDȡ��
	 * @return �ʲ�ID
	 */
	public Integer getEiid() {
		return eiid;
	}

	/**
	 * �ʲ�ID�趨
	 *
	 * @param eiid �ʲ�ID
	 */
	public void setEiid(Integer eiid) {
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
	
}
