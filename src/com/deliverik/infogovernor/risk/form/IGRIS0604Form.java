package com.deliverik.infogovernor.risk.form;

import java.util.ArrayList;
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
import com.deliverik.framework.model.Attachment;
import com.deliverik.framework.soc.asset.model.condition.SOC0129SearchCond;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.infogovernor.sym.model.FormFileInfo;

/**
 * �����������Ϣ��ϸ����FORM
 * 
 */
public class IGRIS0604Form extends BaseForm implements SOC0129SearchCond{

	private static final long serialVersionUID = 1L;

	/** ���������ֵ����ֽ��� */
	private static final int MAX_BYTE = 2000;
	
	

	public IGRIS0604Form() {
		fileList = new ArrayList<FormFileInfo>();
		fileList.add(new FormFileInfo());
	}


	/** �����ID */
	protected String eiid;
	
	/** �����˵�� */
	protected String eidesc;
	
	/** �����״̬ */
	protected String eistatus;
	
	/** ���������ID */
	protected String[] ciid;
	
	/** �ʲ�����ID */
	protected String[] cid;

	/** �ʲ����ñ�� */
	protected String[] clabel;

	/** ���������ֵ */
	protected String[] civalue;
	
	/** ɾ��������ʶ */
	protected String[] delfile;
	
	/** ��������ø��� */
	protected String[] ciattach;
	
	/** �ʲ�ģ��ID */
	protected String[] eid;
	
	/** ģ�Ͳ���� */
	protected String[] esyscoding;

	/** �����汾 */
	protected int eiversion;
	
	/** ����Ǩ�Ʊ�ʶ */
	protected String route = "0";
	
	/** ��������ø������� */
	protected Map<Integer, FormFile> fileMap = new HashMap<Integer, FormFile>();
	
	/** ȡֵ��Χ�������� */
	protected Map<Integer, List<LabelValueBean>> selectedListMap = new HashMap<Integer, List<LabelValueBean>>();
	/** ����������������� */
	protected String eiorgsyscoding;
	
	/** ����������������� */
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
	
	
	/**�汾����map*/
	protected Map<Integer,Integer> checkVersionMap;
	
	/**ѡ��汾*/
	protected String selecteiversion;
	
	/**�鿴���Ƿ���Ȩ���޸�*/
	protected String identyFlag; 
	
	protected String hiddenmguserid;
	

	protected int checkersion;
	
	/**��ѯ��ʶ*/
	protected String looksign;

	/** �ļ��б�  */	
	protected List<FormFileInfo> fileList;
	protected FormFile file;
	public String nattkey;
	protected String attacthname;
	public List<Attachment> attachmentList;
	//�Ƿ�ɾ������
	public String deletekeys;
	
	protected String eiids;
	
	
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
	 * hiddenmguseridȡ��
	 * @return hiddenmguserid hiddenmguserid
	 */
	public String getHiddenmguserid() {
		return hiddenmguserid;
	}


	/**
	 * hiddenmguserid�趨
	 * @param hiddenmguserid hiddenmguserid
	 */
	public void setHiddenmguserid(String hiddenmguserid) {
		this.hiddenmguserid = hiddenmguserid;
	}


	/**
	 * �鿴���Ƿ���Ȩ���޸�ȡ��
	 * @return identyFlag �鿴���Ƿ���Ȩ���޸�
	 */
	public String getIdentyFlag() {
		return identyFlag;
	}


