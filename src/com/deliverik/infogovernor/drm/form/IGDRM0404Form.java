package com.deliverik.infogovernor.drm.form;

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

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.soc.asset.model.condition.SOC0129SearchCond;
import com.deliverik.framework.utility.IGStringUtils;

/**
 * �ĵ�������Ϣ��ϸ����FORM
 * 
 */
public class IGDRM0404Form extends BaseForm implements SOC0129SearchCond{

	private static final long serialVersionUID = 1L;

	/** �ĵ�����ֵ����ֽ��� */
	private static final int MAX_BYTE = 2000;

	/** �ĵ�ID */
	protected String eiid;
	
	/** �ĵ�˵�� */
	protected String eidesc;
	
	/**
	 * �ĵ����
	 */
	protected String eilabel;
	
	/** �ĵ�״̬ */
	protected String eistatus;
	
	/** �ĵ�����ID */
	protected String[] ciid;
	
	/** �ʲ�����ID */
	protected String[] cid;

	/** �ʲ����ñ�� */
	protected String[] clabel;

	/** �ĵ�����ֵ */
	protected String[] civalue;
	
	/** ɾ��������ʶ */
	protected String[] delfile;
	
	/** �ĵ����ø��� */
	protected String[] ciattach;
	
	/** �ʲ�ģ��ID */
	protected String[] eid;
	
	/** ģ�Ͳ���� */
	protected String[] esyscoding;

	/** �ĵ��汾 */
	protected int eiversion;
	
	/** ����Ǩ�Ʊ�ʶ */
	protected String route = "0";
	
	/** �ĵ����ø������� */
	protected Map<Integer, FormFile> fileMap = new HashMap<Integer, FormFile>();
	
	/** ȡֵ��Χ�������� */
	protected Map<Integer, List<LabelValueBean>> selectedListMap = new HashMap<Integer, List<LabelValueBean>>();
	/** �ĵ������������� */
	protected String eiorgsyscoding;
	
	/** �ĵ������������� */
	protected String eiorgname;
	
	/** ģ�Ͳ���� */
	protected String esyscoding_q;
	
	/** �ʲ�ģ����������ֵ */
	protected String[] entityItemCivalue;
	
	/** �������Ա�ʶ */
	protected String[] civalue_bak;
	
	/** �汾�Ƿ�������ʶ */
	protected String ident;
	
	protected String[] isUpgrade;
	
	/** ���ʲ��汾���� */
	protected Map<String, String> cldVersionMap;
	
	/**�ʲ�����*/
	protected String ename;
	
	/**�ʲ����*/
	protected String einame;
	
	/**��������*/
	protected String eiinsdate;
	
	/**
	 * ename�Ļ�ȡ
	 * @return the ename
	 */
	public String getEname() {
		return ename;
	}


	/**
	 * ename���趨
	 * @param ename 
	 */
	public void setEname(String ename) {
		this.ename = ename;
	}


	/**
	 * einame�Ļ�ȡ
	 * @return the einame
	 */
	public String getEiname() {
		return einame;
	}


	/**
	 * einame���趨
	 * @param einame 
	 */
	public void setEiname(String einame) {
		this.einame = einame;
	}


	/**
	 * eiinsdate�Ļ�ȡ
	 * @return the eiinsdate
	 */
	public String getEiinsdate() {
		return eiinsdate;
	}


	/**
	 * eiinsdate���趨
	 * @param eiinsdate 
	 */
	public void setEiinsdate(String eiinsdate) {
		this.eiinsdate = eiinsdate;
	}


	public String[] getIsUpgrade() {
		return isUpgrade;
	}


	public void setIsUpgrade(String[] isUpgrade) {
		this.isUpgrade = isUpgrade;
	}
	
	public String getEiorgsyscoding() {
		return eiorgsyscoding;
	}


	public void setEiorgsyscoding(String eiorgsyscoding) {
		this.eiorgsyscoding = eiorgsyscoding;
	}


	public String getEiorgname() {
		return eiorgname;
	}


	public void setEiorgname(String eiorgname) {
		this.eiorgname = eiorgname;
	}
	/**
	 * �ĵ�IDȡ��
	 * @return �ĵ�ID
	 */
	public String getEiid() {
		return eiid;
	}


	/**
	 * �ĵ�ID�趨
	 *
	 * @param eiid �ĵ�ID
	 */
	public void setEiid(String eiid) {
		this.eiid = eiid;
	}


	/**
	 * �ĵ�˵��ȡ��
	 * @return �ĵ�˵��
	 */
	public String getEidesc() {
		return eidesc;
	}


	/**
	 * �ĵ�˵���趨
	 *
	 * @param eidesc �ĵ�˵��
	 */
	public void setEidesc(String eidesc) {
		this.eidesc = eidesc;
	}


	/**
	 * �ĵ�״̬ȡ��
	 * @return �ĵ�״̬
	 */
	public String getEistatus() {
		return eistatus;
	}


