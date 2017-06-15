/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */


package com.csebank.lom.model;
import com.deliverik.framework.user.model.entity.OrganizationTB;

/**
 * 
 *  接待客人查询实体接口
 * 
 * @author piaow@deliverik.com
 * 
 */

public interface RecptionGuestInfo {
	/**
	 * 接待客人查询RID取得
	 * 
	 * @return 接待客人查询RID
	 */
	public Integer getRid();

	/**
	 * 接待客人查询RNAME取得
	 * 
	 * @return 接待工作名称
	 */
	public String getRname();
	
	/**
	 * 接待客人查询RAPPORGID取得
	 * 
	 * @return 主要申请部门
	 */
	public String getRapporgId();
	
	/**
	 * 接待客人查询RSTIME取得
	 * 
	 * @return 接待开始日期
	 */
	public String getRstime();
	
	/**
	 * 接待客人查询RETIME取得
	 * 
	 * @return 接待结束日期
	 */
	public String getRetime();

	/**
	 * 接待客人查询RPPORG取得
	 * 
	 * @return 其他参与部门
	 */
	public String getRpporg();

	/**
	 * 接待客人查询RDESCRIPTION取得
	 * 
	 * @return 接待内容描述
	 */
	public String getRdescription();
	
	public OrganizationTB getOrganizationTB();

}