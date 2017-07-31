/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.wim.action;


import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.wim.bl.IGWIM01BL;
import com.deliverik.infogovernor.wim.dto.IGWIM01DTO;
import com.deliverik.infogovernor.wim.form.IGWIM0101Form;
import com.deliverik.infogovernor.wim.vo.IGWIM01011VO;
import com.google.gson.Gson;

/**
 * @Description �������������޸�Action
 * 
 * @date 2017��6��9��16:38:55
 * 
 * @author WangLiang
 *
 */
public class IGWIM0101Action extends BaseAction{
	
	static Log log = LogFactory.getLog(IGWIM0101Action.class);

	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		//���������Formȡ��
		IGWIM0101Form form = (IGWIM0101Form) actionForm;
		//BLȡ��
		IGWIM01BL ctlBL  = (IGWIM01BL) getBean("igwim01BL");
		//DTO����
		IGWIM01DTO dto = new IGWIM01DTO();
		//��ȡ��¼�û�
		User user = (User) request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		//��½�û�����
		dto.setUser(user);
		//����Form
		dto.setIgwim0101Form(form);
		
		if("DISP".equals(mapping.getParameter())){
			
			log.info("==========��������ʼ��ҳ��Action��ʼ����ʼ==========");
			//����BL��ʼ����������Ϣ
			dto = ctlBL.workDefinitionInitAction(dto);
			//����BL��ѯ�û��Ƿ������ĸ����˻����ϸ�λ
			dto = ctlBL.searchIsLeader(dto);
			//����ҳ���ʼ�����÷�����id
			form.setInitiatorId(user.getUserid());
			//����ҳ���ʼ�����÷���������
			form.setInitiatorName(user.getUsername());
			//�����û��Ƿ�Ϊ���ĸ��������ϸ�λ
			form.setIsLeader(dto.getIsLeader());
			//ʵ�������������VO
			IGWIM01011VO vo = new IGWIM01011VO();
			//���湤�������Ϣ
			vo.setWorkDefinitionInfo(dto.getWorkDefinitionInfo());
			//����Ƶ�������ڼ��� 
			vo.setWeekList(dto.getWeekList());
			//����Ƶ������������ 
			vo.setMonthList(dto.getMonthList());
			//����Ƶ��Сʱ���� 
			vo.setHourList(dto.getHourList());
			//����Ƶ�ʷּ��� 
			vo.setMinutesList(dto.getMinutesList());
			//�����������Form������Request����
			request.setAttribute("IGWIM0101Form", form);
			
			saveToken(request);
			super.<IGWIM01011VO>setVO(request, vo);
			
			log.info("==========��������ʼ��ҳ��Action��ʼ������==========");
			
		}else if("INSERT".equals(mapping.getParameter())){
			
			log.info("==========����������Action��ʼ==========");
			
			if (isTokenValid(request, true)){
				if(form!=null && "0".equals(form.getMode())){
					//����
					ctlBL.registerWorkDefinitionAction(dto);
				}else{
					//����
					ctlBL.updateWorkDefinitionAction(dto);
				}
			}
			log.info("==========����������Action����==========");
			
		}else if("MODIFY".equals(mapping.getParameter())){
			
			log.info("==========������״̬�޸�Action��ʼ==========");
			
			//��ȡ�����
			PrintWriter out = null;
			
			//���������ʽ
			out = new PrintWriter(new OutputStreamWriter(response.getOutputStream(),"utf-8"));
			
			//����BL���¹���������ͣ��״̬
			IGWIM01DTO msgDto = ctlBL.updateWorkDefinitionStatusAction(dto);
			
			//ʵ����Gson
			Gson gson = new Gson();
			
			//������ʾ��Ϣ
			out.print(gson.toJson(msgDto.getMsg()));
			
			try {
				
			} catch (Exception e) {
				out.print("");
				log.error("AjaxAction Exception", e);
				e.printStackTrace();
				
			}finally {
				
				if(out!=null){
					out.close();
				}
			}
			
			log.info("==========������״̬�޸�Action����==========");
			
			return null;
			
		}else if("MANUALAJAX".equals(mapping.getParameter())){
			
			log.info("==========������ʵ���ֶ�����Action����ʼ==========");
			
			//��ȡ�����
			PrintWriter out = null;
			//���������ʽ
			out = new PrintWriter(new OutputStreamWriter(response.getOutputStream(),"utf-8"));
			
			try {
				
				//�����ֶ������ʶ
				dto.setLaunchFlag("Y");
				//����wdid
				dto.setWdid(Integer.parseInt(request.getParameter("wdid")));
				//����BL�ֶ���������ʵ��
				dto = ctlBL.registerWorkInstanceAction(dto);
				//ʵ����Gson
				Gson gson = new Gson();
				//������ʾ��Ϣ
				out.print(gson.toJson(dto.getMsg()));
				
			} catch (Exception e) {
				out.print("");
				log.error("AjaxAction Exception", e);
				e.printStackTrace();
				
			}finally {
				
				if(out!=null){
					out.close();
				}
			}
			log.info("==========������ʵ���ֶ�����Action�������==========");
			
			return null;
		}
		
		//�߼���������е���Ϣ��ʾ
		List<ActionMessage> messageList = dto.getMessageList();
		if (messageList != null && messageList.size() > 0) {
			for (ActionMessage message : messageList) {
				addMessage(request, message);
			}
		}
		
		return mapping.findForward("DISP");
	}

}
