package com.deliverik.infogovernor.adapter;

import netscape.ldap.LDAPConnection;
import netscape.ldap.LDAPException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.utility.CodeListUtils;

public class LdapAdapter {
	
	private static Log log = LogFactory.getLog(LdapAdapter.class);
	
	private static String LDAP_URL = null;
	private static String LDAP_Node = null;
	private static String LDAP_UID = null;
	
	public static LdapAdapter getInstance() {
		return new LdapAdapter();
	}

	protected LdapAdapter() {
	}

	public boolean ldapAuthorize(String userId,String password) {

		boolean flag = false;
		CodeListUtils ctlBL = (CodeListUtils) WebApplicationSupport.getBean("codeListUtils");
		try{
			LDAPConnection lconn = null;
			lconn = new LDAPConnection();
			if(LDAP_URL == null || "".equals(LDAP_URL)){
				LDAP_URL = ctlBL.getCodeValue(CodeDefinition.LDAP, "", "", CodeDefinition.LDAP_URL);
			}
			
			lconn.connect(LDAP_URL,389);
			
			if(LDAP_UID == null || "".equals(LDAP_UID)){
				LDAP_UID = ctlBL.getCodeValue(CodeDefinition.LDAP, "", "", CodeDefinition.LDAP_UID);
			}
			if(LDAP_Node == null || "".equals(LDAP_Node)){
				LDAP_Node = ctlBL.getCodeValue(CodeDefinition.LDAP, "", "", CodeDefinition.LDAP_NODE);
			}
			
			String dn = LDAP_UID + "=" + userId + "," + LDAP_Node;
			lconn.authenticate(dn, password);
			flag = true;
			log.debug("LDAPµÇÂ¼³É¹¦¡£");
		}catch(LDAPException e){
			return flag;
		}
		return flag;
	}
}