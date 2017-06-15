package com.deliverik.infogovernor.bl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.dao.InvalidDataAccessResourceUsageException;

import sun.misc.BASE64Decoder;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.security.UserPermissionBL;
import com.deliverik.framework.user.bl.task.IG622BL;
import com.deliverik.framework.user.bl.task.UserBL;
import com.deliverik.framework.user.bl.task.UserRoleBL;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.user.model.UserRoleInfo;
import com.deliverik.framework.user.model.condition.UserRoleVWSearchCondImpl;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.utility.ResourceUtility;
import com.deliverik.framework.workflow.WorkFlowConstDefine;
import com.deliverik.infogovernor.adapter.ADAdapter;
import com.deliverik.infogovernor.com.bl.task.ProcessInHandBL;
import com.deliverik.infogovernor.com.model.ProcessInHandVWInfo;
import com.deliverik.infogovernor.dbm.bl.task.BussinessAvailvalVWBL;
import com.deliverik.infogovernor.dbm.model.BussinessAvailval;
import com.deliverik.infogovernor.dto.IGCOM01DTO;
import com.deliverik.infogovernor.form.IGCOM0201Form;
import com.deliverik.infogovernor.kgm.bl.IGKGMCONSTANTS;
import com.deliverik.infogovernor.kgm.bl.task.KnowledgeBL;
import com.deliverik.infogovernor.kgm.model.Knowledge;
import com.deliverik.infogovernor.kgm.model.condition.KnowledgeSearchCondImpl;
import com.deliverik.infogovernor.risk.bl.task.RiskCheckResultBL;
import com.deliverik.infogovernor.risk.model.RiskCheckResult;
import com.deliverik.infogovernor.scheduling.bl.task.QuartzJobsBL;
import com.deliverik.infogovernor.scheduling.model.QuartzJobsDetail;
import com.deliverik.infogovernor.scheduling.model.condition.QuartzJobsSearchCondImpl;
import com.deliverik.infogovernor.sdl.form.IGSDL0110Form;
import com.deliverik.infogovernor.soc.alarm.bl.task.CRM06BL;
import com.deliverik.infogovernor.soc.alarm.model.CRM06Info;
import com.deliverik.infogovernor.soc.alarm.model.condition.CRM06SearchCondImpl;
import com.deliverik.infogovernor.sym.bl.task.NoticeBL;
import com.deliverik.infogovernor.sym.model.Notice;
import com.deliverik.infogovernor.sym.model.condition.NoticeSearchCondImpl;
import com.deliverik.infogovernor.sym.model.entity.NoticeTB;
import com.deliverik.infogovernor.vo.IGCOM04032VO;


/**
 * ��¼����ҵ���߼�ʵ��
 *
 */
public class IGCOM01BLImpl extends BaseBLImpl implements IGCOM01BL {

	static Log log = LogFactory.getLog(IGCOM01BLImpl.class);

	protected UserBL userBL;
	
	protected UserRoleBL userRoleBL;
	
	protected ProcessInHandBL processInHandBL;
	
	protected KnowledgeBL knowledgeBL ;
	
	protected NoticeBL noticeBL;
	
	protected QuartzJobsBL quartzJobsBL;
	
	/** �û�Ȩ��BL */
	protected UserPermissionBL userPermissionBL;
	
	/** ��ҳ��תURL����BL */
	protected IG622BL ig622BL;
	
	/** ҵ��ϵͳ��������ͼBL */
	protected BussinessAvailvalVWBL bussinessAvailvalVWBL;
	
	/** Oracle�澯��ͼBL */
	protected CRM06BL crm06BL;
	
	/** ��鹤����ѯ */
	protected RiskCheckResultBL riskCheckResultBL;
	
	/**
	 * ��鹤����ѯ����
	 * 
	 * @param riskCheckResultBL ��鹤����ѯ
	 */
	public void setRiskCheckResultBL(RiskCheckResultBL riskCheckResultBL) {
		this.riskCheckResultBL = riskCheckResultBL;
	}

	public void setUserBL(UserBL userBL) {
		this.userBL = userBL;
	}
	
	public void setUserRoleBL(UserRoleBL userRoleBL) {
		this.userRoleBL = userRoleBL;
	}
	
	public void setProcessInHandBL(ProcessInHandBL processInHandBL) {
		this.processInHandBL = processInHandBL;
	}

	public void setKnowledgeBL(KnowledgeBL knowledgeBL) {
		this.knowledgeBL = knowledgeBL;
	}

	public void setNoticeBL(NoticeBL noticeBL) {
		this.noticeBL = noticeBL;
	}

	public void setQuartzJobsBL(QuartzJobsBL quartzJobsBL) {
		this.quartzJobsBL = quartzJobsBL;
	}
	
	/** LDAP������IP��ַ */
	private static final String IP = "160.100.101.81";
	
	/** LDAP�������˿� */
	private static final String PORT = "80";
	
	/**
	 * �û�Ȩ��BL�趨
	 * 
	 * @param userPermissionBL �û�Ȩ��BL
	 */
	public void setUserPermissionBL(UserPermissionBL userPermissionBL) {
		this.userPermissionBL = userPermissionBL;
	}
	
	/**
	 * ��ҳ��תURL����BL�趨
	 * 
	 * @param ig622BL
	 */
	public void setIg622BL(IG622BL ig622BL) {
		this.ig622BL = ig622BL;
	}
	
