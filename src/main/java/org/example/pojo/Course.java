package org.example.pojo;


import lombok.Data;

import java.time.LocalDateTime;
@Data
public class Course {
    private Integer id;
    private String title;//课程标题
    private String content;//课程内容
    private String coverImg;//封面
    private String state;//状态
    private Integer categoryId;//课程分类id
    private Integer createUser;//创建人ID
    private LocalDateTime createTime;//创建时间
    private LocalDateTime updateTime;//更新时间
}
