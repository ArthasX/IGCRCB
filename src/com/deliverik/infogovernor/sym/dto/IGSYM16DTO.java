/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.sym.dto;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

import com.deliverik.framework.asset.model.condition.IG117SearchCond;
import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.model.condition.CodeDetailDefSearchCond;
import com.deliverik.framework.tree.TreeNode;
import com.deliverik.infogovernor.sym.form.IGSYM1502Form;
import com.deliverik.infogovernor.sym.form.IGSYM1506Form;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ϵͳ����_��ɫ����_DTO
 * </p>
 * 
 * @author duchong@deliverik.com
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGSYM16DTO extends BaseDTO implements Serializable {
	
	/**���νṹ����**/
	protected String treeSize;
	
	
	public String getTreeSize() {
		return treeSize;
	}

	public void setTreeSize(String treeSize) {
		this.treeSize = treeSize;
	}
	
	/**��*/
	protected Map<String,TreeNode> treeNodeMap=new LinkedHashMap<String,TreeNode>();
	
	/**������Ϣ��*/
	protected Map<String,TreeNode> treeNodeNewMap=new LinkedHashMap<String,TreeNode>();
	
	public Map<String, TreeNode> getTreeNodeNewMap() {
		return treeNodeNewMap;
	}

	public void setTreeNodeNewMap(Map<String, TreeNode> treeNodeNewMap) {
		this.treeNodeNewMap = treeNodeNewMap;
	}

	/**
	 * ÿ��������������
	 */
	
	protected  Map<Integer,String> completenameMap;
	
	protected IGSYM1502Form igsym1502form;
	
	protected CodeDetailDefSearchCond CodeDetailDefSearchCond;
	
	protected IGSYM1506Form IGSYM1506Form;
	
	protected IG117SearchCond entitySearchCond;
	
	protected String select_level;//��Ҫ��ѯ��1�����
	
	protected String del_level;//��Ҫȥ����1�����
	

	public String getSelect_level() {
		return select_level;
	}

	public String getDel_level() {
		return del_level;
	}

	public void setSelect_level(String select_level) {
		this.select_level = select_level;
	}

	public void setDel_level(String del_level) {
		this.del_level = del_level;
	}

	public IGSYM1506Form getIgsym1506form() {
		return IGSYM1506Form;
	}

	public void setIgsym1506form(IGSYM1506Form igsym1506Form) {
		this.IGSYM1506Form = igsym1506Form;
	}

	public IG117SearchCond getEntitySearchCond() {
		return entitySearchCond;
	}

	public void setEntitySearchCond(IG117SearchCond entitySearchCond) {
		this.entitySearchCond = entitySearchCond;
	}

	public IGSYM1502Form getIgsym1502form() {
		return igsym1502form;
	}

	

	public CodeDetailDefSearchCond getCodeDetailDefSearchCond() {
		return CodeDetailDefSearchCond;
	}

	public void setCodeDetailDefSearchCond(CodeDetailDefSearchCond CodeDetailDefSearchCond) {
		this.CodeDetailDefSearchCond = CodeDetailDefSearchCond;
	}

	public Map<String, TreeNode> getTreeNodeMap() {
		return treeNodeMap;
	}

	public void setTreeNodeMap(Map<String, TreeNode> treeNodeMap) {
		this.treeNodeMap = treeNodeMap;
	}

	public Map<Integer, String> getCompletenameMap() {
		return completenameMap;
	}

	public void setCompletenameMap(Map<Integer, String> completenameMap) {
		this.completenameMap = completenameMap;
	}

	public void setIgsym1502form(IGSYM1502Form igsym1502form) {
		this.igsym1502form = igsym1502form;
	}
	
	
	

}
