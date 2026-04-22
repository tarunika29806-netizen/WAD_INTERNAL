import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import java.io.File;

public class DTDValidation {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setValidating(true);
            factory.setNamespaceAware(true);

            DocumentBuilder builder = factory.newDocumentBuilder();


            builder.setErrorHandler(new ErrorHandler() {
                @Override
                public void warning(SAXParseException e) throws SAXException {
                    throw e;
                }
                @Override
                public void error(SAXParseException e) throws SAXException {
                    throw e;
                }
                @Override
                public void fatalError(SAXParseException e) throws SAXException {
                    throw e;
                }
            });

            Document doc = builder.parse(new File("bookstore.xml"));
            System.out.println("DTD Validation successful!");
        } catch (Exception e) {
            System.out.println("DTD Validation failed: " + e.getMessage());
        }
    }
}
