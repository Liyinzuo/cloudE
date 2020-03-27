package com.example.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class SysUser {

    private Long userId;
    private String userName;
    private String userPassword;
    private String nickName;
    private String avaerUrl;
}
