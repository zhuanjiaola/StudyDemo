package com.byx.study.plus;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class Tests {

    //
//    @Test
//    public void insertTest() {
//        PushData pushData = new PushData();
//        pushData.setCarportno("1");
//        pushData.setBerthId("1");
//        pushData.setTaken("Y");
////        pushData.setTime("1");
//        pushData.setVoltage("1");
//        pushData.setSign("1");
//        pushData.setSnr("1");
//
//        int result = pushDataMapper.insert(pushData);//插入数据
//        System.out.println(result);
//        System.out.println(pushData.getId());
//
//        PushData data = new PushData();
//        data.setId(0L);
//        data.setCarportno("");
//        data.setBerthId("");
//        data.setTaken("");
//        data.setTime(new Date());
//        data.setVoltage("");
//        data.setSign("");
//        data.setSnr("");
//
//        int results = pushDataMapper.updateById(data);//通过id更新数据
//
//
//        QueryWrapper<PushData> wrapper = new QueryWrapper<>();
//        wrapper.eq("taken", "Y");
//        pushDataMapper.update(pushData, wrapper);//通过querywrapper查到数据 对数据进行更新
//
//
//        UpdateWrapper<PushData> updateWrapper = new UpdateWrapper<>();
//        updateWrapper.set("taken", "Y").set("snr", "111").eq("portNo", "111");
//        pushDataMapper.update(null, updateWrapper);//通过updatewrapper更新数据
//
//
//        HashMap<String, Object> map = new HashMap<>();
//        map.put("taken", "Y");
//        map.put("snr", "222");
//        int deleteResult = pushDataMapper.deleteByMap(map);//通过map将查询条件进行and连接查询
//
//        /**
//         * 不推荐
//         */
////        QueryWrapper<PushData> pushDataQueryWrapper = new QueryWrapper<>();
////        pushDataQueryWrapper.eq("snr", "111").eq("taken", "Y");
////        int delete = pushDataMapper.delete(pushDataQueryWrapper);//通过querywrapper删除数据
//
//        PushData pushData1 = new PushData();
//        pushData1.setCarportno("");
//        pushData1.setBerthId("");
//        pushData1.setTaken("");
//        QueryWrapper<PushData> pushDataQueryWrapper1 = new QueryWrapper<>(pushData1);
//        int delete1 = pushDataMapper.delete(pushDataQueryWrapper1);//通过构造querywrapper删除数据
//
//        int i = pushDataMapper.deleteBatchIds(Arrays.asList(1L, 2L));// 根据 id 批量删除数据 deleteBatchIds传入Collection集合
//        System.out.println(i);
//
//        PushData pushData2 = pushDataMapper.selectById(1L);// 根据主键查询一条数据
//
//        List<PushData> pushData3 = pushDataMapper.selectBatchIds(Arrays.asList(1L, 2L, 3L));// 根据主键批量查询数据
//
//        pushDataMapper.selectOne(new QueryWrapper<PushData>().eq("taken", "Y"));//根据querywrapper查询一条数据
//
//
//        // 3个东西 UpdateWrapper QueryWrapper map
//
//
//    }
//
//    @Test
//    public void test02() {
//        List<SeqSensorStatus> list = mapper.selectList(null);
//        list.forEach(System.out::println);
//    }
//
//
//    @Test
//    public void deleteTest() {
//        SeqSensorStatus status = new SeqSensorStatus();
//        status.setUpTm("");
//        status.setCycle(0);
//        status.setClientPort(0);
//        status.setClientIp("");
//
//        QueryWrapper<SeqSensorStatus> queryWrapper = new QueryWrapper<>(status);
//
//        HashMap<String, Object> map = new HashMap<>();
//        map.put("cycle", "1");
//        map.put("client_port", "2");
//
//        int i1 = mapper.deleteById(1L);
//        int i2 = mapper.deleteBatchIds(Arrays.asList(1L, 2L));
//        int i3 = mapper.deleteByMap(map);
//        int i4 = mapper.delete(queryWrapper);
//    }
//
//    @Test
//    public void selectTest() {
//        SeqSensorStatus status = new SeqSensorStatus();
//        status.setUpTm("");
//        status.setCycle(0);
//        status.setClientPort(0);
//        status.setClientIp("");
//
//        QueryWrapper<SeqSensorStatus> queryWrapper = new QueryWrapper<>(status);
//
//        HashMap<String, Object> map = new HashMap<>();
//        map.put("cycle", "1");
//        map.put("client_port", "2");
//
//        mapper.selectById(1L);
//        mapper.selectBatchIds(Arrays.asList(1L, 2L));
//        List<SeqSensorStatus> seqSensorStatuses = mapper.selectList(queryWrapper);
//        List<SeqSensorStatus> seqSensorStatuses1 = mapper.selectByMap(map);
//        Integer integer = mapper.selectCount(queryWrapper);
//        SeqSensorStatus seqSensorStatus = mapper.selectOne(queryWrapper);
//        List<Object> objects = mapper.selectObjs(queryWrapper);
//        List<Map<String, Object>> maps = mapper.selectMaps(queryWrapper);
//
//    }
//
//    @Test
//    public void updateTest() {
//        SeqSensorStatus status = new SeqSensorStatus();
//        status.setUpTm("");
//        status.setCycle(0);
//        status.setClientPort(0);
//        status.setClientIp("");
//
//        QueryWrapper<SeqSensorStatus> queryWrapper = new QueryWrapper<>(status);
//
//        HashMap<String, Object> map = new HashMap<>();
//        map.put("cycle", "1");
//        map.put("client_port", "2");
//
//        mapper.updateById(status);
//
//    }




}
