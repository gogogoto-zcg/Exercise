package com.exercise.web.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description :
 * @Reference :
 * @Author : zcg
 * @Date : 2020/4/8 0008 - 11:15
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DemoModel {

    private boolean success;

    private String msg;

    private Object result;
}
