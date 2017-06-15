/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
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
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.utility.CodeListUtils;
import com.deliverik.infogovernor.drm.IGDRMCONSTANTS;
import com.deliverik.infogovernor.drm.dto.IGDRM09DTO;
import com.deliverik.infogovernor.drm.util.IGDRMEmergencyTools;
import com.google.gson.Gson;


/**
 * 应急指挥流程Action
 * @author zyl
 * 
 * 2015年3月25日13:50:42
 */
public class IGDRM0911Action extends BaseAction {

	static Log log = LogFactory.getLog(IGDRM0911Action.class);

	/**
	 * 
	 *
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 * @throws Exception 
	 */
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//实例化DTO
		IGDRM09DTO dto = new IGDRM09DTO();
		//跳转页面
		String forward = "DISP";
		//初始化页面
		if("DISP".equals(mapping.getParameter())){
			log.debug("========应急流程指挥图DashBoard初始化处理开始========");
			//获取prid
			String prid = request.getParameter("prid");
			//端口号和IP
			CodeListUtils codeListUtils=(CodeListUtils) WebApplicationSupport.getBean("codeListUtils");
			String port = codeListUtils.getCodeValue("174",null, null, "1");//端口号
			String ip = codeListUtils.getCodeValue("174",null, null, "2");//IP
			
			//设置request变量
			request.setAttribute("prid", prid);
			request.setAttribute("port", port);
			request.setAttribute("ip", ip);
			log.debug("========应急流程指挥图DashBoard初始化处理终了========");
		}
		
		//获取应急指挥流程初始化DashBoard的Json对象
		//'1'获取实时追踪日志信息、'2'获取流程状态信息列表、'3'获取就位人员信息、'4'获取事件信息、'5'获取预案资产信息'6'信息发布'7'获取进度百分比
		//8流程开始时间、9流程已用时、10应急资源
		if("GETJSONDATA".equals(mapping.getParameter())){
			PrintWriter out = null;
			
			//左侧流程状态信息获取
			try {
				out =  new PrintWriter( new OutputStreamWriter(response.getOutputStream(), "utf-8"));
				//获取prid
				String prid = request.getParameter("prid");
				String showType = request.getParameter("showType");
				//总的Map不知道value的确切类型所以用Object
				Map<String, Object> map = new HashMap<String, Object>();
				if(showType.equals(IGDRMCONSTANTS.DB_TYPE_NOTICE)){	//1实时追踪			
					map = IGDRMEmergencyTools.getProcessRecordListInit(Integer.parseInt(prid));
				}else if(showType.equals(IGDRMCONSTANTS.DB_TYPE_PROCESS)){//2应急指挥-流程图 not ok
					map = IGDRMEmergencyTools.getProcessStatusListInit(Integer.parseInt(prid));
				}else if(showType.equals(IGDRMCONSTANTS.DB_TYPE_INPLACE)){//3人员
					map = IGDRMEmergencyTools.getRestpreDecLayInPlaceList(Integer.parseInt(prid));				
				}else if(showType.equals(IGDRMCONSTANTS.DB_TYPE_EMCINFO)){//4事件信息
					map = IGDRMEmergencyTools.getEmergencyProcessInfo(Integer.parseInt(prid));
				}else if(showType.equals(IGDRMCONSTANTS.DB_TYPE_RELPLAN)){//5预案资产
					map = IGDRMEmergencyTools.getRelPlanProcessInfo(Integer.parseInt(prid));
				}else if(showType.equals(IGDRMCONSTANTS.DB_TYPE_MESSAGE)){
					map = IGDRMEmergencyTools.getMessageInfo(prid);//6获取发布的信息,type=3
				}else if(showType.equals(IGDRMCONSTANTS.DB_TYPE_PERCENT)){
					map = IGDRMEmergencyTools.getPercentNum(Integer.parseInt(prid));//7获取进度百分比
				}else if(showType.equals(IGDRMCONSTANTS.DB_TYPE_PROCESS_START)){
					map = IGDRMEmergencyTools.getProcessStartTime(Integer.parseInt(prid));//8流程开始时间
				}else if(showType.equals(IGDRMCONSTANTS.DB_TYPE_USED_TIME)){
					map = IGDRMEmergencyTools.getProcessUsedTime(Integer.parseInt(prid));//9流程已用时
				}else if(showType.equals(IGDRMCONSTANTS.DB_TYPE_SOC_MSG)){
					map = IGDRMEmergencyTools.getSocMap(Integer.parseInt(prid));//22流程应急资源
				}else if(showType.equals("systemTime")){
					map = IGDRMEmergencyTools.getSystemTime();
				}
					
				//转换成Json
				Gson gson = new Gson();
				System.out.println(gson.toJson(map));
				out.print(gson.toJson(map));
			} catch (NumberFormatException e) {
				log.debug("===============prid无法转换成数字===============");
				e.printStackTrace();
			} catch (BLException e) {
				log.debug("===============获取信息方法出现错误===============");
				e.printStackTrace();
			}catch (Exception e) {
				out.print("");
				log.error("AjaxAction Exception", e);
			} finally {
				if (out != null)
					out.close();
			}
			return null;
		}
		
		if("GETTYPE".equals(mapping.getParameter())){
			PrintWriter out = null;
			//左侧流程状态信息获取
			try {
				out =  new PrintWriter( new OutputStreamWriter(response.getOutputStream(), "utf-8"));
				//获取prid
				String prid = request.getParameter("curPrid");
				//场景类型- 0：单一场景 1：复合场景
				String cldtype = IGDRMEmergencyTools.getSence(Integer.parseInt(prid));//9流程已用时
				out.print(cldtype);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (out != null)
					out.close();
			}
			return null;
		}
		 // 通过应急指挥流程id 获取正在运行的技术恢复流程id
		if("GETRESTORYPRID".equals(mapping.getParameter())){
			PrintWriter out = new PrintWriter(new OutputStreamWriter(response.getOutputStream(),"UTF-8")); 
			String parPrid = request.getParameter("parPrid");
			FlowSearchBL flowSearchBL = (FlowSearchBL)getBean("flowSearchBL");
			List<Integer> cldPrids = flowSearchBL.searchProcessRelationForCld(Integer.valueOf(parPrid));
			Integer cldPrid = null;
			for (Integer prid : cldPrids) {
				if(cldPrid == null|| cldPrid<prid){
					cldPrid = prid;
				}
			}
			out.write(cldPrid.toString());
			return null;
		}
		List<ActionMessage> messageList = dto.getMessageList();
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {
				addMessage(request, message);
			}
		}
		return mapping.findForward(forward);
	}
}
