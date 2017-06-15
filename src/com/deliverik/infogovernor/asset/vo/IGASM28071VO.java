package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0109Info;
import com.deliverik.framework.soc.asset.model.SOC0151Info;
import com.deliverik.infogovernor.asset.form.IGASM2814Form;
import com.deliverik.infogovernor.asset.model.CheckItemVWInfo;

public class IGASM28071VO extends BaseVO implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	
	/**������ʲ���ѯ����*/
	private  List<CheckItemVWInfo> itemList;
	
	/**������Ƶ�ȼ��ϻ�ȡ*/
	protected List<SOC0151Info> checkfrequencyList;
	
	/**�����������Ϣ����*/
	protected List<SOC0109Info> soc0109List;
	
	protected IGASM2814Form igasm2814form;

	/**
	 * igasm2814formȡ��
	 * @return igasm2814form igasm2814form
	 */
	public IGASM2814Form getIgasm2814form() {
		return igasm2814form;
	}

	/**
	 * igasm2814form�趨
	 * @param igasm2814form igasm2814form
	 */
	public void setIgasm2814form(IGASM2814Form igasm2814form) {
		this.igasm2814form = igasm2814form;
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


}
