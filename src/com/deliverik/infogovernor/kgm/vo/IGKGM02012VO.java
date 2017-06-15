package com.deliverik.infogovernor.kgm.vo;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.tree.TreeNode;
import com.deliverik.framework.user.model.Role;
import com.deliverik.infogovernor.kgm.model.Knowledge;
import com.deliverik.infogovernor.kgm.model.KnowledgeProcess;

/**
 * ����:֪ʶ��Ǽ�VO
 * ����������֪ʶ��Ǽ�VO
 * ������¼��cdd 2010/12/07
 * �޸ļ�¼��
 */
@SuppressWarnings("serial")
public class IGKGM02012VO  extends BaseVO implements Serializable{
	
	public IGKGM02012VO() {
	
	}
	
	/**
	 * ֪ʶ��Ǽǽ��Listȡ��
	 * @return ֪ʶ��Ǽǽ��List
	 */
	protected List<Knowledge> knowledgeList;
	
	/**
	 * ֪ʶ��Ǽǹؼ��ʽ��Listȡ��
	 * @return ֪ʶ��Ǽǹؼ��ʽ��List
	 */
	protected List<String> defaultKeyList;
	
	/**
	 * ֪ʶ��Ǽ�ȡ��
	 * @return ֪ʶ��Ǽǹؼ��ʽ��
	 */
	protected Knowledge knowledge;
	
	/** ֪ʶ���̹�����Ϣ���� */
	protected List<KnowledgeProcess> knowledgeProcessList;
	
	/**֪ʶ�ؼ���*/
	protected Map<String,TreeNode> treeNodeMap=new LinkedHashMap<String,TreeNode>();

	/**֪ʶ�����˽�ɫ*/
	protected List<Role> roleList;
	
	public List<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}

	/**
	 * ֪ʶ��Ǽǹؼ��ֻ�ȡ
	 * @return ֪ʶ��Ǽǹؼ���list
	 */
	public List<String> getDefaultKeyList() {
		return defaultKeyList;
	}

	/**
	 * ֪ʶ��Ǽǹؼ�������list
	 * @param ֪ʶ��Ǽǹؼ���list
	 */
	public void setDefaultKeyList(List<String> defaultKeyList) {
		this.defaultKeyList = defaultKeyList;
	}

	/**
	 * ֪ʶ��Ǽǽ����ȡlist
	 * @return ֪ʶ��Ǽǽ��list
	 */
	public List<Knowledge> getKnowledgeList() {
		return knowledgeList;
	}

	/**
	 * ֪ʶ��Ǽǽ������list
	 * @param ֪ʶ��Ǽǽ��list
	 */
	public void setKnowledgeList(List<Knowledge> knowledgeList) {
		this.knowledgeList = knowledgeList;
	}

	/**
	 * ֪ʶ���ѯ�����ȡ
	 * @return ֪ʶ���ѯ���
	 */
	public Knowledge getKnowledge() {
		return knowledge;
	}

	/**
	 * ֪ʶ��Ǽǽ������
	 * @param ֪ʶ���ѯ���
	 */
	public void setKnowledge(Knowledge knowledge) {
		this.knowledge = knowledge;
	}

	/**
	 * ֪ʶ���̹�����Ϣ����ȡ��
	 * @return ֪ʶ���̹�����Ϣ����
	 */
	public List<KnowledgeProcess> getKnowledgeProcessList() {
		return knowledgeProcessList;
	}
	
	/**
	 * ֪ʶ���̹�����Ϣ�����趨
	 * @param knowledgeProcess֪ʶ���̹�����Ϣ����
	 */
	public void setKnowledgeProcessList(List<KnowledgeProcess> knowledgeProcessList) {
		this.knowledgeProcessList = knowledgeProcessList;
	}

	public Map<String, TreeNode> getTreeNodeMap() {
		return treeNodeMap;
	}

	public void setTreeNodeMap(Map<String, TreeNode> treeNodeMap) {
		this.treeNodeMap = treeNodeMap;
	}
	
	/** ���̹���ϵͳMap */
	protected Map<LabelValueBean,String> knowledgeAppImpactMap;

	public Map<LabelValueBean, String> getKnowledgeAppImpactMap() {
		return knowledgeAppImpactMap;
	}

	public void setKnowledgeAppImpactMap(
			Map<LabelValueBean, String> knowledgeAppImpactMap) {
		this.knowledgeAppImpactMap = knowledgeAppImpactMap;
	}
}
