/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.prr.dto;

import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.model.CodeDetailDef;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.infogovernor.prr.form.IGPRR0402Form;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���̷���Ŀ¼dto
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGPRR04DTO extends BaseDTO {

	/** ����Ŀ¼��ʾform */
	protected IGPRR0402Form igprr0402Form;
	
	/** ����Ŀ¼��ʾ���� */
	protected Map<String, List<Map<CodeDetailDef, List<IG380Info>>>> serviceCatalogMap;
	
	/** ����Ŀ¼һ������ */
	protected List<CodeDetailDef> serviceCatalogFirstClassify;
	
	/** �û���Ϣ */
	protected User user;
	
	/** �ɷ������̼���  */
	protected List<IG380Info> pdList;

	/**
	 * ����Ŀ¼��ʾformȡ��
	 * @return igprr0402Form ����Ŀ¼��ʾform
	 */
	public IGPRR0402Form getIgprr0402Form() {
		return igprr0402Form;
	}

	/**
	 * ����Ŀ¼��ʾform�趨
	 * @param igprr0402Form ����Ŀ¼��ʾform
	 */
	public void setIgprr0402Form(IGPRR0402Form igprr0402Form) {
		this.igprr0402Form = igprr0402Form;
	}

	/**
	 * ����Ŀ¼��ʾ����ȡ��
	 * @return serviceCatalogMap ����Ŀ¼��ʾ����
	 */
	public Map<String, List<Map<CodeDetailDef, List<IG380Info>>>> getServiceCatalogMap() {
		return serviceCatalogMap;
	}

	/**
	 * ����Ŀ¼��ʾ�����趨
	 * @param serviceCatalogMap ����Ŀ¼��ʾ����
	 */
	public void setServiceCatalogMap(
			Map<String, List<Map<CodeDetailDef, List<IG380Info>>>> serviceCatalogMap) {
		this.serviceCatalogMap = serviceCatalogMap;
	}

	/**
	 * ����Ŀ¼һ������ȡ��
	 * @return serviceCatalogFirstClassify ����Ŀ¼һ������
	 */
	public List<CodeDetailDef> getServiceCatalogFirstClassify() {
		return serviceCatalogFirstClassify;
	}

	/**
	 * ����Ŀ¼һ�������趨
	 * @param serviceCatalogFirstClassify ����Ŀ¼һ������
	 */
	public void setServiceCatalogFirstClassify(
			List<CodeDetailDef> serviceCatalogFirstClassify) {
		this.serviceCatalogFirstClassify = serviceCatalogFirstClassify;
	}

	/**
	 * �û���Ϣȡ��
	 * @return user �û���Ϣ
	 */
	public User getUser() {
		return user;
	}

	/**
	 * �û���Ϣ�趨
	 * @param user �û���Ϣ
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * �ɷ������̼���ȡ��
	 * @return pdList �ɷ������̼���
	 */
	public List<IG380Info> getPdList() {
		return pdList;
	}

	/**
	 * �ɷ������̼����趨
	 * @param pdList �ɷ������̼���
	 */
	public void setPdList(List<IG380Info> pdList) {
		this.pdList = pdList;
	}
}
