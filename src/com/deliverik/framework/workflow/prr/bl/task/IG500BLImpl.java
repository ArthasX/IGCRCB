/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.framework.workflow.prr.bl.task;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.igflow.api.Constants;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.WorkFlowConstDefine;
import com.deliverik.framework.workflow.prd.bl.task.IG105BL;
import com.deliverik.framework.workflow.prd.bl.task.IG380BL;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.IG500ONLYInfo;
import com.deliverik.framework.workflow.prr.model.IG677Info;
import com.deliverik.framework.workflow.prr.model.IG787Info;
import com.deliverik.framework.workflow.prr.model.IG808Info;
import com.deliverik.framework.workflow.prr.model.condition.IG500SearchCond;
import com.deliverik.framework.workflow.prr.model.condition.IG677SearchCond;
import com.deliverik.framework.workflow.prr.model.condition.IG677SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG787SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.dao.IG500DAO;
import com.deliverik.framework.workflow.prr.model.dao.IG677DAO;
import com.deliverik.framework.workflow.prr.model.dao.IG808DAO;
import com.deliverik.framework.workflow.prr.model.entity.IG500TB;
import com.deliverik.infogovernor.asset.model.condition.RehearseSearchCond;
import com.deliverik.infogovernor.asset.model.dao.RehearseDAO;

/**
 * <p>
 * ���̼�¼��Ϣҵ���߼�ʵ��
 * </p>
 */

public class IG500BLImpl  extends BaseBLImpl implements IG500BL{
	
    // ���ο���log
    static Log igflowlog = LogFactory.getLog(Constants.IGFLOW_LOG_NAME);

	/** ��ɫ��֯�ܹ���ϵ��DAO�ӿ� */
	protected RehearseDAO rehearseDAO;

	/**IG500DAO����*/
	protected IG500DAO ig500DAO;
	
	/** ע��IG677DAO */
	protected IG677DAO ig677DAO;
	
	protected IG787BL ig787BL;
	
	/** ���̲�����ϢBL */
	protected IG105BL ig105BL;
	
	/** ���̶�����ϢBL */
	protected IG380BL ig380BL;

	public void setRehearseDAO(RehearseDAO rehearseDAO) {
		this.rehearseDAO = rehearseDAO;
	}
	
	public void setIg787BL(IG787BL ig787BL) {
		this.ig787BL = ig787BL;
	}
	
	public void setIg380BL(IG380BL ig380BL) {
		this.ig380BL = ig380BL;
	}
	
	/**
	 * �������̻�����Ϣ����
	 * @param ig500DAO IG500DAO
	 */
	
	public void setIg500DAO(IG500DAO ig500DAO){
		this.ig500DAO = ig500DAO;
	}

	/**
	 * ����ProcessRecordVWDAO
	 * 
	 * @param ig677DAO
	 *            IG677DAO
	 */

	public void setIg677DAO(IG677DAO ig677DAO) {
		this.ig677DAO = ig677DAO;
	}
	
	
	/**
	 * ע��OrganizationProcessCountVWDAO
	 */

	protected IG808DAO ig808DAO;
	
	public void setIg808DAO(
			IG808DAO ig808DAO) {
		this.ig808DAO = ig808DAO;
	}
	
	/**
	 * ���̲�����ϢBL�趨
	 * @param Ig105BL���̲�����ϢBL
	 */
	public void setIg105BL(IG105BL ig105BL) {
		this.ig105BL = ig105BL;
	}


	/**
	 * <p>
	 * ��������ʵ��
	 * </p>
	 * 
	 * @param ig500Info ���̼�¼
	 * @return ���̼�¼
	 * @throws BLException
	 */

