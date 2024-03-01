package Collection;

import enum_.Color;
import enum_.TicketType;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;

/**
 * Класс работы с xml файлом
 * @author Захарченко Роман
 */
public class XmlManager {
    /**
     * @return Метод возвращает HashSet коллекцию состоящую из элементов ticket распаршенную из xml файла.
     * @throws Exception
     */
    public static HashSet<Ticket> myParser() throws Exception {
        File f = new File(System.getenv("PWD") + "/base.xml");
        //File f = new File(System.getenv("RBASE") + "/base.xml");
        HashSet<Ticket> notebook = new HashSet<>();
        if(!f.exists() || f.isDirectory()) {
            System.out.println("File not exists or it is directory! We create new file on this way.");
            return notebook;
        }
        if(!f.canRead() || !f.canWrite()){
            System.out.println("Loading error! The file is not readable or writable. Collection is empty.");
            return notebook;
        }
        if (f.length() == 0) return notebook;

        BufferedInputStream xmlFileBuf = new BufferedInputStream(new FileInputStream(f));

        // Create a DocumentBuilder
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        // Parse the XML file
        Document document = null;
        try {
            document = builder.parse(xmlFileBuf);
        } catch (SAXException | IOException e) {
            System.out.println("Error!! The file does not have an XML file structure! You are given an empty collection to work with. If you want to use a collection from a file, check its integrity!");
            return notebook;
        }
        NodeList nodeList = document.getElementsByTagName("ticket");
        boolean[] check = new boolean[15];
        boolean flagPers = false;
        for (int i = 0; i < check.length; i++) {
            check[i] = false;
        }
        for (int i = 0; i < nodeList.getLength(); i++) {
            Ticket ticket = new Ticket();
            Node node = nodeList.item(i);
            NodeList chNode = node.getChildNodes();
            for (int j = 0; j < chNode.getLength(); j++) {
                flagPers = false;
                Node element = chNode.item(j);
                if (element.getNodeName().equals("id")){
                    check[0] = true;
                    ticket.setId(Long.valueOf(element.getTextContent()));
                }else if (element.getNodeName().equals("name")){
                    check[1] = true;
                    ticket.setName(element.getTextContent());
                }else if (element.getNodeName().equals("coordinates")){
                    NodeList chElment = element.getChildNodes();
                    Coordinates coordinates = new Coordinates();
                    for (int k = 0; k < chElment.getLength(); k++) {
                        Node coordElement = chElment.item(k);
                        if (coordElement.getNodeName().equals("x")) {
                            check[2] = true;
                            coordinates.setX(Float.parseFloat(coordElement.getTextContent()));
                        }
                        else if (coordElement.getNodeName().equals("y")) {
                            check[3] = true;
                            coordinates.setY(Double.parseDouble(coordElement.getTextContent()));
                        }
                        else System.out.println("Extra data found in XML file");
                    }
                    ticket.setCoordinates(coordinates);
                }else if (element.getNodeName().equals("creationDate")){
                    check[4] = true;
                    ticket.setCreationDate(ZonedDateTime.parse(element.getTextContent()));
                }else if (element.getNodeName().equals("price")){
                    check[5] = true;
                    ticket.setPrice(Double.parseDouble(element.getTextContent()));
                }else if(element.getNodeName().equals("comment")){
                    check[6] = true;
                    ticket.setComment(element.getTextContent());
                }else if(element.getNodeName().equals("refundable")){
                    check[7] = true;
                    ticket.setRefundable(Boolean.parseBoolean(element.getTextContent()));
                }else if(element.getNodeName().equals("type")){
                    check[8] = true;
                    ticket.setType(TicketType.valueOf(element.getTextContent()));
                }else if(element.getNodeName().equals("person")){
                    if (!element.getTextContent().equals("")){
                        flagPers = true;
                        NodeList chElment = element.getChildNodes();
                        Person person = new Person();
                        for (int k = 0; k < chElment.getLength(); k++) {
                            DateFormat df = new SimpleDateFormat("EEE MMM d HH:mm:ss zzz yyyy", Locale.ENGLISH);
                            Node persElement = chElment.item(k);
                            if (persElement.getNodeName().equals("birthday")) {
                                check[9] = true;
                                person.setBirthday(df.parse(persElement.getTextContent()));
                            }else if (persElement.getNodeName().equals("hairColor")) {
                                check[10] = true;
                                person.setHairColor(Color.valueOf(persElement.getTextContent()));
                            }else if (persElement.getNodeName().equals("location")) {
                                NodeList perChElement = persElement.getChildNodes();
                                Location location = new Location();
                                for (int l = 0; l < perChElement.getLength(); l++) {
                                    Node locElement = perChElement.item(l);
                                    if (locElement.getNodeName().equals("x")) {
                                        check[11] = true;
                                        location.setX(Double.parseDouble(locElement.getTextContent()));
                                    }
                                    else if (locElement.getNodeName().equals("y")) {
                                        check[12] = true;
                                        location.setY(Long.parseLong(locElement.getTextContent()));
                                    }
                                    else if (locElement.getNodeName().equals("z")) {
                                        check[13] = true;
                                        location.setZ(Float.parseFloat(locElement.getTextContent()));
                                    }
                                    else if (locElement.getNodeName().equals("name")) {
                                        check[14] = true;
                                        location.setName(locElement.getTextContent());
                                    }
                                    else System.out.println("Extra data found in XML file");
                                    person.setLocation(location);
                                }
                            }else System.out.println("Extra data found in XML file");
                        }
                        ticket.setPerson(person);
                    }
                }else System.out.println("Extra data found in XML file");
            }
            for (int r = 0; r < check.length-6; r++) {
                if (!check[r]){
                    System.out.println("Some data was lost somewhere and the download failed. Check the integrity of the file.");
                    return notebook;
                }
            }
            if (flagPers) {
                for (int r = check.length-6; r < check.length; r++) {
                    if (!check[r]) {
                        System.out.println("Some data was lost somewhere and the download failed. Check the integrity of the file.");
                        return notebook;
                    }
                }
            }
            notebook.add(ticket);
        }

        xmlFileBuf.close();
        return notebook;
    }

