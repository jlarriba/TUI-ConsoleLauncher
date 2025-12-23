package es.jlarriba.txt.commands.main.raw;

import android.app.Activity;
import android.content.Intent;

import java.io.File;
import java.io.IOException;

import es.jlarriba.txt.LauncherActivity;
import es.jlarriba.txt.R;
import es.jlarriba.txt.commands.txtxt.TxtxtActivity;
import es.jlarriba.txt.commands.CommandAbstraction;
import es.jlarriba.txt.commands.ExecutePack;
import es.jlarriba.txt.commands.main.MainPack;
import es.jlarriba.txt.managers.FileManager;
import es.jlarriba.txt.tuils.Tuils;

/**
 * Created by francescoandreuzzi on 18/01/2017.
 */

public class txtxt implements CommandAbstraction {

    @Override
    public String exec(ExecutePack pack) {
        MainPack info = (MainPack) pack;
        File file = info.get(File.class);
        if(file.isDirectory()) {
            return info.res.getString(R.string.output_isdirectory);
        }

        Intent intent = new Intent(info.context, TxtxtActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra(TxtxtActivity.PATH, file.getAbsolutePath());
        ((Activity) info.context).startActivityForResult(intent, LauncherActivity.TXTXT_REQUEST);

        return Tuils.EMPTYSTRING;
    }

    @Override
    public int[] argType() {
        return new int[] {CommandAbstraction.FILE};
    }

    @Override
    public int priority() {
        return 3;
    }

    @Override
    public int helpRes() {
        return R.string.help_txtxt;
    }

    @Override
    public String onArgNotFound(ExecutePack pack, int index) {
        MainPack info = (MainPack) pack;

        String path = info.getString();
        if(path == null || path.length() == 0) {
            return onNotArgEnough(info, info.args.length);
        }

        FileManager.DirInfo dirInfo = FileManager.cd(info.currentDirectory, path);

        File file = new File(dirInfo.getCompletePath());
        if(!file.getParentFile().exists() && !file.getParentFile().mkdirs()) {
            return info.res.getString(R.string.output_error);
        }

        try {
            file.createNewFile();
        } catch (IOException e) {
            return e.toString();
        }

        Intent intent = new Intent(info.context, TxtxtActivity.class);
        intent.putExtra(TxtxtActivity.PATH, file.getAbsolutePath());
        ((Activity) info.context).startActivityForResult(intent, LauncherActivity.TXTXT_REQUEST);

        return Tuils.EMPTYSTRING;
    }

    @Override
    public String onNotArgEnough(ExecutePack pack, int nArgs) {
        MainPack info = (MainPack) pack;
        return info.res.getString(R.string.help_txtxt);
    }
}
