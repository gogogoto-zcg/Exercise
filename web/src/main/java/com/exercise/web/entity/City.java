package com.exercise.web.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author : cg.Zhou
 * @date : 2020/4/9 0009 -20:31
 * @Description : TODO
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class City implements Serializable {

    private static final long serialVersionUID = 2866630313938636233L;
    @TableId(type = IdType.AUTO)
    private Long id;
    private String name;
    private String province;
}