    /**
     * Метод сохраняющий коллекцию в файл base.xml
     * @param notebook коллекция которую надо сохранить в файл base.xml
     * @throws Exception
     */
    public static void saveCollection(HashSet<Ticket> notebook) throws Exception{

        BufferedOutputStream bfile = new BufferedOutputStream(new FileOutputStream(System.getenv("PWD") + "/base.xml"));
        //BufferedOutputStream bfile = new BufferedOutputStream(new FileOutputStream(System.getenv("RBASE") + "/base.xml"));
        StringBuilder xmlText = new StringBuilder();
        Iterator<Ticket> i = notebook.iterator();
        xmlText.append("<notebook>");
        while (i.hasNext()) {
            Ticket tmp = i.next();
            xmlText.append("<ticket>");
            xmlText.append("<id>").append(tmp.getId()).append("</id>");
            xmlText.append("<name>").append(tmp.getName()).append("</name>");
            xmlText.append("<coordinates>");
            xmlText.append("<x>").append(tmp.getCoordinates().getX()).append("</x>");
            xmlText.append("<y>").append(tmp.getCoordinates().getY()).append("</y>");
            xmlText.append("</coordinates>");
            xmlText.append("<creationDate>").append(tmp.getCreationDate()).append("</creationDate>");
            xmlText.append("<price>").append(tmp.getPrice()).append("</price>");
            xmlText.append("<comment>").append(tmp.getComment()).append("</comment>");
            xmlText.append("<refundable>").append(tmp.getRefundable()).append("</refundable>");
            xmlText.append("<type>").append(tmp.getType().toString()).append("</type>");
            xmlText.append("<person>");
            if (tmp.getPerson() != null) {
                xmlText.append("<birthday>").append(tmp.getPerson().getBirthday()).append("</birthday>");
                xmlText.append("<hairColor>").append(tmp.getPerson().getHairColor().toString()).append("</hairColor>");
                xmlText.append("<location>");
                xmlText.append("<x>").append(tmp.getPerson().getLocation().getX()).append("</x>");
                xmlText.append("<y>").append(tmp.getPerson().getLocation().getY()).append("</y>");
                xmlText.append("<z>").append(tmp.getPerson().getLocation().getZ()).append("</z>");
                xmlText.append("<name>").append(tmp.getPerson().getLocation().getName()).append("</name>");
                xmlText.append("</location>");
            }
            xmlText.append("</person>");
            xmlText.append("</ticket>");
        }
        xmlText.append("</notebook>");
        byte[] buffer = xmlText.toString().getBytes();
        bfile.write(buffer);
        bfile.flush();
        bfile.close();
    }
}
