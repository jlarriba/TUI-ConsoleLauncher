package es.jlarriba.tuixo.managers.xml.options;

import es.jlarriba.tuixo.managers.xml.XMLPrefsManager;
import es.jlarriba.tuixo.managers.xml.classes.XMLPrefsElement;
import es.jlarriba.tuixo.managers.xml.classes.XMLPrefsSave;

/**
 * Created by francescoandreuzzi on 24/09/2017.
 */

public enum Cmd implements XMLPrefsSave {

    default_search {
        @Override
        public String defaultValue() {
            return "-gg";
        }

        @Override
        public String info() {
            return "The param that will be used if you type \"search apples\" instead of \"search -param apples\"";
        }

        @Override
        public String type() {
            return XMLPrefsSave.TEXT;
        }
    };

    @Override
    public XMLPrefsElement parent() {
        return XMLPrefsManager.XMLPrefsRoot.CMD;
    }

    @Override
    public String label() {
        return name();
    }

    @Override
    public String[] invalidValues() {
        return null;
    }

    @Override
    public String getLowercaseString() {
        return label();
    }

    @Override
    public String getString() {
        return label();
    }
}
