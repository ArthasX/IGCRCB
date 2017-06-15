/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 * Copyright 2009 Deliverik Co. Ltd.�� All rights reserved.
 */

package com.deliverik.infogovernor.soc.srv.form;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.Globals;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.upload.FormFile;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.workflow.prr.model.IG500Info;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���̹���_����̨_��������_�¼���ݷ���FormBean
 * </p>
 * 
 * @author masai@deliverik.com
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGSRV0217Form extends BaseForm implements IG500Info {

	/** ���񹤵���� */
	protected Integer parprid;
	
	/** �¼���Ŀ */
	protected String prtitle;

	/** �¼����� */
	protected String prdesc;

	/** �¼������� */
	protected String prurgency;

	/** �¼�Ӱ��� */
	protected String primpact;

	/** �¼��ʲ�ID */
	protected Integer prassetid;

	/** �¼���� */
	protected Integer prid;

	/** �������� */
	protected String prtype;

	/** ���������� */
	protected String prsubtype;

	/** �¼�״̬ */
	protected String prstatus;

	/** ������״̬ */
	protected String prsubstatus;

	/** �¼��������� */
	protected String propentime;

	/** �¼��ʲ����� */
	protected String prassetname;

	/** �¼��ָ��ƻ� */
	protected String prbackplan;

	/** �����ֶ� */
	protected String prbusiness;

	/** �¼��ر�ʱ�� */
	protected String prclosetime;

	/** �¼��ƻ�����ʱ�� */
	protected String prduration;

	/** �¼�ִ�мƻ� */
	protected String primplplan;

	/** �¼��ƻ�����ʱ�� */
	protected String prplantime;

	/** �¼���֤�ƻ� */
	protected String prvfyplan;

	/** ��Ŀ��� */
	protected String pcode;

	/** ��ĿID */
	protected Integer pid;

	/** ��Ŀ���� */
	protected String pname;

	/** �¼���������ϵ��ʽ */
	protected String prinfo;

	/** ����¼�ID */
	protected Integer prcorid;

	/** ����¼����� */
	protected String prcortype;

	/** ����¼����� */
	protected String prcortitle;

	/** �ʲ����� */
	protected String prassetcategory;
	
	/** ������ID */
	protected String pruserid;
	
	/** ���������� */
	protected String prusername;
	
	/** �����߽�ɫID */
	protected Integer prroleid;
	
	/** �����߽�ɫ���� */
	protected String prrolename;
	
	/** �����̶���ID */
	protected String prpdid;
	
	/** �����̶������� */
	protected String prpdname;

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
	
	/**���̱�������ID*/
	protected String[] piid;
	
	/** ���̱�������ֵ����ֽ��� */
	private static final int MAX_BYTE = 256;
	
	/**�����־*/
	protected String flag;
	
	/**�����߻���id*/
	protected String prorgid;
	
	/**�����߻�������*/
	protected String prorgname;
	
	/**����������*/
	protected String prt_username;
	
	/**��������ϵ��ʽ*/
	protected String prt_userconnect;
	
	/**������������������*/
	protected String prt_orgname;
	
	/**������������������*/
	protected String prt_orgsyscoding;
	
	/**������ͬ������*/
	protected String prt_pruser;
	
	/**Ӱ��������*/
	protected String aft_username;
	
	/**Ӱ������ϵ��ʽ*/
	protected String aft_userconnect;
	
	/**Ӱ����������������*/
	protected String aft_orgname;
	
	/**Ӱ����������������*/
	protected String aft_orgsyscoding;
	
	/**Ӱ����ͬ������*/
	protected String aft_pruser;
	
	/** �Ƿ��һ�ν���ҳ��*/
	protected String isFirst;

	protected String prserialnum;
	
	protected String[] pivarassetname;
	protected String[] pivarprname;
	protected String[] pivarprjname;
	
	public String getPrt_orgsyscoding() {
		return prt_orgsyscoding;
	}

	public void setPrt_orgsyscoding(String prt_orgsyscoding) {
		this.prt_orgsyscoding = prt_orgsyscoding;
	}

	public String getAft_orgsyscoding() {
		return aft_orgsyscoding;
	}

	public void setAft_orgsyscoding(String aft_orgsyscoding) {
		this.aft_orgsyscoding = aft_orgsyscoding;
	}

	public String getPrt_username() {
		return prt_username;
	}

	public void setPrt_username(String prt_username) {
		this.prt_username = prt_username;
	}

	public String getPrt_userconnect() {
		return prt_userconnect;
	}

	public void setPrt_userconnect(String prt_userconnect) {
		this.prt_userconnect = prt_userconnect;
	}

	public String getPrt_orgname() {
		return prt_orgname;
	}

	public void setPrt_orgname(String prt_orgname) {
		this.prt_orgname = prt_orgname;
	}

	public String getPrt_pruser() {
		return prt_pruser;
	}

	public void setPrt_pruser(String prt_pruser) {
		this.prt_pruser = prt_pruser;
	}

	public String getAft_username() {
		return aft_username;
	}

	public void setAft_username(String aft_username) {
		this.aft_username = aft_username;
	}

	public String getAft_userconnect() {
		return aft_userconnect;
	}

	public void setAft_userconnect(String aft_userconnect) {
		this.aft_userconnect = aft_userconnect;
	}

	public String getAft_orgname() {
		return aft_orgname;
	}

	public void setAft_orgname(String aft_orgname) {
		this.aft_orgname = aft_orgname;
	}

	public String getAft_pruser() {
		return aft_pruser;
	}

	public void setAft_pruser(String aft_pruser) {
		this.aft_pruser = aft_pruser;
	}

	public void setFileMap(Map<Integer, FormFile> fileMap) {
		this.fileMap = fileMap;
	}

	public String getPrserialnum() {
		return prserialnum;
	}

	public void setPrserialnum(String prserialnum) {
		this.prserialnum = prserialnum;
	}
	/**
	 * ��ȡ�ʲ�ID
	 * @return �ʲ�ID
	 */
	public Integer getPrassetid() {
		return prassetid;
	}

	/**
	 * �����ʲ�ID
	 * @param prassetid �ʲ�ID
	 */
	public void setPrassetid(Integer prassetid) {
		if (prassetid != null && prassetid.intValue() == 0) {
			this.prassetid = null;
		} else {
			this.prassetid = prassetid;
		}
	}

	/**
	 * ��ȡ���̱��
	 * @return ����ʱ��
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * �������̱��
	 * @param prid ���̱��
	 */
	public void setPrid(Integer prid) {
		if (prid != null && prid.intValue() == 0) {
			this.prid = null;
		} else {
			this.prid = prid;
		}
	}

	/**
	 * ��ȡ��ĿID
	 * @return ��ĿID
	 */
	public Integer getPid() {
		return pid;
	}

	/**
	 * ������ĿID
	 * @param pid ��ĿID
	 */
	public void setPid(Integer pid) {
		if (pid != null && pid.intValue() == 0) {
			this.pid = null;
		} else {
			this.pid = pid;
		}
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
	 * ��ȡ����Map
	 * @return ����Map
	 */
	public Map<Integer, FormFile> getFileMap() {
		return fileMap;
	}

	/**
	 * ��ȡ������̱��
	 * @return ������̱��
	 */
	
	public Integer getPrcorid() {
		return prcorid;
	}

	/**
	 * �������̱��
	 * @param prcorid ���̱��
	 */
	public void setPrcorid(Integer prcorid) {
		if (prcorid != null && prcorid.intValue() == 0) {
			this.prcorid = null;
		} else {
			this.prcorid = prcorid;
		}
	}

	/**
	 * ��ȡ�����߽�ɫID
	 * @return �����߽�ɫID
	 */
	public Integer getPrroleid() {
		return prroleid;
	}

	/**
	 * ���÷����߽�ɫID
	 * @param prroleid �����߽�ɫID
	 */
	public void setPrroleid(Integer prroleid) {
		if (prroleid != null && prroleid.intValue() == 0) {
			this.prroleid = null;
		} else {
			this.prroleid = prroleid;
		}
	}

	/**
	 * ��ȡ�¼���Ŀ
	 * @return �¼���Ŀ
	 */
	public String getPrtitle() {
		return prtitle;
	}

	/**
	 * �����¼���Ŀ
	 * @param prtitle �¼���Ŀ
	 */
	public void setPrtitle(String prtitle) {
		this.prtitle = prtitle;
	}

	/**
	 * ��ȡ�¼�����
	 * @return �¼�����
	 */
	public String getPrdesc() {
		return prdesc;
	}

	/**
	 * �����¼�����
	 * @param prdesc �¼�����
	 */
	public void setPrdesc(String prdesc) {
		this.prdesc = prdesc;
	}

	/**
	 * ��ȡ�¼�������
	 * @return �¼�������
	 */
	public String getPrurgency() {
		return prurgency;
	}

	/**
	 * �����¼�������
	 * @param prurgency �¼�������
	 */
	public void setPrurgency(String prurgency) {
		this.prurgency = prurgency;
	}

	/**
	 * ��ȡ�¼�Ӱ���
	 * @return �¼�Ӱ���
	 */
	public String getPrimpact() {
		return primpact;
	}

	/**
	 * �����¼�Ӱ���
	 * @param primpact �¼�Ӱ���
	 */
	public void setPrimpact(String primpact) {
		this.primpact = primpact;
	}

	/**
	 * ��ȡ��������
	 * @return ��������
	 */
	public String getPrtype() {
		return prtype;
	}

	/**
	 * ������������
	 * @param prtype ��������
	 */
	public void setPrtype(String prtype) {
		this.prtype = prtype;
	}

	/**
	 * ��ȡ����������
	 * @return ����������
	 */
	public String getPrsubtype() {
		return prsubtype;
	}

	/**
	 * ��������������
	 * @param prsubtype ����������
	 */
	public void setPrsubtype(String prsubtype) {
		this.prsubtype = prsubtype;
	}

	/**
	 * ��ȡ�¼�״̬
	 * @return �¼�״̬
	 */
	public String getPrstatus() {
		return prstatus;
	}

	/**
	 * �����¼�״̬
	 * @param prstatus �¼�״̬
	 */
	public void setPrstatus(String prstatus) {
		this.prstatus = prstatus;
	}

	/**
	 * ��ȡ������״̬
	 * @return ������״̬
	 */
	public String getPrsubstatus() {
		return prsubstatus;
	}

	/**
	 * ����������״̬
	 * @param prsubstatus ������״̬
	 */
	public void setPrsubstatus(String prsubstatus) {
		this.prsubstatus = prsubstatus;
	}

	/**
	 * ��ȡ�¼���������
	 * @return �¼���������
	 */
	public String getPropentime() {
		return propentime;
	}

	/**
	 * �����¼���������
	 * @param propentime �¼���������
	 */
	public void setPropentime(String propentime) {
		this.propentime = propentime;
	}

	/**
	 * ��ȡ�¼��ʲ�����
	 * @return �¼��ʲ�����
	 */
	public String getPrassetname() {
		return prassetname;
	}

	/**
	 * �����¼��ʲ�����
	 * @param prassetname �¼��ʲ�����
	 */
	public void setPrassetname(String prassetname) {
		this.prassetname = prassetname;
	}

	/**
	 * ��ȡ�¼��ָ��ƻ�
	 * @return �¼��ָ��ƻ�
	 */
	public String getPrbackplan() {
		return prbackplan;
	}

	/**
	 * �����¼��ָ��ƻ�
	 * @param prbackplan �¼��ָ��ƻ�
	 */
	public void setPrbackplan(String prbackplan) {
		this.prbackplan = prbackplan;
	}

	/**
	 * ��ȡ�����ֶ�
	 * @return �����ֶ�
	 */
	public String getPrbusiness() {
		return prbusiness;
	}

	/**
	 * ���ñ����ֶ�
	 * @param prbusiness �����ֶ�
	 */
	public void setPrbusiness(String prbusiness) {
		this.prbusiness = prbusiness;
	}

	/**
	 * ��ȡ�¼��ر�ʱ��
	 * @return �¼��ر�ʱ��
	 */
	public String getPrclosetime() {
		return prclosetime;
	}

	/**
	 * �����¼��ر�ʱ��
	 * @param prclosetime �¼��ر�ʱ��
	 */
	public void setPrclosetime(String prclosetime) {
		this.prclosetime = prclosetime;
	}

	/**
	 * ��ȡ�¼��ƻ�����ʱ��
	 * @return �¼��ƻ�����ʱ��
	 */
	public String getPrduration() {
		return prduration;
	}

	/**
	 * �����¼��ƻ�����ʱ��
	 * @param prduration �¼��ƻ�����ʱ��
	 */
	public void setPrduration(String prduration) {
		this.prduration = prduration;
	}

	/**
	 * ��ȡ�¼�ִ�мƻ�
	 * @return �¼�ִ�мƻ�
	 */
	public String getPrimplplan() {
		return primplplan;
	}

	/**
	 * �����¼�ִ�мƻ�
	 * @param primplplan �¼�ִ�мƻ�
	 */
	public void setPrimplplan(String primplplan) {
		this.primplplan = primplplan;
	}

	/**
	 * ��ȡ�¼��ƻ�����ʱ��
	 * @return �¼��ƻ�����ʱ��
	 */
	public String getPrplantime() {
		return prplantime;
	}

	/**
	 * �����¼��ƻ�����ʱ��
	 * @param prplantime �¼��ƻ�����ʱ��
	 */
	public void setPrplantime(String prplantime) {
		this.prplantime = prplantime;
	}

	/**
	 * ��ȡ�¼���֤�ƻ�
	 * @return �¼���֤�ƻ�
	 */
	public String getPrvfyplan() {
		return prvfyplan;
	}

	/**
	 * �����¼���֤�ƻ�
	 * @param prvfyplan �¼���֤�ƻ�
	 */
	public void setPrvfyplan(String prvfyplan) {
		this.prvfyplan = prvfyplan;
	}

	/**
	 * ��ȡ��Ŀ���
	 * @return ��Ŀ���
	 */
	public String getPcode() {
		return pcode;
	}

	/**
	 * ������Ŀ���
	 * @param pcode ��Ŀ���
	 */
	public void setPcode(String pcode) {
		this.pcode = pcode;
	}

	/**
	 * ��ȡ��Ŀ����
	 * @return ��Ŀ����
	 */
	public String getPname() {
		return pname;
	}

	/**
	 * ������Ŀ����
	 * @param pname ��Ŀ����
	 */
	public void setPname(String pname) {
		this.pname = pname;
	}

	/**
	 * ��ȡ�¼���������ϵ��ʽ
	 * @return �¼���������ϵ��ʽ
	 */
	public String getPrinfo() {
		return prinfo;
	}

	/**
	 * �����¼���������ϵ��ʽ
	 * @param prinfo �¼���������ϵ��ʽ
	 */
	public void setPrinfo(String prinfo) {
		this.prinfo = prinfo;
	}

	/**
	 * ��ȡ����¼�����
	 * @return ����¼�����
	 */
	public String getPrcortype() {
		return prcortype;
	}

	/**
	 * ��������¼�����
	 * @param prcortype ����¼�����
	 */
	public void setPrcortype(String prcortype) {
		this.prcortype = prcortype;
	}

	/**
	 * ��ȡ����¼�����
	 * @return ����¼�����
	 */
	public String getPrcortitle() {
		return prcortitle;
	}

	/**
	 * ��������¼�����
	 * @param prcortitle ����¼�����
	 */
	public void setPrcortitle(String prcortitle) {
		this.prcortitle = prcortitle;
	}

	/**
	 * ��ȡ�ʲ�����
	 * @return �ʲ�����
	 */
	public String getPrassetcategory() {
		return prassetcategory;
	}

	/**
	 * �����ʲ�����
	 * @param prassetcategory �ʲ�����
	 */
	public void setPrassetcategory(String prassetcategory) {
		this.prassetcategory = prassetcategory;
	}

	/**
	 * ��ȡ������ID
	 * @return ������ID
	 */
	public String getPruserid() {
		return pruserid;
	}

	/**
	 * ���÷�����ID
	 * @param pruserid ������ID
	 */
	public void setPruserid(String pruserid) {
		this.pruserid = pruserid;
	}

	/**
	 * ��ȡ����������
	 * @return ����������
	 */
	public String getPrusername() {
		return prusername;
	}

	/**
	 * ���÷���������
	 * @param prusername ����������
	 */
	public void setPrusername(String prusername) {
		this.prusername = prusername;
	}

	/**
	 * ��ȡ�����߽�ɫ����
	 * @return �����߽�ɫ����
	 */
	public String getPrrolename() {
		return prrolename;
	}

	/**
	 * ���÷����߽�ɫ����
	 * @param prrolename �����߽�ɫ����
	 */
	public void setPrrolename(String prrolename) {
		this.prrolename = prrolename;
	}

	/**
	 * ��ȡ�����̶���ID
	 * @return �����̶���ID
	 */
	public String getPrpdid() {
		if(prpdid !=null){
			return null;
		}else{
			return prpdid;
		}
	}

	/**
	 * ���������̶���ID
	 * @param prpdid �����̶���ID
	 */
	public void setPrpdid(String prpdid) {
		this.prpdid = prpdid;
	}

	/**
	 * ��ȡ�����̶�������
	 * @return �����̶�������
	 */
	public String getPrpdname() {
		return prpdname;
	}

	/**
	 * ���������̶�������
	 * @param prpdname �����̶�������
	 */
	public void setPrpdname(String prpdname) {
		this.prpdname = prpdname;
	}

	/**
	 * ��ȡ���̱�������ֵ
	 * @return ���̱�������ֵ
	 */
	public String[] getPivarvalue() {
		return pivarvalue;
	}

	/**
	 * �������̱�������ֵ
	 * @param pivarvalue ���̱�������ֵ
	 */
	public void setPivarvalue(String[] pivarvalue) {
		this.pivarvalue = pivarvalue;
	}

	/**
	 * ��ȡ���̱���������ʶ
	 * @return ���̱���������ʶ
	 */
	public String[] getPivarname() {
		return pivarname;
	}

	/**
	 * �������̱���������ʶ
	 * @param pivarname ���̱���������ʶ
	 */
	public void setPivarname(String[] pivarname) {
		this.pivarname = pivarname;
	}

	/**
	 * ��ȡ���̱�����������
	 * @return ���̱�����������
	 */
	public String[] getPivarlabel() {
		return pivarlabel;
	}

	/**
	 * �������̱�����������
	 * @param pivarlabel ���̱�����������
	 */
	public void setPivarlabel(String[] pivarlabel) {
		this.pivarlabel = pivarlabel;
	}

	/**
	 * ��ȡ���̱�����������
	 * @return ���̱�����������
	 */
	public String[] getPivartype() {
		return pivartype;
	}

	/**
	 * �������̱�����������
	 * @param pivartype ���̱�����������
	 */
	public void setPivartype(String[] pivartype) {
		this.pivartype = pivartype;
	}

	/**
	 * ��ȡ���̱�������ID
	 * @return ���̱�������ID
	 */
	public String[] getPiid() {
		return piid;
	}

	/**
	 * �������̱�������ID
	 * @param piid ���̱�������ID
	 */
	public void setPiid(String[] piid) {
		this.piid = piid;
	}
	
	/**
	 * ��ȡ�����־
	 * @return �����־
	 */
	public String getFlag() {
		return flag;
	}

	/**
	 * ���ý����־
	 * @param flag �����־
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}
	
	/**
	 * ��ȡ�����߻���id
	 * @return �����߻���id
	 */
	public String getProrgid() {
		return prorgid;
	}

	/**
	 * ���÷����߻���id
	 * @param prorgid �����߻���id
	 */
	public void setProrgid(String prorgid) {
		this.prorgid = prorgid;
	}

	/**
	 * ��ȡ�����߻�������
	 * @return �����߻�������
	 */
	public String getProrgname() {
		return prorgname;
	}

	/**
	 * ���÷����߻�������
	 * @param flag �����߻�������
	 */
	public void setProrgname(String prorgname) {
		this.prorgname = prorgname;
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
				}
			}
		}
		request.getSession().setAttribute("IGSVC0217Form", this);
		return errors;
	}

	public Integer getPrfacttime() {
		return null;
	}
	
	protected String fingerPrint;

	public String getFingerPrint() {
		return fingerPrint;
	}

	public void setFingerPrint(String fingerPrint) {
		this.fingerPrint = fingerPrint;
	}
	
	@Override
	public void reset(ActionMapping mapping,HttpServletRequest request){
		super.reset(mapping, request);
		this.fileMap = new HashMap<Integer, FormFile>();
	}

	public String getPrptdcond() {
		return null;
	}
	
	public String getIsFirst() {
		return isFirst;
	}

	public void setIsFirst(String isFirst) {
		this.isFirst = isFirst;
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

	public Integer getParprid() {
		return parprid;
	}

	public void setParprid(Integer parprid) {
		this.parprid = parprid;
	}

	public String getGeneralname() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getGeneralvalue() {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getPidgid() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Jsdoc)
	 * override
	 */
	public Integer getPrStrategyVersion() {
		//
		return null;
	}

	/* (non-Jsdoc)
	 * override
	 */
	public String getPrPriority() {
		//
		return null;
	}
	
}
