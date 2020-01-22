package online.jianchi.webapi.service.sys.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import online.jianchi.webapi.domain.entity.sys.SysDictGroup;
import online.jianchi.webapi.domain.mapper.sys.DictGroupMapper;
import online.jianchi.webapi.domain.vo.sys.dict.DictGroupQuery;
import online.jianchi.webapi.service.sys.IDictGroupService;

/*
 * @author 二先生
 * @date：2020年01月22日
 */
@Service
public class DictGroupService implements IDictGroupService{

    @Autowired
    private DictGroupMapper dictGroupMapper;

	@Override
	public List<SysDictGroup> getPages(DictGroupQuery query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SysDictGroup> getAll() {
		return dictGroupMapper.selectList(null);
	}

	@Override
	public SysDictGroup getModel(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String add(SysDictGroup model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String edit(SysDictGroup model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteByIds(String ids) {
		// TODO Auto-generated method stub
		return null;
	}
}