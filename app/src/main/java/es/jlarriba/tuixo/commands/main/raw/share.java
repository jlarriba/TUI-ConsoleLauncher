package es.jlarriba.tuixo.commands.main.raw;

import android.content.Intent;

import java.io.File;

import es.jlarriba.tuixo.R;
import es.jlarriba.tuixo.commands.CommandAbstraction;
import es.jlarriba.tuixo.commands.ExecutePack;
import es.jlarriba.tuixo.commands.main.MainPack;
import es.jlarriba.tuixo.tuils.Tuils;

public class share implements CommandAbstraction {

    @Override
    public String exec(ExecutePack pack) {
        MainPack info = (MainPack) pack;
        File f = info.get(File.class);
        if (f.isDirectory())
            return info.res.getString(R.string.output_isdirectory);

        Intent sharingIntent = Tuils.shareFile(pack.context, f);
        info.context.startActivity(Intent.createChooser(sharingIntent, info.res.getString(R.string.share_label)));

        return Tuils.EMPTYSTRING;
    }

    @Override
    public int helpRes() {
        return R.string.help_share;
    }

    @Override
    public int[] argType() {
        return new int[]{CommandAbstraction.FILE};
    }

    @Override
    public int priority() {
        return 3;
    }

    @Override
    public String onNotArgEnough(ExecutePack pack, int nArgs) {
        MainPack info = (MainPack) pack;
        return info.res.getString(helpRes());
    }

    @Override
    public String onArgNotFound(ExecutePack pack, int index) {
        MainPack info = (MainPack) pack;
        return info.res.getString(R.string.output_filenotfound);
    }

}
