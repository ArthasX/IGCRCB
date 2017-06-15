package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0109Info;
import com.deliverik.framework.soc.asset.model.SOC0118Info;
import com.deliverik.framework.soc.asset.model.SOC0151Info;

/**
 * ���յ��¼����Ϣ�֣�
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGASM27021VO extends BaseVO implements Serializable{
	
	/** ���յ��¼����Ϣ */
	protected SOC0118Info entityItemData;
	/**�������صȼ����ϻ�ȡ*/
	protected List<SOC0151Info> gradeList;
	
	/**���ռ��𼯺ϻ�ȡ*/
	protected List<SOC0151Info> levelList;
	
	/**���յ������*/
	protected List<SOC0151Info> possibleList;
	/**���ձ�ʶ����*/
	protected List<SOC0151Info> signList;
	
	/**�����������Ϣ����*/
	protected List<SOC0109Info> soc0109List;
	
	/**
	 * �����������Ϣ����ȡ��
	 * @return soc0109List �����������Ϣ����
	 */
	public List<SOC0109Info> getSoc0109List() {
		return soc0109List;
	}

	/**
	 * �����������Ϣ�����趨
	 * @param soc0109List �����������Ϣ����
	 */
	public void setSoc0109List(List<SOC0109Info> soc0109List) {
		this.soc0109List = soc0109List;
	}

	/**
	 * �������صȼ����ϻ�ȡȡ��
	 * @return gradeList �������صȼ����ϻ�ȡ
	 */
	public List<SOC0151Info> getGradeList() {
		return gradeList;
	}

	/**
	 * �������صȼ����ϻ�ȡ�趨
	 * @param gradeList �������صȼ����ϻ�ȡ
	 */
	public void setGradeList(List<SOC0151Info> gradeList) {
		this.gradeList = gradeList;
	}

	/**
	 * ���ռ��𼯺ϻ�ȡȡ��
	 * @return levelList ���ռ��𼯺ϻ�ȡ
	 */
	public List<SOC0151Info> getLevelList() {
		return levelList;
	}

	/**
	 * ���ռ��𼯺ϻ�ȡ�趨
	 * @param levelList ���ռ��𼯺ϻ�ȡ
	 */
	public void setLevelList(List<SOC0151Info> levelList) {
		this.levelList = levelList;
	}

	/**
	 * ���յ������ȡ��
	 * @return possibleList ���յ������
	 */
	public List<SOC0151Info> getPossibleList() {
		return possibleList;
	}

	/**
	 * ���յ�������趨
	 * @param possibleList ���յ������
	 */
	public void setPossibleList(List<SOC0151Info> possibleList) {
		this.possibleList = possibleList;
	}

	/**
	 * ���ձ�ʶ����ȡ��
	 * @return signList ���ձ�ʶ����
	 */
	public List<SOC0151Info> getSignList() {
		return signList;
	}

	/**
	 * ���ձ�ʶ�����趨
	 * @param signList ���ձ�ʶ����
	 */
	public void setSignList(List<SOC0151Info> signList) {
		this.signList = signList;
	}


	
	/**
	 * ���캯��
	 * @param entityData�����յ��¼����Ϣ
	 */
	public IGASM27021VO(SOC0118Info entityItemData) {
		this.entityItemData = entityItemData;
	}
	
	/**
	 * ���յ��¼����Ϣȡ��
	 * @return ���յ��¼����Ϣ
	 */
	public SOC0118Info getEntityData() {
		return entityItemData;
	}
}


