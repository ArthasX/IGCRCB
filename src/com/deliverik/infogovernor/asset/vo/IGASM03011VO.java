package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0124Info;
import com.deliverik.framework.tree.TreeNode;

/**
 * 设备信息检索结果ＶＯ
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGASM03011VO extends BaseVO implements Serializable{
	
	/** 设备信息检索结果 */
	protected List<SOC0124Info> entityDataList;
	
	/** 配置信息XML树 */
	protected Map<String,TreeNode> treeNodeMap = new LinkedHashMap<String,TreeNode>();
	
	/** 配置信息XML树结点信息 */
	protected Map<String,String> infoMap;
	
	protected List<String> section_list;
	
	protected List<String> command_list1;
	
	protected List<String> output_list1;
	
	protected List<String> command_list2;
	
	protected List<String> output_list2;
	
	protected Map<String,List<TreeNode>> map1;
	
	protected Map<String,List<TreeNode>> map2;
	
	protected List<String> command_color_list;//0不变色 1变色
	
	protected List<String> output_color_list;//0不变色 1变色
	
	
	
	public List<String> getCommand_color_list() {
		return command_color_list;
	}

	public void setCommand_color_list(List<String> command_color_list) {
		this.command_color_list = command_color_list;
	}

	public List<String> getOutput_color_list() {
		return output_color_list;
	}

	public void setOutput_color_list(List<String> output_color_list) {
		this.output_color_list = output_color_list;
	}
	
	
	public Map<String, List<TreeNode>> getMap1() {
		return map1;
	}

	public void setMap1(Map<String, List<TreeNode>> map1) {
		this.map1 = map1;
	}

	public Map<String, List<TreeNode>> getMap2() {
		return map2;
	}

	public void setMap2(Map<String, List<TreeNode>> map2) {
		this.map2 = map2;
	}

	/**
	 * 构造函数
	 * @param entityData　设备信息检索结果
	 */
	public IGASM03011VO(List<SOC0124Info> entityDataList) {
		this.entityDataList = entityDataList;
	}
	
	public IGASM03011VO() {
	}
	
	public Map<String, String> getInfoMap() {
		return infoMap;
	}

	public void setInfoMap(Map<String, String> infoMap) {
		this.infoMap = infoMap;
	}
	
	public Map<String, TreeNode> getTreeNodeMap() {
		return treeNodeMap;
	}

	public void setTreeNodeMap(Map<String, TreeNode> treeNodeMap) {
		this.treeNodeMap = treeNodeMap;
	}
	
	
	
	public List<String> getSection_list() {
		return section_list;
	}

	public void setSection_list(List<String> section_list) {
		this.section_list = section_list;
	}

	public List<String> getCommand_list1() {
		return command_list1;
	}

	public void setCommand_list1(List<String> command_list1) {
		this.command_list1 = command_list1;
	}

	public List<String> getOutput_list1() {
		return output_list1;
	}

	public void setOutput_list1(List<String> output_list1) {
		this.output_list1 = output_list1;
	}

	public List<String> getCommand_list2() {
		return command_list2;
	}

	public void setCommand_list2(List<String> command_list2) {
		this.command_list2 = command_list2;
	}

	public List<String> getOutput_list2() {
		return output_list2;
	}

	public void setOutput_list2(List<String> output_list2) {
		this.output_list2 = output_list2;
	}

	/**
	 * 设备信息检索结果取得
	 * @return 资产项信息检索结果
	 */
	public List<SOC0124Info> getEntityDataList() {
		return entityDataList;
	}

}