	public synchronized IG500Info registIG500Info(IG500Info ig500Info)
			throws BLException{
		IG500TB prTB = getIG500TBInstance();
		this.copyProperties(prTB,ig500Info);
		IG380Info ig380Info = null;
		if(StringUtils.isNotEmpty(ig500Info.getPrpdid())) {
			prTB.setPrStrategyVersion(this.ig105BL.getMaxgPsdversion(ig500Info.getPrpdid()));
			ig380Info = this.ig380BL.searchIG380InfoByKey(ig500Info.getPrpdid());
		}
		if(ig380Info != null && StringUtils.isNotEmpty(ig380Info.getSerialgenerator())) {
			//�Զ��������ڴ˴������ɹ����ţ����ڷ���֮������
//			WorkFlowSerialnumGeneratorBL bl = null;
//			try {
//				bl = (WorkFlowSerialnumGeneratorBL)WebApplicationSupport.getBean(ig380Info.getSerialgenerator());
//			} catch (Exception e) {
//				throw new BLException("IGCO10000.E004", "����������������");
//			}
//			igflowlog.debug("========================�����������¼���ʼ========================");
//			igflowlog.debug("������������:" + ig500Info.getPrpdname());
//			igflowlog.debug("��������ID:" + ig500Info.getPrpdid());
//			igflowlog.debug("���̱���:" + ig500Info.getPrtitle());
//			igflowlog.debug("����BL:" + ig380Info.getSerialgenerator());
//			prTB.setPrserialnum(bl.serialnumGenerator());
//			igflowlog.debug("���ɹ�����:" + prTB.getPrserialnum());
//			igflowlog.debug("========================�����������¼�����========================");
		} else {
			prTB.setPrserialnum(this.getSerialNum(ig500Info.getPrtype()));
		}
		return ig500DAO.save(prTB);
	}

	/**
	 * <p>
	 * Description: ����������Ϣ
	 * </p>
	 * 
	 * @param ig500Info ProcessRecord
	 * @return ProcessRecord
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 */

	public IG500Info updateIG500Info(IG500Info ig500Info)
			throws BLException{
		checkExistProcessRecord(ig500Info.getPrid());
		ig500Info = ig500DAO.save(ig500Info);
		return ig500Info;
	}

	/**
	 * <p>
	 * �������̼�¼��Ϣ
	 * </p>
	 * 
	 * @param cond ���̼�¼��Ϣ��������
	 * @return ���̼�¼��Ϣ�б�
	 * @throws BLException
	 */

	public List<IG500Info> searchIG500Info(IG500SearchCond cond){
		/*List<ProcessRecord> prList = ig500DAO.findByCond(cond, 0, 0);
		List<ProcessRecord> incidentList = new ArrayList<ProcessRecord>();
		List<ProcessRecord> allList = new ArrayList<ProcessRecord>();
		for(ProcessRecord pr : prList){
			if("I".equals(pr.getPrtype())&&StringUtils.isEmpty(pr.getPrclosetime())){
				incidentList.add(pr);
			}
		}
		allList.addAll(incidentList);
		prList.removeAll(incidentList);
		allList.addAll(prList);
		return allList;*/
		return ig500DAO.findByCond(cond, 0, 0);
	}
	
	/**
	 * <p>
	 * �������̼�¼��Ϣ
	 * </p>
	 * 
	 * @param cond ���̼�¼��Ϣ��������
	 * @param start ������ʼ����
	 * @param count ��������
	 * @return ���̼�¼��Ϣ�б�
	 * @throws BLException
	 */

	public List<IG500Info> searchIG500Info(
			IG500SearchCond cond, int start, int count){
		return ig500DAO.findByCond(cond, start, count);
	}
	
	
	
	/**
	 * �������̲�ѯ
	 * @param cond
	 * @param start
	 * @param count
	 * @return
	 */
	public List<IG500Info> searchDrillProcess(IG500SearchCond cond, int start,  int count){
		return ig500DAO.searchDrillProcess(cond, start, count);
	}
	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG500Info> queryIG500EntityListByProcessInfo(IG500SearchCond cond, int start, int count){
		return ig500DAO.queryIG500EntityListByProcessInfo(cond, start, count);
	}

	/**
	 * <p>
	 * �������̼�¼ID��ȡ���̼�¼��Ϣ
	 * </p>
	 * 
	 * @param processId ���̼�¼ID
	 * @return ���̼�¼
	 * @throws BLException 
	 */
	
	public IG500Info searchIG500InfoByKey(Integer processId) throws BLException{
		return checkExistProcessRecord(processId);
	}
	
	/**
	 * ��ȡ���̼�¼ʵ��
	 * @return ProcessRecordTB
	 * @throws BLException
	 */
	
	public IG500TB getIG500TBInstance(){
		return new IG500TB();
	}
	
	/**
	 * <p>
	 * �������̼�¼����
	 * </p>
	 * 
	 * @param cond ���̼�¼��������
	 * @return ���̼�¼����
	 */
	
