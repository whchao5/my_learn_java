package dao;


import entity.Items;
import util.DBHelper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

// 商品业务逻辑
public class ItemDAO {

    public ArrayList<Items> getAllItems() {

        Connection conn = null;

        Statement        stmt = null;
        ResultSet        rs   = null;
        ArrayList<Items> list = new ArrayList<Items>();

        try {

            conn = DBHelper.getConnection();
            String sql = "select * from items;"; // SQL语句

            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Items items = new Items();
                items.setId(rs.getInt("id"));
                items.setName(rs.getString("name"));
                items.setCity(rs.getString("city"));
                items.setNumber(rs.getInt("number"));
                items.setPrice(rs.getInt("price"));
                items.setPicture(rs.getString("picture"));

                list.add(items);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            // 释放数据集对象
            if (rs != null) {
                try {
                    rs.close();
                    rs = null;
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            // 释放语句对象
            if (stmt != null) {
                try {
                    stmt.close();
                    stmt = null;
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }


        return list;
    }


    public static Items getItemsById(int id) {
        Connection conn = null;
        Statement  stmt = null;
        ResultSet  rs   = null;
        try {
            conn = DBHelper.getConnection();
            String sql = "select * from items where id=" + id; // SQL语句, 会被注入
            stmt = conn.createStatement();
//            stmt.setInt(1, id);
            rs = stmt.executeQuery(sql);
            if (rs.next()) {
                Items item = new Items();
                item.setId(rs.getInt("id"));
                item.setName(rs.getString("name"));
                item.setCity(rs.getString("city"));
                item.setNumber(rs.getInt("number"));
                item.setPrice(rs.getInt("price"));
                item.setPicture(rs.getString("picture"));
                return item;
            } else {
                return null;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            // 释放数据集对象
            if (rs != null) {
                try {
                    rs.close();
                    rs = null;
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            // 释放语句对象
            if (stmt != null) {
                try {
                    stmt.close();
                    stmt = null;
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

        }
    }


    //获取最近浏览的前五条商品信息
    public ArrayList<Items> getViewList(String list) {
        System.out.println("list:" + list);
        ArrayList<Items> itemlist = new ArrayList<Items>();
        int              iCount   = 5; //每次返回前五条记录
        if (list != null && list.length() > 0) {
            String[] arr = list.split("-");
            System.out.println("arr.length=" + arr.length);
            //如果商品记录大于等于5条
            if (arr.length >= 5) {
                for (int i = arr.length - 1; i >= arr.length - iCount; i--) {
                    itemlist.add(getItemsById(Integer.parseInt(arr[i])));
                }
            } else {
                for (int i = arr.length - 1; i >= 0; i--) {
                    itemlist.add(getItemsById(Integer.parseInt(arr[i])));
                }
            }
            return itemlist;
        } else {
            return null;
        }

    }

    public static void main(String[] args) {


        ItemDAO items = new ItemDAO();

        ArrayList<Items> list = items.getAllItems();

        System.out.println(list);

    }

}
