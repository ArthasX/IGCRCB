package com.deliverik.infogovernor.soc.cim.form;

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
 * ��Ա������Ϣ��ϸ����FORM
 * 
 */
public class IGCIM1404Form extends BaseForm implements SOC0129SearchCond{

	private static final long serialVersionUID = 1L;

	/** ��Ա����ֵ����ֽ��� */
	private static final int MAX_BYTE = 2000;

	/** ��ԱID */
	protected String eiid;
	
	/** �ʲ�ģ��ID */
	protected String[] eid;

	/** ��Ա˵�� */
	protected String eidesc;
	
	/** ��Ա״̬ */
	protected String eistatus;
	
	/** ��Ա����ID */
	protected String[] ciid;
	
	/** �ʲ�����ID */
	protected String[] cid;

	/** �ʲ����ñ�� */
	protected String[] clabel;

	/** ��Ա����ֵ */
	protected String[] civalue;
	
	/** ɾ��������ʶ */
	protected String[] delfile;
	
	/** ��Ա���ø��� */
	protected String[] ciattach;
	
	/** ģ�Ͳ���� */
	protected String[] esyscoding;

	/** ��Ա�汾 */
	protected int eiversion;
	
	/** ����Ǩ�Ʊ�ʶ */
	protected String route = "0";
	
	/** ��Ա���ø������� */
	protected Map<Integer, FormFile> fileMap = new HashMap<Integer, FormFile>();
	
	/** ȡֵ��Χ�������� */
	protected Map<Integer, List<LabelValueBean>> selectedListMap = new HashMap<Integer, List<LabelValueBean>>();
	
	/** ��Ա������������ */
	protected String eiorgname;
	
	/** ��Ա������������ */
	protected String eiorgsyscoding;
	
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
	protected Map<Integer, String> cldVersionMap;
	
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
	 * ��ԱIDȡ��
	 * @return ��ԱID
	 */
	public String getEiid() {
		return eiid;
	}


	/**
	 * ��ԱID�趨
	 *
	 * @param eiid ��ԱID
	 */
	public void setEiid(String eiid) {
		this.eiid = eiid;
	}


	/**
	 * ��Ա˵��ȡ��
	 * @return ��Ա˵��
	 */
	public String getEidesc() {
		return eidesc;
	}


	/**
	 * ��Ա˵���趨
	 *
	 * @param eidesc ��Ա˵��
	 */
	public void setEidesc(String eidesc) {
		this.eidesc = eidesc;
	}


	/**
	 * ��Ա״̬ȡ��
	 * @return ��Ա״̬
	 */
	public String getEistatus() {
		return eistatus;
	}


	/**
	 * ��Ա״̬�趨
	 *
	 * @param eistatus ��Ա״̬
	 */
	public void setEistatus(String eistatus) {
		this.eistatus = eistatus;
	}


	/**
	 * ��Ա����IDȡ��
	 * @return ��Ա����ID
	 */
	public String[] getCiid() {
		return ciid;
	}


	/**
	 * ��Ա����ID�趨
	 *
	 * @param ciid ��Ա����ID
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
	 * ��Ա����ֵȡ��
	 * @return ��Ա����ֵ
	 */
	public String[] getCivalue() {
		return civalue;
	}


	/**
	 * ��Ա����ֵ�趨
	 *
	 * @param civalue ��Ա����ֵ
	 */
	public void setCivalue(String[] civalue) {
		this.civalue = civalue;
	}


	/**
	 * ��Ա�汾ȡ��
	 * @return ��Ա�汾
	 */
	public int getEiversion() {
		return eiversion;
	}


	/**
	 * ��Ա�汾�趨
	 *
	 * @param eiversion ��Ա�汾
	 */
	public void setEiversion(int eiversion) {
		this.eiversion = eiversion;
	}


	/**
	 * ��ԱIDȡ��
	 * @return ��ԱID
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
	 * ��Ա���ø�������ȡ��
	 * @return ��Ա���ø�������
	 */
	public FormFile getAttachFile(int index) {
		return (FormFile) fileMap.get( new Integer( index ) );
	}


	/**
	 * ��Ա���ø�������
	 *
	 * @param index ��Ա���ø�����������
	 * @param file ��Ա���ø�������
	 */
	public void setAttachFile(int index, FormFile file) {
		fileMap.put( new Integer( index ), file );
	}


	/**
	 * ��Ա���ø���ȡ��
	 * @return ��Ա���ø���
	 */
	public String[] getCiattach() {
		return ciattach;
	}


	/**
	 * ��Ա���ø���
	 *
	 * @param ciattach ��Ա���ø���
	 */
	public void setCiattach(String[] ciattach) {
		this.ciattach = ciattach;
	}


	/**
	 * ��Ա���ñ�����ֵ���
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
		request.getSession().setAttribute("IGASM1504Form", this);
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


	public Map<Integer, String> getCldVersionMap() {
		return cldVersionMap;
	}


	public void setCldVersionMap(Map<Integer, String> cldVersionMap2) {
		this.cldVersionMap = cldVersionMap2;
	}


	public String getEkey2() {
		// TODO Auto-generated method stub
		return null;
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
