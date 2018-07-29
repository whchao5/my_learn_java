// pages/area_ operation/area_ operation.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    areaId: undefined,
    name: '',
    priority: '',
    updateAreaUrl: "http://localhost:8082/admin/modifyarea",
    addAreaUrl: "http://localhost:8082/admin/addarea"
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function(options) {
    console.log(options);

    var that = this;
    if (typeof options.areaId == "undefined") {
      return;
    }

    this.setData({
      areaId: options.areaId
    })

    console.log(this.data.areaId)
    wx.request({

      url: "http://localhost:8082/admin/getareabyid",
      method: "GET",
      data: {
        "id": options.areaId
      },
      success: function(res) {
        console.log(res);

        var area = res.data.area;

        if (typeof area === "undefined") {
          var toastText = '获取数据失败' + res.data.errMsg;
          wx.showToast({
            title: toastText,
            icon: '',
            duration: 2000
          })
        } else {
          that.setData({
            name: area.name,
            priority: area.priority,
          })
        }
      }
    })

  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function() {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function() {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function() {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function() {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function() {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function() {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function() {

  },

  formSubmit: function(e) {
    console.log(e);
    var that = this,
      formData = e.detail.value,
      url = this.data.addAreaUrl,
      areaId = this.data.areaId;
    if (typeof areaId !== "undefined") {
      url = this.data.updateAreaUrl;
      formData.id = areaId;
    }

    console.log(formData, url, typeof areaId, areaId);
    wx.request({
      url: url,
      data: JSON.stringify(formData),
      method: "POST",
      header: {
        'Content-Type': 'application/json'
      },
      success: function(res) {
        var result = res.data.success;
        var toastText = "操作成功！";
        if (result != true) {
          toastText = "操作失败" + res.data.errMsg
        }
        console.log(res);

        wx.showToast({
          title: toastText,
          icon: '',
          duration: 2000,
        });

        // if (typeof areaId == 'undefined') {
        //   wx.navigateTo({
        //     url: "../area/area",
        //   })
        // }
      }
    })
  }
})