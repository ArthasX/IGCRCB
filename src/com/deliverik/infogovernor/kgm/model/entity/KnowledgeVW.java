/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.kgm.model.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.model.Attachment;
import com.deliverik.framework.user.model.entity.UserTB;
import com.deliverik.infogovernor.kgm.model.Knowledge;

/**
 * ����: ֪ʶ��ʵ��ʵ��
 * ����������֪ʶ��ʵ��
 * ������¼��wangxiaoqiang 2010/12/07
 * �޸ļ�¼��
 */
@SuppressWarnings("serial")
@IdClass(KnowledgeTBPK.class)
@Entity
public class KnowledgeVW extends BaseEntity implements Serializable, Cloneable,Knowledge{
	@Id
	/**���� */
	protected Integer knid;
	
	@Id
	/**֪ʶ�汾 */
	protected Integer knversion;
	
	/**��� */
	protected String knserial;
	
	/**���� */
	protected String kndepartment;

	/**�鵵��id */
	protected String knapprover;
	
	/**�鵵������ */
	protected String knapprovername;
	
	/**�鵵ʱ�� */
	protected String knapprovetime;
	
	/**����*/
	protected String knclass;
	
	/**��������*/
	protected String knclassname;
	
	/**�ؼ���*/
	protected String knkey;
	
	/**��Դ*/
	protected String knorigin;
	
	/**��Դ����*/
	protected String knoriginname;
	
	/**֪ʶ������id*/
	protected String knproffer;
	
	/**֪ʶ����������*/
	protected String knproffername;
	
	/**����ʱ��*/
	protected String knproffertime;
	
	/**����*/
	protected String kntitle;
	
	/**��������*/
	protected String kndes;
	
	/**����ԭ���ܽ�*/
	protected String knfaultcause;
	
	/**����취*/
	protected String knsolveway;
	
	/**״̬*/
	protected String knstatus;
	
	/**����ԭ��*/
	protected String knreject;
	
	/**����KEY*/
	protected String knattkey;
	
	/**ҵ������*/
	protected String knarea;
	
	/**ҵ��������*/
	protected String knareaname;
	
	/**��������*/
	protected String kntelarea;
	
	/**����������*/
	protected String kntelareaname;
	
	/**֪ʶ�����˽�ɫ*/
	protected Integer knapproverole;

	
	/**
	 * ����״̬ǰ�������
	 */
	@Transient
	protected List<Attachment> attachmentList;
	
