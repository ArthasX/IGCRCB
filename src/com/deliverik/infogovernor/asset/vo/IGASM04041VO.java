package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0124Info;
import com.deliverik.framework.soc.asset.model.SOC0129Info;

/**
 * ��ͬ��ϸ��ϢVO
 * 
 * @author
 * �޸�ʱ�� 2012/11/26 LuJiayuan ���ӱ�ʶ�ж��Ƿ���ʾͼ��ť
 */
@SuppressWarnings("serial")
public class IGASM04041VO extends BaseVO implements Serializable{
	
	/** ��ͬ��Ϣ */
	protected SOC0124Info entityItemData;
	
	/** �ʲ���������Ϣ������� */
	protected Map<String,List<SOC0129Info>> configItemVWInfoMap;
	
	/** ��ͬ������������ */
	protected String eiorgname;
	
	/** Ȩ�ޱ�ʶ */
	protected Boolean flag;
	
	/** ͼ��ɨ��XML */
	protected String picuXml;
	
	/** ͼ��鿴XML */
	protected String picsXml;

	/** ��ʼ����ͬ�����ʾ�б� */
	protected Map<String,String> dismap;
	
	/** ͼ����ʾ��ʶ */
	protected Boolean image_flag;

	/**
	 * ���캯��
	 * @param entityItemData���ʲ�����Ϣ
	 * @param configItemVWInfoMap���ʲ���������Ϣ�������
	 */
	public IGASM04041VO(SOC0124Info entityItemData,Map<String,List<SOC0129Info>> configItemVWInfoMap) {
		this.entityItemData = entityItemData;
		this.configItemVWInfoMap = configItemVWInfoMap;
	}
	
	/**
	 * ��ͬ��Ϣȡ��
	 * @return ��ͬ��Ϣ
	 */
	public SOC0124Info getEntityData() {
		return entityItemData;
	}
	
	/**
	 * �ʲ���������Ϣ�������ȡ��
	 * @return �ʲ���������Ϣ�������
	 */
	public Map<String, List<SOC0129Info>> getConfigItemVWInfoMap() {
		return configItemVWInfoMap;
	}
	
	public String getPicuXml() {
		return picuXml;
	}

	public void setPicuXml(String picuXml) {
		this.picuXml = picuXml;
	}

	public String getPicsXml() {
		return picsXml;
	}

	public void setPicsXml(String picsXml) {
		this.picsXml = picsXml;
	}

	public Boolean getFlag() {
		return flag;
	}

	public void setFlag(Boolean flag) {
		this.flag = flag;
	}

	public String getEiorgname() {
		return eiorgname;
	}

	public void setEiorgname(String eiorgname) {
		this.eiorgname = eiorgname;
	}

	public Map<String, String> getDismap() {
		return dismap;
	}

	public void setDismap(Map<String, String> dismap) {
		this.dismap = dismap;
	}

	/**
	 * ͼ����ʾ��ʶȡ��
	 *
	 * @return image_flag ͼ����ʾ��ʶ
	 */
	public Boolean getImage_flag() {
		return image_flag;
	}
	/**
	 * ͼ����ʾ��ʶ�趨
	 *
	 * @param image_flag ͼ����ʾ��ʶ
	 */
	public void setImage_flag(Boolean image_flag) {
		this.image_flag = image_flag;
	}
}