	/**
	 * ҵ��ϵͳ��������ͼBL �趨
	 * 
	 * @param bussinessAvailvalVWBL ҵ��ϵͳ��������ͼBL 
	 */
	public void setBussinessAvailvalVWBL(BussinessAvailvalVWBL bussinessAvailvalVWBL) {
		this.bussinessAvailvalVWBL = bussinessAvailvalVWBL;
	}
	
	/**
	 * Oracle�澯��ͼBL
	 * @param crm06BL Oracle�澯��ͼBL
	 */
	public void setCrm06BL(CRM06BL crm06BL) {
		this.crm06BL = crm06BL;
	}

	/**
	 * 
	 *
	 * @param dto IGBAS01DTO
	 * @return IGBAS01DTO
	 */
	public IGCOM01DTO loginAction(IGCOM01DTO dto) throws BLException {

		log.debug("========�û���¼����ʼ========");

		User user = null;
		try{
			user = this.userBL.searchUserByKey(dto.getUserSearchCond().getUserid());
		}catch (InvalidDataAccessResourceUsageException e) {
			throw new BLException("IGCOM0101.E001");
		}
		//�û������ 
		//
		if (user == null) {
			log.debug("========�û���¼ʧ��(�û�������ȷ)========");
			dto.getIGCOM0101Form().setUserexist("1");
			//�û�������ȷ
			throw new BLException("IGCOM0101.E001");
		} else {
			
			//ͣ�ü���
			if (!"0".equals(user.getDeleteflag())){
				log.debug("========�û���¼ʧ��(�û�ͣ��)========");
				//�û���ͣ��
				throw new BLException("IGCOM0101.E006");
			}
			
			//������
			if (user.getPassword() == null) {
				log.debug("========�û���¼ʧ��(����û���趨)========");
				//����û���趨���û������
				throw new BLException("IGCOM0101.E003");
			}
			
			if (!user.getPassword().equals(dto.getUserSearchCond().getPassword())){
				log.debug("========�û���¼ʧ��(���벻��ȷ)========");
				dto.getIGCOM0101Form().setUserexist("0");
				//���벻��ȷ
				throw new BLException("IGCOM0101.E002");
			} else {
				//�û���,������ɹ�
				dto.setUser(user);
			}
		
		}
		
		log.debug("========�û���¼�������========");
		return dto;
	}
	
	/**
	 * ����
	  * <p>��������: setEncrypt|����: </p>
	  * @param str
	  * @return
	 */
	public static String setEncrypt(String str){
        String sn="cs"; //��Կ
        int[] snNum=new int[str.length()];
        String result="";
        String temp="";

        for(int i=0,j=0;i<str.length();i++,j++){
            if(j==sn.length())
                j=0;
            snNum[i]=str.charAt(i)^sn.charAt(j);
        }

        for(int k=0;k<str.length();k++){

            if(snNum[k]<10){
                temp="00"+snNum[k];
            }else{
                if(snNum[k]<100){
                    temp="0"+snNum[k];
                }
            }
            result+=temp;
        }
        return result;
    }
	
