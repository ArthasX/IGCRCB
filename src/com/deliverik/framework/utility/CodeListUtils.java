package com.deliverik.framework.utility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.bl.CodeDetailBL;
import com.deliverik.framework.model.CodeDetail;
import com.deliverik.framework.model.condition.CodeDetailSearchCond;
import com.deliverik.framework.model.condition.CodeDetailSearchCondImpl;


/**
 * 
 * 
 * @author 
 *
 */
public class CodeListUtils {
	
	/** BL */
	protected CodeDetailBL codeDetailBL;
	
	/**  */
	protected static volatile HashMap<String,CodeListCache> codeListMap = new HashMap<String,CodeListCache>();
	
	public void setCodeDetailBL(CodeDetailBL codeDetailBL){
		this.codeDetailBL = codeDetailBL;
	}
	
	/**  */
	public void init(){
		initCodeList();
	}
	
	/** init */
	protected synchronized void initCodeList() {
		// 
		CodeDetailSearchCond cond = new CodeDetailSearchCondImpl();
		List<CodeDetail> codeDetailList = 
			codeDetailBL.searchCodeDetail(cond,CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_1);
		
		HashMap<String, Boolean> hm =  new HashMap<String, Boolean>();
		String lastUpdate = "";
		String oldKeyCode = "";
		StringBuffer keycode = new StringBuffer();
		ArrayList<CodeDetail> lst = new ArrayList<CodeDetail>();
		int cnt = 0;
		
		for(CodeDetail i: codeDetailList){
			// Hash
			keycode = new StringBuffer();
			keycode.append(
					StringUtils.rightPad(StringUtils.defaultString(i.getCcid(), "   "), 3, ' '));
			keycode.append(
					StringUtils.rightPad(StringUtils.defaultString(i.getPccid(), "   "), 3, ' '));
			keycode.append(
					StringUtils.rightPad(StringUtils.defaultString(i.getPcid(), "   "), 4, ' '));
			//
			String dt = StringUtils.defaultString(i.getUpdtime(), "0000/00/00 00:00");

			// Hash
			if(hm.get(keycode.toString()) == null){
				hm.put(keycode.toString(), true);

				if(lst.size() > 0){					
					// LabelValueBean
					CodeListCache cache = new CodeListCache(getCodeLabelValueBean(lst), lastUpdate);
					cache.updateCheckTime();
					//
					codeListMap.put(oldKeyCode, cache);
					lst = new ArrayList<CodeDetail>();
					lastUpdate = "";
					cnt = 0;

				}
				oldKeyCode = keycode.toString();
			}
			
			lst.add(i);
			cnt = cnt + 1;
			
			if(lastUpdate.compareTo(dt) < 0){
				lastUpdate = dt;
			}
		}
		
		if ( codeDetailList != null && codeDetailList.size() >0 ) {
			if(lst.size() > 0){					
				// LabelValueBean
				CodeListCache cache = new CodeListCache(getCodeLabelValueBean(lst), lastUpdate);
				cache.updateCheckTime();
				//
				codeListMap.put(oldKeyCode, cache);
			}
		}
	}
	
	/**
	 * 
	 * 
	 * @param 
	 * @return 
	 */
	protected List<LabelValueBean> getCodeLabelValueBean(List<CodeDetail> l){
		List<LabelValueBean> ret = new ArrayList<LabelValueBean>();
		// 
		ret.add(new LabelValueBean("",""));

		for (CodeDetail codeInfo : l) {
			ret.add(new LabelValueBean(codeInfo.getCvalue(), codeInfo.getCid()));
		}
		return ret;
	}

	/**
	 *
	 *
	 * @param ccid
	 * @param pccid
	 * @param pcid
	 * @param cid
	 * @return
	 */
	public String getCodeValue(String ccid, String pccid, String pcid, String cid){
		String ret = null;
		
		//
		List<LabelValueBean> l = getCodeList(ccid, pccid, pcid, true, true);
		if(l==null || l.size() < 1)
			return null;
		
		for(LabelValueBean b : l){
			if(b.getValue().equals(cid)){
				ret = StringUtils.defaultString(b.getLabel(),"");
				break;
			}
		}
		return ret;
	}
	
