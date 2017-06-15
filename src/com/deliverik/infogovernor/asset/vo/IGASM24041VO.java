package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.asset.model.IG002Info;
import com.deliverik.framework.asset.model.IG688Info;
import com.deliverik.framework.base.BaseVO;

/**
 * ��Ʊ��ϸ��ϢVO
 * 
 * @author
 * �޸ļ�¼: 2012/11/27 LuJiayuan ���ӱ�ʶ�ж��Ƿ���ʾͼ��ť
 */
@SuppressWarnings("serial")
public class IGASM24041VO extends BaseVO implements Serializable{
	
	/** ��Ʊ��Ϣ */
	protected IG688Info entityItemData;
	
	/** �ʲ���������Ϣ������� */
	protected Map<String,List<IG002Info>> configItemVWInfoMap;
	
	/** ͼ��ɨ��XML */
    protected String picuXml;
    
    /** ͼ��鿴XML */
    protected String picsXml;
    
    /** ͼ����ʾ��ʶ */
	protected Boolean image_flag;

	/**
	 * ���캯��
	 * @param entityItemData���ʲ�����Ϣ
	 * @param configItemVWInfoMap���ʲ���������Ϣ�������
	 */
	public IGASM24041VO(IG688Info entityItemData,Map<String,List<IG002Info>> configItemVWInfoMap) {
		this.entityItemData = entityItemData;
		this.configItemVWInfoMap = configItemVWInfoMap;
	}
	/** ��Ʊ������������ */
	protected String eiorgname;
	
	/** Ȩ�ޱ�ʶ */
	protected Boolean flag;
	
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
	/**
	 * ��Ʊ��Ϣȡ��
	 * @return ��Ʊ��Ϣ
	 */
	public IG688Info getEntityData() {
		return entityItemData;
	}
	
	/**
	 * �ʲ���������Ϣ�������ȡ��
	 * @return �ʲ���������Ϣ�������
	 */
	public Map<String, List<IG002Info>> getConfigItemVWInfoMap() {
		return configItemVWInfoMap;
	}

    /**
     * ͼ��ɨ��XML is returned.
     * @return picuXml
     */
    public String getPicuXml() {
        return picuXml;
    }

    /**
     * ͼ��ɨ��XML is set.
     * @param picuXml ͼ��ɨ��XML
     */
    public void setPicuXml(String picuXml) {
        this.picuXml = picuXml;
    }

    /**
     * ͼ��鿴XML is returned.
     * @return picsXml
     */
    public String getPicsXml() {
        return picsXml;
    }

    /**
     * ͼ��鿴XML is set.
     * @param picsXml ͼ��鿴XML
     */
    public void setPicsXml(String picsXml) {
        this.picsXml = picsXml;
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