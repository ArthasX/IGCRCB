/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
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
import org.springframework.beans.BeanUtils;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.security.UserPermission;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.user.model.UserRoleInfo;
import com.deliverik.framework.utility.ResourceUtility;
import com.deliverik.framework.workflow.WorkFlowConstDefine;
import com.deliverik.framework.workflow.prr.model.IG677Info;
import com.deliverik.framework.workflow.prr.model.entity.IG677VW;
import com.deliverik.infogovernor.bl.IGCOM01BL;
import com.deliverik.infogovernor.bl.IGCOM04BL;
import com.deliverik.infogovernor.dto.IGCOM01DTO;
import com.deliverik.infogovernor.dto.IGCOM04DTO;
import com.deliverik.infogovernor.form.IGCOM0201Form;
import com.deliverik.infogovernor.svc.bl.IGPROCESSType;
import com.deliverik.infogovernor.sym.bl.IGSYM05BL;
import com.deliverik.infogovernor.sym.dto.IGSYM05DTO;
import com.deliverik.infogovernor.sym.form.IGSYM0501Form;
import com.deliverik.infogovernor.sym.model.DateWorkVWInfo;
import com.deliverik.infogovernor.sym.model.Notice;
import com.deliverik.infogovernor.vo.IGCOM03041VO;
import com.deliverik.infogovernor.vo.IGCOM04031VO;

/**
 * @Description: 技术人员登录画面Action处理
 * @Author  Wu Zhen qiu
 * @History 2010-6-8     新建
 * @History 2010-7-21    0000000判断是否存在服务工单浏览权限
 * @Version V2.0
 */
public class IGCOM0402Action extends BaseAction {

