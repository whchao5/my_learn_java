var my_log = console.log.bind(console);

// 全局过滤器
Vue.filter("money", (value, type) => {
    return '￥' + value.toFixed(2) + type;
})

new Vue({

    el: "#app",
    data: {
        productList: [],
        totalMoney: 0,
        checkAllFlag: false,
        delFlag: false,
        curProduct: {},
    },
    filters : {
        formatMoney (value) {
            return "¥" + value.toFixed(2);
        }
    },
    mounted: function () {
        this.$nextTick(function () {
            this.cartView();
        })
    },
    methods: {
        cartView: function () {
            var _this = this;
            axios.get("../static/data/cartData.json").then(function (response) {
                // handle success
                let res = response.data;

                my_log(res);

                _this.productList = res.result.list;
                _this.totalMoney = res.result.totalMoney;
                my_log(this.productList, this.totalMoney);
            })
        },

        // 更新数量
        changeMoney: function (product, way) {
            if (way > 0) {
                product.productQuantity++;
            } else {
                if ((--product.productQuantity) < 1) {
                    product.productQuantity = 1;
                }
            }
            this.calcTotalPrice();
        },

        // 打勾
        selectedProduct: function (item) {

            if (typeof item.checked === "undefined") {
                this.$set(item, "checked", true);
            } else {
                item.checked = !item.checked
            }
            this.calcTotalPrice();

        },
        checkAll: function (flag) {
            var _this = this;
            this.checkAllFlag = flag;
            // this.productList.forEach(function (item, index) {
            //     if (typeof item.checked === "undefined" ,  _this.checkAllFlag) {
            //         _this.$set(item, "checked", _this.checkAllFlag)
            //     } else {
            //         item.checked = _this.checkAllFlag
            //     }
            // })

            this.productList.forEach((item, index) => {

                if (typeof item.checked === "undefined" && this.checkAllFlag) {
                    this.$set(item, "checked", this.checkAllFlag)
                } else {
                    item.checked = this.checkAllFlag
                }
            })

            this.calcTotalPrice();
        },
        // 更新总价钱
        calcTotalPrice: function () {
            let sum = 0;
            this.productList.forEach((item, index) => {
                if (item.checked) {
                    sum += item.productQuantity * item.productPrice
                }
            })
            this.totalMoney = sum;
        },

        delConfirm: function (item) {
            this.delFlag = true;
            this.curProduct = item;
            my_log(item);
        },
        delProduct: function () {
            var index = this.productList.indexOf(this.curProduct);
            my_log(this.productList, this.curProduct, index);
            this.productList.splice(index, 1);
            this.delFlag = false;
            this.calcTotalPrice()
        }

    }

});