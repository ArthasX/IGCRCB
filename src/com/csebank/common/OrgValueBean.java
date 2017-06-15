package com.csebank.common;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.csebank.lom.bl.IGLOMCONSTANTS;
import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.user.bl.task.OrganizationBL;
import com.deliverik.framework.user.model.Organization;
import com.deliverik.framework.user.model.condition.OrganizationSearchCondImpl;

public class OrgValueBean {
	/** 记录日志 */
	private static Log log = LogFactory.getLog(OrgValueBean.class);
	
	/** 系统参数信息 */
	private static Map<String, String> orgValueMap = new HashMap<String, String>();

	/** 加载属性文件标识 */
	private static boolean init = false;

	/**
	 * <p>
	 * Description:构造函数
	 * </p>
	 */
	private OrgValueBean() {

	}

	/**
	 * <p>
	 * Discription:初始化参数map
	 * </p>
	 * 
	 * @update liupeng@deliverik.com
	 */
	public static void init() {
		if (!init) {
			log.debug("＝＝＝＝＝＝系统参数初始化开始＝＝＝＝＝＝");
			// 取出单位系统配置参数
			
			OrganizationBL organizationBL = (OrganizationBL) WebApplicationSupport.getBean("organizationBL");
			List<Organization> organizationList = organizationBL.searchOrganization(new OrganizationSearchCondImpl());
			
			for (Organization org: organizationList) {
				orgValueMap.put(org.getOrgsyscoding(),org.getOrgname());
			}
			init = true;
			log.debug("＝＝＝＝＝＝系统参数初始化结束＝＝＝＝＝＝");
		}
	}

	/**
	 * <p>
	 * Description: 获取参数信息
	 * </p>
	 * 
	 * @param key
	 * @return String
	 * @update liupeng@deliverik.com
	 */
	public static String getConfigInfo(String key) {
		if (!init) {
			init();
		}
		if(IGLOMCONSTANTS.ST_ORGSYSCODING.equals(key)){
			return IGLOMCONSTANTS.ST_ORGNAME;
		}else{
			if (orgValueMap != null && !orgValueMap.isEmpty()) {
				return (String) orgValueMap.get(key);
			}
		}
		
		
		return null;
	}

}
