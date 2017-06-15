/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.sym.form;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseForm;

/**
 * ����: ���̲����趨Form
 * �������������̲����趨Form
 * ������¼������    2010/11/26
 * �޸ļ�¼��
 */
@SuppressWarnings("serial")
public class IGSYM1702Form extends BaseForm {
	
	/** ���̶���ID */
	protected String pdid;
	
	/** ����ģ��ID */
	protected Integer ptid;
	
	/** ���̲��� */
	protected Map<String, String> strategyMap;
	
	/** ���̲��԰汾�� */
	protected Integer psdversion;
	
	/**
	 * ���̶���IDȡ��
	 * @return ���̶���ID
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * ���̶���ID�趨
	 * @param pdid���̶���ID
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}
	
	/**
	 * ����ģ��IDȡ��
	 * @return ����ģ��ID
	 */
	public Integer getPtid() {
		return ptid;
	}

	/**
	 * ����ģ��ID�趨
	 * @param ptid����ģ��ID
	 */
	public void setPtid(Integer ptid) {
		this.ptid = ptid;
	}

	/**
	 * ���̲���ȡ��
	 * @return ���̲���
	 */
	public String getStrategy(String key) {
		return (String) strategyMap.get(key);
	}

	/**
	 * ���̲����趨
	 * @param key ���̲�����������
	 * @param expecttime ���̲���
	 */
	public void setStrategy(String key, String expecttime) {
		strategyMap.put(key, expecttime);
	}
	
	/**
	 * ���̲���Mapȡ��
	 * @return ���̲���Map
	 */
	public Map<String, String> getStrategyMap() {
		return strategyMap;
	}
	
	/**
	 * ���̲���Map�趨
	 * @param strategyMap���̲���Map
	 */
	public void setStrategyMap(Map<String, String> strategyMap) {
		this.strategyMap = strategyMap;
	}
	
	@Override
	public void reset(ActionMapping mapping,HttpServletRequest request){
		super.reset(mapping, request);
		this.strategyMap = new HashMap<String, String>();
		this.psdversion = null;
	}
	
	/**
	 * ���̲��԰汾��ȡ��
	 * @return ���̲��԰汾��
	 */
	public Integer getPsdversion() {
		if(psdversion != null && psdversion == 0) {
			return null;
		} else {
			return psdversion;
		}
	}

	/**
	 * ���̲��԰汾���趨
	 * @param psdversion���̲��԰汾��
	 */
	public void setPsdversion(Integer psdversion) {
		this.psdversion = psdversion;
	}
	
}