	public IGCOM01DTO loginActionByLDAP(IGCOM01DTO dto) throws BLException {
		log.debug("========LDAP ��¼����ʼ========");
		
		//ƴ��URL ��ʽ��http://ums.ip:ums.port/cbrc/servlet/cn.com.resoft.integrate.SyncServer��servicetype=getperson& persondn=YYY
		//ʾ����YYY  ���û������Ļ�Ӧ�þ����û�ID
		String persondn = dto.getUserSearchCond().getUserid();
		
		log.debug("persondn�ֶ����ݣ�"+persondn);
		
		//ps��servicetype=getpersonӦ������������Ϊ "ȡ���û���Ϣ"
		String url = "http://" + IP + ":" + PORT 
				+ "/cbrc/servlet/cn.com.resoft.integrate.sync.SyncServer?servicetype=getpersonfordlk&persondn=" 
				+ persondn;
		
		log.debug("��ϵͳ�ύURL����"+url);
		
		//���ؽ������
		String returnValue = null;
		//ʵ����URL����
		URL u = null;
		try {
			u = new URL(url);
		} catch (MalformedURLException e) {
			log.error("ʵ����url����"+e.getMessage());
		}
		
		//ͨ��URLȡ�����Ӷ���
		URLConnection con = null;
		try {
			con = u.openConnection();
		} catch (IOException e) {
			log.error("ͨ��URLȡ�����Ӷ������"+e.getMessage());
		}
		
		//���ӷ�����
		try {
			con.connect();
		} catch (IOException e) {
			log.error("���ӷ���������"+e.getMessage());
		}
		//--------------��hearder����ȡ����Ϣ--------------
		//ȡ��״̬��Ϣ  �ɹ�orʧ��
		String isOK = con.getHeaderField("status");
		log.debug("״̬��Ϣ��"+isOK);
		//�����ĵ���ʾ��OK����ɹ���FAIL����ʧ��
		if("OK".equals(isOK)){
			//ȡ��ldap�������ϵ��û���Ϣ
			returnValue = con.getHeaderField("person");
		}else {
			returnValue = "����ʧ�ܣ�����";
			throw new BLException("IGCOM0101.E001");
		}
		
		log.debug("��ȡͳһ�û�����ϵͳHttp-Header�е�person���ֵ��"+returnValue);
		//��������ַ�������
		String content = null;
		//ʹ��base64�����ַ���
		try {
			content = new String(new BASE64Decoder().decodeBuffer(returnValue));
			
			log.debug("����person����ֵ��"+content);
			
			//contentת�룺��GBKת����UTF-8,ͨ���м��ַ���ISO-8859-1���Ա�֤�������Ĳ��ᷢ������
			String tmp = new String(content.getBytes("GBK"),"ISO-8859-1"); 
			content = new String(tmp.getBytes("ISO-8859-1"),"UTF-8"); 
			
			log.debug("Content GBKתUTF-8���ֵ��"+content);
		} catch (IOException e) {
			log.error("����returnValueʧ�ܣ�"+e.getMessage());
		}
		
		//��xml�н�����personid��userpassword
		String userpassword = content.substring(content.indexOf("<userpassword>")+14,content.indexOf("</userpassword>"));
		
		log.debug("��base64�ַ����н����������û�����:"+userpassword);
	
		//�û������ 
		User user = this.userBL.searchUserByKey(persondn);
		//
		if (user == null) {
			log.debug("========LDAP ��¼ʧ��(�û�������ȷ)========");
			dto.getIGCOM0101Form().setUserexist("1");
			//�û�������ȷ
			throw new BLException("IGCOM0101.E001");
		} else {
			
			//ͣ�ü���
			if (!"0".equals(user.getDeleteflag())){
				log.debug("========LDAP ��¼ʧ��(�û�ͣ��)========");
				//�û���ͣ��
				throw new BLException("IGCOM0101.E006");
			}
			
			//�ж��Ƿ�ɹ���ʶ
			int isEqual = 0;
			if (dto.getIGCOM0101Form().getPassword()!=null){
				
				String pwd_trans = setEncrypt(dto.getIGCOM0101Form().getPassword());
				
				log.debug("��ѯ�������룺"+dto.getIGCOM0101Form().getPassword());
				log.debug("������ܺ��ֵ:"+pwd_trans);
				
				if(pwd_trans.equals(userpassword)){
					//�û���,������ɹ�
					dto.setUser(user);
					isEqual = 1;
				}else{
					throw new BLException("IGCOM0101.E002");
				}
			} else if(null == dto.getIGCOM0101Form().getPassword() || isEqual == 0){
				log.debug("========LDAP ��¼ʧ��(���벻��ȷ)========");
				dto.getIGCOM0101Form().setUserexist("0");
				//���벻��ȷ
				throw new BLException("IGCOM0101.E002");
			}
		
		}
		
		log.debug("========LDAP ��¼�������========");
		return dto;
	}	
	
	/**
	 * ʹ��ADУ���¼
	 */
	public IGCOM01DTO loginActionByAD(IGCOM01DTO dto) throws BLException {
		log.debug("========AD ��¼����ʼ========");
	
		//�û������ 
		User user = this.userBL.searchUserByKey(dto.getUserSearchCond().getUserid());
		//
		if (user == null) {
			log.debug("========AD ��¼ʧ��(�û�������ȷ)========");
			dto.getIGCOM0101Form().setUserexist("1");
			//�û�������ȷ
			throw new BLException("IGCOM0101.E001");
		} else {
			
			//ͣ�ü���
			if (!"0".equals(user.getDeleteflag())){
				log.debug("========AD ��¼ʧ��(�û�ͣ��)========");
				//�û���ͣ��
				throw new BLException("IGCOM0101.E006");
			}
			
			//������
			ADAdapter adcheck = ADAdapter.getInstance();
	
			if (!adcheck.adAuthorize(dto.getUserSearchCond().getUserid(), dto.getUserSearchCond().getPassword())){
				log.debug("========AD ��¼ʧ��(���벻��ȷ)========");
				dto.getIGCOM0101Form().setUserexist("0");
				//���벻��ȷ
				throw new BLException("IGCOM0101.E002");
			} else {
				//�û���,������ɹ�
				dto.setUser(user);
			}
		
		}
		
		log.debug("========LDAP ��¼�������========");
		return dto;
	}	
	
	/**
	 * <p>
	 * ��ȡ�û�������Ľ�ɫList
	 * </p>
	 * 
	 * @param userId �û�ID
	 * @return �û�������Ľ�ɫList
	 * @author   
	 */

	public IGCOM01DTO getUserRoles(IGCOM01DTO dto) {
		UserRoleVWSearchCondImpl cond = new UserRoleVWSearchCondImpl();
		cond.setUserid(dto.getUser().getUserid());
		List<UserRoleInfo> roleList = userRoleBL.searchUserRoleVW(cond, 0, 0);
		dto.setUserRoleInfoList(roleList);
		return dto;
	}
	
