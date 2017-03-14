/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.prr.form;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
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
 * @Description: ���̴���Form
 * @Author  
 * @History 2010-9-13     �½� 
 * 			2013-02-27	  �޸�	130225	����֧�ַ��ɻ�������޸�
 * @Version V1.0
 */
@SuppressWarnings("serial")
public class IGPRR0102Form extends BaseForm implements IG500Info, WorkFlowParameterInfo {
	
	//====>130225Begin
	/** ״̬ģʽ */
	protected String psdassign;
	
	/** �������������� */
	protected String pporgid;
	
	/** ���ɲ����߰��������� */
	protected String assign_orgsyscoding="";
	
	/**
	 * ��������������ȡ��
	 *
	 * @return pporgid ��������������
	 */
	public String getPporgid() {
		return pporgid;
	}

	/**
	 * ���������������趨
	 *
	 * @param pporgid ��������������
	 */
	public void setPporgid(String pporgid) {
		this.pporgid = pporgid;
	}
	
	/**
	 * ״̬ģʽȡ��
	 *
	 * @return psdassign ״̬ģʽ
	 */
	public String getPsdassign() {
		return psdassign;
	}

	/**
	 * ״̬ģʽ�趨
	 *
	 * @param psdassign ״̬ģʽ
	 */
	public void setPsdassign(String psdassign) {
		this.psdassign = psdassign;
	}
	//====>130225End
	
	//==>����������¶Begin

	/** �ʲ����������˲�ѯ������ */
	protected String eiorgcode;
	
	/**
	 * �ʲ����������˲�ѯ������ȡ��
	 *
	 * @return eiorgcode �ʲ����������˲�ѯ������
	 */
	public String getEiorgcode() {
		return eiorgcode;
	}

	/**
	 * �ʲ����������˲�ѯ�������趨
	 *
	 * @param eiorgcode �ʲ����������˲�ѯ������
	 */
	public void setEiorgcode(String eiorgcode) {
		this.eiorgcode = eiorgcode;
	}
	//==>����������¶End
	/** ��չ����ֵ */
	protected String parameters;
	
	/** ����ID */
	protected Integer prid;
	
	/** �Ƿ񱨴� */
	protected Integer iserr;

	/** ��־���� */
	protected String log_type;

	/** ���̶���ID */
	protected String pdid;
	
	/** �ʲ�ID */
	protected Integer eiid;
	
	/** ��ɫID */
	protected Integer roleid;
	
	/** ����״̬���� */
	protected String psdcode;
	
	/** ����״̬ID */
	protected String psdid;
	
	/** ���̲�����ID */
	protected String ppdid;
	
	/** ��־��Ϣ */
	protected String rlcomment;
	
	/** �������� */
	protected String pts;
	
	/** �ڵ����� */
	protected String nodetype;
	
	/** ������ʶ ��0010 */
	protected String action;
	
	/** �Ƿ��� 0��1��*/
	protected String isInit;
	
	/** �Ƿ��һ�ν���ҳ��*/
	protected String isFirst;
	
	/** ���� */
	protected Map<Integer, FormFile> fileMap = null;
	
	/**���̱�������ֵ*/
	protected String[] pivarvalue;
	
	/**���̱���������ʶ*/
	protected String[] pivarname;
	
	/**���̱�����������*/
	protected String[] pivarlabel;
	
	/**���̱�����������*/
	protected String[] pivartype;
	
	/**���̱���Ȩ��*/
	protected String[] pidaccess;
	
	/**���̱�������ID*/
	protected String[] piid;
	
	protected String[] pidid;
	
	protected String[] pivarassetname;
	protected String[] pivarprname;
	protected String[] pivarprjname;
	
	/** ���̱�����ѡ */
	protected String[] pivarradio;
	
	/** ���̱�����ѡ */
	protected String[] pivarcheckbox;
	
	/** ���̱����� */
	protected String[] pivartreename;
	
	/** ���̱�������ֵ����ֽ��� */
	private static final int MAX_BYTE = 3000;
	
	/** ������������ */
	protected String processName;
	
	/**�ı��򸽼���*/
	protected Map<Integer, FormFile> fileMapMuti = null;
	
	/** �������и��� */
	protected Map<Integer, FormFile> fileMapTable = null;
	/**�ı��򸽼���map�еĶ�Ӧ�ı������Ƽ�˳��*/
	protected String[] att=new String[]{};
	/**�ı��򸽼���ɾ��*/
	protected String delFileMutiStr;
	
	//------------Ig500--------------
	protected String pporgnamesS;
	protected String ppusernamesS;
	
	protected String ppuseridsS;
	protected String pporgidsS;
	
