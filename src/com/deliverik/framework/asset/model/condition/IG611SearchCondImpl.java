/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.model.condition;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.deliverik.framework.utility.CommonDefineUtils;

/**
  * ����: �ʲ�ģ������ȱʡֵ��������ʵ��
  * ��������: �ʲ�ģ������ȱʡֵ��������ʵ��
  * ������¼: 2012/07/20
  * �޸ļ�¼: 
  */
public class IG611SearchCondImpl implements
		IG611SearchCond {

	/** ģ�Ͳ���� */
	protected String esyscoding;
	
	/** ģ��id */
	protected String eid;
	
	/** ģ�Ͳ���뼯�� */
	protected List<String> esyscodingList;

	/**
	 * ģ��idȡ��
	 *
	 * @return eid ģ��id
	 */
	
	public String getEid() {
		return eid;
	}

	/**
	 * ģ��id�趨
	 *
	 * @param eid ģ��id
	 */
	
	public void setEid(String eid) {
		this.eid = eid;
	}

	/**
	 * ģ�Ͳ����ȡ��
	 * 
	 * @return ģ�Ͳ����
	 */
	public String getEsyscoding() {
		return esyscoding;
	}

	/**
	 * ģ�Ͳ�����趨
	 * 
	 * @param esyscoding ģ�Ͳ����
	 */
	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}

	/**
	 * ģ�Ͳ���뼯��ȡ��
	 * 
	 * @return ģ�Ͳ���뼯��
	 */
	public List<String> getEsyscodingList() {
		if(StringUtils.isNotEmpty(esyscoding)) {
			esyscodingList = new ArrayList<String>();
			int ccid = CommonDefineUtils.CCID_LENGTH + CommonDefineUtils.TREE_LEVEL_CODE;
			esyscodingList.add(esyscoding.substring(0, ccid));
			while(esyscoding.length() > ccid){
				ccid = ccid + CommonDefineUtils.CCID_LENGTH;
				esyscodingList.add(esyscoding.substring(0, ccid));
			}
		}
		return esyscodingList;
	}
	
}