	public int getIG500InfoSearchCount(IG500SearchCond cond){
		return ig500DAO.getSearchCount(cond);
	}
	
	protected String getSerialNum(String processType){
		String serialNum = "";
		if(WorkFlowConstDefine.FLOW_NUMBER_0.equals(WorkFlowConstDefine.WORKFLOW_SERIALNUM_MODE)){
			int leftPad_index = 0;
			//��ܱ���
			int type_length = processType.length();
			if(type_length == 1){
				leftPad_index =  5 ;
			}else if(type_length == 2){
				leftPad_index =  4 ;
			}else if(type_length == 3){
				leftPad_index =  3 ;
			}
	//		if(processType.length() > 1){
	//			processType = processType.substring(0,1);
	//		}
			Calendar c = Calendar.getInstance();
			serialNum = processType + String.valueOf(c.get(Calendar.YEAR)).substring(2);
			String maxSerialNum =  ig500DAO.getMaxPrserialnum(serialNum);
			if(null == maxSerialNum){
				return serialNum + StringUtils.leftPad("1", leftPad_index ,"0");
			}
			String num = "";
			if(processType.length() == 3){
				num = maxSerialNum.substring(5);
			}else if(processType.length() == 2){
				num = maxSerialNum.substring(4);
			}else if(processType.length() == 1){
				num = maxSerialNum.substring(3);
			}
			
			int maxNumber = Integer.valueOf(num) + 1;
			serialNum = serialNum + StringUtils.leftPad(String.valueOf(maxNumber), leftPad_index ,"0");
		}else if(WorkFlowConstDefine.FLOW_NUMBER_1.equals(WorkFlowConstDefine.WORKFLOW_SERIALNUM_MODE)){
			Calendar c = Calendar.getInstance();
			int leftPad_index = 0;
			//��ܱ���
			int type_length = processType.length();
			if(type_length == 1){
				leftPad_index =  4 ;
			}else if(type_length == 2){
				leftPad_index =  3 ;
			}else if(type_length == 3){
				leftPad_index =  2 ;
			}
			serialNum = processType + String.valueOf(c.get(Calendar.YEAR)).substring(2) + IGStringUtils.getCurrentDate().substring(5, 7) + IGStringUtils.getCurrentDate().substring(8, 10);;
			String maxSerialNum =  ig500DAO.getMaxPrserialnum(serialNum);
			if(null == maxSerialNum){
				
				return serialNum + StringUtils.leftPad("1", leftPad_index ,"0");
			}
			String num = "";
			if(processType.length() == 3){
				num = maxSerialNum.substring(9);
			}else if(processType.length() == 2){
				num = maxSerialNum.substring(8);
			}else if(processType.length() == 1){
				num = maxSerialNum.substring(7);
			}
			int maxNumber = Integer.valueOf(num) + 1;
			serialNum = serialNum + StringUtils.leftPad(String.valueOf(maxNumber), leftPad_index ,"0");
		}
		return serialNum;
	}
	
	/**
	 * ��������������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG500Info> queryServiceRequestList(final IG500SearchCond cond, final int start, final int count) {
		return ig500DAO.queryServiceRequestList(cond, start, count);
	}
	
	/**
	 * ������������������¼��
	 * @return ����������¼��
	 */
	public int queryServiceRequestListCount(final IG500SearchCond cond){
		return ig500DAO.queryServiceRequestListCount(cond);
	}
	
