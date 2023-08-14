package org.fade.demo.mybatis.nat5.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDate;

/**
 * @author fade
 */
@Data
@Accessors(chain = true)
public class Runoob {

    /**
     * <p>自增id</p>
     * */
    private Integer runoobId;

    /**
     * <p>标题</p>
     * */
    private String runoobTitle;

    /**
     * <p>作者</p>
     * */
    private String runoobAuthor;

    /**
     * <p>提交时间</p>
     * */
    private LocalDate submissionDate;

}
