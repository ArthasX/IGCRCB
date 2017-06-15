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
 * Ӧ��������Ϣ��ϸ����FORM
 * 
 */
public class IGCIM0148Form extends BaseForm implements SOC0129SearchCond{

	private static final long serialVersionUID = 1L;

	/** Ӧ������ֵ����ֽ��� */
	private static final int MAX_BYTE = 2000;

	/** Ӧ��ID */
	protected String eiid;
	
	/** Ӧ��˵�� */
	protected String eidesc;
	
	private String einame;
	
	/** Ӧ��״̬ */
	protected String eistatus;
	
	/** Ӧ������ID */
	protected String[] ciid;
	
	/** �ʲ�����ID */
	protected String[] cid;

	/** �ʲ����ñ�� */
	protected String[] clabel;

	/** Ӧ������ֵ */
	protected String[] civalue;
	
	/** Ӧ�����ø��� */
	protected String[] ciattach;
	
	/** �ʲ�ģ��ID */
	protected String[] eid;
	
	/** ģ�Ͳ���� */
	protected String[] esyscoding;

	/** Ӧ�ð汾 */
	protected int eiversion;
	
	/** ����Ǩ�Ʊ�ʶ */
	protected String route = "0";
	
	/** Ӧ�����ø������� */
	protected Map<Integer, FormFile> fileMap = new HashMap<Integer, FormFile>();
	
	/** ȡֵ��Χ�������� */
	protected Map<Integer, List<LabelValueBean>> selectedListMap = new HashMap<Integer, List<LabelValueBean>>();
	/** Ӧ�������������� */
	protected String eiorgsyscoding;
	
	/** Ӧ�������������� */
	protected String eiorgname;
	
	/** ģ�Ͳ���� */
	protected String esyscoding_q;
	
	/** �ʲ�ģ����������ֵ */
	protected String[] entityItemCivalue;
	
	/** �������Ա�ʶ */
	protected String[] civalue_bak;
	
	/** �Ƿ�ɼ̳б�ʶ��ʹ��entity����Ԥ���ֶ�EKEY2, 0����̳У�1�����̳�*/
	protected String ekey2;
	
	protected int eismallversion;
	
	/** �ʲ�ģ�����0��һ���ʲ�ģ�� 1�������ʲ�ģ�ͣ� */
	protected String emodeltype;
	
	/** �豸���ø������� */
	protected Map<Integer, FormFile> fileMapXML = new HashMap<Integer, FormFile>();
	
	protected String eirootmark;
	
	public String getEkey2() {
		return ekey2;
	}

	public void setEkey2(String ekey2) {
		this.ekey2 = ekey2;
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
	 * Ӧ��IDȡ��
	 * @return Ӧ��ID
	 */
	public String getEiid() {
		return eiid;
	}


	/**
	 * Ӧ��ID�趨
	 *
	 * @param eiid Ӧ��ID
	 */
	public void setEiid(String eiid) {
		this.eiid = eiid;
	}


	/**
	 * Ӧ��˵��ȡ��
	 * @return Ӧ��˵��
	 */
	public String getEidesc() {
		return eidesc;
	}


	/**
	 * Ӧ��˵���趨
	 *
	 * @param eidesc Ӧ��˵��
	 */
	public void setEidesc(String eidesc) {
		this.eidesc = eidesc;
	}


	/**
	 * Ӧ��״̬ȡ��
	 * @return Ӧ��״̬
	 */
	public String getEistatus() {
		return eistatus;
	}


	/**
	 * Ӧ��״̬�趨
	 *
	 * @param eistatus Ӧ��״̬
	 */
	public void setEistatus(String eistatus) {
		this.eistatus = eistatus;
	}


	/**
	 * Ӧ������IDȡ��
	 * @return Ӧ������ID
	 */
	public String[] getCiid() {
		return ciid;
	}


	/**
	 * Ӧ������ID�趨
	 *
	 * @param ciid Ӧ������ID
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
	 * Ӧ������ֵȡ��
	 * @return Ӧ������ֵ
	 */
	public String[] getCivalue() {
		return civalue;
	}


	/**
	 * Ӧ������ֵ�趨
	 *
	 * @param civalue Ӧ������ֵ
	 */
	public void setCivalue(String[] civalue) {
		this.civalue = civalue;
	}


	/**
	 * Ӧ�ð汾ȡ��
	 * @return Ӧ�ð汾
	 */
	public int getEiversion() {
		return eiversion;
	}


	/**
	 * Ӧ�ð汾�趨
	 *
	 * @param eiversion Ӧ�ð汾
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
	 * Ӧ�����ø�������ȡ��
	 * @return Ӧ�����ø�������
	 */
	public FormFile getAttachFile(int index) {
		return (FormFile) fileMap.get( new Integer( index ) );
	}


	/**
	 * Ӧ�����ø�������
	 *
	 * @param index Ӧ�����ø�����������
	 * @param file Ӧ�����ø�������
	 */
	public void setAttachFile(int index, FormFile file) {
		fileMap.put( new Integer( index ), file );
	}


	/**
	 * Ӧ�����ø���ȡ��
	 * @return Ӧ�����ø���
	 */
	public String[] getCiattach() {
		return ciattach;
	}


	/**
	 * Ӧ�����ø���
	 *
	 * @param ciattach Ӧ�����ø���
	 */
	public void setCiattach(String[] ciattach) {
		this.ciattach = ciattach;
	}


	/**
	 * Ӧ�����ñ�����ֵ���
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
		request.getSession().setAttribute("IGASM0804Form", this);
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

	public String getEiname() {
		return einame;
	}


	public void setEiname(String einame) {
		this.einame = einame;
	}

	public int getEismallversion() {
		return eismallversion;
	}

	public void setEismallversion(int eismallversion) {
		this.eismallversion = eismallversion;
	}

	public String getEmodeltype() {
		return emodeltype;
	}

	public void setEmodeltype(String emodeltype) {
		this.emodeltype = emodeltype;
	}

	public Map<Integer, FormFile> getFileMapXML() {
		return fileMapXML;
	}

	public void setFileMapXML(Map<Integer, FormFile> fileMapXML) {
		this.fileMapXML = fileMapXML;
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

	public String getEirootmark() {
		return eirootmark;
	}

	public void setEirootmark(String eirootmark) {
		this.eirootmark = eirootmark;
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
