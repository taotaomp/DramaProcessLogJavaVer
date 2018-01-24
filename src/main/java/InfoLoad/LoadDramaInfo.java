package InfoLoad;

import Const.ConstValues;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LoadDramaInfo implements ConstValues {
    private File file = null;

    public List<String> getDramaInfo() {
        return dramaInfo;
    }

    private List<String> dramaInfo = new ArrayList<String>();

    /**
     * 创建LoadDramaInfo唯一对象实例
     * @return  此类对象
     * @throws IOException
     */
    public static LoadDramaInfo getInstance() throws IOException {
        LoadDramaInfo loadDramaInfo = new LoadDramaInfo();
        loadDramaInfo.file = new File(ConstValues.FILE_PATH);
        if(!loadDramaInfo.file.exists()){   //判断文件是否存在，不存在则新建
            loadDramaInfo.file.createNewFile();
        }
        return loadDramaInfo;
    }

    /**
     * 装载番剧信息
     * @throws IOException
     */
    public void loadDramaInfo() throws IOException {
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader); //我来给你加个buff（逃
        while(bufferedReader.ready()){
            dramaInfo.add(bufferedReader.readLine());
        }
        bufferedReader.close();
        fileReader.close();
    }
}
