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
import com.deliverik.infogovernor.soc.vir.vim.model.Host;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 虚拟化管理首页VO
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGVIR10051VO extends BaseVO{

	/** 申请数量 */
	protected Integer countS = 0;
	
	/** 调整数量 */
	protected Integer countT = 0;
	
	/** 回收数量 */
	protected Integer countH = 0;
	
	/** 本月申请数量 */
	protected Integer countS_C = 0;
	
	/** 本月调整数量 */
	protected Integer countT_C = 0;
	
	/** 本月回收数量 */
	protected Integer countH_C = 0;
	
	/** Host信息集合 */
	protected Map<Integer, List<Host>> hostMap;
	
	/** 首页显示Host */
	protected List<List<Map<Integer, Host>>> showHostList;
	
	/** 部门申请top5数据 */
	protected Map<String, Integer> top5Map;
	
	/** 申请年度趋势 */
	protected List<Integer> monthCountS;
	
	/** 调整年度趋势 */
	protected List<Integer> monthCountT;
	
	/** 回收年度趋势 */
	protected List<Integer> monthCountH;

	/**
	 * 申请数量取得
	 * @return countS 申请数量
	 */
	public Integer getCountS() {
		return countS;
	}
	
	/**
	 * 申请数量取得
	 * @return countS 申请数量
	 */
	public String getCountSImg() {
		return numberConvertToImage(countS);
	}

	/**
	 * 申请数量设定
	 * @param countS 申请数量
	 */
	public void setCountS(Integer countS) {
		this.countS = countS;
	}

	/**
	 * 调整数量取得
	 * @return countT 调整数量
	 */
	public Integer getCountT() {
		return countT;
	}
	
	/**
	 * 调整数量取得
	 * @return countT 调整数量
	 */
	public String getCountTImg() {
		return numberConvertToImage(countT);
	}

	/**
	 * 调整数量设定
	 * @param countT 调整数量
	 */
	public void setCountT(Integer countT) {
		this.countT = countT;
	}

	/**
	 * 回收数量取得
	 * @return countH 回收数量
	 */
	public Integer getCountH() {
		return countH;
	}
	
	/**
	 * 回收数量取得
	 * @return countH 回收数量
	 */
	public String getCountHImg() {
		return numberConvertToImage(countH);
	}

	/**
	 * 回收数量设定
	 * @param countH 回收数量
	 */
	public void setCountH(Integer countH) {
		this.countH = countH;
	}

	/**
	 * 本月申请数量取得
	 * @return countS_C 本月申请数量
	 */
	public Integer getCountS_C() {
		return countS_C;
	}

	/**
	 * 本月申请数量设定
	 * @param countS_C 本月申请数量
	 */
	public void setCountS_C(Integer countS_C) {
		this.countS_C = countS_C;
	}

	/**
	 * 本月调整数量取得
	 * @return countT_C 本月调整数量
	 */
	public Integer getCountT_C() {
		return countT_C;
	}

	/**
	 * 本月调整数量设定
	 * @param countT_C 本月调整数量
	 */
	public void setCountT_C(Integer countT_C) {
		this.countT_C = countT_C;
	}

	/**
	 * 本月回收数量取得
	 * @return countH_C 本月回收数量
	 */
	public Integer getCountH_C() {
		return countH_C;
	}

	/**
	 * 本月回收数量设定
	 * @param countH_C 本月回收数量
	 */
	public void setCountH_C(Integer countH_C) {
		this.countH_C = countH_C;
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
	 * 部门申请top5数据取得
	 * @return top5Map 部门申请top5数据
	 */
	public Map<String, Integer> getTop5Map() {
		return top5Map;
	}

	/**
	 * 部门申请top5数据设定
	 * @param top5Map 部门申请top5数据
	 */
	public void setTop5Map(Map<String, Integer> top5Map) {
		this.top5Map = top5Map;
	}

	/**
	 * 申请年度趋势取得
	 * @return monthCountS 申请年度趋势
	 */
	public List<Integer> getMonthCountS() {
		return monthCountS;
	}

	/**
	 * 申请年度趋势设定
	 * @param monthCountS 申请年度趋势
	 */
	public void setMonthCountS(List<Integer> monthCountS) {
		this.monthCountS = monthCountS;
	}

	/**
	 * 调整年度趋势取得
	 * @return monthCountT 调整年度趋势
	 */
	public List<Integer> getMonthCountT() {
		return monthCountT;
	}

	/**
	 * 调整年度趋势设定
	 * @param monthCountT 调整年度趋势
	 */
	public void setMonthCountT(List<Integer> monthCountT) {
		this.monthCountT = monthCountT;
	}

	/**
	 * 回收年度趋势取得
	 * @return monthCountH 回收年度趋势
	 */
	public List<Integer> getMonthCountH() {
		return monthCountH;
	}

	/**
	 * 回收年度趋势设定
	 * @param monthCountH 回收年度趋势
	 */
	public void setMonthCountH(List<Integer> monthCountH) {
		this.monthCountH = monthCountH;
	}

	/**
	 * 数字装换为图片
	 * @param number 数字
	 * @return 图片HTML
	 */
	private String numberConvertToImage(Integer number){
		StringBuffer numStr = new StringBuffer();
		if(number == null || number == 0){
			numStr.append("<img src=\"images/number/0.png\" width=\"22\" height=\"29\"/>&nbsp;");
			numStr.append("<img src=\"images/number/0.png\" width=\"22\" height=\"29\"/>");
		}else if(number >= 99){
			numStr.append("<img src=\"images/number/9.png\" width=\"22\" height=\"29\"/>&nbsp;");
			numStr.append("<img src=\"images/number/9.png\" width=\"22\" height=\"29\"/>");
		}else if(number > 9){
			String s = number.toString();
			numStr.append("<img src=\"images/number/");
			numStr.append(s.charAt(0));
			numStr.append(".png\" width=\"22\" height=\"29\"/>&nbsp;");
			numStr.append("<img src=\"images/number/");
			numStr.append(s.charAt(1));
			numStr.append(".png\" width=\"22\" height=\"29\"/>");
		}else{
			numStr.append("<img src=\"images/number/0.png\" width=\"22\" height=\"29\"/>&nbsp;");
			numStr.append("<img src=\"images/number/");
			numStr.append(number);
			numStr.append(".png\" width=\"22\" height=\"29\"/>");
		}
		return numStr.toString();
	}
}
