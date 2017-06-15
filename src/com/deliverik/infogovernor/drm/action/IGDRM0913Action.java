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
import com.deliverik.infogovernor.drm.IGDRMCONSTANTS;
import com.deliverik.infogovernor.drm.dto.IGDRM09DTO;
import com.deliverik.infogovernor.drm.util.IGDRMEmergencyTools;
import com.deliverik.infogovernor.prr.bl.IGPRR01BL;
import com.deliverik.infogovernor.prr.dto.IGPRR01DTO;
import com.google.gson.Gson;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 应急指挥平台-技术恢复dashboard Action-组合场景
 * </p>
 * 
 * @version 1.0
 */

public class IGDRM0913Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGDRM0913Action.class);
	

	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		IGDRM09DTO dto = new IGDRM09DTO();
		
		if("DISP".equals(mapping .getParameter())){
			String prid = request.getParameter("prid");
			String cldtype = request.getParameter("cldtype");
			//端口号和IP
			CodeListUtils codeListUtils=(CodeListUtils) WebApplicationSupport.getBean("codeListUtils");
			String port = codeListUtils.getCodeValue("174",null, null, "1");//端口号
			String ip = codeListUtils.getCodeValue("174",null, null, "2");//IP
			//查询流程图信息
			IGPRR01DTO prrDto = new IGPRR01DTO();
			prrDto.setPrid(Integer.valueOf(prid));
			IGPRR01BL prrBL = (IGPRR01BL)getBean("igPRR01BL");
			//组合场景
			if("0".equals(cldtype)){
				prrDto = prrBL.searchGroupFlowChartXml(prrDto);
			}else{
				prrDto = prrBL.searchFlowChartXmlAction(prrDto);
			}
			//设置request变量
			request.setAttribute("flowCharXml", prrDto.getFlowChartXml());
			System.out.println(prrDto.getFlowChartXml());
			request.setAttribute("prid", prid);
			request.setAttribute("port", port);
			request.setAttribute("ip", ip);
			request.setAttribute("prstatus", prrDto.getStatus());
		}else if("JSON".equals(mapping.getParameter())){
			String type = request.getParameter("type");
			String prid = request.getParameter("prid");
			PrintWriter out = new PrintWriter(new OutputStreamWriter(response.getOutputStream(),"UTF-8")); 
			//总的Map不知道value的确切类型所以用Object
			Map<String, Object> map = new HashMap<String, Object>();
			//左侧流程状态信息获取
			try {
				if(type.equals(IGDRMCONSTANTS.DB_TYPE_NOTICE)){	//1实时追踪			
					map = IGDRMEmergencyTools.getProcessRecordListInit(Integer.parseInt(prid));
				}
				if(type.equals(IGDRMCONSTANTS.DB_TYPE_RELPLAN)){//5预案资产ok
					map = IGDRMEmergencyTools.getRelPlanProcessInfoForScene(Integer.parseInt(prid));
				}
				if(type.equals(IGDRMCONSTANTS.DB_TYPE_MESSAGE)){
					map = IGDRMEmergencyTools.getMessageInfo(prid);//6获取发布的信息,type=3ok
				}
				if(type.equals(IGDRMCONSTANTS.DB_TYPE_PROCESS_START)){
					map = IGDRMEmergencyTools.getProcessStartTime(Integer.parseInt(prid));//8流程开始时间ok
				}else if(type.equals(IGDRMCONSTANTS.DB_TYPE_USED_TIME)){
					map = IGDRMEmergencyTools.getProcessUsedTime(Integer.parseInt(prid));//9流程已用时ok
				}else if(type.equals(IGDRMCONSTANTS.DB_TYPE_PROCESS_STATUS)){
					//10根据流程ID获取该流程当前状态信息
					map = IGDRMEmergencyTools.getProcessStatusForOBDR(Integer.parseInt(prid));
				}else if(type.equals(IGDRMCONSTANTS.DB_TYPE_PROCESS_BUTTON)){
					map = IGDRMEmergencyTools.getIG333InfoForScene(Integer.parseInt(prid));//11实时跟踪按钮
				}
				
				if(type.equals(IGDRMCONSTANTS.DB_TYPE_GROUP_PROCESS_START)){
					//14 - 组流程开始时间
					map = IGDRMEmergencyTools.getGroupProcessStartTime(Integer.parseInt(prid));//8流程开始时间ok
				}else if(type.equals(IGDRMCONSTANTS.DB_TYPE_GROUP_PROCESS_STATUS)){
					//15 流程组-根据流程ID获取该流程当前状态信息
					map = IGDRMEmergencyTools.getGroupProcessStatusForOBDR(Integer.parseInt(prid));
				}else if(type.equals(IGDRMCONSTANTS.DB_TYPE_GROUP_USED_TIME)){
					//16 流程组-使用时间
					map = IGDRMEmergencyTools.getGroupProcessUsedTime(Integer.parseInt(prid));//9流程已用时ok
				}else if(type.equals(IGDRMCONSTANTS.DB_TYPE_GROUP_MESSAGE)){
					//17 流程组-发布消息
					map = IGDRMEmergencyTools.getGroupMessageInfo(Integer.parseInt(prid));//6获取发布的信息,type=3ok
				}else if(type.equals(IGDRMCONSTANTS.DB_TYPE_GROUP_NOTICE)){	
					//18 流程组-已执行 和 正在执行的节点跟踪信息
					map = IGDRMEmergencyTools.getGroupProcessRecordListInit(Integer.parseInt(prid));
				}else if(type.equals(IGDRMCONSTANTS.DB_TYPE_GROUP_PROCESS_BUTTON)){
					//19 流程组--各个节点跟踪信息TAB（已经执行+正在执行）
					map = IGDRMEmergencyTools.getGroupIG333InfoForScene(Integer.parseInt(prid));
				}else if(type.equals(IGDRMCONSTANTS.DB_TYPE_GROUP_PROCESS_RECORD)){
					//20  流程组--各个流程 实例信息
					map = IGDRMEmergencyTools.getGroupProcessList(Integer.parseInt(prid));
				}else if(type.equals(IGDRMCONSTANTS.DB_TYPE_GROUP_TERMINATE_MSG)){
					//21  流程组--中止流程和节点信息
					map = IGDRMEmergencyTools.getTerminateMsgFunc(Integer.parseInt(prid));
				}
				//转换成Json
				Gson gson = new Gson();
				String jsonStr = gson.toJson(map).replaceAll("\'","\"");
				out.print(jsonStr);
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
