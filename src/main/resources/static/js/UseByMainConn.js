/**
 * Created by 汪冉冉 on 2017/2/26.
 */

var vm=	new Vue({
    el: '#app-4',
    data: {
        lists:[],
        searchData:'',
        chosetotalcount:0,
        checkAll:false,
        addcontractor: {
            userid: '',
            contacts: '',
            Phone: '',
            mail:'',
            weixinnumber:'',
            adress:'',
            id:null
        }


    },
    computed: {
        filteredlists: function () {
            var self = this
            self.lists.filter(function (conn) {
                var searchRegex = new RegExp(self.searchData, 'i')
                return conn.isActive && (
                        searchRegex.test(conn.contacts) ||
                        searchRegex.test(conn.weixinnumber)
                    )
            })


        }
    },
    mounted: function () {
        this.$nextTick(function () {
            this.getList();
        });
    },
    //方法
    methods: {
        selectedProduct: function (item) {//单选时
            if(typeof item.checked == "undefined"){
                //Vue.set(product,"checked",true);给item注册添加新属性
                this.$set(item,"checked",true);
            }else{
                item.checked = !item.checked;
            }
            this.calcTotal();
            this.isCheckAll();

        },
        calcTotal: function () {//计算已选个数
            var chosetotalcount=0;
            this.lists.forEach(function (item) {
                if(item.checked){
                    chosetotalcount++;
                }
            });
            this.chosetotalcount = chosetotalcount;

        },
        selectAllChange:function(){//全选or取消全选
            var isCheck=this.checkAll;
            var _this=this;
            this.lists.forEach(function (item) {

                if(typeof item.checked == "undefined"){
                    //Vue.set(product,"checked",true);给item注册添加新属性
                    _this.$set(item,"checked",!isCheck);
                }else{
                    item.checked = !isCheck;
                }

                console.log("选中"+item.id+"值为"+item.checked);
            });
            this.calcTotal();
            this.checkAll=!isCheck;
        },
        isCheckAll: function () {
            var flag = true;
            this.lists.forEach(function (item) {
                if(!item.checked){
                    flag = false;
                }
            })
            if(flag){
                this.checkAll = true;
            }else{
                this.checkAll = false;
            }

        },
        getAlldetelet:function(){//查出所有需要删除的人并删除
            var _this = this;
            this.lists.forEach(function (item,index) {
                if(item.checked){
                    console.log(item.id);
                    //axios.get("/DeleteConn/?id="+item.id).then(
                    axios.get("/DeleteConn", {
                        params: {
                            id: item.id
                        }
                    }).then(
                        function(response){
                            _this.lists.splice(index,1);//删除当前联系人
                            console.log(response);
                            alert(response.data);
                        },
                        function(response){
                            alert("无法连接到服务器");
                        });
                }
            });
        },
        addconnector:function(){
            var _this=this;
            axios.get('/InsertConn', {
                params: {
                    userid: _this.addcontractor.userid,
                    contacts: _this.addcontractor.contacts,
                    Phone: _this.addcontractor.Phone,
                    mail:_this.addcontractor.mail,
                    weixinnumber:_this.addcontractor.weixinnumber,
                    adress:_this.addcontractor.adress,
                    id:null
                }

            }).then(function(response) {
                // 这里是处理正确的回调
                alert(response.data);
                _this.lists.push(_this.addcontractor);
                console.log(response);
            }, function(response) {
                // 这里是处理错误的回调
                alert("添加失败");
            });


        },
        <!--获取lists数据-->
        getList: function () {
            var _this = this;
            axios.get("/getConnectbooInfo").then(function(response){
                _this.lists=response.data;
                //alert("成功"+ _this.lists);
            },function(errormessage){
                alert("失败"+ +errormessage);
            });
        }
    }
});
