/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.ram.bl;

import java.util.List;

import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.user.bl.task.OrganizationBL;
import com.deliverik.framework.user.model.Organization;
import com.deliverik.framework.user.model.condition.OrganizationSearchCondImpl;

/**
 * 风险审计常量类
 * 
 * @author liupeng@deliverik.com
 */
public final class IGRAMCONSTANTS {
	
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
    
	//顶级机构id
	public static final Integer ramPtid = 17;
}
