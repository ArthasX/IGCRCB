/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.kgm.model.condition;

/**
 * ����: ֪ʶ���̹�����Ϣ��������ʵ��
 * ����������֪ʶ���̹�����Ϣ��������ʵ��
 * ������¼������ 2010/12/07
 * �޸ļ�¼��
 */
public class KnowledgeProcessSearchCondImpl implements
		KnowledgeProcessSearchCond {
	
	/** ֪ʶID */
	protected Integer knid;
	
	/** ֪ʶ�汾 */
	protected Integer knversion;
	
	/** ����ID */
	protected Integer prid;
	
	/** ���񹤵�ID */
	protected Integer sfid;
	
	/** �������� */
	protected String connecttype;
	
	/** �Ƿ���Ч��ʶ��0-��Ч��1-��Ч*/
	protected String kpEffect;
	
	/**
	 * ֪ʶIDȡ��
	 * 
	 * @return ֪ʶID
	 */
	public Integer getKnid() {
		return knid;
	}
	
	/**
	 * ֪ʶID�趨
	 * 
	 * @param knid֪ʶID
	 */
	public void setKnid(Integer knid) {
		this.knid = knid;
	}
	
	/**
	 * ֪ʶ�汾ȡ��
	 * @return ֪ʶ�汾
	 */
	public Integer getKnversion() {
		return knversion;
	}

	/**
	 * ֪ʶ�汾�趨
	 * @param knversion֪ʶ�汾
	 */
	public void setKnversion(Integer knversion) {
		this.knversion = knversion;
	}

	/**
	 * ����IDȡ��
	 * 
	 * @return ����ID
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * ����ID�趨
	 * 
	 * @param prid����ID
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}
	
	/**
	 * ���񹤵�IDȡ��
	 * 
	 * @return ���񹤵�ID
	 */
	public Integer getSfid() {
		return sfid;
	}

	/**
	 * ���񹤵�ID�趨
	 * 
	 * @param sfid���񹤵�ID
	 */
	public void setSfid(Integer sfid) {
		this.sfid = sfid;
	}

	/**
	 * ��������ȡ��
	 * 
	 * @return ��������
	 */
	public String getConnecttype() {
		return connecttype;
	}

	/**
	 * ���������趨
	 * 
	 * @param connecttype��������
	 */
	public void setConnecttype(String connecttype) {
		this.connecttype = connecttype;
	}

	/**
	 * ��Ч��ʶλȡ��
	 * @return ��Ч��ʶλ
	 */
	public String getKpEffect() {
		return kpEffect;
	}

	/**
	 * ��Ч��ʶλ�趨
	 * @param kpEffect ��Ч��ʶλ
	 */
	public void setKpEffect(String kpEffect) {
		this.kpEffect = kpEffect;
	}
	
}
