/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.prr.form;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.Globals;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.upload.FormFile;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.workflow.WorkFlowParameterInfo;
import com.deliverik.framework.workflow.prr.model.IG500Info;

/**
 * @Description: ���̷���Form
 * @Author  
 * @History 2010-9-13     �½� 
 * @Version V1.0
 */
@SuppressWarnings("serial")
public class IGPRR0101Form extends BaseForm implements IG500Info, WorkFlowParameterInfo {
	
	/** ��չ����ֵ */
	protected String parameters;
	
	/** ���̶���ID */
	protected String pdid;
	
	/** �ʲ�ID */
	protected Integer eiid;

	/** ����״̬ID */
	protected String psdid;
	
	/** ���̷���λ�� */
	protected String pts;
	
	/** ������ʶ ��0010 */
	protected String action;
	
	/** ��־��Ϣ */
	protected String rlcomment;
	
	/** �Ƿ��һ�ν���ҳ���ʶ */
	protected String isFirst;
	
	/** ���� */
	protected Map<Integer, FormFile> fileMap = null;
	
	/**�ı��򸽼���*/
	protected Map<Integer, FormFile> fileMapMuti = null;
	
	/** �������и��� */
	protected Map<Integer, FormFile> fileMapTable = null;
	
	/**�ı��򸽼���map�еĶ�Ӧ�ı������Ƽ�˳��*/
	protected String[] att=new String[]{};
	
	/** ���̱�������ֵ */
	protected String[] pivarvalue;
	
	/** ���̱���������ʶ */
	protected String[] pivarname;
	
	/** ���̱����������� */
	protected String[] pivarlabel;
	
	/** ���̱����������� */
	protected String[] pivartype;
	
	/** ���̱���Ȩ�� */
	protected String[] pidaccess;
	
	/** ���̱���ģʽ */
	protected String[] pidmode;
	
	/** ����˽��Ȩ�޷�Χ */
	protected String[] privatescope;
	
	/** ���̱�������ID */
	protected String[] pidid;
	
	/** ���̱�������ʲ����� */
	protected String[] pivarassetname;
	
	/** ���̱�������������� */
	protected String[] pivarprname;
	
	/** ���̱��������Ŀ���� */
	protected String[] pivarprjname;
	
	/** ���̱�����ѡ */
	protected String[] pivarradio;
	
	/** ���̱�����ѡ */
	protected String[] pivarcheckbox;
	
	/** ���̱����� */
	protected String[] pivartreename;
	
	/** ������ID*/
	protected String[] participants;
	
	protected String pjdtype;
	
	/** ���첿�� */
	protected String[] ppsupers;
	
	public String[] getPivartreename() {
		return pivartreename;
	}

	public void setPivartreename(String[] pivartreename) {
		this.pivartreename = pivartreename;
	}

	/** ���̱�������ֵ����ֽ��� */
	private static final int MAX_BYTE = 3000;
	
	/**  ���̼�¼ID */
	protected Integer prid;
	
	/** ���̼�¼���� */
	protected String prtype;
	
	/** ���̼�¼������ */
	protected String prsubtype;
	
	/** ���̼�¼״̬ */
	protected String prstatus;
	
	/** ���̼�¼״̬��״̬ */
	protected String prsubstatus;
	
	/** ���̼�¼��Ŀ */
	protected String prtitle;
	
	/** ���̼�¼���� */
	protected String prdesc;
	
	/** ���̼�¼����ʱ�� */
	protected String propentime;
	
	/** ���̼�¼�ر�ʱ�� */
	protected String prclosetime;
	
	/** ���̼�¼�ƻ�ִ��ʱ�� */
	protected String prplantime;
	
	/** ���̼�¼�ƻ�ִ������ */
	protected String prduration;
	
	/** ���̼�¼�����̶� */
	protected String prurgency;
	
	/** ���̼�¼Ӱ��̶� */
	protected String primpact;
	
	/** ���̼�¼����ʲ�ID */
	protected Integer prassetid;
	
	/** ���̼�¼����ʲ����� */
	protected String prassetname;
	
	/** ���̼�¼�����ҵ�� */
	protected String prbusiness;
	
	/** ���̼�¼ִ�мƻ� */
	protected String primplplan;
	
	/** ���̼�¼�ָ��ƻ� */
	protected String prbackplan;
	
	/** ���̼�¼��֤�ƻ� */
	protected String prvfyplan;
	
	/** ���̼�¼�����ĿID */
	protected Integer pid;
	
	/** ���̼�¼�����Ŀ��� */
	protected String pcode;
	
	/** ���̼�¼�����Ŀ���� */
	protected String pname;
	
	/** ���̼�¼��������ϵ��ʽ */
	protected String prinfo;
	
	/** ���̼�¼�������ID */
	protected Integer prcorid;
	
	/** ���̼�¼����������� */
	protected String prcortype;
	
	/** ���̼�¼����������� */
	protected String prcortitle;
	
	/** ���̼�¼����ʲ����� */
	protected String prassetcategory;
	
	/** ���̼�¼�������û�ID */
	protected String pruserid;
	
	/** ���̼�¼�������û����� */
	protected String prusername;
	
	/** ���̼�¼�����߽�ɫID */
	protected Integer prroleid;
	
	/** ���̼�¼�����߽�ɫ���� */
	protected String prrolename;
	
	/** ���̼�¼��������ID */
	protected String prpdid;
	
	/** ���̼�¼������������ */
	protected String prpdname;
	
