package com.byx.study.tc.entityDocGenerate;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

public class JavaToExcelUtil {
    /**
     * java实体类文件转为excel
     *
     * @param inPath   目标文件路径
     * @param outPath  输出文件路径
     * @param fileName 文件名称（此处指输出文件名）
     * @throws IOException 使用时记得捕获异常
     */
    public static void javaToExcel(String inPath, String outPath, String fileName) throws IOException {
        //内存中构造Workbook对象
        Workbook wb = new XSSFWorkbook();
        //添加Sheet
        Sheet sheet = wb.createSheet("注释");
        //属性注释
        String anno = new String();
        //属性计数
        Integer num = 0;

        File infile = new File(inPath);
        InputStreamReader reader = new InputStreamReader(new FileInputStream(infile));
        BufferedReader br = new BufferedReader(reader);
        //读取的每行信息
        String line = "";
        line = br.readLine();
        //循环读取每条属性
        while (line != null) {
            line = line.trim();
            if (line.contains("/**") || line.contains("*/")) {
            } else if (line.startsWith("*")) {
                anno = line;
            } else if (line.startsWith("private")) {
                //将当前代码拆分成数组
                String[] obj = line.replaceFirst(";", "").split(" ");
                System.out.println(line);
                if (obj.length == 3) {
                    //3.添加行
                    Row row = sheet.createRow(num);
                    row.createCell(0).setCellValue(obj[2]);
                    row.createCell(1).setCellValue(obj[1]);
                    row.createCell(2).setCellValue(anno.substring(1));
                    num++;
                }
            }
            line = br.readLine();
        }
        //写出到硬盘
        OutputStream os = new FileOutputStream(new File(outPath + "\\" + fileName + ".xlsx"));
        //输出和关流
        wb.write(os);
        wb.close();
    }

    public static void main(String[] args) throws IOException {
        String fileName = "TrainMakeOrderRecord";
        String in = "/Users/mogo/IdeaProjects/personal/StudyDemo/commons/commons-dto/src/main/java/entityDocGenerate/" + fileName + ".java";
        String out = "/Users/mogo/IdeaProjects/personal/StudyDemo/commons/commons-dto/src/main/java/entityDocGenerate";
        javaToExcel(in, out, fileName);
    }

}