	/**
	 * <p>
	 * ��ȡ��ҳ�����еĹ���
	 * </p>
	 * 
	 * @param userId �û�ID
	 * @return �����еĹ���
	 * @author   
	 */
	public IGCOM01DTO getProcessInHand(IGCOM01DTO dto) throws BLException{
		String userid = dto.getUser().getUserid();
		List<ProcessInHandVWInfo> pihListDesc = this.processInHandBL.searchProcessInHandByUserID(userid,0,10,true);
//		List<ProcessInHandVWInfo> pihListAsc = this.processInHandBL.searchProcessInHandByUserID(userid,0,10,false);
		List<ProcessInHandVWInfo> pihListGroupDesc = this.processInHandBL.searchProcessInHandGroupByUserID(userid,0,10, true);
//		List<ProcessInHandVWInfo> pihListGroupAsc = this.processInHandBL.searchProcessInHandGroupByUserID(userid,0,10, false);

		List<ProcessInHandVWInfo> pihListDiscontinueDesc = this.processInHandBL.searchProcessInHandDiscontinueByUserID(userid, true);
//		List<ProcessInHandVWInfo> pihListDiscontinueAsc = this.processInHandBL.searchProcessInHandDiscontinueByUserID(userid, false);
		
		dto.setPihListDesc(pihListDesc);
//		dto.setPihListAsc(pihListAsc);
		dto.setPihGroupListDesc(pihListGroupDesc);
//		dto.setPihGroupListAsc(pihListGroupAsc);
		dto.setProcessInHandDiscontinueDesc(pihListDiscontinueDesc);
//		dto.setProcessInHandDiscontinueAsc(pihListDiscontinueAsc);
		return dto;
	}
	
	/**
	 * <p>
	 * ��ȡ��ҳ�����е�֪ʶ
	 * </p>
	 * 
	 * @author   
	 */
	public IGCOM01DTO getKnowledge(IGCOM01DTO dto) throws BLException{
		//����֪ʶ
		KnowledgeSearchCondImpl cond = new KnowledgeSearchCondImpl();
		cond.setKnstatus(IGKGMCONSTANTS.KNOWLEDGE_APPROVEED);
		List<Knowledge> knlist = knowledgeBL.searchKnowledgeByCond(cond, 0, 6);
		
		List<IGCOM04032VO> knvoList = new ArrayList<IGCOM04032VO>();

		if(knlist !=null && knlist.size()>0){
			
			for(int i=0;i<knlist.size();i++){
				if(i<4){
					IGCOM04032VO vo = new IGCOM04032VO();
					vo.setKnowledge(knlist.get(i));
					//���� */
					Integer knid = knlist.get(i).getKnid();
					//֪ʶ�汾 */
					 Integer knversion = knlist.get(i).getKnversion();
					//���
					String knserial = knlist.get(i).getKnserial();
					//����
					String title = knlist.get(i).getKntitle();
					//����
					String knclassname = knlist.get(i).getKnclassname();
					//������
					String  knproffername = knlist.get(i).getKnproffername();
					//�鵵����
					String time = knlist.get(i).getKnapprovetime();
					
					//String titleall = knlist.get(i).getKntitle();
					String knfaultcause = knlist.get(i).getKnfaultcause();
					String knkeys = knlist.get(i).getKnkey();
				
					
					if(title !=null && title.length()>10){
						title = title.substring(0, 10) + "......";
					}
					if(knfaultcause !=null && knfaultcause.length()>21){
						knfaultcause = knfaultcause.substring(0, 21) + "......";
					}
					if(knkeys !=null && knkeys.length()>10){
						knkeys = knkeys.substring(0, 10) + "......";
					}
					if(time !=null){
						time = time.substring(0, 10);//ֻ����������
					}
					vo.setKnfaultcause(knfaultcause);
					//����
					vo.setTitle(title);
					vo.setKeys(knkeys);
					//�鵵����
					vo.setTime(time);
				//	vo.setTitleall(titleall);
					//���
					vo.setKnserial(knserial);
					//����
					vo.setKnclassname(knclassname);
					//������
					vo.setKnproffername(knproffername);
					vo.setKnid(knid);
					vo.setKnversion(knversion);					
 					knvoList.add(vo);
				}
			}
		}
		dto.setKnvoList(knvoList);
		
		//������֪ʶ
		cond = new KnowledgeSearchCondImpl();
		cond.setKnstatus(IGKGMCONSTANTS.KNOWLEDGE_UN_APPROVE);
		List<UserRoleInfo> userRoleInfoList = dto.getUserRoleInfoList();
		//��ǰ�û����н�ɫid����
		Integer[] roleIds=new Integer[userRoleInfoList.size()];
		for (int i = 0; i < userRoleInfoList.size(); i++) {
			Integer roleid = userRoleInfoList.get(i).getRoleid();
			roleIds[i]=roleid;
		}
		cond.setKnapproveroles(roleIds);
		knlist = knowledgeBL.searchKnowledgeByCond(cond, 0, 6);
		List<IGCOM04032VO> appKnList = new ArrayList<IGCOM04032VO>();

		if(knlist !=null && knlist.size()>0){
			for(int i=0;i<knlist.size();i++){
				if(i<5){
					IGCOM04032VO vo = new IGCOM04032VO();
					vo.setKnowledge(knlist.get(i));
					String title = knlist.get(i).getKntitle();
					String titleall = knlist.get(i).getKntitle();
					String knfaultcause = knlist.get(i).getKnfaultcause();
					String knkeys = knlist.get(i).getKnkey();
					String time = knlist.get(i).getKnapprovetime();
					
					if(title !=null && title.length()>10){
						title = title.substring(0, 10) + "......";
					}
					if(knfaultcause !=null && knfaultcause.length()>21){
						knfaultcause = knfaultcause.substring(0, 21) + "......";
					}
					if(knkeys !=null && knkeys.length()>10){
						knkeys = knkeys.substring(0, 10) + "......";
					}
					if(time !=null){
						time = time.substring(0, 10);//ֻ����������
					}
					vo.setKnfaultcause(knfaultcause);
					vo.setTitle(title);
					vo.setKeys(knkeys);
					vo.setTime(time);
					vo.setTitleall(titleall);
					appKnList.add(vo);
				}
			}
		}
		dto.setAppKnList(appKnList);
		
		return dto;
	}
	