	/** ���̼�¼������������������� */
	protected String prorgid;
	
	/** ���̼�¼������������������ */
	protected String prorgname;
	
	/** ���̼�¼������ */
	protected String prserialnum;
	
	/** ���̼�¼ʵ�ʽ��ʱ�䣨�ӿ�ʼ�������� */
	protected Integer prfacttime;
	
	/** �Զ���������ʱԾǨ���� */
	protected String prptdcond;
	
	/** ��¼ʱ��� */
	protected String fingerPrint;
	
	/** ��ݷ����ʶ */
	protected String isServiceStart;
	
	/** ��������ID */
	protected Integer parprid;
	
	/**���̱�������ID*/
	protected String[] piid;
	
	/** ���̱�����ɫ���� */
	protected String[] pivarrolename;
	
	
	/** �ı���󶨸���ǰ���� */
	protected String strpsidid;
	
	/**�ı��򸽼���ɾ��*/
	protected String delFileMutiStr;
	
	/** ��ɫID */
	protected Integer roleid;
	
	/** ����ģ��ID */
	protected Integer ptid;
	
	/** �������Ϣ������������ */
	protected String[] column_pidid;
	/** �����ֵ���� */
	protected String[] column_value;
	/** �����ֵ�кż��� */
	protected String[] column_rownumber; 

	/** �ʲ� */
	protected Map<Integer, String> entityMap = null;
	
	/** ��ע */
	protected String[] pidcomment;
	
	/** �����������б�ʶ */
	protected String addTableColumnFileStr;
	
	/** ��˵�� */
	protected String[] piddesc;
	
	/** ���ɲ����߰��������� */
	protected String assign_orgsyscoding;
	
	/** ��Ա���û�ID */
	protected String [] par_userid;
	
	/** ��Ա���û����� */
	protected String [] par_username;
	
	/** ��Ա�������� */
	protected String [] par_orgid;
	
	/** ��Ա���������� */
	protected String [] par_orgname;
	
	/** ��Ա����ɫID */
	protected Integer [] par_roleid;
	
	/** ��Ա����ɫ���� */
	protected String [] par_rolename;
	
	/** ��Ա��������ID */
	protected String [] par_pidid;
	
	/** ��Ա���绰 */
	protected String [] par_phone;
	
	/** ���ʽ������ɾ����ʶ */
	protected String delTableColumnFileStr;
	
	/** �ʲ�ɾ����ʶ */
	protected String pieids;
	
	/**��ת*/
	protected String jump;
	
	/**
	 *��עȡ��
	 */
	public String[] getPidcomment() {
		return pidcomment;
	}

	/**
	 *��ע����
	 */
	public void setPidcomment(String[] pidcomment) {
		this.pidcomment = pidcomment;
	}

	public String[] getPivarrolename() {
		return pivarrolename;
	}

	public void setPivarrolename(String[] pivarrolename) {
		this.pivarrolename = pivarrolename;
	}

	public String[] getPiid() {
		return piid;
	}

	public void setPiid(String[] piid) {
		this.piid = piid;
	}
	
	/**
	 * ���̶���IDȡ��
	 * 
	 * @return ���̶���ID
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * ���̶���ID�趨
	 *
	 * @param pdid ���̶���ID
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	/**
	 * ���̱�������IDȡ��
	 * @return ���̱�������ID
	 */
	public String[] getPidid() {
		return pidid;
	}

	/**
	 * ���̱�������ID�趨
	 * @param pidid ���̱�������ID
	 */
	public void setPidid(String[] pidid) {
		this.pidid = pidid;
	}

	/**
	 * ����ȡ��
	 * @return ����
	 */
	public Map<Integer, FormFile> getFileMap() {
		return fileMap;
	}

	/**
	 * �����趨
	 * @param fileMap ����
	 */
	public void setFileMap(Map<Integer, FormFile> fileMap) {
		this.fileMap = fileMap;
	}

	/**
	 * ���̱�������ֵȡ��
	 * @return ���̱�������ֵ
	 */
	public String[] getPivarvalue() {
		return pivarvalue;
	}

	/**
	 * ���̱�������ֵ�趨
	 * @param pivarvalue ���̱�������ֵ
	 */
	public void setPivarvalue(String[] pivarvalue) {
		this.pivarvalue = pivarvalue;
	}

	/**
	 * ���̱���������ʶȡ��
	 * @return ���̱���������ʶ
	 */
	public String[] getPivarname() {
		return pivarname;
	}

	/**
	 * ���̱���������ʶ�趨
	 * @param pivarname ���̱���������ʶ
	 */
	public void setPivarname(String[] pivarname) {
		this.pivarname = pivarname;
	}

	/**
	 * ���̱�����������ȡ��
	 * @return ���̱�����������
	 */
	public String[] getPivarlabel() {
		return pivarlabel;
	}

	/**
	 * ���̱������������趨
	 * @param pivarlabel ���̱�����������
	 */
	public void setPivarlabel(String[] pivarlabel) {
		this.pivarlabel = pivarlabel;
	}

	/**
	 * ���̱�����������ȡ��
	 * @return ���̱�����������
	 */
	public String[] getPivartype() {
		return pivartype;
	}

	/**
	 * ���̱������������趨
	 * @param pivartype ���̱�����������
	 */
	public void setPivartype(String[] pivartype) {
		this.pivartype = pivartype;
	}


	/**
	 * ����״̬IDȡ��
	 * 
	 * @return ����״̬ID
	 */
	public String getPsdid() {
		return psdid;
	}


