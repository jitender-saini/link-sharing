package com.xmlParser;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

class UserHandler extends DefaultHandler {

    boolean bDept = false;
    boolean bCompetency = false;
    boolean bHead = false;
    boolean bEmployee = false;

    @Override
    public void startElement(String uri,String localName, String qName, Attributes attributes)
            throws SAXException {
        if (qName.equalsIgnoreCase("department")) {
            System.out.println("---------------------------");
            String dpt = attributes.getValue("name");
            System.out.println("Department Name : " + dpt);
        } else if (qName.equalsIgnoreCase("competency")) {
            System.out.println("******************************");
            String cmpt = attributes.getValue("name");
            System.out.println("Competency Name : " + cmpt);
        } else if (qName.equalsIgnoreCase("head")) {
            bHead = true;
        } else if (qName.equalsIgnoreCase("employees")) {
            bEmployee = true;
        }
    }

    @Override
    public void characters(char ch[], int start, int length) throws SAXException {
        if (bHead) {
            System.out.println("Head: "+ new String(ch, start, length));
            bHead = false;
        } else if (bEmployee) {
            System.out.println("Employees: "+ new String(ch, start, length));
            bEmployee = false;
        }
    }
}