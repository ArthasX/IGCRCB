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
import com.deliverik.framework.soc.asset.model.SOC0118Info;
import com.deliverik.framework.soc.asset.model.entity.SOC0117TB;
import com.deliverik.framework.utility.IGStringUtils;

/**
 * �����༭����FORM
 * 
 * @History 2010-5-07     0000428: ���ӻ������Թ���
 */
public class IGASM1102Form extends BaseForm implements SOC0118Info{

	private static final long serialVersionUID = 1L;

	/** ��������ֵ����ֽ��� @update 0000200*/
	private static final int MAX_BYTE = 2000;

	/** ����ID */
	protected Integer eiid;
	
	/** ����ID�����֣� */
	protected String eiidStr;

	/** �ʲ�ģ��ID */
	protected String eid;
	
	/** �ʲ�ģ��ID�����֣� */
	protected String eidStr;
	
	/** �������� */
	protected String einame;
	
	/** �������� */
	protected String eilabel;

	/** ����˵�� */
	protected String eidesc;

	/** �����汾�� */
	protected Integer eiversion;

	/** �������ʱ�� */
	protected String eiupdtime;
	
	/** �����Ǽ��� */
	protected String eiinsdate;
	
	/** ����λ�����곤 */
	protected String x_total;
	
	/** ����λ�����곤 */
	protected String y_total;
	
	/** ������ */
	protected String manager;
	
	/** ��ϵ�绰 */
	protected String tel;

	/** �༭ģʽ���Ǽ�/����� */
	protected String mode = "0";
	
	/** �ʲ�������*/
	protected String eiuserid;
	
	/** �ʲ�����������*/
	protected String eiusername;
	
	protected String fingerPrint;
	
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
	
	/** �������ø��� */
	protected String[] ciattach;
	
	protected String[] esyscoding_str;
	
	protected String esyscoding;
	
	/** ����Ǩ�Ʊ�ʶ */
	protected String route = "0";
	
	/** �������ø������� */
	protected Map<Integer, FormFile> fileMap = new HashMap<Integer, FormFile>();
	
	/** ȡֵ��Χ�������� */
	protected Map<Integer, List<LabelValueBean>> selectedListMap = new HashMap<Integer, List<LabelValueBean>>();
	
	/** ���Ͳ���� */
	protected String esyscoding_q;
	
	protected String[] entityItemCivalue;
	
	/** �ʲ�С�汾*/
	protected Integer eismallversion;

	public String getFingerPrint() {
		return fingerPrint;
	}

	public void setFingerPrint(String fingerPrint) {
		this.fingerPrint = fingerPrint;
	}
	