	/**
	 * ����״̬ID�趨
	 *
	 * @param psdid ����״̬ID
	 */
	public void setPsdid(String psdid) {
		this.psdid = psdid;
	}

	
	/**
	 * ��־��Ϣȡ��
	 * 
	 * @return ��־��Ϣ
	 */
	public String getRlcomment() {
		return rlcomment;
	}

	/**
	 * ��־��Ϣ�趨
	 *
	 * @param rlcomment ��־��Ϣ
	 */
	public void setRlcomment(String rlcomment) {
		this.rlcomment = rlcomment;
	}
	
	
	/**
	 * ��ȡ����
	 * @return ��ȡ����
	 */
	public FormFile getAttachFile(int index) {
		return (FormFile) fileMap.get(new Integer(index));
	}

	/**
	 * ���ø���
	 * @param index ������������
	 * @param file ����
	 */
	public void setAttachFile(int index, FormFile file) {
		fileMap.put(new Integer(index), file);
	}
	
	
	/**
	 * ���̱���Ȩ��ȡ��
	 * 
	 * @return ���̱���Ȩ��
	 */
	public String[] getPidaccess() {
		return pidaccess;
	}

	/**
	 * ���̱���Ȩ���趨
	 *
	 * @param pidaccess ���̱���Ȩ��
	 */
	public void setPidaccess(String[] pidaccess) {
		this.pidaccess = pidaccess;
	}
	
	/**
	 * ������ʶȡ��
	 * @return ������ʶ
	 */
	public String getAction() {
		return action;
	}

	/**
	 * ������ʶ�趨
	 * @param action ������ʶ
	 */
	public void setAction(String action) {
		this.action = action;
	}
	
	/**
	 * �Ƿ��һ�ν���ҳ���ʶȡ��
	 * @return �Ƿ��һ�ν���ҳ���ʶ
	 */
	public String getIsFirst() {
		return isFirst;
	}

	/**
	 * �Ƿ��һ�ν���ҳ���ʶ�趨
	 * @param isFirst �Ƿ��һ�ν���ҳ���ʶ
	 */
	public void setIsFirst(String isFirst) {
		this.isFirst = isFirst;
	}


	/**
	 * ���̱�������ʲ�����ȡ��
	 * @return ���̱�������ʲ�����
	 */
	public String[] getPivarassetname() {
		return pivarassetname;
	}

	/**
	 * ���̱�������ʲ������趨
	 * @param pivarassetname ���̱�������ʲ�����
	 */
	public void setPivarassetname(String[] pivarassetname) {
		this.pivarassetname = pivarassetname;
	}

	/**
	 * ���̱��������������ȡ��
	 * @return ���̱��������������
	 */
	public String[] getPivarprname() {
		return pivarprname;
	}

	/**
	 * ���̱���������������趨
	 * @param pivarprname ���̱��������������
	 */
	public void setPivarprname(String[] pivarprname) {
		this.pivarprname = pivarprname;
	}

	/**
	 * ���̱��������Ŀ����ȡ��
	 * @return ���̱��������Ŀ����
	 */
	public String[] getPivarprjname() {
		return pivarprjname;
	}

	/**
	 * ���̱��������Ŀ�����趨
	 * @param pivarprjname ���̱��������Ŀ����
	 */
	public void setPivarprjname(String[] pivarprjname) {
		this.pivarprjname = pivarprjname;
	}

	/**
	 * ���̷���λ��ȡ��
	 * @return ���̷���λ��
	 */
	public String getPts() {
		return pts;
	}

	/**
	 * ���̷���λ���趨
	 * @param pts ���̷���λ��
	 */
	public void setPts(String pts) {
		this.pts = pts;
	}
	
	/**
	 * ���̼�¼IDȡ��
	 * @return���̼�¼ID
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * ���̼�¼ID�趨
	 * @param prid ���̼�¼ID
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	/**
	 * ���̼�¼����ȡ��
	 * @return ���̼�¼����
	 */
	public String getPrtype() {
		return prtype;
	}

	/**
	 * ���̼�¼�����趨
	 * @param prtype ���̼�¼����
	 */
	public void setPrtype(String prtype) {
		this.prtype = prtype;
	}

	/**
	 * ���̼�¼������ȡ��
	 * @return ���̼�¼������
	 */
	public String getPrsubtype() {
		return prsubtype;
	}

	/**
	 * ���̼�¼�������趨
	 * @param prsubtype ���̼�¼������
	 */
	public void setPrsubtype(String prsubtype) {
		this.prsubtype = prsubtype;
	}

	/**
	 * ���̼�¼״̬ȡ��
	 * @return ���̼�¼״̬
	 */
	public String getPrstatus() {
		return prstatus;
	}

	/**
	 * ���̼�¼״̬�趨
	 * @param prstatus ���̼�¼״̬
	 */
	public void setPrstatus(String prstatus) {
		this.prstatus = prstatus;
	}

	/**
	 * ���̼�¼״̬��״̬ȡ��
	 * @return ���̼�¼״̬��״̬
	 */
	public String getPrsubstatus() {
		return prsubstatus;
	}

	/**
	 * ���̼�¼״̬��״̬�趨
	 * @param prsubstatus ���̼�¼״̬��״̬
	 */
	public void setPrsubstatus(String prsubstatus) {
		this.prsubstatus = prsubstatus;
	}

