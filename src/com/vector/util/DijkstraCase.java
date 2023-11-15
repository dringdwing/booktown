package com.vector.util;

import java.util.Arrays;
public class DijkstraCase {
    private boolean[] already_arr; //记录那些节点已经被访问
    private int[] parent_arr; //记录父节点
    private int[] distance; //节点到起点的距离
    private char[] vertexes;  //节点所对应的值
    private int[][] matrix; // 节点所对应的邻接矩阵

    public DijkstraCase(char[] vertexes, int[][] matrix) {
        this.vertexes = vertexes;
        this.matrix = matrix;
        already_arr = new boolean[vertexes.length];
        parent_arr = new int[already_arr.length];
        distance = new int[already_arr.length];
    }

    // 判断所有的所有的节点是否已经被标记
    public boolean IsFinished() {
        for (boolean b : already_arr) {
            if (!b) {
                return false;
            }
        }
        return true;
    }

    //返回未访问的节点中距离起点最近的节点的下标
    public int GetNotVisitedLeast() {
        int minIndex = -1;
        for (int i = 0; i < already_arr.length; i++) {
            if (!already_arr[i] && (minIndex == -1 || distance[i] < distance[minIndex])) {
                minIndex = i;
            }
        }
        return minIndex;
    }

    public void dijkstra(int from, int to) {
        //将起点到其他点的距离设置为一个无穷值
        Arrays.fill(distance, Integer.MAX_VALUE);
        //将所有节点设置为未访问  此步骤可以省略 因为java 中 boolean值默认为false
        Arrays.fill(already_arr,false);
        distance[from] = 0; //起点到起点的距离设置为0
        //起点的父节点设置为-1 表示没有父节点
        parent_arr[from] = -1;
        //检查所有的节点是否已经被标记为已访问 ,如果全部节点都被标记已访问了 则退出循环
        while (!IsFinished()) {
            //从未访问的节点中取一个离 from 起点距离最近的节点
            int minVertex = GetNotVisitedLeast();
            for (int i = 0; i < vertexes.length; i++) {
                /**
                 * matrix[minVertex][i] != Integer.MAX_VALUE 表示 两个节点之前是连通的
                 * !already_arr[i] 表示节点没有被标记为已访问
                 * matrix[minVertex][i] + distance[minVertex]) <= distance[i] 如果当前路径距	离起点的距离比 另一条路径所得到的的距离小
                 */
                if (matrix[minVertex][i] != Integer.MAX_VALUE && !already_arr[i] && (matrix[minVertex][i] + distance[minVertex]) <= distance[i] ) {
                    //把较大的距离替换为较小的距离
                    distance[i] = matrix[minVertex][i] + distance[minVertex];
//                   //设置父节点
                    parent_arr[i] = minVertex;
                }
            }
            //将节点设置为已访问
            already_arr[minVertex] = true;
        }
        System.out.println("distance="+Arrays.toString(distance));

        for (int i = 1 ;i <vertexes.length;i++){
            StringBuilder sb = new StringBuilder();
            int  index =i;
            System.out.printf("%c[%d]-->%c[%d]的最短路径距离为:%-5d" ,vertexes[from],from,vertexes[i],i,distance[i]);
            System.out.print("路径为:");

            while (index != -1) {
                sb.append(">-" + vertexes[index]);
                index = parent_arr[index];

            }
            sb.reverse();
            System.out.println(sb);
        }
    }

    public static void main(String[] args) {
        //表示节点的值
        char[] vertex = {'A', 'B', 'C', 'D', 'E', 'F'};
        int[][] matrix = new int[vertex.length][vertex.length];
        final int N = Integer.MAX_VALUE; //表示一个无穷值  表示两个节点之间不连通
        //使用一个8x8的矩阵表示几点直接的关系 值表示 节点直接的距离
                                 //A  B  C  D  E  F
        /*A*/matrix[0] = new int[]{N, 6, 3, N, N, N,};
        /*B*/matrix[1] = new int[]{6, N, 2, 5, N, N,};
        /*C*/matrix[2] = new int[]{3, 2, N, 3, 4, N};
        /*D*/matrix[3] = new int[]{N, 5, 3, N, 2, 3,};
        /*E*/matrix[4] = new int[]{N, N, 4, 2, N, 5,};
        /*F*/matrix[5] = new int[]{N, N, N, 3, 5, N,};
        DijkstraCase dijkstraCase = new DijkstraCase(vertex, matrix);
        dijkstraCase.dijkstra(0, 5);

    }

}