	static Log log = LogFactory.getLog(IGCOM0101Action.class);
	private boolean showflag = false;//是否存在没有显示的通知（即存在的通知数目大于规定的显示条数）
	private boolean is_have_notice = true;//是否存在通知
	/**
	 * 
	 *
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 * @throws Exception 
	 * @update 0000192
	 * @update 0000427
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		String file_path = this.getServlet().getServletContext().getRealPath(File.separator);// 获得要创建目录的绝对路径
		
		if("POP".equals(mapping.getParameter())){
			return mapping.findForward("IGCOM0407");
		}else if("CHANGE".equals(mapping.getParameter())){
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER); 
			IGCOM01DTO dto = new IGCOM01DTO();
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
			String m = String.valueOf(Integer.parseInt(String.valueOf(req.getAttribute("month")))+1);
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
			//////////////////////////////////////////
			IGSYM05BL ctlBL_dw = (IGSYM05BL) getBean("igsym05BL");
			IGSYM05DTO dto_dw = new IGSYM05DTO();
			//个人
			dto_dw = ctlBL_dw.searchDateWorkAction(m, user.getUserid());
			Map<String,String> urlMapa = new HashMap<String,String>();
			
			for(int i=0; i<dto_dw.getDateWorkList().size();i++){
				DateWorkVWInfo dw = dto_dw.getDateWorkList().get(i);
				urlMapa.put(dw.getDate(), "red");
			}
			//相关
			dto_dw = ctlBL_dw.searchDateWorkAction(m, user.getUserid(), userRoleInfoList);
			Map<String,String> urlMapb = new HashMap<String,String>();
			
			for(int i=0; i<dto_dw.getDateWorkList().size();i++){
				DateWorkVWInfo dw = dto_dw.getDateWorkList().get(i);
				urlMapb.put(dw.getDate(), "blue");
			}
			//其它
			dto_dw = ctlBL_dw.searchDateWorkAction(m, user.getUserid(), userRoleInfoList, "");
			Map<String,String> urlMapc = new HashMap<String,String>();
			
			for(int i=0; i<dto_dw.getDateWorkList().size();i++){
				DateWorkVWInfo dw = dto_dw.getDateWorkList().get(i);
				urlMapc.put(dw.getDate(), "green");
			}
			//合并
			
			for(int i=1; i<=31; i++){
				if(!"null".equals(String.valueOf(urlMapa.get(String.valueOf(i).length()>1?String.valueOf(i):"0"+String.valueOf(i))))){
					urlMap.put(String.valueOf(i), "red");
				}else if(!"null".equals(String.valueOf(urlMapb.get(String.valueOf(i).length()>1?String.valueOf(i):"0"+String.valueOf(i))))){
					urlMap.put(String.valueOf(i), "blue");
				}else if(!"null".equals(String.valueOf(urlMapc.get(String.valueOf(i).length()>1?String.valueOf(i):"0"+String.valueOf(i))))){
					urlMap.put(String.valueOf(i), "green");
				}else{
					urlMap.put(String.valueOf(i), "black");
				}
			}
			}else{
				for(int i=1; i<=31; i++){
					urlMap.put(String.valueOf(i), "black");
				}
			}
			req.setAttribute("dwmap", urlMap);
			/////////////////////////////////////////
			
			//mod by 0000000 begin 
			UserPermission perm = (UserPermission)req.getSession().getAttribute("UserPermission");
			String menu = "ACT02SVC0115";

			//根据用户角色权限，判断服务目录类型
			if(perm.checkPermission(menu)) {
				
				return mapping.findForward("IGCOM0408");
				
			} else {
				
				return mapping.findForward("IGCOM0402");
				
			}
			//mod by 0000000 end 
		}else {
			
			//点击'首页'的转发
			
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER); 
			IGCOM01DTO dto = new IGCOM01DTO();
			dto.setUser(user);
			req.setAttribute("igcom03041VO", getIGCOM03041VO(dto,file_path));
			IGCOM01BL ctrlBl = (IGCOM01BL) getBean("IGCOM01BL");
			dto = ctrlBl.getUserRoles(dto);
			
		    List<UserRoleInfo> userRoleInfoList = dto.getUserRoleInfoList();
		    Map<String,String> urlMap = new HashMap<String,String>();
		    //判断是否有流程角色
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
			//////////////////////////////////////////
			IGSYM05BL ctlBL_dw = (IGSYM05BL) getBean("igsym05BL");
			IGSYM05DTO dto_dw = new IGSYM05DTO();
			//个人
			dto_dw = ctlBL_dw.searchDateWorkAction(user.getUserid());
			Map<String,String> urlMapa = new HashMap<String,String>();
			
			for(int i=0; i<dto_dw.getDateWorkList().size();i++){
				DateWorkVWInfo dw = dto_dw.getDateWorkList().get(i);
				urlMapa.put(dw.getDate(), "red");
			}
			//相关
			dto_dw = ctlBL_dw.searchDateWorkAction(user.getUserid(), userRoleInfoList);
			Map<String,String> urlMapb = new HashMap<String,String>();
			
			for(int i=0; i<dto_dw.getDateWorkList().size();i++){
				DateWorkVWInfo dw = dto_dw.getDateWorkList().get(i);
				urlMapb.put(dw.getDate(), "blue");
			}
			//其它
			dto_dw = ctlBL_dw.searchDateWorkAction(user.getUserid(), userRoleInfoList, "");
			Map<String,String> urlMapc = new HashMap<String,String>();
			
			for(int i=0; i<dto_dw.getDateWorkList().size();i++){
				DateWorkVWInfo dw = dto_dw.getDateWorkList().get(i);
				urlMapc.put(dw.getDate(), "green");
			}
			//合并
			
			for(int i=1; i<=31; i++){
				if(!"null".equals(String.valueOf(urlMapa.get(String.valueOf(i).length()>1?String.valueOf(i):"0"+String.valueOf(i))))){
					urlMap.put(String.valueOf(i), "red");
				}else if(!"null".equals(String.valueOf(urlMapb.get(String.valueOf(i).length()>1?String.valueOf(i):"0"+String.valueOf(i))))){
					urlMap.put(String.valueOf(i), "blue");
				}else if(!"null".equals(String.valueOf(urlMapc.get(String.valueOf(i).length()>1?String.valueOf(i):"0"+String.valueOf(i))))){
					urlMap.put(String.valueOf(i), "green");
				}else{
					urlMap.put(String.valueOf(i), "black");
				}
			}
			}else{
				for(int i=1; i<=31; i++){
					urlMap.put(String.valueOf(i), "black");
				}
			}
			req.setAttribute("dwmap", urlMap);
		
			//mod by 0000000 begin 
			UserPermission perm = (UserPermission)req.getSession().getAttribute("UserPermission");
			String menu = "ACT02SVC0115";

			//根据用户角色权限，判断服务目录类型
			if(perm.checkPermission(menu)) {
				
				return mapping.findForward("IGCOM0408");
				
			} else {
				
				return mapping.findForward("IGCOM0402");
				
			}
			//mod by 0000000 end 
			
		}
	}
	
	/**
	 * 取得首页显示用VO
	 * @param dto
	 * @param file_path
	 * @return
	 * @throws Exception
	 */
	
