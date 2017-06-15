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

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.soc.asset.model.condition.SOC0129SearchCond;
import com.deliverik.framework.utility.IGStringUtils;

/**
 * ���յ�������Ϣ��ϸ����FORM
 * 
 */
public class IGASM2704Form extends BaseForm implements SOC0129SearchCond{

	private static final long serialVersionUID = 1L;

	/** ���յ�����ֵ����ֽ��� */
	private static final int MAX_BYTE = 2000;

	/** ���յ�ID */
	protected String eiid;
	
	/** ���յ�˵�� */
	protected String eidesc;
	
	/** ���յ�״̬ */
	protected String eistatus;
	
	/** ���յ�����ID */
	protected String[] ciid;
	
	/** �ʲ�����ID */
	protected String[] cid;

	/** �ʲ����ñ�� */
	protected String[] clabel;

	/** ���յ�����ֵ */
	protected String[] civalue;
	
	/** ɾ��������ʶ */
	protected String[] delfile;
	
	/** ���յ����ø��� */
	protected String[] ciattach;
	
	/** �ʲ�ģ��ID */
	protected String[] eid;
	
	/** ģ�Ͳ���� */
	protected String[] esyscoding;

	/** ���յ�汾 */
	protected int eiversion;
	
	/** ����Ǩ�Ʊ�ʶ */
	protected String route = "0";
	
	/** ���յ����ø������� */
	protected Map<Integer, FormFile> fileMap = new HashMap<Integer, FormFile>();
	
	/** ȡֵ��Χ�������� */
	protected Map<Integer, List<LabelValueBean>> selectedListMap = new HashMap<Integer, List<LabelValueBean>>();
	/** ���յ������������� */
	protected String eiorgsyscoding;
	
	/** ���յ������������� */
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
	/**ѡ��汾*/
	protected String selecteiversion;
	
	/**�û�ID*/
	protected String hiddenmguserid;
	
	/**��ѯ��ʶ*/
	protected String looksign;
	
	protected int checkersion;
	


	/**
	 * checkersionȡ��
	 * @return checkersion checkersion
	 */
	public int getCheckersion() {
		return checkersion;
	}


	/**
	 * checkersion�趨
	 * @param checkersion checkersion
	 */
	public void setCheckersion(int checkersion) {
		this.checkersion = checkersion;
	}


	/**
	 * ��ѯ��ʶȡ��
	 * @return looksign ��ѯ��ʶ
	 */
	public String getLooksign() {
		return looksign;
	}


	/**
	 * ��ѯ��ʶ�趨
	 * @param looksign ��ѯ��ʶ
	 */
	public void setLooksign(String looksign) {
		this.looksign = looksign;
	}


	/**
	 * ѡ��汾ȡ��
	 * @return selecteiversion ѡ��汾
	 */
	public String getSelecteiversion() {
		return selecteiversion;
	}


	/**
	 * ѡ��汾�趨
	 * @param selecteiversion ѡ��汾
	 */
	public void setSelecteiversion(String selecteiversion) {
		this.selecteiversion = selecteiversion;
	}


	/** ���ʲ��汾���� */
	protected Map<String, String> cldVersionMap;
	
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
	 * ���յ�IDȡ��
	 * @return ���յ�ID
	 */
	public String getEiid() {
		return eiid;
	}


	/**
	 * ���յ�ID�趨
	 *
	 * @param eiid ���յ�ID
	 */
	public void setEiid(String eiid) {
		this.eiid = eiid;
	}


	/**
	 * ���յ�˵��ȡ��
	 * @return ���յ�˵��
	 */
	public String getEidesc() {
		return eidesc;
	}


	/**
	 * ���յ�˵���趨
	 *
	 * @param eidesc ���յ�˵��
	 */
	public void setEidesc(String eidesc) {
		this.eidesc = eidesc;
	}


	/**
	 * ���յ�״̬ȡ��
	 * @return ���յ�״̬
	 */
	public String getEistatus() {
		return eistatus;
	}


	/**
	 * ���յ�״̬�趨
	 *
	 * @param eistatus ���յ�״̬
	 */
	public void setEistatus(String eistatus) {
		this.eistatus = eistatus;
	}


	/**
	 * ���յ�����IDȡ��
	 * @return ���յ�����ID
	 */
	public String[] getCiid() {
		return ciid;
	}


	/**
	 * ���յ�����ID�趨
	 *
	 * @param ciid ���յ�����ID
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
	 * ���յ�����ֵȡ��
	 * @return ���յ�����ֵ
	 */
	public String[] getCivalue() {
		return civalue;
	}


	/**
	 * ���յ�����ֵ�趨
	 *
	 * @param civalue ���յ�����ֵ
	 */
	public void setCivalue(String[] civalue) {
		this.civalue = civalue;
	}


	/**
	 * ���յ�汾ȡ��
	 * @return ���յ�汾
	 */
	public int getEiversion() {
		return eiversion;
	}


	/**
	 * ���յ�汾�趨
	 *
	 * @param eiversion ���յ�汾
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
	 * ���յ����ø�������ȡ��
	 * @return ���յ����ø�������
	 */
	public FormFile getAttachFile(int index) {
		return (FormFile) fileMap.get( new Integer( index ) );
	}


	/**
	 * ���յ����ø�������
	 *
	 * @param index ���յ����ø�����������
	 * @param file ���յ����ø�������
	 */
	public void setAttachFile(int index, FormFile file) {
		fileMap.put( new Integer( index ), file );
	}


	/**
	 * ���յ����ø���ȡ��
	 * @return ���յ����ø���
	 */
	public String[] getCiattach() {
		return ciattach;
	}


	/**
	 * ���յ����ø���
	 *
	 * @param ciattach ���յ����ø���
	 */
	public void setCiattach(String[] ciattach) {
		this.ciattach = ciattach;
	}


	/**
	 * ���յ����ñ�����ֵ���
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
		request.getSession().setAttribute("IGASM2704Form", this);
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
	 * �û�IDȡ��
	 * @return hiddenmguserid �û�ID
	 */
	public String getHiddenmguserid() {
		return hiddenmguserid;
	}


	/**
	 * �û�ID�趨
	 * @param hiddenmguserid �û�ID
	 */
	public void setHiddenmguserid(String hiddenmguserid) {
		this.hiddenmguserid = hiddenmguserid;
	}


	public String getId() {
		// TODO Auto-generated method stub
		return null;
	}

}
