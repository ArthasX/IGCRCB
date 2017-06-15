package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;
import java.util.List;

import org.apache.struts.upload.FormFile;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0109Info;
import com.deliverik.framework.soc.asset.model.SOC0118Info;
import com.deliverik.framework.soc.asset.model.SOC0151Info;

/**
 * ������¼����Ϣ�֣�
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGASM31021VO extends BaseVO implements Serializable{
	
	/** ������¼����Ϣ */
	protected SOC0118Info entityItemData;
	
	/**����ָ��--�Ƿ�ؼ�ָ������*/
	protected List<SOC0151Info> keyIndexList;
	
	/**����ָ��--ָ��ģ������*/
	protected List<SOC0151Info> titList;
	
	/**����ָ��--��ֵ����*/
	protected List<SOC0151Info> thresholdList;
	
	/**����ָ��������Ϣ����*/
	protected List<SOC0109Info> soc0109List;
	
	/** ����ָ�긽��*/
	protected String attachFile;
	
	
	
	/**
	 * ���캯��
	 * @param entityData��������¼����Ϣ
	 */
	public IGASM31021VO(SOC0118Info entityItemData) {
		this.entityItemData = entityItemData;
	}
	
	/**
	 * ������¼����Ϣȡ��
	 * @return ������¼����Ϣ
	 */
	public SOC0118Info getEntityData() {
		return entityItemData;
	}

	/**
	 * ����ָ��--�Ƿ�ؼ�ָ������ȡ��
	 * @return list����
	 */
	public List<SOC0151Info> getKeyIndexList() {
		return keyIndexList;
	}
	/**
	 * ����ָ��--�Ƿ�ؼ�ָ�������趨
	 */
	public void setKeyIndexList(List<SOC0151Info> keyIndexList) {
		this.keyIndexList = keyIndexList;
	}
	/**
	 * ����ָ��--ָ��ģ������ȡ��
	 * @return list����
	 */
	public List<SOC0151Info> getTitList() {
		return titList;
	}
	/**
	 * ����ָ��--ָ��ģ�������趨
	 */
	public void setTitList(List<SOC0151Info> titList) {
		this.titList = titList;
	}
	/**
	 * ����ָ��--��ֵ����ȡ��
	 * @return list����
	 */
	public List<SOC0151Info> getThresholdList() {
		return thresholdList;
	}
	/**
	 * ����ָ��--��ֵ�����趨
	 */
	public void setThresholdList(List<SOC0151Info> thresholdList) {
		this.thresholdList = thresholdList;
	}

	public List<SOC0109Info> getSoc0109List() {
		return soc0109List;
	}

	public void setSoc0109List(List<SOC0109Info> soc0109List) {
		this.soc0109List = soc0109List;
	}

	public String getAttachFile() {
		return attachFile;
	}

	public void setAttachFile(String attachFile) {
		this.attachFile = attachFile;
	}

	

}


