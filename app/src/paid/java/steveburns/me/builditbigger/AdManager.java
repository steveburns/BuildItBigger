package steveburns.me.builditbigger;

import android.content.Context;
import android.view.View;

/**
 * Created by sburns on 12/12/15.
 */
public class AdManager {

    AdInterface mAdInterface;

    /**
     * constructor.
     * @param context - context
     * @param view - view
     * @param adInterfaceClass - interface back to caller
     */
    public AdManager(final Context context, final View view, final AdInterface adInterfaceClass) {

        mAdInterface = adInterfaceClass;
    }

    /**
     * showAd
     */
    public void showAd() {

        // nothing to do but say we're done!
        if (mAdInterface != null) {
            mAdInterface.notifyFinished();
        }
    }
}
