/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.sym.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.infogovernor.sym.form.IGSYM1701Form;
import com.deliverik.infogovernor.sym.form.IGSYM1702Form;

/**
 * ����: ���̲����趨ҵ��DTO
 * �������������̲����趨ҵ��DTO
 * ������¼������    2010/11/26
 * �޸ļ�¼��
 */
@SuppressWarnings("serial")
public class IGSYM17DTO extends BaseDTO implements Serializable{
	
	/** ���̶����ѯForm */
	protected IGSYM1701Form igSYM1701Form;
	
	/** ���̲����趨Form */
	protected IGSYM1702Form igSYM1702Form;

	/** ���̶�����Ϣ��������� */
	protected List<IG380Info> processDefinitionList;
	
	/** �����ѯ������¼�� */
	protected int maxSearchCount;

	/** ��ҳBean */
	protected PagingDTO pagingDto;
	
	/** ���̲��� */
	protected Map<String, String> strategyMap;
	
	/** �����̶ȼ��� */
	protected List<LabelValueBean> prurgencyList;
	
	/** ����״̬���� */
	protected List<LabelValueBean> prstatusList;
	
	/** ���̶�����Ϣ */
	protected IG380Info processDefinition;
	
	/** ���̲��԰汾�� */
	protected Integer psdversion;
	
	/** ���̲������汾�� */
	protected Integer maxPsdversion;

	/**
	 * ���̶����ѯFormȡ��
	 * @return ���̶����ѯForm
	 */
	public IGSYM1701Form getIgSYM1701Form() {
		return igSYM1701Form;
	}
	
	/**
	 * ���̶����ѯForm�趨
	 * @param igSYM1701Form���̶����ѯForm
	 */
	public void setIgSYM1701Form(IGSYM1701Form igSYM1701Form) {
		this.igSYM1701Form = igSYM1701Form;
	}
	
	/**
	 * ���̲����趨Formȡ��
	 * @return ���̲����趨Form
	 */
	public IGSYM1702Form getIgSYM1702Form() {
		return igSYM1702Form;
	}

	/**
	 * ���̲����趨Form�趨
	 * @param igSYM1702Form���̲����趨Form
	 */
	public void setIgSYM1702Form(IGSYM1702Form igSYM1702Form) {
		this.igSYM1702Form = igSYM1702Form;
	}

	/**
	 * ���̶�����Ϣ���������ȡ��
	 * @return ���̶�����Ϣ���������
	 */
	public List<IG380Info> getProcessDefinitionList() {
		return processDefinitionList;
	}

	/**
	 * ���̶�����Ϣ����������趨
	 * @param processDefinitionList���̶�����Ϣ���������
	 */
	public void setProcessDefinitionList(
			List<IG380Info> processDefinitionList) {
		this.processDefinitionList = processDefinitionList;
	}

	/**
	 * �����ѯ������¼��ȡ��
	 * @return �����ѯ������¼��
	 */
	public int getMaxSearchCount() {
		return maxSearchCount;
	}

	/**
	 * �����ѯ������¼���趨
	 * @param processDefinitionList�����ѯ������¼��
	 */
	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}

	/**
	 * ��ҳBeanȡ��
	 * @return ��ҳBean
	 */
	public PagingDTO getPagingDto() {
		return pagingDto;
	}

	/**
	 * ��ҳBean�趨
	 * @param processDefinitionList��ҳBean
	 */
	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}
	
	/**
	 * ���̲���Map�趨
	 * @param strategyMap���̲���Map
	 */
	public void setStrategyMap(Map<String, String> strategyMap) {
		this.strategyMap = strategyMap;
	}

	/**
	 * ���̲���Mapȡ��
	 * @return ���̲���Map
	 */
	public Map<String, String> getStrategyMap() {
		return strategyMap;
	}

	/**
	 * �����̶ȼ����趨
	 * @param prurgencyList�����̶ȼ���
	 */
	public List<LabelValueBean> getPrurgencyList() {
		return prurgencyList;
	}

	/**
	 * �����̶ȼ���ȡ��
	 * @return �����̶ȼ���
	 */
	public void setPrurgencyList(List<LabelValueBean> prurgencyList) {
		this.prurgencyList = prurgencyList;
	}

	/**
	 * ����״̬�����趨
	 * @param prstatusList����״̬����
	 */
	public List<LabelValueBean> getPrstatusList() {
		return prstatusList;
	}

	/**
	 * ����״̬����ȡ��
	 * @return ����״̬����
	 */
	public void setPrstatusList(List<LabelValueBean> prstatusList) {
		this.prstatusList = prstatusList;
	}

	/**
	 * ���̶�����Ϣ�趨
	 * @param processDefinition���̶�����Ϣ
	 */
	public IG380Info getProcessDefinition() {
		return processDefinition;
	}

	/**
	 * ���̶�����Ϣȡ��
	 * @return ���̶�����Ϣ
	 */
	public void setProcessDefinition(IG380Info processDefinition) {
		this.processDefinition = processDefinition;
	}

	/**
	 * ���̲��԰汾��ȡ��
	 * @return ���̲��԰汾��
	 */
	public Integer getPsdversion() {
		return psdversion;
	}

	/**
	 * ���̲��԰汾���趨
	 * @param psdversion���̲��԰汾��
	 */
	public void setPsdversion(Integer psdversion) {
		this.psdversion = psdversion;
	}

	/**
	 * ���̲������汾��ȡ��
	 * @return ���̲������汾��
	 */
	public Integer getMaxPsdversion() {
		return maxPsdversion;
	}

	/**
	 * ���̲������汾���趨
	 * @param maxPsdversion���̲������汾��
	 */
	public void setMaxPsdversion(Integer maxPsdversion) {
		this.maxPsdversion = maxPsdversion;
	}
	
}


