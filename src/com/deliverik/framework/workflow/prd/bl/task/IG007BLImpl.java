/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.workflow.prd.bl.task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.jdom.Element;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.workflow.WorkFlowConstDefine;
import com.deliverik.framework.workflow.prd.model.IG007Info;
import com.deliverik.framework.workflow.prd.model.condition.IG007SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG007SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.dao.IG007DAO;
import com.deliverik.framework.workflow.prd.model.entity.IG007TB;
import com.deliverik.framework.workflow.prr.model.IG337Info;
import com.deliverik.framework.workflow.prr.model.entity.IG337TB;

/**
 * <p>����:���̱�������ҵ���߼�ʵ��</p>
 * <p>����������1.��ȡ���̱�������ʵ��</p>
 * <p>          2.��ȡ���̱�������</p>
 * <p>          3.��ȡ���̱������ϣ�������ȱʡ����</p>
 * <p>          4.��ȡ���̱���ȱʡ������</p>
 * <p>          5.��ȡ���̱���ȱʡһ��������</p>
 * <p>          6.��ȡ���̱���ȱʡ����������</p>
 * <p>          7.��ȡ���̱���ȱʡ����������</p>
 * <p>          8.����������List����</p>
 * <p>  	    9.check���</p>
 * <p>			10.��ȡ���̱���ȱʡ����������(ppcomment��ȡ֮����Ҫ���)</p>
 * <p>			11.���������������ȡ��</p>
 * <p>			12.ȫ����������</p>
 * <p>			13.������������</p>
 * <p>			14.���̱���ID��ѯ����</p>
 * <p>			15.��¼����</p>
 * <p>			16.���´���</p>
 * <p>			17.ɾ������</p>
 * <p>			18.ȫ�ֱ������ڼ��</p>
 * <p>������¼��</p>
 */
public class IG007BLImpl extends BaseBLImpl implements IG007BL {
	
	/**���̱�������*/
	protected IG007DAO ig007DAO;
	
	/**
	 * ����:�������̱��������趨
	 * @param IG007DAO
	 */
	public void setIg007DAO(IG007DAO ig007DAO) {
		this.ig007DAO = ig007DAO;
	}

	/**
	 * ���ܣ���ȡ���̱�������ʵ��
	 * @return IG007TB
	 */
	
	public IG007TB getIG007TBInstance(){
		return new IG007TB();
	}
	
	/**
	 * ���ܣ���ȡ���̱�������
	 * @param pdid ���̶���ID
	 * @return  List<ProcessInfoDef> ���̱�������
	 */
	
	public List<IG007Info> searchIG007InfoByPdid(String pdid){
		IG007SearchCondImpl cond = new IG007SearchCondImpl();
		cond.setPdid(pdid);
		return ig007DAO.findByCond(cond, 0, 0);
	}
	
	/**
	 * ���ܣ���ȡ���̱������ϣ�������ȱʡ����
	 * @param pdid ���̶���ID
	 * @return  List<ProcessInfoDef> ���̱�������
	 */
	
	public List<IG007Info> searchIG007InfoNoDefault(String pdid){
		IG007SearchCondImpl cond = new IG007SearchCondImpl();
		cond.setPdid(pdid);
		cond.setIsDefault(WorkFlowConstDefine.NO);
		return ig007DAO.findByCond(cond, 0, 0);
	}
	
	/**
	 * ���ܣ���ȡ���̱���ȱʡ������
	 * @param pdid ���̶���ID
	 * @return  Map<String,List<IG337Info>> ���̱���ȱʡ������
	 */
	
	public Map<String,List<IG337Info>> getDefaultApprovors(String pdid){
		List<IG337Info> one = null;
		//����������List
		List<IG337Info> two = null;
		//����������List
		List<IG337Info> three = null;
		Map<String,List<IG337Info>> map = new HashMap<String,List<IG337Info>>();
		if(StringUtils.isNotEmpty(pdid)){
			one = this.getDefaultApprovorsOne(pdid);
			two = this.getDefaultApprovorsTwo(pdid);
			three = this.getDefaultApprovorsThree(pdid);
		}
		map.put(WorkFlowConstDefine.DEFAULT_APPROVOR_ONE, one);
		map.put(WorkFlowConstDefine.DEFAULT_APPROVOR_TWO, two);
		map.put(WorkFlowConstDefine.DEFAULT_APPROVOR_THREE, three);
		return map;
	}
	
