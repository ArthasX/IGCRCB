/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.action;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.user.model.UserRoleInfo;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.utility.ResourceUtility;
import com.deliverik.framework.workflow.WorkFlowConstDefine;
import com.deliverik.framework.workflow.prr.model.IG677Info;
import com.deliverik.infogovernor.bl.IGCOM01BL;
import com.deliverik.infogovernor.bl.IGCOM04BL;
import com.deliverik.infogovernor.dto.IGCOM01DTO;
import com.deliverik.infogovernor.dto.IGCOM04DTO;
import com.deliverik.infogovernor.form.IGCOM0201Form;
import com.deliverik.infogovernor.kgm.bl.IGKGMCONSTANTS;
import com.deliverik.infogovernor.kgm.bl.task.KnowledgeBL;
import com.deliverik.infogovernor.kgm.model.Knowledge;
import com.deliverik.infogovernor.kgm.model.condition.KnowledgeSearchCondImpl;
import com.deliverik.infogovernor.scheduling.bl.IGSCH01BL;
import com.deliverik.infogovernor.scheduling.model.QuartzJobsDetail;
import com.deliverik.infogovernor.sdl.dto.IGSDL01DTO;
import com.deliverik.infogovernor.sdl.form.IGSDL0110Form;
import com.deliverik.infogovernor.sym.bl.IGSYM05BL;
import com.deliverik.infogovernor.sym.dto.IGSYM05DTO;
import com.deliverik.infogovernor.sym.form.IGSYM0501Form;
import com.deliverik.infogovernor.sym.model.Notice;
import com.deliverik.infogovernor.vo.IGCOM03041VO;
import com.deliverik.infogovernor.vo.IGCOM04032VO;

/**
 * @Description: �쵼��¼����Action����
 * @Author  ZhaoJun
 * @History 2010-6-8     �½�
 * @Version V2.0
 */
public class IGCOM0403Action extends BaseAction {

