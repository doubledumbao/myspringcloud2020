package com.doubledumbao.sparsearray;


import java.io.*;

/**
 * 二维数组和稀疏数组互转
 */
public class SparseArray {


    public static void main(String[] args) {

        // 0: 表示没有棋子， 1 表示 黑子 2 表蓝子
        int[][] doubleDimensionalArray = new int[11][11];
        doubleDimensionalArray[1][2] = 1;
        doubleDimensionalArray[2][3] = 2;
        doubleDimensionalArray[4][7] = 2;

        System.out.println("二维数组：");
        //实际数据个数
        int sum = 0;
        for (int[] arr : doubleDimensionalArray) {
            for (int data : arr) {
                if(data!=0){
                    sum ++;
                }
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
        System.out.println("--------------------");
        System.out.println("将二维数组转成稀疏数组");
        System.out.println("实际数据个数："+sum);
        //定义稀疏数组
        int[][] sparseArr = new int [sum+1][3];
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;


        int count = 0;
        for (int i = 0; i < doubleDimensionalArray.length; i++) {
            for (int j = 0; j < doubleDimensionalArray[i].length; j++) {

                if(doubleDimensionalArray[i][j]!=0){
                    count ++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = doubleDimensionalArray[i][j];
                }
            }
        }
        //将稀疏数组输出到文件中
        File file = new File("map.data");
        writeObjectToFile(sparseArr,file);
        //从文件中读取稀疏数组
        int[][] sparseArr1 = (int[][]) readFileToObject(file);
        System.out.println("打印稀疏数组：");
        for (int i = 0; i < sparseArr1.length; i++) {
            for (int j = 0; j < sparseArr1[i].length; j++) {
                System.out.printf("%d\t",sparseArr1[i][j]);
            }
            System.out.println();
        }
        System.out.println("将稀疏数组转成二维数组");
        //1.读取稀疏数组的第一行，创建二维数组
        int[][] arr2 = new int[sparseArr1[0][0]][sparseArr1[0][1]];
        //2. 在读取稀疏数组后几行的数据(从第二行开始)，并赋给 原始的二维数组 即可
        for (int i=1;i<sparseArr1.length;i++){
            arr2[sparseArr1[i][0]][sparseArr1[i][1]] = sparseArr1[i][2];
        }
        System.out.println("二维数组：");
        for (int[] arr : arr2) {
            for (int data : arr) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
    }

    /**
     * 从文件中读出稀疏数组
     * @param file
     */
    public static Object readFileToObject(File file) {
        InputStream inputStream = null;
        ObjectInputStream objectInputStream = null;
        Object readObject = null;
        try {
            inputStream = new FileInputStream(file);
            objectInputStream = new ObjectInputStream(inputStream);
            readObject = objectInputStream.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(objectInputStream!=null){
                try {
                    objectInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(inputStream!=null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return readObject;
    }

    /**
     * 将数组写入到文件中
     * @param objcet
     * @param file
     */
    public static void writeObjectToFile(Object objcet,File file){
        OutputStream outputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            outputStream = new FileOutputStream(file);
            objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(objcet);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(outputStream!=null){
                    outputStream.close();
                }
                if(objectOutputStream!=null){
                    objectOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
