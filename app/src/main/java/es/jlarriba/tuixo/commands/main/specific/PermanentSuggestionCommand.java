package es.jlarriba.tuixo.commands.main.specific;

import es.jlarriba.tuixo.commands.CommandAbstraction;

/**
 * Created by francescoandreuzzi on 29/01/2017.
 */

public abstract class PermanentSuggestionCommand implements CommandAbstraction {

    public abstract String[] permanentSuggestions();
}
