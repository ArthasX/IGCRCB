/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.drm.form;

import com.deliverik.framework.base.BaseForm;
/***
 * ��ɫ��֯�ܹ���ϵFORM
 */
public class IGDRM1002Form extends BaseForm{
	private static final long serialVersionUID = 1L;
	
	/** ����� */
	protected String syscoding;
	/** ��ɫid*/
	protected String roleid;
	
	/**��֯�ܹ���ϵ��id*/
	protected String srid;
	
	/**��ɫ��ѯname like */
	protected String rolename;
	
	/**ccid*/
	protected String ccid;

	/**cid*/
	protected String cid;
	
	/**clevel*/
	protected String clevel;
	
    public String getCcid() {
        return ccid;
    }

    public void setCcid(String ccid) {
        this.ccid = ccid;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getClevel() {
        return clevel;
    }

    public void setClevel(String clevel) {
        this.clevel = clevel;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public String getSrid() {
        return srid;
    }

    public void setSrid(String srid) {
        this.srid = srid;
    }

    public String getSyscoding() {
        return syscoding;
    }

    public String getRoleid() {
        return roleid;
    }

    public void setRoleid(String roleid) {
        this.roleid = roleid;
    }

    public void setSyscoding(String syscoding) {
        this.syscoding = syscoding;
    }
	
}