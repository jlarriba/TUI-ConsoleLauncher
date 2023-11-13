package es.jlarriba.tuixo.tuils.libsuperuser;

import android.content.Context;

import java.io.File;
import java.util.regex.Pattern;

import es.jlarriba.tuixo.managers.TerminalManager;
import es.jlarriba.tuixo.managers.xml.XMLPrefsManager;
import es.jlarriba.tuixo.managers.xml.options.Behavior;
import es.jlarriba.tuixo.tuils.Tuils;

/**
 * Created by francescoandreuzzi on 18/08/2017.
 */

public class ShellHolder {

    private Context context;

    public ShellHolder(Context context) {
        this.context = context;
    }

    Pattern p = Pattern.compile("^\\n");

    public Shell.Interactive build() {
        Shell.Interactive interactive = new Shell.Builder()
                .setOnSTDOUTLineListener(line -> {
                    line = p.matcher(line).replaceAll(Tuils.EMPTYSTRING);
                    Tuils.sendOutput(context, line, TerminalManager.CATEGORY_OUTPUT);
                })
                .setOnSTDERRLineListener(line -> {
                    line = p.matcher(line).replaceAll(Tuils.EMPTYSTRING);
                    Tuils.sendOutput(context, line, TerminalManager.CATEGORY_OUTPUT);
                })
                .open();
        interactive.addCommand("cd " + XMLPrefsManager.get(File.class, Behavior.home_path));
        return interactive;
    }
}
