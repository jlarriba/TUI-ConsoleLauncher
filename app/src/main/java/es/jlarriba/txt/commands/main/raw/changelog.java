package es.jlarriba.txt.commands.main.raw;

import es.jlarriba.txt.R;
import es.jlarriba.txt.commands.CommandAbstraction;
import es.jlarriba.txt.commands.ExecutePack;
import es.jlarriba.txt.commands.main.MainPack;
import es.jlarriba.txt.managers.ChangelogManager;

/**
 * Created by francescoandreuzzi on 26/03/2018.
 */

public class changelog implements CommandAbstraction {

    @Override
    public String exec(ExecutePack pack) throws Exception {
        ChangelogManager.printLog(pack.context, ((MainPack) pack).client, true);
        return null;
    }

    @Override
    public int[] argType() {
        return new int[0];
    }

    @Override
    public int priority() {
        return 2;
    }

    @Override
    public int helpRes() {
        return R.string.help_changelog;
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