	/**
	 * ���̼�¼��Ŀȡ��
	 * @return ���̼�¼��Ŀ
	 */
	public String getPrtitle() {
		return prtitle;
	}

	/**
	 * ���̼�¼��Ŀ�趨
	 * @param prtitle ���̼�¼��Ŀ
	 */
	public void setPrtitle(String prtitle) {
		this.prtitle = prtitle;
	}

	/**
	 * ���̼�¼����ȡ��
	 * @return ���̼�¼����
	 */
	public String getPrdesc() {
		return prdesc;
	}

	/**
	 * ���̼�¼�����趨
	 * @param prdesc ���̼�¼����
	 */
	public void setPrdesc(String prdesc) {
		this.prdesc = prdesc;
	}

	/**
	 * ���̼�¼����ʱ��ȡ��
	 * @return ���̼�¼����ʱ��
	 */
	public String getPropentime() {
		return propentime;
	}

	/**
	 * ���̼�¼����ʱ���趨
	 * @param propentime ���̼�¼����ʱ��
	 */
	public void setPropentime(String propentime) {
		this.propentime = propentime;
	}

	/**
	 * ���̼�¼�ر�ʱ��ȡ��
	 * @return ���̼�¼�ر�ʱ��
	 */
	public String getPrclosetime() {
		return prclosetime;
	}

	/**
	 * ���̼�¼�ر�ʱ���趨
	 * @param prclosetime ���̼�¼�ر�ʱ��
	 */
	public void setPrclosetime(String prclosetime) {
		this.prclosetime = prclosetime;
	}

	/**
	 * ���̼�¼�ƻ�ִ��ʱ��ȡ��
	 * @return ���̼�¼�ƻ�ִ��ʱ��
	 */
	public String getPrplantime() {
		return prplantime;
	}

	/**
	 * ���̼�¼�ƻ�ִ��ʱ���趨
	 * @param prplantime ���̼�¼�ƻ�ִ��ʱ��
	 */
	public void setPrplantime(String prplantime) {
		this.prplantime = prplantime;
	}

	/**
	 * ���̼�¼�ƻ�ִ������ȡ��
	 * @return ���̼�¼�ƻ�ִ������
	 */
	public String getPrduration() {
		return prduration;
	}

	/**
	 * ���̼�¼�ƻ�ִ�������趨
	 * @param prduration ���̼�¼�ƻ�ִ������
	 */
	public void setPrduration(String prduration) {
		this.prduration = prduration;
	}

	/**
	 * ���̼�¼�����̶�ȡ��
	 * @return ���̼�¼�����̶�
	 */
	public String getPrurgency() {
		return prurgency;
	}

	/**
	 * ���̼�¼�����̶��趨
	 * @param prurgency ���̼�¼�����̶�
	 */
	public void setPrurgency(String prurgency) {
		this.prurgency = prurgency;
	}

	/**
	 * ���̼�¼Ӱ��̶�ȡ��
	 * @return ���̼�¼Ӱ��̶�
	 */
	public String getPrimpact() {
		return primpact;
	}

	/**
	 * ���̼�¼Ӱ��̶��趨
	 * @param primpact ���̼�¼Ӱ��̶�
	 */
	public void setPrimpact(String primpact) {
		this.primpact = primpact;
	}

	/**
	 * ���̼�¼����ʲ�IDȡ��
	 * @return ���̼�¼����ʲ�ID
	 */
	public Integer getPrassetid() {
		return prassetid;
	}

	/**
	 * ���̼�¼����ʲ�ID�趨
	 * @param prassetid ���̼�¼����ʲ�ID
	 */
	public void setPrassetid(Integer prassetid) {
		this.prassetid = prassetid;
	}

	/**
	 * ���̼�¼����ʲ�����ȡ��
	 * @return ���̼�¼����ʲ�����
	 */
	public String getPrassetname() {
		return prassetname;
	}

	/**
	 * ���̼�¼����ʲ������趨
	 * @param prassetname ���̼�¼����ʲ�����
	 */
	public void setPrassetname(String prassetname) {
		this.prassetname = prassetname;
	}

	/**
	 * ���̼�¼�����ҵ��ȡ��
	 * @return ���̼�¼�����ҵ��
	 */
	public String getPrbusiness() {
		return prbusiness;
	}

	/**
	 * ���̼�¼�����ҵ���趨
	 * @param prbusiness ���̼�¼�����ҵ��
	 */
	public void setPrbusiness(String prbusiness) {
		this.prbusiness = prbusiness;
	}

	/**
	 * ���̼�¼ִ�мƻ�ȡ��
	 * @return ���̼�¼ִ�мƻ�
	 */
	public String getPrimplplan() {
		return primplplan;
	}

	/**
	 * ���̼�¼ִ�мƻ��趨
	 * @param primplplan ���̼�¼ִ�мƻ�
	 */
	public void setPrimplplan(String primplplan) {
		this.primplplan = primplplan;
	}

	/**
	 * ���̼�¼�ָ��ƻ�ȡ��
	 * @return ���̼�¼�ָ��ƻ�
	 */
	public String getPrbackplan() {
		return prbackplan;
	}

	/**
	 * ���̼�¼�ָ��ƻ��趨
	 * @param prbackplan ���̼�¼�ָ��ƻ�
	 */
	public void setPrbackplan(String prbackplan) {
		this.prbackplan = prbackplan;
	}

	/**
	 * ���̼�¼��֤�ƻ�ȡ��
	 * @return ���̼�¼��֤�ƻ�
	 */
	public String getPrvfyplan() {
		return prvfyplan;
	}

