package es.jlarriba.tuixo.managers.xml.classes;

/**
 * Created by francescoandreuzzi on 06/03/2018.
 */

public interface XMLPrefsElement {
    XMLPrefsList getValues();
    void write(XMLPrefsSave save, String value);
    String[] delete();
    String path();
}