	/**
	 * <p>
	 * Description: ��ȡ��ҳ�м�鹤�����
	 * </p>
	 */
	public IGCOM01DTO getRiskCheckResultGoup(IGCOM01DTO dto) throws BLException {
		log.debug("========��ȡ��ҳ�м�鹤���������ʼ========");
		//��ȡ�û���Ϣ
		User user = dto.getUser();
		
		//����DAO�ӿڲ�ѯ
		//���˼�鹤�������ѯ
//		List<RiskCheckResult> lst_RiskCheckResult_Asc = this.riskCheckResultBL.riskCheckResultGoup(user.getUserid(), false, false);
		//���˼�鹤�������ѯ
		List<RiskCheckResult> lst_RiskCheckResult_Desc = this.riskCheckResultBL.riskCheckResultGoup(user.getUserid(), true, false);
		
		//��¼���˼�鹤������
		List<Integer> lst_rcid = new ArrayList<Integer>();
		if(lst_RiskCheckResult_Desc!= null && lst_RiskCheckResult_Desc.size() > 0){
			for (RiskCheckResult riskCheckResult : lst_RiskCheckResult_Desc) {
				lst_rcid.add(riskCheckResult.getRcid());
			}
		}
		
		
		List<RiskCheckResult> lst_RiskCheckResultGroup_Asc = new ArrayList<RiskCheckResult>();
		//��ؼ�鹤�������ѯ
		List<RiskCheckResult> riskCheckResultGoup_Asc  = this.riskCheckResultBL.riskCheckResultGoup(user.getUserid(), false, true);
		//����ؼ�鹤����ȥ�����˼�鹤��
		if(riskCheckResultGoup_Asc != null && riskCheckResultGoup_Asc.size() > 0){
			for (RiskCheckResult riskCheckResult : riskCheckResultGoup_Asc ) {
				if(!lst_rcid.contains(riskCheckResult.getRcid())){
					lst_RiskCheckResultGroup_Asc.add(riskCheckResult);
				}
			}
		}
		
		
		List<RiskCheckResult> lst_RiskCheckResultGroup_Desc = new ArrayList<RiskCheckResult>();
		//��ؼ�鹤�������ѯ
		List<RiskCheckResult> riskCheckResultGoup_Des= this.riskCheckResultBL.riskCheckResultGoup(user.getUserid(), true, true);
		//����ؼ�鹤����ȥ�����˼�鹤��
		if(riskCheckResultGoup_Des != null && riskCheckResultGoup_Des.size() > 0){
			for (RiskCheckResult riskCheckResult : riskCheckResultGoup_Des) {
				if(!lst_rcid.contains(riskCheckResult.getRcid())){
					lst_RiskCheckResultGroup_Desc.add(riskCheckResult);
				}
			}
		}
		

		//���˼�鹤��
//		dto.setLst_RiskCheckResult_Asc(lst_RiskCheckResult_Asc);
		dto.setLst_RiskCheckResult_Desc(lst_RiskCheckResult_Desc);
		//��ؼ�鹤��
		dto.setLst_RiskCheckResultGroup_Asc(lst_RiskCheckResultGroup_Asc);
		dto.setLst_RiskCheckResultGroup_Desc(lst_RiskCheckResultGroup_Desc);
		
		log.debug("========��ȡ��ҳ�м�鹤�������������========");
		return dto;
	}
	
