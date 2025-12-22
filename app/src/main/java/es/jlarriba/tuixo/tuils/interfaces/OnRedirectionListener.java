package es.jlarriba.tuixo.tuils.interfaces;

import es.jlarriba.tuixo.commands.main.specific.RedirectCommand;

/**
 * Created by francescoandreuzzi on 03/03/2017.
 */

public interface OnRedirectionListener {

    void onRedirectionRequest(RedirectCommand cmd);
    void onRedirectionEnd(RedirectCommand cmd);
}
