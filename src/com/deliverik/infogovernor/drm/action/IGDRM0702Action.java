package com.deliverik.infogovernor.drm.action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.soc.asset.model.SOC0118Info;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.drm.bl.IGDRM07BL;
import com.deliverik.infogovernor.drm.dto.IGDRM07DTO;
import com.deliverik.infogovernor.drm.form.IGDRM0702Form;
import com.deliverik.infogovernor.drm.vo.IGDRM07021VO;
import com.deliverik.infogovernor.drm.vo.IGDRM07022VO;
import com.deliverik.infogovernor.drm.vo.IGDRM07081VO;
import com.google.gson.Gson;

/**
 * Ӧ�������ʲ����ѯ����ҳAction
 *
 */
public class IGDRM0702Action extends BaseAction {

	static Log log = LogFactory.getLog(IGDRM0702Action.class);

	/**
	 * 
	 * ����
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 * @throws Exception 
	 */
	@Override
    @SuppressWarnings("unchecked")
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		//FORMȡ��
		IGDRM0702Form form = (IGDRM0702Form)actionForm;
		
		//BLȡ��
		IGDRM07BL ctlBL = (IGDRM07BL) getBean("igdrm07BL");
		
		//DTO����
		IGDRM07DTO dto = new IGDRM07DTO();
		
		if( "DISP".equals(mapping.getParameter())){
			form.setEsyscodingbegin(form.getEsyscoding());
			log.debug("========�ʲ���HELP��ѯ���������ʾ����ʼ========");
			if(StringUtils.isEmpty(form.getEname()) && StringUtils.isNotEmpty(form.getEsyscoding())){
				dto.setEsyscoding(form.getEsyscoding());
				dto = ctlBL.searchEntityNameActionSOC(dto);
				form.setEname(dto.getEname());
			}
			//���²�ѯ���������
			req.getSession().removeAttribute("ADSelectEntity");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========�ʲ���HELP��ѯ���������ʾ��������========");
			return mapping.findForward("DISP");
		}
		//�鿴�ʲ���ϸ��Ϣ
		if("DETAIL".equals(mapping.getParameter())){
			
			dto.setIgdrm0702Form(form);
			log.info("================�鿴�ʲ���ϸ��Ϣ��ʼ===================");
			
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			
			dto.setUser(user);
			
			dto= ctlBL.getEntityFullInfo(dto);
			//������ϸ��Ϣ���������ʾ�߼�����
		
			//���豸������Ϣ��������趨��VO��
			IGDRM07081VO vo = new IGDRM07081VO(dto.getSoc0124Info(),dto.getSoc0129InfoVWMap());
			super.<IGDRM07081VO>setVO(req.getSession(), vo);
			addMessage(req, new ActionMessage("IGCO10000.I001","�ʲ�������Ϣ"));
			
			log.info("================�鿴�ʲ���ϸ��Ϣ����===================");
		}
		

		if( "SEARCH".equals(mapping.getParameter()) || "SEARCH1".equals(mapping.getParameter())||"SEARCH2".equals(mapping.getParameter())){
			log.debug("========�ʲ����ѯHELP����ʼ========");

			//��ҳ��DTOȡ��
			getPaginDTO(req,"IGDRM0702");

			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			
			if ("SEARCH1".equals(mapping.getParameter())){
				//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
				form = (IGDRM0702Form) req.getSession().getAttribute("IGDRM0702Form");
				if ( form== null){
					form = new IGDRM0702Form();
				}else {
					if (req.getParameter("PAGING") == null) {
						pDto.setFromCount(form.getFromCount());
					} else {
						form.setFromCount(pDto.getFromCount());
					}
				}
			} else {
				if (req.getParameter("PAGING") == null) {
					pDto.setFromCount(0);
					form = (IGDRM0702Form) req.getSession().getAttribute("IGDRM0702Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}

			form.setEistatus("0");
			//��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("IGDRM0702");
			dto.setSp_eiid(form.getSp_eiid());
			dto.setMaxSearchCount(maxCnt);
			dto.setIgdrm0702Form(form);
			
			Set<String> set = (Set<String>)req.getSession().getAttribute("ADSelectEntity");
			if(set != null && set.size() > 0) {
				form.setSelectId(set.toArray(new String[0]));
			} else {
				form.setSelectId(null);
			}
			dto.setIgdrm0702Form(form);
			dto.setPagingDto(pDto);
			if("flag0507".equals(form.getQueryflag())){
				
				dto = ctlBL.searchEntityItemRelation(dto);
			}else{
			//�ʲ�����Ϣ�����߼�����
				dto = ctlBL.searchEntityItem0702Action(dto);
			}
			//���ʲ�����Ϣ��������趨��VO��
			IGDRM07021VO vo = new IGDRM07021VO(dto.getSoc0124List());
			
			super.<IGDRM07021VO>setVO(req, vo);
			
			log.debug("========�ʲ���HELP��ѯ��������========");
		}
		
		if( "AJAX".equals(mapping.getParameter())){
			res.setCharacterEncoding("UTF-8");
			PrintWriter out = res.getWriter();
			try {
				req.getSession().removeAttribute("ADSelectEntity");
				//��ȡ����
				dto.setEsyscoding(form.getEsyscoding());
				dto.setSp_eiid(form.getSp_eiid());
				dto.setIgdrm0702Form(form);
				
				dto = ctlBL.searchEntityItemActionNoPage(dto);
				
				Gson gson= new Gson();
				
				List<Map<String,String>> resultMap = new ArrayList<Map<String,String>>();
				if(dto.getSoc0118InfoList() != null){
					for(SOC0118Info info :dto.getSoc0118InfoList()){
						Map<String,String> infoMap = new HashMap<String,String>();
						infoMap.put("id", form.getPidid()+"#" + info.getEiid() + "#" + info.getEiversion());
						infoMap.put("text", info.getEiname());
						infoMap.put("key", info.getFingerPrint()+"");
						resultMap.add(infoMap);
					}
				}
				out.print(gson.toJson(resultMap));
				
			}catch (Exception e) {
				out.print("");
				log.error("�ʲ���HELP��ѯ�쳣", e);
			} finally {
				if (out != null)
					out.close();
			}
			log.debug("========�ʲ���HELP��ѯ���������ʾ��������========");
			return null;
		}
		if( "AJAXUSER".equals(mapping.getParameter())){
			res.setCharacterEncoding("UTF-8");
			PrintWriter out = res.getWriter();
			try {
				//��ȡ����
				dto.setIgdrm0702Form(form);
				
				dto = ctlBL.searchProcessDefineUser(dto);
				Gson gson= new Gson();
				out.print(gson.toJson(dto.getDataMap()));
				
			}catch (Exception e) {
				out.print("");
				log.error("�ʲ���HELP��ѯ�쳣", e);
			} finally {
				if (out != null)
					out.close();
			}
			log.debug("========�ʲ���HELP��ѯ���������ʾ��������========");
			return null;
		}
		
		if("ADJUST".equals(mapping.getParameter())){
			dto.setRoleids(form.getRoleids());
			dto = ctlBL.searchRoleAndUser(dto);
			//���ʲ�����Ϣ��������趨��VO��
			IGDRM07022VO vo = new IGDRM07022VO();
			vo.setUserRoleMap(dto.getUserRoleMap());
			
			super.<IGDRM07022VO>setVO(req, vo);
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
