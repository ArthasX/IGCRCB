/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.drm.model.condition;

import java.util.List;

/**
  * ����: ��֯�ܹ��������������ʵ��
  * ��������: ��֯�ܹ��������������ʵ��
  * ������¼: 2015/03/09
  * �޸ļ�¼: 
  */
public class StructureRoleSearchCondImpl implements
		StructureRoleSearchCond {
    /** ��֯�ܹ������ */
    protected String syscoding;

    /** ��֯�ܹ�cid */
    protected String cid;

    /** ��֯�ܹ����� */
    protected String sname;

    /** ��ɫid */
    protected Integer roleid;

    /** ��ɫ���� */
    protected String rolename;

    /** ��֯�ܹ����� YӦ����֯�ܹ���R�ճ���֯�ܹ� */
    protected String srtype;
    //��ȫƥ��
    protected String syscoding_q;
    
    protected List<Integer> roleid_in;

    public List<Integer> getRoleid_in() {
		return roleid_in;
	}

	public void setRoleid_in(List<Integer> roleid_in) {
		this.roleid_in = roleid_in;
	}

	public String getSyscoding_q() {
        return syscoding_q;
    }

    public void setSyscoding_q(String syscoding_q) {
        this.syscoding_q = syscoding_q;
    }

    public String getSyscoding() {
        return syscoding;
    }

    public void setSyscoding(String syscoding) {
        this.syscoding = syscoding;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public String getSrtype() {
        return srtype;
    }

    public void setSrtype(String srtype) {
        this.srtype = srtype;
    }
    
    
}