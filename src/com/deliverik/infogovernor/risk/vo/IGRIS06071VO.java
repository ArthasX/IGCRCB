package com.deliverik.infogovernor.risk.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.model.Attachment;
import com.deliverik.framework.soc.asset.model.SOC0109Info;
import com.deliverik.framework.soc.asset.model.SOC0151Info;
import com.deliverik.infogovernor.asset.model.CheckItemVWInfo;
import com.deliverik.infogovernor.risk.form.IGRIS0614Form;

public class IGRIS06071VO extends BaseVO implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	
	/**������ʲ���ѯ����*/
	private  List<CheckItemVWInfo> itemList;
	
	/**������Ƶ�ȼ��ϻ�ȡ*/
	protected List<SOC0151Info> checkfrequencyList;
	
	/**�����������Ϣ����*/
	protected List<SOC0109Info> soc0109List;
	
	protected IGRIS0614Form igris0614form;

	/** �������Ϣ����  */	
	private List<IGRIS06141VO> checkitemInfoList;
	
	/** ������ */
	protected List<Attachment> attachmentDataList;
	
	/**
	 * igris0614formȡ��
	 * @return igris0614form igris0614form
	 */
	public IGRIS0614Form getIgris0614form() {
		return igris0614form;
	}

	/**
	 * igris0614form�趨
	 * @param igris0614form igris0614form
	 */
	public void setIgris0614form(IGRIS0614Form igris0614form) {
		this.igris0614form = igris0614form;
	}

	/**
	 * ������ʲ���ѯ����ȡ��
	 * @return itemList ������ʲ���ѯ����
	 */
	public List<CheckItemVWInfo> getItemList() {
		return itemList;
	}

	/**
	 * ������ʲ���ѯ�����趨
	 * @param itemList ������ʲ���ѯ����
	 */
	public void setItemList(List<CheckItemVWInfo> itemList) {
		this.itemList = itemList;
	}

	/**
	 * ������Ƶ�ȼ��ϻ�ȡȡ��
	 * @return checkfrequencyList ������Ƶ�ȼ��ϻ�ȡ
	 */
	public List<SOC0151Info> getCheckfrequencyList() {
		return checkfrequencyList;
	}

	/**
	 * ������Ƶ�ȼ��ϻ�ȡ�趨
	 * @param checkfrequencyList ������Ƶ�ȼ��ϻ�ȡ
	 */
	public void setCheckfrequencyList(List<SOC0151Info> checkfrequencyList) {
		this.checkfrequencyList = checkfrequencyList;
	}

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
	 * �������Ϣ����ȡ��
	 * @return checkitemInfoList  �������Ϣ����
	 */
	public List<IGRIS06141VO> getCheckitemInfoList() {
		return checkitemInfoList;
	}

	/**
	 * �������Ϣ�����趨
	 * @param checkitemInfoList  �������Ϣ����
	 */
	public void setCheckitemInfoList(List<IGRIS06141VO> checkitemInfoList) {
		this.checkitemInfoList = checkitemInfoList;
	}

	/**
	 * ������ȡ��
	 * @return attachmentDataList  ������
	 */
	public List<Attachment> getAttachmentDataList() {
		return attachmentDataList;
	}

	/**
	 * �������趨
	 * @param attachmentDataList  ������
	 */
	public void setAttachmentDataList(List<Attachment> attachmentDataList) {
		this.attachmentDataList = attachmentDataList;
	}


}
