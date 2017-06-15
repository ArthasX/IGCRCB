/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.soc.cim.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0129Info;
import com.deliverik.framework.soc.asset.model.SOC0128Info;
import com.deliverik.framework.soc.asset.model.SOC0124Info;

/**
 * ����: �豸��ϸ��Ϣ��������֣�
 * ��������: �豸��ϸ��Ϣ��������֣�
 * ������¼: 2011/05/19
 * �޸ļ�¼: 
 */
@SuppressWarnings("serial")
public class IGCIM03091VO extends BaseVO implements Serializable{
	/** �豸��Ϣ */
	protected SOC0124Info soc0124Info;
	
	/** �豸������������ */
	protected String eiorgname;
	
	/** Ȩ�ޱ�ʶ */
	protected Boolean flag;
	
	/** �ʲ���������Ϣ������� */
	protected Map<String,List<SOC0129Info>> configItemVWInfoMap;
	
	/** �ʲ��汾�б� */
	protected List<SOC0128Info> soc0128List;

	/**
	 * �豸��Ϣȡ��
	 *
	 * @return soc0124Info �豸��Ϣ
	 */
	public SOC0124Info getSoc0124Info() {
		return soc0124Info;
	}

	/**
	 * �豸��Ϣ�趨
	 *
	 * @param soc0124Info �豸��Ϣ
	 */
	public void setSoc0124Info(SOC0124Info soc0124Info) {
		this.soc0124Info = soc0124Info;
	}

	/**
	 * �豸������������ȡ��
	 *
	 * @return eiorgname �豸������������
	 */
	public String getEiorgname() {
		return eiorgname;
	}

	/**
	 * �豸�������������趨
	 *
	 * @param eiorgname �豸������������
	 */
	public void setEiorgname(String eiorgname) {
		this.eiorgname = eiorgname;
	}

	/**
	 * Ȩ�ޱ�ʶȡ��
	 *
	 * @return flag Ȩ�ޱ�ʶ
	 */
	public Boolean getFlag() {
		return flag;
	}

	/**
	 * Ȩ�ޱ�ʶ�趨
	 *
	 * @param flag Ȩ�ޱ�ʶ
	 */
	public void setFlag(Boolean flag) {
		this.flag = flag;
	}

	/**
	 * �ʲ���������Ϣ�������ȡ��
	 *
	 * @return configItemVWInfoMap �ʲ���������Ϣ�������
	 */
	public Map<String, List<SOC0129Info>> getConfigItemVWInfoMap() {
		return configItemVWInfoMap;
	}

	/**
	 * �ʲ���������Ϣ��������趨
	 *
	 * @param configItemVWInfoMap �ʲ���������Ϣ�������
	 */
	public void setConfigItemVWInfoMap(
			Map<String, List<SOC0129Info>> configItemVWInfoMap) {
		this.configItemVWInfoMap = configItemVWInfoMap;
	}

	/**
	 * �ʲ��汾�б�ȡ��
	 *
	 * @return soc0128List �ʲ��汾�б�
	 */
	public List<SOC0128Info> getSoc0128List() {
		return soc0128List;
	}

	/**
	 * �ʲ��汾�б��趨
	 *
	 * @param soc0128List �ʲ��汾�б�
	 */
	public void setSoc0128List(List<SOC0128Info> soc0128List) {
		this.soc0128List = soc0128List;
	}

	/**
	 * @param soc0124Info
	 * @param configItemVWInfoMap
	 */
	public IGCIM03091VO(SOC0124Info soc0124Info, Map<String, List<SOC0129Info>> configItemVWInfoMap) {
		super();
		this.soc0124Info = soc0124Info;
		this.configItemVWInfoMap = configItemVWInfoMap;
	}

	
	

}