	/**
	 * <p>
	 * ��ҳ�ճ��ƻ�����
	 * </p>
	 * 
	 * @author   
	 * @throws ParseException 
	 */
	@SuppressWarnings("unused")
	public IGCOM01DTO getDaysPlans(IGCOM01DTO dto) throws BLException {
		IGCOM0201Form from  = dto.getIgcom0201Form();
		
		//��Ĭ������
		if(StringUtils.isEmpty(from.getYear())){
			from.setYear(IGStringUtils.getCurrentYear());//��ǰ��
			
		}
		if(StringUtils.isEmpty(from.getMonth())){
			from.setMonth(IGStringUtils.getCurrentDate().substring(5, 7));//��ǰ��
			
		}
		dto.setIgcom0201Form(from);
		//��ѯ�ƻ�
		dto = getUserRoles(dto);
		List<UserRoleInfo> userRoleInfoList = dto.getUserRoleInfoList();
		Map<String, String> urlMap = new HashMap<String, String>();
		// �ж��Ƿ������̽�ɫ
		String roletype = WorkFlowConstDefine.PROCESS_ROLE_MARK;
		boolean flag = false;
		for (int i = 0; i < userRoleInfoList.size(); i++) {
			UserRoleInfo ur = userRoleInfoList.get(i);
			if (roletype.equals(ur.getRoletype()
					.substring(0, roletype.length()))) {
				flag = true;
				break;
			}
		}
		if (flag) {
			IGSDL0110Form form_sdl = new IGSDL0110Form();
			String curmonth = from.getMonth();// ��
			String curyear = from.getYear();// ��ǰ��
			form_sdl.setYmonth(curyear + "/" + curmonth);
			QuartzJobsSearchCondImpl cond = new QuartzJobsSearchCondImpl();
			String date_q = form_sdl.getYmonth() + "/01 00:00";
			String date_j = form_sdl.getYmonth() + "/31 23:59";
			if (StringUtils.isNotEmpty(form_sdl.getYmonth())) {
				date_q = form_sdl.getYmonth() + "/01 00:00";
				date_j = form_sdl.getYmonth() + "/31 23:59";
			} else {
				date_q = curyear + "/" + curmonth + "/01 00:00";
				date_j = curyear + "/" + curmonth + "/31 23:59";
			}
			cond.setDate_q(date_q);
			cond.setUserid(dto.getUser().getUserid());
			cond.setDate_j(date_j);

			List<QuartzJobsDetail> quartzJobsList = quartzJobsBL
					.getQuartzJobsByUserDate(cond, 0, 0);
			String time = IGStringUtils.getCurrentDate();// ��ǰʱ��
			for (QuartzJobsDetail qjd : quartzJobsList) {
				if (qjd.getQjdtime().length() >= 10
						&& (qjd.getQjdtime().substring(0, 10).compareTo(time) >= 0)) {
					urlMap.put(qjd.getQjdtime().substring(0, 10), "red");
				}
			}

		}
		//���������·�����
		String days[];
		Integer showYear = Integer.valueOf(from.getYear());
		Integer showMonth = Integer.valueOf(from.getMonth())-1;

		days = new String[42];
		for (int i = 0; i < 42; i++) {
			days[i] = "";
		}

		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		boolean isafterDeate = false;
		GregorianCalendar currentDay = new GregorianCalendar();
		int today = currentDay.get(Calendar.DAY_OF_MONTH);
		int month = currentDay.get(Calendar.MONTH);
		int year = currentDay.get(Calendar.YEAR);

		int calendarYear = (showYear == null) ? year : showYear;
		int calendarMonth = (showMonth == null) ? month : showMonth;

		Calendar thisMonth = Calendar.getInstance();
		thisMonth.set(Calendar.MONTH, calendarMonth);
		thisMonth.set(Calendar.YEAR, calendarYear);
		thisMonth.setFirstDayOfWeek(Calendar.SUNDAY);
		thisMonth.set(Calendar.DAY_OF_MONTH, 1);

		
		int thistoday = thisMonth.get(Calendar.DAY_OF_MONTH);
		int thismonth = thisMonth.get(Calendar.MONTH);
		int thisyear = thisMonth.get(Calendar.YEAR);

		Calendar backCal = Calendar.getInstance();
		backCal.set(Calendar.MONTH, calendarMonth);
		backCal.set(Calendar.YEAR, calendarYear);
		backCal.setFirstDayOfWeek(Calendar.SUNDAY);
		backCal.set(Calendar.DAY_OF_MONTH, 1);

		Calendar nextCal = Calendar.getInstance();
		nextCal.set(Calendar.MONTH, calendarMonth);
		nextCal.set(Calendar.YEAR, calendarYear);
		nextCal.setFirstDayOfWeek(Calendar.SUNDAY);
		nextCal.set(Calendar.DAY_OF_MONTH, 1);

		backCal.set(Calendar.MONDAY, backCal.get(Calendar.MONDAY) - 1);
		nextCal.set(Calendar.MONDAY, backCal.get(Calendar.MONDAY) + 1);

		int backCalMaxDay = backCal.getActualMaximum(Calendar.DAY_OF_MONTH);
		int nextCalMaxDay = backCal.getActualMaximum(Calendar.DAY_OF_MONTH);

		int firstIndex = thisMonth.get(Calendar.DAY_OF_WEEK) - 1;
		int maxIndex = thisMonth.getActualMaximum(Calendar.DAY_OF_MONTH);

		int linkIndex = maxIndex + firstIndex;
		for (int i = 0; i < days.length - linkIndex; i++) {
			days[(linkIndex) + i] = "<span class=\"gray\">"
					+ String.valueOf(i + 1) + "</span>";
		}

		for (int i = 0; i < firstIndex; i++) {
			days[(firstIndex - 1) - i] = "<span class=\"gray\">"
					+ String.valueOf(backCalMaxDay - i) + "</span>";
		}

		for (int i = 0; i < maxIndex; i++) {
			days[firstIndex + i] = String.valueOf(i + 1);
		}

		//ƴдҳ��html
		String riliString="";
		for (int j = 0; j < 6; j++) {

			riliString += "<tr>";

			String todayYMD = year + "-" + month + "-" + today;

			for (int i = j * 7; i < (j + 1) * 7; i++) {
				String day = calendarYear + "/" + calendarMonth + "/"
						+ (i - firstIndex + 1);
				String month_split = "/";
				if ((calendarMonth + 1) < 10) {
					month_split = "/0";
				}
				String day_split = "/";
				if (((i - firstIndex + 1)) < 10) {
					day_split = "/0";

				}

				String thistodayYMD = thisyear + "-" + thismonth + "-"
						+ days[i];
				String sfdate = thisyear + "-" + (thismonth + 1) + "-"
						+ days[i];
				String mapDay = days[i];
				String mapMonth = String.valueOf(thismonth + 1);

				if (days[i].length() < 2) {
					mapDay = "0" + days[i];
				}
				if (mapMonth.length() < 2) {
					mapMonth = "0" + mapMonth;
				}
				String mapDate = thisyear + "/" + mapMonth + "/" + mapDay;
				if (thistodayYMD.length() > 10) {
					isafterDeate = false;
				} else {
					Date sdate;
					try {
						sdate = sf.parse(sfdate);
						isafterDeate = sdate.before(new Date());
					} catch (ParseException e) {
						e.printStackTrace();
						throw new BLException();
					}

				}
				boolean color = false;
				if (!thistodayYMD.equals(todayYMD)) {

					riliString += "<td bgcolor=\"#FFFFFF\"";

					if ((days[i].length() < 3) && isafterDeate) {
						riliString += " onclick=\"goPage('" + calendarYear
								+ "', '" + (calendarMonth + 1) + "', "
								+ (i - firstIndex + 1) + ")\"";
						riliString += " style=\"cursor: hand;color: black\"";

					} else {
						if ((days[i].length() < 3)
								&& ("red".equals(urlMap.get(mapDate)))) {
							riliString += " onclick=\"goPage('" + calendarYear
									+ "', '" + (calendarMonth + 1) + "', "
									+ (i - firstIndex + 1) + ")\"";
							riliString += " style=\"cursor: hand\" ";
						} else if ((days[i].length() < 3)
								&& (!"red".equals(urlMap.get(mapDate)))) {
							riliString += " onclick=\"goPageSDL('"
									+ calendarYear + "', '"
									+ (calendarMonth + 1) + "', "
									+ (i - firstIndex + 1) + ")\"";
							riliString += " style=\"cursor: hand;color: black\" ";

						}
					}

					riliString += " >";

				} else {
					riliString += " <td bgcolor=\"#ffe6e2\" ";
					if ((days[i].length() < 3)
							&& ("red".equals((urlMap).get(mapDate)))) {
						riliString += " onclick=\"goPage('"+calendarYear+"', '"+ (calendarMonth+1)+"', "+ (i - firstIndex + 1)+")\"";
						riliString += " style=\"cursor: hand\"";

					} else if ((days[i].length() < 3)
							&& (!"red".equals((urlMap).get(mapDate)))) {
						riliString += " onclick=\"goPageSDL('"+calendarYear+"', '"+ (calendarMonth+1)+"', "+ (i - firstIndex + 1)+")\"";
						riliString += " style=\"cursor: hand\"  ";
					}
					riliString += " >";
					color = true;
				}
				if ("red".equals((urlMap).get(mapDate))||color) {
					riliString += " <span style=\"color: #8c3e3d\"> ";
				} else {
					riliString += " <span> ";
				}
				riliString += "" + days[i] + "";
				riliString += " </span>&nbsp;</td>";
			}
			riliString += " </tr>";
		}
		dto.setRiliString(riliString);
		return dto;
	}
	
	
	/**
	 * <p>
	 * ��ȡ��ҳ֪ͨ
	 * </p>
	 * 
	 * @author   
	 */
	public IGCOM01DTO getNotice(IGCOM01DTO dto) throws BLException{

		int num = Integer
				.parseInt(ResourceUtility.getString("NOTICE_SHOW_NUM"));// �����ļ����趨��֪ͨ����ʾ��Ŀ
		int length = Integer.parseInt(ResourceUtility
				.getString("NOTICE_SHOW_LENGTH"));// �����ļ����趨��֪ͨ��ÿ����ʾ����
		// ��ѯ
		
		List<Notice> noticeList = new ArrayList<Notice>();
		NoticeSearchCondImpl cond = new NoticeSearchCondImpl();
		
		//�жϸý�ɫ�Ƿ��ڿ��Կ����Ľ�ɫ��
		UserRoleVWSearchCondImpl ucond = new UserRoleVWSearchCondImpl();
		ucond.setUserid(dto.getUser().getUserid());
		List<UserRoleInfo> roleList = userRoleBL.searchUserRoleVW(ucond, 0, 0);
		cond.setTuserid(dto.getUser().getUserid());
		String[] roles = new String[roleList.size()];
		for (int i = 0; i < roles.length; i++) {
			roles[i] = String.valueOf(roleList.get(i).getRoleid());
		}
		cond.setTroleids(roles);
		
		int totalCount = noticeBL.getSearchCount(cond);
		if(totalCount==0){
			return dto;
		}else if(totalCount<=num){
			//����DAO�ӿڲ�ѯ
			noticeList = noticeBL.searchNotice(cond,0,totalCount);

		}else{
			//����DAO�ӿڲ�ѯ
			noticeList = noticeBL.searchNotice(cond,0,(num+1));

		}
		List<String> noticeSList = new ArrayList<String>();
		String nid = "";
		if(noticeList!=null){

			for (int i = 0, j = noticeList.size(); i < j; i++) {
				NoticeTB notice = (NoticeTB) noticeList.get(i);
	
				if ((i + 1) > num) {
					break;
				}
				

				String showtime = notice.getNtime() + "-";
				String info = "";
				info += "&nbsp;&nbsp;" + notice.getNusername();
				info += "-" + notice.getNname();
				// ��ȡ֪ͨnid
				nid = notice.getNid().toString();
				// info+="  "+notice.getNdesc();
				// ȡ��֪ͨ��ʾ����Ϣ
				info = getShowLength(info, showtime, length + 8, nid);
				noticeSList.add(info);
			}
		
		}
		dto.setNoticeList(noticeSList);
		return dto;
	}
	