	/**
	 * �鿴���Ƿ���Ȩ���޸��趨
	 * @param identyFlag �鿴���Ƿ���Ȩ���޸�
	 */
	public void setIdentyFlag(String identyFlag) {
		this.identyFlag = identyFlag;
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


	/**
	 * �汾����mapȡ��
	 * @return checkVersionMap �汾����map
	 */
	public Map<Integer, Integer> getCheckVersionMap() {
		return checkVersionMap;
	}


	/**
	 * �汾����map�趨
	 * @param checkVersionMap �汾����map
	 */
	public void setCheckVersionMap(Map<Integer, Integer> checkVersionMap) {
		this.checkVersionMap = checkVersionMap;
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
	 * �����IDȡ��
	 * @return �����ID
	 */
	public String getEiid() {
		return eiid;
	}


	/**
	 * �����ID�趨
	 *
	 * @param eiid �����ID
	 */
	public void setEiid(String eiid) {
		this.eiid = eiid;
	}


	/**
	 * �����˵��ȡ��
	 * @return �����˵��
	 */
	public String getEidesc() {
		return eidesc;
	}


	/**
	 * �����˵���趨
	 *
	 * @param eidesc �����˵��
	 */
	public void setEidesc(String eidesc) {
		this.eidesc = eidesc;
	}


	/**
	 * �����״̬ȡ��
	 * @return �����״̬
	 */
	public String getEistatus() {
		return eistatus;
	}


	/**
	 * �����״̬�趨
	 *
	 * @param eistatus �����״̬
	 */
	public void setEistatus(String eistatus) {
		this.eistatus = eistatus;
	}


	/**
	 * ���������IDȡ��
	 * @return ���������ID
	 */
	public String[] getCiid() {
		return ciid;
	}


	/**
	 * ���������ID�趨
	 *
	 * @param ciid ���������ID
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
	 * ���������ֵȡ��
	 * @return ���������ֵ
	 */
	public String[] getCivalue() {
		return civalue;
	}


	/**
	 * ���������ֵ�趨
	 *
	 * @param civalue ���������ֵ
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
	 * ��������ø�������ȡ��
	 * @return ��������ø�������
	 */
	public FormFile getAttachFile(int index) {
		return (FormFile) fileMap.get( new Integer( index ) );
	}


	/**
	 * ��������ø�������
	 *
	 * @param index ��������ø�����������
	 * @param file ��������ø�������
	 */
	public void setAttachFile(int index, FormFile file) {
		fileMap.put( new Integer( index ), file );
	}


	/**
	 * ��������ø���ȡ��
	 * @return ��������ø���
	 */
	public String[] getCiattach() {
		return ciattach;
	}


	/**
	 * ��������ø���
	 *
	 * @param ciattach ��������ø���
	 */
	public void setCiattach(String[] ciattach) {
		this.ciattach = ciattach;
	}


	/**
	 * ��������ñ�������ֵ���
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
		request.getSession().setAttribute("IGRIS0604Form", this);
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
	 * attacthnameȡ��
	 * @return attacthname  attacthname
	 */
	public String getAttacthname() {
		return attacthname;
	}

	/**
	 * attacthname�趨
	 * @param attacthname  attacthname
	 */
	public void setAttacthname(String attacthname) {
		this.attacthname = attacthname;
	}
	/**
	 * nattkeyȡ��
	 * @return nattkey  nattkey
	 */
	public String getNattkey() {
		return nattkey;
	}

	/**
	 * nattkey�趨
	 * @param nattkey  nattkey
	 */
	public void setNattkey(String nattkey) {
		this.nattkey = nattkey;
	}
	public void setAttachmentList(List<Attachment> attachmentList) {
		this.attachmentList = attachmentList;
	}

	public List<Attachment> getAttachmentList() {
		return attachmentList;
	}
	public List<FormFileInfo> getFileListInfo() {
		return fileList;
	}

	public FormFileInfo getFileList(int index) {
		int size = fileList.size();
		if (index>size-1) {
			for (int i = 0; i < index-size+1; i++) {
				fileList.add(new FormFileInfo());
			}
		}
		return fileList.get(index);
	}

	/**
	 * �ļ��б��趨
	 * @param fileList  �ļ��б�
	 */
	public void setFileList(List<FormFileInfo> fileList) {
		this.fileList = fileList;
	}
	
	public FormFile getAttachFile() {
		return this.file;
	}

	public void setAttachFile( FormFile file) {
		this.file=file;
	}


	/**
	 * deletekeysȡ��
	 * @return deletekeys  deletekeys
	 */
	public String getDeletekeys() {
		return deletekeys;
	}


	/**
	 * deletekeys�趨
	 * @param deletekeys  deletekeys
	 */
	public void setDeletekeys(String deletekeys) {
		this.deletekeys = deletekeys;
	}


	/**
	 * @return the eiids
	 */
	public String getEiids() {
		return eiids;
	}


	/**
	 * @param eiids the eiids to set
	 */
	public void setEiids(String eiids) {
		this.eiids = eiids;
	}


	public String getId() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}