	/**
	 * ���ܣ���ȡ���̱���ȱʡһ��������
	 * @param processDefinitionId ���̶���ID
	 * @return  List<ProcessParticipant> ���̱���ȱʡһ��������
	 */
	
	public List<IG337Info> getDefaultApprovorsOne(String processDefinitionId){
		IG007SearchCondImpl cond = new IG007SearchCondImpl();
		cond.setPdid(processDefinitionId);//��������ID
		cond.setPidname_like(WorkFlowConstDefine.DEFAULT_APPROVOR_ONE);//ȱʡһ�������˱�ʶ
		List<IG337Info> approvorsList = null;
		//���̱���List
		List<IG007Info> pidList = ig007DAO.findByCond(cond, 0, 0);
		//�����˸���
		int len = 0;
		for(IG007Info pid : pidList) {
			if(checkEqual(WorkFlowConstDefine.DEFAULT_APPROVOR_ROLEID_ONE, pid.getPidname()) && StringUtils.isNotEmpty(pid.getPiddesc())) {
				String[] approvors = pid.getPiddesc().split(WorkFlowConstDefine.SPILT_APPROVORS,-1);//��������ַ���
				len = approvors.length;
				break;
			}
		}
		if(len != 0) {
			approvorsList = this.createProcessParticipants(len);
			for(IG007Info pid : pidList) {
				if(StringUtils.isNotEmpty(pid.getPiddesc())) {
					String[] propertys = pid.getPiddesc().split(WorkFlowConstDefine.SPILT_APPROVORS,-1);
					if(checkEqual(WorkFlowConstDefine.DEFAULT_APPROVOR_ROLEID_ONE, pid.getPidname())) {
						for(int i = 0; i < len; i++) {
							((IG337TB)approvorsList.get(i)).setPproleid(Integer.parseInt(propertys[i]));
						}
					} else if(checkEqual(WorkFlowConstDefine.DEFAULT_APPROVOR_ROLENAME_ONE, pid.getPidname())) {
						for(int i = 0; i < len; i++) {
							((IG337TB)approvorsList.get(i)).setPprolename(propertys[i]);
						}
					} else if(checkEqual(WorkFlowConstDefine.DEFAULT_APPROVOR_USERID_ONE, pid.getPidname())) {
						for(int i = 0; i < len; i++) {
							((IG337TB)approvorsList.get(i)).setPpuserid(propertys[i]);
						}
					} else if(checkEqual(WorkFlowConstDefine.DEFAULT_APPROVOR_USERNAME_ONE, pid.getPidname())) {
						for(int i = 0; i < len; i++) {
							((IG337TB)approvorsList.get(i)).setPpusername(propertys[i]);
						}
					} else if(checkEqual(WorkFlowConstDefine.DEFAULT_APPROVOR_ORGSYSCODING_ONE, pid.getPidname())) {
						for(int i = 0; i < len; i++) {
							((IG337TB)approvorsList.get(i)).setPporgid(propertys[i]);
						}
					} else if(checkEqual(WorkFlowConstDefine.DEFAULT_APPROVOR_ORGNAME_ONE, pid.getPidname())) {
						for(int i = 0; i < len; i++) {
							((IG337TB)approvorsList.get(i)).setPporgname(propertys[i]);
						}
					}
				}
			}
		}
		return approvorsList;
	}
	/**
	 * ���ܣ���ȡ���̱���ȱʡ����������
	 * @param processDefinitionId ���̶���ID
	 * @return  List<ProcessParticipant> ���̱���ȱʡ����������
	 */
	
