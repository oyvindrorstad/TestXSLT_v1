import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;

public class XSLTransformerExample {
    public static void main(String[] args) {
        try {
            File stylesheet = new File("D://employees.xsl");
            File xmlfile = new File("D://employees.xml");
            StreamSource stylesource = new StreamSource(stylesheet);
            StreamSource xmlsource = new StreamSource(xmlfile);
            Transformer transformer = TransformerFactory.newInstance()
                    .newTransformer(stylesource);

            // Transform the document and store it in a file
            transformer.transform(xmlsource, new StreamResult(new File("D://employees.html")));

            StreamResult consoleOut = new StreamResult(System.out);
            // Transform the document and print the content to console
            transformer.transform(xmlsource, consoleOut);
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
}
