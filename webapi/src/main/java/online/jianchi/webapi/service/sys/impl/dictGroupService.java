package online.jianchi.webapi.service.sys.impl;

import java.util.Arrays;
import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.hutool.core.util.StrUtil;
import online.jianchi.webapi.domain.entity.sys.SysDictGroup;
import online.jianchi.webapi.domain.mapper.sys.DictGroupMapper;
import online.jianchi.webapi.service.sys.IDictGroupService;

/***
 * 字典分组DictGroupService
 * 
 * @author 二先生 @date：2020年01月22日
 */
@Service
public class DictGroupService implements IDictGroupService {

    @Autowired
    private DictGroupMapper dictGroupMapper;

    @Override
    public  Page<SysDictGroup> getPages(Page<SysDictGroup> page,SysDictGroup query) {
        QueryWrapper<SysDictGroup> wrapper = new QueryWrapper<>();
        
        if(StrUtil.hasEmpty(query.getGroupName())){
            wrapper.lambda().like(SysDictGroup::getGroupName, query.getGroupName());
        }
        Page<SysDictGroup> pages= dictGroupMapper.selectPage(page, wrapper);
        return pages;
    }

    @Override
    public List<SysDictGroup> getAll() {
        List<SysDictGroup> list =dictGroupMapper.selectList(null);
        return list;
    }

    @Override
    public SysDictGroup getModel(String id) {
        SysDictGroup model=dictGroupMapper.selectById(id);
        return model;
    }

    @Override
    public int add(SysDictGroup model) {
        return dictGroupMapper.insert(model);
    }

    @Override
    public int edit(SysDictGroup model) {
        return dictGroupMapper.updateById(model);
    }

    @Override
    public int deleteById(String id) {
        QueryWrapper<SysDictGroup> wrapper = new QueryWrapper<>();
        wrapper.lambda().like(SysDictGroup::getGroupId, id);
        
        return dictGroupMapper.delete(wrapper);
    }

    @Override
    public int deleteByIds(String ids) {
        String[] idList = ids.split(",");
        List<String> idArray = Arrays.asList(idList);
        return dictGroupMapper.deleteBatchIds(idArray);
    }

}