package com.deliverik.infogovernor.asset.action;

import java.util.HashMap;
import java.util.LinkedHashMap;
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

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.asset.bl.IGASM32BL;
import com.deliverik.infogovernor.asset.dto.IGASM32DTO;
import com.deliverik.infogovernor.asset.form.IGASM3202Form;
import com.deliverik.infogovernor.asset.model.RiskcaseVWInfo;
import com.deliverik.infogovernor.asset.model.condition.RiskcaseVWSearchCondImpl;
import com.deliverik.infogovernor.asset.vo.IGASM32021VO;
import com.deliverik.infogovernor.svc.bl.IGSVC01BL;
import com.deliverik.infogovernor.svc.dto.IGSVC01DTO;
import com.deliverik.infogovernor.svc.form.IGSVC0100Form;

/**
 * �ĵ��༭����Action����
 *
 * @author
 */
public class IGASM3202Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM3202Action.class);

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
		IGASM3202Form form = (IGASM3202Form)actionForm;
		
		//BLȡ��
		IGASM32BL ctlBL = (IGASM32BL) getBean("IGASM32BL");
		
		//DTO����
		IGASM32DTO dto = new IGASM32DTO();
		
		
		//�����߰汾
		Integer highVersion = null;
		
		//�����ӵ�еİ汾
		Map<Integer,Integer> checkVersionMap = new HashMap<Integer, Integer>();
		//������ת�趨
		String forward = null;

		if( "DISP".equals(mapping.getParameter())){
			log.debug("========�����¼��Ǽǻ��������ʾ����ʼ========");
			forward = "DISP";
			log.debug("========�����¼��Ǽǻ��������ʾ�������========");
		}else if( "INSERT".equals(mapping.getParameter())){
			log.debug("========�����¼��ǼǴ���ʼ========");
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			form.setEiorgsyscoding(user.getOrgid());
			form.setEiuserid(user.getUserid());
			form.setEiusername(user.getUsername());
			
			dto.setIgasm3202Form(form);
			
			dto = ctlBL.insertEntityItemAction(dto);
			
			
			IGASM32021VO vo = new IGASM32021VO(dto.getEiid());
			if(form.getRiskid()!=null && !(form.getRiskid().equals(""))){
				vo.setRiskid(Integer.parseInt(form.getRiskid()));	
			}
			
			vo.setRiskjobid(form.getRiskjobid());
			super.<IGASM32021VO>setVO(req.getSession(), vo);
			if(form!=null && form.getFlag()!=null && form.getFlag().equals("1")){
				forward = "SUCCESS2";
			}else{
				forward = "SUCCESS";				
			}
			log.debug("========�����¼��ǼǴ�������========");
		}else if( "EDIT_DISP".equals(mapping.getParameter())){
			log.debug("========�����¼������ʼ����ʼ========");
			getPaginDTO(req,"IGASM3202");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			dto.setIgasm3202Form(form);
			
			int maxCnt = getMaxDataCount("IGASM3202");
			
			//��ѯ���°汾
			dto.setEiid(form.getEiid());
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			RiskcaseVWSearchCondImpl cond = new RiskcaseVWSearchCondImpl();
			cond.setEiid(form.getEiid());
			cond.setVersion("0");
			dto.setRiskcaseVWSearchCond(cond);
			dto = ctlBL.searchEntityItemAction(dto);
			copyArgu(dto);
			Map<Integer,Integer> maps = dto.getIgasm3202Form().getCheckVersionMap();
			for(int i=0;i<maps.size();i++){
				highVersion = maps.get(i);
			}
			
			//��ѯ��ع�������
			String riskjobid = dto.getIgasm3202Form().getRiskjobid();
			String riskEiid = dto.getIgasm3202Form().getRiskid();
			if(riskjobid==null || riskjobid.equals("")){
				riskjobid = req.getParameter("riskjobid");
			}
			if(riskEiid == null || riskEiid.equals("")){
				riskEiid = req.getParameter("riskEiid");
			}
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			//��¼�����������������
			String name = "";
			//�ж���ع�������������ID�Ƿ�Ϊ��
			if(riskjobid !=null && !(riskjobid.equals(""))){
				IGSVC0100Form form1 = new IGSVC0100Form();
				form1.setPrpdid("01001");
				IGSVC01BL ctlBL1 = (IGSVC01BL) getBean("igsvc01BL");
				IGSVC01DTO dto01 = new IGSVC01DTO();
				getPaginDTO(req,"IGSVC0106");
				PagingDTO pDto2;
				pDto2 = (PagingDTO)req.getAttribute("PagingDTO");
				
				dto01.setMaxSearchCount(100000);
				dto01.setPagingDto(pDto2);
				form1.setUserid_q(user.getUserid());
				form1.setSing("DESC");
				form1.setOrder("prclosetime desc , propentime ");
				dto01.setPrSearchCond(form1);
				//����BL��ѯ
				dto01 = ctlBL1.getProcessRecords(dto01);
				
				if(dto01.getProcessList() !=null && dto01.getProcessList().size()>0  ){
					name = dto01.getProcessList().get(0).getPrtitle();
				}
			}
			dto.getIgasm3202Form().setEiversion(highVersion.toString());
			dto.getIgasm3202Form().setFcriskname(dto.getRiskcaseVWList().get(0).getFcriskname());
			dto.getIgasm3202Form().setFccheckjob(name);
			dto.getIgasm3202Form().setFctypename(dto.getRiskcaseVWList().get(0).getRisktype());
			dto.getIgasm3202Form().setFcseveritylevel(dto.getRiskcaseVWList().get(0).getFcseveritylevel());
			dto.getIgasm3202Form().setFcpossibility(dto.getRiskcaseVWList().get(0).getFcpossibility());
			dto.getIgasm3202Form().setFclevel(dto.getRiskcaseVWList().get(0).getFclevel());
			req.setAttribute("IGASM3202Form", dto.getIgasm3202Form());
			req.setAttribute("highVersion", highVersion);
			forward = "DISP";
			log.debug("========�����¼������ʼ������========");
		}else if( "UPDATE".equals(mapping.getParameter())){
			log.debug("========�����¼�����ʼ========");
			dto.setIgasm3202Form(form);	
			dto = ctlBL.updateEntityItem(dto);
			IGASM32021VO vo = new IGASM32021VO(form.getEiid());
			super.<IGASM32021VO>setVO(req.getSession(), vo);
			forward = "SUCCESS";
			req.setAttribute("flag", "1");
			log.debug("========�����¼���������========");
		}else if( "VERSION".equals(mapping.getParameter())){
			log.debug("========�����¼�����ʼ========");
			dto.setIgasm3202Form(form);
			//��ѯ���°汾
			dto.setEiid(form.getEiid());
			RiskcaseVWSearchCondImpl cond = new RiskcaseVWSearchCondImpl();
			cond.setEiid(form.getEiid());
			cond.setVersion(form.getEiversion());
			dto.setRiskcaseVWSearchCond(cond);
			dto = ctlBL.searchEntityItemByVersion(dto);
			copyArgu(dto);
			
			highVersion = Integer.parseInt(req.getParameter("highVersion"));
			
			for(int i=0;highVersion!=null && i<highVersion;i++){
				checkVersionMap.put(i, i+1);
			}
			dto.getIgasm3202Form().setCheckVersionMap(checkVersionMap);
			dto.getIgasm3202Form().setFcriskname(dto.getRiskcaseVWList().get(0).getFcriskname());
			dto.getIgasm3202Form().setFctypename(dto.getRiskcaseVWList().get(0).getRisktype());
			dto.getIgasm3202Form().setFcseveritylevel(dto.getRiskcaseVWList().get(0).getFcseveritylevel());
			dto.getIgasm3202Form().setFcpossibility(dto.getRiskcaseVWList().get(0).getFcpossibility());
			dto.getIgasm3202Form().setFclevel(dto.getRiskcaseVWList().get(0).getFclevel());
			req.setAttribute("IGASM3202Form", dto.getIgasm3202Form());
			req.setAttribute("highVersion", highVersion);
			forward = "SUCCESS";
			log.debug("========�����¼���������========");
		}
		
		List<ActionMessage> messageList = dto.getMessageList();
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
		}
		
		return mapping.findForward(forward);
	}
	
	private void copyArgu(IGASM32DTO dto){
		List<RiskcaseVWInfo> list = dto.getRiskcaseVWList();
		IGASM3202Form form = dto.getIgasm3202Form();
		if(list!=null && list.size()==1){
			RiskcaseVWInfo ri = list.get(0);
			form.setEiid(ri.getEIID());
			form.setEistatus(ri.getEISTATUS());
			form.setFcname(ri.getFcname());
			form.setFcdesc(ri.getFcdesc());
			form.setFcorigin(ri.getFcorigin());
			form.setFccategory(ri.getFccategory());
			//���������������
			
			form.setRiskjobid(ri.getRiskjobid());
			//���յ�����
			
			form.setRiskid(ri.getRiskid());
			//���յ��������
			
			form.setRisktype(ri.getRisktype());
			form.setFcseveritylevel(ri.getFcseveritylevel());
			form.setFcpossibility(ri.getFcpossibility());
			form.setFclevel(ri.getFclevel());
			form.setRiskcatchtime(ri.getRiskcatchtime());
			form.setRisktype(ri.getRisktype());
			form.setFcrisktask(ri.getFcrisktask());
			form.setFcrisktaskdesc(ri.getFcrisktaskdesc());
			form.setFcpolicy(ri.getFcpolicy());
			form.setFcoperatoraim(ri.getFcoperatoraim());
			form.setFcoperatordept(ri.getFcoperatordept());
			form.setRiskoperatordept(ri.getRiskoperatordept());
			form.setFcoperator(ri.getFcoperator());
			form.setRiskoperator(ri.getRiskoperator());
			form.setFcccoperator(ri.getFcccoperator());
			form.setRiskccoperator(ri.getRiskccoperator());
			form.setRiskreviewresult(ri.getRiskreviewresult());
			form.setRiskdealid(ri.getRiskdealid());
			/**
			 * ���ð汾ѡ��������
			 */
			Map<Integer,Integer> checkVersionMap = new LinkedHashMap<Integer, Integer>();
			for (int i=0;i<Integer.parseInt(ri.getFingerPrint());i++){
				checkVersionMap.put(i,i+1);
			}
			form.setCheckVersionMap(checkVersionMap);
			dto.setIgasm3202Form(form);
		}
	}
}