	protected String rolename;
	protected String prtype;
	protected String prsubtype;
	protected String prstatus;
	protected String prsubstatus;
	protected String prtitle;
	protected String prdesc;
	protected String propentime;
	protected String prclosetime;
	protected String prplantime;
	protected String prduration;
	protected String prurgency;
	protected String primpact;
	protected Integer prassetid;
	protected String prassetname;
	protected String prbusiness;
	protected String primplplan;
	protected String prbackplan;
	protected String prvfyplan;
	protected Integer pid;
	protected String pcode;
	protected String pname;
	protected String prinfo;
	protected Integer prcorid;
	protected String prcortype;
	protected String prcortitle;
	protected String prassetcategory;
	protected String pruserid;
	protected String prusername;
	protected String prrolename;
	protected String prpdid;
	protected String prpdname;
	protected String prorgid;
	protected String prorgname;
	protected String prserialnum;
	protected Integer prfacttime;
	protected String prptdcond;
	protected String fingerPrint;
	/** ��ע */
	protected String[] pidcomment;
	
	/**�����߽�ɫID*/
	protected String[] roleids;

	/**�����߽�ɫ����*/
	protected String[] rolenames;

	/**�������û�ID*/
	protected String[] ppuserids;
	
	/**�������û�����*/
	protected String[] ppusernames;
	
	/**�����߻���ID*/
	protected String[] pporgids;
	
	/**�����߻�������*/
	protected String[] pporgnames;
	
	/** ����ͼXML */
	protected String flowXML;
	
	/** �ɷ��ɽ�ɫ */
	protected String ppsuper;
	
	/** ��ݷ��� */
	protected String isServiceStart;
	
	/** ��������ID */
	protected Integer parprid;
	
	/** ��Ȩ�û�ID */
	protected String paiid;
	
	/** ���̱�����ɫ���� */
	protected String[] pivarrolename;
	
	/** ��ʱ��ɫ������ */
	protected boolean tempRoleManager;
	
	/**ҳ����ת��ʶ*/
	protected String jump;
	
	/** ִ���˸��±�ʶ */
	protected String people_code;
	
	/** ��ɫ�����˱�ʶ */
	protected String psdmode_code;

	/** ���̱���ģʽ */
	protected String[] pidmode;
	
	/** ����˽��Ȩ�޷�Χ */
	protected String[] privatescope;
	
	/** ������ID����ʽ��roleid_userid��*/
	protected String[] participants;
	
	/** ������ID����ʽ��roleid_��*/
	protected String[] participants_;
	
	/** ���첿�� */
	protected String[] ppsupers;
	/** �ʲ� */
	protected Map<Integer, String> entityMap = null;
	
	/** �������ʲ���ϵID�ַ��� */
	protected String pieids;
	
	/** ����ҳ���ʼ��ѡ����Ա��ʶ */
	protected String selected_participants;
	/** �����˱����� */
	protected String cruid;
	/** �������Ƿ�鿴 */
	protected String islook;
	/** ҳ���Ƿ���ʾ�˵��Ͱ�ť	yes����ʾ	no������ʾ */
	protected String pageFlag;
	/** �������Ϣ������������ */
	protected String[] column_pidid;
	/** �����ֵ���� */
	protected String[] column_value;
	/** �����ֵ�кż��� */
	protected String[] column_rownumber; 
	/** �����������б�ʶ */
	protected String addTableColumnFileStr;
	
	/** �������и���ɾ����ʶ */
	protected String delTableColumnFileStr;
	/** ��ʷ����ID */
	protected Integer historyPrid;
	
	/** ���ư�ť��ʾ��ʶ */
	protected String showCopy;
	
	/** �Ƿ���±��ʽ��ֵ */
	protected boolean updateTableValue = true;
	
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
	
	/** ��˵�� */
	protected String[] piddesc;
	
	/** ��Ա���绰 */
	protected String [] par_phone;
	
	/** ���������ID */
	protected String ppidstr;
	
	/**
	 * ��ɫ�����˱�ʶȡ��
	 *
	 * @return psdmode_code ��ɫ�����˱�ʶ
	 */
	public String getPsdmode_code() {
		return psdmode_code;
	}

	/**
	 * ��ɫ�����˱�ʶ�趨
	 *
	 * @param psdmode_code ��ɫ�����˱�ʶ
	 */
	public void setPsdmode_code(String psdmode_code) {
		this.psdmode_code = psdmode_code;
	}

	/**
	 * ִ���˸��±�ʶȡ��
	 *
	 * @return people_code ִ���˸��±�ʶ
	 */
	public String getPeople_code() {
		return people_code;
	}

	/**
	 * ִ���˸��±�ʶ�趨
	 *
	 * @param people_code ִ���˸��±�ʶ
	 */
	public void setPeople_code(String people_code) {
		this.people_code = people_code;
	}

	public String getJump() {
		return jump;
	}

