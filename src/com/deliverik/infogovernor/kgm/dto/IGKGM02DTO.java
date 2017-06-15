/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.kgm.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.model.CodeDetailDef;
import com.deliverik.framework.workflow.prd.model.IG731Info;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.IG677Info;
import com.deliverik.framework.workflow.prr.model.condition.IG500SearchCond;
import com.deliverik.infogovernor.kgm.form.IGKGM0203Form;
import com.deliverik.infogovernor.kgm.form.IGKGM0231Form;
import com.deliverik.infogovernor.kgm.model.KnowLogInfo;
import com.deliverik.infogovernor.kgm.model.condition.KnowLogSearchCond;


/**
 * @Description: ֪ʶ����
 * @Author  
 * @History 2009-8-18     �½� 
 * @Version V2.0
 */
@SuppressWarnings("serial")
public class IGKGM02DTO extends BaseDTO implements Serializable {
    
	private String userid;
	
	private String username;
	
	private Integer roleid;
	
	private IG500SearchCond  prSearchCond;
	
	private IG500Info processRecord;
	
	private Integer prkid_r;
	
	private Integer prkid;

	private Map<String, List<List<IG677Info>>> processRecordMap;
	
	private Map<String, List<IG677Info>> allActiveProcessMap;

	private Integer prid;
	
	//============================>>2010-9-7 	  �޸� 0001103 start
	/** �������ʲ���ϵ */
	protected List<IG731Info> processInfoEntityList;
	
	/** ����ʲ���Ϣ */
	protected List<IG731Info> pieList;
	
	/**��ҳBean*/
	protected PagingDTO pagingDto;
	
	/**֪ʶ��ѯform*/
	protected IGKGM0203Form igkgm0203Form;
	
	/**�����ѯ������¼��*/
	protected int maxSearchCount;

	/** ֪ʶID */
	protected KnowLogSearchCond knowLogSearchCond;

	/**֪ʶ����־*/
	protected List<KnowLogInfo> recordList;
	
	/**֪ʶ��������ͳ��form*/
	protected IGKGM0231Form igkgm0231Form;
	
	/**ҵ��ϵͳ�����б�*/
	protected List<CodeDetailDef> businessSystemList;
	
	/**ҵ��ϵͳ��������*/
	protected String businessSystemSyscoding;

	/**
	 * ��ȡ�����ѯ������¼��
	 * @return �����ѯ������¼��
	 */
	public int getMaxSearchCount() {
		return maxSearchCount;
	}

	/**
	 * ���������ѯ������¼��
	 * @param maxSearchCount �����ѯ������¼��
	 */
	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
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
	//<<============================2010-12-07   �޸�wangxiaoqiang end
	
	
	//-----------------------------------------------------------�κ���----------------------------------------------------------------------
	
	
   //-----------------------------------------------------------����----------------------------------------------------------------------
	
	
	
	//-----------------------------------------------------------����ǿ----------------------------------------------------------------------
	
	
	//-----------------------------------------------------------�޶���----------------------------------------------------------------------
	public Integer getPrid() {
		return prid;
	}

	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	public Integer getPrkid() {
		return prkid;
	}

	public void setPrkid(Integer prkid) {
		this.prkid = prkid;
	}

	public Integer getPrkid_r() {
		return prkid_r;
	}

	public void setPrkid_r(Integer prkid_r) {
		this.prkid_r = prkid_r;
	}

	public String getUserid() {
		return userid;
	}

	public String getUsername() {
		return username;
	}

	public Integer getRoleid() {
		return roleid;
	}

	public IG500SearchCond getPrSearchCond() {
		return prSearchCond;
	}


	public IG500Info getProcessRecord() {
		return processRecord;
	}


	public Map<String, List<List<IG677Info>>> getProcessRecordMap() {
		return processRecordMap;
	}

	public Map<String, List<IG677Info>> getAllActiveProcessMap() {
		return allActiveProcessMap;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	public void setPrSearchCond(IG500SearchCond prSearchCond) {
		this.prSearchCond = prSearchCond;
	}


	public void setProcessRecord(IG500Info processRecord) {
		this.processRecord = processRecord;
	}

	public void setProcessRecordMap(
			Map<String, List<List<IG677Info>>> processRecordMap) {
		this.processRecordMap = processRecordMap;
	}

	public void setAllActiveProcessMap(
			Map<String, List<IG677Info>> allActiveProcessMap) {
		this.allActiveProcessMap = allActiveProcessMap;
	}

	
	//============================>>2010-9-7 	  �޸� 0001103 start
	/**
	 * �������ʲ���ϵȡ��
	 * @return �������ʲ���ϵ
	 */
	public List<IG731Info> getProcessInfoEntityList() {
		return processInfoEntityList;
	}

	/**
	 * �������ʲ���ϵ�趨
	 * @param processInfoEntityList �������ʲ���ϵ
	 */
	public void setProcessInfoEntityList(
			List<IG731Info> processInfoEntityList) {
		this.processInfoEntityList = processInfoEntityList;
	}

	/**
	 * ����ʲ���Ϣȡ��
	 * @return ����ʲ���Ϣ
	 */
	public List<IG731Info> getPieList() {
		return pieList;
	}

	/**
	 * ����ʲ���Ϣ�趨
	 * @param pieList ����ʲ���Ϣ
	 */
	public void setPieList(List<IG731Info> pieList) {
		this.pieList = pieList;
	}

	/**
	 * ֪ʶIDȡ��
	 * @return klkid ֪ʶID
	 */
	public KnowLogSearchCond getKnowLogSearchCond() {
		return knowLogSearchCond;
	}

	/**
	 * ֪ʶID�趨
	 * @param klkid ֪ʶID
	 */
	public void setKnowLogSearchCond(KnowLogSearchCond knowLogSearchCond) {
		this.knowLogSearchCond = knowLogSearchCond;
	}

	/**
	 * ֪ʶ����־ȡ��
	 * @return recordLogMap ֪ʶ����־
	 */
	public List<KnowLogInfo> getRecordList() {
		return recordList;
	}

	/**
	 * ֪ʶ����־�趨
	 * @param recordLogMap ֪ʶ����־
	 */
	public void setRecordList(List<KnowLogInfo> recordList) {
		this.recordList = recordList;
	}
	/**
	 * ֪ʶ��������ͳ��formȡ��
	 * @return igkgm0231Form ֪ʶ��������ͳ��form
	 */
	public IGKGM0231Form getIgkgm0231Form() {
		return igkgm0231Form;
	}
	
	/**
	 * ֪ʶ��������ͳ��form�趨
	 * @param igkgm0231Form ֪ʶ��������ͳ��form
	 */
	public void setIgkgm0231Form(IGKGM0231Form igkgm0231Form) {
		this.igkgm0231Form = igkgm0231Form;
	}

	public List<CodeDetailDef> getBusinessSystemList() {
		return businessSystemList;
	}

	public void setBusinessSystemList(List<CodeDetailDef> businessSystemList) {
		this.businessSystemList = businessSystemList;
	}

	public String getBusinessSystemSyscoding() {
		return businessSystemSyscoding;
	}

	public void setBusinessSystemSyscoding(String businessSystemSyscoding) {
		this.businessSystemSyscoding = businessSystemSyscoding;
	}


	
	
}