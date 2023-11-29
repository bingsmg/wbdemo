package live.cloverescape.startimes.schoolrecruit;

/**
 * @author weibb
 * @date 2023-11-20
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ReadFile {

    static String filePath = "D:\\IdeaProjects\\wbdemo\\code-lc\\src\\main\\java\\live\\cloverescape\\startimes\\schoolrecruit\\input.txt";


    public static void main(String[] args) {
        try {
            // 读取文件内容
            List<Record> records = readFile(filePath);

            // 输出结果
            for (Record record : records) {
                System.out.println(record);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Record> readFile(String filePath) throws IOException {
        List<Record> records = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                // 读取第一行
                String[] tokens = line.split(" ");
                int n = Integer.parseInt(tokens[0]);
                int k = Integer.parseInt(tokens[1]);

                // 读取第二行，并以空格分割
                String str = br.readLine();

                // 构建 Record 对象
                Record record = new Record(str, n, k);

                // 添加到列表
                records.add(record);
            }
        }

        return records;
    }

    static class Record {
        String str;
        int n;
        int k;

        Record(String str, int n, int k) {
            this.str = str;
            this.n = n;
            this.k = k;
        }

        @Override
        public String toString() {
            return "Record{" +
                    "str='" + str + '\'' +
                    ", n=" + n +
                    ", k=" + k +
                    '}';
        }

        @Override
        public int hashCode() {
            return Objects.hash(str, n, k);
        }
    }
}

