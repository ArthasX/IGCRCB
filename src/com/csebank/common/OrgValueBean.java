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
	/** ��¼��־ */
	private static Log log = LogFactory.getLog(OrgValueBean.class);
	
	/** ϵͳ������Ϣ */
	private static Map<String, String> orgValueMap = new HashMap<String, String>();

	/** ���������ļ���ʶ */
	private static boolean init = false;

	/**
	 * <p>
	 * Description:���캯��
	 * </p>
	 */
	private OrgValueBean() {

	}

	/**
	 * <p>
	 * Discription:��ʼ������map
	 * </p>
	 * 
	 * @update liupeng@deliverik.com
	 */
	public static void init() {
		if (!init) {
			log.debug("������������ϵͳ������ʼ����ʼ������������");
			// ȡ����λϵͳ���ò���
			
			OrganizationBL organizationBL = (OrganizationBL) WebApplicationSupport.getBean("organizationBL");
			List<Organization> organizationList = organizationBL.searchOrganization(new OrganizationSearchCondImpl());
			
			for (Organization org: organizationList) {
				orgValueMap.put(org.getOrgsyscoding(),org.getOrgname());
			}
			init = true;
			log.debug("������������ϵͳ������ʼ������������������");
		}
	}

	/**
	 * <p>
	 * Description: ��ȡ������Ϣ
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