	/**
	 *
	 *
	 * @param mst_syu_cd 
	 * @param kojyo_cd 
	 * @param key_kbn 
	 * @param isMakeBlankRow 
	 * @param isCodeLabel 
	 * @return 
	 */
	public List<LabelValueBean> getCodeList(String ccid, String pccid, String pcid, boolean isMakeBlankRow, boolean isCodeLabel){
		//checkUpdate(ccid, pccid, pcid);
		StringBuffer sbkey = new StringBuffer();
		// 
		sbkey.append(StringUtils.rightPad(StringUtils.defaultString(ccid, "   "), 3, ' '));
		sbkey.append(StringUtils.rightPad(StringUtils.defaultString(pccid, "   "), 3, ' '));
		sbkey.append(StringUtils.rightPad(StringUtils.defaultString(pcid, "   "), 4, ' '));
		List<LabelValueBean> l = null;
		if (codeListMap.get(sbkey.toString()) == null) {
			l = new ArrayList<LabelValueBean>();
			l.add(new LabelValueBean("",""));
		} else {
			l = codeListMap.get(sbkey.toString()).list;
		}
		l = ViewUtils.getCodeLabelValueBean(l, isMakeBlankRow, isCodeLabel);
		return l;
	}
	
	/**
	 * 2010/4/8 增加
	 *
	 * @param mst_syu_cd 
	 * @param kojyo_cd 
	 * @param key_kbn 
	 * @param isMakeBlankRow 
	 * @param isCodeLabel 
	 * @param type 
	 * @return 
	 */
	public List<LabelValueBean> getCodeList(String ccid, String pccid, 
			String pcid, boolean isMakeBlankRow, boolean isCodeLabel,
			String type){
		StringBuffer sbkey = new StringBuffer();
		// 
		sbkey.append(StringUtils.rightPad(StringUtils.defaultString(ccid, "   "), 3, ' '));
		sbkey.append(StringUtils.rightPad(StringUtils.defaultString(pccid, "   "), 3, ' '));
		sbkey.append(StringUtils.rightPad(StringUtils.defaultString(pcid, "   "), 4, ' '));
		List<LabelValueBean> l = null;
		if(type == null || type.equals("") ){
			//现有逻辑不变
			if (codeListMap.get(sbkey.toString()) == null) {
				l = new ArrayList<LabelValueBean>();
				l.add(new LabelValueBean("",""));
			} else {
				l = codeListMap.get(sbkey.toString()).list;
			}
		} else {
			l = new ArrayList<LabelValueBean>();
			l.add(new LabelValueBean("",""));
			for(LabelValueBean tList:codeListMap.get(sbkey.toString()).list){
				String value = tList.getValue();
				if (value.length()>0){
					if (type.equals(value.substring(0, 1))) {
						l.add(tList);
					}
				}
			}
		}

		l = ViewUtils.getCodeLabelValueBean(l, isMakeBlankRow, isCodeLabel);
		return l;
	}

