package comg.github.technus.iarWiggler.xml;

import comg.github.technus.iarWiggler.xml.bindings.Project;
import lombok.SneakyThrows;
import lombok.val;

import javax.xml.bind.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

@SuppressWarnings("unchecked")
public class UtilXML {
    @SneakyThrows
    public static <T> T unmarshallString(String xml, Class<T> clazz) {
        return unmarshallStream(new ByteArrayInputStream(xml.getBytes(StandardCharsets.UTF_8)), clazz);
    }

    @SneakyThrows
    public static <T> T unmarshallFile(Path xml, Class<T> clazz) {
        return unmarshallStream(Files.newInputStream(xml), clazz);
    }

    @SneakyThrows
    public static <T> T unmarshallStream(InputStream xml, Class<T> clazz) {
        JAXBContext context = JAXBContext.newInstance(clazz);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        return (T) unmarshaller.unmarshal(xml);
    }

    public static <T> void marshallToStream(OutputStream outputStream,T obj) {
        marshallToStream(outputStream,obj, (Class<T>) obj.getClass());
    }

    @SneakyThrows
    public static <T> void marshallToStream(OutputStream outputStream,T obj, Class<T> clazz) {
        JAXBContext context = JAXBContext.newInstance(clazz);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        if (!clazz.isAnnotationPresent(XmlRootElement.class)) {
            JAXBElement<T> jaxbElement = new JAXBElement<T>(
                    new QName("", clazz.getAnnotation(XmlType.class).name()),
                    clazz,
                    obj);
            marshaller.marshal(jaxbElement, outputStream);
        } else {
            marshaller.marshal(obj, outputStream);
        }
    }

    public static <T> String marshallToString(T obj) {
        return marshallToString(obj, (Class<T>) obj.getClass());
    }

    public static <T> String marshallToString(T obj, Class<T> clazz) {
        ByteArrayOutputStream output=new ByteArrayOutputStream();
        marshallToStream(output,obj, clazz);
        return new String(output.toByteArray(),StandardCharsets.UTF_8);
    }

    public static <T> void marshallToFile(Path path, T obj) {
        marshallToFile(path,obj,(Class<T>)obj.getClass());
    }

    @SneakyThrows
    public static <T> void marshallToFile(Path path, T obj, Class<T> clazz) {
        OutputStream output = Files.newOutputStream(path);
        marshallToStream(output,obj, clazz);
    }
}
