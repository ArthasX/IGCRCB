/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.asset.bl;


/**
 * 合同统计页添加
 * @创建时间 2013/06/30 LiJi
 */
public final class IGASM04BLType {
	//-----------物品种类管理常量-----------
	
	
	// 共15个应付款比例
	public static final String[] PAY_PERCENT_CID = { "CI060000000013", "CI060000000020", "CI060000000027",
			"CI060000000034", "CI060000000041", "CI060000000063", "CI060000000091", "CI060000000070", "CI060000000077", "CI060000000084", "CI060000000098",
			"CI060000000105", "CI060000000112", "CI060000000119", "CI060000000126" };

	// 共15个应付款时间
	public static final String[] PAY_DATE_CID = { "CI060000000015", "CI060000000022", "CI060000000029","CI060000000036",
			"CI060000000043", "CI060000000065", "CI060000000072", "CI060000000079", "CI060000000086", "CI060000000093", "CI060000000100", "CI060000000107",
			"CI060000000114", "CI060000000121", "CI060000000128" };

	// 共15个付款金额
	public static final String[] CivalueOfMoney = { "CI060000000014", "CI060000000021", "CI060000000028",
			"CI060000000035", "CI060000000042", "CI060000000064", "CI060000000092", "CI060000000071", "CI060000000078", "CI060000000085", "CI060000000099",
			"CI060000000106", "CI060000000113", "CI060000000120", "CI060000000127" };

	// 共15个付款实付日
	public static final String[] CID = { "CI060000000017", "CI060000000024", "CI060000000031", "CI060000000038",
			"CI060000000045", "CI060000000067", "CI060000000074", "CI060000000081", "CI060000000088", "CI060000000095", "CI060000000102", "CI060000000109",
			"CI060000000116", "CI060000000123", "CI060000000130" };
	
	// 第一笔
	public static final String PAY_FIRST_CID_NAME = "第一笔应付款";
	public static final String PAY_FIRST_CID_PERCENT = "CI060000000013"; //应付款比例
	public static final String PAY_FIRST_CID_DATE = "CI060000000015"; //应付款日期
	public static final String PAY_FIRST_CID_MONEY = "CI060000000014"; //实际付款
	public static final String PAY_FIRST_CID_RDATE = "CI060000000017"; //实际付款日
	
	// 第二笔    
	public static final String PAY_SECOND_CID_NAME = "第二笔应付款";
	public static final String PAY_SECOND_CID_PERCENT = "CI060000000020"; //应付款比例
	public static final String PAY_SECOND_CID_DATE = "CI060000000022"; //应付款日期
	public static final String PAY_SECOND_CID_MONEY = "CI060000000021"; //实际付款
	public static final String PAY_SECOND_CID_RDATE = "CI060000000024"; //实际付款日
	
	// 第三笔    
	public static final String PAY_THIRD_CID_NAME = "第三笔应付款";
	public static final String PAY_THIRD_CID_PERCENT = "CI060000000027"; //应付款比例
	public static final String PAY_THIRD_CID_DATE = "CI060000000029"; //应付款日期
	public static final String PAY_THIRD_CID_MONEY = "CI060000000028"; //实际付款
	public static final String PAY_THIRD_CID_RDATE = "CI060000000031"; //实际付款日
	
	// 第四笔    
	public static final String PAY_FOURTH_CID_NAME = "第四笔应付款";
	public static final String PAY_FOURTH_CID_PERCENT = "CI060000000034"; //应付款比例
	public static final String PAY_FOURTH_CID_DATE = "CI060000000036"; //应付款日期
	public static final String PAY_FOURTH_CID_MONEY = "CI060000000035"; //实际付款
	public static final String PAY_FOURTH_CID_RDATE = "CI060000000038"; //实际付款日
	
	// 第五笔    
	public static final String PAY_FIFTH_CID_NAME = "第五笔应付款";
	public static final String PAY_FIFTH_CID_PERCENT = "CI060000000041"; //应付款比例
	public static final String PAY_FIFTH_CID_DATE = "CI060000000043"; //应付款日期
	public static final String PAY_FIFTH_CID_MONEY = "CI060000000042"; //实际付款
	public static final String PAY_FIFTH_CID_RDATE = "CI060000000045"; //实际付款日
	
	// 第六笔    
	public static final String PAY_SIXTH_CID_NAME = "第六笔应付款";
	public static final String PAY_SIXTH_CID_PERCENT = "CI060000000063"; //应付款比例
	public static final String PAY_SIXTH_CID_DATE = "CI060000000065"; //应付款日期
	public static final String PAY_SIXTH_CID_MONEY = "CI060000000064"; //实际付款
	public static final String PAY_SIXTH_CID_RDATE = "CI060000000067"; //实际付款日
	
	// 第七笔    
	public static final String PAY_SEVENTH_CID_NAME = "第七笔应付款";
	public static final String PAY_SEVENTH_CID_PERCENT = "CI060000000070"; //应付款比例
	public static final String PAY_SEVENTH_CID_DATE = "CI060000000072"; //应付款日期
	public static final String PAY_SEVENTH_CID_MONEY = "CI060000000071"; //实际付款
	public static final String PAY_SEVENTH_CID_RDATE = "CI060000000074"; //实际付款日
	