	/**
	 * 
	 * 
	 * @param mst_syu_cd
	 * @param kojyo_cd
	 * @param key_kbn
	 * @return true:/false:
	 * @throws BLException 
	 */
	protected synchronized boolean checkUpdate(String ccid, String pccid, String pcid){

		ccid = StringUtils.rightPad(StringUtils.defaultString(ccid, "   "), 3, ' ');	
		pccid = StringUtils.rightPad(StringUtils.defaultString(pccid, "   "), 3, ' ');	
		pcid = StringUtils.rightPad(StringUtils.defaultString(pcid, "   "), 4, ' ');	

		StringBuffer sbkey = new StringBuffer();
		// 
		sbkey.append(ccid + pccid + pcid);

		CodeListCache cache = codeListMap.get(sbkey.toString());
		
		// 
		if( cache != null && (System.currentTimeMillis() - cache.lastCheckTime) <= 120000)
			return false;

		// 
		CodeDetailSearchCondImpl cond = new CodeDetailSearchCondImpl();
		
		cond.setCcid(ccid.trim());
		cond.setPccid(pccid.trim());
		cond.setPcid(pcid.trim());

		String lastUpddate = codeDetailBL.getLastUpdate(ccid, pccid, pcid);
		//int cnt = codeDetailBL.getSearchCount(cond);
		
		// 
		if( cache != null && StringUtils.equals(lastUpddate, cache.lastUpddate)){
		//if( cache != null && (StringUtils.equals(lastUpddate, cache.lastUpddate))&&(cnt == cache.cnt)){
			cache.updateCheckTime();
			return false;
		}
		
		//
		
		List<CodeDetail> codeInfolist = 
			codeDetailBL.searchCodeDetail(cond,CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_1);
		
		// LabelValueBean
		List<LabelValueBean> list = getCodeLabelValueBean(codeInfolist);
		
//		cnt = 0;
//		
//		if ( list != null ) {
//			cnt = list.size();
//		}
		// 
		//cache = new CodeListCache(list, lastUpddate,cnt);
		cache = new CodeListCache(list, lastUpddate);
		
		// 
		codeListMap.put(sbkey.toString(), cache);
		
		return true;
	}
	
	/**
	 * 
	 * 
	 * @param mst_syu_cd
	 * @param kojyo_cd
	 * @param key_kbn
	 * @return true:/false:
	 * @throws BLException 
	 */
	public void updateCodeDetailCache(String ccid, String pccid, String pcid){

		ccid = StringUtils.rightPad(StringUtils.defaultString(ccid, "   "), 3, ' ');	
		pccid = StringUtils.rightPad(StringUtils.defaultString(pccid, "   "), 3, ' ');	
		pcid = StringUtils.rightPad(StringUtils.defaultString(pcid, "   "), 4, ' ');	

		StringBuffer sbkey = new StringBuffer();
		// 
		sbkey.append(ccid + pccid + pcid);

		CodeDetailSearchCondImpl cond = new CodeDetailSearchCondImpl();
		
		cond.setCcid(ccid.trim());
		cond.setPccid(pccid.trim());
		cond.setPcid(pcid.trim());

		List<CodeDetail> codeInfolist = 
			codeDetailBL.searchCodeDetail(cond,CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_1);
		
		// LabelValueBean
		List<LabelValueBean> list = getCodeLabelValueBean(codeInfolist);
		
		if (list == null || list.size() == 0) {
			codeListMap.remove(sbkey.toString());
		} else {
			String lastUpddate = codeDetailBL.getLastUpdate(ccid, pccid, pcid);

			CodeListCache cache = new CodeListCache(list, lastUpddate);
			
			// 
			codeListMap.put(sbkey.toString(), cache);
		}
	}
	
	/**
	 * 
	 * @param key 
	 * @param code 
	 */
	protected void removeCode(String key, String code){
		codeListMap.get(key).remove(code);
	}
	
	/**
	 * LabelValueBean
	 */	
	public class CodeListCache {

		/** LabelValueBean */
		public List<LabelValueBean> list;
		
		/**  */
		public long lastCheckTime = System.currentTimeMillis();
		
		/**  */
		public String lastUpddate;
		
		public int cnt;

		public void updateCheckTime(){lastCheckTime = System.currentTimeMillis();}

		public CodeListCache(List<LabelValueBean> list, String lastUpddate) {
			this.list = list;
			this.lastUpddate = lastUpddate;
			//this.cnt = cnt;
		}
		
		/**
		 * 
		 * @param code 
		 */
		public void remove(String code){
			for (LabelValueBean bean : list) {
				if( code.equals(bean.getValue()) ){
					list.remove(bean);
					return;
				}
			}
		}
	}


}