	/**
	 * ����(�����¼�������״̬��������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG500Info> queryIG500InfoSubStatusList(final IG500SearchCond cond, final int start, final int count) {
		/*List<ProcessRecord> prList = ig500DAO.queryProcessRecordSubStatusList(cond, start, count);
		List<ProcessRecord> incidentList = new ArrayList<ProcessRecord>();
		List<ProcessRecord> allList = new ArrayList<ProcessRecord>();
		for(ProcessRecord pr : prList){
			if("I".equals(pr.getPrtype())&&StringUtils.isEmpty(pr.getPrclosetime())){
				incidentList.add(pr);
			}else if("ID".equals(pr.getPrtype())&&StringUtils.isEmpty(pr.getPrclosetime())){
				incidentList.add(pr);
			}
		}
		allList.addAll(incidentList);
		prList.removeAll(incidentList);
		allList.addAll(prList);
		return allList;*/
		return ig500DAO.queryIG500InfoSubStatusList(cond, start, count);
	}
	
	
	/**
	 * ����(�����¼�������״̬��������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG500ONLYInfo> queryIG500ONLYInfoSubStatusList(final IG500SearchCond cond, final int start, final int count) {
		return ig500DAO.queryIG500ONLYInfoSubStatusList(cond, start, count);
	}
	
	/**
	 * ����(�����¼�������״̬������������¼��
	 * @return ����������¼��
	 */
	public int queryIG500InfoSubStatusListCount(IG500SearchCond cond){
		return ig500DAO.queryIG500InfoSubStatusListCount(cond);
	}
	
	/**
	 * ����(�����¼�������״̬������������¼��
	 * @return ����������¼��
	 */
	public int queryIG500ONLYInfoSubStatusListCount(IG500SearchCond cond){
		return ig500DAO.queryIG500ONLYInfoSubStatusListCount(cond);
	}
	
	/**
	 * ���ܣ����������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int queryIG500EntityCount(final IG500SearchCond cond){
		return ig500DAO.queryIG500EntityCount(cond);
	}

	
	/**
	 * <p>
	 * ��ȡָ����ɫ���еĴ������̼�¼
	 * </p>
	 * 
	 * @param roleId ��ɫID
	 * @param prType ���̼�¼����
	 * @return ���̼�¼������û���Ϣ�������
	 */
	public List<IG677Info> getTodoProcessRecordsByRole(Integer roleId,
			String prType) {

		IG677SearchCondImpl cond = new IG677SearchCondImpl();
		cond.setPproleid(roleId);
		cond.setPrtype(prType);
		cond.setTodo(true);
		List<IG677Info> prList = ig677DAO.findByCond(cond, 0, 0);
		List<IG677Info> incidentList = new ArrayList<IG677Info>();
		List<IG677Info> allList = new ArrayList<IG677Info>();
		for(IG677Info pr : prList){
			if("I".equals(pr.getPrtype())){
				incidentList.add(pr);
			}
		}
		allList.addAll(incidentList);
		prList.removeAll(incidentList);
		allList.addAll(prList);
		return allList;
	}

	
	/**
	 * <p>
	 * ��ȡָ���û����еĴ������̼�¼
	 * </p>
	 * 
	 * @param userId �û�ID
	 * @param prType ���̼�¼����
	 * @param pdid ���̶���ID
	 * @return ���̼�¼������û���Ϣ�������
	 */
	public List<IG677Info> getTodoProcessRecordsByUser(String userId,
			String prType,String pdid,String prstatus) {
		IG677SearchCondImpl cond = new IG677SearchCondImpl();
		cond.setPpuserid(userId);
		cond.setPrtype(prType);
		cond.setPrpdid(pdid);
		cond.setPpstatus(prstatus);
		cond.setTodo(true);
		List<IG677Info> prList = ig677DAO.findByCond(cond, 0, 0);
		
		//��ѯ�Զ������̣�������Ȩ�����̣�
//		ProcessRecordSearchCondImpl cond1 = new ProcessRecordSearchCondImpl();
//		cond1.setPrActive("Y");//δ�ر�
//		cond1.setUserid_q(userId2);
//		List<ProcessRecord> processRecordList = searchProcessRecordForSelfDef(cond1,0,0);
		
		//List<ProcessRecordInfo> prList = new ArrayList<ProcessRecordInfo>();
		
//		for(ProcessRecordInfo pri : temp_prList){
//			for(ProcessRecord pr:processRecordList){
//				if(pri.getPrid().equals(pr.getPrid())){
//					prList.add(pri);
//					break;
//				}
//				
//			}
//		}
		
		
		List<IG677Info> incidentList = new ArrayList<IG677Info>();
		List<IG677Info> allList = new ArrayList<IG677Info>();
		for(IG677Info pr : prList){
			if("I".equals(pr.getPrtype())){
				incidentList.add(pr);
			}
		}
		allList.addAll(incidentList);
		prList.removeAll(incidentList);
		allList.addAll(prList);
		return allList;
	}
	
	/**
	 * <p>
	 * ��ѯ������صĹ�ͨ������Ϣ
	 * </p>
	 * 
	 */
	public List<String> getProcessInfoDefGeneral(List<IG677Info> list, Integer pidGeneralId) {
		List<String> varlist = new ArrayList<String>();
		
		for(IG677Info pr:list){

			//��ѯ�Ƿ���ڹ�ͨ����
			IG787SearchCondImpl pigcond = new IG787SearchCondImpl();
			pigcond.setPrid(pr.getPrid());
			pigcond.setPidgid(pidGeneralId);
			List<IG787Info> pigList  = ig787BL.findByCond(pigcond, 0, 0);
			
			if(pigList!=null && pigList.size()>0){
				varlist.add(pigList.get(0).getGeneralvalue().length()>=5?pigList.get(0).getGeneralvalue().substring(5):pigList.get(0).getGeneralvalue());
			}else{
				varlist.add("");
			}
				
		}
			
		return varlist;
	}
	
	