	public List<IG337Info> getDefaultApprovorsTwo(String processDefinitionId){
		IG007SearchCondImpl cond = new IG007SearchCondImpl();
		cond.setPdid(processDefinitionId);//��������ID
		cond.setPidname_like(WorkFlowConstDefine.DEFAULT_APPROVOR_TWO);//ȱʡ���������˱�ʶ
		List<IG337Info> approvorsList = null;
		List<IG007Info> pidList = ig007DAO.findByCond(cond, 0, 0);
		//�����˸���
		int len = 0;
		for(IG007Info pid : pidList) {
			if(checkEqual(WorkFlowConstDefine.DEFAULT_APPROVOR_ROLEID_TWO, pid.getPidname()) && StringUtils.isNotEmpty(pid.getPiddesc())) {
				String[] approvors = pid.getPiddesc().split(WorkFlowConstDefine.SPILT_APPROVORS,-1);//��������ַ���
				len = approvors.length;
				break;
			}
		}
		if(len != 0) {
			approvorsList = this.createProcessParticipants(len);
			for(IG007Info pid : pidList) {
				if(StringUtils.isNotEmpty(pid.getPiddesc())) {
					String[] propertys = pid.getPiddesc().split(WorkFlowConstDefine.SPILT_APPROVORS,-1);
					if(checkEqual(WorkFlowConstDefine.DEFAULT_APPROVOR_ROLEID_TWO, pid.getPidname())) {
						for(int i = 0; i < len; i++) {
							((IG337TB)approvorsList.get(i)).setPproleid(Integer.parseInt(propertys[i]));
						}
					} else if(checkEqual(WorkFlowConstDefine.DEFAULT_APPROVOR_ROLENAME_TWO, pid.getPidname())) {
						for(int i = 0; i < len; i++) {
							((IG337TB)approvorsList.get(i)).setPprolename(propertys[i]);
						}
					} else if(checkEqual(WorkFlowConstDefine.DEFAULT_APPROVOR_USERID_TWO, pid.getPidname())) {
						for(int i = 0; i < len; i++) {
							((IG337TB)approvorsList.get(i)).setPpuserid(propertys[i]);
						}
					} else if(checkEqual(WorkFlowConstDefine.DEFAULT_APPROVOR_USERNAME_TWO, pid.getPidname())) {
						for(int i = 0; i < len; i++) {
							((IG337TB)approvorsList.get(i)).setPpusername(propertys[i]);
						}
					} else if(checkEqual(WorkFlowConstDefine.DEFAULT_APPROVOR_ORGSYSCODING_TWO, pid.getPidname())) {
						for(int i = 0; i < len; i++) {
							((IG337TB)approvorsList.get(i)).setPporgid(propertys[i]);
						}
					} else if(checkEqual(WorkFlowConstDefine.DEFAULT_APPROVOR_ORGNAME_TWO, pid.getPidname())) {
						for(int i = 0; i < len; i++) {
							((IG337TB)approvorsList.get(i)).setPporgname(propertys[i]);
						}
					}
				}
			}
		}
		return approvorsList;
	}
	/**
	 * ���ܣ���ȡ���̱���ȱʡ����������
	 * @param processDefinitionId ���̶���ID
	 * @return  List<ProcessParticipant> ���̱���ȱʡ����������
	 */
	
	public List<IG337Info> getDefaultApprovorsThree(String processDefinitionId){
		IG007SearchCondImpl cond = new IG007SearchCondImpl();
		cond.setPdid(processDefinitionId);//��������ID
		cond.setPidname_like(WorkFlowConstDefine.DEFAULT_APPROVOR_THREE);//ȱʡ���������˱�ʶ
		List<IG337Info> approvorsList = null;
		List<IG007Info> pidList = ig007DAO.findByCond(cond, 0, 0);
		//�����˸���
		int len = 0;
		for(IG007Info pid : pidList) {
			if(checkEqual(WorkFlowConstDefine.DEFAULT_APPROVOR_ROLEID_THREE, pid.getPidname()) && StringUtils.isNotEmpty(pid.getPiddesc())) {
				String[] approvors = pid.getPiddesc().split(WorkFlowConstDefine.SPILT_APPROVORS,-1);//��������ַ���
				len = approvors.length;
				break;
			}
		}
		if(len != 0) {
			approvorsList = this.createProcessParticipants(len);
			for(IG007Info pid : pidList) {
				if(StringUtils.isNotEmpty(pid.getPiddesc())) {
					String[] propertys = pid.getPiddesc().split(WorkFlowConstDefine.SPILT_APPROVORS,-1);
					if(checkEqual(WorkFlowConstDefine.DEFAULT_APPROVOR_ROLEID_THREE, pid.getPidname())) {
						for(int i = 0; i < len; i++) {
							((IG337TB)approvorsList.get(i)).setPproleid(Integer.parseInt(propertys[i]));
						}
					} else if(checkEqual(WorkFlowConstDefine.DEFAULT_APPROVOR_ROLENAME_THREE, pid.getPidname())) {
						for(int i = 0; i < len; i++) {
							((IG337TB)approvorsList.get(i)).setPprolename(propertys[i]);
						}
					} else if(checkEqual(WorkFlowConstDefine.DEFAULT_APPROVOR_USERID_THREE, pid.getPidname())) {
						for(int i = 0; i < len; i++) {
							((IG337TB)approvorsList.get(i)).setPpuserid(propertys[i]);
						}
					} else if(checkEqual(WorkFlowConstDefine.DEFAULT_APPROVOR_USERNAME_THREE, pid.getPidname())) {
						for(int i = 0; i < len; i++) {
							((IG337TB)approvorsList.get(i)).setPpusername(propertys[i]);
						}
					} else if(checkEqual(WorkFlowConstDefine.DEFAULT_APPROVOR_ORGSYSCODING_THREE, pid.getPidname())) {
						for(int i = 0; i < len; i++) {
							((IG337TB)approvorsList.get(i)).setPporgid(propertys[i]);
						}
					} else if(checkEqual(WorkFlowConstDefine.DEFAULT_APPROVOR_ORGNAME_THREE, pid.getPidname())) {
						for(int i = 0; i < len; i++) {
							((IG337TB)approvorsList.get(i)).setPporgname(propertys[i]);
						}
					}
				}
			}
		}
		return approvorsList;
	}
	
