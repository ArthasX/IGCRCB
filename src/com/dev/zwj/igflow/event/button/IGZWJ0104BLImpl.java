package com.dev.zwj.igflow.event.button;

import java.text.SimpleDateFormat;
import java.util.Date;

import nl.justobjects.pushlet.util.Log;

import org.apache.commons.lang.StringUtils;
import org.hyperic.hq.hqapi1.AlertApi;
import org.hyperic.hq.hqapi1.HQApi;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.utility.CodeListUtils;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusButtonHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;
import com.deliverik.infogovernor.syslog.bl.task.Mss00008BL;
import com.deliverik.infogovernor.syslog.bl.task.Mss00009BL;
import com.deliverik.infogovernor.syslog.model.Mss00008Info;
import com.deliverik.infogovernor.syslog.model.entity.Mss00009TB;
import com.deliverik.infogovernor.util.StringEncrypt;

public class IGZWJ0104BLImpl implements WorkFlowStatusButtonHandlerBL {
	
	
	protected FlowSearchBL flowSearchBL;
	
	/** 设备日志表taskBL */
	protected Mss00008BL mss00008BL;
	
	/** 设备日志历史表taskBL */
	protected Mss00009BL mss00009BL;

	public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
		this.flowSearchBL = flowSearchBL;
	}

	public void setMss00008BL(Mss00008BL mss00008BL) {
		this.mss00008BL = mss00008BL;
	}

	public void setMss00009BL(Mss00009BL mss00009BL) {
		this.mss00009BL = mss00009BL;
	}



	public void statusButtonTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		String formValue = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(), "告警ID");
		if(StringUtils.isNotEmpty(formValue)){
			
//			String alarmid = formValue.split("#")[0];
//			String flag = formValue.split("#")[1];
			
			String[] values = formValue.split("#");
			if(values.length == 1){
				CodeListUtils codeListUtils=(CodeListUtils) WebApplicationSupport.getBean("codeListUtils");
				//提取相应的配置信息
				String HQServerIP = codeListUtils.getCodeValue("160", null, null, "1");
				Integer HQServerPort = new Integer(codeListUtils.getCodeValue("160", null, null, "2"));
				String HQServerUsername = codeListUtils.getCodeValue("160", null, null, "3");
				String HQServerPassword = StringEncrypt.asciiToChar(codeListUtils.getCodeValue("160", null, null, "4"));
				try{
					HQApi api = new HQApi(HQServerIP, HQServerPort, false, HQServerUsername, HQServerPassword);
					AlertApi alertApi = api.getAlertApi();
					//获取需要修改的告警ID
					Integer id = Integer.parseInt(values[0]);
					alertApi.fixAlert(id);
				}catch (Exception e){
					Log.error("流程告警修复异常:",e);
				}	
			}else if(values.length == 2 && "syslog".equals(values[1])){
				
				Mss00008Info info = mss00008BL.searchMss00008ByPK(Integer.parseInt(values[0]));
				Date today = new Date();
				SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm");
				
				Mss00009TB mss00009Bean = new Mss00009TB();
				mss00009Bean.setAlarmmsg(info.getAlarmmsg());
				mss00009Bean.setCreatetime(info.getCreatetime());
				String starttime;
				if(StringUtils.isEmpty(info.getStarttime())) starttime = format.format(new Date());
				else starttime = info.getStarttime();
				mss00009Bean.setStarttime(starttime);
				mss00009Bean.setEndtime(format.format(today));
				mss00009Bean.setDeviceid(info.getDeviceid());
				mss00009Bean.setDeviceip(info.getDeviceip());
				mss00009Bean.setDevicename(info.getDevicename());
				mss00009Bean.setIsalarm(info.getIsalarm());
				mss00009Bean.setRulelevel(info.getRulelevel());
				mss00009Bean.setState(1);//设置为已修复状态
				mss00009Bean.setPrid(info.getID());
				mss00009BL.registMss00009(mss00009Bean);
				mss00008BL.deleteMss00008(info);
			}
		}
	}

}
