package com;

import com.entity.Student;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
class Test3ApplicationTests {

    @Autowired
    WebApplicationContext context;
    MockMvc mockMVC;

    @BeforeEach
    public void before() {
        mockMVC = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    void TestSave() throws Exception {
        Student student = new Student(1, "黄乙鑫");
        ObjectMapper mapper = new ObjectMapper();
        mockMVC.perform(post("/student/save").contentType(MediaType.APPLICATION_JSON_UTF8).
                accept(MediaType.APPLICATION_JSON_UTF8)
                .content(mapper.writeValueAsString(student)))
                .andExpect(status().isOk()).andDo(print());
    }

    @Test
    void TestParam() throws Exception {
        mockMVC.perform(post("/student/paramTest")
                        .param("uname", "收银员"))
                .andExpect(status().isOk())//状态响应码为200，如果不是抛出异常，测试不通过。
                .andDo(print());//输出结果
    }

}
