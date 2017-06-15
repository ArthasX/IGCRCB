/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.soc.vir.dto;

import java.util.List;

import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.infogovernor.soc.vir.form.IGVIR1302Form;
import com.deliverik.infogovernor.soc.vir.model.VIM03Info;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �����Դ����DTO
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGVIR13DTO extends BaseDTO{

	/** vCenter���� */
	protected Integer vcid;
	
	/** �������� */
	protected String hostname;
	
	/** �����б�ֵ���� */
	protected List<LabelValueBean> labelValueBeanList;
	
	/** json��� */
	protected String jsonResult;
	
	/**�����ѯ������¼��*/
	protected int maxSearchCount;

	/**��ҳBean*/
	protected PagingDTO pagingDto;
	
	/** �����Ϣ���� */
	protected List<VIM03Info> vim03List;

	/** �����Ϣ�༭Form */
	protected IGVIR1302Form igvir1302Form;
	
	/**
	 * vCenter����ȡ��
	 * @return vcid vCenter����
	 */
	public Integer getVcid() {
		return vcid;
	}

	/**
	 * vCenter�����趨
	 * @param vcid vCenter����
	 */
	public void setVcid(Integer vcid) {
		this.vcid = vcid;
	}

	/**
	 * ��������ȡ��
	 * @return hostname ��������
	 */
	public String getHostname() {
		return hostname;
	}

	/**
	 * ���������趨
	 * @param hostname ��������
	 */
	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	/**
	 * �����б�ֵ����ȡ��
	 * @return labelValueBeanList �����б�ֵ����
	 */
	public List<LabelValueBean> getLabelValueBeanList() {
		return labelValueBeanList;
	}

	/**
	 * �����б�ֵ�����趨
	 * @param labelValueBeanList �����б�ֵ����
	 */
	public void setLabelValueBeanList(List<LabelValueBean> labelValueBeanList) {
		this.labelValueBeanList = labelValueBeanList;
	}

	/**
	 * json���ȡ��
	 * @return jsonResult json���
	 */
	public String getJsonResult() {
		return jsonResult;
	}

	/**
	 * json����趨
	 * @param jsonResult json���
	 */
	public void setJsonResult(String jsonResult) {
		this.jsonResult = jsonResult;
	}

	/**
	 * �����ѯ������¼��ȡ��
	 * @return maxSearchCount �����ѯ������¼��
	 */
	public int getMaxSearchCount() {
		return maxSearchCount;
	}

	/**
	 * �����ѯ������¼���趨
	 * @param maxSearchCount �����ѯ������¼��
	 */
	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}

	/**
	 * ��ҳBeanȡ��
	 * @return pagingDto ��ҳBean
	 */
	public PagingDTO getPagingDto() {
		return pagingDto;
	}

	/**
	 * ��ҳBean�趨
	 * @param pagingDto ��ҳBean
	 */
	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}

	/**
	 * �����Ϣ����ȡ��
	 * @return vim03List �����Ϣ����
	 */
	public List<VIM03Info> getVim03List() {
		return vim03List;
	}

	/**
	 * �����Ϣ�����趨
	 * @param vim03List �����Ϣ����
	 */
	public void setVim03List(List<VIM03Info> vim03List) {
		this.vim03List = vim03List;
	}

	/**
	 * �����Ϣ�༭Formȡ��
	 * @return igvir1302Form �����Ϣ�༭Form
	 */
	public IGVIR1302Form getIgvir1302Form() {
		return igvir1302Form;
	}

	/**
	 * �����Ϣ�༭Form�趨
	 * @param igvir1302Form �����Ϣ�༭Form
	 */
	public void setIgvir1302Form(IGVIR1302Form igvir1302Form) {
		this.igvir1302Form = igvir1302Form;
	}
}
