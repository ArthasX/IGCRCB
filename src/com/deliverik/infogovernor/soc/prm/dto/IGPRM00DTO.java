/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 * Copyright 2009 Deliverik Co. Ltd.�� All rights reserved.
 */

package com.deliverik.infogovernor.soc.prm.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.tree.TreeNode;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.framework.workflow.prd.model.IG259Info;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ��ѯ��������DTO 
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGPRM00DTO extends BaseDTO implements Serializable {
	
	/**�û�ID*/
	private String userid;
	
	/**��������*/
	private String processType;
	
	/**������ȱ�ʶ��p �������� e ָ������*/
	private String ptqrtzflag;
	
	/**���̶�����*/
	private Map<String,TreeNode> treeNodeMap;
	
	/**�������弯��*/
	private Map<IG259Info,List<IG380Info>> templateDefinitionMap;
	
	/**ҳ����Դ*/
	private String page;
	
	/**��׼����ģ��**/
	private IG259Info gpt;
	
	/**�Զ�������ģ��**/
	private IG259Info spt;
	
	protected Locale locale;

	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}
	public String getPtqrtzflag() {
		return ptqrtzflag;
	}

	public void setPtqrtzflag(String ptqrtzflag) {
		this.ptqrtzflag = ptqrtzflag;
	}

	/**
	 * ��ȡ��������
	 * @return ��������
	 */
	public String getProcessType() {
		return processType;
	}

	/**
	 * ������������
	 * @param processType ��������
	 */
	public void setProcessType(String processType) {
		this.processType = processType;
	}

	/**
	 * ��ȡ���̶�����
	 * @return ���̶�����
	 */
	public Map<String, TreeNode> getTreeNodeMap() {
		return treeNodeMap;
	}

	/**
	 * �������̶�����
	 * @param treeNodeMap ���̶�����
	 */
	public void setTreeNodeMap(Map<String, TreeNode> treeNodeMap) {
		this.treeNodeMap = treeNodeMap;
	}

	/**
	 * ��ȡ�������弯��
	 * @return �������弯��
	 */
	public Map<IG259Info, List<IG380Info>> getTemplateDefinitionMap() {
		return templateDefinitionMap;
	}
	

	/**
	 * ���ù������弯��
	 * @param map �������弯��
	 */
	public void setTemplateDefinitionMap(Map<IG259Info, List<IG380Info>> templateDefinitionMap) {
		this.templateDefinitionMap = templateDefinitionMap;
	}
	
	/**
	 * ��ȡ�û�ID
	 * @return �û�ID
	 */
	public String getUserid() {
		return userid;
	}

	/**
	 * �����û�ID
	 * @param userid �û�ID
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public IG259Info getGpt() {
		return gpt;
	}

	public void setGpt(IG259Info gpt) {
		this.gpt = gpt;
	}

	public IG259Info getSpt() {
		return spt;
	}

	public void setSpt(IG259Info spt) {
		this.spt = spt;
	}
	
}