	/**
	 * ���ܣ�����������List����
	 * @param size int
	 * @return  List<ProcessParticipant> ������List����
	 */
	private List<IG337Info> createProcessParticipants(int size) {
		List<IG337Info> ppList = new ArrayList<IG337Info>();
		for(int i = 0; i < size; i++) {
			ppList.add(new IG337TB());
		}
		return ppList;
	}
	
	/**
	 * ���ܣ�check���
	 * @param left String ��null
	 * @param right String
	 * @return  boolean
	 */
	private boolean checkEqual(String left, String right) {
		return left.equals(right);
	}
	
	/**
	 * ���ܣ���ȡ���̱���ȱʡ����������(ppcomment��ȡ֮����Ҫ���)
	 * @param pdid ���̶���ID
	 * @return  List<IG337Info> ���̱���ȱʡ����������
	 */
	public List<IG337Info> searchDefaultApprovorDispatcherByPdid(String pdid){
		IG007SearchCondImpl cond = new IG007SearchCondImpl();
		cond.setPdid(pdid);//��������ID
		cond.setPidname_like(WorkFlowConstDefine.DEFAULT_APPROVEDISPATCHER);//ȱʡ���������˱�ʶ
		List<IG337Info> approvorsList = new ArrayList<IG337Info>();
		List<IG007Info> list = ig007DAO.findByCond(cond, 0, 0);
		for(IG007Info pid : list) {
			if(StringUtils.isNotEmpty(pid.getPiddesc())) {
				String[] propertys = pid.getPiddesc().split(WorkFlowConstDefine.SPILT_APPROVORS,-1);//�����������������
				//����������
				IG337TB pp = new IG337TB();
				pp.setPproleid(Integer.parseInt(propertys[0]));
				pp.setPprolename(propertys[1]);
				pp.setPpuserid(propertys[2]);
				pp.setPpusername(propertys[3]);
				pp.setPporgid(propertys[4]);
				pp.setPporgname(propertys[5]);
				pp.setPpcomment(pid.getPidid().toString());//��ȡ֮����Ҫ���
				approvorsList.add(pp);
			}
		}
		return approvorsList;
	}
	
	/**
	 * ���ܣ����������������ȡ��
	 * @param cond ��������
	 * @return ���������������
	 */
	public int getIG007InfoSearchCount(IG007SearchCond cond){
		
		return ig007DAO.getSearchCount(cond);
	}
	
	/**
	 * ���ܣ�ȫ����������
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<IG007Info> searchIG007Info(IG007SearchCond cond){
		return ig007DAO.findByCond(cond,0,0);
	}
	
	/**
	 * ���ܣ�������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG007Info> searchIG007Info(IG007SearchCond cond, int start, int count){
		
		return ig007DAO.findByCond(cond,start,count);
	}
	
	/**
	 * ���ܣ����̱���ID��ѯ����
	 * @param pidid ���̱���ID
	 * @return ���̱���
	 * @throws BLException 
	 */
	public IG007Info searchIG007InfoByKey(String pidid) throws BLException {
		
		return checkExistIG007Info(pidid);
	}
	
