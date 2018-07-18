var my_log = console.log.bind(console);

new Vue({
    el : ".container",
    data : {
        addressList : [],
        limitNum : 3,
        shippingMethod : 1
    },
    mounted : function(){
        this.$nextTick(function () {
            this.getAddressList();
        })
    },
    computed : {
        filterAddress : function () {
            return this.addressList.slice(0, this.limitNum);
        }
    }
    ,
    methods : {
        getAddressList : function() {
            axios.get("../static/data/address.json").then((response) => {

                let res = response.data;
                if (Number(res.status) === 0) {
                    this.addressList = res.result;
                }
                my_log(response);
            })
        },
        setDefault : function (addressId) {
            this.addressList.forEach((item, index) => {
                if (Number(item.addressId) === Number(addressId)) {
                    item.isDefault = true;
                } else {
                    item.isDefault = false;
                }
            })
        },
        loadMore : function () {
            this.limitNum = this.addressList.length;
        }
    }
})