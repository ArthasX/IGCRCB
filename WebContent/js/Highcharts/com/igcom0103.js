function set_line_chart(){
	 jQ('#container').highcharts({
         chart: {
             type: 'column'
         },
         title: {
             text: ''
         },
         subtitle: {
             text: ''
         },
         xAxis: {
             categories: [                 
                 '科技治理',
                 '科技风险',
                 '信息安全',
                 '开发维护',
                 '科技运行',
                 '业务连续性',
                 '外包管理',
                 '审计管理'
             ]
         },
         yAxis: {
             min: 0,
             title: {
                 text: ''
             }
         },
         tooltip: {
             headerFormat: '<span style="font-size:10px">{point.key}</span><table style="width:108px;">',
             pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
                 '<td style="padding:0"><b>{point.y}项</b></td></tr>',
             footerFormat: '</table>',
             shared: true,
             useHTML: true
         },
         plotOptions: {
             column: {
                 pointPadding: 0.2,
                 borderWidth: 0
             }
         },
         series: [{
             name: '风险点',
             data: [44, 53, 99, 35, 109, 57, 40, 33]
 
         }, {
             name: '检查项',
             data: [102, 143, 204, 86, 265, 132, 98, 75]
 
         }, {
             name: '检查工作',
             data: [34, 67, 73, 32, 89, 68, 53, 28]
         }]
     });
}



function radar() {


	//整改问题
    jQ('#container1').highcharts({
        
	    chart: {
	    	marginRight: 12,
	    	marginLeft: 0,
	        polar: true
	    },
	    title: {
	        text: ''
	    },
	    legend:{
	    	enabled:false
	    },
	    pane: {
	        startAngle: 0,
	        endAngle: 360
	    },
	
	    xAxis: {
	    	tickmarkPlacement: 'on',
            categories: [                 
                         '科技治理',
                         '科技风险',
                         '信息安全',
                         '开发维护',
                         '科技运行',
                         '业务连续性',
                         '外包',
                         '审计'
                     ]
	    
	    },
	    
	        
	    yAxis: {	    	
	        min: 0,
	        max:100,
	        labels: {
	        	formatter: function () {
	        		return this.value + '%';
	        	}
	        }
	        
	    },
	    tooltip: {
            headerFormat: '<span style="font-size:10px">{point.key}</span><table style="width:108px;">',
            pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
                '<td style="padding:0"><b>{point.y}'+'%'+'</b></td></tr>',
            footerFormat: '</table>',           
            shared: true,           
            useHTML: true
        },
	    plotOptions: {
	        series: {	          
	            pointPlacement: 'on'
	        },
	        column: {
	            pointPadding: 0,
	            groupPadding: 0
	        }
	    },	
	    series:[{	    	
	        type: 'area',
	        name: '整改率',
	        data: [60, 50, 75, 64, 46, 60, 67, 100]
	        
	    }]
	    
	});
   
}