	/**
	 * ȡ�ù涨��ʾ������
	 */
	private String getShowLength(String info, String showtime, int length,
			String nid) {

		String temp = "";
		String result = "";// ���ؽ��
		temp += showtime + info;
		if (isOverShowLength(info, showtime, length)) {// ���������涨
			temp = temp.substring(0, length) + "......";
			String time = "<INPUT TYPE=\"HIDDEN\" NAME=\"nid\" VALUE="
					+ nid + ">" + temp.split("-")[0];
			result = time+"&nbsp;&nbsp;"+temp.split("-")[2] ;

		} else {
			String time = "<INPUT TYPE=\"HIDDEN\" NAME=\"nid\" VALUE="
					+ nid + ">" + temp.split("-")[0];
			result = time+"&nbsp;&nbsp;"+temp.split("-")[2];
		}

		return result;
	}
	
	/**
	 * �ж�֪ͨ�������Ƿ񳬹��涨����ʾ����
	 */
	private boolean isOverShowLength(String info, String showtime, int length) {

		boolean lengthflag = false;
		String temp = "";
		temp += showtime + info;
		if (temp.length() > length) {
			lengthflag = true;
		}

		return lengthflag;

	}
	
	/**
	 * ��ҳ��ת����
	 * @param dto IGCOM01DTO
	 * @return IGCOM01DTO
	 * @throws BLException
	 */
	public IGCOM01DTO initIGCOM0105Action(IGCOM01DTO dto) throws BLException {
		if(StringUtils.isEmpty(dto.getUsertype())) {
			//�ӵ�¼ҳ��ת
			dto.setUserPermission(userPermissionBL.initUserPermission(dto.getUser().getUserid()));
			dto.setHomepage(ig622BL.getUrl(dto.getUser().getUsertype()));
		} else {
			//�����ҳ������ת
			dto.setHomepage(ig622BL.getUrl(dto.getUsertype()));
		}
		return dto;
	}
	
