/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.prr.vo;

import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.user.model.UserRoleInfo;
import com.deliverik.infogovernor.prr.model.CopyReadUserInfo;

/**
 * 概述:抄阅人查询 
 * 功能描述：抄阅人查询
 * 创建人：赵梓廷
 * 创建记录： 2013-02-25
 * 修改记录：
 */
@SuppressWarnings("serial")
public class IGPRR01141VO extends BaseVO {

	/**页面map集合*/	
	protected Map<String,List<UserRoleInfo>> map_cru;
	
	/**查询结果*/
	protected List<CopyReadUserInfo> list;

	private Map<String,String> detailPgMap;
	public Map<String, List<UserRoleInfo>> getMap_cru() {
		return map_cru;
	}

	public void setMap_cru(Map<String, List<UserRoleInfo>> map_cru) {
		this.map_cru = map_cru;
	}
	/**
	 * 查询结果取得
	 * @return 查询结果
	 */
	public List<CopyReadUserInfo> getList() {
		return list;
	}
	/**
	 * 查询结果设定
	 *
	 * @param user 查询结果
	 */
	public void setList(List<CopyReadUserInfo> list) {
		this.list = list;
	}
	public void setDetailPgMap(Map<String,String> detailPgMap) {
		this.detailPgMap = detailPgMap;
	}

	public Map<String, String> getDetailPgMap() {
		return detailPgMap;
	}
	
}
