/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.drm.action;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.axis.utils.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.utility.CodeListUtils;
import com.deliverik.framework.workflow.prd.bl.task.IG333BL;
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.framework.workflow.prr.bl.task.IG500BL;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.infogovernor.drm.IGDRMCONSTANTS;
import com.deliverik.infogovernor.drm.bl.task.EmergencyLogBL;
import com.deliverik.infogovernor.drm.dto.IGDRM09DTO;
import com.deliverik.infogovernor.drm.model.EmergencyLogInfo;
import com.deliverik.infogovernor.drm.util.IGDRMEmergencyTools;
import com.deliverik.infogovernor.prr.bl.IGPRR01BL;
import com.deliverik.infogovernor.prr.dto.IGPRR01DTO;
import com.google.gson.Gson;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 应急指挥平台-技术恢复dashboard Action
 * </p>
 * 
 * @version 1.0
 */

public class IGDRM0912Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGDRM0912Action.class);
	

	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		IGDRM09DTO dto = new IGDRM09DTO();
		
		if("DISP".equals(mapping .getParameter())){
			String prid = request.getParameter("prid");
			//端口号和IP
			CodeListUtils codeListUtils=(CodeListUtils) WebApplicationSupport.getBean("codeListUtils");
			String port = codeListUtils.getCodeValue("174",null, null, "1");//端口号
			String ip = codeListUtils.getCodeValue("174",null, null, "2");//IP
			//查询流程图信息
			IGPRR01DTO prrDto = new IGPRR01DTO();
			prrDto.setPrid(Integer.valueOf(prid));
			IGPRR01BL prrBL = (IGPRR01BL)getBean("igPRR01BL");
			prrDto = prrBL.searchFlowChartXmlAction(prrDto);
			
			
			//设置request变量
			request.setAttribute("flowCharXml", prrDto.getFlowChartXml());
			request.setAttribute("prid", prid);
			request.setAttribute("port", port);
			request.setAttribute("ip", ip);
			//创建500BL查找prstatus状态
			IG500BL ig500BL = (IG500BL)getBean("ig500BL");
			IG500Info ig500Info = ig500BL.searchIG500InfoByKey(Integer.parseInt(prid));
			//判断状态是否为#，如果为#则为终止状态，在emergencylog表中查找时间最大的取出终止节点
			if("#".equals(ig500Info.getPrstatus())){
				EmergencyLogBL emergencyLogBL = (EmergencyLogBL) getBean("emergencyLogBL");
				EmergencyLogInfo elInfo = emergencyLogBL.findMaxTimeEmergencyLog(prid);
				if(elInfo !=null){
					IG333BL ig333BL = (IG333BL)getBean("ig333BL");
					IG333Info ig333Info = ig333BL.searchIG333InfoByKey(elInfo.getElpsdid());
					if(ig333Info !=null){
						Map<String, Object> stopProcessMap = new HashMap<String, Object>();
						if(StringUtils.isEmpty(ig333Info.getPpsdid())){
							stopProcessMap.put("psdname", ig333Info.getPsdname());
						}else{
							IG333Info ig333InfoParent = ig333BL.searchIG333InfoByKey(ig333Info.getPpsdid());
							stopProcessMap.put("ppsdname",ig333InfoParent.getPsdname());
							stopProcessMap.put("psdname", ig333Info.getPsdname());
						}
						//将map转成json
						Gson stopGson = new Gson();
						request.setAttribute("stopProcess", stopGson.toJson(stopProcessMap));
					}
				}
			}
		}else if("JSON".equals(mapping.getParameter())){
			String type = request.getParameter("type");
			String prid = request.getParameter("prid");
			PrintWriter out = new PrintWriter(new OutputStreamWriter(response.getOutputStream(),"UTF-8")); 
			//总的Map不知道value的确切类型所以用Object
			Map<String, Object> map = new HashMap<String, Object>();
			//左侧流程状态信息获取
			try {
				if(type.equals(IGDRMCONSTANTS.DB_TYPE_MESSAGE)){
					map = IGDRMEmergencyTools.getMessageInfo(prid);//6获取发布的信息,type=3ok
				}else if(type.equals(IGDRMCONSTANTS.DB_TYPE_PROCESS_START)){
					map = IGDRMEmergencyTools.getProcessStartTime(Integer.parseInt(prid));//8流程开始时间ok
				}else if(type.equals(IGDRMCONSTANTS.DB_TYPE_USED_TIME)){
					map = IGDRMEmergencyTools.getProcessUsedTime(Integer.parseInt(prid));//9流程已用时ok
				}else if(type.equals(IGDRMCONSTANTS.DB_TYPE_STOP_TIME)){
					map = IGDRMEmergencyTools.getStopTime(Integer.parseInt(prid));//stopTime 结束时间
				} else if(type.equals(IGDRMCONSTANTS.DB_TYPE_BASE_MSG)){
					map = IGDRMEmergencyTools.getBaseMessage(Integer.parseInt(prid));//baseMsg 基本信息
				}else if(type.equals(IGDRMCONSTANTS.DB_TYPE_FLOW_MSG)){
					map = IGDRMEmergencyTools.getFlow(Integer.parseInt(prid));//flowMsg 流程图
				}else if(type.equals("logMsg")){
					map = IGDRMEmergencyTools.getLogMessage(Integer.parseInt(prid));//logMsg 流程日志
				}else if(type.equals("overTime")){
					map = IGDRMEmergencyTools.getOverTime(Integer.parseInt(prid));//overTime 停止时间
				}else if(type.equals("emergencyFlow")){
					map = IGDRMEmergencyTools.getEmergencyFlow(Integer.parseInt(prid));//emergencyFlow 流程图
				}
				//转换成Json
				Gson gson = new Gson();
				out.print(gson.toJson(map));
			} catch (NumberFormatException e) {
				log.debug("===============prid无法转换成数字===============");
				map.put("emsg", "流程id不正确!");
			} catch (BLException e) {
				log.debug("===============获取信息方法出现错误===============");
				map.put("emsg", "获取数据出错!");
			}finally {
				if (out != null)
					out.close();
			}
			return null;
		}
		
		List<ActionMessage> messageList = dto.getMessageList();
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(request, message);
			}
		}
		
		return mapping.findForward("DISP");
	}
}
