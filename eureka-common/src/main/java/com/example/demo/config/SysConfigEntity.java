package com.example.demo.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysConfigEntity {

    private Long id;
    @NotBlank(message="参数名不能为空")
    private String paramKey;
    @NotBlank(message="参数值不能为空")
    private String paramValue;
    private String remark;
}