	/**
	 * ���̼�¼��֤�ƻ��趨
	 * @param prvfyplan ���̼�¼��֤�ƻ�
	 */
	public void setPrvfyplan(String prvfyplan) {
		this.prvfyplan = prvfyplan;
	}
	
	/**
	 * ���̼�¼�����ĿIDȡ��
	 * @return ���̼�¼�����ĿID
	 */
	public Integer getPid() {
		return pid;
	}

	/**
	 * ���̼�¼�����ĿID�趨
	 * @param pid ���̼�¼�����ĿID
	 */
	public void setPid(Integer pid) {
		this.pid = pid;
	}

	/**
	 * ���̼�¼�����Ŀ���ȡ��
	 * @return ���̼�¼�����Ŀ���
	 */
	public String getPcode() {
		return pcode;
	}

	/**
	 * ���̼�¼�����Ŀ����趨
	 * @param pcode ���̼�¼�����Ŀ���
	 */
	public void setPcode(String pcode) {
		this.pcode = pcode;
	}

	/**
	 * ���̼�¼�����Ŀ����ȡ��
	 * @return ���̼�¼�����Ŀ����
	 */
	public String getPname() {
		return pname;
	}

	/**
	 * ���̼�¼�����Ŀ�����趨
	 * @param pname ���̼�¼�����Ŀ����
	 */
	public void setPname(String pname) {
		this.pname = pname;
	}
	
	/**
	 * ���̼�¼��������ϵ��ʽȡ��
	 * @return ���̼�¼��������ϵ��ʽ
	 */
	public String getPrinfo() {
		return prinfo;
	}

	/**
	 * ���̼�¼��������ϵ��ʽ�趨
	 * @param prinfo ���̼�¼��������ϵ��ʽ
	 */
	public void setPrinfo(String prinfo) {
		this.prinfo = prinfo;
	}

	/**
	 * ���̼�¼�������IDȡ��
	 * @return ���̼�¼�������ID
	 */
	public Integer getPrcorid() {
		return prcorid;
	}

	/**
	 * ���̼�¼�������ID�趨
	 * @param prcorid ���̼�¼�������ID
	 */
	public void setPrcorid(Integer prcorid) {
		this.prcorid = prcorid;
	}

	/**
	 * ���̼�¼�����������ȡ��
	 * @return ���̼�¼�����������
	 */
	public String getPrcortype() {
		return prcortype;
	}

	/**
	 * ���̼�¼������������趨
	 * @param prcortype ���̼�¼�����������
	 */
	public void setPrcortype(String prcortype) {
		this.prcortype = prcortype;
	}

	/**
	 * ���̼�¼�����������ȡ��
	 * @return ���̼�¼�����������
	 */
	public String getPrcortitle() {
		return prcortitle;
	}

	/**
	 * ���̼�¼������������趨
	 * @param prcortitle ���̼�¼�����������
	 */
	public void setPrcortitle(String prcortitle) {
		this.prcortitle = prcortitle;
	}

	/**
	 * ���̼�¼����ʲ�����ȡ��
	 * @return ���̼�¼����ʲ�����
	 */
	public String getPrassetcategory() {
		return prassetcategory;
	}

	/**
	 * ���̼�¼����ʲ������趨
	 * @param prassetcategory ���̼�¼����ʲ�����
	 */
	public void setPrassetcategory(String prassetcategory) {
		this.prassetcategory = prassetcategory;
	}

	/**
	 * ���̼�¼�������û�����ȡ��
	 * @return ���̼�¼�������û�����
	 */
	public String getPrusername() {
		return prusername;
	}

	/**
	 * ���̼�¼�������û������趨
	 * @param prusername ���̼�¼�������û�����
	 */
	public void setPrusername(String prusername) {
		this.prusername = prusername;
	}

	/**
	 * ���̼�¼�����߽�ɫ����ȡ��
	 * @return ���̼�¼�����߽�ɫ����
	 */
	public String getPrrolename() {
		return prrolename;
	}

	/**
	 * ���̼�¼�����߽�ɫ�����趨
	 * @param prrolename ���̼�¼�����߽�ɫ����
	 */
	public void setPrrolename(String prrolename) {
		this.prrolename = prrolename;
	}

	/**
	 * ���̼�¼�������û�IDȡ��
	 * @return ���̼�¼�������û�ID
	 */
	public String getPruserid() {
		return pruserid;
	}

	/**
	 * ���̼�¼�������û�ID�趨
	 * @param pruserid ���̼�¼�������û�ID
	 */
	public void setPruserid(String pruserid) {
		this.pruserid = pruserid;
	}

	/**
	 * ���̼�¼�����߽�ɫIDȡ��
	 * @return ���̼�¼�����߽�ɫID
	 */
	public Integer getPrroleid() {
		return prroleid;
	}

	/**
	 * ���̼�¼�����߽�ɫID�趨
	 * @param prroleid ���̼�¼�����߽�ɫID
	 */
	public void setPrroleid(Integer prroleid) {
		this.prroleid = prroleid;
	}

	/**
	 * ���̼�¼��������IDȡ��
	 * @return ���̼�¼��������ID
	 */
	public String getPrpdid() {
		return prpdid;
	}

	/**
	 * ���̼�¼��������ID�趨
	 * @param prpdid ���̼�¼��������ID
	 */
	public void setPrpdid(String prpdid) {
		this.prpdid = prpdid;
	}