	private IGCOM03041VO getIGCOM03041VO(IGCOM01DTO dto,String file_path) throws Exception{
		IGCOM03041VO igcom03041VO = this.getWorkAssigned(dto.getUser().getUserid(),dto);
		IGSYM05BL ctlBL = (IGSYM05BL) getBean("igsym05BL");
		igcom03041VO.setNoticeList(showNoticeByDB(ctlBL));
		igcom03041VO.setIs_have_notice(is_have_notice);
		if(showflag){//有更多通知存在
			igcom03041VO.setShowflag(true);
		}

		return igcom03041VO;
	}
	
	/**
	 * 取得首页显示的工作的相关信息
	 * @param userId
	 * @return
	 * @throws BLException
	 * @update 0000192 
	 */
	private IGCOM03041VO getWorkAssigned(String userId,IGCOM01DTO dto) throws BLException{
		IGCOM04BL igcom04BL = (IGCOM04BL) getBean("igcom04BL");
		IGCOM04DTO igcom04DTO = new IGCOM04DTO();
		igcom04DTO.setUserId(userId);
		igcom04DTO = igcom04BL.getWorkAssigned(igcom04DTO);
		IGCOM03041VO igcom03041VO = igcom04DTO.getIgcom03041VO();
		
		
		List<IG677Info> forMeList = igcom03041VO.getProcessRecordInfoForMeList();
		List<IG677Info> forGroupListTmp = igcom03041VO.getProcessRecordInfoForGroupList();
		List<IG677Info> forGroupList = new ArrayList<IG677Info>();
		forGroupList.addAll(forMeList);
		forGroupList.addAll(forGroupListTmp);
		
		List <IG677Info> meListTmp = new ArrayList<IG677Info>();
		List <IG677Info> groupListTmp = new ArrayList<IG677Info>();
		List <IG677Info> meListTmpAsc = new ArrayList<IG677Info>();
		List <IG677Info> groupListTmpAsc = new ArrayList<IG677Info>();
		
		for(int i=0;i<forMeList.size();i++){
			IG677VW obj = (IG677VW)forMeList.get(i);
			IGCOM04031VO vo04 = new IGCOM04031VO();
			BeanUtils.copyProperties(obj, vo04);
			if((IGPROCESSType.CHANGE_PRTYPE.equals(obj.getPrtype()))||IGPROCESSType.DEPLOYMENT_PRTYPE.equals(obj.getPrtype())){
				vo04.setPropentime(obj.getPrplantime());
			}
			meListTmp.add(vo04);
		}
		for(int i=0;i<forGroupList.size();i++){
			IGCOM04031VO vo04 = new IGCOM04031VO();
			IG677VW obj = (IG677VW)forGroupList.get(i);
			BeanUtils.copyProperties(obj, vo04);
			if((IGPROCESSType.CHANGE_PRTYPE.equals(obj.getPrtype()))||IGPROCESSType.DEPLOYMENT_PRTYPE.equals(obj.getPrtype())){
				vo04.setPropentime(obj.getPrplantime());
			}
			groupListTmp.add(vo04);
		}
		
		meListTmpAsc.addAll(meListTmp);
		groupListTmpAsc.addAll(groupListTmp);
		
		Collections.sort(meListTmp, new Comparator<IG677Info>(){
			public int compare(IG677Info o1, IG677Info o2){ 
				return o1.getPropentime().compareTo(o2.getPropentime());
			}
		});

		Collections.sort(groupListTmp, new Comparator<IG677Info>(){
			public int compare(IG677Info o1, IG677Info o2){ 
				return o1.getPropentime().compareTo(o2.getPropentime());
			}
		});
		
		Collections.sort(meListTmpAsc, new Comparator<IG677Info>(){
			public int compare(IG677Info o1, IG677Info o2){ 
				return o2.getPropentime().compareTo(o1.getPropentime());
			}
		});

		Collections.sort(groupListTmpAsc, new Comparator<IG677Info>(){
			public int compare(IG677Info o1, IG677Info o2){ 
				return o2.getPropentime().compareTo(o1.getPropentime());
			}
		});
		
		int count = 10;
		if(meListTmp.size() > count){
			meListTmp = meListTmp.subList(0, count);
		}

		if(groupListTmp.size() > count){
			groupListTmp = groupListTmp.subList(0, count);
		}
		
		if(meListTmpAsc.size() > count){
			meListTmpAsc = meListTmpAsc.subList(0, count);
		}
		if(groupListTmpAsc.size() > count){
			groupListTmpAsc = groupListTmpAsc.subList(0, count);
		}
		
		
		
		igcom03041VO.setProcessRecordInfoForMeList(meListTmp);
		igcom03041VO.setProcessRecordInfoForGroupList(groupListTmp);
		igcom03041VO.setProcessRecordInfoForMeListAsc(meListTmpAsc);
		igcom03041VO.setProcessRecordInfoForGroupListAsc(groupListTmpAsc);
		
		return igcom03041VO;
	}

