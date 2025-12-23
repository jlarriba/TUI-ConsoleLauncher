package es.jlarriba.txt.commands.txtxt;

import android.content.Context;
import android.content.res.Resources;
import android.widget.EditText;

import java.io.File;

import es.jlarriba.txt.commands.CommandGroup;
import es.jlarriba.txt.commands.ExecutePack;

/**
 * Created by francescoandreuzzi on 25/01/2017.
 */

public class TxtxtPack extends ExecutePack {

    public File editFile;
    public EditText editText;

    public Resources resources;

    public TxtxtPack(CommandGroup group, File file, Context context, EditText editText) {
        super(group);

        this.editText = editText;
        editFile = file;
        this.context = context;
        this.resources = context.getResources();
    }
}
