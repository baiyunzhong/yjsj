/* 对应/pages/charts/flot.html 表格  */
$(function(){
	//页面加载后，先爬取此时的数据，然后存储到数据库中
	$.get("/yjsj/fund/update.do",function(result){
		if(result.status==0){
			selectDate();
		}
	},'json');
	
})

function selectDate(){
	/*从数据库中查找相应的数据*/
	var url = "/yjsj/fund/selectAll.do";
	$.get (url,function(result){
		if(result.status==0){
			var funds = result.data;	
			loadData(funds);
		}
	},'json');
}

	/*把数据渲染到页面*/
function loadData(funds){
	   /*
     * BAR CHART
     * ---------
     */
    var bar_data = {
      data : [[funds[0].name, funds[0].dayGrowthRate],
    	  [funds[1].name, funds[1].dayGrowthRate],
    	  [funds[2].name, funds[2].dayGrowthRate],
    	  [funds[3].name, funds[3].dayGrowthRate],
    	  [funds[4].name, funds[4].dayGrowthRate],
    	  ],
      color: '#3c8dbc'
    }
    $.plot('#bar-chart', [bar_data], {
      grid  : {
        borderWidth: 1,
        borderColor: '#f3f3f3',
        tickColor  : '#f3f3f3'
      },
      series: {
        bars: {
          show    : true,
          barWidth: 0.5,
          align   : 'center'
        }
      },
      xaxis : {
        mode      : 'categories',
        tickLength: 0
      }
    })
}
		    /* END BAR CHART */
