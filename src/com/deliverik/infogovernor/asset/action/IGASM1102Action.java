package com.deliverik.infogovernor.asset.action;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.infogovernor.asset.bl.IGASM11BL;
import com.deliverik.infogovernor.asset.dto.IGASM11DTO;
import com.deliverik.infogovernor.asset.form.IGASM1102Form;
import com.deliverik.infogovernor.asset.vo.IGASM11021VO;
import com.deliverik.infogovernor.room.utils.DrawFloorUtil;

/**
 * @Description: �����༭����Action����
 * @Author  
 * @History 2009-8-22     �½�
 * @History 2010-5-07     0000428: ���ӻ������Թ���
 * @Version V2.0
 */
public class IGASM1102Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM1102Action.class);

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
		IGASM1102Form form = (IGASM1102Form)actionForm;
		
		//BLȡ��
		IGASM11BL ctlBL = (IGASM11BL) getBean("igasm11BL");
		
		//DTO����
		IGASM11DTO dto = new IGASM11DTO();
		
		req.getSession().setAttribute("ADcount", 0);
		
		req.getSession().setAttribute("ADcheckCount", 0);
		
		req.getSession().setAttribute("ADmapcount", 0);
		
		//������ת�趨
		String forward = null;
		
		User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		if( "DISP".equals(mapping.getParameter())){
			//�����Ǽǻ��������ʾ����
			log.debug("========�����Ǽǻ��������ʾ����ʼ========");
			form.setEiinsdate(IGStringUtils.getCurrentDate());
			dto.setIgasm1102Form(form);
			dto = ctlBL.initIGASM1102Action(dto);
			IGASM11021VO vo = new IGASM11021VO(dto.getEntityItemVWInfo());
			vo.setConfigurationList(dto.getConfigurationList());
			Map<Integer, List<LabelValueBean>> map = form.getSelectedListMap();
			Set<Map.Entry<Integer,List<LabelValueBean>>> set = map.entrySet();
			for(Iterator<Map.Entry<Integer,List<LabelValueBean>>> iter = set.iterator();iter.hasNext();){
				Map.Entry<Integer,List<LabelValueBean>> entry = iter.next();
				req.getSession().setAttribute("ADlist"+entry.getKey(), entry.getValue());
			}
			super.<IGASM11021VO>setVO(req.getSession(), vo);
			
			
			addMessage(req, new ActionMessage("IGCO10000.I001","������Ϣ"));
			log.debug("========�����Ǽǻ��������ʾ��������========");
			return mapping.findForward("DISP");
		}

		if( "EDIT".equals(mapping.getParameter())){
			//����������������ʾ����
			log.debug("========����������������ʾ����ʼ========");
			dto.setIgasm1102Form(form);
			dto = ctlBL.initEditIGASM1102Action(dto);
			IGASM11021VO vo = new IGASM11021VO(dto.getEntityItemVWInfo());
			vo.setConfigItemVWInfoList(dto.getConfigItemVWInfoList());
			Map<Integer, List<LabelValueBean>> map = form.getSelectedListMap();
			Set<Map.Entry<Integer,List<LabelValueBean>>> set = map.entrySet();
			for(Iterator<Map.Entry<Integer,List<LabelValueBean>>> iter = set.iterator();iter.hasNext();){
				Map.Entry<Integer,List<LabelValueBean>> entry = iter.next();
				req.getSession().setAttribute("ADlist"+entry.getKey(), entry.getValue());
			}
			super.<IGASM11021VO>setVO(req.getSession(), vo);
			
			
			addMessage(req, new ActionMessage("IGCO10000.I001","������Ϣ"));
			log.debug("========����������������ʾ��������========");
			return mapping.findForward("DISP");
		}

		if( "INSERT".equals(mapping.getParameter())){

			//�����ǼǴ���
			log.debug("========�����ǼǴ���ʼ========");

			//DTO��������趨
			dto.setIgasm1102Form(form);
			dto.setUser(user);
			//������Ϣ�Ǽ��߼�����
			dto = ctlBL.insertComputerRoomInfoAction(dto);
			
			DrawFloorUtil df = new DrawFloorUtil();
			int x_total = Integer.parseInt(form.getCivalue()[0]);
			int y_total = Integer.parseInt(form.getCivalue()[1]);
			df.imgUpload("jifang"+dto.getEiid(), x_total, y_total);
			
			log.debug("========�����ǼǴ�������========");
			
			forward = "DISP";

			
		}

		if( "UPDATE".equals(mapping.getParameter())){

			//�����������
			log.debug("========�����������ʼ========");
			
			//DTO��������趨
			dto.setIgasm1102Form(form);
			dto.setUser(user);
			
			//��������߼�����
			dto = ctlBL.updateComputerRoomAction(dto);
			
			log.debug("========���������������========");
			
			forward = "BACK";
			
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
