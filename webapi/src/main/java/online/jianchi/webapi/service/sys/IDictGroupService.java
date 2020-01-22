package online.jianchi.webapi.service.sys;

import java.util.List;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import online.jianchi.webapi.domain.entity.sys.SysDictGroup;

/***
 * 字典分组接口
 * 
 * @author 二先生 @date：2020年01月22日
 */
public interface IDictGroupService {
    /**
     * 根据条件分页查询数据
     * 
     * @param query 查询条件model
     * @return 返回查询数据
     */
    public Page<SysDictGroup> getPages(Page<SysDictGroup> page,SysDictGroup query);

    /**
     * 获取所有数据
     * 
     * @return 返回所有数据
     */
    public List<SysDictGroup> getAll();

    /**
     * 获取指定Id数据
     * 
     * @param id 主键值
     * @return 返回指定Id数据
     */
    public SysDictGroup getModel(String id);

    /**
     * 新增信息
     * 
     * @param model 新增实体信息
     * @return 返回主键，异常返回空字符串
     */
    public int add(SysDictGroup model);

    /**
     * 编辑信息
     * 
     * @param model 编辑实体信息
     * @return 返回主键，异常返回空字符串
     */
    public int edit(SysDictGroup model);

    /**
     * 删除指定Id信息
     * 
     * @param id 需删除的主键值
     * @return 返回主键，异常返回空字符串
     */
    public int deleteById(String id);

    /**
     * 批量删除指定Id信息
     * 
     * @param ids 需删除的主键值字符串集合
     * @return 返回主键，异常返回空字符串
     */
    public int deleteByIds(String ids);
}