	// 第八笔   
	public static final String PAY_EIGHTH_CID_NAME = "第八笔应付款";
	public static final String PAY_EIGHTH_CID_PERCENT = "CI060000000077"; //应付款比例
	public static final String PAY_EIGHTH_CID_DATE = "CI060000000079"; //应付款日期
	public static final String PAY_EIGHTH_CID_MONEY = "CI060000000078"; //实际付款
	public static final String PAY_EIGHTH_CID_RDATE = "CI060000000081"; //实际付款日
	
	// 第九笔  
	public static final String PAY_NINTH_CID_NAME = "第九笔应付款";
	public static final String PAY_NINTH_CID_PERCENT = "CI060000000084"; //应付款比例
	public static final String PAY_NINTH_CID_DATE = "CI060000000086"; //应付款日期
	public static final String PAY_NINTH_CID_MONEY = "CI060000000085"; //实际付款
	public static final String PAY_NINTH_CID_RDATE = "CI060000000088"; //实际付款日
	
	// 第十笔   
	public static final String PAY_TENTH_CID_NAME = "第十笔应付款";
	public static final String PAY_TENTH_CID_PERCENT = "CI060000000091"; //应付款比例
	public static final String PAY_TENTH_CID_DATE = "CI060000000093"; //应付款日期
	public static final String PAY_TENTH_CID_MONEY = "CI060000000092"; //实际付款
	public static final String PAY_TENTH_CID_RDATE = "CI060000000095"; //实际付款日
	
	// 第十一笔   
	public static final String PAY_ELEVENTH_CID_NAME = "第十一笔应付款";
	public static final String PAY_ELEVENTH_CID_PERCENT = "CI060000000098"; //应付款比例
	public static final String PAY_ELEVENTH_CID_DATE = "CI060000000100"; //应付款日期
	public static final String PAY_ELEVENTH_CID_MONEY = "CI060000000099"; //实际付款
	public static final String PAY_ELEVENTH_CID_RDATE = "CI060000000102"; //实际付款日
	
	// 第十二笔  
	public static final String PAY_TWELFTH_CID_NAME = "第十二笔应付款";
	public static final String PAY_TWELFTH_CID_PERCENT = "CI060000000105"; //应付款比例
	public static final String PAY_TWELFTH_CID_DATE = "CI060000000107"; //应付款日期
	public static final String PAY_TWELFTH_CID_MONEY = "CI060000000106"; //实际付款
	public static final String PAY_TWELFTH_CID_RDATE = "CI060000000109"; //实际付款日
	
	// 第十三笔 
	public static final String PAY_THIRTEEN_CID_NAME = "第十三笔应付款";
	public static final String PAY_THIRTEEN_CID_PERCENT = "CI060000000112"; //应付款比例
	public static final String PAY_THIRTEEN_CID_DATE = "CI060000000114"; //应付款日期
	public static final String PAY_THIRTEEN_CID_MONEY = "CI060000000113"; //实际付款
	public static final String PAY_THIRTEEN_CID_RDATE = "CI060000000116"; //实际付款日
	
	// 第十四笔 
	public static final String PAY_FOURTEEN_CID_NAME = "第十四笔应付款";
	public static final String PAY_FOURTEEN_CID_PERCENT = "CI060000000119"; //应付款比例
	public static final String PAY_FOURTEEN_CID_DATE = "CI060000000121"; //应付款日期
	public static final String PAY_FOURTEEN_CID_MONEY = "CI060000000120"; //实际付款
	public static final String PAY_FOURTEEN_CID_RDATE = "CI060000000123"; //实际付款日
	
	// 第十五笔
	public static final String PAY_FIFTEEN_CID_NAME = "第十五笔应付款";
	public static final String PAY_FIFTEEN_CID_PERCENT = "CI060000000126"; //应付款比例
	public static final String PAY_FIFTEEN_CID_DATE = "CI060000000128"; //应付款日期
	public static final String PAY_FIFTEEN_CID_MONEY = "CI060000000127"; //实际付款
	public static final String PAY_FIFTEEN_CID_RDATE = "CI060000000130"; //实际付款日

	//合同导出表头
	public static final String[] CLABEL = {"IG_0110", "IG_0111", "IG_0113", "IG_0116", "IG_0264", "IG_0265", "IG_0266"};
	
	//IG_0110项目名称
	public static final String CLABEL_IG_0110 = "IG_0110";
	
	//IG_0111签订日期
	public static final String CLABEL_IG_0111 = "IG_0111";	
	
	//IG_0116合同总价格
	public static final String CLABEL_IG_0116 = "IG_0116";
	
	//IG_0113服务商
	public static final String CLABEL_IG_0113 = "IG_0113";
	
	//IG_0264财审委意见
	public static final String CLABEL_IG_0264 = "IG_0264";
	
	//IG_0265会议纪要编号
	public static final String CLABEL_IG_0265 = "IG_0265";
	
	//IG_0266审批日期
	public static final String CLABEL_IG_0266 = "IG_0266";

	
}
	
	
	
	
