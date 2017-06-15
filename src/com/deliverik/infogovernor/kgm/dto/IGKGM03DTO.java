/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.kgm.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.Role;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.kgm.form.IGKGM0201Form;
import com.deliverik.infogovernor.kgm.form.IGKGM0202Form;
import com.deliverik.infogovernor.kgm.form.IGKGM0203Form;
import com.deliverik.infogovernor.kgm.form.IGKGM0207Form;
import com.deliverik.infogovernor.kgm.form.IGKGM0216Form;
import com.deliverik.infogovernor.kgm.form.IGKGM0228Form;
import com.deliverik.infogovernor.kgm.model.KnowLedgeInfo;
import com.deliverik.infogovernor.kgm.model.Knowledge;
import com.deliverik.infogovernor.kgm.model.KnowledgeAppImpact;
import com.deliverik.infogovernor.kgm.model.KnowledgeGrade;
import com.deliverik.infogovernor.kgm.model.KnowledgeProcess;
import com.deliverik.infogovernor.kgm.model.condition.KnowledgeSearchCond;
import com.deliverik.infogovernor.kgm.vo.IGKGM02052VO;


/**
 * @Description: ֪ʶ����
 * @Author  
 * @History 2009-8-18     �½� 
 * @Version V2.0
 */
@SuppressWarnings("serial")
public class IGKGM03DTO extends BaseDTO implements Serializable {

	
	/**��ҳBean*/
	protected PagingDTO pagingDto;
	
	/**֪ʶ���form*/
	protected IGKGM0201Form igkgm0201Form;
	
	/**֪ʶ��ѯform*/
	protected IGKGM0202Form igkgm0202Form;
	
	/**֪ʶ��ѯform*/
	protected IGKGM0216Form igkgm0216Form;

	/**֪ʶ��ѯform*/
	protected IGKGM0203Form igkgm0203Form;

	/**֪ʶ��������form*/
	protected IGKGM0228Form igkgm0228Form;
	
	/**�����ѯ������¼��*/
	protected int maxSearchCount;
	
	/**֪ʶ��ѯ�ӿ�*/
	protected KnowledgeSearchCond knowledgeSearchCond;
	
	/**֪ʶ��ѯ�ӿ�*/
	protected Knowledge knowledgeREAD;
	
	/**�ؼ����б�*/
	protected List keysFromDB ;	

	/**����id*/
	protected String ProcessID ;
	
	/**Session id*/
	protected String SessionID ;
	
	/**����id*/
	protected String rlcomment ;	
	
	/**��������*/
	protected String ProcessName ;	
	protected String messageflag ;	
	/**��������*/
	protected String kntelareaname;
	
	/**֪ʶ�����˽�ɫ*/
	protected List<Role> roleList;
	
	/**Ҫɾ��������ID����*/
	protected String delFiles;
	
	/**Ҫɾ����ذ�����ID����*/
	protected String delKgm;
	
	/**��Ҫ����֪ʶ����Ϣ����*/
	protected List<Knowledge> knowledgelist;
	
	
	/**��ʷҵ��ϵͳ*/
	protected List<IGKGM02052VO> voList;
	
