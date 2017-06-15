/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
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
 * Ӧ��ָ������Action
 * @author zyl
 * 
 * 2015��3��25��13:50:42
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
		//ʵ����DTO
		IGDRM09DTO dto = new IGDRM09DTO();
		//��תҳ��
		String forward = "DISP";
		//��ʼ��ҳ��
		if("DISP".equals(mapping.getParameter())){
			log.debug("========Ӧ������ָ��ͼDashBoard��ʼ������ʼ========");
			//��ȡprid
			String prid = request.getParameter("prid");
			//�˿ںź�IP
			CodeListUtils codeListUtils=(CodeListUtils) WebApplicationSupport.getBean("codeListUtils");
			String port = codeListUtils.getCodeValue("174",null, null, "1");//�˿ں�
			String ip = codeListUtils.getCodeValue("174",null, null, "2");//IP
			
			//����request����
			request.setAttribute("prid", prid);
			request.setAttribute("port", port);
			request.setAttribute("ip", ip);
			log.debug("========Ӧ������ָ��ͼDashBoard��ʼ����������========");
		}
		
		//��ȡӦ��ָ�����̳�ʼ��DashBoard��Json����
		//'1'��ȡʵʱ׷����־��Ϣ��'2'��ȡ����״̬��Ϣ�б�'3'��ȡ��λ��Ա��Ϣ��'4'��ȡ�¼���Ϣ��'5'��ȡԤ���ʲ���Ϣ'6'��Ϣ����'7'��ȡ���Ȱٷֱ�
		//8���̿�ʼʱ�䡢9��������ʱ��10Ӧ����Դ
		if("GETJSONDATA".equals(mapping.getParameter())){
			PrintWriter out = null;
			
			//�������״̬��Ϣ��ȡ
			try {
				out =  new PrintWriter( new OutputStreamWriter(response.getOutputStream(), "utf-8"));
				//��ȡprid
				String prid = request.getParameter("prid");
				String showType = request.getParameter("showType");
				//�ܵ�Map��֪��value��ȷ������������Object
				Map<String, Object> map = new HashMap<String, Object>();
				if(showType.equals(IGDRMCONSTANTS.DB_TYPE_NOTICE)){	//1ʵʱ׷��			
					map = IGDRMEmergencyTools.getProcessRecordListInit(Integer.parseInt(prid));
				}else if(showType.equals(IGDRMCONSTANTS.DB_TYPE_PROCESS)){//2Ӧ��ָ��-����ͼ not ok
					map = IGDRMEmergencyTools.getProcessStatusListInit(Integer.parseInt(prid));
				}else if(showType.equals(IGDRMCONSTANTS.DB_TYPE_INPLACE)){//3��Ա
					map = IGDRMEmergencyTools.getRestpreDecLayInPlaceList(Integer.parseInt(prid));				
				}else if(showType.equals(IGDRMCONSTANTS.DB_TYPE_EMCINFO)){//4�¼���Ϣ
					map = IGDRMEmergencyTools.getEmergencyProcessInfo(Integer.parseInt(prid));
				}else if(showType.equals(IGDRMCONSTANTS.DB_TYPE_RELPLAN)){//5Ԥ���ʲ�
					map = IGDRMEmergencyTools.getRelPlanProcessInfo(Integer.parseInt(prid));
				}else if(showType.equals(IGDRMCONSTANTS.DB_TYPE_MESSAGE)){
					map = IGDRMEmergencyTools.getMessageInfo(prid);//6��ȡ��������Ϣ,type=3
				}else if(showType.equals(IGDRMCONSTANTS.DB_TYPE_PERCENT)){
					map = IGDRMEmergencyTools.getPercentNum(Integer.parseInt(prid));//7��ȡ���Ȱٷֱ�
				}else if(showType.equals(IGDRMCONSTANTS.DB_TYPE_PROCESS_START)){
					map = IGDRMEmergencyTools.getProcessStartTime(Integer.parseInt(prid));//8���̿�ʼʱ��
				}else if(showType.equals(IGDRMCONSTANTS.DB_TYPE_USED_TIME)){
					map = IGDRMEmergencyTools.getProcessUsedTime(Integer.parseInt(prid));//9��������ʱ
				}else if(showType.equals(IGDRMCONSTANTS.DB_TYPE_SOC_MSG)){
					map = IGDRMEmergencyTools.getSocMap(Integer.parseInt(prid));//22����Ӧ����Դ
				}else if(showType.equals("systemTime")){
					map = IGDRMEmergencyTools.getSystemTime();
				}
					
				//ת����Json
				Gson gson = new Gson();
				System.out.println(gson.toJson(map));
				out.print(gson.toJson(map));
			} catch (NumberFormatException e) {
				log.debug("===============prid�޷�ת��������===============");
				e.printStackTrace();
			} catch (BLException e) {
				log.debug("===============��ȡ��Ϣ�������ִ���===============");
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
			//�������״̬��Ϣ��ȡ
			try {
				out =  new PrintWriter( new OutputStreamWriter(response.getOutputStream(), "utf-8"));
				//��ȡprid
				String prid = request.getParameter("curPrid");
				//��������- 0����һ���� 1�����ϳ���
				String cldtype = IGDRMEmergencyTools.getSence(Integer.parseInt(prid));//9��������ʱ
				out.print(cldtype);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (out != null)
					out.close();
			}
			return null;
		}
		 // ͨ��Ӧ��ָ������id ��ȡ�������еļ����ָ�����id
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
