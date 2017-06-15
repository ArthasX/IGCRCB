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
import com.deliverik.infogovernor.drm.bl.IGDRM02BL;
import com.deliverik.infogovernor.drm.dto.IGDRM02DTO;
import com.deliverik.infogovernor.drm.form.IGDRM0201Form;
import com.deliverik.infogovernor.drm.vo.IGDRM02011VO;

/**
 * 
 * ��ϳ�������Action����
 * 
 * @author zyl
 */
public class IGDRM0201Action extends BaseAction {

    static Log log = LogFactory.getLog(IGDRM0201Action.class);

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
        IGDRM0201Form form = (IGDRM0201Form)actionForm;
        IGDRM02DTO dto = new IGDRM02DTO();
        IGDRM02BL ctlBL =(IGDRM02BL)getBean("igdrm02BL");
        dto.setIgdrm0201Form(form);
        //���̱༭���г���ѡ�񵯳�����ʼ��
        if("SDISP".equals(mapping.getParameter())){
        	req.setAttribute("eiids", form.getEiids());
        }
        //��ϳ�������xml��ʼ��
        else if("DISP".equals(mapping.getParameter())){
        	//��ʼ��
			log.debug("==========��ѯ������ʼ��������ʼ==========");
			String pgdid = req.getParameter("pgdid");
			String isMask = req.getParameter("isMask");
			String isUpdate = req.getParameter("isUpdate");
			String oldpdid = req.getParameter("oldpdid");
			dto.setPgdid(pgdid);
			//�����ʶ
			dto.setIsUpdate(isUpdate);
			//ԭ����pgdid
			dto.setOldpdid(oldpdid);
			// ��ϳ�����ʼ��xml
			String initJsonXML = ctlBL.getSceneInitXMLInfo(dto);
			form.setXml(initJsonXML);
			form.setIsMask(isMask);
			log.debug("==========��ѯ������ʼ��������ʼ==========");
        }
        //��ѯ������Ϣ����
		else if ("SEARCHSCENE".equals(mapping.getParameter())) {
			log.debug("==========��ѯ������Ϣ������ʼ==========");
			String ename = form.getEname();
			if(StringUtils.isNotEmpty(ename)){
				form.setEname(ename);
			}
			dto = ctlBL.searchSceneProcessInfo(dto);
			// ���ʲ�����Ϣ��������趨��VO��
			IGDRM02011VO vo = new IGDRM02011VO();
			vo.setEntityItemVWInfoList(dto.getSoc0124List());
			super.<IGDRM02011VO> setVO(req, vo);
			log.debug("==========��ѯ������Ϣ��������==========");
		}
        //��ӳ�����Ϣ����
        else if("ADDSCENE".equals(mapping.getParameter())){
        	log.debug("==========��ӳ���������ʼ==========");
			PrintWriter out = null;
			try {
				out = new PrintWriter(new OutputStreamWriter(res.getOutputStream(), "utf-8"));
				String addEiids[] = req.getParameterValues("addEiids[]");
		        dto.setAddEiids(addEiids);	
		        //�õ���������xml
		        String sceneJsonXML =  ctlBL.getSceneProcessXMLInfo(dto);
				//�ڵ���Ϣlist-josn�ַ���
				out.print(sceneJsonXML);
			
			} catch (Exception e) {
				log.error("Ajax ADD Exception", e);
			} finally {
				if (out != null)
					out.close();
			}
			log.debug("==========��ӳ�����������==========");
			return null;
            }        
        //������ϳ�����Ϣ
        else if("SAVE".equals(mapping.getParameter())){
			log.debug("===========������ϳ���������Ϣ�������============");
			PrintWriter out = null;
			try {
				out = new PrintWriter(new OutputStreamWriter(res.getOutputStream(), "utf-8"));
				String prid = req.getParameter("prid");
				String pdid = req.getParameter("pdid");
				dto.setPrid(Integer.parseInt(prid));
				String xml = req.getParameter("xmlValue");
				if(StringUtils.isNotEmpty(xml)){
					//�������滻˫����
					xml = xml.replaceAll("\'","\"" );
				}
				dto.setPdidStr(pdid);
				dto.setXmlValue(xml);
		        //���泡������xml
		    	ctlBL.saveSceneProcessAction(dto);
				//�ڵ���Ϣlist-josn�ַ���
			} catch (Exception e) {
				log.error("Ajax SAVE Exception", e);
			} finally {
				if (out != null)
					out.close();
			}
			
			log.debug("===========������ϳ���������Ϣ�������============");
			return null;
		}
        //��ȡ״̬��
        else if("STATEFORM".equals(mapping.getParameter())){
        	log.debug("==========��ϳ����ڵ�-״̬����Ϣȡ�ò�����ʼ==========");
			PrintWriter out = null;
			try {
				out = new PrintWriter(new OutputStreamWriter(res.getOutputStream(), "utf-8"));
				String pgdid = req.getParameter("pgdid");
				String pdidStr = req.getParameter("pdidStr");
				dto.setPdidStr(pdidStr);
				dto.setPgdid(pgdid);
				//��ѯ�ڵ�״̬��Ϣ
				String stateFormXml  = ctlBL.getStateFormXML(dto);
				//״̬���� - ��Ϣxml�ַ���
				out.print(stateFormXml);
			} catch (Exception e) {
				out.print("");
				log.error("Ajax STATEFORM Exception", e);
			} finally {
				if (out != null)
					out.close();
			}
			log.debug("==========��ϳ����ڵ�-״̬����Ϣȡ�ò�������==========");
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
