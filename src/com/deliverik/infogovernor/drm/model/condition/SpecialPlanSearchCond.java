/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.drm.model.condition;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ר��Ԥ����ѯ�����ӿ�
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface SpecialPlanSearchCond {

	/**
	 * Ԥ������ģ��ƥ��ȡ��
	 * @return einame_like Ԥ������ģ��ƥ��
	 */
	public String getEiname_like();
	
	/**
	 * ҵ��ϵͳIDȡ��
	 * @return usinessSystemId ҵ��ϵͳID
	 */
	public Integer getUsinessSystemId();
	
	/**
	 * ����IDȡ��
	 * @return sceneId ����ID
	 */
	public Integer getSceneId();
	
	/**
	 * Ӧ����ԴIDȡ��
	 * @return drmResourceId Ӧ����ԴID
	 */
	public Integer getDrmResourceId();
}