	/**
	 * ���ܣ���¼����
	 * @param ig007Info ��¼����
	 * @return ȫ�ֱ���
	 * @throws BLException 
	 */
	public IG007Info registIG007Info(IG007Info ig007Info) throws BLException{
		
		if(ig007Info == null) {
			throw new BLException("IGCO10000.E004","ȫ�ֱ�������");
		}
		return ig007DAO.save(ig007Info);
	}

	/**
	 * ���ܣ����´���
	 * @param ig007Info ��������
	 * @return ȫ�ֱ���
	 * @throws BLException 
	 */
	public IG007Info updateIG007Info(IG007Info ig007Info) throws BLException{
		
		if(ig007Info == null) {
			throw new BLException("IGCO10000.E004","ȫ�ֱ�������");
		}
		return ig007DAO.save(ig007Info);
	}
	
	
	/**
	 * ���ܣ�ɾ������
	 * @param pidid ɾ��ȫ�ֱ�������
	 */
	public void deleteIG007InfoByKey(String pidid) throws BLException{
		
		IG007Info processInfoDef = checkExistIG007Info(pidid);
		
		ig007DAO.delete(processInfoDef);
	}
	
	/**
	 * ���ܣ�ɾ������
	 * @param ig007Info ���̱�������
	 */
	public void deleteIG007Info(IG007Info ig007Info) throws BLException{
		IG007Info pid = checkExistIG007Info(ig007Info.getPidid());
		
		ig007DAO.delete(pid);
	}


	/**
	 * ���ܣ�ȫ�ֱ������ڼ��
	 * @param pidid ȫ�ֱ���ID
	 * @return ȫ�ֱ���
	 * @throws BLException 
	 */
	protected IG007Info checkExistIG007Info(String pidid) throws BLException{
		IG007Info info = ig007DAO.findByPK(pidid);
		if( info == null) {
			throw new BLException("IGCO10000.E004","ȫ�ֱ�������");
		}
		return info;
	}
	
	/**
	 * PIDID����ֵȡ��
	 * 
	 * @param ���̶���ID
	 * @return PIDID����ֵ
	 */
	public String getPididSequenceNextValue(String pdid) {
		return ig007DAO.getPididSequenceNextValue(pdid);
	}
	
	/**
	 * ���ݱ�����ѯ��������Ϣ
	 * 
	 * @param pdid ���̶���ID
	 * @param name ����
	 * @return ��������Ϣ
	 * @throws BLException
	 */
	public IG007Info searchIG007Info(String pdid, String name) throws BLException {
		IG007SearchCondImpl cond = new IG007SearchCondImpl();
		cond.setPdid(pdid);//���̶���ID
		cond.setPidlabel(name);//������
		cond.setTableColumn("N");
		List<IG007Info> lst_ProcessInfoDef = this.searchIG007Info(cond);
		if(lst_ProcessInfoDef.isEmpty()) {
			throw new BLException("IGCO10000.E004", "����" + name + "��");
		} else if(lst_ProcessInfoDef.size() > 1) {
			throw new BLException("IGCO10000.E026", "����" + name + "��");
		} else {
			return lst_ProcessInfoDef.get(0); 
		}
	}
	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<IG007Info> searchIG007InfoRun(IG007SearchCond cond){
		return ig007DAO.findByCondRun(cond);
	}
	
