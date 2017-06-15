/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.soc.cim.dto;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.soc.asset.model.SOC0107Info;
import com.deliverik.framework.soc.asset.model.SOC0124Info;
import com.deliverik.framework.soc.asset.model.SOC0129Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0117SearchCond;
import com.deliverik.framework.tree.TreeNode;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.soc.cim.form.IGCIM1202Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM1203Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM1204Form;



@SuppressWarnings("serial")
public class IGCIM12DTO extends BaseDTO implements Serializable {
	
	
	protected IGCIM1202Form igcim1202form;
	
	protected IGCIM1203Form igcim1203form;
	
	protected IGCIM1204Form igcim1204form;
	/** 用户对象 */
	private User user;
	
	/** 配置项信息 */
	protected SOC0124Info entityItemVWInfo;
	
	/** 资产项配置信息检索结果 */
	protected Map<String,List<SOC0107Info>> configItemMap;
	
	protected SOC0117SearchCond entitySearchCond;
	
	protected Map<String,TreeNode> treeNodeMap=new LinkedHashMap<String,TreeNode>();
	
	/** 配置信息检索结果 */
	protected List<SOC0107Info> configItemList;
	
	/** 权限标识 */
	protected Boolean flag;
	
	/** 资产项配置信息检索结果 */
	protected Map<String,List<SOC0129Info>> soc0129InfoVWMap;


	public SOC0117SearchCond getEntitySearchCond() {
		return entitySearchCond;
	}

	public void setEntitySearchCond(SOC0117SearchCond entitySearchCond) {
		this.entitySearchCond = entitySearchCond;
	}

	public IGCIM1202Form getIgcim1202form() {
		return igcim1202form;
	}

	public void setIgcim1202form(IGCIM1202Form igcim1202form) {
		this.igcim1202form = igcim1202form;
	}

	public Map<String, TreeNode> getTreeNodeMap() {
		return treeNodeMap;
	}

	public void setTreeNodeMap(Map<String, TreeNode> treeNodeMap) {
		this.treeNodeMap = treeNodeMap;
	}

	public IGCIM1203Form getIgcim1203form() {
		return igcim1203form;
	}

	public void setIgcim1203form(IGCIM1203Form igcim1203form) {
		this.igcim1203form = igcim1203form;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public SOC0124Info getEntityItemVWInfo() {
		return entityItemVWInfo;
	}

	public void setEntityItemVWInfo(SOC0124Info entityItemVWInfo) {
		this.entityItemVWInfo = entityItemVWInfo;
	}

	public Map<String, List<SOC0107Info>> getConfigItemMap() {
		return configItemMap;
	}

	public void setConfigItemMap(Map<String, List<SOC0107Info>> configItemMap) {
		this.configItemMap = configItemMap;
	}

	public Boolean getFlag() {
		return flag;
	}

	public void setFlag(Boolean flag) {
		this.flag = flag;
	}

	public IGCIM1204Form getIgcim1204form() {
		return igcim1204form;
	}

	public void setIgcim1204form(IGCIM1204Form igcim1204form) {
		this.igcim1204form = igcim1204form;
	}

	public List<SOC0107Info> getConfigItemList() {
		return configItemList;
	}

	public void setConfigItemList(List<SOC0107Info> configItemList) {
		this.configItemList = configItemList;
	}

	public Map<String, List<SOC0129Info>> getSoc0129InfoVWMap() {
		return soc0129InfoVWMap;
	}

	public void setSoc0129InfoVWMap(Map<String, List<SOC0129Info>> soc0129InfoVWMap) {
		this.soc0129InfoVWMap = soc0129InfoVWMap;
	}
	
}
