/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.kgm.model.condition;

/**
 * 
 * @Description:֪ʶ����Cond��
 * @Author
 * @History
 * @Version V1.0
 */
public class KnowledgeGradeSearchCondImpl implements KnowledgeGradeSearchCond {
	/**
	 *֪ʶ��key
	 */
	protected Integer knid;

	/**
	 *֪ʶ��keyȡ��
	 * 
	 * @return ֪ʶ��key
	 */
	public Integer getKnid() {
		return knid;
	}

	/**
	 *֪ʶ��key�趨
	 * 
	 * @param kgknid֪ʶ��key
	 */
	public void setKnid(Integer knid) {
		this.knid = knid;
	}

	/**
	 *����
	 */
	protected Integer kggrade;

	/**
	 *����ȡ��
	 * 
	 * @return ����
	 */
	public Integer getKggrade() {
		return kggrade;
	}

	/**
	 *�����趨
	 * 
	 * @param kggrade����
	 */
	public void setKggrade(Integer kggrade) {
		this.kggrade = kggrade;
	}

	/**
	 *֪ʶ������
	 */
	protected String kgappraise;

	/**
	 *֪ʶ������ȡ��
	 * 
	 * @return ֪ʶ������
	 */
	public String getKgappraise() {
		return kgappraise;
	}

	/**
	 *֪ʶ�������趨
	 * 
	 * @param kgappraise֪ʶ������
	 */
	public void setKgappraise(String kgappraise) {
		this.kgappraise = kgappraise;
	}

	/**
	 *������
	 */
	protected String kguserid;

	/**
	 *������ȡ��
	 * 
	 * @return ������
	 */
	public String getKguserid() {
		return kguserid;
	}

	/**
	 *�������趨
	 * 
	 * @param kguseid������
	 */
	public void setKguserid(String kguserid) {
		this.kguserid = kguserid;
	}

	/**
	 *����ʱ��
	 */
	protected String kgtime;

	/**
	 *����ʱ��ȡ��
	 * 
	 * @return ����ʱ��
	 */
	public String getKgtime() {
		return kgtime;
	}

	/**
	 *����ʱ���趨
	 * 
	 * @param kgtime����ʱ��
	 */
	public void setKgtime(String kgtime) {
		this.kgtime = kgtime;
	}
}
