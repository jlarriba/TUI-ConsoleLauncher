package es.jlarriba.tuixo.commands.tuixt.raw;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import es.jlarriba.tuixo.R;
import es.jlarriba.tuixo.commands.CommandAbstraction;
import es.jlarriba.tuixo.commands.ExecutePack;
import es.jlarriba.tuixo.commands.tuixt.TuixtPack;
import es.jlarriba.tuixo.tuils.Tuils;

/**
 * Created by francescoandreuzzi on 24/01/2017.
 */

public class help implements CommandAbstraction {

    @Override
    public String exec(ExecutePack info) throws Exception {
        TuixtPack pack = (TuixtPack) info;

        CommandAbstraction cmd = info.get(CommandAbstraction.class);
        int res = cmd == null ? R.string.output_commandnotfound : cmd.helpRes();
        return pack.resources.getString(res);
    }

    @Override
    public int[] argType() {
        return new int[] {CommandAbstraction.COMMAND};
    }

    @Override
    public int priority() {
        return 5;
    }

    @Override
    public int helpRes() {
        return R.string.help_tuixt_help;
    }

    @Override
    public String onArgNotFound(ExecutePack info, int index) {
        return onNotArgEnough(info, 0);
    }

    @Override
    public String onNotArgEnough(ExecutePack pack, int nArgs) {
        TuixtPack info = (TuixtPack) pack;
        List<String> toPrint = new ArrayList<>(Arrays.asList(info.commandGroup.getCommandNames()));

        Collections.sort(toPrint, Tuils::alphabeticCompare);

        Tuils.addPrefix(toPrint, Tuils.DOUBLE_SPACE);
        Tuils.addSeparator(toPrint, Tuils.TRIBLE_SPACE);
        Tuils.insertHeaders(toPrint, true);

        return Tuils.toPlanString(toPrint, Tuils.EMPTYSTRING);
    }
}