	/**��Ϣ����*/
	protected int count;
	
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public List<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}

	/**
	 * ��������ȡ��
	 * @return ��������
	 */
	public String getKntelareaname() {
		return kntelareaname;
	}

	/**
	 * ���������趨
	 * @param kntelareaname ��������
	 */
	public void setKntelareaname(String kntelareaname) {
		this.kntelareaname = kntelareaname;
	}

	/**
	 * ��ȡ֪ʶ��ѯ�ӿ�
	 * @return ֪ʶ��ѯ�ӿ�
	 */
	public KnowledgeSearchCond getKnowledgeSearchCond() {
		return knowledgeSearchCond;
	}
	
	/**
	 * ����֪ʶ��ѯ�ӿ�
	 * @param knowledgeSearchCond ֪ʶ��ѯ�ӿ�
	 */
	public void setKnowledgeSearchCond(KnowledgeSearchCond knowledgeSearchCond) {
		this.knowledgeSearchCond = knowledgeSearchCond;
	}


	/**
	 * ��ȡ�����ѯ������¼��
	 * @return �����ѯ������¼��
	 */
	public int getMaxSearchCount() {
		return maxSearchCount;
	}

	/** �û���Ϣ*/
	protected User user;
	
	/** �ؼ���*/
	protected String keys;
	
	/** ��֪ʶ��ϸҳ�������ID */
	protected Integer prid;
	
	/** ��֪ʶ��ϸҳ��Ĺ���ID */
	protected Integer sfid;
	/**
	 *����ԭ������
	 */
	protected String[] knrejects;
	
	/**
	 *�汾����
	 */
	protected String[] knversions;
	/**
	 *�汾����ȡ��
	 * 
	 * @return �汾����
	 */
	public String[] getKnversions() {
		return knversions;
	}
	/**
	 * �汾�����趨
	 * @param knversions �汾����
	 */
	public void setKnversions(String[] knversions) {
		this.knversions = knversions;
	}
	
	/**
	 *����ԭ������ȡ��
	 * 
	 * @return ����ԭ������
	 */
	public String[] getKnrejects() {
		return knrejects;
	}
	/**
	 * ����ԭ�������趨
	 * @param knrejects ����ԭ������
	 */
	public void setKnrejects(String[] knrejects) {
		this.knrejects = knrejects;
	}
	/**
	 * ���������ѯ������¼��
	 * @param maxSearchCount �����ѯ������¼��
	 */
	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}
	
	
	public IGKGM0201Form getIgkgm0201Form() {
		return igkgm0201Form;
	}

	public void setIgkgm0201Form(IGKGM0201Form igkgm0201Form) {
		this.igkgm0201Form = igkgm0201Form;
	}
	
	public IGKGM0203Form getIgkgm0203Form() {
		return igkgm0203Form;
	}

	public void setIgkgm0203Form(IGKGM0203Form igkgm0203Form) {
		this.igkgm0203Form = igkgm0203Form;
	}

	public PagingDTO getPagingDto() {
		return pagingDto;
	}
	
	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}
	
	//-----------------------------------------------------------�κ���----------------------------------------------------------------------
	/** ֪ʶ����� */
	private List<Knowledge>  knowledgeList;
	/**
	 * ֪ʶ�������ȡ��
	 * @return ֪ʶ�����
	 */
	public List<Knowledge> getKnowledgeList() {
		return knowledgeList;
	}
	/**
	 * �趨֪ʶ�����
	 * @param knowledgeList ֪ʶ�����
	 */
	public void setKnowledgeList(List<Knowledge> knowledgeList) {
		this.knowledgeList = knowledgeList;
	}
	
	/**
	 *֪ʶid����
	 */
	protected String[] knids;
	/**
	 *֪ʶid����ȡ��
	 * 
	 * @return ֪ʶid����
	 */
	public String[] getKnids() {
		return knids;
	}
	
	/**
	 *֪ʶid�����趨
	 * 
	 * @param knids ֪ʶid����
	 */
	public void setKnids(String[] knids) {
		this.knids = knids;
	}
	
	/**
	 *״̬
	 */
	protected String knstatus;
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
   //-----------------------------------------------------------����----------------------------------------------------------------------
	
	
	
	//-----------------------------------------------------------����ǿ----------------------------------------------------------------------
	
	/**֪ʶ��ѯ���List */
	protected List<KnowLedgeInfo> knowLedgeInfoList;
	
	/**֪ʶID*/
	protected Integer knid;
	
	/**֪ʶ�汾*/
	protected Integer knversion;
	
	/**֪ʶ���ֲ�ѯ���List */
	protected List<KnowledgeGrade> knowledgeGradeList;
	
	/**֪ʶ��Ϣ��ϸ*/
	protected Knowledge knowledge;
	
	/**֪ʶ������̲�ѯ���List*/
	protected List<KnowledgeProcess> knowledgeProcessList;

	/**֪ʶ�Ǽ�Form*/
	protected IGKGM0207Form igkgm0207Form;
	
	/**
	 * ֪ʶ�Ǽ�Formȡ��
	 * @return ֪ʶ�Ǽ�Form
	 */
	public IGKGM0207Form getIgkgm0207Form() {
		return igkgm0207Form;
	}

	/**
	 * ֪ʶ�Ǽ�Form�趨
	 * @param igkgm0207Form ֪ʶ�Ǽ�Form
	 */
	public void setIgkgm0207Form(IGKGM0207Form igkgm0207Form) {
		this.igkgm0207Form = igkgm0207Form;
	}

	/**
	 * ֪ʶ������̲�ѯ���ȡ��
	 * @return ֪ʶ������̲�ѯ���
	 */
	public List<KnowledgeProcess> getKnowledgeProcessList() {
		return knowledgeProcessList;
	}

	/**
	 * ֪ʶ������̲�ѯ����趨
	 * @param knowledgeProcessList ֪ʶ������̲�ѯ���
	 */
	public void setKnowledgeProcessList(List<KnowledgeProcess> knowledgeProcessList) {
		this.knowledgeProcessList = knowledgeProcessList;
	}

	/**
	 * ֪ʶ��Ϣ��ϸȡ��
	 * @return ֪ʶ��Ϣ��ϸ
	 */
	public Knowledge getKnowledge() {
		return knowledge;
	}

	/**
	 * ֪ʶ��Ϣ��ϸ�趨
	 * @param knowledge ֪ʶ��Ϣ��ϸ
	 */
	public void setKnowledge(Knowledge knowledge) {
		this.knowledge = knowledge;
	}

	
	/**
	 * ֪ʶ���ֲ�ѯ���Listȡ��
	 * @return ֪ʶ���ֲ�ѯ���List
	 */
	public List<KnowledgeGrade> getKnowledgeGradeList() {
		return knowledgeGradeList;
	}

	/**
	 * ֪ʶ���ֲ�ѯ���List�趨
	 * @param knowledgeGradeList ֪ʶ���ֲ�ѯ���List
	 */
	public void setKnowledgeGradeList(List<KnowledgeGrade> knowledgeGradeList) {
		this.knowledgeGradeList = knowledgeGradeList;
	}
	
	/**
	 * ֪ʶIDȡ��
	 * @return ֪ʶID
	 */
	public Integer getKnid() {
		return knid;
	}

	/**
	 * ֪ʶID�趨
	 * @param knid ֪ʶID
	 */
	public void setKnid(Integer knid) {
		this.knid = knid;
	}
	
	/**
	 * ֪ʶ��ѯ���Listȡ��
	 * @return ֪ʶ��ѯ���List
	 */
	public List<KnowLedgeInfo> getKnowLedgeInfoList() {
		return knowLedgeInfoList;
	}

	/**
	 * ֪ʶ��ѯ���List�趨
	 * @param knowLedgeInfoList ֪ʶ��ѯ���List
	 */
	public void setKnowLedgeInfoList(List<KnowLedgeInfo> knowLedgeInfoList) {
		this.knowLedgeInfoList = knowLedgeInfoList;
	}
	/**
	 * ֪ʶ�汾��ȡ��
	 * @return ֪ʶ�汾��
	 */
	public Integer getKnversion() {
		return knversion;
	}

	/**
	 * ֪ʶ�汾���趨
	 * @param knversion ֪ʶ�汾��
	 */
	public void setKnversion(Integer knversion) {
		this.knversion = knversion;
	}
	
	/**����Ӱ��Ӧ��ϵͳList*/
	protected List<KnowledgeAppImpact> knowledgeAppImpactList;
	
	/**����ҵ��ϵͳMap*/
	protected Map<LabelValueBean,String> knowledgeAppImpactMap;
	
	public List<KnowledgeAppImpact> getKnowledgeAppImpactList() {
		return knowledgeAppImpactList;
	}

	public void setKnowledgeAppImpactList(List<KnowledgeAppImpact> knowledgeAppImpactList) {
		this.knowledgeAppImpactList = knowledgeAppImpactList;
	}
	
	public Map<LabelValueBean, String> getKnowledgeAppImpactMap() {
		return knowledgeAppImpactMap;
	}

	public void setKnowledgeAppImpactMap(
			Map<LabelValueBean, String> knowledgeAppImpactMap) {
		this.knowledgeAppImpactMap = knowledgeAppImpactMap;
	}
	
	/**�¼�����ϵͳ����*/
	protected List<LabelValueBean> system_typeList;
	
	/**
	 * �¼�����ϵͳȡ��
	 * @return �¼�����ϵͳ
	 */
	public List<LabelValueBean> getSystem_typeList() {
		return system_typeList;
	}
	
	/**
	 * �¼�����ϵͳ����
	 * @param system_typeList �¼�����ϵͳ
	 */
	public void setSystem_typeList(List<LabelValueBean> system_typeList) {
		this.system_typeList = system_typeList;
	}
	
	//-----------------------------------------------------------�޶���----------------------------------------------------------------------
	
	/**һ��֪ʶ�д���û�������ĸ��°汾��*/
	protected int versions;

	/**
	 * �û���Ϣ��ȡ
	 * @return �û���Ϣ
	 */
	public User getUser() {
		return user;
	}

	/**
	 * �û���Ϣ�趨
	 * @param user �û���Ϣ
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * �ؼ��ֻ�ȡ
	 * @return �ؼ���
	 */
	public String getKeys() {
		return keys;
	}

	/**
	 * �ؼ����趨
	 * @param user �ؼ���
	 */
	public void setKeys(String keys) {
		this.keys = keys;
	}

	/**
	 * ֪ʶ��ѯform��ȡ
	 * @return ֪ʶ��ѯform
	 */
	public IGKGM0202Form getIgkgm0202Form() {
		return igkgm0202Form;
	}
	/**֪ʶ��ѯform�趨
	 * @param igkgm0202Form ֪ʶ��ѯ
	 */
	public void setIgkgm0202Form(IGKGM0202Form igkgm0202Form) {
		this.igkgm0202Form = igkgm0202Form;
	}
	
	/**
	 * ��֪ʶ��ϸҳ�������IDȡ��
	 * @return ��֪ʶ��ϸҳ�������ID
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * ��֪ʶ��ϸҳ�������ID�趨
	 * @param prid��֪ʶ��ϸҳ�������ID
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	/**
	 * ��֪ʶ��ϸҳ��Ĺ���IDȡ��
	 * @return ��֪ʶ��ϸҳ��Ĺ���ID
	 */
	public Integer getSfid() {
		return sfid;
	}

	/**
	 * ��֪ʶ��ϸҳ��Ĺ���ID�趨
	 * @param sfid��֪ʶ��ϸҳ��Ĺ���ID
	 */
	public void setSfid(Integer sfid) {
		this.sfid = sfid;
	}
	
	/**
	 * ֪ʶ������ϸ��ѯ
	 * @return igkgm0216Form֪ʶ������ϸ��ѯ
	 */
	public IGKGM0216Form getIgkgm0216Form() {
		return igkgm0216Form;
	}

	/**
	 * ֪ʶ������ϸ��ѯ
	 * @param igkgm0216Form֪ʶ������ϸ��ѯ
	 */
	public void setIgkgm0216Form(IGKGM0216Form igkgm0216Form) {
		this.igkgm0216Form = igkgm0216Form;
	}

	/**
	 * ���ݿ���ҹؼ�������
	 * @return ���ݿ���ҹؼ�������
	 */
	public List getKeysFromDB() {
		return keysFromDB;
	}

	/**
	 * ���ݿ���ҹؼ���
	 * @param ���ݿ���ҹؼ�������
	 */
	public void setKeysFromDB(List keysFromDB) {
		this.keysFromDB = keysFromDB;
	}

	/**
	 * δ��������֪ʶ��
	 * @return δ��������֪ʶ��
	 */
	public int getVersions() {
		return versions;
	}

	/**
	 * δ��������֪ʶ��
	 * @param δ��������֪ʶ��
	 */
	public void setVersions(int versions) {
		this.versions = versions;
	}

	/**
	 * ��������
	 * @return ��������
	 */
	public String getProcessName() {
		return ProcessName;
	}

	/**
	 * ��������
	 * @param ��������
	 */
	public void setProcessName(String processName) {
		ProcessName = processName;
	}

	/**
	 * ����id
	 * @return ����id
	 */
	public String getProcessID() {
		return ProcessID;
	}

	/**
	 * ����id
	 * @param ����id
	 */
	public void setProcessID(String processID) {
		ProcessID = processID;
	}

	/**
	 * @return the delFiles
	 */
	public String getDelFiles() {
		return delFiles;
	}

	/**
	 * @param delFiles the delFiles to set
	 */
	public void setDelFiles(String delFiles) {
		this.delFiles = delFiles;
	}

	public String getRlcomment() {
		return rlcomment;
	}

	public void setRlcomment(String rlcomment) {
		this.rlcomment = rlcomment;
	}

	/**
	 * @return the delKgm
	 */
	public String getDelKgm() {
		return delKgm;
	}

	/**
	 * @param delKgm the delKgm to set
	 */
	public void setDelKgm(String delKgm) {
		this.delKgm = delKgm;
	}

	/**
	 * ֪ʶ��������formȡ��
	 * @return ֪ʶ��������form
	 */
	public IGKGM0228Form getIgkgm0228Form() {
		return igkgm0228Form;
	}

	/**
	 * ֪ʶ��������form�趨
	 * @param igkgm0228Form ֪ʶ��������form
	 */
	public void setIgkgm0228Form(IGKGM0228Form igkgm0228Form) {
		this.igkgm0228Form = igkgm0228Form;
	}

	/**
	 * ��Ҫ����֪ʶ����Ϣ����ȡ��
	 * @return ��Ҫ����֪ʶ����Ϣ����
	 */
	public List<Knowledge> getKnowledgelist() {
		return knowledgelist;
	}

	/**
	 * ��Ҫ����֪ʶ����Ϣ�����趨
	 * @param knowledgelist ��Ҫ����֪ʶ����Ϣ����
	 */
	public void setKnowledgelist(List<Knowledge> knowledgelist) {
		this.knowledgelist = knowledgelist;
	}

	public String getMessageflag() {
		return messageflag;
	}

	public void setMessageflag(String messageflag) {
		this.messageflag = messageflag;
	}

	/**
	 * ��ʷҵ��ϵͳȡ��
	 * @return ��ʷҵ��ϵͳ
	 */
	public List<IGKGM02052VO> getVoList() {
		return voList;
	}

	/**
	 * ��ʷҵ��ϵͳ�趨
	 * @param voList ��ʷҵ��ϵͳ
	 */
	public void setVoList(List<IGKGM02052VO> voList) {
		this.voList = voList;
	}

	public String getSessionID() {
		return SessionID;
	}

	public void setSessionID(String sessionID) {
		SessionID = sessionID;
	}
}