/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.sym.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.sym.model.Notice;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 系统管理_通知管理_查询VO
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGSYM05011VO extends BaseVO implements Serializable {

	/**
	 * 通知对象List
	 */
	
	protected List<Notice> noticecondList;

	/**
	 * 构造方法
	 * @param noticecondList List<Notice>
	 */
	
	public IGSYM05011VO(List<Notice> noticecondList) {
		this.noticecondList = noticecondList;
	}
	
	/**
	 * 获取通知对象List
	 * @return List<Notice>
	 */
	
	public List<Notice> getNoticecondList() {
		return noticecondList;
	}
}
