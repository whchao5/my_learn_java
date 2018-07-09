var my_log = console.log.bind(console);

new Vue({

    el : "#app",
    data : {
        title: "Hello Cart",
        productList : [],
        totalMoney : 0
    },
    mounted : function(){
        this.$nextTick(function () {
            this.cartView();
        })
    },
    methods : {
        cartView : function () {
            var _this=this;
            axios.get("../static/data/cartData.json").then(function (response) {
                // handle success
                var res = response.data;
                _this.productList = res.result.list;
                _this.totalMoney = res.result.totalMoney;
                my_log(this.productList, this.totalMoney);
            })
        }
    }

});


var example1 = new Vue({
    el: '#example-1',
    data: {
        items: [
            { message: 'Foo' },
            { message: 'Bar' }
        ]
    }
})