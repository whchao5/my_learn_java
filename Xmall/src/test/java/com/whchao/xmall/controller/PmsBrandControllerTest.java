package com.whchao.xmall.controller;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.result.ContentResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;



import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PmsBrandControllerTest {


    protected MockMvc mockMvc;



    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before    //这个方法在每个方法执行之前都会执行一遍
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }


    //  使用方法  https://blog.csdn.net/coolcoffee168/article/details/88638042
    @Test
    public void getListAll()  throws Exception {

        String responseString = mockMvc.perform(get("/brand/listAll").accept(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        System.out.println(responseString);
    }

    @Test
    public void createBrand()  throws Exception {

        String jsonS = "{\"name\": \"万和3\",\"firstLetter\": \"W\", \"sort\": 0,\"factoryStatus\": 1,\"showStatus\": 1," +
                "\"productCount\": 100, \"productCommentCount\": 100,\"logo\": \"http://macro-oss.oss-cn-shenzhen.aliyuncs." +
                "com/mall/images/20180607/timg(5).jpg\",\"bigPic\": \"\",\"brandStory\": null}";

        String responseString = mockMvc.perform(post("/brand/createBrand").contentType(MediaType.APPLICATION_JSON).content(jsonS))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        System.out.println(responseString);
    }


}
