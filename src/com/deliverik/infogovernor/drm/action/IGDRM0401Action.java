/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.drm.action;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.infogovernor.drm.bl.IGDRM04BL;
import com.deliverik.infogovernor.drm.dto.IGDRM04DTO;
import com.deliverik.infogovernor.drm.form.IGDRM0401Form;
import com.deliverik.infogovernor.drm.vo.IGDRM04011VO;
import com.deliverik.infogovernor.drm.vo.IGDRM04012VO;


/**
 * Ӧ����Դά��Action
 * @author �Ž�
 *
 * 2015-2-12 ����9:51:47
 */
public class IGDRM0401Action extends BaseAction {

	static Log log = LogFactory.getLog(IGDRM0401Action.class);

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
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		
		//BLȡ��
		IGDRM04BL ctlBL = (IGDRM04BL) getBean("igdrm04BL");
		
		IGDRM0401Form form = (IGDRM0401Form)actionForm;
		
		//DTO����
		IGDRM04DTO dto = new IGDRM04DTO(); 
		dto.setUser(user);
		//������ת�趨
		String forward = "DISP";

		if( "DISP".equals(mapping.getParameter())){
			log.info("=============Ӧ���ʲ��Ǽ�Ԥ����ʼ===============");
			Date nowDateTime = new Date();
			String date = CommonDefineUtils.DATE_FORMAT.format(nowDateTime);
			form.setEiinsdate(date);
			
			dto.setIgdrm0401Form(form);
			//Ӧ����Դ�����ʲ��鿴���ܣ����̲鿴����ҳ��
			if("open".equals(form.getFlag())){
				forward = "OPEN";
			}
			
			ctlBL.init0401Action(dto);
			req.setAttribute("IGDRM0401Form",form = dto.getIgdrm0401Form());
//			
			IGDRM04011VO vo = new IGDRM04011VO();
			vo.setFlag("DISP");
			vo.setConfigurationList(dto.getConfigurationList());
			vo.setConfigItemList(dto.getConfigItemList());
			if(dto.getEntityItemVW()!=null)
			BeanUtils.copyProperties(dto.getEntityItemVW(), dto.getIgdrm0401Form());
			vo.setEntityItemVW(dto.getEntityItemVW());
			super.<IGDRM04011VO>setVO(req, vo);
			
			
			log.info("=============Ӧ���ʲ��Ǽ�Ԥ�������===============");
			
		}
		if("INSERT".equals(mapping.getParameter())){
			log.info("=============Ӧ���ʲ��Ǽǿ�ʼ===============");
			dto.setIgdrm0401Form(form);
			dto.setUser(user);
			ctlBL.regEmergencyResource(dto);
			dto.getMessageList().add(new ActionMessage("IGCO10000.I000","Ӧ����Դ����ɹ���"));
			log.info("=============Ӧ���ʲ��Ǽǽ���===============");
			
		}
		if("CONFIG".equals(mapping.getParameter())){
			
			log.debug("============��ȡӦ����Դ�����б�ʼ==============");
			
			dto.setIgdrm0401Form(form);
			
			ctlBL.searchConfigList(dto);
			
			IGDRM04012VO vo = new IGDRM04012VO();
			
			Map<Integer, List<LabelValueBean>> map = dto.getSelectedListMap();
			Set<Map.Entry<Integer,List<LabelValueBean>>> set = map.entrySet();
			for(Iterator<Map.Entry<Integer,List<LabelValueBean>>> iter = set.iterator();iter.hasNext();){
				Map.Entry<Integer,List<LabelValueBean>> entry = iter.next();
				req.getSession().setAttribute("ADlist"+entry.getKey(), entry.getValue());
			}
			
			vo.setConfigurationList(dto.getConfigurationList());
			vo.setEntityItemVW(dto.getEntityItemVW());
			vo.setConfigItemList(dto.getConfigItemList());
			super.<IGDRM04012VO>setVO(req, vo);	
			
			log.debug("============��ȡӦ����Դ�����б����==============");
			
		}
		if("GETLABEL".equals(mapping.getParameter())){
			log.info("==========��ȡ�ʲ���ſ�ʼ===========");
			dto.setIgdrm0401Form(form);
			ctlBL.getLabel(dto);
			res.setCharacterEncoding("UTF-8");
			res.getWriter().write(dto.getEilabel());
			log.info("==========��ȡ�ʲ���Ž���===========");
			return null;
		}
		List<ActionMessage> messageList = dto.getMessageList();
		if (messageList != null && messageList.size() > 0) {
			for (ActionMessage message : messageList) {
				addMessage(req, message);
			}
		}
		return mapping.findForward(forward);
	}
}
