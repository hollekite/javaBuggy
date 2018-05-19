package com.lgs.file;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.util.ArrayList;
import java.util.List;

/**
 * 说明：通过一个文件获取，文件下所有文件的信息，不包括文件夹
 * 作者:
 * 创建日期：2018-05-19
 * 版本：${Version}
 */
public class FileWizard {

    private List<String> Filelist = new ArrayList<String>();  //所有文件的全路径名
    private static int fileNum = 0;  //文件数量

    /**
     * 获取根文件中所有文件的全路径名，并保存在List集合中
     * @param file 根文件
     */
    public void InitFiles(File file)
    {
        if(file.isFile())
        {
            try {
                this.Filelist.add(file.getCanonicalPath());
                fileNum++;
                return ;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            File []files = file.listFiles();
            for (File file2 : files) {
                InitFiles(file2);
            }
        }
    }


    /**
     * 得到所有的文件的文件名
     * @return 文件名的List集合
     */
    @Deprecated
    public List<String> getNames()
    {
        List<String> suffixlist = new ArrayList<String>();
        for (String s : this.Filelist) {
            String name =s.substring(s.lastIndexOf(File.separator)+1,s.length() ) ;
            suffixlist.add(name);
        }
        return suffixlist;
    }

    /**
     * 获取包含全路径的文件名
     * @return
     */
    public List<String> getWholePathNames()
    {
        return this.Filelist;
    }

    /**
     *获取指定后缀的文件名
     * @param suffix
     * @return
     */
    @Deprecated
    public  List<String> getAppointSuffixFileName(String suffix)
    {
        List<String> suffixlist = new ArrayList<String>();
        for (String s : this.Filelist) {
            if(s.endsWith(suffix)) {
                String name = s.substring(s.lastIndexOf(File.separator) + 1, s.length());
                suffixlist.add(name);
            }
        }
        return suffixlist;
    }

    /**
     * 获取文件中所有的类的类名
     * @return
     */
    public  List<String> getClassNames()
    {
        List<String> suffixlist = new ArrayList<String>();
        for (String s : this.Filelist) {
            if(s.endsWith(".class")) {
                String name = s.substring(s.lastIndexOf(File.separator)+1, s.length()-(".class").length());
                suffixlist.add(name);
            }
        }
        return suffixlist;
    }
    /**
     * 获取所有类的全路径名
     * @return
     */
    public List<String> getClassFiles(String path)
    {
        List<String> suffixlist = new ArrayList<String>();
        for (String s : this.Filelist) {

                String name = s.substring(path.length()-1, s.length()-(".class").length());
                name=name.replaceAll("\\\\",".");
                suffixlist.add(name);
            }
        return suffixlist;
    }


    /**
     * 传入的根文件是否为空（根文件中是否包含文件）
     * @return false--有文件  true--没有文件
     */
    public boolean isEmpty()
    {
        if(fileNum>0)
            return false;
        return true;
    }

    /**
     * 获取根文件中文件数量
     * @return
     */
    public int  getFileNum()
    {
        return  this.fileNum;
    }




}
