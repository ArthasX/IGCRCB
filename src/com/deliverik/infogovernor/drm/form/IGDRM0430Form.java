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
 * Ӧ����Դ������Ϣ��ϸ����FORM
 * 
 */
public class IGDRM0430Form extends BaseForm implements SOC0129SearchCond{

	private static final long serialVersionUID = 1L;

	/** Ӧ����Դ����ֵ����ֽ��� */
	private static final int MAX_BYTE = 2000;

	/** Ӧ����ԴID */
	protected String id;
	
	/** Ӧ����ԴeiID */
	protected String eiid;
	
	/** �ʲ�ģ��ID */
	protected Integer[] eid;

	/** Ӧ����Դ˵�� */
	protected String eidesc;
	
	/** Ӧ����Դ״̬ */
	protected String eistatus;
	
	/** Ӧ����Դ����ID */
	protected String[] ciid;
	
	/** �ʲ�����ID */
	protected String[] cid;

	/** �ʲ����ñ�� */
	protected String[] clabel;

	/** Ӧ����Դ����ֵ */
	protected String[] civalue;
	
	/** ɾ��������ʶ */
	protected String[] delfile;
	
	/** �汾�Ƿ�������ʶ */
	protected String ident;
	
	/** �ʲ�ģ����������ֵ */
	protected String[] entityItemCivalue;
	
	/** Ӧ����Դ���ø��� */
	protected String[] ciattach;
	
	/** ģ�Ͳ���� */
	protected String[] esyscoding;

	/** Ӧ����Դ�汾 */
	protected Integer eiversion;
	
	/** ����Ǩ�Ʊ�ʶ */
	protected String route = "0";
	
	/** Ӧ����Դ���ø������� */
	protected Map<Integer, FormFile> fileMap = new HashMap<Integer, FormFile>();
	/** Ӧ����Դ���ø������� */
	protected Map<Integer, FormFile> fileMapXML = new HashMap<Integer, FormFile>();
	
	/** ȡֵ��Χ�������� */
	protected Map<Integer, List<LabelValueBean>> selectedListMap = new HashMap<Integer, List<LabelValueBean>>();
	
	/** Ӧ����Դ������������ */
	protected String eiorgsyscoding;
	
	/** Ӧ����Դ������������ */
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
	
	/** ���ʲ��汾���� */
	protected Map<String, String> cldVersionMap;
	
	protected String[] isUpgrade;
	
	
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}


	public String[] getIsUpgrade() {
		return isUpgrade;
	}


	public void setIsUpgrade(String[] isUpgrade) {
		this.isUpgrade = isUpgrade;
	}

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
	 * Ӧ����ԴIDȡ��
	 * @return Ӧ����ԴID
	 */
	public String getEiid() {
		return eiid;
	}


	/**
	 * Ӧ����ԴID�趨
	 *
	 * @param eiid Ӧ����ԴID
	 */
	public void setEiid(String eiid) {
		this.eiid = eiid;
	}


	/**
	 * Ӧ����Դ˵��ȡ��
	 * @return Ӧ����Դ˵��
	 */
	public String getEidesc() {
		return eidesc;
	}


	/**
	 * Ӧ����Դ˵���趨
	 *
	 * @param eidesc Ӧ����Դ˵��
	 */
	public void setEidesc(String eidesc) {
		this.eidesc = eidesc;
	}


	/**
	 * Ӧ����Դ״̬ȡ��
	 * @return Ӧ����Դ״̬
	 */
	public String getEistatus() {
		return eistatus;
	}


	/**
	 * Ӧ����Դ״̬�趨
	 *
	 * @param eistatus Ӧ����Դ״̬
	 */
	public void setEistatus(String eistatus) {
		this.eistatus = eistatus;
	}


	/**
	 * Ӧ����Դ����IDȡ��
	 * @return Ӧ����Դ����ID
	 */
	public String[] getCiid() {
		return ciid;
	}


	/**
	 * Ӧ����Դ����ID�趨
	 *
	 * @param ciid Ӧ����Դ����ID
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
	 * Ӧ����Դ����ֵȡ��
	 * @return Ӧ����Դ����ֵ
	 */
	public String[] getCivalue() {
		return civalue;
	}


	/**
	 * Ӧ����Դ����ֵ�趨
	 *
	 * @param civalue Ӧ����Դ����ֵ
	 */
	public void setCivalue(String[] civalue) {
		this.civalue = civalue;
	}


	/**
	 * Ӧ����Դ�汾ȡ��
	 * @return Ӧ����Դ�汾
	 */
	public Integer getEiversion() {
		return eiversion;
	}


	/**
	 * Ӧ����Դ�汾�趨
	 *
	 * @param eiversion Ӧ����Դ�汾
	 */
	public void setEiversion(Integer eiversion) {
		this.eiversion = eiversion;
	}


	/**
	 * Ӧ����ԴIDȡ��
	 * @return Ӧ����ԴID
	 */
	public Integer[] getEid() {
		return eid;
	}


	/**
	 * �ʲ�ģ��ID�趨
	 *
	 * @param eid �ʲ�ģ��ID
	 */
	public void setEid(Integer[] eid) {
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
	 * Ӧ����Դ���ø�������ȡ��
	 * @return Ӧ����Դ���ø�������
	 */
	public FormFile getAttachFile(int index) {
		return (FormFile) fileMap.get( new Integer( index ) );
	}


	/**
	 * Ӧ����Դ���ø�������
	 *
	 * @param index Ӧ����Դ���ø�����������
	 * @param file Ӧ����Դ���ø�������
	 */
	public void setAttachFile(int index, FormFile file) {
		fileMap.put( new Integer( index ), file );
	}
	
	/**
	 * Ӧ����Դ���ø�������ȡ��
	 * @return Ӧ����Դ���ø�������
	 */
	public FormFile getAttachFileXML(int index) {
		return (FormFile) fileMapXML.get( new Integer( index ) );
	}


	/**
	 * Ӧ����Դ���ø�������
	 *
	 * @param index Ӧ����Դ���ø�����������
	 * @param file Ӧ����Դ���ø�������
	 */
	public void setAttachFileXML(int index, FormFile file) {
		fileMapXML.put( new Integer( index ), file );
	}


	/**
	 * Ӧ����Դ���ø���ȡ��
	 * @return Ӧ����Դ���ø���
	 */
	public String[] getCiattach() {
		return ciattach;
	}


	/**
	 * Ӧ����Դ���ø���
	 *
	 * @param ciattach Ӧ����Դ���ø���
	 */
	public void setCiattach(String[] ciattach) {
		this.ciattach = ciattach;
	}


	/**
	 * Ӧ����Դ���ñ�����ֵ���
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


	/* (non-Javadoc)
	 * @see com.deliverik.framework.soc.asset.model.condition.SOC0129SearchCond#getCheckersion()
	 */
	public int getCheckersion() {
		// TODO Auto-generated method stub
		return 0;
	}


	public String getId() {
		return id;
	}
	
}
