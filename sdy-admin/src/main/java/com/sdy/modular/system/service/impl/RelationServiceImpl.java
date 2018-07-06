package com.sdy.modular.system.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.sdy.modular.system.model.Relation;
import com.sdy.modular.system.dao.RelationMapper;
import com.sdy.modular.system.service.IRelationService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色和菜单关联表 服务实现类
 * </p>
 */
@Service
public class RelationServiceImpl extends ServiceImpl<RelationMapper, Relation> implements IRelationService {

}
