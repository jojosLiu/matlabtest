package com.example.matlabtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.mathworks.toolbox.javabuilder.*;
import block_grover_matlab.BlockGrover;

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




            c = new MWNumericArray(gCovArr,MWClassID.DOUBLE);
            Object[] result = blockGrover.ins_fun1(1,c);
            double re ;

            System.out.println(Arrays.toString(result));


        }catch (MWException e) {
            e.printStackTrace();
        }


        finally {
            // 释放本地资源
            MWArray.disposeArray(c);


        }


    }




}
