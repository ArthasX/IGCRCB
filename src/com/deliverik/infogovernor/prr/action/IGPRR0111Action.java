/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.prr.action;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.infogovernor.prr.bl.IGPRR01BL;
import com.deliverik.infogovernor.prr.dto.IGPRR01DTO;
import com.deliverik.infogovernor.prr.form.IGPRR0111Form;
import com.deliverik.infogovernor.prr.vo.IGPRR01111VO;

/**
 * @Description: ����ͼ�鿴Action
 * @Author  
 * @History 2010-9-13     �½� 
 * @Version V1.0
 */
public class IGPRR0111Action extends BaseAction {

	static Log log = LogFactory.getLog(IGPRR0111Action.class);

	/**
	 * ���̴���
	 *
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return ActionForward
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		log.debug("========�鿴����ͼ����ʼ========");
		//FORMȡ��
		IGPRR0111Form form = (IGPRR0111Form)actionForm;
		
		//BLȡ��
		IGPRR01BL ctlBL = (IGPRR01BL) getBean("igPRR01BL");
		
		String forward = "DISP";
		
		//DTO����
		IGPRR01DTO dto = new IGPRR01DTO();
		//����ID������ҳ��ʹ��
		dto.setPrid(form.getPrid());
		//���̶���ID������ҳ��ʹ��
		dto.setPdid(form.getPdid());
		//����״̬ID������ҳ��ʹ��
		dto.setPsdid(form.getPsdid());
		if("FLOWXML".equals(mapping.getParameter())){
			//����ͼ��ѯ
			dto = ctlBL.searchFlowChartXmlAction(dto);
			//VO����
			IGPRR01111VO vo = new IGPRR01111VO();
			vo.setFlowChartXml(dto.getFlowChartXml());
			vo.setXmlheight(dto.getXmlheight());
			super.<IGPRR01111VO>setVO(req, vo);
			forward = "FLOWXML";
			log.debug("========�鿴����ͼ��������========");
		}
		if("CHILDFLOWXML".equals(mapping.getParameter())){
			log.debug("=========����������ͼ��Ϣ��ѯ������ʼ=========");
			PrintWriter out = null;
			try {
				dto = ctlBL.searchChileFlowChartAction(dto);
				out = new PrintWriter(new OutputStreamWriter(res.getOutputStream(), "utf-8"));
				if(StringUtils.isNotEmpty(dto.getFlowChartXml())){
					out.print(dto.getFlowChartXml());
				}
			} catch (Exception e) {
				out.print("");
				log.error("AjaxAction Exception", e);
			} finally {
				if (out != null)
					out.close();
			}
			log.debug("=========����������ͼ��Ϣ��ѯ��������=========");
			return null;
		}
		if("GETSERIAL".equals(mapping.getParameter())){
			log.debug("=========��������prid��ȡ���̹����ſ�ʼ=========");
			PrintWriter out = null;
			try {
				dto = ctlBL.searchSerialNum(dto);
				out = new PrintWriter(new OutputStreamWriter(res.getOutputStream(), "utf-8"));
				if(StringUtils.isNotEmpty(dto.getSerialNum())){
					out.print(dto.getSerialNum());
				}
			} catch (Exception e) {
				out.print("");
				log.error("AjaxAction Exception", e);
			} finally {
				if (out != null)
					out.close();
			}
			log.debug("=========��������prid��ȡ���̹����Ž���=========");
			return null;
		}
		
		//�߼���������е���Ϣ��ʾ
		List<ActionMessage> messageList = dto.getMessageList();
		
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
			
		}
		
		return mapping.findForward(forward);
	}
	
	

}
