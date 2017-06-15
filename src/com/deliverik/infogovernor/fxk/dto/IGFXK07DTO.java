/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.fxk.dto;

import java.util.List;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.infogovernor.asset.model.RiskcaseVWInfo;
import com.deliverik.infogovernor.fxk.form.IGFXK0700Form;
import com.deliverik.infogovernor.fxk.model.AcceptuserInfo;
import com.deliverik.infogovernor.fxk.model.RiskmanagerwaringInfo;
import com.deliverik.infogovernor.fxk.vo.IGFXK07012VO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ��������DTO
 * </p>
 * 2014-6-16
 * 
 * @author zhangq@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGFXK07DTO extends BaseDTO {
	/**���ռƻ���ѯ����*/
	protected int prlistsize;
	/**�����嵥��ѯ����*/
	protected int qdlistsize;
	/**�������Ĳ�ѯ����*/
	protected int qmlistsize;
	/**����������ѯ����*/
	protected int pglistsize;
	
	/**���յ��ѯ����*/
	protected int riskCount;
	
	/**���������*/
	protected int checkCount;
	
	/**��������ִ�е�����*/
	protected int pgExcing;
	
	/**���� ���*/
	protected int pgYear;
	protected int qdExcing;
	protected int qdYear;
	
	protected IGFXK0700Form igfxk0700Form;
	
	/**
	 * igfxk0700Formȡ��
	 * @return igfxk0700Form igfxk0700Form
	 */
	public IGFXK0700Form getIgfxk0700Form() {
		return igfxk0700Form;
	}

	/**
	 * igfxk0700Form�趨
	 * @param igfxk0700Form igfxk0700Form
	 */
	public void setIgfxk0700Form(IGFXK0700Form igfxk0700Form) {
		this.igfxk0700Form = igfxk0700Form;
	}

	/**
	 * �������ȡ��
	 * @return pgYear �������
	 */
	public int getPgYear() {
		return pgYear;
	}

	/**
	 * ��������趨
	 * @param pgYear �������
	 */
	public void setPgYear(int pgYear) {
		this.pgYear = pgYear;
	}

	/**
	 * ��������ִ�е�����ȡ��
	 * @return pgExcing ��������ִ�е�����
	 */
	public int getPgExcing() {
		return pgExcing;
	}

	/**
	 * ��������ִ�е������趨
	 * @param pgExcing ��������ִ�е�����
	 */
	public void setPgExcing(int pgExcing) {
		this.pgExcing = pgExcing;
	}

	/**
	 * ���յ��ѯ����ȡ��
	 * @return riskCount ���յ��ѯ����
	 */
	public int getRiskCount() {
		return riskCount;
	}

	/**
	 * ���յ��ѯ�����趨
	 * @param riskCount ���յ��ѯ����
	 */
	public void setRiskCount(int riskCount) {
		this.riskCount = riskCount;
	}

	/**
	 * ���������ȡ��
	 * @return checkCount ���������
	 */
	public int getCheckCount() {
		return checkCount;
	}

	/**
	 * ����������趨
	 * @param checkCount ���������
	 */
	public void setCheckCount(int checkCount) {
		this.checkCount = checkCount;
	}

	/**������ʾ��ѯ ����*/
	int risklistsize;
	/** ҳ���ʼ */
	private IGFXK0700Form form;

	/** ��Ӹ��� */
	protected IGFXK0700Form attachFile;

	/** ������Ա */
	protected String[] usid;

	/** ������Ա���� */
	protected String[] usname;

	/** ������ʾ���� */
	protected List<RiskmanagerwaringInfo> list;

	/** ������ʾ���� */
	protected List<AcceptuserInfo> acceptList;
	/** �������� */
	protected String smsContext;
	/** �ʼ����� */
	protected String mailTitle;

	/** ������ʾ�����Ϣ���� */
	protected List<IGFXK07012VO> voList;

	/** ������ʾid */
	private Integer rwid;

	/** ������ʾ���� */
	protected String rwname;

	/** �·�����id */
	protected String nuserid;

	/** �·��������� */
	protected String nusername;

	/** �·��߻����� */
	protected String norgname;

	/** �·��߻����� */
	protected String norgid;

	/** �·�ʱ�� */
	protected String ntime;

	/** �·�����ϵ��ʽ */
	protected String ntel;

	/** ������ʾ���� */
	protected String rwcontext;

	/** ��ʾ���� */
	protected String rwkey;

	/** ������ʾ���ݽӿ� */
	protected RiskmanagerwaringInfo info;

	/** �����߻������� */
	protected String[] aporgname;

	/** ������ʾ�������ݼ��� */
	protected IGFXK07012VO igfxkvo;

	/** �жϻ���������Ա */
	protected String type;
	/** �����ѯ������¼�� */
	protected int maxSearchCount;

	/** ��ҳBean */
	protected PagingDTO pagingDto;
	
	/**���ռƻ�*/
	protected  List<IG500Info> prList;
	/**�����嵥*/
	protected List<RiskcaseVWInfo> qdList;
	
	/**��������*/
	protected List<IG500Info> questModfiy;
	/**��������*/
	protected List<IG500Info> riskpg;
	/**
	 * @return the riskpg
	 */
	public List<IG500Info> getRiskpg() {
		return riskpg;
	}

	/**
	 * @param riskpg the riskpg to set
	 */
	public void setRiskpg(List<IG500Info> riskpg) {
		this.riskpg = riskpg;
	}

	/**
	 * @return the questModfiy
	 */
	public List<IG500Info> getQuestModfiy() {
		return questModfiy;
	}

	/**
	 * @param questModfiy the questModfiy to set
	 */
	public void setQuestModfiy(List<IG500Info> questModfiy) {
		this.questModfiy = questModfiy;
	}

	/**
	 * @return the qdList
	 */
	public List<RiskcaseVWInfo> getQdList() {
		return qdList;
	}

	/**
	 * @param qdList the qdList to set
	 */
	public void setQdList(List<RiskcaseVWInfo> qdList) {
		this.qdList = qdList;
	}

	/**
	 * ���ռƻ�ȡ��
	 * @return prList ���ռƻ�
	 */
	
	public List<IG500Info> getPrList() {
		return prList;
	}

	/**
	 * ���ռƻ��趨
	 * @param prList ���ռƻ�
	 */
	public void setPrList(List<IG500Info> prList) {
		this.prList = prList;
	}

	/**
	 * ������ʾ����ȡ��
	 * 
	 * @return acceptList ������ʾ����
	 */

	public List<AcceptuserInfo> getAcceptList() {
		return acceptList;
	}

	/**
	 * ������ʾ�����趨
	 * 
	 * @param acceptList
	 *            ������ʾ����
	 */
	public void setAcceptList(List<AcceptuserInfo> acceptList) {
		this.acceptList = acceptList;
	}

	/**
	 * �жϻ���������Աȡ��
	 * 
	 * @return type �жϻ���������Ա
	 */

	public String getType() {
		return type;
	}

	/**
	 * �жϻ���������Ա�趨
	 * 
	 * @param type
	 *            �жϻ���������Ա
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * ������ʾ�������ݼ���ȡ��
	 * 
	 * @return igfxkvo ������ʾ�������ݼ���
	 */
	public IGFXK07012VO getIgfxkvo() {
		return igfxkvo;
	}

	/**
	 * ������ʾ�������ݼ����趨
	 * 
	 * @param igfxkvo
	 *            ������ʾ�������ݼ���
	 */
	public void setIgfxkvo(IGFXK07012VO igfxkvo) {
		this.igfxkvo = igfxkvo;
	}

	/**
	 * ������ʾ����ȡ��
	 * 
	 * @return list ������ʾ����
	 */
	public List<RiskmanagerwaringInfo> getList() {
		return list;
	}

	/**
	 * ������ʾ�����趨
	 * 
	 * @param list
	 *            ������ʾ����
	 */
	public void setList(List<RiskmanagerwaringInfo> list) {
		this.list = list;
	}

	/**
	 * �������� 1:��ӻ��� 2:�����Ա
	 */
	protected String sign;

	/**
	 * ��������1:��ӻ���2:�����Աȡ��
	 * 
	 * @return sign ��������1:��ӻ���2:�����Ա
	 */
	public String getSign() {
		return sign;
	}

	/**
	 * ��������1:��ӻ���2:�����Ա�趨
	 * 
	 * @param sign
	 *            ��������1:��ӻ���2:�����Ա
	 */
	public void setSign(String sign) {
		this.sign = sign;
	}

	/**
	 * ������Ա����ȡ��
	 * 
	 * @return usname ������Ա����
	 */
	public String[] getUsname() {
		return usname;
	}

	/**
	 * ������Ա�����趨
	 * 
	 * @param usname
	 *            ������Ա����
	 */
	public void setUsname(String[] usname) {
		this.usname = usname;
	}

	/** ���ջ��� */
	protected String[] aporgid;

	/**
	 * ���ջ���ȡ��
	 * 
	 * @return aporgid ���ջ���
	 */
	public String[] getAporgid() {
		return aporgid;
	}

	/**
	 * ���ջ����趨
	 * 
	 * @param aporgid
	 *            ���ջ���
	 */
	public void setAporgid(String[] aporgid) {
		this.aporgid = aporgid;
	}

	/**
	 * ������Աȡ��
	 * 
	 * @return usid ������Ա
	 */
	public String[] getUsid() {
		return usid;
	}

	/**
	 * ������Ա�趨
	 * 
	 * @param usid
	 *            ������Ա
	 */
	public void setUsid(String[] usid) {
		this.usid = usid;
	}

	/**
	 * �����߻�������ȡ��
	 * 
	 * @return aporgname �����߻�������
	 */
	public String[] getAporgname() {
		return aporgname;
	}

	/**
	 * �����߻��������趨
	 * 
	 * @param aporgname
	 *            �����߻�������
	 */
	public void setAporgname(String[] aporgname) {
		this.aporgname = aporgname;
	}

	/**
	 * ������ʾ����ȡ��
	 * 
	 * @return rwname ������ʾ����
	 */

	public String getRwname() {
		return rwname;
	}

	/**
	 * ������ʾ�����趨
	 * 
	 * @param rwname
	 *            ������ʾ����
	 */
	public void setRwname(String rwname) {
		this.rwname = rwname;
	}

	/**
	 * �·�����idȡ��
	 * 
	 * @return nuserid �·�����id
	 */

	public String getNuserid() {
		return nuserid;
	}

	/**
	 * �·�����id�趨
	 * 
	 * @param nuserid
	 *            �·�����id
	 */
	public void setNuserid(String nuserid) {
		this.nuserid = nuserid;
	}

	/**
	 * �·���������ȡ��
	 * 
	 * @return nusername �·���������
	 */

	public String getNusername() {
		return nusername;
	}

	/**
	 * �·����������趨
	 * 
	 * @param nusername
	 *            �·���������
	 */
	public void setNusername(String nusername) {
		this.nusername = nusername;
	}

	/**
	 * �·��߻�����ȡ��
	 * 
	 * @return norgname �·��߻�����
	 */

	public String getNorgname() {
		return norgname;
	}

	/**
	 * �·��߻������趨
	 * 
	 * @param norgname
	 *            �·��߻�����
	 */
	public void setNorgname(String norgname) {
		this.norgname = norgname;
	}

	/**
	 * �·��߻�����ȡ��
	 * 
	 * @return norgid �·��߻�����
	 */

	public String getNorgid() {
		return norgid;
	}

	/**
	 * �·��߻������趨
	 * 
	 * @param norgid
	 *            �·��߻�����
	 */
	public void setNorgid(String norgid) {
		this.norgid = norgid;
	}

	/**
	 * �·�ʱ��ȡ��
	 * 
	 * @return ntime �·�ʱ��
	 */

	public String getNtime() {
		return ntime;
	}

	/**
	 * �·�ʱ���趨
	 * 
	 * @param ntime
	 *            �·�ʱ��
	 */
	public void setNtime(String ntime) {
		this.ntime = ntime;
	}

	/**
	 * �·�����ϵ��ʽȡ��
	 * 
	 * @return ntel �·�����ϵ��ʽ
	 */

	public String getNtel() {
		return ntel;
	}

	/**
	 * �·�����ϵ��ʽ�趨
	 * 
	 * @param ntel
	 *            �·�����ϵ��ʽ
	 */
	public void setNtel(String ntel) {
		this.ntel = ntel;
	}

	/**
	 * ������ʾ����ȡ��
	 * 
	 * @return rwcontext ������ʾ����
	 */

	public String getRwcontext() {
		return rwcontext;
	}

	/**
	 * ������ʾ�����趨
	 * 
	 * @param rwcontext
	 *            ������ʾ����
	 */
	public void setRwcontext(String rwcontext) {
		this.rwcontext = rwcontext;
	}

	/**
	 * ��ʾ����ȡ��
	 * 
	 * @return rwkey ��ʾ����
	 */

	public String getRwkey() {
		return rwkey;
	}

	/**
	 * ��ʾ�����趨
	 * 
	 * @param rwkey
	 *            ��ʾ����
	 */
	public void setRwkey(String rwkey) {
		this.rwkey = rwkey;
	}

	/**
	 * �����ѯ������¼��ȡ��
	 * 
	 * @return maxSearchCount �����ѯ������¼��
	 */

	public int getMaxSearchCount() {
		return maxSearchCount;
	}

	/**
	 * �����ѯ������¼���趨
	 * 
	 * @param maxSearchCount
	 *            �����ѯ������¼��
	 */
	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}

	/**
	 * ��ҳBeanȡ��
	 * 
	 * @return pagingDto ��ҳBean
	 */

	public PagingDTO getPagingDto() {
		return pagingDto;
	}

	/**
	 * ��ҳBean�趨
	 * 
	 * @param pagingDto
	 *            ��ҳBean
	 */
	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}

	/**
	 * formȡ��
	 * 
	 * @return form form
	 */

	public IGFXK0700Form getForm() {
		return form;
	}

	/**
	 * form�趨
	 * 
	 * @param form
	 *            form
	 */
	public void setForm(IGFXK0700Form form) {
		this.form = form;
	}

	/**
	 * ������ʾ���ݽӿ�ȡ��
	 * 
	 * @return info ������ʾ���ݽӿ�
	 */
	public RiskmanagerwaringInfo getInfo() {
		return info;
	}

	/**
	 * ������ʾ���ݽӿ��趨
	 * 
	 * @param info
	 *            ������ʾ���ݽӿ�
	 */
	public void setInfo(RiskmanagerwaringInfo info) {
		this.info = info;
	}

	/**
	 * ������ʾidȡ��
	 * 
	 * @return rwid ������ʾid
	 */
	public Integer getRwid() {
		return rwid;
	}

	/**
	 * ������ʾid�趨
	 * 
	 * @param rwid
	 *            ������ʾid
	 */
	public void setRwid(Integer rwid) {
		this.rwid = rwid;
	}

	/**
	 * attachFileȡ��
	 * 
	 * @return attachFile attachFile
	 */
	public IGFXK0700Form getAttachFile() {
		return attachFile;
	}

	/**
	 * attachFile�趨
	 * 
	 * @param attachFile
	 *            attachFile
	 */
	public void setAttachFile(IGFXK0700Form attachFile) {
		this.attachFile = attachFile;
	}

	/**
	 * ��������ȡ��
	 * 
	 * @return smsContext ��������
	 */
	public String getSmsContext() {
		return smsContext;
	}

	/**
	 * ���������趨
	 * 
	 * @param smsContext
	 *            ��������
	 */
	public void setSmsContext(String smsContext) {
		this.smsContext = smsContext;
	}

	/**
	 * �ʼ�����ȡ��
	 * 
	 * @return mailTitle �ʼ�����
	 */
	public String getMailTitle() {
		return mailTitle;
	}

	/**
	 * �ʼ������趨
	 * 
	 * @param mailTitle
	 *            �ʼ�����
	 */
	public void setMailTitle(String mailTitle) {
		this.mailTitle = mailTitle;
	}

	/**
	 * ������ʾ�����Ϣ����ȡ��
	 * 
	 * @return voList ������ʾ�����Ϣ����
	 */
	public List<IGFXK07012VO> getVoList() {
		return voList;
	}

	/**
	 * ������ʾ�����Ϣ�����趨
	 * 
	 * @param voList
	 *            ������ʾ�����Ϣ����
	 */
	public void setVoList(List<IGFXK07012VO> voList) {
		this.voList = voList;
	}
	public int getPrlistsize() {
		return prlistsize;
	}

	public void setPrlistsize(int prlistsize) {
		this.prlistsize = prlistsize;
	}

	public int getQdlistsize() {
		return qdlistsize;
	}

	public void setQdlistsize(int qdlistsize) {
		this.qdlistsize = qdlistsize;
	}

	public int getQmlistsize() {
		return qmlistsize;
	}

	public void setQmlistsize(int qmlistsize) {
		this.qmlistsize = qmlistsize;
	}

	public int getPglistsize() {
		return pglistsize;
	}

	public void setPglistsize(int pglistsize) {
		this.pglistsize = pglistsize;
	}
	public int getRisklistsize() {
		return risklistsize;
	}

	public void setRisklistsize(int risklistsize) {
		this.risklistsize = risklistsize;
	}

	/**
	 * qdExcingȡ��
	 * @return qdExcing qdExcing
	 */
	public int getQdExcing() {
		return qdExcing;
	}

	/**
	 * qdExcing�趨
	 * @param qdExcing qdExcing
	 */
	public void setQdExcing(int qdExcing) {
		this.qdExcing = qdExcing;
	}

	/**
	 * qdYearȡ��
	 * @return qdYear qdYear
	 */
	public int getQdYear() {
		return qdYear;
	}

	/**
	 * qdYear�趨
	 * @param qdYear qdYear
	 */
	public void setQdYear(int qdYear) {
		this.qdYear = qdYear;
	}

}
