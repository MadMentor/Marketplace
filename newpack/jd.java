//import java.io.FileWriter;
//import java.io.IOException;
//
//public class jd {
//    public class WriteToCSV {
//        public static void main(String[] args) {
//            String csvFile = "example.csv";
//            FileWriter writer = null;
//
//            try {
//                writer = new FileWriter(csvFile);
//                writer.append("Name");
//                writer.append(",");
//                writer.append("Age");
//                writer.append("\n");
//
//                writer.append("John Doe");
//                writer.append(",");
//                writer.append("30");
//                writer.append("\n");
//
//                writer.flush();
//            } catch (IOException e) {
//                e.printStackTrace();
//            } finally {
//                try {
//                    writer.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
//}
