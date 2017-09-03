package ink.akto.converter.currency.core;

import ink.akto.converter.currency.core.CoreContracts.ICoreLibVersion;

/**
 * Created by Ruben on 31.08.2017.
 */
public class CoreLibVersion implements ICoreLibVersion
{
    private String ver;

    @Override
    public String getVersion() {
        return "1.1";
    }
}
