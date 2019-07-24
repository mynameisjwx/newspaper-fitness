package com.hand6.health.util;/**
 * Created by Administrator on 2019/7/11.
 */
import com.hand6.health.domain.entity.HandUser;
import com.hand6.health.domain.entity.Student;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;
/**
 * @author xxxx
 * @description
 * @date 2019/7/11
 */
    public class Test {

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        students.add(new Student(1,"张三",90,2));
        students.add(new Student(1,"张三",83,3));
        students.add(new Student(1,"张三",79,4));
        students.add(new Student(2,"李四",60,4));
        students.add(new Student(3,"王五",30,5));
        students.add(new Student(3,"王五",70,3));
        students.add(new Student(3,"王五",75,2));
        students.add(new Student(4,"赵六",60,1));
        students.add(new Student(4,"赵六",85,2));

        Map<String, Integer> collect = students.stream().collect(Collectors.groupingBy(Student::getName,Collectors.summingInt(Student::getScore)));
        Map<String, Integer> collect1 = students.stream().collect(Collectors.groupingBy(Student::getName,Collectors.summingInt(Student::getScore1)));
        System.out.println(collect.get("张三"));
        System.out.println(collect1);

//        Integer flag = 4;
//        System.out.print(flag == null ? "否":flag == 1 ? "是" : "否");
        //System.out.print(DateUtil.date2Str(new Date(),"yyyyMMdd"));
//        List<HandUser> list1 = new ArrayList<HandUser>();
//        list1.add(HandUser.builder().userNumber("19531").fullName("19531").id(new Long(1)).build());
//        list1.add(HandUser.builder().userNumber("19531").fullName("19531").id(new Long(2)).build());
//        list1.add(HandUser.builder().userNumber("19532").fullName("19532").id(new Long(3)).build());
//        list1.add(HandUser.builder().userNumber("19533").fullName("19533").id(new Long(4)).build());
//        list1.add(HandUser.builder().userNumber("19534").fullName("19534").id(new Long(5)).build());
//        list1.add(HandUser.builder().userNumber("19534").fullName("19534").id(new Long(6)).build());

        //List<HandUser>  map = list1.stream().collect(Collectors.groupingBy(HandUser :: getUserNumber,Collectors.toList()));

//        Set<String> list2 = new HashSet<String>();
//        list2.add("19532");
//        list2.add("19533");
//        list2.add("19535");
//        list2.add("19536");
//        list2.add("19536");
//
//
//        // 交集
//        List<HandUser> intersection = list1.stream().distinct().filter(item -> list2.contains(item.getUserNumber())).collect(toList());
//        System.out.println("---交集 intersection---");
//        intersection.parallelStream().forEach(System.out::println);
//
//        // 差集 (list1 - list2)
//        List<HandUser> reduce1 = list1.stream().filter(item -> !list2.contains(item.getUserNumber())).collect(toList());
//        System.out.println("---差集 reduce1 (list1 - list2)---");
//        reduce1.parallelStream().forEach(System.out::println);
//
//        // 差集 (list1 - list2)
//        List<String> reduce22 = list2.stream()
//                .filter(item -> !list1.stream().map(e->e.getUserNumber()).collect(Collectors.toList()).contains(item))
//                .collect(toList());
//        System.out.println("---差集 reduce1 (list2 - list1)---");
//        reduce22.parallelStream().forEach(System.out::println);


//        // 差集 (list2 - list1)
//        List<String> reduce2 = list2.stream().distinct().filter(item -> !list1.contains(item)).collect(toList());
//        System.out.println("---拼接字符串---");
//        System.out.println(StringUtils.join(reduce22,','));
//
//        if (false || true || false || false) {
//            System.out.println("true");
//        } else {
//            System.out.println("false");
//        }


    }
}
