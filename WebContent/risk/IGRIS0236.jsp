<%@page import="java.util.LinkedHashMap"%>
<%@page import="com.deliverik.infogovernor.prr.vo.IGPRR01036VO"%>
<%@page import="com.deliverik.framework.workflow.prd.model.IG333Info"%>
<%@page import="java.util.Map"%>
<%@page import="com.deliverik.framework.user.model.Role"%>
<%@page import="com.deliverik.framework.user.model.UserInfo"%>
<%@page import="com.deliverik.infogovernor.prr.vo.IGPRR01035VO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.deliverik.infogovernor.prr.vo.IGPRR01034VO"%>
<%@page import="java.util.List"%>
<%@page import="com.deliverik.infogovernor.prr.vo.IGPRR01033VO"%>
<%@page import="com.deliverik.framework.user.model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
    User user = (User)session.getAttribute("LOGIN_USER");
	String orgid = user.getOrgid();
	IGPRR01033VO vo = (IGPRR01033VO)session.getAttribute("IGPRR01033VO");
	if(vo != null){
		List<IGPRR01034VO> voList = vo.getLst_IGPRR01034VO();
		if(voList != null){
			Map<IG333Info,IGPRR01036VO> map = new LinkedHashMap<IG333Info,IGPRR01036VO>();
			for(IGPRR01034VO cvo:voList){
				List<IGPRR01035VO> cvoList = cvo.getLst_IGPRR01035VO();
				if(cvoList != null){
					IGPRR01036VO mapVo = new IGPRR01036VO();
					Map<Role,List<UserInfo>> voMap = new LinkedHashMap<Role,List<UserInfo>>();
					for(IGPRR01035VO ccvo:cvoList){
						List<UserInfo> userList = ccvo.getLst_UserInfo();
						if(userList != null){
							List<UserInfo> newUserList = new ArrayList<UserInfo>();
							for(UserInfo u:userList){
								if(u.getOrgida().startsWith(orgid)){
									newUserList.add(u);
								}
							}
							voMap.put(ccvo.getRole(), newUserList);
						}
					}
					mapVo.setMap_ParticipantDefToBeAssignByRole(voMap);
					map.put(cvo.getProcessStatusDef(), mapVo);
				}
			}
			vo = new IGPRR01033VO(map);
			session.setAttribute("IGPRR01033VO", vo);
		}
	}
	getServletContext().getRequestDispatcher("/prr/IGPRR0103.jsp").forward(request, response);
%>