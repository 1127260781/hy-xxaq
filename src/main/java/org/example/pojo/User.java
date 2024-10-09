package org.example.pojo;



import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.NonNull;

import java.time.LocalDateTime;

@Data
public class User {
    @NotNull
    private Integer id;//主键ID
    private String username;//用户名
    @JsonIgnore //json不返回密码
    private String password;//密码
    @NotEmpty
    @Pattern(regexp = "^[\\u4e00-\\u9fa5a-zA-Z0-9_]{2,12}$")//由中文、英文、数字、下划线组成，长度为 2 到 12 个字符
    private String nickname;//昵称
    @NotEmpty
    @Email
    private String email;//邮箱
    private String userPic;//用户头像地址
    private String role;//权限控制
    private LocalDateTime createTime;//创建时间
    private LocalDateTime updateTime;//更新时间
}