	/**
	 * XML�ű���������
	 *
	 * @param pdid ���̶���ID
	 * @return XML�ű�
	 */
	public StringBuffer exportXML(String pdid) throws BLException {
		IG007SearchCondImpl cond = new IG007SearchCondImpl();
		cond.setPidid_like(pdid);
		cond.setTableColumn("N");
		cond.setIsExport("Y");
		List<IG007Info> lst_IG007Info = this.searchIG007Info(cond);
		cond.setTableColumn("Y");
		List<IG007Info> temp = this.searchIG007Info(cond);
		StringBuffer sbf_xml = new StringBuffer("");
		sbf_xml.append("<IG007>");
		sbf_xml.append("<DATALIST>");
		if(lst_IG007Info != null) {
			if(temp != null){
				lst_IG007Info.addAll(temp);
			}
			for(IG007Info info : lst_IG007Info) {
				sbf_xml.append("<DATA>");
				sbf_xml.append("<PIDID>");
				sbf_xml.append(StringUtils.isEmpty(info.getPidid()) ? "" : IGStringUtils.filterXMLStr(info.getPidid()));
				sbf_xml.append("</PIDID>");
				sbf_xml.append("<PDID>");
				sbf_xml.append(StringUtils.isEmpty(info.getPdid()) ? "" : IGStringUtils.filterXMLStr(info.getPdid()));
				sbf_xml.append("</PDID>");
				sbf_xml.append("<PIDNAME>");
				sbf_xml.append(StringUtils.isEmpty(info.getPidname()) ? "" : IGStringUtils.filterXMLStr(info.getPidname()));
				sbf_xml.append("</PIDNAME>");
				sbf_xml.append("<PIDLABEL>");
				sbf_xml.append(StringUtils.isEmpty(info.getPidlabel()) ? "" : IGStringUtils.filterXMLStr(info.getPidlabel()));
				sbf_xml.append("</PIDLABEL>");
				sbf_xml.append("<PIDDESC>");
				sbf_xml.append(StringUtils.isEmpty(info.getPiddesc()) ? "" : IGStringUtils.filterXMLStr(info.getPiddesc()));
				sbf_xml.append("</PIDDESC>");
				sbf_xml.append("<PIDTYPE>");
				sbf_xml.append(StringUtils.isEmpty(info.getPidtype()) ? "" : IGStringUtils.filterXMLStr(info.getPidtype()));
				sbf_xml.append("</PIDTYPE>");
				sbf_xml.append("<PIDOPTION>");
				sbf_xml.append(StringUtils.isEmpty(info.getPidoption()) ? "" : IGStringUtils.filterXMLStr(info.getPidoption()));
				sbf_xml.append("</PIDOPTION>");
				sbf_xml.append("<PIDDEFAULT>");
				sbf_xml.append(StringUtils.isEmpty(info.getPiddefault()) ? "" : IGStringUtils.filterXMLStr(info.getPiddefault()));
				sbf_xml.append("</PIDDEFAULT>");
				sbf_xml.append("<PIDREQUIRED>");
				sbf_xml.append(StringUtils.isEmpty(info.getPidrequired()) ? "" : IGStringUtils.filterXMLStr(info.getPidrequired()));
				sbf_xml.append("</PIDREQUIRED>");
				sbf_xml.append("<FINGERPRINT>");
				sbf_xml.append(StringUtils.isEmpty(info.getFingerPrint()) ? "" : IGStringUtils.filterXMLStr(info.getFingerPrint()));
				sbf_xml.append("</FINGERPRINT>");
				sbf_xml.append("<PIDSORTID>");
				sbf_xml.append(StringUtils.isEmpty(info.getPidsortid()) ? "" : IGStringUtils.filterXMLStr(info.getPidsortid()));
				sbf_xml.append("</PIDSORTID>");
				sbf_xml.append("<CCID>");
				sbf_xml.append(StringUtils.isEmpty(info.getCcid()) ? "" : IGStringUtils.filterXMLStr(info.getCcid()));
				sbf_xml.append("</CCID>");
				sbf_xml.append("<PIDGID>");
				sbf_xml.append(info.getPidgid() == null ? "" : info.getPidgid());
				sbf_xml.append("</PIDGID>");
				sbf_xml.append("<PIDMODE>");
				sbf_xml.append(StringUtils.isEmpty(info.getPidmode()) ? "" : IGStringUtils.filterXMLStr(info.getPidmode()));
				sbf_xml.append("</PIDMODE>");
				sbf_xml.append("<PRIVATESCOPE>");
				sbf_xml.append(StringUtils.isEmpty(info.getPrivatescope()) ? "" : IGStringUtils.filterXMLStr(info.getPrivatescope()));
				sbf_xml.append("</PRIVATESCOPE>");
				sbf_xml.append("<HASATTACH>");
				sbf_xml.append(StringUtils.isEmpty(info.getHasattach()) ? "" : IGStringUtils.filterXMLStr(info.getHasattach()));
				sbf_xml.append("</HASATTACH>");
				sbf_xml.append("<ROWWIDTH>");
				sbf_xml.append(StringUtils.isEmpty(info.getRowwidth()) ? "" : IGStringUtils.filterXMLStr(info.getRowwidth()));
				sbf_xml.append("</ROWWIDTH>");
				sbf_xml.append("<PIDDISPLAY>");
				sbf_xml.append(StringUtils.isEmpty(info.getPiddisplay()) ? "" : IGStringUtils.filterXMLStr(info.getPiddisplay()));
				sbf_xml.append("</PIDDISPLAY>");
				sbf_xml.append("<PIDUSE>");
				sbf_xml.append(StringUtils.isEmpty(info.getPiduse()) ? "" : IGStringUtils.filterXMLStr(info.getPiduse()));
				sbf_xml.append("</PIDUSE>");
				sbf_xml.append("<PIDWIDTH>");
				sbf_xml.append(info.getPidwidth() == null ? "" : info.getPidwidth());
				sbf_xml.append("</PIDWIDTH>");
				sbf_xml.append("<PPIDID>");
				sbf_xml.append(StringUtils.isEmpty(info.getPpidid()) ? "" : IGStringUtils.filterXMLStr(info.getPpidid()));
				sbf_xml.append("</PPIDID>");
				sbf_xml.append("<PIDROWS>");
				sbf_xml.append(info.getPidrows() == null ? "" : info.getPidrows());
				sbf_xml.append("</PIDROWS>");
				sbf_xml.append("<PIDHIDE>");
				sbf_xml.append(StringUtils.isEmpty(info.getPidhide()) ? "" : IGStringUtils.filterXMLStr(info.getPidhide()));
				sbf_xml.append("</PIDHIDE>");
				sbf_xml.append("<SHOWROWNUM>");
				sbf_xml.append(StringUtils.isEmpty(info.getShowrownum()) ? "" : IGStringUtils.filterXMLStr(info.getShowrownum()));
				sbf_xml.append("</SHOWROWNUM>");
				sbf_xml.append("<SHOWLINE>");
				sbf_xml.append(StringUtils.isEmpty(info.getShowline()) ? "" : IGStringUtils.filterXMLStr(info.getShowline()));
				sbf_xml.append("</SHOWLINE>");
				sbf_xml.append("<PIDUNIT>");
				sbf_xml.append(StringUtils.isEmpty(info.getPidunit()) ? "" : IGStringUtils.filterXMLStr(info.getPidunit()));
				sbf_xml.append("</PIDUNIT>");
				sbf_xml.append("<REMARKS>");
				sbf_xml.append(StringUtils.isEmpty(info.getRemarks()) ? "" : IGStringUtils.filterXMLStr(info.getRemarks()));
				sbf_xml.append("</REMARKS>");
				sbf_xml.append("<SHOWSTYLES>");
				sbf_xml.append(StringUtils.isEmpty(info.getShowstyles()) ? "" : IGStringUtils.filterXMLStr(info.getShowstyles()));
				sbf_xml.append("</SHOWSTYLES>");
				sbf_xml.append("<TITLEDISPLAY>");
				sbf_xml.append(StringUtils.isEmpty(info.getTitledisplay()) ? "" : IGStringUtils.filterXMLStr(info.getTitledisplay()));
				sbf_xml.append("</TITLEDISPLAY>");
				sbf_xml.append("<NEEDIDEA>");
				sbf_xml.append(StringUtils.isEmpty(info.getNeedidea()) ? "" : IGStringUtils.filterXMLStr(info.getNeedidea()));
				sbf_xml.append("</NEEDIDEA>");
				sbf_xml.append("<JSFUNCTION>");
				sbf_xml.append(StringUtils.isEmpty(info.getJsfunction()) ? "" : IGStringUtils.filterXMLStr(info.getJsfunction()) );
				sbf_xml.append("</JSFUNCTION>");
				sbf_xml.append("<PIDRATIO>");
				sbf_xml.append(StringUtils.isEmpty(info.getPidratio()) ? "" : IGStringUtils.filterXMLStr(info.getPidratio()));
				sbf_xml.append("</PIDRATIO>");
				sbf_xml.append("<PIDSIZE>");
				sbf_xml.append(info.getPidsize() == null ? "0" : info.getPidsize());
				sbf_xml.append("</PIDSIZE>");
				sbf_xml.append("<WRITEABLE>");
				sbf_xml.append(StringUtils.isEmpty(info.getWriteable()) ? "" : IGStringUtils.filterXMLStr(info.getWriteable()));
				sbf_xml.append("</WRITEABLE>");
				sbf_xml.append("<SELECEDLAST>");
				sbf_xml.append(StringUtils.isEmpty(info.getSelecedlast()) ? "" : IGStringUtils.filterXMLStr(info.getSelecedlast()));
				sbf_xml.append("</SELECEDLAST>");
				sbf_xml.append("<NUMBERTYPE>");
				sbf_xml.append(StringUtils.isEmpty(info.getNumbertype()) ? "" : IGStringUtils.filterXMLStr(info.getNumbertype()));
				sbf_xml.append("</NUMBERTYPE>");
				sbf_xml.append("<ALIGN>");
				sbf_xml.append(StringUtils.isEmpty(info.getAlign()) ? "" : IGStringUtils.filterXMLStr(info.getAlign()));
				sbf_xml.append("</ALIGN>");
				sbf_xml.append("</DATA>");
			}
		}
		sbf_xml.append("</DATALIST>");
		sbf_xml.append("</IG007>");
		return sbf_xml;
	}
	
