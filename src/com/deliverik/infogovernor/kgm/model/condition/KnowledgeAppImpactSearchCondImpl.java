/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.kgm.model.condition;

/**
 * 
 * @Description:֪ʶҵ��ϵͳ����Cond��
 * @Author
 * @History
 * @Version V1.0
 */
public class KnowledgeAppImpactSearchCondImpl implements KnowledgeAppImpactSearchCond {
	/**
	 *֪ʶID
	 */
	protected Integer knid;

	/**
	 *֪ʶIDȡ��
	 * 
	 * @return ֪ʶID
	 */
	public Integer getKnid() {
		return knid;
	}

	/**
	 *֪ʶID�趨
	 * 
	 * @param knid֪ʶID
	 */
	public void setKnid(Integer knid) {
		this.knid = knid;
	}

	/**
	 *ҵ��ϵͳCode
	 */
	protected String kaicode;

	/**
	 *ҵ��ϵͳCodeȡ��
	 * 
	 * @return ҵ��ϵͳCode
	 */
	public String getKaicode() {
		return kaicode;
	}

	/**
	 *ҵ��ϵͳCode�趨
	 * 
	 * @param kaicodeҵ��ϵͳCode
	 */
	public void setKaicode(String kaicode) {
		this.kaicode = kaicode;
	}

	/**
	 * ֪ʶ�汾
	 */
	protected Integer knversion;

	/**
	 * ֪ʶ�汾ȡ��
	 * @return ֪ʶ�汾
	 */
	public Integer getKnversion() {
		return knversion;
	}

	/**
	 * ֪ʶ�汾�趨
	 * @param knversion ֪ʶ�汾
	 */
	public void setKnversion(Integer knversion) {
		this.knversion = knversion;
	}
}
