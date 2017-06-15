/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.zwj.bl;

import java.util.List;

import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.user.bl.task.OrganizationBL;
import com.deliverik.framework.user.model.Organization;
import com.deliverik.framework.user.model.condition.OrganizationSearchCondImpl;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 武警总院流程相关常亮
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGZWJCONSTANT {

	public static String ORGSYSCODING= "0001";
	static{
	    OrganizationBL organization = (OrganizationBL) WebApplicationSupport.getBean("organizationBL");
	    OrganizationSearchCondImpl condImpl  =new  OrganizationSearchCondImpl();
	    condImpl.setOrgpar(ORGSYSCODING);
	    List<Organization> organizationInfos = organization.searchOrganization(condImpl);
	    if(!organizationInfos.isEmpty()){
	        ORGSYSCODING = organizationInfos.get(0).getOrgsyscoding();
	    }
	}
}
