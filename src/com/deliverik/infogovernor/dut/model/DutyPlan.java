/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.dut.model;

import java.util.List;

import com.deliverik.framework.base.BaseModel;
import com.deliverik.infogovernor.dut.model.entity.DutyPersonTB;

/**
 * 值班计划实体接口
 */
public interface DutyPlan extends BaseModel {	
	
	/**
	 * 检查项ID
	 */
	public Integer getDpid();

	/**
	 * 值班类型
	 */
	public String getDadcategory();
	
	/**
	 * 值班日期
	 */
	public String getDptime();
	
	/**
	 * 白班/夜班
	 */
	public String getDptype();
	
	/**
	 * 状态
	 */
	public String getDpstatus();
	
	/**
	 * 遗留问题
	 */
	public String getDpquestion();
	
	/**
	 * 总结
	 */
	public String getDpinfo();
	
	/**
	 * 交班人ID
	 */
	public String getDpuserid();
	
	/**
	 * 交班人姓名
	 */
	public String getDpusername();
	
	/**
	 * 登记时间
	 */
	public String getDpcretime();
	
	/**
	 * 更新时间
	 */
	public String getDpupdtime();
	
	/**
	 * 交班时间
	 */
	public String getDpfintime();
	
	/**
	 * dpremarks取得
	 *
	 * @return dpremarks dpremarks
	 */
	public String getDpremarks();
	
	/**
     * 
	 * 值班人取得
	 * @return 值班人
	 */
	public List<DutyPersonTB> getDutyPersonList();
	
	/**
     * 
	 * 全部值班人名称取得
	 * @return 全部值班人名称
	 */
	public String getDutyPersonName();

}
