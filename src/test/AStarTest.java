package test;

import java.util.LinkedList;
import java.util.List;

public class AStarTest {


    public static void main(String[] args) {

    }

    private static boolean findPath(Point start, Point end, Point[][] map, int mapWidth, int mapHeight) {

        List<Point> openList = new LinkedList<>();
        List<Point> closeList = new LinkedList<>();

        openList.add(start);

        while (openList.size() > 0) {


            // 寻找开列表中最小的 F
            Point point = findMinF(openList);

            // 把得到的 F 最小的点移除 开列表，添加到关列表中
            openList.remove(point);
            closeList.add(point);

            List<Point> surroundPoints = getSurroundPoints(point, map, mapWidth, mapHeight);
            // 过滤掉关列表中的数据
            pointFilter(surroundPoints, closeList);

            for (Point item : surroundPoints) {

                if (openList.contains(item)) {
                    float nowG = CalcG(item, point);
                    if (nowG < item.G) {
                        item.updateParent(point, nowG);
                    }

                } else {
                    item.parent = point;

                    CalcF(item, end);
                    openList.add(item);
                }
            }


            if (openList.contains(end))
                return true;

        }


        return false;
    }

    private static Point findMinF(List<Point> openList) {
        float f = Float.MAX_VALUE;
        Point temp = null;

        for (Point p : openList) {
            if (p.F < f) {
                temp = p;
                f = p.F;
            }
        }

        return temp;
    }

    private static float CalcG(Point now, Point parent) {
        return (float)distance(now, parent) + parent.G;
    }


    private static void CalcF(Point now, Point end) {
        //F=G+H
        // H 值的计算方式不唯一，有意义就行，这里是结束点X和Y的和
        float h = Math.abs(end.x - now.x) + Math.abs(end.y - now.y);
        float g = 0;

        if (now.parent == null) {
            g = 0;
        } else {
            g = CalcG(now, now.parent);
        }

        float f = g + h;
        now.F = f;
        now.G = g;
        now.H = h;


    }

    private static void pointFilter(List<Point> src, List<Point> closeList) {
        for (Point point : closeList) {
            if (src.contains(point)) {
                src.remove(point);
            }
        }
    }


    private static List<Point> getSurroundPoints(Point point, Point[][] map, int mapWidth, int mapHeight) {
        /**
         *             lu| up |ru
         *           left|    |right
         *             ld|down|rd
         */

        // 一个点一般会有上、下、左、右，左上、左下、右上、右下 八个点
        Point up = null, down = null, left = null, right = null;
        Point lu = null, ru = null, ld = null, rd = null;


        // 如果 点 Y 小于 mapHeight - 1，则表明不是最顶端，有上点
        if (point.y < mapHeight - 1) {
            up = map[point.x][point.y + 1];
        }

        // 如果 点 Y 大于 0，则表明不是最下端，有下点
        if (point.y > 0) {
            down = map[point.x][point.y - 1];
        }

        // 如果 点 X 小于 mapWidth - 1，则表明不是最右端，有右点
        if (point.x < mapWidth - 1) {
            right = map[point.x + 1][point.y];
        }
        // 如果 点 X 大于 0，则表明不是最左端，有左点
        if (point.y > 0) {
            left = map[point.x - 1][point.y];

        }

        // 边角点
        // 有上点和左点，说明有左上点
        if (up != null && left != null) {
            lu = map[point.x - 1][point.y + 1];
        }
        // 有上点和右点，说明有右上点
        if (up != null && right != null) {
            ru = map[point.x + 1][point.y + 1];
        }
        // 有下点和左点，说明有左下点
        if (down != null && left != null) {
            ld = map[point.x - 1][point.y - 1];
        }
        // 有下点和右点，说明有右下点
        if (down != null && right != null) {
            rd = map[point.x + 1][point.y - 1];
        }


        List<Point> list = new LinkedList<>();

        if (up != null && !up.isWall) {
            list.add(up);
        }


        barrierCheck(down, list);
        barrierCheck(left, list);
        barrierCheck(right, list);

        if (lu != null && lu.isWall == false && left.isWall == false && up.isWall == false) {
            list.add(lu);
        }

        //TODO the same check other corner


        return list;

    }

    private static boolean barrierCheck(Point point, List<Point> list) {
        if (point != null && !point.isWall) {
            list.add(point);
            return true;
        }

        return false;
    }


    private static double distance(Point one, Point two) {
        return Math.sqrt((double) ((one.x - two.x) * (one.x - two.x) + (one.y - two.y) * (one.y - two.y)));
    }


    private static class Point {
        public int x;
        public int y;


        public Point parent;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }


        public float F;
        public float G;
        public float H;

        public boolean isWall;

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }

        public void updateParent(Point point, float nowG) {
            parent = point;
            G = nowG;
        }
    }

}
