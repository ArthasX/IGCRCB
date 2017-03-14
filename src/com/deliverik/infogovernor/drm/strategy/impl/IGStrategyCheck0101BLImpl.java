package com.deliverik.infogovernor.drm.strategy.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import nl.justobjects.pushlet.util.Log;

import com.deliverik.infogovernor.crc.bl.task.IgalarmBL;
import com.deliverik.infogovernor.crc.model.IgalarmInfo;
import com.deliverik.infogovernor.crc.model.condition.IgalarmSearchCondImpl;
import com.deliverik.infogovernor.drm.strategy.StrategyCheckBL;

/**
 * 核心业务系统主备机故障触发规则
 * @author crcb
 *
 */
public class IGStrategyCheck0101BLImpl implements StrategyCheckBL {
	
	
	protected IgalarmBL igalarmBL;
	
	

	public void setIgalarmBL(IgalarmBL igalarmBL) {
		this.igalarmBL = igalarmBL;
	}


	/**
	 * 根据参数给定的IP查询是否满足触发条件
	 */
	public boolean check(Object... objects) {
		
		Log.debug("===============触发条件特殊处理bl开始====================");
		boolean result = true;
		
		String alarmMsg = objects[0].toString();
		
		String argStr = objects[1].toString();
		String[] args = argStr.trim().split("[\\s ]");
		
		for (String string : args) {
			
			if(StringUtils.isEmpty(string)){
				continue;
			}
			
			IgalarmSearchCondImpl cond = new IgalarmSearchCondImpl();
			cond.setIpaddr(string.trim());
			//正常状态的告警
			cond.setShieldflag("0");
			cond.setStatus("0");
			List<IgalarmInfo> igalarmList = igalarmBL.searchIgalarm(cond);
			if(igalarmList.size()==0){
				result = false;
				Log.warn("没有找到IP地址为："+string+"的设备发生告警，不能构成触发条件");
				break;
			}
			
		}
		Log.debug("===============触发条件特殊处理bl开始====================");
		return result;
	}
	
	
	public static void main(String[] arg3s) {
	String alarmMsg = "";
		
		String argStr = " sjdfj shdfk sfsdf 343 34jh3 ".toString();
		String[] args = argStr.trim().split("[\\s ]");
		System.out.println("长度"+args.length);
		for (String string : args) {
			System.out.println("neirngo>"+string);
		}
	}

}
