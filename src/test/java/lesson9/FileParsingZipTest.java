import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.opencsv.CSVReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.InputStreamReader;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class FileParsingZipTest {

    private final ClassLoader cl = FileParsingZipTest.class.getClassLoader();

    @Test
    void zipFileParsingAndContentCheckCsvTest() throws Exception {
        try (ZipInputStream zis = new ZipInputStream(
                cl.getResourceAsStream("test_files.zip")
        )) {
            ZipEntry entry;

            while ((entry = zis.getNextEntry()) != null) {
                String fileName = entry.getName();
                System.out.println("Reading: " + fileName);

                if (fileName.endsWith(".csv")) {
                    CSVReader csvReader = new CSVReader(new InputStreamReader(zis));
                    List<String[]> data = csvReader.readAll();

                    Assertions.assertArrayEquals(
                            new String[]{"id", "name", "email", "registration_date"},
                            data.get(0), "Заголовок");

                    Assertions.assertArrayEquals(
                            new String[]{"1", "Иван Иванов", "ivan@example.com", "2023-01-15"},
                            data.get(1), "1 строка");

                    Assertions.assertArrayEquals(
                            new String[]{"2", "Петр Петров", "peter@example.com", "2023-02-20"},
                            data.get(2), "2 строка");
                }
            }
        }
    }

    @Test
    void zipFileParsingAndContentCheckPdfTest() throws Exception {
        try (ZipInputStream zis = new ZipInputStream(
                cl.getResourceAsStream("test_files.zip")
        )) {
            ZipEntry entry;

            while ((entry = zis.getNextEntry()) != null) {
                String fileName = entry.getName();
                System.out.println("Reading: " + fileName);

                if (fileName.endsWith(".pdf")) {
                    PDF pdf = new PDF(zis);
                    Assertions.assertTrue(
                            pdf.text.contains("Sample PDF Content"),
                            "PDF does not contain expected content"
                    );
                }
            }
        }
    }
    @Test
    void zipFileParsingAndContentCheckXlsTest() throws Exception {
        try (ZipInputStream zis = new ZipInputStream(
                cl.getResourceAsStream("test_files.zip")
        )) {
            ZipEntry entry;

            while ((entry = zis.getNextEntry()) != null) {
                String fileName = entry.getName();
                System.out.println("Reading: " + fileName);

                if (fileName.endsWith(".xlsx")) {
                    XLS xls = new XLS(zis);
                    String actualValue = xls.excel.getSheetAt(0).getRow(0).getCell(0).getStringCellValue();
                    Assertions.assertTrue(actualValue.contains("Sample Excel Data"));
                }
            }
        }
    }
}
