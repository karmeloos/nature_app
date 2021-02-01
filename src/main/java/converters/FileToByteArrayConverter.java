package converters;

import java.io.*;

public class FileToByteArrayConverter {
    public byte[] convert(File file) {
        try {
            FileInputStream fs = new FileInputStream(file);
            byte[] data = new byte[(int)file.length()];
            BufferedInputStream bs = new BufferedInputStream(fs);
            bs.read(data, 0, data.length);

            return data;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new byte[0];
    }
}