	/**
	 * ���̼�¼������������ȡ��
	 * @return ���̼�¼������������
	 */
	public String getPrpdname() {
		return prpdname;
	}

	/**
	 * ���̼�¼�������������趨
	 * @param prpdname ���̼�¼������������
	 */
	public void setPrpdname(String prpdname) {
		this.prpdname = prpdname;
	}

	/**
	 * ���̼�¼�������������������ȡ��
	 * @return ���̼�¼�������������������
	 */
	public String getProrgid() {
		return prorgid;
	}

	/**
	 * �����̼�¼��������������������趨
	 * @param prorgid ���̼�¼�������������������
	 */
	public void setProrgid(String prorgid) {
		this.prorgid = prorgid;
	}

	/**
	 * ���̼�¼������������������ȡ��
	 * @return ���̼�¼������������������
	 */
	public String getProrgname() {
		return prorgname;
	}

	/**
	 * ���̼�¼�������������������趨
	 * @param prorgname ���̼�¼������������������
	 */
	public void setProrgname(String prorgname) {
		this.prorgname = prorgname;
	}

	/**
	 * ���̼�¼������ȡ��
	 * @return ���̼�¼������
	 */
	public String getPrserialnum() {
		return prserialnum;
	}

	/**
	 * ���̼�¼�������趨
	 * @param prserialnum ���̼�¼������
	 */
	public void setPrserialnum(String prserialnum) {
		this.prserialnum = prserialnum;
	}

	/**
	 * ���̼�¼ʵ�ʽ��ʱ�䣨�ӿ�ʼ��������ȡ��
	 * @return ���̼�¼ʵ�ʽ��ʱ��
	 */
	public Integer getPrfacttime() {
		return prfacttime;
	}

	/**
	 * ���̼�¼ʵ�ʽ��ʱ�䣨�ӿ�ʼ���������趨
	 * @param piid ���̼�¼ʵ�ʽ��ʱ��
	 */
	public void setPrfacttime(Integer prfacttime) {
		this.prfacttime = prfacttime;
	}

	/**
	 * �Զ���������ʱԾǨ����ȡ��
	 * @return �Զ���������ʱԾǨ����
	 */
	public String getPrptdcond() {
		return prptdcond;
	}

	/**
	 * �Զ���������ʱԾǨ�����趨
	 * @param prptdcond �Զ���������ʱԾǨ����
	 */
	public void setPrptdcond(String prptdcond) {
		this.prptdcond = prptdcond;
	}
	
	/**
	 * ��¼ʱ���ȡ��
	 * @return ��¼ʱ���
	 */
	public String getFingerPrint() {
		return fingerPrint;
	}

	/**
	 * ��¼ʱ����趨
	 * @param fingerPrint ��¼ʱ���
	 */
	public void setFingerPrint(String fingerPrint) {
		this.fingerPrint = fingerPrint;
	}
	
	/**
	 * ��ݷ����ʶȡ��
	 * @return ��ݷ����ʶ
	 */
	public String getIsServiceStart() {
		return isServiceStart;
	}

	/**
	 * ��ݷ����ʶ�趨
	 * @param isServiceStart ��ݷ����ʶ
	 */
	public void setIsServiceStart(String isServiceStart) {
		this.isServiceStart = isServiceStart;
	}

	/**
	 * ��������IDȡ��
	 * @return ��������ID
	 */
	public Integer getParprid() {
		return parprid;
	}