	public void setJump(String jump) {
		this.jump = jump;
	}

	public String[] getPivarrolename() {
		return pivarrolename;
	}

	public void setPivarrolename(String[] pivarrolename) {
		this.pivarrolename = pivarrolename;
	}
	
	
	public String getPaiid() {
		return paiid;
	}

	public void setPaiid(String paiid) {
		this.paiid = paiid;
	}

	public String getIsServiceStart() {
		return isServiceStart;
	}

	public void setIsServiceStart(String isServiceStart) {
		this.isServiceStart = isServiceStart;
	}

	public Integer getParprid() {
		return parprid;
	}

	public void setParprid(Integer parprid) {
		this.parprid = parprid;
	}

	public String getLog_type() {
		return log_type;
	}

	public void setLog_type(String log_type) {
		this.log_type = log_type;
	}

	public Integer getIserr() {
		return iserr;
	}

	public void setIserr(Integer iserr) {
		this.iserr = iserr;
	}
	
	public String getProcessName() {
		return processName;
	}

	public void setProcessName(String processName) {
		this.processName = processName;
	}
	
	
	public String getFingerPrint() {
		return fingerPrint;
	}

	public void setFingerPrint(String fingerPrint) {
		this.fingerPrint = fingerPrint;
	}
	
	public String getPrtype() {
		return prtype;
	}

	public void setPrtype(String prtype) {
		this.prtype = prtype;
	}

	public String getPrsubtype() {
		return prsubtype;
	}

	public void setPrsubtype(String prsubtype) {
		this.prsubtype = prsubtype;
	}

	public String getPrstatus() {
		return prstatus;
	}

	public void setPrstatus(String prstatus) {
		this.prstatus = prstatus;
	}

	public String getPrsubstatus() {
		return prsubstatus;
	}

	public void setPrsubstatus(String prsubstatus) {
		this.prsubstatus = prsubstatus;
	}

	public String getPrtitle() {
		return prtitle;
	}

	public void setPrtitle(String prtitle) {
		this.prtitle = prtitle;
	}

	public String getPrdesc() {
		return prdesc;
	}

	public void setPrdesc(String prdesc) {
		this.prdesc = prdesc;
	}

	public String getPropentime() {
		return propentime;
	}

	public void setPropentime(String propentime) {
		this.propentime = propentime;
	}

	public String getPrclosetime() {
		return prclosetime;
	}

	public void setPrclosetime(String prclosetime) {
		this.prclosetime = prclosetime;
	}

	public String getPrplantime() {
		return prplantime;
	}

	public void setPrplantime(String prplantime) {
		this.prplantime = prplantime;
	}

	public String getPrduration() {
		return prduration;
	}

	public void setPrduration(String prduration) {
		this.prduration = prduration;
	}

	public String getPrurgency() {
		return prurgency;
	}

	public void setPrurgency(String prurgency) {
		this.prurgency = prurgency;
	}

	public String getPrimpact() {
		return primpact;
	}

	public void setPrimpact(String primpact) {
		this.primpact = primpact;
	}

	public Integer getPrassetid() {
		return prassetid;
	}

	public void setPrassetid(Integer prassetid) {
		this.prassetid = prassetid;
	}

	public String getPrassetname() {
		return prassetname;
	}

	public void setPrassetname(String prassetname) {
		this.prassetname = prassetname;
	}

	public String getPrbusiness() {
		return prbusiness;
	}

	public void setPrbusiness(String prbusiness) {
		this.prbusiness = prbusiness;
	}

	public String getPrimplplan() {
		return primplplan;
	}

	public void setPrimplplan(String primplplan) {
		this.primplplan = primplplan;
	}

	public String getPrbackplan() {
		return prbackplan;
	}

	public void setPrbackplan(String prbackplan) {
		this.prbackplan = prbackplan;
	}

	public String getPrvfyplan() {
		return prvfyplan;
	}

