import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import org.w3c.dom.Document;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import java.io.File;

public class XSDValidation {
    public static void main(String[] args) {
        try {

            SchemaFactory schemaFactory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
            Schema schema = schemaFactory.newSchema(new File("bookstore.xsd"));


            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setNamespaceAware(true);
            factory.setSchema(schema);

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

            
            Document doc = builder.parse(new File("bookstore_xsd.xml"));
            System.out.println("XSD Validation successful!");
        } catch (Exception e) {
            System.out.println("XSD Validation failed: " + e.getMessage());
        }
    }
}