	/**
	 * ��������ID�趨
	 * @param parprid ��������ID
	 */
	public void setParprid(Integer parprid) {
		this.parprid = parprid;
	}

	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		this.isFirst = "1";
		ActionErrors errors = new ActionErrors();
		errors = super.validate(mapping, request);
		if (pivarvalue != null) {
			for (int i = 0; i < pivarvalue.length; i++) {
				if (!IGStringUtils.isValidBytes(pivarvalue[i], MAX_BYTE)) {
					errors.add(Globals.ERROR_KEY, new ActionMessage(
							"errors.invalid", pivarlabel[i]+"���ݹ���"));
				}
			}
		}
		request.getSession().setAttribute("IGPRR0101Form", this);
		return errors;
	}

	public void reset(ActionMapping mapping, HttpServletRequest request) {
		super.reset(mapping, request);
		fileMap = new HashMap<Integer, FormFile>();
		fileMapMuti = new HashMap<Integer, FormFile>();
		assign_orgsyscoding = null;
		this.entityMap = new HashMap<Integer, String>();
		this.fileMapTable = new Hashtable<Integer, FormFile>();
	}
	public String[] getAtt() {
		return att;
	}

	public void setAtt(String[] att) {
		this.att = att;
	}

	public Map<Integer, FormFile> getFileMapMuti() {
		return fileMapMuti;
	}

	public void setFileMapMuti(Map<Integer, FormFile> fileMap) {
		this.fileMapMuti = fileMap;
	}
	public FormFile getAttachFileMuti(int index) {
		return (FormFile) fileMapMuti.get(new Integer(index));
	}

	public void setAttachFileMuti(int index, FormFile file) {
		fileMapMuti.put(new Integer(index), file);
	}
	
	public String getDelFileMutiStr() {
		return delFileMutiStr;
	}
	public void setDelFileMutiStr(String delFileMutiStr) {
		this.delFileMutiStr = delFileMutiStr;
	}
	public String getStrpsidid() {
		return strpsidid;
	}

	public void setStrpsidid(String strpsidid) {
		this.strpsidid = strpsidid;
	}
	
	public Integer getRoleid() {
		return roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	public String getPrreport() {
		return null;
	}

	/**
	 * ���̱���ģʽȡ��
	 * 
	 * @return ���̱���ģʽ
	 */
	public String[] getPidmode() {
		return pidmode;
	}

	/**
	 * ���̱���ģʽ�趨
	 * 
	 * @param pidmode ���̱���ģʽ
	 */
	public void setPidmode(String[] pidmode) {
		this.pidmode = pidmode;
	}

	/**
	 * ����˽��Ȩ�޷�Χȡ��
	 * 
	 * @return ����˽��Ȩ�޷�Χ
	 */
	public String[] getPrivatescope() {
		return privatescope;
	}

	/**
	 * ����˽��Ȩ�޷�Χ�趨
	 * 
	 * @param privatescope ����˽��Ȩ�޷�Χ
	 */
	public void setPrivatescope(String[] privatescope) {
		this.privatescope = privatescope;
	}

	public String[] getPivarradio() {
		return pivarradio;
	}

	public void setPivarradio(String[] pivarradio) {
		this.pivarradio = pivarradio;
	}

	public String[] getPivarcheckbox() {
		return pivarcheckbox;
	}

	public void setPivarcheckbox(String[] pivarcheckbox) {
		this.pivarcheckbox = pivarcheckbox;
	}
	
	/**
	 * ������IDȡ��
	 * 
	 * @return ������ID
	 */
	public String[] getParticipants() {
		return participants;
	}

	/**
	 * ������ID�趨
	 * 
	 * @param participants ������ID
	 */
	public void setParticipants(String[] participants) {
		this.participants = participants;
	}
	
	/**
	 * ���첿��ȡ��
	 * 
	 * @return ���첿��
	 */
	public String[] getPpsupers() {
		return ppsupers;
	}

	/**
	 * ���첿���趨
	 * 
	 * @param ppsupers ���첿��
	 */
	public void setPpsupers(String[] ppsupers) {
		this.ppsupers = ppsupers;
	}

	public String prPriority;
	public String getPrPriority() {
		return prPriority;
	}
	public Integer prStrategyVersion;
	
	public Integer getPrStrategyVersion() {
		return prStrategyVersion;
	}
	public void setPrPriority(String prPriority) {
		this.prPriority = prPriority;
	}
	public void setPrStrategyVersion(Integer prStrategyVersion) {
		this.prStrategyVersion = prStrategyVersion;
	}
	/**
	 * ��ȡ�ʲ�
	 * @return ��ȡ�ʲ�
	 */
	public String getEntityId(int index) {
		return (String) entityMap.get(new Integer(index));
	}

	/**
	 * �����ʲ�
	 * @param index �ʲ���������
	 * @param file �ʲ�
	 */
	public void setEntityId(int index, String entityId) {
		entityMap.put(new Integer(index), entityId);
	}

	/**
	 * ��ȡ�ʲ�Map
	 * @return �ʲ�Map
	 */
	public Map<Integer, String> getEntityMap() {
		return entityMap;
	}

	/**
	 * ����ģ��IDȡ��
	 * 
	 * @return ����ģ��ID
	 */
	public Integer getPtid() {
		return ptid;
	}

	/**
	 * ����ģ��ID�趨
	 * 
	 * @param ptid ����ģ��ID
	 */
	public void setPtid(Integer ptid) {
		this.ptid = ptid;
	}

	/**
	 * �ʲ�IDȡ��
	 * 
	 * @return �ʲ�ID
	 */
	public Integer getEiid() {
		return eiid;
	}
	
	/**
	 * �ʲ�ID�趨
	 * 
	 * @param ptid �ʲ�ID
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

	/**
	 * ��չ����ֵȡ��
	 * 
	 * @return ��չ����ֵ
	 */
	public String getParameters() {
		return parameters;
	}
	
	/**
	 * ��չ����ֵ�趨
	 * 
	 * @param parameters ��չ����ֵ
	 */
	public void setParameters(String parameters) {
		this.parameters = parameters;
	}

	/**
	 * �������Ϣ������������ȡ��
	 * @return column_pidid �������Ϣ������������
	 */
	public String[] getColumn_pidid() {
		return column_pidid;
	}

	/**
	 * �������Ϣ�������������趨
	 * @param column_pidid �������Ϣ������������
	 */
	public void setColumn_pidid(String[] column_pidid) {
		this.column_pidid = column_pidid;
	}

	/**
	 * �����ֵ����ȡ��
	 * @return column_value �����ֵ����
	 */
	public String[] getColumn_value() {
		return column_value;
	}

	/**
	 * �����ֵ�����趨
	 * @param column_value �����ֵ����
	 */
	public void setColumn_value(String[] column_value) {
		this.column_value = column_value;
	}

	/**
	 * �����ֵ�кż���ȡ��
	 * @return column_rownumber �����ֵ�кż���
	 */
	public String[] getColumn_rownumber() {
		return column_rownumber;
	}

	/**
	 * �����ֵ�кż����趨
	 * @param column_rownumber �����ֵ�кż���
	 */
	public void setColumn_rownumber(String[] column_rownumber) {
		this.column_rownumber = column_rownumber;
	}
	
	public void setAttachFileTable(int index,FormFile file){
		fileMapTable.put(new Integer(index), file);
	}
	
	public FormFile getAttachFileTable(int index){
		return fileMapTable.get(new Integer(index));
	}

	/**
	 * �������и���ȡ��
	 * @return fileMapTable �������и���
	 */
	public Map<Integer, FormFile> getFileMapTable() {
		return fileMapTable;
	}

	/**
	 * �������и����趨
	 * @param fileMapTable �������и���
	 */
	public void setFileMapTable(Map<Integer, FormFile> fileMapTable) {
		this.fileMapTable = fileMapTable;
	}

	/**
	 * �����������б�ʶȡ��
	 * @return addTableColumnFileStr �����������б�ʶ
	 */
	public String getAddTableColumnFileStr() {
		return addTableColumnFileStr;
	}

	/**
	 * �����������б�ʶ�趨
	 * @param addTableColumnFileStr �����������б�ʶ
	 */
	public void setAddTableColumnFileStr(String addTableColumnFileStr) {
		this.addTableColumnFileStr = addTableColumnFileStr;
	}

	/**
	 *��˵��ȡ��
	 */
	public String[] getPiddesc() {
		return piddesc;
	}

	/**
	 *��˵���趨
	 */
	public void setPiddesc(String[] strings) {
		this.piddesc = strings;
	}
	
	public void setEntityMap(Map<Integer, String> entityMap) {
		this.entityMap = entityMap;
	}

	/**
	 * ���ɲ����߰���������ȡ��
	 * @return ���ɲ����߰���������
	 */
	public String getAssign_orgsyscoding() {
		return assign_orgsyscoding;
	}

	/**
	 * ���ɲ����߰����������趨
	 * @param assign_orgsyscoding ���ɲ����߰���������
	 */
	public void setAssign_orgsyscoding(String assign_orgsyscoding) {
		this.assign_orgsyscoding = assign_orgsyscoding;
	}

	/**
	 * ��Ա���û�IDȡ��
	 * @return par_userid ��Ա���û�ID
	 */
	public String[] getPar_userid() {
		return par_userid;
	}

	/**
	 * ��Ա���û�ID�趨
	 * @param par_userid ��Ա���û�ID
	 */
	public void setPar_userid(String[] par_userid) {
		this.par_userid = par_userid;
	}

	/**
	 * ��Ա���û�����ȡ��
	 * @return par_username ��Ա���û�����
	 */
	public String[] getPar_username() {
		return par_username;
	}

	/**
	 * ��Ա���û������趨
	 * @param par_username ��Ա���û�����
	 */
	public void setPar_username(String[] par_username) {
		this.par_username = par_username;
	}

	/**
	 * ��Ա��������ȡ��
	 * @return par_orgid ��Ա��������
	 */
	public String[] getPar_orgid() {
		return par_orgid;
	}

	/**
	 * ��Ա���������趨
	 * @param par_orgid ��Ա��������
	 */
	public void setPar_orgid(String[] par_orgid) {
		this.par_orgid = par_orgid;
	}

	/**
	 * ��Ա����������ȡ��
	 * @return par_orgname ��Ա����������
	 */
	public String[] getPar_orgname() {
		return par_orgname;
	}

	/**
	 * ��Ա�����������趨
	 * @param par_orgname ��Ա����������
	 */
	public void setPar_orgname(String[] par_orgname) {
		this.par_orgname = par_orgname;
	}

	/**
	 * ��Ա����ɫIDȡ��
	 * @return par_roleid ��Ա����ɫID
	 */
	public Integer[] getPar_roleid() {
		return par_roleid;
	}

	/**
	 * ��Ա����ɫID�趨
	 * @param par_roleid ��Ա����ɫID
	 */
	public void setPar_roleid(Integer[] par_roleid) {
		this.par_roleid = par_roleid;
	}

	/**
	 * ��Ա����ɫ����ȡ��
	 * @return par_rolename ��Ա����ɫ����
	 */
	public String[] getPar_rolename() {
		return par_rolename;
	}

	/**
	 * ��Ա����ɫ�����趨
	 * @param par_rolename ��Ա����ɫ����
	 */
	public void setPar_rolename(String[] par_rolename) {
		this.par_rolename = par_rolename;
	}

	/**
	 * ��Ա��������IDȡ��
	 * @return par_pidid ��Ա��������ID
	 */
	public String[] getPar_pidid() {
		return par_pidid;
	}

	/**
	 * ��Ա��������ID�趨
	 * @param par_pidid ��Ա��������ID
	 */
	public void setPar_pidid(String[] par_pidid) {
		this.par_pidid = par_pidid;
	}

	public String[] getPar_phone() {
		return par_phone;
	}

	public void setPar_phone(String[] par_phone) {
		this.par_phone = par_phone;
	}

	public String getDelTableColumnFileStr() {
		return delTableColumnFileStr;
	}

	public void setDelTableColumnFileStr(String delTableColumnFileStr) {
		this.delTableColumnFileStr = delTableColumnFileStr;
	}

	public String getPieids() {
		return pieids;
	}

	public void setPieids(String pieids) {
		this.pieids = pieids;
	}

	/**
	 * ��תȡ��
	 * @return jump ��ת
	 */
	public String getJump() {
		return jump;
	}

	/**
	 * ��ת�趨
	 * @param jump ��ת
	 */
	public void setJump(String jump) {
		this.jump = jump;
	}

	/**
	 * @return the pjdtype
	 */
	public String getPjdtype() {
		return pjdtype;
	}

	/**
	 * @param pjdtype the pjdtype to set
	 */
	public void setPjdtype(String pjdtype) {
		this.pjdtype = pjdtype;
	}
	
	
	
}

