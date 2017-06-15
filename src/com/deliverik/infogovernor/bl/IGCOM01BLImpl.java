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
 * 登录画面业务逻辑实现
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
	
	/** 用户权限BL */
	protected UserPermissionBL userPermissionBL;
	
	/** 首页跳转URL定义BL */
	protected IG622BL ig622BL;
	
	/** 业务系统可用性视图BL */
	protected BussinessAvailvalVWBL bussinessAvailvalVWBL;
	
	/** Oracle告警视图BL */
	protected CRM06BL crm06BL;
	
	/** 检查工作查询 */
	protected RiskCheckResultBL riskCheckResultBL;
	
	/**
	 * 检查工作查询设置
	 * 
	 * @param riskCheckResultBL 检查工作查询
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
	
	/** LDAP服务器IP地址 */
	private static final String IP = "160.100.101.81";
	
	/** LDAP服务器端口 */
	private static final String PORT = "80";
	
	/**
	 * 用户权限BL设定
	 * 
	 * @param userPermissionBL 用户权限BL
	 */
	public void setUserPermissionBL(UserPermissionBL userPermissionBL) {
		this.userPermissionBL = userPermissionBL;
	}
	
	/**
	 * 首页跳转URL定义BL设定
	 * 
	 * @param ig622BL
	 */
	public void setIg622BL(IG622BL ig622BL) {
		this.ig622BL = ig622BL;
	}
	
	/**
	 * 业务系统可用性视图BL 设定
	 * 
	 * @param bussinessAvailvalVWBL 业务系统可用性视图BL 
	 */
	public void setBussinessAvailvalVWBL(BussinessAvailvalVWBL bussinessAvailvalVWBL) {
		this.bussinessAvailvalVWBL = bussinessAvailvalVWBL;
	}
	
	/**
	 * Oracle告警视图BL
	 * @param crm06BL Oracle告警视图BL
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

		log.debug("========用户登录处理开始========");

		User user = null;
		try{
			user = this.userBL.searchUserByKey(dto.getUserSearchCond().getUserid());
		}catch (InvalidDataAccessResourceUsageException e) {
			throw new BLException("IGCOM0101.E001");
		}
		//用户名检查 
		//
		if (user == null) {
			log.debug("========用户登录失败(用户名不正确)========");
			dto.getIGCOM0101Form().setUserexist("1");
			//用户名不正确
			throw new BLException("IGCOM0101.E001");
		} else {
			
			//停用检验
			if (!"0".equals(user.getDeleteflag())){
				log.debug("========用户登录失败(用户停用)========");
				//用户被停用
				throw new BLException("IGCOM0101.E006");
			}
			
			//密码检查
			if (user.getPassword() == null) {
				log.debug("========用户登录失败(密码没有设定)========");
				//密码没有设定的用户的情况
				throw new BLException("IGCOM0101.E003");
			}
			
			if (!user.getPassword().equals(dto.getUserSearchCond().getPassword())){
				log.debug("========用户登录失败(密码不正确)========");
				dto.getIGCOM0101Form().setUserexist("0");
				//密码不正确
				throw new BLException("IGCOM0101.E002");
			} else {
				//用户名,密码检测成功
				dto.setUser(user);
			}
		
		}
		
		log.debug("========用户登录处理结束========");
		return dto;
	}
	
	/**
	 * 加密
	  * <p>方法名称: setEncrypt|描述: </p>
	  * @param str
	  * @return
	 */
	public static String setEncrypt(String str){
        String sn="cs"; //密钥
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
		log.debug("========LDAP 登录处理开始========");
		
		//拼接URL 格式：http://ums.ip:ums.port/cbrc/servlet/cn.com.resoft.integrate.SyncServer？servicetype=getperson& persondn=YYY
		//示例是YYY  如果没有理解错的话应该就是用户ID
		String persondn = dto.getUserSearchCond().getUserid();
		
		log.debug("persondn字段内容："+persondn);
		
		//ps：servicetype=getperson应该是请求类型为 "取得用户信息"
		String url = "http://" + IP + ":" + PORT 
				+ "/cbrc/servlet/cn.com.resoft.integrate.sync.SyncServer?servicetype=getpersonfordlk&persondn=" 
				+ persondn;
		
		log.debug("子系统提交URL请求："+url);
		
		//返回结果定义
		String returnValue = null;
		//实例化URL对象
		URL u = null;
		try {
			u = new URL(url);
		} catch (MalformedURLException e) {
			log.error("实例化url出错："+e.getMessage());
		}
		
		//通过URL取得连接对象
		URLConnection con = null;
		try {
			con = u.openConnection();
		} catch (IOException e) {
			log.error("通过URL取得连接对象出错："+e.getMessage());
		}
		
		//连接服务器
		try {
			con.connect();
		} catch (IOException e) {
			log.error("连接服务器出错："+e.getMessage());
		}
		//--------------从hearder域中取得信息--------------
		//取得状态信息  成功or失败
		String isOK = con.getHeaderField("status");
		log.debug("状态信息："+isOK);
		//根据文档提示：OK代表成功、FAIL代表失败
		if("OK".equals(isOK)){
			//取得ldap服务器上的用户信息
			returnValue = con.getHeaderField("person");
		}else {
			returnValue = "连接失败！！！";
			throw new BLException("IGCOM0101.E001");
		}
		
		log.debug("获取统一用户管理系统Http-Header中的person域的值："+returnValue);
		//解析后的字符串定义
		String content = null;
		//使用base64解析字符串
		try {
			content = new String(new BASE64Decoder().decodeBuffer(returnValue));
			
			log.debug("解析person域后的值："+content);
			
			//content转码：从GBK转换成UTF-8,通过中间字符集ISO-8859-1，以保证奇数中文不会发生乱码
			String tmp = new String(content.getBytes("GBK"),"ISO-8859-1"); 
			content = new String(tmp.getBytes("ISO-8859-1"),"UTF-8"); 
			
			log.debug("Content GBK转UTF-8后的值："+content);
		} catch (IOException e) {
			log.error("解析returnValue失败："+e.getMessage());
		}
		
		//从xml中解析出personid和userpassword
		String userpassword = content.substring(content.indexOf("<userpassword>")+14,content.indexOf("</userpassword>"));
		
		log.debug("从base64字符串中解析出来的用户密码:"+userpassword);
	
		//用户名检查 
		User user = this.userBL.searchUserByKey(persondn);
		//
		if (user == null) {
			log.debug("========LDAP 登录失败(用户名不正确)========");
			dto.getIGCOM0101Form().setUserexist("1");
			//用户名不正确
			throw new BLException("IGCOM0101.E001");
		} else {
			
			//停用检验
			if (!"0".equals(user.getDeleteflag())){
				log.debug("========LDAP 登录失败(用户停用)========");
				//用户被停用
				throw new BLException("IGCOM0101.E006");
			}
			
			//判断是否成功标识
			int isEqual = 0;
			if (dto.getIGCOM0101Form().getPassword()!=null){
				
				String pwd_trans = setEncrypt(dto.getIGCOM0101Form().getPassword());
				
				log.debug("查询出的密码："+dto.getIGCOM0101Form().getPassword());
				log.debug("密码加密后的值:"+pwd_trans);
				
				if(pwd_trans.equals(userpassword)){
					//用户名,密码检测成功
					dto.setUser(user);
					isEqual = 1;
				}else{
					throw new BLException("IGCOM0101.E002");
				}
			} else if(null == dto.getIGCOM0101Form().getPassword() || isEqual == 0){
				log.debug("========LDAP 登录失败(密码不正确)========");
				dto.getIGCOM0101Form().setUserexist("0");
				//密码不正确
				throw new BLException("IGCOM0101.E002");
			}
		
		}
		
		log.debug("========LDAP 登录处理结束========");
		return dto;
	}	
	
	/**
	 * 使用AD校验登录
	 */
	public IGCOM01DTO loginActionByAD(IGCOM01DTO dto) throws BLException {
		log.debug("========AD 登录处理开始========");
	
		//用户名检查 
		User user = this.userBL.searchUserByKey(dto.getUserSearchCond().getUserid());
		//
		if (user == null) {
			log.debug("========AD 登录失败(用户名不正确)========");
			dto.getIGCOM0101Form().setUserexist("1");
			//用户名不正确
			throw new BLException("IGCOM0101.E001");
		} else {
			
			//停用检验
			if (!"0".equals(user.getDeleteflag())){
				log.debug("========AD 登录失败(用户停用)========");
				//用户被停用
				throw new BLException("IGCOM0101.E006");
			}
			
			//密码检查
			ADAdapter adcheck = ADAdapter.getInstance();
	
			if (!adcheck.adAuthorize(dto.getUserSearchCond().getUserid(), dto.getUserSearchCond().getPassword())){
				log.debug("========AD 登录失败(密码不正确)========");
				dto.getIGCOM0101Form().setUserexist("0");
				//密码不正确
				throw new BLException("IGCOM0101.E002");
			} else {
				//用户名,密码检测成功
				dto.setUser(user);
			}
		
		}
		
		log.debug("========LDAP 登录处理结束========");
		return dto;
	}	
	
	/**
	 * <p>
	 * 获取用户被授予的角色List
	 * </p>
	 * 
	 * @param userId 用户ID
	 * @return 用户被授予的角色List
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
	 * 获取首页处理中的工作
	 * </p>
	 * 
	 * @param userId 用户ID
	 * @return 处理中的工作
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
	 * 获取首页处理中的知识
	 * </p>
	 * 
	 * @author   
	 */
	public IGCOM01DTO getKnowledge(IGCOM01DTO dto) throws BLException{
		//最新知识
		KnowledgeSearchCondImpl cond = new KnowledgeSearchCondImpl();
		cond.setKnstatus(IGKGMCONSTANTS.KNOWLEDGE_APPROVEED);
		List<Knowledge> knlist = knowledgeBL.searchKnowledgeByCond(cond, 0, 6);
		
		List<IGCOM04032VO> knvoList = new ArrayList<IGCOM04032VO>();

		if(knlist !=null && knlist.size()>0){
			
			for(int i=0;i<knlist.size();i++){
				if(i<4){
					IGCOM04032VO vo = new IGCOM04032VO();
					vo.setKnowledge(knlist.get(i));
					//主键 */
					Integer knid = knlist.get(i).getKnid();
					//知识版本 */
					 Integer knversion = knlist.get(i).getKnversion();
					//编号
					String knserial = knlist.get(i).getKnserial();
					//标题
					String title = knlist.get(i).getKntitle();
					//分类
					String knclassname = knlist.get(i).getKnclassname();
					//贡献人
					String  knproffername = knlist.get(i).getKnproffername();
					//归档日期
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
						time = time.substring(0, 10);//只保留年月日
					}
					vo.setKnfaultcause(knfaultcause);
					//标题
					vo.setTitle(title);
					vo.setKeys(knkeys);
					//归档日期
					vo.setTime(time);
				//	vo.setTitleall(titleall);
					//编号
					vo.setKnserial(knserial);
					//分类
					vo.setKnclassname(knclassname);
					//贡献人
					vo.setKnproffername(knproffername);
					vo.setKnid(knid);
					vo.setKnversion(knversion);					
 					knvoList.add(vo);
				}
			}
		}
		dto.setKnvoList(knvoList);
		
		//待审批知识
		cond = new KnowledgeSearchCondImpl();
		cond.setKnstatus(IGKGMCONSTANTS.KNOWLEDGE_UN_APPROVE);
		List<UserRoleInfo> userRoleInfoList = dto.getUserRoleInfoList();
		//当前用户所有角色id数组
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
						time = time.substring(0, 10);//只保留年月日
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
	 * Description: 获取首页中检查工作结果
	 * </p>
	 */
	public IGCOM01DTO getRiskCheckResultGoup(IGCOM01DTO dto) throws BLException {
		log.debug("========获取首页中检查工作结果处理开始========");
		//获取用户信息
		User user = dto.getUser();
		
		//调用DAO接口查询
		//个人检查工作正序查询
//		List<RiskCheckResult> lst_RiskCheckResult_Asc = this.riskCheckResultBL.riskCheckResultGoup(user.getUserid(), false, false);
		//个人检查工作倒序查询
		List<RiskCheckResult> lst_RiskCheckResult_Desc = this.riskCheckResultBL.riskCheckResultGoup(user.getUserid(), true, false);
		
		//记录个人检查工作主键
		List<Integer> lst_rcid = new ArrayList<Integer>();
		if(lst_RiskCheckResult_Desc!= null && lst_RiskCheckResult_Desc.size() > 0){
			for (RiskCheckResult riskCheckResult : lst_RiskCheckResult_Desc) {
				lst_rcid.add(riskCheckResult.getRcid());
			}
		}
		
		
		List<RiskCheckResult> lst_RiskCheckResultGroup_Asc = new ArrayList<RiskCheckResult>();
		//相关检查工作正序查询
		List<RiskCheckResult> riskCheckResultGoup_Asc  = this.riskCheckResultBL.riskCheckResultGoup(user.getUserid(), false, true);
		//从相关检查工作中去除个人检查工作
		if(riskCheckResultGoup_Asc != null && riskCheckResultGoup_Asc.size() > 0){
			for (RiskCheckResult riskCheckResult : riskCheckResultGoup_Asc ) {
				if(!lst_rcid.contains(riskCheckResult.getRcid())){
					lst_RiskCheckResultGroup_Asc.add(riskCheckResult);
				}
			}
		}
		
		
		List<RiskCheckResult> lst_RiskCheckResultGroup_Desc = new ArrayList<RiskCheckResult>();
		//相关检查工作倒序查询
		List<RiskCheckResult> riskCheckResultGoup_Des= this.riskCheckResultBL.riskCheckResultGoup(user.getUserid(), true, true);
		//从相关检查工作中去除个人检查工作
		if(riskCheckResultGoup_Des != null && riskCheckResultGoup_Des.size() > 0){
			for (RiskCheckResult riskCheckResult : riskCheckResultGoup_Des) {
				if(!lst_rcid.contains(riskCheckResult.getRcid())){
					lst_RiskCheckResultGroup_Desc.add(riskCheckResult);
				}
			}
		}
		

		//个人检查工作
//		dto.setLst_RiskCheckResult_Asc(lst_RiskCheckResult_Asc);
		dto.setLst_RiskCheckResult_Desc(lst_RiskCheckResult_Desc);
		//相关检查工作
		dto.setLst_RiskCheckResultGroup_Asc(lst_RiskCheckResultGroup_Asc);
		dto.setLst_RiskCheckResultGroup_Desc(lst_RiskCheckResultGroup_Desc);
		
		log.debug("========获取首页中检查工作结果处理终了========");
		return dto;
	}
	
	/**
	 * <p>
	 * 首页日常计划日历
	 * </p>
	 * 
	 * @author   
	 * @throws ParseException 
	 */
	@SuppressWarnings("unused")
	public IGCOM01DTO getDaysPlans(IGCOM01DTO dto) throws BLException {
		IGCOM0201Form from  = dto.getIgcom0201Form();
		
		//设默认年月
		if(StringUtils.isEmpty(from.getYear())){
			from.setYear(IGStringUtils.getCurrentYear());//当前年
			
		}
		if(StringUtils.isEmpty(from.getMonth())){
			from.setMonth(IGStringUtils.getCurrentDate().substring(5, 7));//当前月
			
		}
		dto.setIgcom0201Form(from);
		//查询计划
		dto = getUserRoles(dto);
		List<UserRoleInfo> userRoleInfoList = dto.getUserRoleInfoList();
		Map<String, String> urlMap = new HashMap<String, String>();
		// 判断是否有流程角色
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
			String curmonth = from.getMonth();// 月
			String curyear = from.getYear();// 当前年
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
			String time = IGStringUtils.getCurrentDate();// 当前时间
			for (QuartzJobsDetail qjd : quartzJobsList) {
				if (qjd.getQjdtime().length() >= 10
						&& (qjd.getQjdtime().substring(0, 10).compareTo(time) >= 0)) {
					urlMap.put(qjd.getQjdtime().substring(0, 10), "red");
				}
			}

		}
		//计算所需月份日历
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

		//拼写页面html
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
	 * 获取首页通知
	 * </p>
	 * 
	 * @author   
	 */
	public IGCOM01DTO getNotice(IGCOM01DTO dto) throws BLException{

		int num = Integer
				.parseInt(ResourceUtility.getString("NOTICE_SHOW_NUM"));// 配置文件中设定的通知的显示数目
		int length = Integer.parseInt(ResourceUtility
				.getString("NOTICE_SHOW_LENGTH"));// 配置文件中设定的通知的每行显示字数
		// 查询
		
		List<Notice> noticeList = new ArrayList<Notice>();
		NoticeSearchCondImpl cond = new NoticeSearchCondImpl();
		
		//判断该角色是否在可以看见的角色里
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
			//调用DAO接口查询
			noticeList = noticeBL.searchNotice(cond,0,totalCount);

		}else{
			//调用DAO接口查询
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
				// 获取通知nid
				nid = notice.getNid().toString();
				// info+="  "+notice.getNdesc();
				// 取得通知显示的信息
				info = getShowLength(info, showtime, length + 8, nid);
				noticeSList.add(info);
			}
		
		}
		dto.setNoticeList(noticeSList);
		return dto;
	}
	
	/**
	 * 取得规定显示的字数
	 */
	private String getShowLength(String info, String showtime, int length,
			String nid) {

		String temp = "";
		String result = "";// 返回结果
		temp += showtime + info;
		if (isOverShowLength(info, showtime, length)) {// 字数超过规定
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
	 * 判断通知的字数是否超过规定的显示字数
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
	 * 首页跳转处理
	 * @param dto IGCOM01DTO
	 * @return IGCOM01DTO
	 * @throws BLException
	 */
	public IGCOM01DTO initIGCOM0105Action(IGCOM01DTO dto) throws BLException {
		if(StringUtils.isEmpty(dto.getUsertype())) {
			//从登录页跳转
			dto.setUserPermission(userPermissionBL.initUserPermission(dto.getUser().getUserid()));
			dto.setHomepage(ig622BL.getUrl(dto.getUser().getUsertype()));
		} else {
			//点击首页链接跳转
			dto.setHomepage(ig622BL.getUrl(dto.getUsertype()));
		}
		return dto;
	}
	
	/**
	 * 告警列表
	 * @param dto IGCOM01DTO
	 * @return IGCOM01DTO
	 * @throws Exception
	 */
	public IGCOM01DTO searchHQAlertListDetailVWAction(IGCOM01DTO dto) throws Exception {
		log.debug("========告警信息查询处理开始========");
		log.debug("========告警信息查询处理终了========");
		return dto;
	}
	
	/**
	 * 业务系统可用性列表
	 * @param dto IGCOM01DTO
	 * @return IGCOM01DTO
	 * @throws Exception
	 */
	public IGCOM01DTO searchBussinessAvailvalVWAction(IGCOM01DTO dto) throws Exception {
		log.debug("========业务系统可用性查询处理开始========");
		List<BussinessAvailval> lst_BussinessAvailval = this.bussinessAvailvalVWBL.searchBussinessAvailvalVW();
		dto.setLst_BussinessAvailval(lst_BussinessAvailval);
		log.debug("========业务系统可用性查询处理终了========");
		return dto;
	}
	
	/**
	 * Oracle告警列表
	 * @param dto IGCOM01DTO
	 * @return IGCOM01DTO
	 * @throws Exception
	 */
	public IGCOM01DTO searchOracleAlertAction(IGCOM01DTO dto) throws Exception {
		log.debug("========Oracle告警查询处理开始========");
		List<CRM06Info> lst_CRM06Info = this.crm06BL.searchCRM06(new CRM06SearchCondImpl());
		dto.setLst_CRM06Info(lst_CRM06Info);
		log.debug("========Oracle告警查询处理终了========");
		return dto;
	}
	
	/**
	 * 告警列表
	 * @param dto IGCOM01DTO
	 * @return IGCOM01DTO
	 * @throws Exception
	 */
	public IGCOM01DTO searchHQAlertListDetailVWActionByIP(IGCOM01DTO dto) throws Exception {
		log.debug("========告警信息查询处理开始========");
		log.debug("========告警信息查询处理终了========");
		return dto;
	}
	
	/**
	 * Oracle告警列表
	 * @param dto IGCOM01DTO
	 * @return IGCOM01DTO
	 * @throws Exception
	 */
	public IGCOM01DTO searchOracleAlertActionaa(IGCOM01DTO dto) throws Exception {
		log.debug("========Oracle告警查询处理开始========");
		CRM06SearchCondImpl cond = new CRM06SearchCondImpl();
		cond.setServerName(dto.getIgaim0150Form().getAppText()+"_"+dto.getIgaim0150Form().getIpText());
		List<CRM06Info> lst_CRM06Info = this.crm06BL.searchCRM06(cond);
		dto.setLst_CRM06Info(lst_CRM06Info);
		log.debug("========Oracle告警查询处理终了========");
		return dto;
	}
}