	static Log log = LogFactory.getLog(IGCOM0101Action.class);
	private boolean showflag = false;// �Ƿ����û����ʾ��֪ͨ�������ڵ�֪ͨ��Ŀ���ڹ涨����ʾ������
	private boolean is_have_notice = true;// �Ƿ����֪ͨ

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
	public ActionForward doProcess(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest req,
			HttpServletResponse res) throws Exception {

		String file_path = this.getServlet().getServletContext().getRealPath(
				File.separator);// ���Ҫ����Ŀ¼�ľ���·��
		if("POP".equals(mapping.getParameter())){
			return mapping.findForward("IGCOM0407");
		}else if("CHANGE".equals(mapping.getParameter())){
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER); 
			IGCOM01DTO dto = new IGCOM01DTO();
			dto.setUser(user);
			
			req.setAttribute("igcom03041VO", getIGCOM03041VO(dto,file_path));
			dto.setUser(user);
			
			req.setAttribute("igcom03041VO", getIGCOM03041VO(dto,file_path));
			IGCOM01BL ctrlBl = (IGCOM01BL) getBean("IGCOM01BL");
			dto = ctrlBl.getUserRoles(dto);
			List<UserRoleInfo> userRoleInfoList = dto.getUserRoleInfoList();
			dto = ctrlBl.getUserRoles(dto);
			IGCOM0201Form form = (IGCOM0201Form)actionForm;
			String forward = form.getForward();
			Integer year = Integer.parseInt(form.getYear());
			Integer month = Integer.parseInt(form.getMonth());
			String curmonth = form.getCurmonth();//Ŀ����(ҳ������)
			String curyear = form.getCuryear();//Ŀ����
			if(forward.equals("back")){
				if(month == 0){
					req.setAttribute("year", year - 1);
					req.setAttribute("month", 11);
				} else {
					req.setAttribute("year", year);
					req.setAttribute("month", month - 1);
				}
			} else if (forward.equals("next")){
				if(month >= 11){
					req.setAttribute("year", year + 1);
					req.setAttribute("month", 0);
				} else {
					req.setAttribute("year", year);
					req.setAttribute("month", month + 1);
				}
			}
			
			Map<String,String> urlMap = new HashMap<String,String>();
			String roletype = WorkFlowConstDefine.PROCESS_ROLE_MARK;
			boolean flag = false;
			for(int i=0; i<userRoleInfoList.size(); i++){
				UserRoleInfo ur = userRoleInfoList.get(i);
				if(roletype.equals(ur.getRoletype().substring(0, roletype.length()))){
					flag = true;
					break;
				}
			}
			if(flag){
				IGSCH01BL ctBL_sdl = (IGSCH01BL)getBean("IGSCH01BL");
				IGSDL01DTO dto_sdl = new IGSDL01DTO();
				IGSDL0110Form form_sdl = new IGSDL0110Form();
				form_sdl.setYmonth(curyear+"/"+curmonth);
				dto_sdl.setIgsdl0110Form(form_sdl);
				dto_sdl.setUserid(user.getUserid());
				
				//����USERID��ʱ���ѯQuartzJobsDetail
				dto_sdl = ctBL_sdl.searchQuartzJobsByUserDate(dto_sdl);
				List<QuartzJobsDetail> quartzJobsList = dto_sdl.getQuartzJobsDetailList();
				
				String time = IGStringUtils.getCurrentDate();//��ǰʱ��
				for(QuartzJobsDetail qjd:quartzJobsList){
					if(qjd.getQjdtime().length()>=10 && (qjd.getQjdtime().substring(0,10).compareTo(time)>=0)){
						urlMap.put(qjd.getQjdtime().substring(0,10), "red");  //����Ҫ����ʱ����ɺ�ɫ
					}
				}
			}
			req.setAttribute("dwmap", urlMap);
			return mapping.findForward("IGCOM0403");
		}else{
			
			
			
		// Session���
		clearSessionFormData(req);
		IGCOM0201Form form = (IGCOM0201Form) actionForm;
		setLinkID(req, form.getLinkID());
		// ���'��ҳ'��ת��

		User user = (User) req.getSession()
				.getAttribute(SESSION_KEY_LOGIN_USER);
		IGCOM01DTO dto = new IGCOM01DTO();
		dto.setUser(user);

		req.setAttribute("igcom03041VO", getIGCOM03041VO(dto, file_path));
		IGCOM01BL ctrlBl = (IGCOM01BL) getBean("IGCOM01BL");
		dto = ctrlBl.getUserRoles(dto);
		List<UserRoleInfo> userRoleInfoList = dto.getUserRoleInfoList();
		Map<String,String> urlMap = new HashMap<String,String>();
		//�ж��Ƿ������̽�ɫ
		String roletype = WorkFlowConstDefine.PROCESS_ROLE_MARK;
		boolean flag = false;
		for(int i=0; i<userRoleInfoList.size(); i++){
			UserRoleInfo ur = userRoleInfoList.get(i);
			if(roletype.equals(ur.getRoletype().substring(0, roletype.length()))){
				flag = true;
				break;
			}
		}
		if(flag){
			IGSCH01BL ctBL_sdl = (IGSCH01BL)getBean("IGSCH01BL");
			IGSDL01DTO dto_sdl = new IGSDL01DTO();
			IGSDL0110Form form_sdl = new IGSDL0110Form();
			String curmonth = IGStringUtils.getCurrentDate().substring(5, 7);//��ǰ��
			String curyear = IGStringUtils.getCurrentYear();//��ǰ��
			form_sdl.setYmonth(curyear+"/"+curmonth);
//			form_sdl.setDate_j(curyear+"/"+curmonth+"/31 23:59");
//			form_sdl.setDate(IGStringUtils.getCurrentDate()+" 00:00");
			dto_sdl.setIgsdl0110Form(form_sdl);
			dto_sdl.setUserid(user.getUserid());

			dto_sdl = ctBL_sdl.searchQuartzJobsByUserDate(dto_sdl);
			List<QuartzJobsDetail> quartzJobsList = dto_sdl.getQuartzJobsDetailList();
			
			String time = IGStringUtils.getCurrentDate();//��ǰʱ��
			for(QuartzJobsDetail qjd:quartzJobsList){
				if(qjd.getQjdtime().length()>=10 && (qjd.getQjdtime().substring(0,10).compareTo(time)>=0) ){
					urlMap.put(qjd.getQjdtime().substring(0,10), "red");
				}
			}

		}
		req.setAttribute("dwmap", urlMap);
		
		
		/////////////////////////////////////////
		return mapping.findForward("SUCCESS");
		}
	}

	/**
	 * ȡ����ҳ��ʾ��VO
	 * 
	 * @param dto
	 * @param file_path
	 * @return
	 * @throws Exception
	 */

	private IGCOM03041VO getIGCOM03041VO(IGCOM01DTO dto, String file_path)
			throws Exception {
		IGCOM03041VO igcom03041VO = this.getWorkAssigned(dto.getUser()
				.getUserid(), dto);
		IGSYM05BL ctlBL = (IGSYM05BL) getBean("igsym05BL");
		igcom03041VO.setNoticeList(showNoticeByDB(ctlBL));
		igcom03041VO.setIs_have_notice(is_have_notice);
		if (showflag) {// �и���֪ͨ����
			igcom03041VO.setShowflag(true);
		}
		//-----------------------------------
		//��ʷ����ͳ����ʾ
//		IGSVC11BL igsvc11BL = (IGSVC11BL) getBean("igsvc11BL");
//		IGSVC10DTO dto1 = new IGSVC10DTO();
//		dto1.setUser(dto.getUser());
//		dto1 = igsvc11BL.searchHistoryCount(dto1);
//		igcom03041VO.setHlist(dto1.getHcount());
		// ����֪ʶ��ѯ song start 
		KnowledgeSearchCondImpl cond = new KnowledgeSearchCondImpl();
		cond.setKnstatus(IGKGMCONSTANTS.KNOWLEDGE_APPROVEED);
		KnowledgeBL knowledgeBL = (KnowledgeBL) getBean("knowledgeBL");
		List<Knowledge> knlist = knowledgeBL.searchKnowledgeByCond(cond, 0, 6);
		List<IGCOM04032VO> knvoList = new ArrayList<IGCOM04032VO>();
		boolean showKnflag = false;
		if(knlist !=null && knlist.size()>0){
			
			for(int i=0;i<knlist.size();i++){
				if(i<5){
					IGCOM04032VO vo = new IGCOM04032VO();
					vo.setKnowledge(knlist.get(i));
					String title = knlist.get(i).getKntitle();
					String titleall = knlist.get(i).getKntitle();
					String knfaultcause = knlist.get(i).getKnfaultcause();
					String knkeys = knlist.get(i).getKnkey();
					String time = knlist.get(i).getKnapprovetime();
					
					if(title !=null && title.length()>10){
						title = title.substring(0, 10) + "......";
					}
					if(knfaultcause !=null && knfaultcause.length()>21){
						knfaultcause = knfaultcause.substring(0, 21) + "......";
					}
					if(knkeys !=null && knkeys.length()>10){
						knkeys = knkeys.substring(0, 10) + "......";
					}
					if(time !=null){
						time = time.substring(0, 10);//ֻ����������
					}
					vo.setKnfaultcause(knfaultcause);
					vo.setTitle(title);
					vo.setKeys(knkeys);
					vo.setTime(time);
					vo.setTitleall(titleall);
 					knvoList.add(vo);
				}else{
					showKnflag = true;
					break;
				}
				
			}
		}
		igcom03041VO.setKnvoList(knvoList);
		igcom03041VO.setShowKnflag(showKnflag);
		// song start 
		return igcom03041VO;
	}

	/**
	 * ȡ����ҳ��ʾ�Ĺ����������Ϣ
	 * 
	 * @param userId
	 * @return
	 * @throws BLException
	 */
	private IGCOM03041VO getWorkAssigned(String userId, IGCOM01DTO dto)
			throws BLException {
		IGCOM04BL igcom04BL = (IGCOM04BL) getBean("igcom04BL");
		IGCOM04DTO igcom04DTO = new IGCOM04DTO();
		igcom04DTO.setUserId(userId);
		igcom04DTO = igcom04BL.getProcessRecordList(igcom04DTO);
		IGCOM03041VO igcom03041VO = igcom04DTO.getIgcom03041VO();

		List<IG677Info> forMeList = igcom03041VO.getProcessRecordInfoForMeList();
		List<IG677Info> forMeListAsc = new ArrayList<IG677Info>();
		forMeListAsc.addAll(forMeList);
		List<IG677Info> forGroupList = igcom03041VO.getProcessRecordInfoForGroupList();
		List<IG677Info> forGroupListAsc = new ArrayList<IG677Info>();
		forGroupListAsc.addAll(forGroupList);
		
		//���ҵĹ�����������
		Collections.sort(forMeList, new Comparator<IG677Info>(){
			public int compare(IG677Info o1, IG677Info o2){ 
				return o1.getPropentime().compareTo(o2.getPropentime());
			}
		});
		
		//���ҵĹ�����������
		Collections.sort(forMeListAsc, new Comparator<IG677Info>(){
			public int compare(IG677Info o1, IG677Info o2){ 
				return o2.getPropentime().compareTo(o1.getPropentime());
			}
		});
		
		
		//����ع�����������
		Collections.sort(forGroupList, new Comparator<IG677Info>(){
			public int compare(IG677Info o1, IG677Info o2){ 
				return o1.getPropentime().compareTo(o2.getPropentime());
			}
		});
		
		//����ع�����������
		Collections.sort(forGroupListAsc, new Comparator<IG677Info>(){
			public int compare(IG677Info o1, IG677Info o2){ 
				return o2.getPropentime().compareTo(o1.getPropentime());
			}
		});
		
		igcom03041VO.setProcessRecordInfoForMeList(forMeList);
		igcom03041VO.setProcessRecordInfoForMeListAsc(forMeListAsc);
		igcom03041VO.setProcessRecordInfoForGroupList(forGroupList);
		igcom03041VO.setProcessRecordInfoForGroupListAsc(forGroupListAsc);

		return igcom03041VO;
	}

	/**
	 * ��ѯ���ڵ�֪ͨ(���ݿ��)
	 * 
	 * @param svcbl
	 * @param svcform
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	private ArrayList showNoticeByDB(IGSYM05BL bl) throws Exception {

		IGSYM0501Form form = new IGSYM0501Form();
		IGSYM05DTO dto = new IGSYM05DTO();
		int num = Integer
				.parseInt(ResourceUtility.getString("NOTICE_SHOW_NUM"));// �����ļ����趨��֪ͨ����ʾ��Ŀ
		int length = Integer.parseInt(ResourceUtility
				.getString("NOTICE_SHOW_LENGTH"));// �����ļ����趨��֪ͨ��ÿ����ʾ����
		dto.setNoticeSearchCond(form);
		// ��ѯ
		dto = bl.getNoticeInfo(dto);
		List<Notice> list = dto.getNoticeCondList();// ���µ�5��֪ͨ����
		ArrayList infolist = new ArrayList();
		String nid = "";
		if (null == list || 0 == list.size()) {
//			infolist.add("Ŀǰû��֪ͨ��");
			is_have_notice = false;
		} else {
			is_have_notice = true;
			if (list.size() > num) {
				showflag = true;// �и���֪ͨ����
			}
			for (int i = 0, j = list.size(); i < j; i++) {
				Notice notice = list.get(i);
				if (showflag) {
					if ((i + 1) > num) {
						break;
					}
				}

				String showtime = notice.getNtime() + "-";
				String info = "";
				info += "&nbsp;&nbsp;" + notice.getNusername();
				info += "-" + notice.getNname();
				// ��ȡ֪ͨnid
				nid = notice.getNid().toString();
				// info+="  "+notice.getNdesc();
				// ȡ��֪ͨ��ʾ����Ϣ
				info = getShowLength(info, showtime, length + 8, nid);
				infolist.add(info);
			}
		}

		return infolist;
	}

	/**
	 * �ж�֪ͨ�������Ƿ񳬹��涨����ʾ����
	 */
	private boolean isOverShowLength(String info, String showtime, int length) {

		boolean lengthflag = false;
		String temp = "";
		temp += showtime + info;
		if (temp.length() > length) {
			lengthflag = true;
		}

		return lengthflag;

	}

	/**
	 * ȡ�ù涨��ʾ������
	 */
	private String getShowLength(String info, String showtime, int length,
			String nid) {

		String temp = "";
		String result = "";// ���ؽ��
		temp += showtime + info;
		if (isOverShowLength(info, showtime, length)) {// ���������涨
			temp = temp.substring(0, length) + "......";
			String time = "<INPUT TYPE=\"HIDDEN\" NAME=\"nid\" VALUE="
					+ nid + ">" + temp.split("-")[0];
			result = time+"&nbsp;&nbsp;"+temp.split("-")[2] ;

		} else {
			String time = "<INPUT TYPE=\"HIDDEN\" NAME=\"nid\" VALUE="
					+ nid + ">" + temp.split("-")[0];
			result = time+"&nbsp;&nbsp;"+temp.split("-")[2];
		}

		return result;
	}
	
}