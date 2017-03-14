/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;

import com.deliverik.framework.asset.model.IG499Info;
import com.deliverik.framework.base.BaseVO;

/**
 * ����: ��ͬӦ����Ǽ�VO
 * ��������: ��ͬӦ����Ǽ�VO
 * ������¼: 2012/04/11
 * �޸ļ�¼: 2012/11/27 LuJiayuan ���ӱ�ʶ�ж��Ƿ���ʾͼ��ť
 */
@SuppressWarnings("serial")
public class IGASM04211VO extends BaseVO implements Serializable {
	
	
	/** ��ͬ��Ϣ������� */
	protected IG499Info entityItemCompactVWInfo;
	
	/** ��ͬ������������ */
	protected String eiorgname;

	/** ͼ��ɨ��XML */
	protected String picuXml;
	
	/** ͼ��鿴XML */
	protected String picsXml;
	
	/** ������ */
	protected String kaihuhang;
	
	/** �����˺� */
	protected String kaihuzhanghao;
	
	/** �������� */
	protected String kaihumingcheng;
	
	/** ͼ����ʾ��ʶ */
	protected Boolean image_flag;
	
	/**
	 * ���캯��
	 */
	public IGASM04211VO() {
		super();
	}

	/**
	 * ��ͬ��Ϣ�������ȡ��
	 * @return ��ͬ��Ϣ�������
	 */
	public IG499Info getEntityItemCompactVWInfo() {
		return entityItemCompactVWInfo;
	}

	
	/**
	 * ��ͬ��Ϣ��������趨
	 * @param entityItemCompactVWInfo��ͬ��Ϣ�������
	 */
	public void setEntityItemCompactVWInfo(
			IG499Info entityItemCompactVWInfo) {
		this.entityItemCompactVWInfo = entityItemCompactVWInfo;
	}




	/**
	 * ��ͬ������������ȡ��
	 * @return ��ͬ������������
	 */
	public String getEiorgname() {
		return eiorgname;
	}

	/**
	 * ��ͬ�������������趨
	 * @param eiorgname��ͬ������������
	 */
	public void setEiorgname(String eiorgname) {
		this.eiorgname = eiorgname;
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

	public String getKaihuhang() {
		return kaihuhang;
	}

	public void setKaihuhang(String kaihuhang) {
		this.kaihuhang = kaihuhang;
	}

	public String getKaihuzhanghao() {
		return kaihuzhanghao;
	}

	public void setKaihuzhanghao(String kaihuzhanghao) {
		this.kaihuzhanghao = kaihuzhanghao;
	}

	public String getKaihumingcheng() {
		return kaihumingcheng;
	}

	public void setKaihumingcheng(String kaihumingcheng) {
		this.kaihumingcheng = kaihumingcheng;
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