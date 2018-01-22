package InfoStore;

import Const.ConstValues;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StoreDramaInfo implements ConstValues {
    private File file = null;
    private List<String> dramaInfo = new ArrayList<String>();

    public static StoreDramaInfo getInstance(List<String> dramaInfo) throws IOException {
        StoreDramaInfo storeDramaInfo = new StoreDramaInfo();

        storeDramaInfo.dramaInfo = dramaInfo;   //装载待写入的番剧信息
        storeDramaInfo.file = new File(ConstValues.FILE_PATH);

        if(!storeDramaInfo.file.exists()){   //判断文件是否存在，不存在则新建
            storeDramaInfo.file.createNewFile();
        }
        return storeDramaInfo;
    }

    public void storeDramaInfo() throws IOException {
        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        Iterator<String> iterator = dramaInfo.iterator();
        while (iterator.hasNext()){
            bufferedWriter.write(iterator.next());
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
        fileWriter.close();
    }
}
