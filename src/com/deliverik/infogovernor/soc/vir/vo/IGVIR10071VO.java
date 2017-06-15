/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.soc.vir.vo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.com.model.ProcessInHandVWInfo;
import com.deliverik.infogovernor.soc.vir.vim.model.Host;
import com.deliverik.infogovernor.soc.vir.vim.model.Template;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 资源管理首页VO
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGVIR10071VO extends BaseVO{
	
	/** 待办工作集合 */
	protected List<ProcessInHandVWInfo> pihList;
	
	/**模板集合*/
	protected List<Template> templateList;
	
	/** Host信息集合 */
	protected Map<Integer, List<Host>> hostMap;
	
	/** 首页显示Host */
	protected List<List<Map<Integer, Host>>> showHostList;
	
	/** 首页显示Host */
	
	/** 申请趋势统计Map */
	protected Map<String, Integer> vmReportMap;
	
	/** 运维流程趋势Map */
	protected Map<String, Map<String, Integer>> prRecportMap;

	/**
	 * 待办工作集合取得
	 * @return pihList 待办工作集合
	 */
	public List<ProcessInHandVWInfo> getPihList() {
		return pihList;
	}

	/**
	 * 待办工作集合设定
	 * @param pihList 待办工作集合
	 */
	public void setPihList(List<ProcessInHandVWInfo> pihList) {
		this.pihList = pihList;
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

	/**
	 * Host信息集合取得
	 * @return hostMap Host信息集合
	 */
	public Map<Integer, List<Host>> getHostMap() {
		return hostMap;
	}

	/**
	 * Host信息集合设定
	 * @param hostMap Host信息集合
	 */
	public void setHostMap(Map<Integer, List<Host>> hostMap) {
		this.hostMap = hostMap;
		if(hostMap != null){
			this.showHostList = new ArrayList<List<Map<Integer,Host>>>();
			List<Map<Integer, Host>> temp = new ArrayList<Map<Integer,Host>>();
			int index = 0;
			for(Iterator<Entry<Integer, List<Host>>> iter = hostMap.entrySet().iterator();iter.hasNext();){
				Entry<Integer, List<Host>> next = iter.next();
				Integer key = next.getKey();
				List<Host> list = next.getValue();
				for(Host host : list){
					if(index > 0 && index % 6 == 0){
						showHostList.add(temp);
						temp = new ArrayList<Map<Integer,Host>>();
					}
					Map<Integer, Host> map = new HashMap<Integer, Host>();
					map.put(key, host);
					temp.add(map);
					index ++;
				}
			}
			if(temp.size() > 0){
				showHostList.add(temp);
			}
		}
	}

	/**
	 * 首页显示Host取得
	 * @return showHostList 首页显示Host
	 */
	public List<List<Map<Integer, Host>>> getShowHostList() {
		return showHostList;
	}

	/**
	 * 首页显示Host设定
	 * @param showHostList 首页显示Host
	 */
	public void setShowHostList(List<List<Map<Integer, Host>>> showHostList) {
		this.showHostList = showHostList;
	}

	/**
	 * 申请趋势统计Map取得
	 * @return vmReportMap 申请趋势统计Map
	 */
	public Map<String, Integer> getVmReportMap() {
		return vmReportMap;
	}

	/**
	 * 申请趋势统计Map设定
	 * @param vmReportMap 申请趋势统计Map
	 */
	public void setVmReportMap(Map<String, Integer> vmReportMap) {
		this.vmReportMap = vmReportMap;
	}

	/**
	 * 运维流程趋势Map取得
	 * @return prRecportMap 运维流程趋势Map
	 */
	public Map<String, Map<String, Integer>> getPrRecportMap() {
		return prRecportMap;
	}

	/**
	 * 运维流程趋势Map设定
	 * @param prRecportMap 运维流程趋势Map
	 */
	public void setPrRecportMap(Map<String, Map<String, Integer>> prRecportMap) {
		this.prRecportMap = prRecportMap;
	}
}