	/**
	 * ����IDȡ��
	 * @return ����ID
	 */
	public Integer getEiid() {
		return this.eiid;
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
	 * ����ID�����֣�ȡ��
	 * @return ����ID�����֣�
	 */
	public String getEiidStr() {
		return eiidStr;
	}

	/**
	 * ����ID�����֣��趨
	 *
	 * @param eiidStr ����ID�����֣�
	 */
	public void setEiidStr(String eiidStr) {
		this.eiidStr = eiidStr;
	}

	/**
	 * �ʲ�ģ��IDȡ��
	 * @return �ʲ�ģ��ID
	 */
	public String getEid() {
		if( (this.eidStr == null) || (this.eidStr.equals(""))){
			return null;
		} else {
			return this.eidStr;
		}
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
	 * �ʲ�ģ��ID�����֣�ȡ��
	 * @return �ʲ�ģ��ID�����֣�
	 */
	public String getEidStr() {
		return eidStr;
	}

	/**
	 * �ʲ�ģ��ID�����֣��趨
	 *
	 * @param eidStr �ʲ�ģ��ID�����֣�
	 */
	public void setEidStr(String eidStr) {
		this.eidStr = eidStr;
	}

	/**
	 * ��������ȡ��
	 * @return ��������
	 */
	public String getEiname() {
		return einame;
	}

	/**
	 * ���������趨
	 *
	 * @param einame ��������
	 */
	public void setEiname(String einame) {
		this.einame = einame;
	}

	/**
	 * ��������ȡ��
	 * @return ��������
	 */
	public String getEilabel() {
		return eilabel;
	}

	/**
	 * ���������趨
	 *
	 * @param eilabel ��������
	 */
	public void setEilabel(String eilabel) {
		this.eilabel = eilabel;
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
	 * �����汾��ȡ��
	 * @return �����汾��
	 */
	public Integer getEiversion() {
		return eiversion;
	}

	/**
	 * �����汾���趨
	 *
	 * @param eiversion �����汾��
	 */
	public void setEiversion(Integer eiversion) {
		this.eiversion = eiversion;
	}

	/**
	 * ��������ʱ��ȡ��
	 * @return ��������ʱ��
	 */
	public String getEiupdtime() {
		return eiupdtime;
	}

	/**
	 * ��������ʱ���趨
	 *
	 * @param eiupdtime ��������ʱ��
	 */
	public void setEiupdtime(String eiupdtime) {
		this.eiupdtime = eiupdtime;
	}

	/**
	 * �����Ǽ���ȡ��
	 * @return �����Ǽ���
	 */
	public String getEiinsdate() {
		return eiinsdate;
	}

	/**
	 * �����Ǽ����趨
	 *
	 * @param eiinsdate �����Ǽ���
	 */
	public void setEiinsdate(String eiinsdate) {
		this.eiinsdate = eiinsdate;
	}

	/**
	 * ����λ�������᳤ȡ��
	 * @return ����λ�������᳤
	 */
	public String getX_total() {
		return x_total;
	}

	/**
	 * ����λ�������᳤�趨
	 *
	 * @param x_total ����λ�������᳤
	 */
	public void setX_total(String x_total) {
		this.x_total = x_total;
	}

	/**
	 * ����λ�������᳤ȡ��
	 * @return ����λ�������᳤
	 */
	public String getY_total() {
		return y_total;
	}

	/**
	 * ����λ�������᳤�趨
	 *
	 * @param y_total ����λ�������᳤
	 */
	public void setY_total(String y_total) {
		this.y_total = y_total;
	}

	/**
	 * ������ȡ��
	 * @return ������
	 */
	public String getManager() {
		return manager;
	}

	/**
	 * �������趨
	 *
	 * @param manager ������
	 */
	public void setManager(String manager) {
		this.manager = manager;
	}

	/**
	 * ��ϵ�绰ȡ��
	 * @return ��ϵ�绰
	 */
	public String getTel() {
		return tel;
	}

	/**
	 * ��ϵ�绰�趨
	 *
	 * @param tel ��ϵ�绰
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}

	/**
	 * �༭ģʽȡ��
	 * @return �༭ģʽ
	 */
	public String getMode() {
		return mode;
	}


	/**
	 * �༭ģʽ�趨
	 *
	 * @param mode �༭ģʽ
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}
	
	public String getEistatus() {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * �ʲ�������ȡ��
	 * @return �ʲ�������
	 */
	public String getEiuserid() {
		return eiuserid;
	}
	
	/**
	 * �ʲ��������趨
	 *
	 * @param eiuserid �ʲ�������
	 */
	public void setEiuserid(String eiuserid) {
		this.eiuserid = eiuserid;
	}
	
	/**
	 * �ʲ�����������ȡ��
	 * @return �ʲ�����������
	 */
	public String getEiusername() {
		return eiusername;
	}
	
	/**
	 * �ʲ������������趨
	 *
	 * @param eiusername �ʲ�����������
	 */
	public void setEiusername(String eiusername) {
		this.eiusername = eiusername;
	}

	public String[] getCiid() {
		return ciid;
	}

	public void setCiid(String[] ciid) {
		this.ciid = ciid;
	}

	public String[] getCid() {
		return cid;
	}

	public void setCid(String[] cid) {
		this.cid = cid;
	}

	public String[] getClabel() {
		return clabel;
	}

	public void setClabel(String[] clabel) {
		this.clabel = clabel;
	}

	public String[] getCivalue() {
		return civalue;
	}

	public void setCivalue(String[] civalue) {
		this.civalue = civalue;
	}

	public String[] getCiattach() {
		return ciattach;
	}

	public void setCiattach(String[] ciattach) {
		this.ciattach = ciattach;
	}

	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
	}

	public Map<Integer, FormFile> getFileMap() {
		return fileMap;
	}

	public void setFileMap(Map<Integer, FormFile> fileMap) {
		this.fileMap = fileMap;
	}

	public void setSelectedListMap(
			Map<Integer, List<LabelValueBean>> selectedListMap) {
		this.selectedListMap = selectedListMap;
	}

	public String getEsyscoding_q() {
		return esyscoding_q;
	}

	public void setEsyscoding_q(String esyscoding_q) {
		this.esyscoding_q = esyscoding_q;
	}

	public void setEistatus(String eistatus) {
		this.eistatus = eistatus;
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
		request.getSession().setAttribute("IGASM1102Form", this);
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

	public String[] getEntityItemCivalue() {
		return entityItemCivalue;
	}

	public void setEntityItemCivalue(String[] entityItemCivalue) {
		this.entityItemCivalue = entityItemCivalue;
	}
	
	/**
	 * �ĵ����ø�������ȡ��
	 * @return �ĵ����ø�������
	 */
	public FormFile getAttachFile(int index) {
		return (FormFile) fileMap.get( new Integer( index ) );
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

	public String getEiorgsyscoding() {
		// TODO Auto-generated method stub
		return null;
	}

	public String[] getDelfile() {
		return delfile;
	}

	public void setDelfile(String[] delfile) {
		this.delfile = delfile;
	}

	public String[] getEsyscoding_str() {
		return esyscoding_str;
	}

	public void setEsyscoding_str(String[] esyscoding_str) {
		this.esyscoding_str = esyscoding_str;
	}

	public String getEsyscoding() {
		return esyscoding;
	}

	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}
	
		public Integer getEirootmark() {
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

	public SOC0117TB getSoc0117TB() {
		// TODO Auto-generated method stub
		return null;
	}


}
