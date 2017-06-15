package com.deliverik.infogovernor.fxk.bl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.bl.task.UserRoleBL;
import com.deliverik.framework.user.model.UserRoleInfo;
import com.deliverik.framework.user.model.condition.UserRoleVWSearchCondImpl;
import com.deliverik.framework.workflow.prd.bl.task.IG007BL;
import com.deliverik.framework.workflow.prd.model.IG007Info;
import com.deliverik.framework.workflow.prd.model.condition.IG007SearchCondImpl;
import com.deliverik.framework.workflow.prr.bl.task.IG898BL;
import com.deliverik.framework.workflow.prr.model.IG898Info;
import com.deliverik.framework.workflow.prr.model.condition.IG898SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.entity.IG898TB;
import com.deliverik.infogovernor.fxk.bl.task.RiskprojectvwBL;
import com.deliverik.infogovernor.fxk.dto.IGFXK03DTO;
import com.deliverik.infogovernor.fxk.form.IGFXK0302Form;
import com.deliverik.infogovernor.fxk.model.RiskprojectvwInfo;
import com.deliverik.infogovernor.fxk.model.condition.RiskprojectvwSearchCondImpl;

/**
 * 
* @ClassName: IGFXK03BLImpl 
* @Description: 风险计划查询&修改。操作项为表单值和流程本身
* @author wangyaowen@Deliverik.com 
* @date 2014-7-24 下午8:14:55 
*
 */
public class IGFXK03BLImpl extends BaseBLImpl implements IGFXK03BL {
	
    /**风险计划查询BL*/
    protected  RiskprojectvwBL riskprojectvwBL;
    
    /**表格式表单BL*/
    protected IG898BL ig898BL;
    
    /**表单定义BL*/
    protected IG007BL ig007BL;
    
    protected UserRoleBL userRoleBL;

    public UserRoleBL getUserRoleBL() {
        return userRoleBL;
    }

    public void setUserRoleBL(UserRoleBL userRoleBL) {
        this.userRoleBL = userRoleBL;
    }

    public IG007BL getIg007BL() {
        return ig007BL;
    }

    public void setIg007BL(IG007BL ig007bl) {
        ig007BL = ig007bl;
    }

    /** 日志对象 */
    private static final Log log = LogFactory.getLog(IGFXK03BLImpl.class);
    


	public RiskprojectvwBL getRiskprojectvwBL() {
		return riskprojectvwBL;
	}

    public void setIg898BL(IG898BL ig898bl) {
        ig898BL = ig898bl;
    }


	public void setRiskprojectvwBL(RiskprojectvwBL riskprojectvwBL) {
		this.riskprojectvwBL = riskprojectvwBL;
	}




	public IGFXK03DTO searchRiskproAction(IGFXK03DTO dto) throws BLException {
	    // 查询记录总数
		RiskprojectvwSearchCondImpl cond = new RiskprojectvwSearchCondImpl();
		this.copyProperties(cond, dto.getForm());
        int totalCount = riskprojectvwBL.getSearchCount(cond);
        if (totalCount == 0) {

            log.debug("========用户数据检索数据不存在========");
            // 知识服务检索数据不存在
            dto.addMessage(new ActionMessage("IGBCM0101.I002", 0));

            return dto;
        }

        if (totalCount > dto.getMaxSearchCount()) {

            log.debug("========用户检索数据件数过多========");
            // 用户检索数据件数过多
            dto.addMessage(new ActionMessage("IGBCM0101.E005", dto
                    .getMaxSearchCount(), totalCount));

            return dto;
        }
        
        //获取分页bean
        PagingDTO pDto = dto.getPagingDto();
        pDto.setTotalCount(totalCount);
	    List<RiskprojectvwInfo> risklist=riskprojectvwBL.
	            searchRiskprojectvw(cond, pDto.getFromCount(), pDto.getPageDispCount());
	    Map<RiskprojectvwInfo,Map<String,Map<String,String>>> infomap=new LinkedHashMap<RiskprojectvwInfo,Map<String,Map<String,String>>>();
	    
	    //key为rownum,value为装有键值对的map<Pvcolname,Pvalue>
	    Map<String,Map<String,String>> innermap=new LinkedHashMap<String,Map<String,String>>();
	    Map<String,String> key_valuemap=new LinkedHashMap<String, String>();
	    
	    for(RiskprojectvwInfo info :risklist){
	        //内层map初始化
	        innermap=new LinkedHashMap<String,Map<String,String>>();
	        
	        Integer prid=info.getPrid();
	        IG898SearchCondImpl cond898=new IG898SearchCondImpl();
	        cond898.setPrid(prid);
	        List<IG898Info> list898=ig898BL.searchIG898(cond898, 0, 0);
	        for(IG898Info info898:list898){
	            //key value map初始化，对应key为
	            String rownum=info898.getPvrownumber();
	            String key=info898.getPvcolname();
	            String value=info898.getPvalue();
	            if(innermap.containsKey(rownum)){
	                innermap.get(rownum).put(key, value);
	            }else{
	                key_valuemap=new LinkedHashMap<String, String>();
	                key_valuemap.put(key, value);
	                innermap.put(rownum,key_valuemap);
	            }
	        }
	        
	        infomap.put(info, innermap);
	    }
//	    System.out.println(infomap.toString());
	    dto.setInfomap(infomap);
	    
		return dto;
		
		
	}
	
