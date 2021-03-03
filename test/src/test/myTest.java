package test;

import com.HaiTaiHisba1Info;
import com.HaiTaiHisba2Info;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class myTest{

    public static void main(String[] args) throws JAXBException {
        Customer customer = new Customer();
        customer.setFirstName("Jane");
        customer.setMiddleName("");
        customer.setLastName("null");

        JAXBContext jc = JAXBContext.newInstance(Customer.class);
        Marshaller marshaller = jc.createMarshaller();
        MarshallerListener marlistener=new MarshallerListener();
        marshaller.setListener(marlistener);
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        // Output XML
        marshaller.marshal(customer, System.out);
    }
}
