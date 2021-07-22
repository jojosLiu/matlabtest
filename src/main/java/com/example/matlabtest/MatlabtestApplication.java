package com.example.matlabtest;


import blockgrover_matlab.BlockGrover;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.mathworks.toolbox.javabuilder.*;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@SpringBootApplication
public class MatlabtestApplication {

    public static void main(String[] args) {
        SpringApplication.run(MatlabtestApplication.class, args);





        try {
//            MWNumericArray c = null; // 存放k值的数组
            BlockGrover blockGrover = new BlockGrover();


//            double[] gCovArr = { 20,20,22,25,25};
            double m=64;
            double n=10;
//            c = new MWNumericArray(gCovArr,MWClassID.DOUBLE);
//            Object[] result1 = blockGrover.ins_fun1(1,m,n,c);

            Object[] result = blockGrover.algorithmC(10,m,n);

//[maxk,psi,C,Emax,x,y,E,opt,k,sumP] = algorithmC(m,n);
//k为二维数组，2*m矩阵，其他都是单个double数字


            MWNumericArray data = (MWNumericArray) result[8];					// 输出参数k为2*m的矩阵
            double[][] kp = (double[][]) data.toDoubleArray();	            // 将矩阵k转化为二维double数组


            System.out.println("maxk : "+result[0]);
            System.out.println("Emax : " +result[3]);
            System.out.println("迭代次数k分别为 ："+result[8]);
            System.out.println("ki : "+ Arrays.toString(kp[0]));
            System.out.println("pi : "+ Arrays.toString(kp[1]));
            System.out.println("平均搜索次数E ："+result[6]);
            System.out.println("优化率 ："+result[7]);





        }catch (MWException e) {
            e.printStackTrace();
        }




    }




}
