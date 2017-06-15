package com.deliverik.infogovernor.drm.form;

import com.deliverik.framework.base.BaseForm;

@SuppressWarnings("serial")
public class IGDRM2105Form extends BaseForm {

	/** ҳ��ģʽ */
	protected String mode = "0";
	
	/** ר��Ԥ��ID */
	protected Integer eiid;
	
	/** Ԥ������ */
	protected String einame_like;
	
	/** ��ɾ��Ԥ��ID���� */
	protected Integer[] selectedEiids;
	
	/** ҵ��ϵͳID */
	protected Integer usinessSystemId;
	
	/*** ҵ��ϵͳ���� */
	protected String usinessSystemName;
	
	/** ����ID */
	protected Integer sceneId;
	
	/** �������� */
	protected String sceneName;
	
	/** Ӧ����ԴID */
	protected Integer drmResourceId;
	
	/** Ӧ����Դ���� */
	protected String drmResourceName;

	/**
	 * ҳ��ģʽȡ��
	 * @return mode ҳ��ģʽ ��ѯ:0, ����:1
	 */
	public String getMode() {
		return mode;
	}

	/**
	 * ҳ��ģʽ�趨
	 * @param mode ҳ��ģʽ ��ѯ:0, ����:1
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}

	/**
	 * ר��Ԥ��IDȡ��
	 * @return eiid ר��Ԥ��ID
	 */
	public Integer getEiid() {
		return eiid;
	}

	/**
	 * ר��Ԥ��ID�趨
	 * @param eiid ר��Ԥ��ID
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

	/**
	 * Ԥ������ȡ��
	 * @return einame_like Ԥ������
	 */
	public String getEiname_like() {
		return einame_like;
	}

	/**
	 * Ԥ�������趨
	 * @param einame_like Ԥ������
	 */
	public void setEiname_like(String einame_like) {
		this.einame_like = einame_like;
	}

	/**
	 * ��ɾ��Ԥ��ID����ȡ��
	 * @return selectedEiids ��ɾ��Ԥ��ID����
	 */
	public Integer[] getSelectedEiids() {
		return selectedEiids;
	}

	/**
	 * ��ɾ��Ԥ��ID�����趨
	 * @param selectedEiids ��ɾ��Ԥ��ID����
	 */
	public void setSelectedEiids(Integer[] selectedEiids) {
		this.selectedEiids = selectedEiids;
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
	 * ҵ��ϵͳ����ȡ��
	 * @return usinessSystemName ҵ��ϵͳ����
	 */
	public String getUsinessSystemName() {
		return usinessSystemName;
	}

	/**
	 * ҵ��ϵͳ�����趨
	 * @param usinessSystemName ҵ��ϵͳ����
	 */
	public void setUsinessSystemName(String usinessSystemName) {
		this.usinessSystemName = usinessSystemName;
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
	 * ��������ȡ��
	 * @return sceneName ��������
	 */
	public String getSceneName() {
		return sceneName;
	}

	/**
	 * ���������趨
	 * @param sceneName ��������
	 */
	public void setSceneName(String sceneName) {
		this.sceneName = sceneName;
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

	/**
	 * Ӧ����Դ����ȡ��
	 * @return drmResourceName Ӧ����Դ����
	 */
	public String getDrmResourceName() {
		return drmResourceName;
	}

	/**
	 * Ӧ����Դ�����趨
	 * @param drmResourceName Ӧ����Դ����
	 */
	public void setDrmResourceName(String drmResourceName) {
		this.drmResourceName = drmResourceName;
	}

}
