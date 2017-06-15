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
import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.asset.model.condition.IG002SearchCond;
import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.utility.IGStringUtils;

/**
 * �ʲ���������Ϣ��ϸ����FORM
 * 
 */
public class IGASM0204Form extends BaseForm implements IG002SearchCond{

	private static final long serialVersionUID = 1L;

	/** �ʲ�������ֵ����ֽ��� */
	private static final int MAX_BYTE = 2000;

	/** �ʲ���ID */
	protected Integer eiid;
	
	/** �ʲ�ģ��ID */
	protected String[] eid;

	/** �ʲ���˵�� */
	protected String eidesc;
	
	/** �ʲ���״̬ */
	protected String eistatus;
	
	/** �ʲ�������ID */
	protected String[] ciid;
	
	/** �ʲ�����ID */
	protected String[] cid;

	/** �ʲ����ñ�� */
	protected String[] clabel;

	/** �ʲ�������ֵ */
	protected String[] civalue;
	
	/** �ʲ������ø��� */
	protected String[] ciattach;

	/** �ʲ���汾 */
	protected int eiversion;
	
	/** ����Ǩ�Ʊ�ʶ */
	protected String route = "0";
	
	/** ģ�Ͳ���� */
	protected String[] esyscoding;
	
	/** �ʲ������ø������� */
	protected Map<Integer, FormFile> fileMap = new HashMap<Integer, FormFile>();
	
	/** ȡֵ��Χ�������� */
	protected Map<Integer, List<LabelValueBean>> selectedListMap = new HashMap<Integer, List<LabelValueBean>>();
	
	/** �ʲ�����������*/
	public String eiorgsyscoding;
	
	/** ģ�Ͳ���� */
	protected String esyscoding_q;
	
	public String getEiorgsyscoding() {
		return eiorgsyscoding;
	}


	public void setEiorgsyscoding(String eiorgsyscoding) {
		this.eiorgsyscoding = eiorgsyscoding;
	}


	/**
	 * �ʲ���IDȡ��
	 * @return �ʲ���ID
	 */
	public Integer getEiid() {
		return eiid;
	}


	/**
	 * �ʲ���ID�趨
	 *
	 * @param eiid �ʲ���ID
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}


	/**
	 * �ʲ���˵��ȡ��
	 * @return �ʲ���˵��
	 */
	public String getEidesc() {
		return eidesc;
	}


	/**
	 * �ʲ���˵���趨
	 *
	 * @param eidesc �ʲ���˵��
	 */
	public void setEidesc(String eidesc) {
		this.eidesc = eidesc;
	}


	/**
	 * �ʲ���״̬ȡ��
	 * @return �ʲ���״̬
	 */
	public String getEistatus() {
		return eistatus;
	}


	/**
	 * �ʲ���״̬�趨
	 *
	 * @param eistatus �ʲ���״̬
	 */
	public void setEistatus(String eistatus) {
		this.eistatus = eistatus;
	}


	/**
	 * �ʲ�������IDȡ��
	 * @return �ʲ�������ID
	 */
	public String[] getCiid() {
		return ciid;
	}


	/**
	 * �ʲ�������ID�趨
	 *
	 * @param ciid �ʲ�������ID
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
	 * �ʲ�������ֵȡ��
	 * @return �ʲ�������ֵ
	 */
	public String[] getCivalue() {
		return civalue;
	}


	/**
	 * �ʲ�������ֵ�趨
	 *
	 * @param civalue �ʲ�������ֵ
	 */
	public void setCivalue(String[] civalue) {
		this.civalue = civalue;
	}


	/**
	 * �ʲ���汾ȡ��
	 * @return �ʲ���汾
	 */
	public int getEiversion() {
		return eiversion;
	}


	/**
	 * �ʲ���汾�趨
	 *
	 * @param eiversion �ʲ���汾
	 */
	public void setEiversion(int eiversion) {
		this.eiversion = eiversion;
	}


	/**
	 * �ʲ���IDȡ��
	 * @return �ʲ���ID
	 */
	public String[] getEid() {
		return eid;
	}


	/**
	 * �ʲ�ģ��ID�趨
	 *
	 * @param eid �ʲ�ģ��ID
	 */
	public void setEid(String[] eid) {
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
	 * �ʲ����ø���ȡ��
	 * @return �ʲ����ø���
	 */
	public String[] getCiattach() {
		return ciattach;
	}


	/**
	 * �ʲ����ø���
	 *
	 * @param ciattach �ʲ����ø���
	 */
	public void setCiattach(String[] ciattach) {
		this.ciattach = ciattach;
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
	 * �ʲ������ø�������ȡ��
	 * @return �ʲ������ø�������
	 */
	public FormFile getAttachFile(int index) {
		return (FormFile) fileMap.get( new Integer( index ) );
	}


	/**
	 * �ʲ������ø�������
	 *
	 * @param index �ʲ������ø�����������
	 * @param file �ʲ������ø�������
	 */
	public void setAttachFile(int index, FormFile file) {
		fileMap.put( new Integer( index ), file );
	}


	/**
	 * �ʲ������ñ�����ֵ���
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
		
		request.getSession().setAttribute("IGASM0204Form", this);
		return errors;
	}
	
	/**
	 * ȡֵ��Χ��������ȡ��
	 * @return ȡֵ��Χ��������
	 */
	public List<LabelValueBean> getSelectedListMap(int index) {
		return (List<LabelValueBean>) selectedListMap.get( new Integer( index ) );
	}

	/**
	 * ȡֵ��Χ���������趨
	 *
	 * @param selectedList ȡֵ��Χ��������
	 */
	public void setSelectedListMap(int index,List<LabelValueBean> selectedList) {
		selectedListMap.put(new Integer(index), selectedList);
	}

	/**
	 * ȡֵ��Χ��������ȡ��
	 * @return ȡֵ��Χ��������
	 */
	public Map<Integer, List<LabelValueBean>> getSelectedListMap() {
		return selectedListMap;
	}
	
	/**
	 * ģ�Ͳ����ȡ��
	 * @return ģ�Ͳ����
	 */
	public String[] getEsyscoding() {
		return esyscoding;
	}

	/**
	 * ģ�Ͳ�����趨
	 *
	 * @param esyscoding ģ�Ͳ����
	 */
	public void setEsyscoding(String[] esyscoding) {
		this.esyscoding = esyscoding;
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
		return null;
	}


	public String getCiversion() {
		return null;
	}


	public String getEid_q() {
		return null;
	}
}
