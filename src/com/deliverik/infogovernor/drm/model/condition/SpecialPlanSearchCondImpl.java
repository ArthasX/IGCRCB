/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.drm.model.condition;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ר��Ԥ����ѯ����ʵ��
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class SpecialPlanSearchCondImpl implements SpecialPlanSearchCond{

	/** Ԥ������ģ��ƥ�� */
	protected String einame_like;
	
	/** ҵ��ϵͳID */
	protected Integer usinessSystemId;
	
	/** ����ID */
	protected Integer sceneId;
	
	/** Ӧ����ԴID */
	protected Integer drmResourceId;

	/**
	 * Ԥ������ģ��ƥ��ȡ��
	 * @return einame_like Ԥ������ģ��ƥ��
	 */
	public String getEiname_like() {
		return einame_like;
	}

	/**
	 * Ԥ������ģ��ƥ���趨
	 * @param einame_like Ԥ������ģ��ƥ��
	 */
	public void setEiname_like(String einame_like) {
		this.einame_like = einame_like;
	}

	/**
	 * ҵ��ϵͳIDȡ��
	 * @return usinessSystemId ҵ��ϵͳID
	 */
	public Integer getUsinessSystemId() {
		return usinessSystemId;
	}

	/**
	 * ҵ��ϵͳID�趨
	 * @param usinessSystemId ҵ��ϵͳID
	 */
	public void setUsinessSystemId(Integer usinessSystemId) {
		this.usinessSystemId = usinessSystemId;
	}

	/**
	 * ����IDȡ��
	 * @return sceneId ����ID
	 */
	public Integer getSceneId() {
		return sceneId;
	}

	/**
	 * ����ID�趨
	 * @param sceneId ����ID
	 */
	public void setSceneId(Integer sceneId) {
		this.sceneId = sceneId;
	}

	/**
	 * Ӧ����ԴIDȡ��
	 * @return drmResourceId Ӧ����ԴID
	 */
	public Integer getDrmResourceId() {
		return drmResourceId;
	}

	/**
	 * Ӧ����ԴID�趨
	 * @param drmResourceId Ӧ����ԴID
	 */
	public void setDrmResourceId(Integer drmResourceId) {
		this.drmResourceId = drmResourceId;
	}

}
