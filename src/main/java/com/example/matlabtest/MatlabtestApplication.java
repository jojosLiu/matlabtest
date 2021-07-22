package com.example.matlabtest;


import ins_fun1.BlockGrover;
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



        MWNumericArray c = null; // 存放x值的数组

        try {
            BlockGrover blockGrover = new BlockGrover();

            double[] gCovArr = { 20,20,22,25,25};
            double m=5;
            double n=10;
            c = new MWNumericArray(gCovArr,MWClassID.DOUBLE);
            Object[] result1 = blockGrover.ins_fun1(1,m,n,c);
            double re ;

//[maxk,psi,C,Emax,x,y,E,opt,k,sumP] = algorithmC(m,n);

//            Object[] result = blockGrover.algorithmC(10,m,n);


            System.out.println(Arrays.toString(result1));


        }catch (MWException e) {
            e.printStackTrace();
        }


        finally {
            // 释放本地资源
            MWArray.disposeArray(c);


        }


    }




}