	/**
	 * �澯�б�
	 * @param dto IGCOM01DTO
	 * @return IGCOM01DTO
	 * @throws Exception
	 */
	public IGCOM01DTO searchHQAlertListDetailVWAction(IGCOM01DTO dto) throws Exception {
		log.debug("========�澯��Ϣ��ѯ����ʼ========");
		log.debug("========�澯��Ϣ��ѯ��������========");
		return dto;
	}
	
	/**
	 * ҵ��ϵͳ�������б�
	 * @param dto IGCOM01DTO
	 * @return IGCOM01DTO
	 * @throws Exception
	 */
	public IGCOM01DTO searchBussinessAvailvalVWAction(IGCOM01DTO dto) throws Exception {
		log.debug("========ҵ��ϵͳ�����Բ�ѯ����ʼ========");
		List<BussinessAvailval> lst_BussinessAvailval = this.bussinessAvailvalVWBL.searchBussinessAvailvalVW();
		dto.setLst_BussinessAvailval(lst_BussinessAvailval);
		log.debug("========ҵ��ϵͳ�����Բ�ѯ��������========");
		return dto;
	}
	
	/**
	 * Oracle�澯�б�
	 * @param dto IGCOM01DTO
	 * @return IGCOM01DTO
	 * @throws Exception
	 */
	public IGCOM01DTO searchOracleAlertAction(IGCOM01DTO dto) throws Exception {
		log.debug("========Oracle�澯��ѯ����ʼ========");
		List<CRM06Info> lst_CRM06Info = this.crm06BL.searchCRM06(new CRM06SearchCondImpl());
		dto.setLst_CRM06Info(lst_CRM06Info);
		log.debug("========Oracle�澯��ѯ��������========");
		return dto;
	}
	
	/**
	 * �澯�б�
	 * @param dto IGCOM01DTO
	 * @return IGCOM01DTO
	 * @throws Exception
	 */
	public IGCOM01DTO searchHQAlertListDetailVWActionByIP(IGCOM01DTO dto) throws Exception {
		log.debug("========�澯��Ϣ��ѯ����ʼ========");
		log.debug("========�澯��Ϣ��ѯ��������========");
		return dto;
	}
	
	/**
	 * Oracle�澯�б�
	 * @param dto IGCOM01DTO
	 * @return IGCOM01DTO
	 * @throws Exception
	 */
	public IGCOM01DTO searchOracleAlertActionaa(IGCOM01DTO dto) throws Exception {
		log.debug("========Oracle�澯��ѯ����ʼ========");
		CRM06SearchCondImpl cond = new CRM06SearchCondImpl();
		cond.setServerName(dto.getIgaim0150Form().getAppText()+"_"+dto.getIgaim0150Form().getIpText());
		List<CRM06Info> lst_CRM06Info = this.crm06BL.searchCRM06(cond);
		dto.setLst_CRM06Info(lst_CRM06Info);
		log.debug("========Oracle�澯��ѯ��������========");
		return dto;
	}
}