	/**UserTB ʵ��*/
	@OneToOne
	@JoinColumn(name="knapprover", referencedColumnName="userid", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected UserTB user;
	
	/**UserTB ʵ��*/
	@OneToOne
	@JoinColumn(name="knproffer", referencedColumnName="userid", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected UserTB userTB;
	
	/**
	 *��Դ����ȡ��
	 * 
	 * @return ��Դ����
	 */
	public String getKnoriginname() {
		return knoriginname;
	}
	/**
	 * ��Դ�����趨
	 * @param knoriginname ��Դ����
	 */
	public void setKnoriginname(String knoriginname) {
		this.knoriginname = knoriginname;
	}
	/**
	 *֪ʶ�汾ȡ��
	 * 
	 * @return ֪ʶ�汾
	 */
	public Integer getKnversion() {
		return knversion;
	}
	/**
	 * ֪ʶ�汾
	 * @param knversion ֪ʶ�汾
	 */
	public void setKnversion(Integer knversion) {
		this.knversion = knversion;
	}

	/**
	 *����KEYȡ��
	 * 
	 * @return ����KEY
	 */
	public String getKnattkey() {
		return knattkey;
	}
	
	/**
	 * ����KEY
	 * @param knattkey ����KEY
	 */
	public void setKnattkey(String knattkey) {
		this.knattkey = knattkey;
	}
	/**
	 *����ԭ��ȡ��
	 * 
	 * @return ����ԭ��
	 */
	public String getKnreject() {
		return knreject;
	}
	/**
	 * ����ԭ���趨
	 * @param knreject ����ԭ��
	 */
	public void setKnreject(String knreject) {
		this.knreject = knreject;
	}

	/**
	 *�鵵������ȡ��
	 * 
	 * @return �鵵������
	 */
	public String getKnapprovername() {
		return knapprovername;
	}

	/**
	 * �鵵�������趨
	 * @param knapprovername �鵵������
	 */
	public void setKnapprovername(String knapprovername) {
		this.knapprovername = knapprovername;
	}
	/**
	 *֪ʶ����������ȡ��
	 * 
	 * @return ֪ʶ����������
	 */
	public String getKnproffername() {
		return knproffername;
	}

	/**
	 * ֪ʶ�����������趨
	 * @param knproffername ֪ʶ����������
	 */
	public void setKnproffername(String knproffername) {
		this.knproffername = knproffername;
	}

	
	
	/**
	 * Userʵ��ȡ��
	 * @return Userʵ��
	 */
	public UserTB getUserTB() {
		return userTB;
	}

	/**
	 * UserTBʵ���趨
	 * @param userTB Userʵ��
	 */
	public void setUserTB(UserTB userTB) {
		this.userTB = userTB;
	}

	/**
	 * Userʵ��ȡ��
	 * @return Userʵ��
	 */
	public UserTB getUser() {
		return user;
	}

	/**
	 * Userʵ���趨
	 * @param user Userʵ��
	 */
	public void setUser(UserTB user) {
		this.user = user;
	}

	/**
	 *����ȡ��
	 * 
	 * @return ����
	 */
	public Integer getKnid() {
		return knid;
	}

	/**
	 *�����趨
	 * 
	 * @param knid����
	 */
	public void setKnid(Integer knid) {
		this.knid = knid;
	}

	/**
	 *���ȡ��
	 * 
	 * @return ���
	 */
	public String getKnserial() {
		return knserial;
	}

	/**
	 *����趨
	 * 
	 * @param knserial���
	 */
	public void setKnserial(String knserial) {
		this.knserial = knserial;
	}

	/**
	 *����ȡ��
	 * 
	 * @return ����
	 */
	public String getKndepartment() {
		return kndepartment;
	}

	/**
	 *�����趨
	 * 
	 * @param kndepartment����
	 */
	public void setKndepartment(String kndepartment) {
		this.kndepartment = kndepartment;
	}	

	/**
	 *�鵵��ȡ��
	 * 
	 * @return �鵵��
	 */
	public String getKnapprover() {
		return knapprover;
	}

	/**
	 *�鵵���趨
	 * 
	 * @param knapprover�鵵��
	 */
	public void setKnapprover(String knapprover) {
		this.knapprover = knapprover;
	}

	/**
	 *�鵵ʱ��ȡ��
	 * 
	 * @return �鵵ʱ��
	 */
	public String getKnapprovetime() {
		return knapprovetime;
	}

	/**
	 *�鵵ʱ���趨
	 * 
	 * @param knapprovetime�鵵ʱ��
	 */
	public void setKnapprovetime(String knapprovetime) {
		this.knapprovetime = knapprovetime;
	}

	/**
	 *����ȡ��
	 * 
	 * @return ����
	 */
	public String getKnclass() {
		return knclass;
	}

	/**
	 *�����趨
	 * 
	 * @param knclass����
	 */
	public void setKnclass(String knclass) {
		this.knclass = knclass;
	}

	/**
	 *�ؼ���ȡ��
	 * 
	 * @return �ؼ���
	 */
	public String getKnkey() {
		return knkey;
	}

	/**
	 *�ؼ����趨
	 * 
	 * @param knkey�ؼ���
	 */
	public void setKnkey(String knkey) {
		this.knkey = knkey;
	}

	/**
	 *��Դȡ��
	 * 
	 * @return ��Դ
	 */
	public String getKnorigin() {
		return knorigin;
	}

	/**
	 *��Դ�趨
	 * 
	 * @param knorigin��Դ
	 */
	public void setKnorigin(String knorigin) {
		this.knorigin = knorigin;
	}

	/**
	 *֪ʶ������ȡ��
	 * 
	 * @return ֪ʶ������
	 */
	public String getKnproffer() {
		return knproffer;
	}

	/**
	 *֪ʶ�������趨
	 * 
	 * @param knproffer֪ʶ������
	 */
	public void setKnproffer(String knproffer) {
		this.knproffer = knproffer;
	}

	/**
	 *����ʱ��ȡ��
	 * 
	 * @return ����ʱ��
	 */
	public String getKnproffertime() {
		return knproffertime;
	}

	/**
	 *����ʱ���趨
	 * 
	 * @param knproffertime����ʱ��
	 */
	public void setKnproffertime(String knproffertime) {
		this.knproffertime = knproffertime;
	}

	/**
	 *����ȡ��
	 * 
	 * @return ����
	 */
	public String getKntitle() {
		return kntitle;
	}

	/**
	 *�����趨
	 * 
	 * @param kntitle����
	 */
	public void setKntitle(String kntitle) {
		this.kntitle = kntitle;
	}

	/**
	 *��������ȡ��
	 * 
	 * @return ��������
	 */
	public String getKndes() {
		return kndes;
	}

	/**
	 *���������趨
	 * 
	 * @param kndes��������
	 */
	public void setKndes(String kndes) {
		this.kndes = kndes;
	}

	/**
	 *����ԭ���ܽ�ȡ��
	 * 
	 * @return ����ԭ���ܽ�
	 */
	public String getKnfaultcause() {
		return knfaultcause;
	}

	/**
	 *����ԭ���ܽ��趨
	 * 
	 * @param knfaultcause����ԭ���ܽ�
	 */
	public void setKnfaultcause(String knfaultcause) {
		this.knfaultcause = knfaultcause;
	}

	/**
	 *����취ȡ��
	 * 
	 * @return ����취
	 */
	public String getKnsolveway() {
		return knsolveway;
	}

	/**
	 *����취�趨
	 * 
	 * @param knsolveway����취
	 */
	public void setKnsolveway(String knsolveway) {
		this.knsolveway = knsolveway;
	}

	/**
	 *״̬ȡ��
	 * 
	 * @return ״̬
	 */
	public String getKnstatus() {
		return knstatus;
	}

	/**
	 *״̬�趨
	 * 
	 * @param knstatus״̬
	 */
	public void setKnstatus(String knstatus) {
		this.knstatus = knstatus;
	}
	
	/**
	 *�������ȡ��
	 * 
	 * @return �������
	 */
	public String getKnclassname() {
		return knclassname;
	}
	
	/**
	 *��������趨
	 * 
	 * @param knclassname �������
	 */
	public void setKnclassname(String knclassname) {
		this.knclassname = knclassname;
	}

	public Serializable getPK() {
		return new KnowledgeTBPK(knid,knversion);
	}
	/**
	 *ҵ������ȡ��
	 * 
	 * @return ҵ������
	 */
	public String getKnarea() {
		return knarea;
	}
	/**
	 *ҵ������
	 * @param knarea ҵ������
	 */
	public void setKnarea(String knarea) {
		this.knarea = knarea;
	}
	/**
	 *ҵ��������ȡ��
	 * 
	 * @return ҵ��������
	 */
	public String getKnareaname() {
		return knareaname;
	}
	/**
	 * ҵ��������
	 * @param knareaname ҵ��������
	 */
	public void setKnareaname(String knareaname) {
		this.knareaname = knareaname;
	}
	/**
	 *��������ȡ��
	 * 
	 * @return ��������
	 */
	public String getKntelarea() {
		return kntelarea;
	}
	/**
	 * ��������
	 * @param kntelarea ��������
	 */
	public void setKntelarea(String kntelarea) {
		this.kntelarea = kntelarea;
	}
	/**
	 *��������ȡ��
	 * 
	 * @return ��������
	 */
	public String getKntelareaname() {
		return kntelareaname;
	}
	/**
	 * ��������
	 * @param kntelareaname ��������Y
	 */
	public void setKntelareaname(String kntelareaname) {
		this.kntelareaname = kntelareaname;
	}
	public List<Attachment> getAttachmentList() {
		return attachmentList;
	}

	/**
	 * ֪ʶ����List�趨
	 * @param attachmentList ֪ʶ����List
	 */
	public void setAttachmentList(List<Attachment> attachmentList) {
		this.attachmentList = attachmentList;
	}
	
	public Integer getKnapproverole() {
		return knapproverole;
	}
	public void setKnapproverole(Integer knapproverole) {
		this.knapproverole = knapproverole;
	}

	
}