	/**
	 * XML�ű����봦��
	 *
	 * @param element Element
	 * @throws BLException
	 */
	@SuppressWarnings("unchecked")
	public void importXML(Element element) throws BLException {
		Element data = element.getChild("DATALIST");
		List<Element> dataList = data.getChildren();
		List<IG007Info> lst_IG007 = new ArrayList<IG007Info>();
		IG007TB entity = null;
		for(Element e : dataList) {
			entity = this.getIG007TBInstance();
			entity.setPidid(e.getChildText("PIDID"));
			entity.setPdid(e.getChildText("PDID"));
			entity.setPidname(e.getChildText("PIDNAME"));
			entity.setPidlabel(e.getChildText("PIDLABEL"));
			entity.setPiddesc(e.getChildText("PIDDESC"));
			entity.setPidtype(e.getChildText("PIDTYPE"));
			entity.setPidoption(e.getChildText("PIDOPTION"));
			entity.setPiddefault(e.getChildText("PIDDEFAULT"));
			entity.setPidrequired(e.getChildText("PIDREQUIRED"));
			entity.setFingerPrint(e.getChildText("FINGERPRINT"));
			entity.setPidsortid(e.getChildText("PIDSORTID"));
			entity.setCcid(e.getChildText("CCID"));
			entity.setHasattach(e.getChildText("HASATTACH"));
			entity.setPidgid(StringUtils.isEmpty(e.getChildText("PIDGID")) ? null : new Integer(e.getChildText("PIDGID")));
			entity.setPidmode(e.getChildText("PIDMODE"));
			entity.setPrivatescope(e.getChildText("PRIVATESCOPE"));
			entity.setRowwidth(e.getChildText("ROWWIDTH"));			
			entity.setPiddisplay(e.getChildText("PIDDISPLAY"));
			entity.setPiduse(e.getChildText("PIDUSE"));
			entity.setPidwidth(StringUtils.isEmpty(e.getChildText("PIDWIDTH")) ? null : new Integer(e.getChildText("PIDWIDTH")));
			entity.setPpidid(StringUtils.isNotEmpty(e.getChildText("PPIDID")) ? e.getChildText("PPIDID") : null);
			entity.setPidrows(StringUtils.isEmpty(e.getChildText("PIDROWS")) ? null : new Integer(e.getChildText("PIDROWS")));
			entity.setPidhide(e.getChildText("PIDHIDE"));
			entity.setShowrownum(e.getChildText("SHOWROWNUM"));
			entity.setShowline(e.getChildText("SHOWLINE"));
			entity.setPidunit(e.getChildText("PIDUNIT"));
			entity.setRemarks(e.getChildText("REMARKS"));
			entity.setShowstyles(e.getChildText("SHOWSTYLES"));
			entity.setTitledisplay(e.getChildText("TITLEDISPLAY"));
			entity.setNeedidea(e.getChildText("NEEDIDEA"));
			entity.setJsfunction(e.getChildText("JSFUNCTION"));
			entity.setPidratio(e.getChildText("PIDRATIO"));
			entity.setPidsize(Integer.valueOf(e.getChildText("PIDSIZE")));
			entity.setWriteable(e.getChildText("WRITEABLE"));
			entity.setSelecedlast(e.getChildText("SELECEDLAST"));
			entity.setNumbertype(e.getChildText("NUMBERTYPE"));
			entity.setAlign(e.getChildText("ALIGN"));
			lst_IG007.add(entity);
		}
		this.ig007DAO.saveOrUpdateAll(lst_IG007);
	}
	
}
