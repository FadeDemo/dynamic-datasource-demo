package org.fade.demo.mybatis.nat5.service.impl;

import org.fade.demo.mybatis.nat5.configuration.DataSourceKey;
import org.fade.demo.mybatis.nat5.configuration.Ds;
import org.fade.demo.mybatis.nat5.entity.Runoob;
import org.fade.demo.mybatis.nat5.mapper.RunoobMapper;
import org.fade.demo.mybatis.nat5.service.RunoobService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.util.Objects;

/**
 * @author fade
 */
@Service
public class RunoobServiceImpl implements RunoobService {

    private final RunoobMapper runoobMapper;

    public RunoobServiceImpl(RunoobMapper runoobMapper) {
        this.runoobMapper = runoobMapper;
    }

    @Override
    @Ds(DataSourceKey.SOURCE)
    @Transactional(rollbackFor = Throwable.class)
    public void insert(Runoob runoob) {
        Objects.requireNonNull(runoob);
        Assert.hasLength(runoob.getRunoobTitle(), "标题不能为空");
        Assert.hasLength(runoob.getRunoobAuthor(), "作者不能为空");
        runoob.setSubmissionDate(LocalDate.now());
        runoobMapper.insert(runoob);
    }

    @Override
    @Ds(DataSourceKey.SOURCE)
    @Transactional(rollbackFor = Throwable.class)
    public void update(Runoob runoob) {
        Objects.requireNonNull(runoob);
        Integer runoobId = runoob.getRunoobId();
        Objects.requireNonNull(runoobId);
        Runoob data = runoobMapper.findById(runoobId);
        String runoobTitle = data.getRunoobTitle();
        String runoobAuthor = data.getRunoobAuthor();
        if (StringUtils.hasLength(runoobTitle)) {
            data.setRunoobTitle(runoobTitle);
        }
        if (StringUtils.hasLength(runoobAuthor)) {
            data.setRunoobAuthor(runoobAuthor);
        }
        runoobMapper.update(runoob);
    }

    @Override
    @Ds(DataSourceKey.SOURCE)
    @Transactional(rollbackFor = Throwable.class)
    public void delete(Integer id) {
        Objects.requireNonNull(id);
        runoobMapper.delete(id);
    }

    @Override
    @Ds
    public Runoob selectById(Integer id) {
        Objects.requireNonNull(id);
        return runoobMapper.findById(id);
    }

}
