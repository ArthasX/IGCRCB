package com.deliverik.infogovernor.asset.form;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.Globals;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.upload.FormFile;

import com.deliverik.framework.asset.model.condition.IG002SearchCond;
import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.utility.IGStringUtils;

/**
 * ����������Ϣ��ϸ����FORM
 * 
 */
public class IGASM0704Form extends BaseForm implements IG002SearchCond{

	private static final long serialVersionUID = 1L;

	/** ��������ֵ����ֽ��� */
	private static final int MAX_BYTE = 2000;

	/** ����ID */
	protected Integer eiid;
	
	/** �ʲ�ģ��ID */
	protected String eid;

	/** ����˵�� */
	protected String eidesc;
	
	/** ����״̬ */
	protected String eistatus;
	
	/** ��������ID */
	protected String[] ciid;
	
	/** �ʲ�����ID */
	protected String[] cid;

	/** �ʲ����ñ�� */
	protected String[] clabel;

	/** ��������ֵ */
	protected String[] civalue;
	
	/** �������ø��� */
	protected String[] ciattach;

	/** �����汾 */
	protected int eiversion;
	
	/** ����Ǩ�Ʊ�ʶ */
	protected String route = "0";
	
	/** �������ø������� */
	protected Map<Integer, FormFile> fileMap = new HashMap<Integer, FormFile>();
	
	/** ģ�Ͳ���� */
	protected String esyscoding_q;
	
	/**
	 * ����IDȡ��
	 * @return ����ID
	 */
	public Integer getEiid() {
		return eiid;
	}


	/**
	 * ����ID�趨
	 *
	 * @param eiid ����ID
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}


	/**
	 * ����˵��ȡ��
	 * @return ����˵��
	 */
	public String getEidesc() {
		return eidesc;
	}


	/**
	 * ����˵���趨
	 *
	 * @param eidesc ����˵��
	 */
	public void setEidesc(String eidesc) {
		this.eidesc = eidesc;
	}


	/**
	 * ����״̬ȡ��
	 * @return ����״̬
	 */
	public String getEistatus() {
		return eistatus;
	}


	/**
	 * ����״̬�趨
	 *
	 * @param eistatus ����״̬
	 */
	public void setEistatus(String eistatus) {
		this.eistatus = eistatus;
	}


	/**
	 * ��������IDȡ��
	 * @return ��������ID
	 */
	public String[] getCiid() {
		return ciid;
	}


	/**
	 * ��������ID�趨
	 *
	 * @param ciid ��������ID
	 */
	public void setCiid(String[] ciid) {
		this.ciid = ciid;
	}


	/**
	 * �ʲ����ñ��ȡ��
	 * @return �ʲ����ñ��
	 */
	public String[] getClabel() {
		return clabel;
	}


	/**
	 * �ʲ����ñ���趨
	 *
	 * @param clabel �ʲ����ñ��
	 */
	public void setClabel(String[] clabel) {
		this.clabel = clabel;
	}


	/**
	 * ��������ֵȡ��
	 * @return ��������ֵ
	 */
	public String[] getCivalue() {
		return civalue;
	}


	/**
	 * ��������ֵ�趨
	 *
	 * @param civalue ��������ֵ
	 */
	public void setCivalue(String[] civalue) {
		this.civalue = civalue;
	}


	/**
	 * �����汾ȡ��
	 * @return �����汾
	 */
	public int getEiversion() {
		return eiversion;
	}


	/**
	 * �����汾�趨
	 *
	 * @param eiversion �����汾
	 */
	public void setEiversion(int eiversion) {
		this.eiversion = eiversion;
	}


	/**
	 * ����IDȡ��
	 * @return ����ID
	 */
	public String getEid() {
		return eid;
	}


	/**
	 * �ʲ�ģ��ID�趨
	 *
	 * @param eid �ʲ�ģ��ID
	 */
	public void setEid(String eid) {
		this.eid = eid;
	}


	/**
	 * �ʲ�����IDȡ��
	 * @return �ʲ�����ID
	 */
	public String[] getCid() {
		return cid;
	}


	/**
	 * �ʲ�����ID�趨
	 *
	 * @param cid �ʲ�����ID
	 */
	public void setCid(String[] cid) {
		this.cid = cid;
	}


	/**
	 * ����Ǩ�Ʊ�ʶȡ��
	 * @return ����Ǩ�Ʊ�ʶ
	 */
	public String getRoute() {
		return route;
	}


	/**
	 * ����Ǩ�Ʊ�ʶ�趨
	 *
	 * @param route ����Ǩ�Ʊ�ʶ
	 */
	public void setRoute(String route) {
		this.route = route;
	}
	
	/**
	 * �������ø�������ȡ��
	 * @return �������ø�������
	 */
	public FormFile getAttachFile(int index) {
		return (FormFile) fileMap.get( new Integer( index ) );
	}


	/**
	 * �������ø�������
	 *
	 * @param index �������ø�����������
	 * @param file �������ø�������
	 */
	public void setAttachFile(int index, FormFile file) {
		fileMap.put( new Integer( index ), file );
	}


	/**
	 * �������ø���ȡ��
	 * @return �������ø���
	 */
	public String[] getCiattach() {
		return ciattach;
	}


	/**
	 * �������ø���
	 *
	 * @param ciattach �������ø���
	 */
	public void setCiattach(String[] ciattach) {
		this.ciattach = ciattach;
	}


	/**
	 * �������ñ�����ֵ���
	 *
	 * @param mapping
	 * @param request
	 * @return ��������Ϣ
	 */
	public ActionErrors validate(ActionMapping mapping,HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();
		
		errors = super.validate(mapping, request);
		if ( civalue != null ) {
			for ( int i=0;i<civalue.length;i++ ) {
				if (!IGStringUtils.isValidBytes(civalue[i],MAX_BYTE)) {
					errors.add(Globals.ERROR_KEY, new ActionMessage("errors.maxbytes","(��ţ�" +clabel[i]+")����������", 
    					String.valueOf(MAX_BYTE / 3), String.valueOf(MAX_BYTE)));
				}
			}
		}
		request.getSession().setAttribute("IGASM0704Form", this);
		return errors;
	}


	public String getCname() {
		// TODO Auto-generated method stub
		return null;
	}


	public String getEsyscoding_q() {
		return esyscoding_q;
	}


	public void setEsyscoding_q(String esyscoding_q) {
		this.esyscoding_q = esyscoding_q;
	}


	public String getClabel_q() {
		// TODO Auto-generated method stub
		return null;
	}


	public List<Integer> getEiid_list() {
		// TODO Auto-generated method stub
		return null;
	}


	public String getSreilabel_q() {
		// TODO Auto-generated method stub
		return null;
	}


	public String getSrname_q() {
		// TODO Auto-generated method stub
		return null;
	}


	public String getCiversion() {
		// TODO Auto-generated method stub
		return null;
	}


	public String getEid_q() {
		// TODO Auto-generated method stub
		return null;
	}
}
