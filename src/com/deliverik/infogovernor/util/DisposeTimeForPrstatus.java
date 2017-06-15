 /*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.util;

import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.workflow.prr.bl.task.IG224BL;
import com.deliverik.framework.workflow.prr.model.IG224Info;
import com.deliverik.framework.workflow.prr.model.condition.IG224SearchCondImpl;

/**
 * 计算流程状态中处理人的处理时间
 * 
 */
public class DisposeTimeForPrstatus {

	static Log log = LogFactory.getLog(DisposeTimeForPrstatus.class);

	/**
	 * 计算状态参与人的处理时间
	 * 
	 * @param prid 流程ID
	 * @param psdcode 流程状态
	 * @param confirm_flag 流程是否有确认动作ID
	 * @return Integer
	 */
	public static Integer getCountTime(Integer prid, String psdid, boolean confirm_flag) {
		//流程状态信息查询BL
		IG224BL ig224BL = (IG224BL)WebApplicationSupport.getBean("ig224BL");
		
		//查询流程状态下所有的处理时间
		IG224SearchCondImpl cond224 = new IG224SearchCondImpl();
		//流程ID
		cond224.setPrid(prid);
		//当前状态标识
		cond224.setPsdid(psdid);
		//当前参与人
		List<IG224Info> lstStatusLog = ig224BL.searchIG224Info(cond224, 0, 0);
		
		//流程处理总时间
		long sumTime = 0;
		//获取流程处理总时间
		for (int i = 0; i < lstStatusLog.size(); i++) {
			//流程处理开始时间
			Date openTime = lstStatusLog.get(i).getRslOpenTime();
			//流程处理结束时间
			Date closeTime = lstStatusLog.get(i).getRslCloseTime();
			//如果结束时间为空即未处理完成 按当前系统时间计算
			if (closeTime == null) {
				closeTime = new Date();
			}
			//计算处理总时间的毫秒数
			sumTime += (closeTime.getTime() - openTime.getTime());
		}
		//获取处理总时长 单位（分钟）
		Integer minute = (int) (sumTime / (1000 * 60));
		return minute;
	}
}
