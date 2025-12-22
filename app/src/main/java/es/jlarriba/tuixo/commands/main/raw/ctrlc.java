package es.jlarriba.tuixo.commands.main.raw;

import android.content.Intent;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import java.io.File;

import es.jlarriba.tuixo.MainManager;
import es.jlarriba.tuixo.R;
import es.jlarriba.tuixo.UIManager;
import es.jlarriba.tuixo.commands.CommandAbstraction;
import es.jlarriba.tuixo.commands.ExecutePack;
import es.jlarriba.tuixo.commands.main.MainPack;
import es.jlarriba.tuixo.managers.xml.XMLPrefsManager;
import es.jlarriba.tuixo.managers.xml.options.Behavior;
import es.jlarriba.tuixo.tuils.StoppableThread;

/**
 * Created by francescoandreuzzi on 26/07/2017.
 */

public class ctrlc implements CommandAbstraction {

    @Override
    public String exec(final ExecutePack pack) throws Exception {
        new StoppableThread() {
            @Override
            public void run() {
                super.run();

                MainManager.interactive.kill();
                MainManager.interactive.close();
                MainManager.interactive = null;

                MainManager.interactive = ((MainPack) pack).shellHolder.build();

                ((MainPack) pack).currentDirectory = XMLPrefsManager.get(File.class, Behavior.home_path);
                LocalBroadcastManager.getInstance(pack.context.getApplicationContext()).sendBroadcast(new Intent(UIManager.ACTION_UPDATE_HINT));
            }
        }.start();

        LocalBroadcastManager.getInstance(pack.context.getApplicationContext()).sendBroadcast(new Intent(UIManager.ACTION_NOROOT));

        return null;
    }

    @Override
    public int[] argType() {
        return new int[0];
    }

    @Override
    public int priority() {
        return 3;
    }

    @Override
    public int helpRes() {
        return R.string.help_ctrlc;
    }

    @Override
    public String onArgNotFound(ExecutePack pack, int indexNotFound) {
        return null;
    }

    @Override
    public String onNotArgEnough(ExecutePack pack, int nArgs) {
        return null;
    }
}
