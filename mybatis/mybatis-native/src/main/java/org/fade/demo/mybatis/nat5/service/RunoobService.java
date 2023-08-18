package org.fade.demo.mybatis.nat5.service;

import org.fade.demo.mybatis.nat5.entity.Runoob;

/**
 * @author fade
 */
public interface RunoobService {

    /**
     * <p>插入</p>
     * @param runoob {@link Runoob}
     * */
    void insert(Runoob runoob);

    /**
     * <p>有异常的更新</p>
     * @param runoob {@link Runoob}
     * */
    void updateWithException(Runoob runoob);

    /**
     * <p>更新</p>
     * @param runoob {@link Runoob}
     * */
    void update(Runoob runoob);

    /**
     * <p>删除</p>
     * @param id 主键
     * */
    void delete(Integer id);

    /**
     * <p>根据主键查找</p>
     * @param id 主键
     * @return {@link Runoob}
     * */
    Runoob selectById(Integer id);

}
