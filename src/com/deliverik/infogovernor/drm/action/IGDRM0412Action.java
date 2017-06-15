package com.deliverik.infogovernor.drm.action;

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
import com.deliverik.infogovernor.drm.bl.IGDRM04BL;
import com.deliverik.infogovernor.drm.dto.IGDRM04DTO;
import com.deliverik.infogovernor.drm.form.IGDRM0412Form;
import com.deliverik.infogovernor.drm.vo.IGDRM04021VO;
import com.deliverik.infogovernor.drm.vo.IGDRM04121VO;
import com.google.gson.Gson;

/**
 * ���ͻ�����Ϣ�༭����Action����
 *
 */
public class IGDRM0412Action extends BaseAction {

	static Log log = LogFactory.getLog(IGDRM0412Action.class);

	/**
	 * �¼�����
	 *
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		//FORMȡ��
		IGDRM0412Form form = (IGDRM0412Form)actionForm;
		
		//BLȡ��
		IGDRM04BL ctlBL = (IGDRM04BL) getBean("igdrm04BL");
		
		//DTO����
		IGDRM04DTO dto = new IGDRM04DTO();
		
		//������ת�趨
		String forward = null;
		//��ȡ�����ɫ�б�
		User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		dto.setUser(user);
		if( "DISP".equals(mapping.getParameter())){
			//���͵Ǽǻ��������ʾ����
			log.debug("========���͵Ǽǻ��������ʾ����ʼ========");
			req.setAttribute("IGDRM0412Form", new IGDRM0412Form());
			
			addMessage(req, new ActionMessage("IGCO10000.I001","���������Ϣ"));
			log.debug("========���͵Ǽǻ��������ʾ��������========");
			saveToken(req);
			return mapping.findForward("DISP");
		} else if("REDISP".equals(mapping.getParameter())){
			//���͵Ǽǻ�������ʾ����
			log.debug("========���͵Ǽǻ�������ʾ����ʼ========");
			
			dto.setIgdrm0412Form(form);
			saveToken(req);
			
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========���͵Ǽǻ�������ʾ��������========");
			return mapping.findForward("DISP");
		}	

		if( "INSERT".equals(mapping.getParameter())){
			//���ͱ༭����
			if (isCancelled(req)||(req.getParameter("btn_back")!=null)){
				//���͵Ǽǻ��水�·��ذ�ťʱ�ķ��ش���
				if (form.getMode().equals("1")){
					//�������Ͳ�ѯ����
					return mapping.findForward("BACK");
				}
			}
			
			if (form.getMode().equals("0")){
				//���͵ǼǴ���
				log.debug("========���͵ǼǴ���ʼ========");
				
				//DTO��������趨
				dto.setEntity(form);
				dto.setIgdrm0412Form(form);
				
				if (isTokenValid(req, true)){
				//������Ϣ�Ǽ��߼�����
					dto = ctlBL.insertEntityAction(dto);
				}else{
					addMessage(req, new ActionMessage("IGCO00000.E007"));
					return mapping.findForward("/error1");
				}
				//���Ǽ����˵�������Ϣ�趨��VO��
				IGDRM04121VO vo = new IGDRM04121VO(dto.getEntity());
				
				super.<IGDRM04121VO>setVO(req.getSession(), vo);
				
				log.debug("========���͵ǼǴ�������========");
				
				forward = "DISP";
				
			} else {
				//���ͱ������
				log.debug("========���ͻ�����Ϣ�������ʼ========");
				
				//DTO��������趨
				dto.setEntity(form);
				dto.setIgdrm0412Form(form);
				
				//������Ϣ����߼�����
				dto = ctlBL.updateEntityAction(dto);
				
				log.debug("========���ͻ�����Ϣ�����������========");
				
				forward = "BACK";
			}
		}
		if ("EDIT".equals(mapping.getParameter())){
			log.debug("========���ͻ�����Ϣ���������ʾ����ʼ========");
			dto.setIgdrm0412Form(form);
			
			dto = ctlBL.initIGDRM0412Action(dto);
			
			log.debug("========���ͻ�����Ϣ���������ʾ��������========");

			forward = "DISP";
		}
		if ("TREE".equals(mapping.getParameter())){
			log.debug("========Ӧ����Դ������ʼ========");
			if(!"allTree".equals(form.getEsyscoding())){
				dto.setRootEsyscoding("000");
			}else{
				dto.setRootEsyscoding("allTree");
			}
			dto = ctlBL.initNewNodeMap(dto);
			IGDRM04021VO vo = new IGDRM04021VO();
			Gson g = new Gson();
			vo.setNodeMapJson(g.toJson(dto.getNodeMap()));
			super.<IGDRM04021VO>setVO(req, vo);
			log.debug("========Ӧ����Դ����������========");
			forward = "DISP";
		}
		if ("AJAXCONFIG".equals(mapping.getParameter())){
			log.debug("========����ʲ����Դ���ʼ========");
			dto.setIgdrm0412Form(form);
			PrintWriter out = null;
			try {
				String result = ctlBL.getConfigList(dto);
                out = new PrintWriter(new OutputStreamWriter(res.getOutputStream(), "utf-8"));
                out.print(result);
            } catch (Exception e) {
                log.error("AjaxAction Exception", e);
            } finally {
                if (out != null){
                    out.close();
                }
            }
			forward = "null";
			
			log.debug("========����ʲ����Դ�������========");
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