//	/**
//	 * <p>
//	 * ���ݼ���������ȡ���̼�¼������û���Ϣ�������
//	 * </p>
//	 * 
//	 * @param ProcessRecordInfoSearchCond ���̼�¼������û���Ϣ��������
//	 * @return ���̼�¼������û���Ϣ�������
//	 */
//
//	public int getSearchCount(ProcessRecordInfoSearchCond cond) {
//		return ig677DAO.getSearchCount(cond);
//	}
	
	/**
	 * <p>
	 * ���ݼ���������ȡ���̼�¼������û���Ϣ
	 * </p>
	 * 
	 * @param cond ���̼�¼������û���Ϣ��������
	 * @param start ������ʼ����
	 * @param count ����������
	 * @return ���̼�¼������û���Ϣ�������
	 */

	public List<IG677Info> searchProcessRecordInfo(IG677SearchCond cond, int start, int count){
		List<IG677Info> prList = ig677DAO.findByCond(cond, start, count);
		List<IG677Info> incidentList = new ArrayList<IG677Info>();
		List<IG677Info> allList = new ArrayList<IG677Info>();
		
		for(IG677Info pr : prList){
			if("01080".equals(pr.getPrpdid())&&StringUtils.isEmpty(pr.getPrclosetime())){
				incidentList.add(pr);
			}
		}
		allList.addAll(incidentList);
		prList.removeAll(incidentList);
		allList.addAll(prList);
		return allList;
	}

	
	/**
	 * <p>
	 * ���ݼ���������ȡ���̼�¼������û���Ϣ
	 * </p>
	 * 
	 * @param cond ���̼�¼������û���Ϣ��������
	 * @return ���̼�¼������û���Ϣ�������
	 */

	public List<IG677Info> searchProcessRecordInfo(IG677SearchCond cond){
		List<IG677Info> prList = ig677DAO.findByCond(cond, 0, 0);
		List<IG677Info> incidentList = new ArrayList<IG677Info>();
		List<IG677Info> allList = new ArrayList<IG677Info>();
		for(IG677Info pr : prList){
		    if("01080".equals(pr.getPrpdid())&&StringUtils.isEmpty(pr.getPrclosetime())){
                incidentList.add(pr);
            }
		}
		allList.addAll(incidentList);
		prList.removeAll(incidentList);
		allList.addAll(prList);
		return allList;
	}

	/**
	 * <p>
	 * ���ݼ���������ȡ���̼�¼������û���Ϣ�������
	 * </p>
	 * 
	 * @param cond ���̼�¼������û���Ϣ��������
	 * @return ���̼�¼������û���Ϣ�������
	 */
	public int getProcessRecordVWSearchCount(IG677SearchCond cond) {
		return ig677DAO.getSearchCount(cond);
	}

	
	/**
	 * ���̼�¼��Ϣ���ڼ��
	 * 
	 * @param prid ���̼�¼ID
	 * @return  ���̼�¼��Ϣ
	 * @throws BLException 
	 */
	private IG500Info checkExistProcessRecord(Integer processId) throws BLException{
		IG500Info info = ig500DAO.findByPK(processId);
		if( info == null) {
			throw new BLException("IGCO10000.E004","���̼�¼����");
		}
		
		return info;
	}
	
	/**
	 * �������̼�¼��Ϣ����ɾ�����̼�¼��Ϣ����
	 * 
	 * @param prid ɾ�����̼�¼��Ϣ����
	 * @return
	 * @throws BLException
	 */
	public void deleteProcessRecordByKey(Integer prid) throws BLException{
		IG500Info processRecord = checkExistProcessRecord(prid);
		ig500DAO.delete(processRecord);
	}
	
	/**
	 * ɾ�����̼�¼��Ϣ����
	 * 
	 * @param processRecord ɾ�������̼�¼��Ϣ����
	 * @return
	 * @throws BLException
	 */
	public void deleteProcessRecord(IG500Info processRecord) throws BLException{
		checkExistProcessRecord(processRecord.getPrid());
		ig500DAO.delete(processRecord);
	}
	
	/**
	 * ָ���û�δ��������������������
	 * @param userid �û�ID
	 * @return ��������б�
	 */
	public List<IG500Info> queryActiveProcessByUserid(String userid){
		return ig500DAO.queryActiveProcessByUserid(userid);
	}
	
	/**
	 * <p>
	 * ��ȡ���̷����߽�ɫ���еĴ������̼�¼
	 * </p>
	 * 
	 * @param roleId ���̷����߽�ɫID
	 * @param prType ���̼�¼����
	 * @return ���̼�¼������û���Ϣ�������
	 */
	public List<IG677Info> getTodoProcessRecordsByFPRole(Integer roleId,
			String prType) {

		IG677SearchCondImpl cond = new IG677SearchCondImpl();
		cond.setPproleid(roleId);
		cond.setPrtype(prType);
		cond.setPrstatus(WorkFlowConstDefine.PPTYPE_ASSIGN_TO_PERSON);
		cond.setPpstatus(WorkFlowConstDefine.PPTYPE_ASSIGN_TO_PERSON);
		List<IG677Info> prList = ig677DAO.findByCond(cond, 0, 0);
		List<IG677Info> incidentList = new ArrayList<IG677Info>();
		List<IG677Info> allList = new ArrayList<IG677Info>();
		for(IG677Info pr : prList){
			if("I".equals(pr.getPrtype())){
				incidentList.add(pr);
			}
		}
		allList.addAll(incidentList);
		prList.removeAll(incidentList);
		allList.addAll(prList);
		return allList;
	}
	
	/**
	 * ���ָ���û��Ƿ����ָ�����̲鿴Ȩ�ޣ�Ŀǰֻ֧�ֱ����������
	 * @param userid �û�ID
	 * @param prid ����ID
	 * @return Ȩ�ޱ�ʶ
	 */
	public boolean checkLookDetailPermission(String userid, Integer prid){
		return ig500DAO.checkLookDetailPermission(userid, prid);
	}
	
	/**
	 * ������ָ������ɫʱ,�ڽ�ɫ�����˵��ҵĹ�������ʾ����������Ϣ
	 * @param userid �û�ID
	 * @return 
	 */
	public List<IG677Info> queryActiveProcessByFPRoleid(String userid){
		return ig500DAO.queryActiveProcessByFPRoleid(userid);
	}
	
	/**
	 * ����������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG500Info> queryProcessRecordEntityList(final IG500SearchCond cond, final int start, final int count) {
		List<IG500Info> prList = ig500DAO.queryIG500EntityList(cond, start, count);
		return prList;
	}

	/**
	 * ָ���û���ش�������������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @param closeFlag ��ѯ�رձ�־��0���Ѵ���1��δ��������������
	 * @param dealFlag  ��ѯ�����־��0���ѹرգ�1��δ�رգ�����������
	 * @return ��������б�
	 */
	public List<IG500Info> queryCorrelationProcessByUserid(final IG677SearchCond cond, 
			final int start, final int count, final int closeFlag, final int dealFlag) {
		return ig500DAO.queryCorrelationProcessByUserid(cond, start, count, closeFlag, dealFlag);
	}
	
	/**
	 * ָ���û���ش�������������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @param closeFlag ��ѯ�رձ�־��0���Ѵ���1��δ��������������
	 * @param dealFlag  ��ѯ�����־��0���ѹرգ�1��δ�رգ�����������
	 * @return �����������
	 */
	public int queryCorrelationProcessByUseridCount(final IG677SearchCond cond, 
			final int start, final int count, final int closeFlag, final int dealFlag) {
		return ig500DAO.queryCorrelationProcessByUseridCount(cond, start, count, closeFlag, dealFlag);
	}
	
	/**
	 * ָ����ɫδ��������������������
	 * @param roleid ��ɫID
	 * @return ��������б�
	 */
	public List<IG500Info> queryActiveProcessByRoleid(Integer roleid){
		return ig500DAO.queryActiveProcessByRoleid(roleid);
	}
	
	
	
	/**
	 * �Զ�������������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public int searchProcessRecordCountForSelfDef(IG500SearchCond cond){
		return ig500DAO.searchIG500CountForSelfDef(cond);
	}
	
	
	
	/**
	 * �Զ�������������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG500Info> searchProcessRecordForSelfDef(IG500SearchCond cond, int start, int count){
		return ig500DAO.searchIG500InfoForSelfDef(cond,start,count);
	}
	
	/**
	 * �Զ���������ع�������������¼��
	 * @return �Զ�����������������¼��
	 */
	public int searchProcessRecordCountForRelatedWork(IG500SearchCond cond){
		return ig500DAO.searchIG500InfoCountForRelatedWork(cond);
	}
	
	
	
	/**
	 * �Զ�������������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG500Info> searchProcessRecordForRelatedWork(IG500SearchCond cond, int start, int count){
		return ig500DAO.searchIG500InfoForRelatedWork(cond,start,count);
	}
	
	/**
	 * ��ҳ�ϰ�����ͳ�ƹ���������ѯ����
	 * @return ��������б�
	 */
	public List<IG808Info> getOrganizationProcessCount(){
		return ig808DAO.findIG808Info();
	}
	
	/**
	 * ���ܣ����ݹ�����ʶ��ѯ��ǰ�����ˮ��
	 * @param prserialnum ������ʶ
	 * @return �����ˮ��
	 */
	public String searchMaxPrserialnum(String prserialnum) {
		return ig500DAO.getMaxPrserialnum(prserialnum);
	}
	
	/**
	 * ���ܣ������ô�����idȡ�÷��������б�
	 * @return ��������б�
	 */
	public List<IG500Info> searchDispatchStatistics(IG677SearchCond cond, int start, int count){
		return ig500DAO.searchDispatchStatisticsVW(cond,start,count);
	}
	
	/**
	 * ���ܣ������ô�����idȡ�÷��������б�����
	 * @return ��¼����
	 */
	public int findDispatchStatisticsSearchCount(IG677SearchCond cond){
		return ig500DAO.findDispatchStatisticsSearchCount(cond);
	}
	
	/**
	 * ��ѯָ����ܱ���key����������
	 * @param type ��������
	 * @param pdid ������ID
	 * @param key ����ʵ��key
	 * @param isClose true����ѯ�ѹرգ�false����ѯδ�رգ�null����ѯȫ������������ֹ
	 * @return ��������
	 */
	public List<Integer> searchRegulatoryReportDetailByKey(final String type, final String pdid,
			final String key, final Boolean isClose) throws BLException{
		return ig500DAO.searchRegulatoryReportDetailByKey(type, pdid, key, isClose);
	}

	public List<IG500Info> searchProcessByType(IG500SearchCond cond,int start,int count, String type)
			throws BLException {
		//������������ǲ�ѯ���й�����Ϣ
		if(IGPRDCONSTANTS.SEARCH_ALL_PROCESS.equals(type)){
			return ig500DAO.queryIG500EntityListByProcessInfo(cond,start,count);
		}
		//������������ǲ�ѯ���Լ��Ĺ�����Ϣ
		if(IGPRDCONSTANTS.SEARCH_MY_PROCESS.equals(type)){
			return ig500DAO.searchMyProcess(cond,start,count);
		}
		//������������ǲ�ѯͬ�����Ĺ�����Ϣ
		if(IGPRDCONSTANTS.SEARCH_ORG_PROCESS.equals(type)){
			return ig500DAO.searchMyProcessByOrg(cond,start,count);
		}
		//������������ǲ�ѯͬ��ɫ�Ĺ�����Ϣ
		if(IGPRDCONSTANTS.SEARCH_ROLE_PROCESS.equals(type)){
			return ig500DAO.searchMyProcessByRole(cond,start,count);
		}
		//������������ǲ�ѯ���Լ�������Ĺ�����Ϣ
		if(IGPRDCONSTANTS.SEARCH_MY_UN_PROCESSED.equals(type)){
			return ig500DAO.searchMyUnProcessd(cond,start,count);
		}
		return null;
	}

	public Integer searchProcessByTypeCount(IG500SearchCond cond,
			String type) throws BLException {
		//������������ǲ�ѯ���й�����Ϣ
		if(IGPRDCONSTANTS.SEARCH_ALL_PROCESS.equals(type)){
			return ig500DAO.queryIG500EntityCount(cond);
		}
		//������������ǲ�ѯ���Լ��Ĺ�����Ϣ
		if(IGPRDCONSTANTS.SEARCH_MY_PROCESS.equals(type)){
			return ig500DAO.searchMyProcessCount(cond);
		}
		//������������ǲ�ѯͬ�����Ĺ�����Ϣ
		if(IGPRDCONSTANTS.SEARCH_ORG_PROCESS.equals(type)){
			return ig500DAO.searchMyProcessByOrgCount(cond);
		}
		//������������ǲ�ѯͬ��ɫ�Ĺ�����Ϣ
		if(IGPRDCONSTANTS.SEARCH_ROLE_PROCESS.equals(type)){
			return ig500DAO.searchMyProcessByRoleCount(cond);
		}
		return 0;
	}
	
	/**
	 * ��ȡ���̵�ǰ״̬��ʾ����
	 * @param prid ����ID
	 * @return ���̵�ǰ״̬��ʾ����
	 */
	public String searchCurrentStatusName(Integer prid) throws BLException {
		return this.ig500DAO.searchCurrentStatusName(prid);
	}
	
	/**
	 * ��ȡ���̵�ǰ״̬
	 * @param prid ����ID
	 * @return ���̵�ǰ״̬
	 */
	public List<String> searchCurrentStatus(final Integer prid) throws BLException {
		return this.ig500DAO.searchCurrentStatus(prid);
	}
	
	/**
	 * ��������
	 * @param cond
	 * @return
	 * @throws BLException
	 */
	public List<IG677Info> searchIG677InfoByCond(IG677SearchCond cond) throws BLException {
		return ig677DAO.findByCond(cond, 0, 0);
	}
	
	/**
	 * dashboard
	 *	������������������� ��������
	 * @param months
	 * @return List<Map>
	 * <p>
	 * 	map �ṹ   key :(DATEMONTH,PRPDID,PRPDNAME,ACOUNT,CLOSECOUNT)
	 * </p>
	 */
	@SuppressWarnings("rawtypes")
	public List<Map> getRiskAssess (String months,String prpdid)throws BLException{
		return ig500DAO.getRiskAssess(months,prpdid);
	}
	
	/**
	 * ��������
	 * @param cond
	 * @param start
	 * @param count
	 * @return
	 */
	public List<HashMap<String, Object>> searchIssueCorrectiveInfo(RehearseSearchCond cond, int start, int count) throws BLException{
		return rehearseDAO.searchIssueCorrectiveInfo(cond, start, count);
	}
	
	/**
	 * �������� ����������ȡ
	 * @param cond
	 * @param start
	 * @param count
	 * @return
	 */
	public List<IG500Info> searchIssueCorrectiveByField(RehearseSearchCond cond, int start, int count) throws BLException{
		return rehearseDAO.searchIssueCorrectiveByField(cond, start, count);
	}
		/** 
     * @Title: queryIG500WithStatusAndPart 
     * @Description: TODO ��ѯig500 ������״̬����ǰ����״̬�Ĳ�����
     * @param prSearchCond
     * @param i
     * @param j
     * @return    
     * List<IG500Info>    
     * @throws 
     */
    public List<Map<String, Object>> queryIG500WithStatusAndPart(IG500SearchCond prSearchCond, int i, int j)throws BLException{
        return ig500DAO.queryIG500WithStatusAndPart( prSearchCond,  i,  j);
    }
    /**
     * ��ѯӦ����������
     * @param cond
     * @param start
     * @param count
     * @return
     */
    public List<IG500Info> getDrmFlow(final IG500SearchCond cond,final int start,final int count){
    	return ig500DAO.getDrmFlow(cond, start, count);
    }
    
    /**
     * ��ѯӦ��������������
     * @param cond
     * @param start
     * @param count
     * @return
     */
    public Integer countDrmFlow(final IG500SearchCond cond){
    	return ig500DAO.countDrmFlow(cond);
    }
}
