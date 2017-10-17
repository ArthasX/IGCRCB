package com.dev.crc.igflow.event.status;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;




import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.igflow.api.Constants;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.igflow.api.FlowSetBL;
import com.deliverik.framework.igflow.parameter.WorkFlowLog;
import com.deliverik.framework.igflow.resultset.ParticipantInfo;
import com.deliverik.framework.igflow.resultset.ProcessRecordInfo;
import com.deliverik.framework.utility.ResourceUtility;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;
import com.deliverik.infogovernor.drm.util.IGDRMEmergencyTools;
import com.dev.hac.util.ComUtil;
import com.google.gson.Gson;

public class IGCRC3004BLImpl extends BaseBLImpl implements WorkFlowEventHandlerBL{
	static Log log = LogFactory.getLog(IGCRC3004BLImpl.class);
	/** 查询类API */
	protected FlowSearchBL flowSearchBL;
	
	/** 更新功能API类 */
	private FlowSetBL flowSetBL;
	
	public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
		this.flowSearchBL = flowSearchBL;
	}


	public void setFlowSetBL(FlowSetBL flowSetBL) {
		this.flowSetBL = flowSetBL;
	}


	/**
	 * 变更执行节点前处理
	 */
	public void preTreatmentExecute(final WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		log.debug("========堡垒机接口发送数据处理开始========");
		Integer prid = bean.getLogInfo().getPrid();
		//请求地址通过业务系统ID更新业务系统应急演练状态
		String desc = IGDRMEmergencyTools.getDesc(prid);
		IGDRMEmergencyTools.changeFlowSystemState(prid, "5",desc);
		
		//变更类型
		String bgtype = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(), "变更类别");
		
		//计划开始执行时间
		String starttime = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(), "计划执行开始时间");
		//计划结束执行时间
		String endtime = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(), "计划执行结束时间");
		
		final List<ProcessRecordInfo> processInfo = flowSearchBL.searchProcessInfo(bean.getLogInfo().getPrid(),null);
		//查询当前结点所有参与人
		List<ParticipantInfo> list = flowSearchBL.searchStatusParticipantByCode(bean.getLogInfo().getPrid(), bean.getAfstatus());
		//发起人
		String operator = list.get(0).getUserid();
		//流程名称
		String reason = processInfo.get(0).getPrtitle();
		//流程单号
		String workNoteNumber = processInfo.get(0).getPrserialnum();
		//拼接需要传递的数据
		Map<String,Object> dataMap = new HashMap<String,Object>();
		//port数据
		List<Map<String,Object>> portMap = new ArrayList<Map<String,Object>>();
		
		//基础数据
		Map<String,String>jcMap = new HashMap<String,String>();
		jcMap.put("endTime",endtime.replace("/", "-"));
		jcMap.put("operator",operator);
		jcMap.put("reason",reason);
		jcMap.put("startTime",starttime.replace("/", "-"));
		jcMap.put("workNoteNumber",workNoteNumber);
		//调用HTTP接口请求
		String url = ResourceUtility.getString("EMERGENT_URL");
		if(bgtype.equals("常规变更")){
			String[] gxpt = (flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(), "更新平台").replace("cv_cev_", "")).split("#");
			dataMap.put("workNote",jcMap );
			dataMap.put("groupname",gxpt);
			url = ResourceUtility.getString("NORMAL_URL");
		}else{
			//向hac推送数据
			List<Map<String,Object>> maplist = (List<Map<String, Object>>) flowSearchBL.searchPublicTableValue("平台详细信息", prid,null);
			/*[
				{更新平台名称=EAST报送系统, 平台信息=SSH:cyccall/watch;, HAC数据=7772&12901|12903;},
				{更新平台名称=人民币冠字号管理系统, 平台信息=SSH:cyccall/watch;, HAC数据=7772&12901|12903;}
			]*/
			//平台名称数据
			String[] ptname = new String[maplist.size()];
			//循环推送数据
			if(maplist.size()>0){
				for(int i=0;i<maplist.size();i++){
					String name = maplist.get(i).get("更新平台名称").toString();
					String[] hacData = maplist.get(i).get("HAC数据").toString().split(";");
					for(String onedata:hacData){
						String[] fendata = onedata.split("&");
						Map<String,Object> portOne = new HashMap<String,Object>();
						portOne.put("portId", fendata[0]);
						portOne.put("accountId", (fendata[1].split("\\|")));
						//port存入数据
						portMap.add(portOne);
					}
					//平台名称插入数据
					ptname[i] = name;
					
				}
			}
			dataMap.put("workNote",jcMap );
			dataMap.put("port",portMap );
			dataMap.put("groupname",ptname);
			
		}
		
		Gson gson = new Gson();
		String json = gson.toJson(dataMap);
		log.info("========堡垒机接口发送数据:========"+json);
				
        //获取到返回的数据
        final Map<String,Object> jsonmap =  ComUtil.httpRequest(url, "POST", json);
        if(jsonmap==null){
        	Thread deployThread = new Thread(){
     			@Override
     			public void run() {
     				//添加流程日志表
     				WorkFlowLog wfl = new WorkFlowLog();
     				wfl.setPrid(bean.getLogInfo().getPrid());
     				wfl.setExecutorid(processInfo.get(0).getPruserid());	
     				wfl.setExecutorRoleid(processInfo.get(0).getPrroleid());
     				wfl.setAuthuserid("");
     				wfl.setComment("堡垒机通讯接口无法连通:conncet failed");
     				try {
 						flowSetBL.setProcessLog(wfl, "与堡垒机通讯失败", Constants.PROCESS_LOG_TYPE_PROCESSING);
 					} catch (BLException e) {
 						e.printStackTrace();
 					}
     			}
     		};
     		deployThread.start();
     		log.error("========堡垒机通讯接口无法连通:conncet failed========");
         	throw new BLException("IGHAC0101.E001", "与堡垒机通讯失败");
        }else{
        	 if(jsonmap.get("success").toString()=="false"){
         		Thread deployThread = new Thread(){
         			@Override
         			public void run() {
         				//添加流程日志表
         				WorkFlowLog wfl = new WorkFlowLog();
         				wfl.setPrid(bean.getLogInfo().getPrid());
         				wfl.setExecutorid(processInfo.get(0).getPruserid());	
         				wfl.setExecutorRoleid(processInfo.get(0).getPrroleid());
         				wfl.setAuthuserid("");
         				wfl.setComment("错误码："+jsonmap.get("errorCode").toString()+"；错误信息："+jsonmap.get("errorMessage").toString()+"；");
         				try {
     						flowSetBL.setProcessLog(wfl, "与堡垒机通讯失败", Constants.PROCESS_LOG_TYPE_PROCESSING);
     						log.error("========堡垒机通讯接口失败========错误码："+jsonmap.get("errorCode").toString()+"；错误信息："+jsonmap.get("errorMessage").toString()+"；");
     					} catch (BLException e) {
     						e.printStackTrace();
     					}
         			}
         		};
         		deployThread.start();
             	throw new BLException("IGHAC0101.E001", jsonmap.get("errorMessage").toString());
             }
        }
        log.debug("========堡垒机接口发送数据处理结束========");
    }
       

	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		// TODO Auto-generated method stub
		Integer prid = bean.getLogInfo().getPrid();
		//请求地址通过业务系统ID更新业务系统应急演练状态
		IGDRMEmergencyTools.changeFlowSystemState(prid, "4",null);
	}

}
