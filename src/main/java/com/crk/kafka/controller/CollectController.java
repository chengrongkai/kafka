package com.crk.kafka.controller;

import com.crk.kafka.domain.JsonResult;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashSet;


@RestController
@RequestMapping("/kafka")
public class CollectController {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private KafkaTemplate kafkaTemplate;

    @RequestMapping(value = "/send", method = RequestMethod.GET)
    public JsonResult sendKafka(String message) {
        try {
            kafkaTemplate.send("test", "key", message);
            logger.info("发送kafka成功.消息为："+message);
            return new JsonResult(1, "发送kafka成功", message);
        } catch (Exception e) {
            logger.error("发送kafka失败", e);
            return new JsonResult(0, "发送kafka失败", null);
        }
    }

    public static void main(String[] args) {
//        int[] a = new int[]{7,6,9,2,1};
//        int max = 0;
//        int max2 = 0;
//        for (int i = 0; i < a.length; i++) {
//            if (a[i]>=max2){
//                max2 = a[i];
//            }
//            if (max2>max){
//                int temp = max;
//                max = max2;
//                max2 = temp;
//            }
//        }
//        System.out.println(max);
//        System.out.println(max2);
        Solution solution = new Solution();
        int[] a = {1};
        int[] b = {1};
        int[] c =  solution.intersect(a,b);
        for (int i = 0; i < c.length; i++) {
            int i1 = c[i];
            System.out.println(i1);
        }
    }


}
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] minNums = nums1;
        int[] maxNums = nums2;
        if(nums1.length>nums2.length){
            minNums = nums2;
            maxNums = nums1;
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        HashSet set = new HashSet();
        for(int i=0;i<minNums.length;i++){
            int temp = 0;
            if(set.contains(minNums[i])){
                continue;
            }
            for(int j=1;j<maxNums.length;j++){
                if(maxNums[j] == minNums[i]){
                    temp++;
                }
            }
            if(temp>0){
                set.add(minNums[i]);
                int myTemp = 1;
                for(int t=1;t<minNums.length;t++){
                    if(t==i){
                        continue;
                    }
                    if(minNums[t] == minNums[i]){
                        myTemp++;
                    }
                }
                temp = Math.min(temp,myTemp);
                while(temp>0){
                    list.add(minNums[i]);
                    temp--;
                }
            }


        }
        int[] result = new int[list.size()];
        for (int i=0;i<list.size();i++){
            result[i] =list.get(i);
        }
        return result;
    }
}