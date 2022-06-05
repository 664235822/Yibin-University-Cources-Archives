package com.Controller;

import com.entity.Student;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {
// @Autowired
// private StudentService studentService;
    /**
     * 保存学生信息
     */
    @PostMapping("/save")
    public String save(@RequestBody Student student) {
        System.out.println(student.toString());
//    studentService.save(student);
        System.out.println("成功");

        return "success";
    }
    @PostMapping ("/paramTest")
    public String param(String uname) {
        System.out.println(uname);
        System.out.println("成功");
        return "success";
    }
}
