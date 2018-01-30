package InfoLoad;

import Const.ConstValues;
import Util.ChangeThePath;
import Util.CheckOperationSystem;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 番剧信息加载器，通过getInstance实例化
 * 将番剧信息装载到List<String>中
 * 通过getDramaInfo()获取装有番剧信息的List对象
 */
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
            String rawValue = bufferedReader.readLine();
            if(CheckOperationSystem.getSystem().toLowerCase().contains("win")){
                dramaInfo.add(rawValue);
            }else {
                String realValue = ChangeThePath.ConvertWinPath2LinuxPath(rawValue);
                dramaInfo.add(realValue);
            }
        }
        bufferedReader.close();
        fileReader.close();
    }
}
