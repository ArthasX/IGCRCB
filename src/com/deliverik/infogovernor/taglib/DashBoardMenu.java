/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.taglib;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.Globals;
import org.apache.struts.taglib.TagUtils;

import com.deliverik.framework.security.UserPermission;
import com.deliverik.framework.user.model.Action;
import com.deliverik.framework.user.model.User;

/**
 * @Description:
 * @Author ZhaoJun
 * @History 2010-09-02 新建
 * @Version V1.0
 */
@SuppressWarnings("serial")
public class DashBoardMenu extends TagSupport {

	/** ACTION表的ACTNAME */
	protected String actName;

	/**返回相对路径 */
	protected String acturl;
	
	/**不显示菜单的ACTNAME*/
	protected String noDisplayActName;
	
	/**显示领导菜单*/
	protected String showtitle;
	
	@Override
	public int doStartTag() throws JspException {

		UserPermission perm = (UserPermission) pageContext.getSession().getAttribute(("UserPermission")); // 取得用户权限对象
		User user = (User)pageContext.getSession().getAttribute("LOGIN_USER"); 
		
		List<Map<Action, List<Map<Action, List<Map<Action, List<Action>>>>>>> actionList = perm
				.getActionList(); // 取得用户具有权限的菜单
		List<ActionTagBean> firstBeanList = new ArrayList<ActionTagBean>(); // 用户具有权限的一级菜单
		
		List<ActionTagBean> thirdAcList = new ArrayList<ActionTagBean>();

		// 递归构造用户具有权限的所有菜单
		for (Map<Action, List<Map<Action, List<Map<Action, List<Action>>>>>> firstMap : actionList) {
			Set<Action> firstSet = firstMap.keySet();
			Iterator<Action> firstIte = firstSet.iterator();
			Action firstAction = null;
			List<Map<Action, List<Map<Action, List<Action>>>>> secList = null;
			List<ActionTagBean> secBeanList = new ArrayList<ActionTagBean>();
			while (firstIte.hasNext()) {
				firstAction = firstIte.next();
			}

			// 取得二级菜单
			secList = firstMap.get(firstAction);
			if (secList != null) {
				for (Map<Action, List<Map<Action, List<Action>>>> secMap : secList) {
					Set<Action> secSet = secMap.keySet();
					Iterator<Action> secIte = secSet.iterator();
					Action secAction = null;
					List<Map<Action, List<Action>>> thirdList = null;
					List<ActionTagBean> thirdBeanList = new ArrayList<ActionTagBean>();
					while (secIte.hasNext()) {
						secAction = secIte.next();
					}
					// 取得3级菜单
					thirdList = secMap.get(secAction);
					if (thirdList != null) {
						for (Map<Action, List<Action>> thirdMap : thirdList) {
							Set<Action> thirdSet = thirdMap.keySet();
							Iterator<Action> thirdIte = thirdSet.iterator();
							Action thirdAction = null;
							while (thirdIte.hasNext()) {
								thirdAction = thirdIte.next();
							}
							if (thirdAction != null) {
								ActionTagBean atBean = new ActionTagBean();
								atBean.setActlabel(thirdAction.getActlabel());
								atBean.setActname(thirdAction.getActname());
								atBean.setActurl(thirdAction.getActurl());
								atBean.setActurlType(thirdAction
										.getActurltype());
								thirdBeanList.add(atBean);
							}
						}
					}
					// 构造二级菜单
					if (secAction != null) {
						ActionTagBean atBean = new ActionTagBean();
						atBean.setActlabel(secAction.getActlabel());
						atBean.setActname(secAction.getActname());
						atBean.setActurl(secAction.getActurl());
						atBean.setActurlType(secAction.getActurltype());
						atBean.setActionList(thirdBeanList);
						secBeanList.add(atBean);
					}

				}
			}
			// 构造一级菜单
			if (firstAction != null) {
				ActionTagBean atBean = new ActionTagBean();
				atBean.setActlabel(firstAction.getActlabel());
				atBean.setActname(firstAction.getActname());
				atBean.setActurl(firstAction.getActurl());
				atBean.setActurlType(firstAction.getActurltype());
				atBean.setActionList(secBeanList);
				firstBeanList.add(atBean);
			}
		}
		// 输出指定ACTNAME的所有菜单
		if (StringUtils.isNotEmpty(actName)) {
			String[] noDisName = noDisplayActName.split("[|]");
			String userType = user.getUsertype();
			StringBuffer outStr = new StringBuffer();
			if("true".equals(showtitle)){
				outStr.append("<li><a href=\"IGCOM0105.do?index=1 \">"+"运维首页"+"</a></li>");
				
				for (ActionTagBean aBean: thirdAcList) {
					
				}
//				outStr.append("<li><a href=\"IGCOM0105.do \">"+"刷新"+"</a></li>");
				outStr.append("<li><a href=\"#\" onclick=\"quit();\">"+"退出"+"</a></li>");
				TagUtils.getInstance().write(pageContext, outStr.toString());
				return (EVAL_BODY_INCLUDE);
			}
			for (ActionTagBean aBean : firstBeanList) { // 查询一级菜单
				if (actName.equals(aBean.getActname())) {
					if(userType.equals("2")||userType.equals("3")){
						outStr.append("<li><a href=\"IGCOM0105.do?index=1 \">"+"运维首页"+"</a></li>");
//						outStr.append("<li><a href=\"IGCOM0105.do \">"+"刷新"+"</a></li>");
					}else{
						outStr.append("<li><a href=\"IGCOM0105.do?index=1 \">"+"运维首页"+"</a></li>");
					}
					List<ActionTagBean> secList = aBean.getActionList(); // 查询二级菜单
					for (ActionTagBean secBean : secList) {
						if(isExistMenu(noDisName,secBean.getActname())){
							continue;
						}
						if(StringUtils.isNotEmpty(secBean.getActurl())){
							outStr.append("<li><a href=\""+acturl+""+ secBean.getActurl()+"\">"+secBean.getActlabel()+"</a></li>");
						}else{
							outStr.append("<li><a href=\"#\">"+secBean.getActlabel()+"</a></li>");
						}
						List<ActionTagBean> thirdList = secBean.getActionList(); // 查询三级菜单
						
						for (ActionTagBean thirdBean : thirdList) {
							if(isExistMenu(noDisName,thirdBean.getActname())){
								continue;
							}
							outStr.append("<li style=\"font-weight: normal;\"><a href=\""+acturl+""+ thirdBean.getActurl()+"\">");
							outStr.append("<span style=\"padding-left:10px;\">"+thirdBean.getActlabel()+"</span></a></li>");
						}
					}
					outStr.append("<li><a href=\"#\" onclick=\"quit();\">"+"退出"+"</a></li>");
					break;
				}

			}

			TagUtils.getInstance().write(pageContext, outStr.toString());
			return (EVAL_BODY_INCLUDE);
		}else{
			StringBuffer outStr = new StringBuffer();
			for (ActionTagBean aBean : firstBeanList) { // 查询一级菜单
				outStr.append("<li><a href=\""+acturl+""+ aBean.getActurl()+"&actname="+aBean.getActname()+"\">"+aBean.getActlabel()+"</a></li>");
				              
			}

			Locale currentLocale = (Locale)pageContext.getSession().getAttribute(Globals.LOCALE_KEY);
			if(currentLocale == null){
				currentLocale = Locale.getDefault();
			}
			if("en".equals(currentLocale.getLanguage())){
				outStr.append("<li><a href=\"#\" onclick=\"quit('IGCOM0102.do?lang=en');\">"+"Exit"+"</a></li>");
			}else{
				outStr.append("<li><a href=\"#\" onclick=\"quit('IGCOM0102.do?lang=zh');\">"+"退出"+"</a></li>");
			}

			TagUtils.getInstance().write(pageContext, outStr.toString());
			return (EVAL_BODY_INCLUDE);
		}
	}
	
	public boolean isExistMenu(String[] strs,String actName){
		if(strs!=null && strs.length>0){
			for(String str:strs){
				if(str.equals(actName)){
					return true;
				}
			}
		}
		return false;
	}

	public String getShowtitle() {
		return showtitle;
	}

	public void setShowtitle(String showtitle) {
		this.showtitle = showtitle;
	}

	public String getActName() {
		return actName;
	}

	public void setActName(String actName) {
		this.actName = actName;
	}

	public String getNoDisplayActName() {
		return noDisplayActName;
	}

	public void setNoDisplayActName(String noDisplayActName) {
		this.noDisplayActName = noDisplayActName;
	}

	public String getActurl() {
		return acturl;
	}

	public void setActurl(String acturl) {
		this.acturl = acturl;
	}
}