	public void setPrvfyplan(String prvfyplan) {
		this.prvfyplan = prvfyplan;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getPcode() {
		return pcode;
	}

	public void setPcode(String pcode) {
		this.pcode = pcode;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPrinfo() {
		return prinfo;
	}

	public void setPrinfo(String prinfo) {
		this.prinfo = prinfo;
	}

	public Integer getPrcorid() {
		return prcorid;
	}

	public void setPrcorid(Integer prcorid) {
		this.prcorid = prcorid;
	}

	public String getPrcortype() {
		return prcortype;
	}

	public void setPrcortype(String prcortype) {
		this.prcortype = prcortype;
	}

	public String getPrcortitle() {
		return prcortitle;
	}

	public void setPrcortitle(String prcortitle) {
		this.prcortitle = prcortitle;
	}

	public String getPrassetcategory() {
		return prassetcategory;
	}

	public void setPrassetcategory(String prassetcategory) {
		this.prassetcategory = prassetcategory;
	}

	public String getPruserid() {
		return pruserid;
	}

	public void setPruserid(String pruserid) {
		this.pruserid = pruserid;
	}

	public String getPrusername() {
		return prusername;
	}

	public void setPrusername(String prusername) {
		this.prusername = prusername;
	}


	public String getPrrolename() {
		return prrolename;
	}

	public void setPrrolename(String prrolename) {
		this.prrolename = prrolename;
	}

	public String getPrpdid() {
		return prpdid;
	}

	public void setPrpdid(String prpdid) {
		this.prpdid = prpdid;
	}

	public String getPrpdname() {
		return prpdname;
	}

	public void setPrpdname(String prpdname) {
		this.prpdname = prpdname;
	}

	public String getProrgid() {
		return prorgid;
	}

	public void setProrgid(String prorgid) {
		this.prorgid = prorgid;
	}

	public String getProrgname() {
		return prorgname;
	}

	public void setProrgname(String prorgname) {
		this.prorgname = prorgname;
	}

	public String getPrserialnum() {
		return prserialnum;
	}

	public void setPrserialnum(String prserialnum) {
		this.prserialnum = prserialnum;
	}

	public Integer getPrfacttime() {
		return prfacttime;
	}

	public void setPrfacttime(Integer prfacttime) {
		this.prfacttime = prfacttime;
	}

	public String getPrptdcond() {
		return prptdcond;
	}

	public void setPrptdcond(String prptdcond) {
		this.prptdcond = prptdcond;
	}

	public String[] getPidid() {
		return pidid;
	}

	public void setPidid(String[] pidid) {
		this.pidid = pidid;
	}

	public Map<Integer, FormFile> getFileMap() {
		return fileMap;
	}

	public void setFileMap(Map<Integer, FormFile> fileMap) {
		this.fileMap = fileMap;
	}

	public String[] getPivarvalue() {
		return pivarvalue;
	}

	public void setPivarvalue(String[] pivarvalue) {
		this.pivarvalue = pivarvalue;
	}

	public String[] getPivarname() {
		return pivarname;
	}

	public void setPivarname(String[] pivarname) {
		this.pivarname = pivarname;
	}

	public String[] getPivarlabel() {
		return pivarlabel;
	}

	public void setPivarlabel(String[] pivarlabel) {
		this.pivarlabel = pivarlabel;
	}

	public String[] getPivartype() {
		return pivartype;
	}

	public void setPivartype(String[] pivartype) {
		this.pivartype = pivartype;
	}

	public String[] getPiid() {
		return piid;
	}

	public void setPiid(String[] piid) {
		this.piid = piid;
	}

	public static int getMAX_BYTE() {
		return MAX_BYTE;
	}

	/**
	 * ���̲�����IDȡ��
	 * 
	 * @return ���̲�����ID
	 */
	public String getPpdid() {
		return ppdid;
	}

	/**
	 * ���̲�����ID�趨
	 *
	 * @param ppdid ���̲�����ID
	 */
	public void setPpdid(String ppdid) {
		this.ppdid = ppdid;
	}

	/**
	 * ����״̬����ȡ��
	 * 
	 * @return ����״̬����
	 */
	public String getPsdcode() {
		return psdcode;
	}

	/**
	 * ����״̬�����趨
	 *
	 * @param roleid ����״̬����
	 */
	public void setPsdcode(String psdcode) {
		this.psdcode = psdcode;
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
	 * ��ɫIDȡ��
	 * 
	 * @return ��ɫID
	 */
	public Integer getRoleid() {
		if(roleid != null && roleid == 0){
			return null;
		}
		return roleid;
	}

	/**
	 * ��ɫID�趨
	 *
	 * @param roleid ��ɫID
	 */
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
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
	 * ����IDȡ��
	 * 
	 * @return ����ID
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * ����ID�趨
	 *
	 * @param prid ����ID
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
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
	 * �Ƿ���ȡ��
	 * @return �Ƿ���
	 */
	public String getIsInit() {
		return isInit;
	}

	/**
	 * �Ƿ����趨
	 * @param isInit �Ƿ���
	 */
	public void setIsInit(String isInit) {
		this.isInit = isInit;
	}
	
	public String getIsFirst() {
		return isFirst;
	}

	public void setIsFirst(String isFirst) {
		this.isFirst = isFirst;
	}

	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();
		errors = super.validate(mapping, request);
		if (pivarvalue != null) {
			for (int i = 0; i < pivarvalue.length; i++) {
				if (!IGStringUtils.isValidBytes(pivarvalue[i], MAX_BYTE)) {
					errors.add(Globals.ERROR_KEY, new ActionMessage(
							"errors.invalid", pivarlabel[i]+"���ݹ���"));
					this.setIserr(1);
				}
			}
		}
		if(fileMap!=null){
			Set<Integer> keySet = fileMap.keySet();
			Iterator<Integer> keyite = keySet.iterator();
			while(keyite.hasNext()){
				Integer key = keyite.next();
				if(fileMap.get(key).getFileSize()>MAX_BYTE*20480){
//					errors.add(Globals.ERROR_KEY, new ActionMessage(
//							"errors.invalid", "������С���ܳ���5M!"));
					errors.add(Globals.ERROR_KEY, new ActionMessage(
							"IGCO10000.E006", "30"));
					this.setIserr(1);
				}
				if("exe".equals(fileMap.get(key).getFileName().split("[.]")[(fileMap.get(key).getFileName().split("[.]").length-1)]) ||
				   "bat".equals(fileMap.get(key).getFileName().split("[.]")[(fileMap.get(key).getFileName().split("[.]").length-1)]) ||
				   "EXE".equals(fileMap.get(key).getFileName().split("[.]")[(fileMap.get(key).getFileName().split("[.]").length-1)]) ||
				   "BAT".equals(fileMap.get(key).getFileName().split("[.]")[(fileMap.get(key).getFileName().split("[.]").length-1)])){
					errors.add(Globals.ERROR_KEY, new ActionMessage(
							"errors.invalid", "�������Ͳ���Ϊexe�ļ���bat�ļ�!"));
					this.setIserr(1);
				}
			}
		}
		if(fileMapMuti!=null){
			Set<Integer> keySet = fileMapMuti.keySet();
			Iterator<Integer> keyite = keySet.iterator();
			
			while(keyite.hasNext()){
				Integer key = keyite.next();
			    if (fileMapMuti.get(key) != null) {
			        if(fileMapMuti.get(key).getFileSize()>MAX_BYTE*20480){
//			            errors.add(Globals.ERROR_KEY, new ActionMessage(
//			                    "errors.invalid", "������С���ܳ���5M!"));
			        	errors.add(Globals.ERROR_KEY, new ActionMessage(
								"IGCO10000.E006", "30"));
			            this.setIserr(1);
			        }
			        if("exe".equals(fileMapMuti.get(key).getFileName().split("[.]")[(fileMapMuti.get(key).getFileName().split("[.]").length-1)]) ||
			                "bat".equals(fileMapMuti.get(key).getFileName().split("[.]")[(fileMapMuti.get(key).getFileName().split("[.]").length-1)]) ||
			                "EXE".equals(fileMapMuti.get(key).getFileName().split("[.]")[(fileMapMuti.get(key).getFileName().split("[.]").length-1)]) ||
			                "BAT".equals(fileMapMuti.get(key).getFileName().split("[.]")[(fileMapMuti.get(key).getFileName().split("[.]").length-1)])){
			            errors.add(Globals.ERROR_KEY, new ActionMessage(
			                    "errors.invalid", "�������Ͳ���Ϊexe�ļ���bat�ļ�!"));
			            this.setIserr(1);
			        }
			    }
			}
		}
		request.getSession().setAttribute("IGPRR0102Form", this);
		return errors;
	}

	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		// TODO Auto-generated method stub
		super.reset(mapping, request);
		if(!"assign".equals(isInit)) {
			fileMap = new HashMap<Integer, FormFile>();
			isInit = null;
//			pivarname = null;
//			pivarlabel = null;
//			pivartype = null;
//			pidaccess = null;
			piid = null;
			pidid = null;
//			rlcomment = null;
			people_code = null;
			psdmode_code = null;
		}
		this.assign_orgsyscoding = null;
		this.roleids = null;
		this.rolenames = null;
		this.ppuserids = null;
		this.ppusernames = null;
		this.pporgids = null;
		this.pporgnames = null;
		this.participants = null;
		this.participants_ = null;
		if(this.iserr==null){
			this.iserr=0;
		}
		fileMapMuti = new HashMap<Integer, FormFile>();
		this.entityMap = new HashMap<Integer, String>();
		this.fileMapTable = new HashMap<Integer, FormFile>();
	}

	public String[] getPivarassetname() {
		return pivarassetname;
	}

	public void setPivarassetname(String[] pivarassetname) {
		this.pivarassetname = pivarassetname;
	}

	public String[] getPivarprname() {
		return pivarprname;
	}

	public void setPivarprname(String[] pivarprname) {
		this.pivarprname = pivarprname;
	}

	public String[] getPivarprjname() {
		return pivarprjname;
	}

	public void setPivarprjname(String[] pivarprjname) {
		this.pivarprjname = pivarprjname;
	}

	/**
	 * ��ȡ�����߻���ID
	 * @return �����߻���ID
	 */
	public String[] getPporgids() {
		return pporgids;
	}
	
	/**
	 * ���ò����߻���ID
	 * @param pporgids �����߻���ID
	 */
	public void setPporgids(String[] pporgids) {
		this.pporgids = pporgids;
	}
	
	/**
	 * ��ȡ�����߻�������
	 * @return �����߻�������
	 */
	public String[] getPporgnames() {
		return pporgnames;
	}
	
	/**
	 * ���ò����߻�������
	 * @param pporgnames �����߻�������
	 */
	public void setPporgnames(String[] pporgnames) {
		this.pporgnames = pporgnames;
	}
	
	/**
	 * ��ȡ�����߽�ɫID
	 * @return �����߽�ɫID
	 */
	public String[] getRoleids() {
		return roleids;
	}

	/**
	 * ���ò����߽�ɫID
	 * @param roleids �����߽�ɫID
	 */
	public void setRoleids(String[] roleids) {
		this.roleids = roleids;
	}

	/**
	 * ��ȡ�����߽�ɫ����
	 * @return �����߽�ɫ����
	 */
	public String[] getRolenames() {
		return rolenames;
	}

	/**
	 * ���ò����߽�ɫ����
	 * @param rolenames �����߽�ɫ����
	 */
	public void setRolenames(String[] rolenames) {
		this.rolenames = rolenames;
	}

	/**
	 * ��ȡ�������û�ID
	 * @return �������û�ID
	 */
	public String[] getPpuserids() {
		return ppuserids;
	}

	/**
	 * ���ò������û�ID
	 * @param ppuserids �������û�ID
	 */
	public void setPpuserids(String[] ppuserids) {
		this.ppuserids = ppuserids;
	}

	/**
	 * ��ȡ�������û�����
	 * @return �������û�����
	 */
	public String[] getPpusernames() {
		return ppusernames;
	}

	/**
	 * ���ò������û�����
	 * @param ppusernames �������û�����
	 */
	public void setPpusernames(String[] ppusernames) {
		this.ppusernames = ppusernames;
	}

	public String getPts() {
		return pts;
	}

	public void setPts(String pts) {
		this.pts = pts;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	/**
	 * ����ͼXMLȡ��
	 * @return ����ͼXML
	 */
	public String getFlowXML() {
		return flowXML;
	}

	/**
	 * ����ͼXML�趨
	 * @param flowXML ����ͼXML
	 */
	public void setFlowXML(String flowXML) {
		this.flowXML = flowXML;
	}

	public String getNodetype() {
		return nodetype;
	}

	public void setNodetype(String nodetype) {
		this.nodetype = nodetype;
	}

	public String getPporgnamesS() {
		return pporgnamesS;
	}

	public void setPporgnamesS(String pporgnamesS) {
		this.pporgnamesS = pporgnamesS;
	}

	public String getPpusernamesS() {
		return ppusernamesS;
	}

	public void setPpusernamesS(String ppusernamesS) {
		this.ppusernamesS = ppusernamesS;
	}

	public String getPpuseridsS() {
		return ppuseridsS;
	}

	public void setPpuseridsS(String ppuseridsS) {
		this.ppuseridsS = ppuseridsS;
	}

	public String getPporgidsS() {
		return pporgidsS;
	}

	public void setPporgidsS(String pporgidsS) {
		this.pporgidsS = pporgidsS;
	}

	/**
	 * �ɷ��ɽ�ɫȡ��
	 * @return �ɷ��ɽ�ɫ
	 */
	public String getPpsuper() {
		return ppsuper;
	}

	/**
	 * �ɷ��ɽ�ɫ�趨
	 * @param ppsuper�ɷ��ɽ�ɫ
	 */
	public void setPpsuper(String ppsuper) {
		this.ppsuper = ppsuper;
	}
	
	/**
	 * ��ʱ��ɫ������ȡ��
	 * @return ��ʱ��ɫ������
	 */
	public boolean isTempRoleManager() {
		return tempRoleManager;
	}

	/**
	 * ��ʱ��ɫ�������趨
	 * @param tempRoleManager��ʱ��ɫ������
	 */
	public void setTempRoleManager(boolean tempRoleManager) {
		this.tempRoleManager = tempRoleManager;
	}
	public Map<Integer, FormFile> getFileMapMuti() {
		return fileMapMuti;
	}

	public void setFileMapMuti(Map<Integer, FormFile> fileMapMuti) {
		this.fileMapMuti = fileMapMuti;
	}

	public String[] getAtt() {
		return att;
	}

	public void setAtt(String[] att) {
		this.att = att;
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

	public String[] getPivartreename() {
		return pivartreename;
	}

	public void setPivartreename(String[] pivartreename) {
		this.pivartreename = pivartreename;
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
	 * �������ʲ���ϵID�ַ���ȡ��
	 * @return �������ʲ���ϵID�ַ���
	 */
	public String getPieids() {
		return pieids;
	}

	/**
	 * �������ʲ���ϵID�ַ����趨
	 * @param pieids �������ʲ���ϵID�ַ���
	 */
	public void setPieids(String pieids) {
		this.pieids = pieids;
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
	 * ����ҳ���ʼ��ѡ����Ա��ʶȡ��
	 * 
	 * @return ����ҳ���ʼ��ѡ����Ա��ʶ
	 */
	public String getSelected_participants() {
		return selected_participants;
	}

	/**
	 * ����ҳ���ʼ��ѡ����Ա��ʶ�趨
	 * 
	 * @param selected_participants ����ҳ���ʼ��ѡ����Ա��ʶ
	 */
	public void setSelected_participants(String selected_participants) {
		this.selected_participants = selected_participants;
	}

	/**
	 * ������IDȡ��
	 * 
	 * @return ������IDȡ��
	 */
	public String[] getParticipants_() {
		return participants_;
	}

	/**
	 * ������ID�趨
	 * 
	 * @param participants_ ������ID
	 */
	public void setParticipants_(String[] participants_) {
		this.participants_ = participants_;
	}

	

	public String getCruid() {
		return cruid;
	}

	public void setCruid(String cruid) {
		this.cruid = cruid;
	}

	public String getIslook() {
		return islook;
	}

	public void setIslook(String islook) {
		this.islook = islook;
	}
	/** ҳ���Ƿ���ʾ�˵��Ͱ�ť	yes����ʾ	no������ʾ */
	public String getPageFlag() {
		return pageFlag;
	}
	/** ҳ���Ƿ���ʾ�˵��Ͱ�ť	yes����ʾ	no������ʾ */
	public void setPageFlag(String pageFlag) {
		this.pageFlag = pageFlag;
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

	/**
	 * �������и���ȡ��
	 * @return fileMapTable �������и���
	 */
	public Map<Integer, FormFile> getFileMapTable() {
		return fileMapTable;
	}
	
	public void setAttachFileTable(int index,FormFile file){
		fileMapTable.put(new Integer(index), file);
	}
	
	public FormFile getAttachFileTable(int index){
		return fileMapTable.get(new Integer(index));
	}

	/**
	 * �������и����趨
	 * @param fileMapTable �������и���
	 */
	public void setFileMapTable(Map<Integer, FormFile> fileMapTable) {
		this.fileMapTable = fileMapTable;
	}

	/**
	 * �ʲ��趨
	 * @param entityMap �ʲ�
	 */
	public void setEntityMap(Map<Integer, String> entityMap) {
		this.entityMap = entityMap;
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
	 * �������и���ɾ����ʶȡ��
	 * @return delTableColumnFileStr �������и���ɾ����ʶ
	 */
	public String getDelTableColumnFileStr() {
		return delTableColumnFileStr;
	}

	/**
	 * �������и���ɾ����ʶ�趨
	 * @param delTableColumnFileStr �������и���ɾ����ʶ
	 */
	public void setDelTableColumnFileStr(String delTableColumnFileStr) {
		this.delTableColumnFileStr = delTableColumnFileStr;
	}
	
	/**
	 * ��ʷ����IDȡ��
	 * @return historyPrid ��ʷ����ID
	 */
	public Integer getHistoryPrid() {
		return historyPrid;
	}

	/**
	 * ��ʷ����ID�趨
	 * @param historyPrid ��ʷ����ID
	 */
	public void setHistoryPrid(Integer historyPrid) {
		this.historyPrid = historyPrid;
	}

	/**
	 * ���ư�ť��ʾ��ʶȡ��
	 * @return showCopy ���ư�ť��ʾ��ʶ
	 */
	public String getShowCopy() {
		return showCopy;
	}

	/**
	 * ���ư�ť��ʾ��ʶ�趨
	 * @param showCopy ���ư�ť��ʾ��ʶ
	 */
	public void setShowCopy(String showCopy) {
		this.showCopy = showCopy;
	}

	/**
	 * �Ƿ���±��ʽ��ֵȡ��
	 * @return updateTableValue �Ƿ���±��ʽ��ֵ
	 */
	public boolean isUpdateTableValue() {
		return updateTableValue;
	}

	/**
	 * �Ƿ���±��ʽ��ֵ�趨
	 * @param updateTableValue �Ƿ���±��ʽ��ֵ
	 */
	public void setUpdateTableValue(boolean updateTableValue) {
		this.updateTableValue = updateTableValue;
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

	/**
	 * maxByteȡ��
	 * @return maxByte maxByte
	 */
	public static int getMaxByte() {
		return MAX_BYTE;
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
	
	/**
	 * ���������IDȡ��
	 * @return ���������ID
	 */
	public String getPpidstr() {
		return ppidstr;
	}

	/**
	 * ���������ID�趨
	 * @param ppidstr ���������ID
	 */
	public void setPpidstr(String ppidstr) {
		this.ppidstr = ppidstr;
	}
	
	/**
	 * ���������IDȡ��
	 * @return ���������ID
	 */
	public Integer getPpid() {
		if(StringUtils.isEmpty(getPpidstr())) {
			return null;
		} else {
			return new Integer(getPpidstr().split("_")[0]);
		}
	}

	public void clear() {
		this.setParameters(null);
		this.setIserr(null);
		this.setLog_type(null);
		this.setPdid(null);
		this.setEiid(null);
		this.setRoleid(null);
		this.setPsdcode(null);
		this.setPsdid(null);
		this.setPpdid(null);
		this.setRlcomment(null);
		this.setPts(null);
		this.setNodetype(null);
		this.setAction(null);
		this.setIsInit(null);
		this.setIsFirst(null);
		this.setFileMap(null);
		this.setPivarvalue(null);
		this.setPivarname(null);
		this.setPivarlabel(null);
		this.setPivartype(null);
		this.setPidaccess(null);
		this.setPiid(null);
		this.setPidid(null);
		this.setPivarassetname(null);
		this.setPivarprname(null);
		this.setPivarprjname(null);
		this.setPivarradio(null);
		this.setPivarcheckbox(null);
		this.setPivartreename(null);
		this.setProcessName(null);
		this.setFileMapMuti(null);
		this.setFileMapTable(null);
		this.setAtt(null);
		this.setDelFileMutiStr(null);
		this.setPporgnamesS(null);
		this.setPpusernamesS(null);
		this.setPpuseridsS(null);
		this.setPporgidsS(null);
		this.setRolename(null);
		this.setPrtype(null);
		this.setPrsubtype(null);
		this.setPrstatus(null);
		this.setPrsubstatus(null);
		this.setPrtitle(null);
		this.setPrdesc(null);
		this.setPropentime(null);
		this.setPrclosetime(null);
		this.setPrplantime(null);
		this.setPrduration(null);
		this.setPrurgency(null);
		this.setPrimpact(null);
		this.setPrassetid(null);
		this.setPrassetname(null);
		this.setPrbusiness(null);
		this.setPrimplplan(null);
		this.setPrbackplan(null);
		this.setPrvfyplan(null);
		this.setPid(null);
		this.setPcode(null);
		this.setPname(null);
		this.setPrinfo(null);
		this.setPrcorid(null);
		this.setPrcortype(null);
		this.setPrcortitle(null);
		this.setPrassetcategory(null);
		this.setPruserid(null);
		this.setPrusername(null);
		this.setPrroleid(null);
		this.setPpidstr(null);
		this.setPrrolename(null);
		this.setPrpdid(null);
		this.setPrpdname(null);
		this.setProrgid(null);
		this.setProrgname(null);
		this.setPrserialnum(null);
		this.setPrfacttime(null);
		this.setPrptdcond(null);
		this.setFingerPrint(null);
		this.setPidcomment(null);
		this.setPporgnames(null);
		this.setFlowXML(null);
		this.setPpsuper(null);
		this.setIsServiceStart(null);
		this.setParprid(null);
		this.setPaiid(null);
		this.setPivarrolename(null);
		this.setTempRoleManager(false);
		this.setPeople_code(null);
		this.setPsdmode_code(null);
		this.setPidmode(null);
		this.setPrivatescope(null);
		this.setParticipants(null);
		this.setParticipants_(null);
		this.setPpsupers(null);
		this.setEntityMap(null);
		this.setPieids(null);
		this.setSelected_participants(null);
		this.setCruid(null);
		this.setIslook(null);
		this.setPageFlag(null);
		this.setColumn_pidid(null);
		this.setColumn_value(null);
		this.setColumn_rownumber(null);
		this.setAddTableColumnFileStr(null);
		this.setDelTableColumnFileStr(null);
		this.setHistoryPrid(null);
		this.setShowCopy(null);
		this.setUpdateTableValue(true);
		this.setPar_userid(null);
		this.setPar_username(null);
		this.setPar_orgid(null);
		this.setPar_orgname(null);
		this.setPar_roleid(null);
		this.setPar_rolename(null);
		this.setPar_pidid(null);
		this.setPiddesc(null);
	}

	protected Integer prroleid;
	public void setPrroleid(Integer prroleid) {
		this.prroleid = prroleid;
	}
	//������ҳ�Ĵ����ɫ�����б��ύʱ��ȡ,����ȡprroleid
	public Integer getPrroleid() {
		if(StringUtils.isEmpty(getPpidstr())) {
			return this.prroleid;
		} else {
			return new Integer(getPpidstr().split("_")[1]);
		}
	}
}
