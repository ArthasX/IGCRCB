package com.deliverik.infogovernor.soc.mnt.form;

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
 * �豸������Ϣ��ϸ����FORM
 * 
 */
public class IGMNT0204Form extends BaseForm implements SOC0129SearchCond{

	private static final long serialVersionUID = 1L;

	/** �豸����ֵ����ֽ��� */
	private static final int MAX_BYTE = 2000;

	/** �豸ID */
	protected String eiid;
	
	/** �ʲ�ģ��ID */
	protected String[] eid;

	/** �豸˵�� */
	protected String eidesc;
	
	/** �豸״̬ */
	protected String eistatus;
	
	/** �豸����ID */
	protected String[] ciid;
	
	/** �ʲ�����ID */
	protected String[] cid;

	/** �ʲ����ñ�� */
	protected String[] clabel;

	/** �豸����ֵ */
	protected String[] civalue;
	
	/** �ʲ�ģ����������ֵ */
	protected String[] entityItemCivalue;
	
	/** �豸���ø��� */
	protected String[] ciattach;
	
	/** ģ�Ͳ���� */
	protected String[] esyscoding;

	/** �豸�汾 */
	protected int eiversion;
	
	/** ����Ǩ�Ʊ�ʶ */
	protected String route = "0";
	
	/** �豸���ø������� */
	protected Map<Integer, FormFile> fileMap = new HashMap<Integer, FormFile>();
	/** �豸���ø������� */
	protected Map<Integer, FormFile> fileMapXML = new HashMap<Integer, FormFile>();
	
	/** ȡֵ��Χ�������� */
	protected Map<Integer, List<LabelValueBean>> selectedListMap = new HashMap<Integer, List<LabelValueBean>>();
	
	/** �豸������������ */
	protected String eiorgsyscoding;
	
	/** �豸������������ */
	protected String eiorgname;
	
	/** ģ�Ͳ���� */
	protected String esyscoding_q;
	
	/** �������Ա�ʶ */
	protected String[] civalue_bak;
	
	protected String filename;
	
	/** �ʲ�С�汾*/
	protected Integer eismallversion;
	
	/** �ʲ�ģ�����0��һ���ʲ�ģ�� 1�������ʲ�ģ�ͣ� */
	protected String emodeltype;

	public String getFilename() {
		return filename;
	}


	public void setFilename(String filename) {
		this.filename = filename;
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
	 * �豸IDȡ��
	 * @return �豸ID
	 */
	public String getEiid() {
		return eiid;
	}


	/**
	 * �豸ID�趨
	 *
	 * @param eiid �豸ID
	 */
	public void setEiid(String eiid) {
		this.eiid = eiid;
	}


	/**
	 * �豸˵��ȡ��
	 * @return �豸˵��
	 */
	public String getEidesc() {
		return eidesc;
	}


	/**
	 * �豸˵���趨
	 *
	 * @param eidesc �豸˵��
	 */
	public void setEidesc(String eidesc) {
		this.eidesc = eidesc;
	}


	/**
	 * �豸״̬ȡ��
	 * @return �豸״̬
	 */
	public String getEistatus() {
		return eistatus;
	}


	/**
	 * �豸״̬�趨
	 *
	 * @param eistatus �豸״̬
	 */
	public void setEistatus(String eistatus) {
		this.eistatus = eistatus;
	}


	/**
	 * �豸����IDȡ��
	 * @return �豸����ID
	 */
	public String[] getCiid() {
		return ciid;
	}


	/**
	 * �豸����ID�趨
	 *
	 * @param ciid �豸����ID
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
	 * �豸����ֵȡ��
	 * @return �豸����ֵ
	 */
	public String[] getCivalue() {
		return civalue;
	}


	/**
	 * �豸����ֵ�趨
	 *
	 * @param civalue �豸����ֵ
	 */
	public void setCivalue(String[] civalue) {
		this.civalue = civalue;
	}


	/**
	 * �豸�汾ȡ��
	 * @return �豸�汾
	 */
	public int getEiversion() {
		return eiversion;
	}


	/**
	 * �豸�汾�趨
	 *
	 * @param eiversion �豸�汾
	 */
	public void setEiversion(int eiversion) {
		this.eiversion = eiversion;
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
	 * �豸���ø�������ȡ��
	 * @return �豸���ø�������
	 */
	public FormFile getAttachFile(int index) {
		return (FormFile) fileMap.get( new Integer( index ) );
	}


	/**
	 * �豸���ø�������
	 *
	 * @param index �豸���ø�����������
	 * @param file �豸���ø�������
	 */
	public void setAttachFile(int index, FormFile file) {
		fileMap.put( new Integer( index ), file );
	}
	
	/**
	 * �豸���ø�������ȡ��
	 * @return �豸���ø�������
	 */
	public FormFile getAttachFileXML(int index) {
		return (FormFile) fileMapXML.get( new Integer( index ) );
	}


	/**
	 * �豸���ø�������
	 *
	 * @param index �豸���ø�����������
	 * @param file �豸���ø�������
	 */
	public void setAttachFileXML(int index, FormFile file) {
		fileMapXML.put( new Integer( index ), file );
	}


	/**
	 * �豸���ø���ȡ��
	 * @return �豸���ø���
	 */
	public String[] getCiattach() {
		return ciattach;
	}


	/**
	 * �豸���ø���
	 *
	 * @param ciattach �豸���ø���
	 */
	public void setCiattach(String[] ciattach) {
		this.ciattach = ciattach;
	}


	/**
	 * �豸���ñ�����ֵ���
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
		request.getSession().setAttribute("IGASM0304Form", this);
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

	public String getEsyscoding_q() {
		return esyscoding_q;
	}


	public void setEsyscoding_q(String esyscoding_q) {
		this.esyscoding_q = esyscoding_q;
	}


	public String getCname() {
		// TODO Auto-generated method stub
		return null;
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


	public String getClabel_q() {
		// TODO Auto-generated method stub
		return null;
	}


	public Map<Integer, FormFile> getFileMapXML() {
		return fileMapXML;
	}


	public void setFileMapXML(Map<Integer, FormFile> fileMapXML) {
		this.fileMapXML = fileMapXML;
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
	
	/**
	 * �ʲ�С�汾ȡ��
	 * @return �ʲ�С�汾
	 */
	public Integer getEismallversion() {
		return eismallversion;
	}
	/**
	 * �ʲ�С�汾�趨
	 *
	 * @param eismallversion �ʲ�С�汾
	 */
	public void setEismallversion(Integer eismallversion) {
		this.eismallversion = eismallversion;
	}
	
	/**
	 * �ʲ�ģ�����ȡ��
	 * @return �ʲ�ģ�����
	 */
	public String getEmodeltype() {
		return emodeltype;
	}
	/**
	 * �ʲ�ģ������趨
	 *
	 * @param eparcoding �ʲ�ģ�����
	 */
	public void setEmodeltype(String emodeltype) {
		this.emodeltype = emodeltype;
	}


	public String getCiversion() {
		// TODO Auto-generated method stub
		return null;
	}


	public String getEid_q() {
		// TODO Auto-generated method stub
		return null;
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
