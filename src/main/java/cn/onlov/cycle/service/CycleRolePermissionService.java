package cn.onlov.cycle.service;


public interface CycleRolePermissionService  {

     void addRolePermission(Integer rid, Integer[] pids);

    /**
     * discription:当删除资源的时候，同时删除关联数据
     * @param ids 资源ids
     */
    void deleteByPermissionKeys(String[] ids);
}