	/**
	 * 查询存在的通知(数据库版)
	 * 
	 * @param svcbl
	 * @param svcform
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	private ArrayList showNoticeByDB(IGSYM05BL bl) throws Exception {

		IGSYM0501Form form = new IGSYM0501Form();
		IGSYM05DTO dto = new IGSYM05DTO();
		int num = 5;// 配置文件中设定的通知的显示数目
		int length = Integer.parseInt(ResourceUtility
				.getString("NOTICE_SHOW_LENGTH"));// 配置文件中设定的通知的每行显示字数
		dto.setNoticeSearchCond(form);
		// 查询
		dto = bl.getNoticeInfo(dto);
		List<Notice> list = dto.getNoticeCondList();// 最新的5条通知内容
		ArrayList infolist = new ArrayList();
		String nid = "";
		if (null == list || 0 == list.size()) {
//			infolist.add("目前没有通知！");
			is_have_notice = false;
		} else {
			is_have_notice = true;
			if (list.size() > num) {
				showflag = true;// 有更多通知存在
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
				// 获取通知nid
				nid = notice.getNid().toString();
				// info+="  "+notice.getNdesc();
				// 取得通知显示的信息
				info = getShowLength(info, showtime, length + 5, nid);
				infolist.add(info);
			}
		}

		return infolist;
	}
	/**
	 * 判断通知的字数是否超过规定的显示字数
	 */
	private boolean isOverShowLength(String info,String showtime,int length){

		boolean lengthflag = false;
		String temp = "";
		temp+=showtime+info;
		if(temp.length()>length){
			lengthflag = true;
		}

		return lengthflag;
		
	}
	/**
	 * 取得规定显示的字数
	 */
	private String getShowLength(String info, String showtime, int length,
			String nid) {

		String temp = "";
		String result = "";// 返回结果
		temp += showtime + info;
		if (isOverShowLength(info, showtime, length)) {// 字数超过规定
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
