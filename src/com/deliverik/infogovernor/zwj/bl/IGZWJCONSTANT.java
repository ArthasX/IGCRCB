/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.zwj.bl;

import java.util.List;

import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.user.bl.task.OrganizationBL;
import com.deliverik.framework.user.model.Organization;
import com.deliverik.framework.user.model.condition.OrganizationSearchCondImpl;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �侯��Ժ������س���
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
