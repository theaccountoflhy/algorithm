package demo;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author luohongyan
 * time：2021/3/31
 * @version 1.0
 * 一些项目要占用一个会议室宣讲，会议室不能同时容纳两个项目的宣讲。
 * 给你每一个项目的开始时间和结束时间（给你一个数组，里面是一个个具体的项目），
 * 你来安排宣讲的日程，要求会议室进行宣讲的场次最多，返回这个最多的宣讲场次。
 * input: arr[project detail]
 * return: the max times of project..
 *
 * 解题思路：
 * 贪心策略：那个早结束，安排哪一个
 */

public class BestArrange {

    public static class Project{
        private int start;
        private int end;

        public Project(int start,int end){
            this.start = start;
            this.end = end;
        }
    }

    public static class ProjectComparator implements Comparator<Project> {
        @Override
        public int compare(Project o1,Project o2) {
            return o1.end - o2.end;
        }
    }

    public static int bestArrange (Project[] project,int curTime){
        Arrays.sort(project, new ProjectComparator());
        int result =0;
        for(int i =0;i< project.length;i++){
            if(curTime <= project[i].start){
                result++;
                curTime = project[i].end;
            }
        }
        return result;
    }

    public static void main (String[] Args){
        Project[] project = new Project[4];
        project[0]= new Project(0,1);
        project[1]= new Project(0,1);
        project[2]= new Project(2,5);
        project[3]= new Project(4,7);

        System.out.println(bestArrange(project,0));

    }
}
