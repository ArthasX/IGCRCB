package com.deliverik.infogovernor.drm.action;

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
import com.deliverik.infogovernor.drm.bl.IGDRM01BL;
import com.deliverik.infogovernor.drm.dto.IGDRM01DTO;
import com.deliverik.infogovernor.drm.form.IGDRM0101Form;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description:��������Action����
 * </p>
 * 
 * @author wym@deliverik.com
 * @version 1.0
 */
public class IGDRM0101Action extends BaseAction {

    static Log log = LogFactory.getLog(IGDRM0101Action.class);

    /**
     * ��������Action����
     *
     * @param mapping 
     * @param actionForm 
     * @param req 
     * @param res 
     * @return 
     * @throws Exception 
     */
    @Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm
			, HttpServletRequest req, HttpServletResponse res) throws Exception {
        //
        IGDRM0101Form form = (IGDRM0101Form)actionForm;
        IGDRM01DTO dto = new IGDRM01DTO();
        IGDRM01BL ctlBL =(IGDRM01BL)getBean("igdrm01BL");
        dto.setIgdrm0101Form(form);
        if("DISP".equals(mapping.getParameter())){
        //AJAX ���������ڵ�-�������̶���״̬�ڵ���Ϣ��ѯ
        }else if("STAUTSINFO".equals(mapping.getParameter())){
        	log.debug("==========�ڵ���Ϣȡ�ò�����ʼ==========");
			PrintWriter out = null;
			try {
				out = new PrintWriter(new OutputStreamWriter(res.getOutputStream(), "utf-8"));
				//��ѯ�ڵ�״̬��Ϣ
				String josn = ctlBL.getStautsInfo(dto);
				//�ڵ���Ϣlist-josn�ַ���
				out.print(josn);
			} catch (Exception e) {
				out.print("");
				log.error("AjaxAction Exception", e);
			} finally {
				if (out != null)
					out.close();
			}
			log.debug("==========�ڵ���Ϣȡ�ò�������==========");
        }else if("STAUTSLOG".equals(mapping.getParameter())){
        	log.debug("==========����ʵ������ڵ����Ϣȡ�ò�����ʼ==========");
			PrintWriter out = null;
			try {
				out = new PrintWriter(new OutputStreamWriter(res.getOutputStream(), "utf-8"));
				//��ѯ�ڵ�״̬��Ϣ
				String josn = ctlBL.getStautsFormLog(dto);
				//�ڵ���Ϣlist-josn�ַ���
				out.print(josn);
			} catch (Exception e) {
				out.print("");
				log.error("AjaxAction Exception", e);
			} finally {
				if (out != null)
					out.close();
			}
			log.debug("==========����ʵ������ڵ����Ϣȡ�ò�������==========");
        }else if("ORGINFO".equals(mapping.getParameter())){
        	log.debug("==========�ڵ���Ϣȡ�ò�����ʼ==========");
			PrintWriter out = null;
			try {
				out = new PrintWriter(new OutputStreamWriter(res.getOutputStream(), "utf-8"));
				//��ѯ�ڵ�״̬��Ϣ
				dto = ctlBL.getOrgInfo(dto);
				//�ڵ���Ϣlist-josn�ַ���
				out.print(dto.getAjaxResult());
			} catch (Exception e) {
				out.print("");
				log.error("AjaxAction Exception", e);
			} finally {
				if (out != null)
					out.close();
			}
			log.debug("==========�ڵ���Ϣȡ�ò�������==========");
        }else if("ATTKEY".equals(mapping.getParameter())){
        	log.debug("==========�ڵ���Ϣȡ�ò�����ʼ==========");
			PrintWriter out = null;
			try {
				out = new PrintWriter(new OutputStreamWriter(res.getOutputStream(), "utf-8"));
				//��ѯ�ڵ�״̬��Ϣ
				String attKeyXml  = ctlBL.getAttKey(dto);
				//״̬������ - ��Ϣxml�ַ���
				out.print(attKeyXml);
			} catch (Exception e) {
				out.print("");
				log.error("AjaxAction Exception", e);
			} finally {
				if (out != null)
					out.close();
			}
			log.debug("==========�ڵ���Ϣȡ�ò�������==========");
        }else if("STATEFORM".equals(mapping.getParameter())){
        	log.debug("==========�ڵ�-״̬����Ϣȡ�ò�����ʼ==========");
			PrintWriter out = null;
			try {
				out = new PrintWriter(new OutputStreamWriter(res.getOutputStream(), "utf-8"));
				//��ѯ�ڵ�״̬��Ϣ
				String stateFormXml  = ctlBL.getStateForm(dto);
				//״̬���� - ��Ϣxml�ַ���
				out.print(stateFormXml);
			} catch (Exception e) {
				out.print("");
				log.error("AjaxAction Exception", e);
			} finally {
				if (out != null)
					out.close();
			}
			log.debug("==========�ڵ�-״̬����Ϣȡ�ò�������==========");
        }else if("SWITCHMASTER".equals(mapping.getParameter())){
        	log.debug("==========�ڵ�-�л�������ť������ʼ==========");
        	PrintWriter out = null;
        	try {
        		out = new PrintWriter(new OutputStreamWriter(res.getOutputStream(), "utf-8"));
        		dto.setPrid(Integer.parseInt(req.getParameter("prid")));
        		ctlBL.switchMaster(dto);
        		String result = dto.getResult();
        		if(StringUtils.isNotEmpty(result)){
        			out.print(result);
        		}else{
        			out.print("�л�����ʧ��");
        		}
        		
        	}catch (Exception e) {
				out.print("�л�����ʧ��");
				log.error("AjaxAction Exception", e);
			} finally {
				if (out != null)
					out.close();
			}
        	return null;
        }    
        
        //�߼���������е���Ϣ��ʾ
  		List<ActionMessage> messageList = dto.getMessageList();
  		if( messageList != null && messageList.size() > 0 ) {
  			for (ActionMessage message : messageList) {	
  				addMessage(req, message);
  			}
  		}
        return mapping.findForward("DISP");
    }
}
