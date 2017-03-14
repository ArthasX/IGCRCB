package com.deliverik.infogovernor.ven.form;

import com.deliverik.framework.base.BaseForm;


/**
 * ���ռ��FORM
 * 
 */
@SuppressWarnings("serial")
public class IGVEN0202Form extends BaseForm {
	
	/** ���ռ������id */
	protected Integer rmid;
	
	/** ָ������  */	
	protected String einame;
	
	/** ָ����  */	
	protected String eilabel;

	/**
	 * ���ռ������idȡ��
	 * @return rmid  ���ռ������id
	 */
	public Integer getRmid() {
		return rmid;
	}

	/**
	 * ���ռ������id�趨
	 * @param rmid  ���ռ������id
	 */
	public void setRmid(Integer rmid) {
		this.rmid = rmid;
	}

	/**
	 * ָ������ȡ��
	 * @return einame  ָ������
	 */
	public String getEiname() {
		return einame;
	}

	/**
	 * ָ�������趨
	 * @param einame  ָ������
	 */
	public void setEiname(String einame) {
		this.einame = einame;
	}

	/**
	 * ָ����ȡ��
	 * @return eilabel  ָ����
	 */
	public String getEilabel() {
		return eilabel;
	}

	/**
	 * ָ�����趨
	 * @param eilabel  ָ����
	 */
	public void setEilabel(String eilabel) {
		this.eilabel = eilabel;
	}
	

	

	
//	/** ���ռ��ID */
//	protected Integer rcid;
//	
//	/** �������id*/
//	protected Integer cwrid;
//	
//	/** ������id*/
//	protected Integer csid;
//	
//	protected String eiids;
//	
//	protected String eiversions;
//	
//	protected String einames;
//	
//	protected String riskitem;
//	
//	protected String eidesc;
//	
//	protected String eistatus;
//	
//	protected String rcommon;
//	
//	/** ���ռ������ */
//	protected String rcname;
//	
//	/** ���ռ�鷽��˵�� */
//	protected String rcdesc;
//	
//	/** ���ռ�鷽�� */
//	protected String rccommon;
//	
//	/** ���ռ����Ҫ�̶� */
//	protected String rctype;
//	
//	/** ���ռ��״̬ */
//	protected String rcstatus;
//	
//	/** ���ռ����ʼ���� */
//	protected String rcstartdate;
//	
//	/** ���ռ��������� */
//	protected String rcenddate;
//	
//	/** ���ռ��Ƶ�� */
//	protected String rcfrequency;
//	
//	/** ���ռ��Ƶ������ */
//	protected String rcfrequencydesc;
//	
//	/** ���ռ��Ƶ��(��) */
//	protected String[] rcfrequencyweek;
//	
//	/** ���ռ��Ƶ��(��) */
//	protected String[] rcfrequencymonth;
//	
//	/** ���ռ��Ƶ��(ÿ�����һ��) */
//	protected String rcfrequencymonthlastday;
//	/** ���ռ��Ƶ��(��������) */
//	protected String once;
//	
//
//	/** ���ռ��������id */
//	protected String rcuserid;
//	
//	/** ���ռ������������ */
//	protected String rcusername;
//	
//	/** ���ռ���������ɫid */
//	protected Integer rcroleid;
//	
//	/** ���ռ���������ɫ�� */
//	protected String rcrolename;
//	
//	/** ���ռ������ʲ� */
//	protected Integer rcasset;
//	
//	/** ���ռ������ʲ����� */
//	protected String rcassetname;
//	
//	/** ���ռ������ʲ��汾��*/
//	protected Integer rcassetversion; 
//	
//	/** ���ռ�鸽�� */
//	protected String rcattch;
//	
//	/** ���ռ��ѡ�� */
//	protected String rcoption;
//	
//	/** ���ռ�����ִ�б��ʽ */
//	protected String rccron;
//	
//	protected String fingerPrint;
//	
//	/** ���ռ������ */
//	protected String rcclass;
//	
//	/** ���� */
//	protected Map<Integer, FormFile> fileMap = new HashMap<Integer, FormFile>();
//	
//	/** 0Ϊ���� 1Ϊ��� */
//	protected String mode = "0";
//
//	/** ���ռ������� */
//	protected String rccategory;
//	
//	/** ���ռ����������� */
//	protected String rccategoryname;
//	
//	/** ���ռ��Ǽ�ʱ�� */
//	protected String rccreatetime;
//	
//	/** ���ռ������ʱ�� */
//	protected String rcapprovetime;
//	
//	/** ���ռ�������� */
//	protected String rcapprover;
//	
//	/** ����ʱ�� */
//	protected String rcupdatetime;
//	
//	/** ��Ҫɾ���ĸ���id��*/
//	protected String predelkey;
//	/** ����ִ����  */
//	protected String cog;
//	/** ����ִ����  */
//	protected String ciiop;
//	/** ����ִ����ID  */
//	protected String cogid;
//	/** ����ִ����ID  */
//	protected String ciiopid;
//	/** ���ռ�鷽ʽ */
//	protected String rcrtestmode;
//	/** ����ִ������  */
//	protected Integer wtip;
//
//	/** ���ռ��ƻ����ʱ�� */
//	protected String rcrplandate_from;
//
//	/** ���ռ��ƻ����ʱ�� */
//	protected String rcrplandate_to;
//	
//	/** Ϊ1ʱֻ��ѯδִ�еļ�鹤���������������ȫ����鹤�� */
//	protected String isNull;
//	/**����������id*/
//	protected String[] orgids;
//	/**����������*/
//	protected String[] orgnames;
//	
//	
//	
//	public String[] getOrgids() {
//        return orgids;
//    }
//
//    public void setOrgids(String[] orgids) {
//        this.orgids = orgids;
//    }
//
//    public String[] getOrgnames() {
//        return orgnames;
//    }
//
//    public void setOrgnames(String[] orgnames) {
//        this.orgnames = orgnames;
//    }
//
//    /**
//	 * ����ִ����IDȡ��
//	 * @return ����ִ����ID
//	 */
//	public String getCogid() {
//		return cogid;
//	}
//
//	public void setCogid(String cogid) {
//		this.cogid = cogid;
//	}
//	
//	
//	/**
//	 * @return the cwrid
//	 */
//	public Integer getCwrid() {
//		return cwrid;
//	}
//
//	/**
//	 * @param cwrid the cwrid to set
//	 */
//	public void setCwrid(Integer cwrid) {
//		this.cwrid = cwrid;
//	}
//
//	/**
//	 * ����ִ����IDȡ��
//	 * @return ����ִ����ID
//	 */
//	public String getCiiopid() {
//		return ciiopid;
//	}
//
//	public void setCiiopid(String ciiopid) {
//		this.ciiopid = ciiopid;
//	}
//
//	public String getCog() {
//		return cog;
//	}
//
//	public void setCog(String cog) {
//		this.cog = cog;
//	}
//
//	public String getCiiop() {
//		return ciiop;
//	}
//
//	public void setCiiop(String ciiop) {
//		this.ciiop = ciiop;
//	}
//
//	public Integer getWtip() {
//		return wtip;
//	}
//
//	public void setWtip(Integer wtip) {
//		this.wtip = wtip;
//	}
//
//	/**
//	 * ���ռ������ʲ�����ȡ��
//	 * @return ���ռ������ʲ�����
//	 */
//	public String getRcassetname() {
//		return rcassetname;
//	}
//
//	/**
//	 * ���ռ������ʲ������趨
//	 * @param rcassetname ���ռ������ʲ�����
//	 */
//	public void setRcassetname(String rcassetname) {
//		this.rcassetname = rcassetname;
//	}
//
//	/**
//	 * ���ռ�����ִ�б��ʽȡ��
//	 * @return ���ռ�����ִ�б��ʽ
//	 */
//	public String getRccron() {
//		return rccron;
//	}
//
//	/**
//	 * ���ռ�����ִ�б��ʽ�趨
//	 * @param rccron ���ռ�����ִ�б��ʽ
//	 */
//	public void setRccron(String rccron) {
//		this.rccron = rccron;
//	}
//
//	/**
//	 * @return the fingerPrint
//	 */
//	public String getFingerPrint() {
//		return fingerPrint;
//	}
//	
//	public String getOnce() {
//		return once;
//	}
//
//	public void setOnce(String once) {
//		this.once = once;
//	}
//
//	/**
//	 * @param fingerPrint the fingerPrint to set
//	 */
//	public void setFingerPrint(String fingerPrint) {
//		this.fingerPrint = fingerPrint;
//	}
//
//	/**
//	 * 0Ϊ���� 1Ϊ���ȡ��
//	 * @return 0Ϊ���� 1Ϊ���
//	 */
//	public String getMode() {
//		return mode;
//	}
//
//	/**
//	 * 0Ϊ���� 1Ϊ����趨
//	 * @param mode 0Ϊ���� 1Ϊ���
//	 */
//	public void setMode(String mode) {
//		this.mode = mode;
//	}
//	
//	/**
//	 * ��ȡ����
//	 * @return ��ȡ����
//	 */
//	public FormFile getAttachFile(int index) {
//		return fileMap.get(new Integer(index));
//	}
//
//	/**
//	 * ���ø���
//	 * @param index ������������
//	 * @param file ����
//	 */
//	public void setAttachFile(int index, FormFile file) {
//		fileMap.put(new Integer(index), file);
//	}
//
//	/**
//	 * ��ȡ����Map
//	 * @return ����Map
//	 */
//	public Map<Integer, FormFile> getFileMap() {
//		return fileMap;
//	}
//
//	/**
//	 * �����趨
//	 * @param fileMap ����
//	 */
//	public void setFileMap(Map<Integer, FormFile> fileMap) {
//		this.fileMap = fileMap;
//	}
//
//	/**
//	 * ���ռ��IDȡ��
//	 * @return ���ռ��ID
//	 */
//	public Integer getRcid() {
//		if(rcid!=null && rcid==0){
//			return null;
//		}else{
//			return rcid;
//		}
//		
//	}
//
//	/**
//	 * ���ռ������ȡ��
//	 * @return ���ռ������
//	 */
//	public String getRcname() {
//		return rcname;
//	}
//
//	/**
//	 * ���ռ������ȡ��
//	 * @return ���ռ������
//	 */
//	public String getRcdesc() {
//		return rcdesc;
//	}
//
//	/**
//	 * ���ռ����Ҫ�̶�ȡ��
//	 * @return the ���ռ����Ҫ�̶�
//	 */
//	public String getRctype() {
//		return rctype;
//	}
//
//	/**
//	 * ���ռ��״̬ȡ��
//	 * @return ���ռ��״̬
//	 */
//	public String getRcstatus() {
//		return rcstatus;
//	}
//
//	/**
//	 * ���ռ����ʼ����ȡ��
//	 * @return ���ռ����ʼ����
//	 */
//	public String getRcstartdate() {
//		return rcstartdate;
//	}
//
//	/**
//	 * ���ռ���������ȡ��
//	 * @return ���ռ���������
//	 */
//	public String getRcenddate() {
//		return rcenddate;
//	}
//
//	/**
//	 * ���ռ��Ƶ��ȡ��
//	 * @return ���ռ��Ƶ��
//	 */
//	public String getRcfrequency() {
//		return rcfrequency;
//	}
//
//	/**
//	 * ���ռ��������idȡ��
//	 * @return ���ռ��������id
//	 */
//	public String getRcuserid() {
//		return rcuserid;
//	}
//	
//	/**
//	 * ���ռ��Ƶ��(��)ȡ��
//	 * @return ���ռ��Ƶ��(��)
//	 */
//	public String[] getRcfrequencyweek() {
//		return rcfrequencyweek;
//	}
//
//	/**
//	 * ���ռ��Ƶ��(��)�趨
//	 *
//	 * @param rcfrequencyweek ���ռ��Ƶ��(��)
//	 */
//	public void setRcfrequencyweek(String[] rcfrequencyweek) {
//		this.rcfrequencyweek = rcfrequencyweek;
//	}
//
//	/**
//	 * ���ռ��Ƶ��(��)ȡ��
//	 * @return ���ռ��Ƶ��(��)
//	 */
//	public String[] getRcfrequencymonth() {
//		return rcfrequencymonth;
//	}
//
//	/**
//	 * ���ռ��Ƶ��(��)�趨
//	 *
//	 * @param rcfrequencymonth ���ռ��Ƶ��(��)
//	 */
//	public void setRcfrequencymonth(String[] rcfrequencymonth) {
//		this.rcfrequencymonth = rcfrequencymonth;
//	}
//	
//	/**
//	 * ���ռ��Ƶ��(ÿ�����һ��)ȡ��
//	 * @return ���ռ��Ƶ��(ÿ�����һ��)
//	 */
//	public String getRcfrequencymonthlastday() {
//		return rcfrequencymonthlastday;
//	}
//	
//	/**
//	 * ���ռ��Ƶ��(ÿ�����һ��)�趨
//	 *
//	 * @param rcfrequencymonthlastday ���ռ��Ƶ��(ÿ�����һ��)
//	 */
//	public void setRcfrequencymonthlastday(String rcfrequencymonthlastday) {
//		this.rcfrequencymonthlastday = rcfrequencymonthlastday;
//	}
//	
//	/**
//	 * ���ռ������������ȡ��
//	 * @return ���ռ������������
//	 */
//	public String getRcusername() {
//		return rcusername;
//	}
//
//	/**
//	 * ���ռ���������ɫidȡ��
//	 * @return ���ռ���������ɫid
//	 */
//	public Integer getRcroleid() {
//		return rcroleid;
//	}
//
//	
//	/**
//	 * @return the einames
//	 */
//	public String getEinames() {
//		return einames;
//	}
//
//	/**
//	 * @param einames the einames to set
//	 */
//	public void setEinames(String einames) {
//		this.einames = einames;
//	}
//
//	/**
//	 * ���ռ���������ɫ��ȡ��
//	 * @return ���ռ���������ɫ��
//	 */
//	public String getRcrolename() {
//		return rcrolename;
//	}
//
//	/**
//	 * ���ռ������ʲ�ȡ��
//	 * @return ���ռ������ʲ�
//	 */
//	public Integer getRcasset() {
//		return rcasset;
//	}
//
//	/**
//	 * ���ռ�鸽��ȡ��
//	 * @return ���ռ�鸽��
//	 */
//	public String getRcattch() {
//		return rcattch;
//	}
//
//	/**
//	 * ���ռ��ѡ��ȡ��
//	 * @return ���ռ��ѡ��
//	 */
//	public String getRcoption() {
//		return rcoption;
//	}
//
//	/**
//	 * ���ռ��ID�趨
//	 * @param rcid ���ռ��ID
//	 */
//	public void setRcid(Integer rcid) {
//		this.rcid = rcid;
//	}
//
//	/**
//	 * ���ռ�������趨
//	 * @param rcname ���ռ������
//	 */
//	public void setRcname(String rcname) {
//		this.rcname = rcname;
//	}
//
//	/**
//	 * ���ռ�������趨
//	 * @param rcdesc ���ռ������
//	 */
//	public void setRcdesc(String rcdesc) {
//		this.rcdesc = rcdesc;
//	}
//
//	/**
//	 * ���ռ����Ҫ�̶��趨
//	 * @param rctype ���ռ����Ҫ�̶�
//	 */
//	public void setRctype(String rctype) {
//		this.rctype = rctype;
//	}
//
//	/**
//	 * ���ռ��״̬�趨
//	 * @param rcstatus ���ռ��״̬
//	 */
//	public void setRcstatus(String rcstatus) {
//		this.rcstatus = rcstatus;
//	}
//
//	/**
//	 * ���ռ����ʼ�����趨
//	 * @param rcstartdate ���ռ����ʼ����
//	 */
//	public void setRcstartdate(String rcstartdate) {
//		this.rcstartdate = rcstartdate;
//	}
//
//	/**
//	 * ���ռ����������趨
//	 * @param rcenddate ���ռ���������
//	 */
//	public void setRcenddate(String rcenddate) {
//		this.rcenddate = rcenddate;
//	}
//
//	/**
//	 * ���ռ��Ƶ���趨
//	 * @param rcfrequency ���ռ��Ƶ��
//	 */
//	public void setRcfrequency(String rcfrequency) {
//		this.rcfrequency = rcfrequency;
//	}
//
//	/**
//	 * ���ռ��������id�趨
//	 * @param rcuserid ���ռ��������id
//	 */
//	public void setRcuserid(String rcuserid) {
//		this.rcuserid = rcuserid;
//	}
//
//	/**
//	 * ���ռ��Ƶ������ȡ��
//	 * @return ���ռ��Ƶ������
//	 */
//	public String getRcfrequencydesc() {
//		return rcfrequencydesc;
//	}
//
//	/**
//	 * ���ռ��Ƶ�������趨
//	 *
//	 * @param rcfrequencydesc ���ռ��Ƶ������
//	 */
//	public void setRcfrequencydesc(String rcfrequencydesc) {
//		this.rcfrequencydesc = rcfrequencydesc;
//	}
//	
//	/**
//	 * ���ռ�������������趨
//	 * @param rcusername ���ռ������������
//	 */
//	public void setRcusername(String rcusername) {
//		this.rcusername = rcusername;
//	}
//
//	/**
//	 * ���ռ���������ɫid�趨
//	 * @param rcroleid ���ռ���������ɫid
//	 */
//	public void setRcroleid(Integer rcroleid) {
//		this.rcroleid = rcroleid;
//	}
//
//	/**
//	 * ���ռ���������ɫ���趨
//	 * @param rcrolename ���ռ���������ɫ��
//	 */
//	public void setRcrolename(String rcrolename) {
//		this.rcrolename = rcrolename;
//	}
//
//	/**
//	 * ���ռ������ʲ��趨
//	 * @param rcasset ���ռ������ʲ�
//	 */
//	public void setRcasset(Integer rcasset) {
//		this.rcasset = rcasset;
//	}
//
//	/**
//	 * ���ռ�鸽���趨
//	 * @param rcattch ���ռ�鸽��
//	 */
//	public void setRcattch(String rcattch) {
//		this.rcattch = rcattch;
//	}
//
//	/**
//	 * ���ռ��ѡ���趨
//	 * @param rcoption ���ռ��ѡ��
//	 */
//	public void setRcoption(String rcoption) {
//		this.rcoption = rcoption;
//	}
//
//	/**
//	 * ���ռ�������ȡ��
//	 * @return ���ռ�������
//	 */
//	public String getRccategory() {
//		return rccategory;
//	}
//
//	/**
//	 * ���ռ��������趨
//	 *
//	 * @param rccategory ���ռ�������
//	 */
//	public void setRccategory(String rccategory) {
//		this.rccategory = rccategory;
//	}
//
//	/**
//	 * ���ռ�����������ȡ��
//	 * @return ���ռ�����������
//	 */
//	public String getRccategoryname() {
//		return rccategoryname;
//	}
//
//	/**
//	 * ���ռ������������趨
//	 *
//	 * @param rccategoryname ���ռ�����������
//	 */
//	public void setRccategoryname(String rccategoryname) {
//		this.rccategoryname = rccategoryname;
//	}
//
//	/**
//	 * ���ռ��Ǽ�ʱ��ȡ��
//	 * @return ���ռ��Ǽ�ʱ��
//	 */
//	public String getRccreatetime() {
//		return rccreatetime;
//	}
//
//	/**
//	 * ���ռ��Ǽ�ʱ���趨
//	 *
//	 * @param rccreatetime ���ռ��Ǽ�ʱ��
//	 */
//	public void setRccreatetime(String rccreatetime) {
//		this.rccreatetime = rccreatetime;
//	}
//
//	/**
//	 * ���ռ������ʱ��ȡ��
//	 * @return ���ռ������ʱ��
//	 */
//	public String getRcapprovetime() {
//		return rcapprovetime;
//	}
//
//	/**
//	 * ���ռ������ʱ���趨
//	 *
//	 * @param rcapprovetime ���ռ������ʱ��
//	 */
//	public void setRcapprovetime(String rcapprovetime) {
//		this.rcapprovetime = rcapprovetime;
//	}
//
//	/**
//	 * ���ռ��������ȡ��
//	 * @return ���ռ��������
//	 */
//	public String getRcapprover() {
//		return rcapprover;
//	}
//
//	/**
//	 * ���ռ���������趨
//	 *
//	 * @param rcapprover ���ռ��������
//	 */
//	public void setRcapprover(String rcapprover) {
//		this.rcapprover = rcapprover;
//	}
//	
//	/**
//	 * ����ʱ��ȡ��
//	 * @return ����ʱ��
//	 */
//	public String getRcupdatetime() {
//		return rcupdatetime;
//	}
//
//	/**
//	 * ����ʱ���趨
//	 *
//	 * @param rcupdatetime ����ʱ��
//	 */
//	public void setRcupdatetime(String rcupdatetime) {
//		this.rcupdatetime = rcupdatetime;
//	}
//
//	/**
//	 * ��Ҫɾ���ĸ���id��ȡ��
//	 *
//	 * @return ��Ҫɾ���ĸ���id��
//	 */
//	public String getPredelkey() {
//		return predelkey;
//	}
//
//	/**
//	 * ��Ҫɾ���ĸ���id���趨
//	 *
//	 * @param predelkey ��Ҫɾ���ĸ���id��
//	 */
//	public void setPredelkey(String predelkey) {
//		this.predelkey = predelkey;
//	}
//
//	public String getRccommon() {
//		return rccommon;
//	}
//
//	public void setRccommon(String rccommon) {
//		this.rccommon = rccommon;
//	}
//
//	public String getRcclass() {
//		return rcclass;
//	}
//
//	public void setRcclass(String rcclass) {
//		this.rcclass = rcclass;
//	}
//	public String getRcrtestmode() {
//		return rcrtestmode;
//	}
//
//	public void setRcrtestmode(String rcrtestmode) {
//		this.rcrtestmode = rcrtestmode;
//	}
//
//	public String getRcrplandate_from() {
//		return rcrplandate_from;
//	}
//
//
//	public void setRcrplandate_from(String rcrplandate_from) {
//		this.rcrplandate_from = rcrplandate_from;
//	}
//
//
//	public String getRcrplandate_to() {
//		return rcrplandate_to;
//	}
//
//
//	public void setRcrplandate_to(String rcrplandate_to) {
//		this.rcrplandate_to = rcrplandate_to;
//	}
//
//	public String getIsNull() {
//		return isNull;
//	}
//
//	public void setIsNull(String isNull) {
//		this.isNull = isNull;
//	}
//	/**
//	 * @return the eiids
//	 */
//	public String getEiids() {
//		return eiids;
//	}
//
//	/**
//	 * @param eiids the eiids to set
//	 */
//	public void setEiids(String eiids) {
//		this.eiids = eiids;
//	}
//
//	/**
//	 * @return the eiversions
//	 */
//	public String getEiversions() {
//		return eiversions;
//	}
//
//	/**
//	 * @param eiversions the eiversions to set
//	 */
//	public void setEiversions(String eiversions) {
//		this.eiversions = eiversions;
//	}
//
//	/**
//	 * @return the csid
//	 */
//	public Integer getCsid() {
//		return csid;
//	}
//
//	/**
//	 * @param csid the csid to set
//	 */
//	public void setCsid(Integer csid) {
//		this.csid = csid;
//	}
//
//	/**
//	 * @return the rcassetversion
//	 */
//	public Integer getRcassetversion() {
//		return rcassetversion;
//	}
//
//	/**
//	 * @param rcassetversion the rcassetversion to set
//	 */
//	public void setRcassetversion(Integer rcassetversion) {
//		this.rcassetversion = rcassetversion;
//	}
//
//	/**
//	 * @return the riskitem
//	 */
//	public String getRiskitem() {
//		return riskitem;
//	}
//
//	/**
//	 * @param riskitem the riskitem to set
//	 */
//	public void setRiskitem(String riskitem) {
//		this.riskitem = riskitem;
//	}
//
//	/**
//	 * @return the eidesc
//	 */
//	public String getEidesc() {
//		return eidesc;
//	}
//
//	/**
//	 * @param eidesc the eidesc to set
//	 */
//	public void setEidesc(String eidesc) {
//		this.eidesc = eidesc;
//	}
//
//	/**
//	 * @return the eistatus
//	 */
//	public String getEistatus() {
//		return eistatus;
//	}
//
//	/**
//	 * @param eistatus the eistatus to set
//	 */
//	public void setEistatus(String eistatus) {
//		this.eistatus = eistatus;
//	}
//
//	/**
//	 * @return the rcommon
//	 */
//	public String getRcommon() {
//		return rcommon;
//	}
//
//	/**
//	 * @param rcommon the rcommon to set
//	 */
//	public void setRcommon(String rcommon) {
//		this.rcommon = rcommon;
//	}

	
}
