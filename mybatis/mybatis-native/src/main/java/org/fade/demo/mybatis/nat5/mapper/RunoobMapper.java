package org.fade.demo.mybatis.nat5.mapper;

import org.fade.demo.mybatis.nat5.entity.Runoob;

/**
 * @author fade
 */
public interface RunoobMapper {

    /**
     * <p>插入</p>
     * @param runoob {@link Runoob}
     * @see Runoob
     * */
    void insert(Runoob runoob);

    /**
     * <p>删除</p>
     * @param id 主键
     * @see Runoob
     * */
    void delete(Integer id);

    /**
     * <p>更新</p>
     * @param runoob {@link Runoob}
     * @see Runoob
     * */
    void update(Runoob runoob);

    /**
     * <p>根据主键查找</p>
     * @param id 主键
     * @return {@link Runoob}
     * */
    Runoob findById(Integer id);

}
