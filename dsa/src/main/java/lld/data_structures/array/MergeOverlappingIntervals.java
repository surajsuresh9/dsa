package lld.data_structures.array;

import java.util.ArrayList;
import java.util.List;

public class MergeOverlappingIntervals {
    public static void main(String[] args) {
        int[][] intervals = {{7, 8}, {1, 5}, {2, 4}, {4, 6}};
        List<List<Integer>> res = new ArrayList<>();

        // sort interval based on start time
        sortIntervalOnStartTime(intervals);

        // add 1st interval
        List<Integer> firstInterval = new ArrayList<>();
        firstInterval.add(intervals[0][0]);
        firstInterval.add(intervals[0][1]);
        res.add(firstInterval);

        for (int i = 1; i < intervals.length; i++) {
            List<Integer> last = res.get(res.size() - 1);
            int[] curr = intervals[i];

            if (curr[0] <= last.get(1)) {
                // overlapped intervals, merge them
                last.set(1, Math.max(curr[1], last.get(1)));
            } else {
                // non-overlapped interval, add
                List<Integer> interval = new ArrayList<>();
                interval.add(curr[0]);
                interval.add(curr[1]);
                res.add(interval);
            }
        }

        for (List<Integer> interval : res)
            System.out.println(interval.get(0) + " " + interval.get(1));

    }

    static void sortIntervalOnStartTime(int[][] intervals) {
        for (int i = 0; i < intervals.length - 1; i++) {
            for (int j = i + 1; j < intervals.length; j++) {
                if (intervals[i][0] > intervals[j][0]) {
                    int[] t = new int[2];
                    t[0] = intervals[j][0];
                    t[1] = intervals[j][1];
                    intervals[j][0] = intervals[i][0];
                    intervals[j][1] = intervals[i][1];
                    intervals[i][0] = t[0];
                    intervals[i][1] = t[1];
                }
            }
        }
    }
}
