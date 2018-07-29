// pages/list/list.js

var root_url = "http://localhost:8082"

Page({

  /**
   * 页面的初始数据
   */
  data: {
    area_list: []
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {

  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {
    var that = this;
    wx.request({
      url: root_url + '/admin/listarea',
      method : 'GET',
      success : function(res) {
        var areaList = res.data.areaList;

        if (areaList == null) {
          var toastText = '获取数据失败' + res.data.errMsg;
          wx.showToast({
            title: toastText,
            icon: 'warn',
            duration : 2000
          })
        } else {
          that.setData({
            area_list : areaList
          })
        }
      }
    })
  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  },

  addArea : function() {
    wx.navigateTo({
      url: '/pages/area_operation/area_operation',
    })
  },
  deleteArea : function(e) {
    console.log(e);
    var that = this;
    var deleteData = e.target.dataset;
    wx.showModal({
      title: '提示',
      content: '确定要删除[' + deleteData.areaname + ']吗？',
      success : function(res) {
        if (res.confirm) {
          console.log('用户点击确定')

          wx.request({
            url: 'http://localhost:8082/admin/removearea',
            method: "GET",
            data: {
              "areaId": deleteData.areaid
            },
            success : function(res) {
              var result = res.data.success;
              var toastText = "操作成功！";
              if (result != true) {
                toastText = "操作失败" + res.data.errMsg
              } else {
                that.data.area_list.splice(deleteData.index, 1);
                that.setData({
                  area_list: that.data.area_list
                })
              }
              console.log(res);

              wx.showToast({
                title: toastText,
                icon: '',
                duration: 2000,
              });
            }
          })
        }
      }
    })
  }


})