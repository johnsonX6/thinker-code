package com.client.algorithem.arrays.tanxin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author hqz
 * @create 2024/10/16 22:25
 */
public class Test {
    public static void main(String[] args) {
        Activity[] activities = new Activity[]{
                new Activity(1, 4),
                new Activity(3, 5),
                new Activity(0, 6),
                new Activity(5, 7)
        };
        List<Activity> res = maxAct(activities);
        for (Activity activity : res) {
            System.out.println(activity.s + "   " + activity.e);
        }
    }

    static class Activity {
        int s;
        int e;

        public Activity(int s, int e) {
            this.s = s;
            this.e = e;
        }
    }

    /**
     * 最大不延误，能参与的活动数量
     * @param activities
     * @return
     */
    private static List<Activity> maxAct(Activity[] activities) {
        Arrays.sort(activities, Comparator.comparingInt(a -> a.e));
        int lastEnd = Integer.MIN_VALUE;
        List<Activity> activityList = new ArrayList<>();
        for (Activity activity : activities) {
            if (activity.s >= lastEnd) {
                activityList.add(activity);
                lastEnd = activity.e;
            }
        }
        return activityList;
    }

}
