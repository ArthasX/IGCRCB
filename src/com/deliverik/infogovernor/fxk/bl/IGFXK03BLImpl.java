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
* @Description: ���ռƻ���ѯ&�޸ġ�������Ϊ��ֵ�����̱���
* @author wangyaowen@Deliverik.com 
* @date 2014-7-24 ����8:14:55 
*
 */
public class IGFXK03BLImpl extends BaseBLImpl implements IGFXK03BL {
	
    /**���ռƻ���ѯBL*/
    protected  RiskprojectvwBL riskprojectvwBL;
    
    /**���ʽ��BL*/
    protected IG898BL ig898BL;
    
    /**������BL*/
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

    /** ��־���� */
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
	    // ��ѯ��¼����
		RiskprojectvwSearchCondImpl cond = new RiskprojectvwSearchCondImpl();
		this.copyProperties(cond, dto.getForm());
        int totalCount = riskprojectvwBL.getSearchCount(cond);
        if (totalCount == 0) {

            log.debug("========�û����ݼ������ݲ�����========");
            // ֪ʶ����������ݲ�����
            dto.addMessage(new ActionMessage("IGBCM0101.I002", 0));

            return dto;
        }

        if (totalCount > dto.getMaxSearchCount()) {

            log.debug("========�û��������ݼ�������========");
            // �û��������ݼ�������
            dto.addMessage(new ActionMessage("IGBCM0101.E005", dto
                    .getMaxSearchCount(), totalCount));

            return dto;
        }
        
        //��ȡ��ҳbean
        PagingDTO pDto = dto.getPagingDto();
        pDto.setTotalCount(totalCount);
	    List<RiskprojectvwInfo> risklist=riskprojectvwBL.
	            searchRiskprojectvw(cond, pDto.getFromCount(), pDto.getPageDispCount());
	    Map<RiskprojectvwInfo,Map<String,Map<String,String>>> infomap=new LinkedHashMap<RiskprojectvwInfo,Map<String,Map<String,String>>>();
	    
	    //keyΪrownum,valueΪװ�м�ֵ�Ե�map<Pvcolname,Pvalue>
	    Map<String,Map<String,String>> innermap=new LinkedHashMap<String,Map<String,String>>();
	    Map<String,String> key_valuemap=new LinkedHashMap<String, String>();
	    
	    for(RiskprojectvwInfo info :risklist){
	        //�ڲ�map��ʼ��
	        innermap=new LinkedHashMap<String,Map<String,String>>();
	        
	        Integer prid=info.getPrid();
	        IG898SearchCondImpl cond898=new IG898SearchCondImpl();
	        cond898.setPrid(prid);
	        List<IG898Info> list898=ig898BL.searchIG898(cond898, 0, 0);
	        for(IG898Info info898:list898){
	            //key value map��ʼ������ӦkeyΪ
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
	 * pdid=0100301 pidname='�ƻ�����'
	 * ��ȡ�ƻ����࣬��Ϊ�����б�
	 */
	public IGFXK03DTO searchLableValueAction(IGFXK03DTO dto) throws BLException {
	    IG007SearchCondImpl cond= new IG007SearchCondImpl();
	    cond.setPdid("0100301");
	    cond.setPidname("�ƻ�����");
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
            if("��������".equals(info.getPvcolname())){
                form.setRiskname(info.getPvalue());
            }
            if("����˵��".equals(info.getPvcolname())){
                form.setRiskdesc(info.getPvalue());
            }
            if("������".equals(info.getPvcolname())){
                form.setRiskpeople(info.getPvalue());
            }
            if("������ʼ����".equals(info.getPvcolname())){
                form.setRiskstart(info.getPvalue());
            }
            if("�����������".equals(info.getPvcolname())){
                form.setRiskend(info.getPvalue());
            }
            if("��������ʱ��".equals(info.getPvcolname())){
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
            if("��������".equals(info.getPvcolname())){                
                ((IG898TB)info).setPvalue(form.getRiskname());
                ig898BL.registIG898(info);
            }
            if("����˵��".equals(info.getPvcolname())){
                ((IG898TB)info).setPvalue(form.getRiskdesc());
                ig898BL.registIG898(info);
//                form.setRiskdesc(info.getPvalue());
            }
            if("������".equals(info.getPvcolname())){
                ((IG898TB)info).setPvalue(form.getRiskpeople());
                ig898BL.registIG898(info);
//                form.setRiskpeople(info.getPvalue());
            }
            if("������ʼ����".equals(info.getPvcolname())){
                ((IG898TB)info).setPvalue(form.getRiskstart());
                ig898BL.registIG898(info);
//                form.setRiskstart(info.getPvalue());
            }
            if("�����������".equals(info.getPvcolname())){
                ((IG898TB)info).setPvalue(form.getRiskend());
                ig898BL.registIG898(info);
//                form.setRiskstart(info.getPvalue());
            }
            if("��������ʱ��".equals(info.getPvcolname())){
                ((IG898TB)info).setPvalue(form.getAllocationtime());
                ig898BL.registIG898(info);
//                form.setAllocationtime(info.getPvalue());
            }
        }
        dto.addMessage(new ActionMessage("IGSVC1001.I001", "�ƻ�����"));
        return dto;
    }
    /**
     *
     *�����������б�
     *
     */
    public IGFXK03DTO searchUserLabelValueBean(IGFXK03DTO dto) throws BLException {
      //��ȡ�û���ɫ��ȨBL
        UserRoleVWSearchCondImpl cond = new UserRoleVWSearchCondImpl();
        //��װ��ѯ��ɫ��Χ�ļ���
        List<Integer> roleid_in = new ArrayList<Integer>();
        Integer[] riskManagerPerson = IGFXK03BLType.RISK_MANAGER_PERSON;
        for (int i = 0; i < riskManagerPerson.length; i++) {
            roleid_in.add(riskManagerPerson[i]);//���չ����
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
