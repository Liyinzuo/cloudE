package com.example.demo.config;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class SysConfigEntity {

    private Long id;
    @NotBlank(message="参数名不能为空")
    private String paramKey;
    @NotBlank(message="参数值不能为空")
    private String paramValue;
    private String remark;
}
