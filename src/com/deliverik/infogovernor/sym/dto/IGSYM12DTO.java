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
import com.deliverik.framework.model.condition.CodeDetailSearchCond;
import com.deliverik.framework.soc.asset.model.condition.SOC0117SearchCond;
import com.deliverik.framework.tree.TreeNode;
import com.deliverik.infogovernor.sym.form.IGSYM1201Form;
import com.deliverik.infogovernor.sym.form.IGSYM1202Form;

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
public class IGSYM12DTO extends BaseDTO implements Serializable {
	
	
	/**��*/
	protected Map<String,TreeNode> treeNodeMap=new LinkedHashMap<String,TreeNode>();
	
	/**
	 * ÿ��������������
	 */
	
	protected  Map<Integer,String> completenameMap;
	
	protected IGSYM1201Form igsym1201form;
	
	protected CodeDetailSearchCond codeDetailSearchCond;
	
	protected IGSYM1202Form igsym1202form;
	
	protected IG117SearchCond entitySearchCond;
	
	protected SOC0117SearchCond socEntitySearchCond;
	
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

	public IGSYM1202Form getIgsym1202form() {
		return igsym1202form;
	}

	public void setIgsym1202form(IGSYM1202Form igsym1202form) {
		this.igsym1202form = igsym1202form;
	}

	public IG117SearchCond getEntitySearchCond() {
		return entitySearchCond;
	}

	public void setEntitySearchCond(IG117SearchCond entitySearchCond) {
		this.entitySearchCond = entitySearchCond;
	}

	public IGSYM1201Form getIgsym1201form() {
		return igsym1201form;
	}

	public void setIgsym1201form(IGSYM1201Form igsym1201form) {
		this.igsym1201form = igsym1201form;
	}

	public CodeDetailSearchCond getCodeDetailSearchCond() {
		return codeDetailSearchCond;
	}

	public void setCodeDetailSearchCond(CodeDetailSearchCond codeDetailSearchCond) {
		this.codeDetailSearchCond = codeDetailSearchCond;
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

	public SOC0117SearchCond getSocEntitySearchCond() {
		return socEntitySearchCond;
	}

	public void setSocEntitySearchCond(SOC0117SearchCond socEntitySearchCond) {
		this.socEntitySearchCond = socEntitySearchCond;
	}

}
