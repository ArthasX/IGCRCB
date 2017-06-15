/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.soc.aut.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0124Info;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 流程管理_变更管理_查询VO
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGAUT02021VO extends BaseVO implements Serializable {
	
	public IGAUT02021VO(){}
	public IGAUT02021VO(List<SOC0124Info> entityItemVWInfoList){
		this.entityItemVWInfoList = entityItemVWInfoList;
	}

	protected List<SOC0124Info> entityItemVWInfoList;

	/** 域ID */
	protected Integer domainid;
	
	/** 域版本 */
	protected Integer domainversion;
	/** 快照生成时间 */
	protected String createtime;
	
	/** 是否显示逻辑关系MAP */
	protected Map<String,String> showRelationMap;
	
	public List<SOC0124Info> getEntityItemVWInfoList() {
		return entityItemVWInfoList;
	}
	public void setEntityItemVWInfoList(List<SOC0124Info> entityItemVWInfoList) {
		this.entityItemVWInfoList = entityItemVWInfoList;
	}
	public Integer getDomainid() {
		return domainid;
	}
	public void setDomainid(Integer domainid) {
		this.domainid = domainid;
	}
	public Integer getDomainversion() {
		return domainversion;
	}
	public void setDomainversion(Integer domainversion) {
		this.domainversion = domainversion;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public Map<String, String> getShowRelationMap() {
		return showRelationMap;
	}
	public void setShowRelationMap(Map<String, String> showRelationMap) {
		this.showRelationMap = showRelationMap;
	}
	
	
	
}
