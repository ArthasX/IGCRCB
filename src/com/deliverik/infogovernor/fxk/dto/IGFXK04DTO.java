/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.fxk.dto;

import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.soc.asset.model.SOC0124Info;
import com.deliverik.framework.tree.TreeNode;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ��������DTO
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGFXK04DTO extends BaseDTO{

	/**��������*/
	protected Map<String,TreeNode> treeNodeMap = null;
	
	/** �ʲ�ģ�ͱ�� */
	protected String esyscoding;
	
	/** �ʲ���Ϣ���� */
	protected List<SOC0124Info> entityItemVWInfoList;
	
	/** ajax���ؽ�� */
	protected String ajaxResult;

	/**
	 * ��������ȡ��
	 * @return treeNodeMap ��������
	 */
	public Map<String, TreeNode> getTreeNodeMap() {
		return treeNodeMap;
	}

	/**
	 * ���������趨
	 * @param treeNodeMap ��������
	 */
	public void setTreeNodeMap(Map<String, TreeNode> treeNodeMap) {
		this.treeNodeMap = treeNodeMap;
	}

	/**
	 * �ʲ�ģ�ͱ��ȡ��
	 * @return esyscoding �ʲ�ģ�ͱ��
	 */
	public String getEsyscoding() {
		return esyscoding;
	}

	/**
	 * �ʲ�ģ�ͱ���趨
	 * @param esyscoding �ʲ�ģ�ͱ��
	 */
	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}

	/**
	 * �ʲ���Ϣ����ȡ��
	 * @return entityItemVWInfoList �ʲ���Ϣ����
	 */
	public List<SOC0124Info> getEntityItemVWInfoList() {
		return entityItemVWInfoList;
	}

	/**
	 * �ʲ���Ϣ�����趨
	 * @param entityItemVWInfoList �ʲ���Ϣ����
	 */
	public void setEntityItemVWInfoList(List<SOC0124Info> entityItemVWInfoList) {
		this.entityItemVWInfoList = entityItemVWInfoList;
	}

	/**
	 * ajax���ؽ��ȡ��
	 * @return ajaxResult ajax���ؽ��
	 */
	public String getAjaxResult() {
		return ajaxResult;
	}

	/**
	 * ajax���ؽ���趨
	 * @param ajaxResult ajax���ؽ��
	 */
	public void setAjaxResult(String ajaxResult) {
		this.ajaxResult = ajaxResult;
	}
}
