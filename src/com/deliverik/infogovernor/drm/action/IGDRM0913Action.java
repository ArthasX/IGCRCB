/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
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
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: Ӧ��ָ��ƽ̨-�����ָ�dashboard Action-��ϳ���
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
			//�˿ںź�IP
			CodeListUtils codeListUtils=(CodeListUtils) WebApplicationSupport.getBean("codeListUtils");
			String port = codeListUtils.getCodeValue("174",null, null, "1");//�˿ں�
			String ip = codeListUtils.getCodeValue("174",null, null, "2");//IP
			//��ѯ����ͼ��Ϣ
			IGPRR01DTO prrDto = new IGPRR01DTO();
			prrDto.setPrid(Integer.valueOf(prid));
			IGPRR01BL prrBL = (IGPRR01BL)getBean("igPRR01BL");
			//��ϳ���
			if("0".equals(cldtype)){
				prrDto = prrBL.searchGroupFlowChartXml(prrDto);
			}else{
				prrDto = prrBL.searchFlowChartXmlAction(prrDto);
			}
			//����request����
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
			//�ܵ�Map��֪��value��ȷ������������Object
			Map<String, Object> map = new HashMap<String, Object>();
			//�������״̬��Ϣ��ȡ
			try {
				if(type.equals(IGDRMCONSTANTS.DB_TYPE_NOTICE)){	//1ʵʱ׷��			
					map = IGDRMEmergencyTools.getProcessRecordListInit(Integer.parseInt(prid));
				}
				if(type.equals(IGDRMCONSTANTS.DB_TYPE_RELPLAN)){//5Ԥ���ʲ�ok
					map = IGDRMEmergencyTools.getRelPlanProcessInfoForScene(Integer.parseInt(prid));
				}
				if(type.equals(IGDRMCONSTANTS.DB_TYPE_MESSAGE)){
					map = IGDRMEmergencyTools.getMessageInfo(prid);//6��ȡ��������Ϣ,type=3ok
				}
				if(type.equals(IGDRMCONSTANTS.DB_TYPE_PROCESS_START)){
					map = IGDRMEmergencyTools.getProcessStartTime(Integer.parseInt(prid));//8���̿�ʼʱ��ok
				}else if(type.equals(IGDRMCONSTANTS.DB_TYPE_USED_TIME)){
					map = IGDRMEmergencyTools.getProcessUsedTime(Integer.parseInt(prid));//9��������ʱok
				}else if(type.equals(IGDRMCONSTANTS.DB_TYPE_PROCESS_STATUS)){
					//10��������ID��ȡ�����̵�ǰ״̬��Ϣ
					map = IGDRMEmergencyTools.getProcessStatusForOBDR(Integer.parseInt(prid));
				}else if(type.equals(IGDRMCONSTANTS.DB_TYPE_PROCESS_BUTTON)){
					map = IGDRMEmergencyTools.getIG333InfoForScene(Integer.parseInt(prid));//11ʵʱ���ٰ�ť
				}
				
				if(type.equals(IGDRMCONSTANTS.DB_TYPE_GROUP_PROCESS_START)){
					//14 - �����̿�ʼʱ��
					map = IGDRMEmergencyTools.getGroupProcessStartTime(Integer.parseInt(prid));//8���̿�ʼʱ��ok
				}else if(type.equals(IGDRMCONSTANTS.DB_TYPE_GROUP_PROCESS_STATUS)){
					//15 ������-��������ID��ȡ�����̵�ǰ״̬��Ϣ
					map = IGDRMEmergencyTools.getGroupProcessStatusForOBDR(Integer.parseInt(prid));
				}else if(type.equals(IGDRMCONSTANTS.DB_TYPE_GROUP_USED_TIME)){
					//16 ������-ʹ��ʱ��
					map = IGDRMEmergencyTools.getGroupProcessUsedTime(Integer.parseInt(prid));//9��������ʱok
				}else if(type.equals(IGDRMCONSTANTS.DB_TYPE_GROUP_MESSAGE)){
					//17 ������-������Ϣ
					map = IGDRMEmergencyTools.getGroupMessageInfo(Integer.parseInt(prid));//6��ȡ��������Ϣ,type=3ok
				}else if(type.equals(IGDRMCONSTANTS.DB_TYPE_GROUP_NOTICE)){	
					//18 ������-��ִ�� �� ����ִ�еĽڵ������Ϣ
					map = IGDRMEmergencyTools.getGroupProcessRecordListInit(Integer.parseInt(prid));
				}else if(type.equals(IGDRMCONSTANTS.DB_TYPE_GROUP_PROCESS_BUTTON)){
					//19 ������--�����ڵ������ϢTAB���Ѿ�ִ��+����ִ�У�
					map = IGDRMEmergencyTools.getGroupIG333InfoForScene(Integer.parseInt(prid));
				}else if(type.equals(IGDRMCONSTANTS.DB_TYPE_GROUP_PROCESS_RECORD)){
					//20  ������--�������� ʵ����Ϣ
					map = IGDRMEmergencyTools.getGroupProcessList(Integer.parseInt(prid));
				}else if(type.equals(IGDRMCONSTANTS.DB_TYPE_GROUP_TERMINATE_MSG)){
					//21  ������--��ֹ���̺ͽڵ���Ϣ
					map = IGDRMEmergencyTools.getTerminateMsgFunc(Integer.parseInt(prid));
				}
				//ת����Json
				Gson gson = new Gson();
				String jsonStr = gson.toJson(map).replaceAll("\'","\"");
				out.print(jsonStr);
			} catch (NumberFormatException e) {
				log.debug("===============prid�޷�ת��������===============");
				map.put("emsg", "����id����ȷ!");
			} catch (BLException e) {
				log.debug("===============��ȡ��Ϣ�������ִ���===============");
				map.put("emsg", "��ȡ���ݳ���!");
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