	/**
	 * �ĵ�״̬�趨
	 *
	 * @param eistatus �ĵ�״̬
	 */
	public void setEistatus(String eistatus) {
		this.eistatus = eistatus;
	}


	/**
	 * �ĵ�����IDȡ��
	 * @return �ĵ�����ID
	 */
	public String[] getCiid() {
		return ciid;
	}


	/**
	 * �ĵ�����ID�趨
	 *
	 * @param ciid �ĵ�����ID
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
	 * �ĵ�����ֵȡ��
	 * @return �ĵ�����ֵ
	 */
	public String[] getCivalue() {
		return civalue;
	}


	/**
	 * �ĵ�����ֵ�趨
	 *
	 * @param civalue �ĵ�����ֵ
	 */
	public void setCivalue(String[] civalue) {
		this.civalue = civalue;
	}


	/**
	 * �ĵ��汾ȡ��
	 * @return �ĵ��汾
	 */
	public int getEiversion() {
		return eiversion;
	}


	/**
	 * �ĵ��汾�趨
	 *
	 * @param eiversion �ĵ��汾
	 */
	public void setEiversion(int eiversion) {
		this.eiversion = eiversion;
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
	 * �ĵ����ø�������ȡ��
	 * @return �ĵ����ø�������
	 */
	public FormFile getAttachFile(int index) {
		return fileMap.get( new Integer( index ) );
	}


	/**
	 * �ĵ����ø�������
	 *
	 * @param index �ĵ����ø�����������
	 * @param file �ĵ����ø�������
	 */
	public void setAttachFile(int index, FormFile file) {
		fileMap.put( new Integer( index ), file );
	}


	/**
	 * �ĵ����ø���ȡ��
	 * @return �ĵ����ø���
	 */
	public String[] getCiattach() {
		return ciattach;
	}


	/**
	 * �ĵ����ø���
	 *
	 * @param ciattach �ĵ����ø���
	 */
	public void setCiattach(String[] ciattach) {
		this.ciattach = ciattach;
	}


	/**
	 * �ĵ����ñ�����ֵ���
	 *
	 * @param mapping
	 * @param request
	 * @return ��������Ϣ
	 */
	@Override
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
		request.getSession().setAttribute("IGASM0504Form", this);
		return errors;
	}
	
	/**
	 * ȡֵ��Χ��������ȡ��
	 * @return ȡֵ��Χ��������
	 */
	public List<LabelValueBean> getSelectedListMap(int index) {
		return selectedListMap.get( new Integer( index ) );
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
	/**
	 * �ʲ�ģ����������ֵȡ��
	 * @return �ʲ�ģ����������ֵ
	 */
	public String[] getEntityItemCivalue() {
		return entityItemCivalue;
	}

	/**
	 * �ʲ�ģ����������ֵ�趨
	 *
	 * @param entityItemCivalue �ʲ�ģ����������ֵ
	 */
	public void setEntityItemCivalue(String[] entityItemCivalue) {
		this.entityItemCivalue = entityItemCivalue;
	}
	
	/**
	 * �豸IDȡ��
	 * @return �豸ID
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
	
	/**
	 * �������Ա�ʶȡ��
	 * @return �������Ա�ʶ
	 */
	public String[] getCivalue_bak() {
		return civalue_bak;
	}

	/**
	 * �������Ա�ʶ�趨
	 *
	 * @param civalue_bak �������Ա�ʶ
	 */
	public void setCivalue_bak(String[] civalue_bak) {
		this.civalue_bak = civalue_bak;
	}

	/**
	 * �汾������ʶȡ��
	 * @return �汾������ʶ
	 */
	public String getIdent() {
		return ident;
	}

	/**
	 * �汾������ʶ�趨
	 * @param ident �汾������ʶ
	 */
	public void setIdent(String ident) {
		this.ident = ident;
	}

	public String[] getDelfile() {
		return delfile;
	}


	public void setDelfile(String[] delfile) {
		this.delfile = delfile;
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


	public Map<String, String> getCldVersionMap() {
		return cldVersionMap;
	}


	public void setCldVersionMap(Map<String, String> cldVersionMap) {
		this.cldVersionMap = cldVersionMap;
	}


	public String getEkey2() {
		// TODO Auto-generated method stub
		return null;
	}


	/**
	 * eilabel   ȡ��
	 * @return eilabel eilabel
	 */
	public String getEilabel() {
		return eilabel;
	}


	/**
	 * eilabel   �趨
	 * @param eilabel eilabel
	 */
	public void setEilabel(String eilabel) {
		this.eilabel = eilabel;
	}


	/* (non-Javadoc)
	 * @see com.deliverik.framework.soc.asset.model.condition.SOC0129SearchCond#getCheckersion()
	 */
	public int getCheckersion() {
		// TODO Auto-generated method stub
		return 0;
	}


	public String getId() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