	/**
	 * pdid=0100301 pidname='计划分类'
	 * 获取计划分类，作为下拉列表。
	 */
	public IGFXK03DTO searchLableValueAction(IGFXK03DTO dto) throws BLException {
	    IG007SearchCondImpl cond= new IG007SearchCondImpl();
	    cond.setPdid("0100301");
	    cond.setPidname("计划分类");
	    List<IG007Info> list=ig007BL.searchIG007Info(cond); 
	    String pidoption=list.get(0).getPidoption();
	    String [] optArr=pidoption.split("#");
	    List<LabelValueBean> lst_LabelValueBean=new ArrayList<LabelValueBean>();
	    LabelValueBean bean=new LabelValueBean();
        bean.setLabel("");
        bean.setValue("");
        lst_LabelValueBean.add(bean);
	    for(int i=1;i<optArr.length;i++){
	        bean=new LabelValueBean();
	        bean.setLabel(optArr[i]);
	        bean.setValue(optArr[i]);
	        lst_LabelValueBean.add(bean);
	    }
	    dto.setLst_LabelValueBean(lst_LabelValueBean);
        return dto;
    }

    public IGFXK03DTO searchFXK0302FormAction(IGFXK03DTO dto) throws BLException {
        IGFXK0302Form form=dto.getForm0302();
        IG898SearchCondImpl cond898=new IG898SearchCondImpl();
        cond898.setPrid(Integer.valueOf(form.getPrid()));
        cond898.setRownumber(form.getPvrownumber());
        List<IG898Info> list898=ig898BL.searchIG898(cond898, 0, 0);
        for(IG898Info info:list898){
            if("工作名称".equals(info.getPvcolname())){
                form.setRiskname(info.getPvalue());
            }
            if("工作说明".equals(info.getPvcolname())){
                form.setRiskdesc(info.getPvalue());
            }
            if("负责人".equals(info.getPvcolname())){
                form.setRiskpeople(info.getPvalue());
            }
            if("工作开始日期".equals(info.getPvcolname())){
                form.setRiskstart(info.getPvalue());
            }
            if("工作完成日期".equals(info.getPvcolname())){
                form.setRiskend(info.getPvalue());
            }
            if("工作提醒时间".equals(info.getPvcolname())){
                form.setAllocationtime(info.getPvalue());
            }
        }
        dto.setForm0302(form);
        return dto;
    }

    public IGFXK03DTO editFXK0302FormAction(IGFXK03DTO dto) throws BLException {
        IGFXK0302Form form=dto.getForm0302();
        IG898SearchCondImpl cond898=new IG898SearchCondImpl();
        cond898.setPrid(Integer.valueOf(form.getPrid()));
        cond898.setRownumber(form.getPvrownumber());
        List<IG898Info> list898=ig898BL.searchIG898(cond898, 0, 0);
        for(IG898Info info:list898){
            if("工作名称".equals(info.getPvcolname())){                
                ((IG898TB)info).setPvalue(form.getRiskname());
                ig898BL.registIG898(info);
            }
            if("工作说明".equals(info.getPvcolname())){
                ((IG898TB)info).setPvalue(form.getRiskdesc());
                ig898BL.registIG898(info);
//                form.setRiskdesc(info.getPvalue());
            }
            if("负责人".equals(info.getPvcolname())){
                ((IG898TB)info).setPvalue(form.getRiskpeople());
                ig898BL.registIG898(info);
//                form.setRiskpeople(info.getPvalue());
            }
            if("工作开始日期".equals(info.getPvcolname())){
                ((IG898TB)info).setPvalue(form.getRiskstart());
                ig898BL.registIG898(info);
//                form.setRiskstart(info.getPvalue());
            }
            if("工作完成日期".equals(info.getPvcolname())){
                ((IG898TB)info).setPvalue(form.getRiskend());
                ig898BL.registIG898(info);
//                form.setRiskstart(info.getPvalue());
            }
            if("工作提醒时间".equals(info.getPvcolname())){
                ((IG898TB)info).setPvalue(form.getAllocationtime());
                ig898BL.registIG898(info);
//                form.setAllocationtime(info.getPvalue());
            }
        }
        dto.addMessage(new ActionMessage("IGSVC1001.I001", "计划任务"));
        return dto;
    }
    /**
     *
     *负责人下拉列表
     *
     */
    public IGFXK03DTO searchUserLabelValueBean(IGFXK03DTO dto) throws BLException {
      //获取用户角色授权BL
        UserRoleVWSearchCondImpl cond = new UserRoleVWSearchCondImpl();
        //封装查询角色范围的集合
        List<Integer> roleid_in = new ArrayList<Integer>();
        Integer[] riskManagerPerson = IGFXK03BLType.RISK_MANAGER_PERSON;
        for (int i = 0; i < riskManagerPerson.length; i++) {
            roleid_in.add(riskManagerPerson[i]);//风险管理岗
        }
        
        cond.setRoleid_in(roleid_in);
        List<UserRoleInfo> lst_UserRoleVW = userRoleBL.searchUserRoleVW(cond);
        
        
        List<LabelValueBean> lst_LabelValueBean=new ArrayList<LabelValueBean>();
        LabelValueBean bean=new LabelValueBean();
        bean.setLabel("");
        bean.setValue("");
        lst_LabelValueBean.add(bean);
        for(UserRoleInfo userRoleInfo : lst_UserRoleVW){
            bean=new LabelValueBean();
            bean.setLabel(userRoleInfo.getUsername());
            bean.setValue(userRoleInfo.getUserid()+"_user_"+userRoleInfo.getUsername()+"_user_"+userRoleInfo.getRoleid());
            lst_LabelValueBean.add(bean);
        }
        dto.setPeo_LabelValueBean(lst_LabelValueBean);
        return dto;
    }

}
