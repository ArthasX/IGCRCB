/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.soc.vir.vo;

import java.util.ArrayList;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.workflow.prr.model.IG677Info;
import com.deliverik.infogovernor.soc.vir.vim.model.Template;
import com.deliverik.infogovernor.soc.vir.vim.model.VMachine;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 用户首页VO
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGVIR10061VO extends BaseVO{

	/** 我发起的流程信息 */
	protected List<IG677Info> myOpenProcessList;
	
	/**个人VM列表*/
	protected List<VMachine> ownVMList ;
	
	/** 页面显示个人VM列表信息 */
	protected List<List<VMachine>> showOwnVMList;
	
	/**模板集合*/
	protected List<Template> templateList;

	/**
	 * 我发起的流程信息取得
	 * @return myOpenProcessList 我发起的流程信息
	 */
	public List<IG677Info> getMyOpenProcessList() {
		return myOpenProcessList;
	}

	/**
	 * 我发起的流程信息设定
	 * @param myOpenProcessList 我发起的流程信息
	 */
	public void setMyOpenProcessList(List<IG677Info> myOpenProcessList) {
		this.myOpenProcessList = myOpenProcessList;
	}

	/**
	 * 个人VM列表取得
	 * @return ownVMList 个人VM列表
	 */
	public List<VMachine> getOwnVMList() {
		return ownVMList;
	}

	/**
	 * 个人VM列表设定
	 * @param ownVMList 个人VM列表
	 */
	public void setOwnVMList(List<VMachine> ownVMList) {
		this.ownVMList = ownVMList;
		if(ownVMList == null) return;
		this.showOwnVMList = new ArrayList<List<VMachine>>();
		List<VMachine> temp = new ArrayList<VMachine>();
		for(int i=0;i<ownVMList.size();i++){
			if(i > 0 && i % 10 == 0){
				showOwnVMList.add(temp);
				temp = new ArrayList<VMachine>();
			}
			temp.add(ownVMList.get(i));
		}
		if(temp.size() > 0){
			showOwnVMList.add(temp);
		}
	}

	/**
	 * 页面显示个人VM列表信息取得
	 * @return showOwnVMList 页面显示个人VM列表信息
	 */
	public List<List<VMachine>> getShowOwnVMList() {
		return showOwnVMList;
	}

	/**
	 * 页面显示个人VM列表信息设定
	 * @param showOwnVMList 页面显示个人VM列表信息
	 */
	public void setShowOwnVMList(List<List<VMachine>> showOwnVMList) {
		this.showOwnVMList = showOwnVMList;
	}

	/**
	 * 模板集合取得
	 * @return templateList 模板集合
	 */
	public List<Template> getTemplateList() {
		return templateList;
	}

	/**
	 * 模板集合设定
	 * @param templateList 模板集合
	 */
	public void setTemplateList(List<Template> templateList) {
		this.templateList = templateList;
	}
}
